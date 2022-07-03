package com.odde.tdd;

import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;

public class BudgetPlan {
  private final BudgetRepo budgetRepo;

  public BudgetPlan(BudgetRepo budgetRepo) {

    this.budgetRepo = budgetRepo;
  }

  public double getBudget(Date from, Date to) {
    if (from.compareTo(to) > 0) {
      return 0;
    }
    YearMonth fromYearMonth = getYearMonth(from);
    YearMonth toYearMonth = getYearMonth(to);
    int fromYear = fromYearMonth.getYear();
    int fromMonth = fromYearMonth.getMonthValue();
    int toYear = toYearMonth.getYear();
    int toMonth = toYearMonth.getMonthValue();
    double amount = 0.0;
    for (int year = fromYear; year <= toYear; year++) {
      for (int i = 1; i <= 12; i++) {
        amount += getMonthlyBudget(YearMonth.of(year, i));
      }
    }
    for (int i = 1; i < fromMonth; i++) {
      amount -= getMonthlyBudget(YearMonth.of(fromYear, i));
    }
    for (int i = toMonth + 1; i <= 12; i++) {
      amount -= getMonthlyBudget(YearMonth.of(toYear, i));
    }
    amount -= getMonthlyBudget(fromYearMonth) / fromYearMonth.lengthOfMonth() * (getDayOfMonth(from) - 1);
    amount -= getMonthlyBudget(toYearMonth) / toYearMonth.lengthOfMonth() * (toYearMonth.lengthOfMonth() - getDayOfMonth(to));
    return amount;
  }

  private double getMonthlyBudget(YearMonth yearMonth) {
    return (double) this.budgetRepo.findAll().stream().filter(budget ->
        budget.getMonth().equals(yearMonth)).findFirst().map(Budget::getAmount).orElse(0L);
  }

  private YearMonth getYearMonth(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    return YearMonth.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1);
  }

  private int getDayOfMonth(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    return calendar.get(Calendar.DAY_OF_MONTH);
  }
}
