package com.odde.tdd;

import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.util.List;

public class CalBudgetAmout {
  private List<Budget> budgetList;
  private BudgetRepo budgetRepo = new BudgetRepoImpl();

  CalBudgetAmout() {
    budgetList = budgetRepo.findAll();
  }

  int CalBudgetAmount(LocalDate begin, LocalDate end) {
    begin.atDay()
    return 0;
  }

}
