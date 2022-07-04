package com.odde.tdd;

import static java.time.temporal.ChronoUnit.DAYS;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CalBudgetAmout {

  private List<Budget> budgetList;
  private BudgetRepo budgetRepo;

  public CalBudgetAmout(BudgetRepo budgetRepo) {
    this.budgetList = budgetRepo.findAll();
  }


//  public void setBudgetList(List<Budget> budgetList) {
//    this.budgetList = budgetList;
//  }


  long CalBudgetAmount(LocalDate begin, LocalDate end) {
    long amount = 0;
    if (end.isBefore(begin)) {
      return amount;
    }

    Map<YearMonth, Long> budgetMap = budgetList.stream().collect(
        Collectors.toMap(Budget::getMonth, Budget::getAmount));
    budgetMap.replaceAll((k, v) -> v / k.lengthOfMonth());

    LocalDate date = begin;
    while (!date.isAfter(end)) {
      if(!Objects.isNull(budgetMap.get(YearMonth.from(date)))) {
        if ((date.getYear() == end.getYear()) && (date.getMonth() == end.getMonth())) {
          //same month
          long daysBetween = DAYS.between(date, end) + 1;
//          System.out.println("days diff ==" + daysBetween);
          amount += budgetMap.get(YearMonth.from(date)) * daysBetween;
        } else {
          amount += budgetMap.get(YearMonth.from(date)) * (date.lengthOfMonth() - date.getDayOfMonth() + 1);
        }
      }
      date = date.plusMonths(1);
      date = date.withDayOfMonth(1);
    }

    return amount;
  }
}
