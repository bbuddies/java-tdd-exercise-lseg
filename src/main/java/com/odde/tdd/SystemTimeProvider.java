package com.odde.tdd;

import java.util.Date;

public class SystemTimeProvider implements TimeProvider {
    @Override
    public Date getDate() {
        return new Date();
    }
}
