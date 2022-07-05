package com.odde.tdd;

public class BudgetCalculation {

    private final BudgetRepo budgetRepo;

    public BudgetCalculation(BudgetRepo budgetRepo) {
        this.budgetRepo = budgetRepo;
    }

    public long calculate(Period period) {
        return budgetRepo.findAll().stream().mapToLong(budget -> budget.getOverlappingAmount(period)).sum();
    }

}
