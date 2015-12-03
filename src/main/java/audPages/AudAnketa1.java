package main.java.audPages;

import org.openqa.selenium.WebDriver;

import main.java.audHelpers.Element;
import main.java.audHelpers.Files;
import main.java.audHelpers.UserAud;

public class AudAnketa1 {
	private ApplicationManager manager;
	private WebDriver wd;
	private String url = "/#/questionnaire";

	public AudAnketa1(ApplicationManager manager) {
		this.manager = manager;
		this.wd = manager.Driver;
		
	}

	public AudAnketa1 open() {
		wd.get(manager.BaseUrl + url);
		return new AudAnketa1(manager);
	}

	public void fillFields(UserAud user) {
		dwnDownloadFile.sendKeys(Files.pdffile1);
		fldSurname.sendKeys(user.surName);
		fldName.sendKeys(user.name);
		fldMiddlename.sendKeys(user.middleName);
		fldPhone.sendKeys(user.phoneNumber);
		fldNumberAt.sendKeys(user.numberAt);
		fldExp.sendKeys(user.exp);
		fldEmail.sendKeys(user.email);
		chkAgr1.click();
		chkAgr2.click();
		Element.sl(1);
		btnSend.click();
		Element.sl(5);
		btnNext.click();
	}
	
	
	public static Element fldSurname = new Element("html/body/div[1]/div/ng-view/div/div[2]/div[2]/form/div[1]/div[1]/label/input");
	public Element fldName = new Element(
			"html/body/div[1]/div/ng-view/div/div[2]/div[2]/form/div[1]/div[2]/label/input");
	public Element fldMiddlename = new Element(
			"html/body/div[1]/div/ng-view/div/div[2]/div[2]/form/div[1]/div[3]/label/input");
	public Element fldPhone = new Element(
			"html/body/div[1]/div/ng-view/div/div[2]/div[2]/form/div[1]/div[4]/label/input");
	public Element fldEmail = new Element(
			"html/body/div[1]/div/ng-view/div/div[2]/div[2]/form/div[1]/div[5]/label/input");
	public Element fldNumberAt = new Element(
			"html/body/div[1]/div/ng-view/div/div[2]/div[2]/form/div[2]/div[1]/label/input");
	public Element fldExp = new Element(
			"html/body/div[1]/div/ng-view/div/div[2]/div[2]/form/div[2]/div[2]/label/input");
	public Element dwnDownloadFile = new Element("//input[starts-with(@type,'file')][starts-with(@accept,'ap')]");
	public Element chkAgr1 = new Element("html/body/div[1]/div/ng-view/div/div[2]/div[2]/form/div[4]/label/span[1]");
	public Element chkAgr2 = new Element("html/body/div[1]/div/ng-view/div/div[2]/div[2]/form/div[5]/label/span[1]");

	public Element btnSend = new Element("html/body/div[1]/div/ng-view/div/div[2]/div[2]/form/div[6]/button");

	public Element btnNext = new Element("html/body/div[1]/div/ng-view/div/div/div[1]/a");
}
