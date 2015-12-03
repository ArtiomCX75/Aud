package audHelpers;

import static org.junit.Assert.assertFalse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import audPages.ApplicationManager;


public class TempMail1  implements Mail{
	private ApplicationManager manager;
	private WebDriver wd;
	private String url="https://temp-mail.ru/";
	
	public TempMail1(ApplicationManager manager) {
		this.manager=manager;
		this.wd=manager.Driver;

	}
	
	public TempMail1 open(){
		wd.get(url);
		return new TempMail1(manager);
	}
	
		
	public String getEmail(){
		return currentEmail.getAttribute("Value");
	}
	
	public  String setMail(String s){ // создание почты
		open();
		Element.sl(5);
		btnChange.click();
		fldLogin.sendKeys(s);
		btnSubmitChange.click();
		btnReload.click();
		Element.sl(1);
		String email = getEmail();
		return email;
	}

	
	public UserAud readMail_aud_reg(UserAud user) {
		//open();
		int i=0;
		while (manager.Driver.findElements(By.xpath("html/body/div[1]/div/div/div[2]/div/div/table/tbody/tr/td[2]/a")).isEmpty()) {
			btnReload.click();
			i=i+1;
			Element.sl(1);
			if (i>3){
				System.err.println("there is not email for reg aud");
				assertFalse("there is not email for reg aud", true);
				}
		}
		Element letter = new Element("html/body/div[1]/div/div/div[2]/div/div/table/tbody/tr/td[2]/a");
		letter.click();
		try{
		Element login = new Element("html/body/div[1]/div/div/div[2]/div/div/div[3]/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/p/span");
		user.login = login.getText();
		Element pass = new Element("html/body/div[1]/div/div/div[2]/div/div/div[3]/table/tbody/tr/td/table[2]/tbody/tr[8]/td[2]/p/span");
		user.password =pass.getText();
		}
		catch(Exception e){
			btnReload.click();
			user=readMail_aud_reg(user);
			
		}
		return user;
	}
	

	public Element btnReload=new Element("html/body/div[1]/div/div/div[1]/ul/li[2]/a");
	public Element btnChange=new Element("html/body/div[1]/div/div/div[1]/ul/li[3]/a");
	public Element fldLogin=new Element("html/body/div[1]/div/div/div[2]/div[1]/div[2]/div/form/div[1]/div/input");
	public Element btnSubmitChange=new Element("html/body/div[1]/div/div/div[2]/div[1]/div[2]/div/form/div[3]/div[2]/button");
	public Element currentEmail=new Element("html/body/header/div/div/div/div[2]/div/div[1]/div/input");

	
	public void recPass(User user) {
		int i=0;
		while (manager.Driver.findElements(By.xpath("html/body/div[1]/div/div/div[2]/div/div/table/tbody/tr/td[2]/a")).isEmpty()) {
			btnReload.click();
			i=i+1;
			Element.sl(1);
			if (i>3){
				System.err.println("there is not email for reg aud");
				assertFalse("there is not email for reg aud", true);
				}
		}
		Element letter = new Element("html/body/div[1]/div/div/div[2]/div/div/table/tbody/tr/td[2]/a");
		letter.click();
		Element lnk = new Element("html/body/div[1]/div/div/div[2]/div/div/div[3]/table/tbody/tr/td/table[2]/tbody/tr[8]/td[2]/p/a");
		lnk.click();
		Element fldNewPass1 = new Element("html/body/div[1]/div[1]/ng-view/div/div[2]/div/form/div/div[1]/label/input");
		fldNewPass1.sendKeys(user.password);
		Element fldNewPass2 = new Element("html/body/div[1]/div[1]/ng-view/div/div[2]/div/form/div/div[2]/label/input");
		fldNewPass2.sendKeys(user.password);
		Element btnSaveChanges= new Element("html/body/div[1]/div[1]/ng-view/div/div[2]/div/form/div/button");
		btnSaveChanges.click();
		Element.sl(2);
	}

	
	public void wlcmLttrReadDel(UserAud user) {
		// TODO Auto-generated method stub
		
	}

}

/*
@FindBy(xpath="")
public WebElement ;
WebElement e = wait.until(ExpectedConditions.visibilityOf(By.id(locatorArg)));
*/