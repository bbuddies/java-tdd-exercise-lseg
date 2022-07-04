package com.odde.tdd;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class EmailNotificationTest {

  private EmailNotification emailNotificationUnderTest;
  @Mock
  private MailService mailService;

//  @Before
//  public void setUp() {
//    emailNotificationUnderTest = new EmailNotification();
//  }

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    emailNotificationUnderTest = new EmailNotification();
  }

  @Test
  public void testWelcome() {
    // Setup
    // Run the test
    emailNotificationUnderTest.welcome("email");
    ArgumentCaptor<Email> argument = ArgumentCaptor.forClass(Email.class);
    verify(mailService).send(argument.capture());
    assertEquals(argument.getValue().getTitle(), "Welcome");

    // Verify the results
  }
}
