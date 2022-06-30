package com.odde.tdd;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NowTest {
    @Test
    public void now_string() throws ParseException {
        TimeProvider provider = mock(TimeProvider.class);
        when(provider.getDate()).thenReturn(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").parse("2018-11-01 01:00:00.000"));

        Now now = new Now(provider);

        assertEquals("2018-11-01 01:00:00.000", now.getString());
    }

    public class StubTimeProvider implements TimeProvider {
        @Override
        public Date getDate() {
            try {
                return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").parse("2018-11-01 01:00:00.000");
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    }
}