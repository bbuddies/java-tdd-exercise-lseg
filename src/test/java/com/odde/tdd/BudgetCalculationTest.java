package com.odde.tdd;

import org.junit.Test;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BudgetCalculationTest {
    private BudgetRepo repo = mock(BudgetRepo.class);
    private BudgetCalculation budgetCalculation = new BudgetCalculation(repo);;

    @Test
    public void calculate_one_day_normal_month() {
        givenBudgets(budget(2018, 11, 300));
        assertAmount(10, "2018-11-02", "2018-11-02");
    }

    @Test
    public void calculate_one_day_leap_month() {
        givenBudgets(budget(2018, 10, 310));
        assertAmount(10, "2018-10-02", "2018-10-02");
    }

    @Test
    public void calculate_one_month() {
        givenBudgets(budget(2018, 10, 310));
        assertAmount(310, "2018-10-01", "2018-10-31");
    }

    @Test
    public void calculate_two_days_normal_month() {
        givenBudgets(budget(2018, 11, 300));
        assertAmount(20, "2018-11-02", "2018-11-03");
    }

    @Test
    public void calculate_two_months() {
        givenBudgets(
                budget(2018, 11, 300)
                , budget(2018, 12, 310)
        );
        assertAmount(50, "2018-11-29", "2018-12-03");
    }

    @Test
    public void calculate_two_years() {
        givenBudgets(
                budget(2018, 11, 300)
                , budget(2018, 12, 310)
                , budget(2019, 1, 310)
        );
        assertAmount(360, "2018-11-29", "2019-01-03");
    }

    @Test
    public void calculate_two_years_missing_one_month_and_disorder() {
        givenBudgets(
                budget(2019, 1, 310)
                , budget(2018, 10, 310)
        );
        assertAmount(340, "2018-09-29", "2019-01-03");
    }

    @Test
    public void query_start_before_budget() {
       givenBudgets(budget(2018, 11, 300));
       assertAmount(40, "2018-10-21", "2018-11-04");
    }

    @Test
    public void query_end_after_budget() {
        givenBudgets(budget(2018, 11, 300));
        assertAmount(100, "2018-11-21", "2018-12-04");
    }

    @Test
    public void query_out_of_budget() {
        givenBudgets(budget(2018, 11, 300));
        assertAmount(0, "2018-12-21", "2019-12-04");
    }

    @Test
    public void start_after_end() {
        givenBudgets(budget(2018, 11, 300));
        assertAmount(0, "2019-12-21", "2018-12-04");
    }

    private void givenBudgets(Budget... value) {
        when(repo.findAll()).thenReturn(Arrays.asList(value));
    }


    private void assertAmount(int expected, String start, String end) {
        assertEquals(expected, budgetCalculation.calculate(LocalDate.parse(start), LocalDate.parse(end)));
    }

    private Budget budget(int year, int month, int amount) {
        return new Budget(YearMonth.of(year, month), amount);
    }
}