package main.java.audPages;

import org.openqa.selenium.WebDriver;

import main.java.audHelpers.Element;
import main.java.audHelpers.UserPred;

public class AudAnketPred1 {
	private ApplicationManager manager;
	private WebDriver wd;
	private String url = "/#/create";

	public AudAnketPred1(ApplicationManager manager) {
		this.manager = manager;
		this.wd = manager.Driver;

	}

	public AudAnketPred1 open() {
		wd.get(manager.BaseUrl + url);
		return new AudAnketPred1(manager);
	}

	public AudAnketPred1 fillTheCompany(UserPred user) {
		Element.sl(0.5);
		fldNazvOrg.sendKeys(user.orgName);
		fldContactFio.sendKeys(user.contactName);
		fldUsualPhone.sendKeys(user.usualPhone);
		fldPhone.sendKeys(user.phoneNumber);
		return new AudAnketPred1(manager);
	}

	public AudAnketPred1 fillAccount(UserPred user) {
		fldEmail.sendKeys(user.email);
		fldPass.sendKeys(user.password);
		return new AudAnketPred1(manager);
	}

	public Element fldNazvOrg = new Element(".//div[1]/div[1]/label[1]/input");
	public Element fldContactFio = new Element(".//div[1]/div[1]/label[2]/input");
	public Element fldUsualPhone = new Element(".//div[1]/div[2]/label[1]/input");
	public Element fldPhone = new Element(".//div[1]/div[2]/label[2]/input");
	public Element fldEmail = new Element("html/body/div[1]/div/ng-view/div/div/div/form/div[2]/div[1]/label/input");
	public Element fldPass = new Element("html/body/div[1]/div/ng-view/div/div/div/form/div[2]/div[2]/label/input");
	public Element chkAgree = new Element(".//div[1]/div/ng-view/div/div/div/form/div[2]/div[2]/div/div/label/span[1]");
	public Element btnZakaz = new Element("html/body/div[1]/div/ng-view/div/div/div/form/div[2]/div[1]/div/button");

}
