package email;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MailSenderTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		MailSender mailSender = new MailSender();
		try {
			List<String> recipients = new ArrayList<String>();
			recipients.add("ABCJobsPortal@gmail.com");
			String message = "Test Message";
			String subject = "Test Subject";
			mailSender.sendSSLMessage(recipients, message, subject);
			assertTrue(true, "Email sent");
		} catch (Exception e) {
			e.printStackTrace();
			assertFalse(true, "Email not sent");
		}
	}

}
