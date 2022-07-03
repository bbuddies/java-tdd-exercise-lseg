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
        LocalDate startTime = LocalDate.parse("2018-11-02");
        when(repo.findAll()).thenReturn(Arrays.asList(new Budget(YearMonth.of(2018, 11), 300)));
        assertEquals(10, budgetCalculation.calculate(startTime, startTime));
    }

    @Test
    public void calculate_one_day_leap_month() {
        LocalDate startTime = LocalDate.parse("2018-10-02");
        when(repo.findAll()).thenReturn(Arrays.asList(new Budget(YearMonth.of(2018, 10), 310)));
        assertEquals(10, budgetCalculation.calculate(startTime, startTime));
    }

    @Test
    public void calculate_one_month() {
        LocalDate startTime = LocalDate.parse("2018-10-01");
        LocalDate endTime = LocalDate.parse("2018-10-31");
        when(repo.findAll()).thenReturn(Arrays.asList(new Budget(YearMonth.of(2018, 10), 310)));
        assertEquals(310, budgetCalculation.calculate(startTime, endTime));
    }

    @Test
    public void calculate_two_days_normal_month() {
        LocalDate startTime = LocalDate.parse("2018-11-02");
        LocalDate endTime = LocalDate.parse("2018-11-03");
        when(repo.findAll()).thenReturn(Arrays.asList(new Budget(YearMonth.of(2018, 11), 300)));
        assertEquals(20, budgetCalculation.calculate(startTime, endTime));
    }

    @Test
    public void calculate_two_months() {
        LocalDate startTime = LocalDate.parse("2018-11-29");
        LocalDate endTime = LocalDate.parse("2018-12-03");
        when(repo.findAll()).thenReturn(Arrays.asList(
                new Budget(YearMonth.of(2018, 11), 300)
                , new Budget(YearMonth.of(2018, 12), 310)
                ));
        assertEquals(50, budgetCalculation.calculate(startTime, endTime));
    }

    @Test
    public void calculate_two_years() {
        LocalDate startTime = LocalDate.parse("2018-11-29");
        LocalDate endTime = LocalDate.parse("2019-01-03");
        when(repo.findAll()).thenReturn(Arrays.asList(
                new Budget(YearMonth.of(2018, 11), 300)
                , new Budget(YearMonth.of(2018, 12), 310)
                , new Budget(YearMonth.of(2019, 1), 310)
        ));
        assertEquals(360, budgetCalculation.calculate(startTime, endTime));
    }

    @Test
    public void calculate_two_years_missing_one_month_and_disorder() {
        LocalDate startTime = LocalDate.parse("2018-11-29");
        LocalDate endTime = LocalDate.parse("2019-01-03");
        when(repo.findAll()).thenReturn(Arrays.asList(
                new Budget(YearMonth.of(2019, 1), 310)
                , new Budget(YearMonth.of(2018, 12), 310)
        ));
        assertEquals(340, budgetCalculation.calculate(startTime, endTime));
    }

}