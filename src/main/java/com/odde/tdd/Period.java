package com.odde.tdd;

import java.time.LocalDate;

public class Period {
    private final LocalDate startTime;
    private final LocalDate endTime;

    public Period(LocalDate startTime, LocalDate endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    int getOverlappingDayCount(Period another) {
        LocalDate startDay = startTime.isAfter(another.startTime) ? startTime : another.startTime;
        LocalDate endDay = endTime.isBefore(another.endTime) ? endTime : another.endTime;
        return startDay.isAfter(endDay)? 0 : startDay.until(endDay).getDays() + 1;
    }
}
