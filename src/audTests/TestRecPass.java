package audTests;

import org.junit.Test;

import audHelpers.Element;
import audHelpers.UserAud;
import audHelpers.UserPred;

public class TestRecPass extends TestBase{
	UserPred Pred1 = UserPred.readLast();
	UserAud Aud1 = UserAud.readLast();
	
	@Test
	public void rec_pass_pred() throws Exception {
		Element.sl(2);	
		app.landPred.open().btnVhodClick().recPass(Pred1.email);
		app.mail.setMail(Pred1.semiEmail);
		app.mail.recPass(Pred1);
		app.cabPred.open().btnExit.click();
	}
	
	@Test
	public void rec_pass_aud() throws Exception {
		Element.sl(2);	
		app.landAud.open().btnVhodClick().recPass(Aud1.email);
		app.mail.setMail(Aud1.semiEmail);
		app.mail.recPass(Aud1);
		app.list.open().btnExit.click();
	}
	
}
