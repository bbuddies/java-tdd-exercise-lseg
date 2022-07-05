package com.odde.tdd;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.YearMonth;

public class Budget {
    private final YearMonth month;
    private final long amount;

    public Budget(YearMonth month, long amount) {
        this.month = month;
        this.amount = amount;
    }

    public YearMonth getMonth() {
        return month;
    }

    public long getAmount() {
        return amount;
    }

    LocalDate getStartDate() {
        return month.atDay(1);
    }

    LocalDate getEndDate() {
        return month.atEndOfMonth();
    }

    Period getPeriod() {
        return new Period(getStartDate(), getEndDate());
    }

    long getOverlappingAmount(Period period) {
        int totalDays = period.getOverlappingDayCount(getPeriod());
        int monthDays = getMonth().lengthOfMonth();
        return totalDays * getAmount() / monthDays;
    }
}
