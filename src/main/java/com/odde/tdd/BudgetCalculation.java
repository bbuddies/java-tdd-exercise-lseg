package com.odde.tdd;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BudgetCalculation {

    private final BudgetRepo budgetRepo;

    public BudgetCalculation(BudgetRepo budgetRepo) {
        this.budgetRepo = budgetRepo;
    }

    private long calculateOneMonth(Budget budget, int startDay, int endDay) {
        int totalDays = endDay - startDay + 1;
        int monthDays = budget.getMonth().lengthOfMonth();
        if (totalDays == monthDays) {
            return budget.getAmount();
        }
        return totalDays * budget.getAmount() / monthDays;
    }

    public long calculate(LocalDate startTime, LocalDate endTime) {
        long totalBudget = 0;
        YearMonth startMonth = YearMonth.of(startTime.getYear(), startTime.getMonth());
        YearMonth endMonth = YearMonth.of(endTime.getYear(), endTime.getMonth());
        int startDay = startTime.getDayOfMonth();
        int endDay = endTime.getDayOfMonth();
        List<Budget> budgetList = budgetRepo.findAll();
        Map<YearMonth, Budget> budgetMap = budgetList.stream().collect(Collectors.toMap(Budget::getMonth, Function.identity()));
        for (int i = 0; !startMonth.isAfter(endMonth); ++i) {
            if (i > 0) {
                startTime = startTime.plus(1, ChronoUnit.MONTHS);
                startMonth = YearMonth.of(startTime.getYear(), startTime.getMonth());
            }
            Budget budget = budgetMap.get(startMonth);
            if(budget == null) {
                startDay = 1;
                System.out.println("WARNING: No budget for "+ startMonth + " so that there is no budget for this month");
                continue;
            }
            if (startMonth.isBefore(endMonth)) {
                totalBudget += calculateOneMonth(budget, startDay, budget.getMonth().lengthOfMonth());
                startDay = 1;
            } else if (startMonth.equals(endMonth)) {
                totalBudget += calculateOneMonth(budget, startDay, endDay);
                break;
            }
        }
        return totalBudget;
    }
}
