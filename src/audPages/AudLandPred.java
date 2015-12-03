package audPages;

import org.openqa.selenium.WebDriver;
import audHelpers.LoginHelper;
import audHelpers.Element;

public class AudLandPred   {
	private ApplicationManager manager;
	private WebDriver wd;
	private String url = "/";

	public AudLandPred(ApplicationManager manager) {
		this.manager = manager;
		this.wd = manager.Driver;

	}

	public AudLandPred open() {
		wd.get(manager.BaseUrl + url);

		return new AudLandPred(manager);
	}

	public LoginHelper btnVhodClick() {
		Element.sl(1);
		btnVhod.click();
		return new LoginHelper(manager);
	}

	public AudLandPred btnZakazAudClick() {
		btnZakazAud.click();
		return new AudLandPred(manager);
	}

	public AudAnketPred1 fillTheFields(int s1, int s2, int s3, int s4, int s5, int s6, int s7, int s8) {

		fillTheFields(Integer.toString(s1), Integer.toString(s2), Integer.toString(s3), Integer.toString(s4),
				Integer.toString(s5), Integer.toString(s6), Integer.toString(s7), Integer.toString(s8));
		return new AudAnketPred1(manager);
	}

	public AudAnketPred1 fillTheFields(String s1, String s2, String s3, String s4, String s5, String s6, String s7,
			String s8) {
		fldUrSusch1.sendKeys(s1);
		fldUrSusch2.sendKeys(s2);
		fldUrSusch3.sendKeys(s3);
		fldUrSusch4.sendKeys(s4);
		fldUrSusch5.sendKeys(s5);
		fldUrSusch6.sendKeys(s6);
		fldUrSusch7.sendKeys(s7);
		fldUrSusch8.sendKeys(s8);
		btnRassch.click();
		return new AudAnketPred1(manager);

	}

	public Element lnkLogoHeader = new Element("html/body/div[1]/div/ng-view/div[1]/header/span");
	public Element lnkONas = new Element("html/body/div[1]/div/ng-view/div[1]/header/nav/ul/li[1]/span");
	public Element lnkKakPr = new Element("html/body/div[1]/div/ng-view/div[1]/header/nav/ul/li[2]/span");
	public Element lnkKomanda = new Element("html/body/div[1]/div/ng-view/div[1]/header/nav/ul/li[3]/span");
	public Element lnkVoprosy = new Element("html/body/div[1]/div/ng-view/div[1]/header/nav/ul/li[4]/span");
	public Element lnkZakon = new Element("html/body/div[1]/div/ng-view/div[1]/header/nav/ul/li[5]/span");
	public Element lnkUznatUr = new Element("html/body/div[1]/div/ng-view/div[1]/header/nav/ul/li[6]/span");

	public Element btnVhod = new Element("html/body/div[1]/div/ng-view/div[1]/header/div/span");

	public Element fldLogin = new Element("html/body/div[4]/table/tbody/tr/td/div/div/form[1]/label[1]/input");
	public Element fldPass = new Element("html/body/div[4]/table/tbody/tr/td/div/div/form[1]/label[2]/input");
	public Element btnLoginSubmit = new Element("html/body/div[4]/table/tbody/tr/td/div/div/form[1]/input");
	public Element lnkRecPass= new Element("html/body/div[4]/table/tbody/tr/td/div/div/form[1]/span");
	public Element fldRecPass = new Element("html/body/div[4]/table/tbody/tr/td/div/div/form[2]/label/input[contains(@ng-focus,'restore')]");
	public Element btnRecPass = new Element("html/body/div[4]/table/tbody/tr/td/div/div/form[2]/input[contains(@value,'Выслать')]");
	
	public Element btnEsc = new Element("html/body/div[4]/table/tbody/tr/td/div/span[2]");

	public Element btnZakazAud = new Element("html/body/div[1]/div/ng-view/div[1]/section[1]/div/div/div/div/span[2]");

	public Element fldUrSusch1 = new Element(
			"html/body/div[1]/div/ng-view/div[1]/section[8]/div/form/div/div[1]/label[1]/input");
	public Element fldUrSusch2 = new Element(
			"html/body/div[1]/div/ng-view/div[1]/section[8]/div/form/div/div[1]/label[2]/input");
	public Element fldUrSusch3 = new Element(
			"html/body/div[1]/div/ng-view/div[1]/section[8]/div/form/div/div[1]/label[3]/input");
	public Element fldUrSusch4 = new Element(
			"html/body/div[1]/div/ng-view/div[1]/section[8]/div/form/div/div[1]/label[4]/input");
	public Element fldUrSusch5 = new Element(
			"html/body/div[1]/div/ng-view/div[1]/section[8]/div/form/div/div[2]/label[1]/input");
	public Element fldUrSusch6 = new Element(
			"html/body/div[1]/div/ng-view/div[1]/section[8]/div/form/div/div[2]/label[2]/input");
	public Element fldUrSusch7 = new Element(
			"html/body/div[1]/div/ng-view/div[1]/section[8]/div/form/div/div[2]/label[3]/input");
	public Element fldUrSusch8 = new Element(
			"html/body/div[1]/div/ng-view/div[1]/section[8]/div/form/div/div[2]/label[4]/input");
	public Element btnRassch = new Element("html/body/div[1]/div/ng-view/div[1]/section[8]/div/form/button");

}
