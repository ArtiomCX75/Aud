package audHelpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import audPages.ApplicationManager;
import audPages.AudCabPred;
import audPages.AudList;

public class LoginHelper {

	private ApplicationManager manager;
	private WebDriver wd;

	public LoginHelper(ApplicationManager manager) {
		this.manager = manager;
		this.wd = manager.Driver;
		PageFactory.initElements(this.wd, this);
	}

	public AudCabPred login(UserPred user) {
		String login = user.email;
		String pass = user.password;
		login(login, pass);
		return new AudCabPred(manager);
	}

	public AudList login(UserAud user) {
		String login = user.login;
		String pass = user.password;
		login(login, pass);
		return new AudList(manager);
	}

	private void login(String login, String pass) {
		manager.landPred.fldLogin.sendKeys(login);
		manager.landPred.fldPass.sendKeys(pass);
		Element.sl(0.5);
		manager.landPred.btnLoginSubmit.click();
		Element.sl(0.5);
	}

	public void btnEscClick() {
		manager.landPred.btnEsc.click();
		// return new AllPages(manager);
	}

	public void recPass(String email) {
		manager.landPred.lnkRecPass.click();
		manager.landPred.fldRecPass.sendKeys(email);
		manager.landPred.btnRecPass.click();
		Element.sl(2);
	}
}
