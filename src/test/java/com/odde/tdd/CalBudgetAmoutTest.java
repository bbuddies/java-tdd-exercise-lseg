package com.odde.tdd;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class CalBudgetAmoutTest {

  private CalBudgetAmout calBudgetAmoutUnderTest;

  @Before
  public void setUp() {
    calBudgetAmoutUnderTest = new CalBudgetAmout();
  }

  @Test
  public void testCalBudgetAmount() {
    List<Budget> budgetList = Arrays.asList(new Budget(YearMonth.of(2020, 5), 3100),
                                            new Budget(YearMonth.of(2020, 6), 300),
                                            new Budget(YearMonth.of(2020, 7), 310));
    calBudgetAmoutUnderTest.setBudgetList(budgetList);
    assertEquals(0, calBudgetAmoutUnderTest.CalBudgetAmount(LocalDate.of(2020, 5, 1),
        LocalDate.of(2020, 4, 1)));
    assertEquals(100, calBudgetAmoutUnderTest.CalBudgetAmount(LocalDate.of(2020, 5, 1),
        LocalDate.of(2020, 5, 1)));
    assertEquals(500, calBudgetAmoutUnderTest.CalBudgetAmount(LocalDate.of(2020, 5, 1),
        LocalDate.of(2020, 5, 5)));
    assertEquals(3110, calBudgetAmoutUnderTest.CalBudgetAmount(LocalDate.of(2020, 5, 1),
        LocalDate.of(2020, 6, 1)));
    assertEquals(3110, calBudgetAmoutUnderTest.CalBudgetAmount(LocalDate.of(2020, 4, 3),
        LocalDate.of(2020, 6, 1)));
    assertEquals(3410, calBudgetAmoutUnderTest.CalBudgetAmount(LocalDate.of(2020, 4, 3),
        LocalDate.of(2020, 7, 1)));
    assertEquals(3710, calBudgetAmoutUnderTest.CalBudgetAmount(LocalDate.of(2020, 4, 3),
        LocalDate.of(2020, 8, 5)));
    assertEquals(440, calBudgetAmoutUnderTest.CalBudgetAmount(LocalDate.of(2020, 5, 31),
        LocalDate.of(2020, 7, 4)));
  }
}
