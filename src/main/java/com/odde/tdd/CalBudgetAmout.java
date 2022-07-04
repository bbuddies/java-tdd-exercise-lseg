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
  //  private BudgetRepo budgetRepo = new BudgetRepoImpl();
  private BudgetRepo budgetRepo;

  public CalBudgetAmout() {
    budgetRepo = new BudgetRepoImpl();
    budgetList = budgetRepo.findAll();
  }


  public void setBudgetList(List<Budget> budgetList) {
    this.budgetList = budgetList;
  }


  int CalBudgetAmount(LocalDate begin, LocalDate end) {
    int amount = 0;
    if (end.isBefore(begin)) {
      return amount;
    }

//    Map<YearMonth, Integer> budgetMap = budgetList.stream().map(x->x.getMonth(), x->x.getAmount());
    Map<YearMonth, Long> budgetMap = budgetList.stream().collect(
        Collectors.toMap(Budget::getMonth, Budget::getAmount));
//      Collectors.toMap(x -> x.getMonth(), Budget::getAmount/Budget::getMonth));

    budgetMap.replaceAll((k, v) -> v / k.lengthOfMonth());
//    YearMonth beginYM = YearMonth.from(begin);
//    YearMonth endYM = YearMonth.from(end);
//    YearMonth date = beginYM;
    LocalDate date = begin;

    while (!date.isAfter(end)) {
      if(!Objects.isNull(budgetMap.get(YearMonth.from(date)))) {
        if ((date.getYear() == end.getYear()) && (date.getMonth() == end.getMonth())) {
          //same month
          long daysBetween = DAYS.between(date, end) + 1;
          System.out.println("days diff ==" + daysBetween);
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
