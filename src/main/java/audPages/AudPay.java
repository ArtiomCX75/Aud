package main.java.audPages;

import org.openqa.selenium.WebDriver;

import main.java.audHelpers.Element;

public class AudPay {
	private ApplicationManager manager;
	private WebDriver wd;
	private String url = "/#/create/pay";

	public AudPay(ApplicationManager manager) {
		this.manager = manager;
		this.wd = manager.Driver;

	}

	public AudPay open() {
		wd.get(manager.BaseUrl + url);
		return new AudPay(manager);
	}

	public Element btnGetBill = new Element(".//div/a[contains(text(),'25 000')]");
}