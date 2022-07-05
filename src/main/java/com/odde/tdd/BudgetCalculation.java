package com.odde.tdd;

import java.time.YearMonth;
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
        return totalDays * budget.getAmount() / monthDays;
    }

    public long calculate(Period period) {
        long totalBudget = 0;
        YearMonth startMonth = period.getStartMonth();
        YearMonth endMonth = period.getEndMonth();
        int startDay = period.getStartDay();
        int endDay = period.getEndDay();
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
