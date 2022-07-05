package com.odde.tdd;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.YearMonth;

public class Period {
    private final LocalDate startTime;
    private final LocalDate endTime;

    public Period(LocalDate startTime, LocalDate endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    YearMonth getStartMonth() {
        return YearMonth.from(startTime);
    }

    @NotNull
    YearMonth getEndMonth() {
        return YearMonth.from(endTime);
    }

    int getStartDay() {
        return startTime.getDayOfMonth();
    }

    int getEndDay() {
        return endTime.getDayOfMonth();
    }
}
