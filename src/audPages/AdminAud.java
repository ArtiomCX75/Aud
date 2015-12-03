package audPages;

import org.openqa.selenium.WebDriver;

import audHelpers.Element;
import audHelpers.User;

public class AdminAud {
	private ApplicationManager manager;
	private WebDriver wd;
	private String url = "/admin#/main/auditors/registration";

	public AdminAud(ApplicationManager manager) {
		this.manager = manager;
		this.wd = manager.Driver;

	}

	public Admin open() {
		wd.get(manager.BaseUrl + url);
		return new Admin(manager);
	}

	public Element btnOk = new Element("html/body/div[1]/div[3]/md-dialog/div/button");
	public Element btnExit = new Element("html/body/div[1]/div/div[1]/div[2]/button");

	public AdminAud choseUser(User u) {
		Element.sl(1);
		Element el = new Element(".//div[contains(text(),'" + u.email + "')]");
		el.click();
		Element.sl(1);
		return new AdminAud(manager);
	}

	public AdminAud acceptUser(User u) {
		Element.sl(2);
		Element btnReg = new Element(".//div[div[@class='panel-heading']//*[contains(text(),'" + u.email+ "')]]//button[span[contains(text(),'Зар')]]");
		
		//.//div[div[@class='panel-heading']//*[contains(text(),'aud301115121215')]]//button[span[contains(text(),'ло')]]
		btnReg.click();
		Element.sl(1);
		btnOk.click();
		Element.sl(1);
		return new AdminAud(manager);
	}

	public AdminAud regUser(User u) {
		choseUser(u);
		acceptUser(u);
		return new AdminAud(manager);
	}
}