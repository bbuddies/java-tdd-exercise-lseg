package com.odde.tdd;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class EmailNotificationTest {

    @Test
    public void send_welcome_mail() {
//        Outbox mockOutbox = new MockOutbox();

        Outbox outbox = mock(Outbox.class);

        EmailNotification emailNotification = new EmailNotification(outbox);
        emailNotification.welcome("zbcjackson@gmail.com");
//        ((MockOutbox)mockOutbox).verify();
        ArgumentCaptor<Email> argument = ArgumentCaptor.forClass(Email.class);
        verify(outbox).send(argument.capture());
        assertEquals("Welcome", argument.getValue().getTitle());
    }
}

class MockOutbox implements Outbox {

    private boolean isCalled;
    private Email mail;

    @Override
    public void send(Email mail) {
        isCalled = true;
        this.mail = mail;
        // Real implementation to send email
    }

    public void verify()  {
        assertTrue(isCalled);
        assertEquals("Welcome", mail.getTitle());
        assertEquals("Welcome", mail.getTitle());
    }
}