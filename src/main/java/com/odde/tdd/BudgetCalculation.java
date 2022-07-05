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
        YearMonth cursorMonth = startMonth;
        for (int i = 0; !cursorMonth.isAfter(endMonth); ++i) {
            cursorMonth = startMonth.plusMonths(i);
            Budget budget = budgetMap.get(cursorMonth);
            if(budget == null) {
                System.out.println("WARNING: No budget for "+ cursorMonth + " so that there is no budget for this month");
                continue;
            }
            if (!cursorMonth.isAfter(endMonth)) {
                totalBudget += calculateOneMonth(budget, cursorMonth.equals(startMonth) ? startDay : 1, cursorMonth.equals(endMonth) ? endDay : budget.getMonth().lengthOfMonth());
            }
        }
        return totalBudget;
    }
}
