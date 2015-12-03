package test.java.audTests;

import org.junit.Test;
import main.java.audHelpers.UserPred;

public class TestRegPred extends TestBase {
	@Test
	public void regPred() throws Exception {
		UserPred Pred1 = new UserPred();
		Pred1.email = app.mail.setMail(Pred1.semiEmail);
		app.audHelper.reg_pred(Pred1);
	}
}