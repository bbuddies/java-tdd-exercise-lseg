package com.odde.tdd;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Now {

    private TimeProvider timeProvider;
    public Now() {
        this.timeProvider = new SystemTimeProvider();
    }

    public Now(TimeProvider timeProvider) {
        this.timeProvider = timeProvider;
    }

    public String getString() {
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS")
                .format(timeProvider.getDate());
    }


}

