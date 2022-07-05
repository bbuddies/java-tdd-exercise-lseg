package com.odde.tdd;

import java.time.LocalDate;
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

    public long calculate(Period period) {
        long totalBudget = 0;
        YearMonth startMonth = period.getStartMonth();
        YearMonth endMonth = period.getEndMonth();
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
                totalBudget += budget.getOverlappingAmount(period);
            }
        }
        return totalBudget;
    }

}
