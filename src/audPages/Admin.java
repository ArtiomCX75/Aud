package audPages;

import org.openqa.selenium.WebDriver;

import audHelpers.Element;
import audHelpers.User;

public class Admin {
	private ApplicationManager manager;
	private WebDriver wd;
	private String url = "/admin";
	//private String url = "/admin#/main";
	public Admin(ApplicationManager manager) {
		this.manager = manager;
		this.wd = manager.Driver;

	}

	public Admin open() {
		Element.sl(1);
		wd.get(manager.BaseUrl + url);
		Element.sl(1);
		return new Admin(manager);
	}
	
	public AdminAud regOpen()
	{
		btnReg.click();
		return new AdminAud(manager);
	}
	
	public AdminOrder ordOpen()
	{	
		
		btnOrder.click();
		return new AdminOrder(manager);
	}
	
	
	public Element fldLogin = new Element("html/body/div[1]/div/div/form/md-input-container[1]/input");
	public Element fldPass = new Element("html/body/div[1]/div/div/form/md-input-container[2]/input");
	public Element btnSubmit = new Element("html/body/div[1]/div/div/div/button");
	public Element btnReg = new Element("html/body/div[1]/div/div[2]/div/div[2]/div[1]/a[1]");
	public Element btnOrder = new Element("html/body/div[1]/div/div[2]/div/div[2]/div[1]/a[3]");	
	public Element btnExit = new Element("html/body/div[1]/div/div[1]/div[2]/button");

	public Admin login() {
	fldLogin.sendKeys(User.makeAdmin().email);	
	fldPass.sendKeys(User.makeAdmin().password);	
	btnSubmit.click();
	Element.sl(3);
	return new Admin(manager);
	}
}
