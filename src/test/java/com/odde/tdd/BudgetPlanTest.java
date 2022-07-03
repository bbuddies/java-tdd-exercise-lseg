package com.odde.tdd;

import org.junit.Test;

import java.time.YearMonth;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class BudgetPlanTest {
  MockBudgetRepo budgetRepo = new MockBudgetRepo();
  BudgetPlan target = new BudgetPlan(budgetRepo);
  Calendar calendar = new GregorianCalendar();

  @Test
  public void budge_of_22_01_01() {
    calendar.set(2022, Calendar.JANUARY, 1);
    Date from = calendar.getTime();
    Date to = calendar.getTime();
    double amount = target.getBudget(from, to);
    assertEquals(1.0, amount, 0.0);
  }

  @Test
  public void budge_from_22_01_01_to_22_01_02() {
    calendar.set(2022, Calendar.JANUARY, 1);
    Date from = calendar.getTime();
    calendar.set(2022, Calendar.JANUARY, 3);
    Date to = calendar.getTime();
    double amount = target.getBudget(from, to);
    assertEquals(3.0, amount, 0.0);
  }

  @Test
  public void budge_from_22_01_31_to_22_02_01() {
    calendar.set(2022, Calendar.JANUARY, 31);
    Date from = calendar.getTime();
    calendar.set(2022, Calendar.FEBRUARY, 1);
    Date to = calendar.getTime();
    double amount = target.getBudget(from, to);
    assertEquals(3.0, amount, 0.0);
  }

  @Test
  public void budget_from_22_01_31_to_22_03_01() {
    calendar.set(2022, Calendar.JANUARY, 31);
    Date from = calendar.getTime();
    calendar.set(2022, Calendar.MARCH, 1);
    Date to = calendar.getTime();
    double amount = target.getBudget(from, to);
    assertEquals(60.0, amount, 0.0);
  }

  @Test
  public void budget_from_21_12_31_to_22_02_01() {
    calendar.set(2021, Calendar.DECEMBER, 31);
    Date from = calendar.getTime();
    calendar.set(2022, Calendar.FEBRUARY, 1);
    Date to = calendar.getTime();
    double amount = target.getBudget(from, to);
    assertEquals(34.0, amount, 0.0);
  }

  @Test
  public void budge_from_21_12_31_to_23_01_01() {
    calendar.set(2021, Calendar.DECEMBER, 31);
    Date from = calendar.getTime();
    calendar.set(2023, Calendar.JANUARY, 1);
    Date to = calendar.getTime();
    double amount = target.getBudget(from, to);
    assertEquals(2384.0, amount, 0);
  }

  @Test
  public void budget_from_20_01_01_to_20_12_31() {
    calendar.set(2020, Calendar.JANUARY, 1);
    Date from = calendar.getTime();
    calendar.set(2020, Calendar.DECEMBER, 31);
    Date to = calendar.getTime();
    double amount = target.getBudget(from, to);
    assertEquals(0, amount, 0);
  }

}

class MockBudgetRepo implements BudgetRepo {

  @Override
  public List<Budget> findAll() {
    return Arrays.asList(
        new Budget(YearMonth.of(2021, 12), 31),
        new Budget(YearMonth.of(2022, 1), 31),
        new Budget(YearMonth.of(2022, 2), 56),
        new Budget(YearMonth.of(2022, 3), 93),
        new Budget(YearMonth.of(2022, 4), 120),
        new Budget(YearMonth.of(2022, 5), 155),
        new Budget(YearMonth.of(2022, 6), 180),
        new Budget(YearMonth.of(2022, 7), 217),
        new Budget(YearMonth.of(2022, 8), 248),
        new Budget(YearMonth.of(2022, 9), 270),
        new Budget(YearMonth.of(2022, 10), 310),
        new Budget(YearMonth.of(2022, 11), 330),
        new Budget(YearMonth.of(2022, 12), 372),
        new Budget(YearMonth.of(2023, 1), 31)
    );
  }

}
