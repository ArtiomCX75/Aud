package main.java.audPages;

import org.openqa.selenium.WebDriver;

import main.java.audHelpers.Element;
import main.java.audHelpers.Files;
import main.java.audHelpers.UserAud;

public class AudAnketa2 {
	private ApplicationManager manager;
	private WebDriver wd;
	private String url = "/#/auditors/registration";

	public AudAnketa2(ApplicationManager manager) {
		this.manager = manager;
		this.wd = manager.Driver;
		
	}

	public AudAnketa2 open() {
		wd.get(manager.BaseUrl + url);
		return new AudAnketa2(manager);
	}

	public void fillFields(UserAud user){
		manager.anketa2.fldDateOfBirth.sendKeys(user.dateOfBirth);
		manager.anketa2.fldSnils.sendKeys(user.snils);
		manager.anketa2.fldPassNumber.sendKeys(user.passNumber);
		manager.anketa2.fldCity.sendKeys(user.city);
		manager.anketa2.fldStreet.sendKeys(user.street);
		manager.anketa2.fldHouse.sendKeys(user.house);
		manager.anketa2.fldFlat.sendKeys(user.flat);
		manager.anketa2.fldBic.sendKeys(user.bic);
		manager.anketa2.fldBill.sendKeys(user.bill);
		manager.anketa2.dwnDownloadFile.sendKeys(Files.jpgfile1);
		manager.anketa2.chkAgree.click();
		Element.sl(3);
		manager.anketa2.btnSend.click();
		Element.sl(3);
		
	}
	
	public Element fldDateOfBirth = new Element(
			"html/body/div[1]/div/ng-view/div/div[2]/div[2]/form/div[1]/div[1]/label/input");
	public Element fldSnils = new Element(
			"html/body/div[1]/div/ng-view/div/div[2]/div[2]/form/div[1]/div[2]/label/input");
	public Element fldPassNumber = new Element(
			"html/body/div[1]/div/ng-view/div/div[2]/div[2]/form/div[1]/div[3]/label/input");
	public Element fldCity = new Element(
			"html/body/div[1]/div/ng-view/div/div[2]/div[2]/form/div[1]/div[4]/label/input");
	public Element fldStreet = new Element(
			"html/body/div[1]/div/ng-view/div/div[2]/div[2]/form/div[1]/div[5]/label/input");
	public Element fldHouse = new Element(
			"html/body/div[1]/div/ng-view/div/div[2]/div[2]/form/div[1]/div[6]/label/input");
	public Element fldFlat = new Element(
			"html/body/div[1]/div/ng-view/div/div[2]/div[2]/form/div[1]/div[7]/label/input");
	public Element fldBic = new Element(
			"html/body/div[1]/div/ng-view/div/div[2]/div[2]/form/div[3]/div[1]/label/input");
	public Element fldBill = new Element(
			"html/body/div[1]/div/ng-view/div/div[2]/div[2]/form/div[3]/div[4]/label/input");
	public Element dwnDownloadFile = new Element("//input[starts-with(@type,'file')][starts-with(@accept,'im')]");
	public Element chkAgree = new Element("html/body/div[1]/div/ng-view/div/div[2]/div[2]/form/div[5]/label/span[1]");
	public Element btnSend = new Element("html/body/div[1]/div/ng-view/div/div[2]/div[2]/form/div[6]");
}
