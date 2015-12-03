package test.java.audTests;

import org.junit.Test;

import main.java.audHelpers.Element;
import main.java.audHelpers.UserAud;
import main.java.audHelpers.UserPred;


public class TestAuth extends TestBase {
	UserPred Pred1 = UserPred.readLast();
	UserAud Aud1= UserAud.readLast();

	@Test
	public void auth_pred() throws Exception {
		Element.sl(2);	
		app.landPred.open().btnVhodClick().login(Pred1);
		Element.sl(2);
		app.cabPred.btnExit.click();
	}
	
	@Test
	public void auth_aud() {
		Element.sl(2);
		app.landAud.open().btnVhodClick().login(Aud1);
		Element.sl(2);
		app.audbid.btnExit.click();	
	}
}
