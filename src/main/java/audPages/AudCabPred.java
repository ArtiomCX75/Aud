package main.java.audPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import main.java.audHelpers.Element;
import main.java.audHelpers.Files;

public class AudCabPred {
	private ApplicationManager manager;
	private WebDriver wd;
	private String url = "/#/cabinet";

	public AudCabPred(ApplicationManager manager) {
		this.manager = manager;
		this.wd = manager.Driver;

	}

	public AudCabPred open() {
		wd.get(manager.BaseUrl + url);
		return new AudCabPred(manager);
	}
public String getStatus() {
		return wd.findElement(By.xpath("html/body/div[1]/div[1]/ng-view/div/div/div[2]/div[1]/div[2]")).getText();
	}
public boolean verifyStatus(String goodStatus) {
	String status = getStatus();
	return status.equals(goodStatus);
}

	public Element btnReloadStatus = new Element("html/body/div[1]/div/ng-view/div/div/div[2]/div[4]/span");
	public Element btnExit = new Element("html/body/div[1]/div/ng-view/header/div/div/a");
	public Element btnReWork1 = new Element("html/body/div[1]/div[1]/ng-view/div/div/div[2]/div[6]/span[2]");
	public Element fldReWork = new Element("html/body/div[1]/div[1]/ng-view/div/div/div[2]/div[7]/textarea");
	public Element btnReWork2 = new Element("html/body/div[1]/div[1]/ng-view/div/div/div/div/span[contains(text(),'на доработку')][@class='button']");
	public Element btnAcceptWork = new Element("html/body/div[1]/div[1]/ng-view/div/div/div[2]/div[6]/span[1]");
	public Element fldPost = new Element(".//input[contains(@type,'email')]");
	public Element btnSendPost = new Element(".//div[div/text() = 'Отправить']");
	public Element dwnFile = new Element(".//input [@type = 'file']");

	public void naDorabotku(String string, String pdffile2) {
		btnReWork1.click();
		dwnFile.sendKeys(Files.pdffile2);
		Element.sl(5);
		fldReWork.sendKeys("aufull");
		Element.sl(1);
		btnReWork2.click();
		Element.sl(1);
	}
	
	
}