package audTests;
import org.junit.Test;

import audHelpers.UserAud;
public class TestRegAud extends TestBase{	
	@Test
	public void regAud() throws Exception{
		UserAud Aud1 = new UserAud();
		Aud1.email = app.mail.setMail(Aud1.semiEmail);
		app.audHelper.reg_aud(Aud1);
	}	
}


