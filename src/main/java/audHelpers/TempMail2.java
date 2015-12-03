package main.java.audHelpers;

import static org.junit.Assert.assertFalse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import main.java.audPages.ApplicationManager;


public class TempMail2 implements Mail{
	private ApplicationManager manager;
	private WebDriver wd;
	private String url="http://www.mfsa.info/";
	public String welcomeMsg="Ваша заявка в данный момент проверятся администрацией.";
	
	public TempMail2(ApplicationManager manager) {
		this.manager=manager;
		this.wd=manager.Driver;

	}
	
	public TempMail2 open(){
		wd.get(url);
		return new TempMail2(manager);
	}
	
	
	
	public Element btnReload=new Element("html/body/div[1]/div[3]/div/div[1]/center/div[1]/form/input[2]");
	//public Element btnChange=new Element("");
	public Element fldLogin=new Element("html/body/div[1]/div[3]/div/div[1]/center/div[2]/form/input[1]");
	public Element btnSubmitChange=new Element("html/body/div[1]/div[3]/div/div[1]/center/div[2]/form/input[2]");
//	public Element currentEmail=new Element("");
//	public Element delEmail=new Element("html/body/div[1]/div[3]/div/div[1]/center/div[2]/div[2]/form[1]/a/span");
	public Element txtLogin=new Element("html/body/div[1]/div[3]/div/div[2]/table[2]/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/p/span");
	public Element txtPass=new Element("html/body/div[1]/div[3]/div/div[2]/table[2]/tbody/tr/td/table[2]/tbody/tr[8]/td[2]/p/span");
	public Element txtWelcomeMsg=new Element("html/body/div[1]/div[3]/div/div[2]/table[2]/tbody/tr/td/table[2]/tbody/tr[4]/td[2]/p");
	public Element lnkLastLetter = new Element("html/body/div[1]/div[3]/div/div/div[4]/table/tbody/tr[3]");
	
	public String getEmail(){
		return manager.Driver.findElement(By.xpath("html/body/div[1]/div[3]/div/div/div[1]/h2")).getText();
	}
	
	public  String setMail(String s) { // создание почты
		open();
		//btnChange.click();
		fldLogin.sendKeys(s);
		btnSubmitChange.click();
		String email = getEmail();
		return email;
	}

	public UserAud readMail_aud_reg(UserAud user) {
		//open();
		while (manager.Driver.findElements(By.xpath("html/body/div[1]/div[3]/div/div/div[4]/table/tbody/tr[3]")).isEmpty()) {
			btnReload.click();
			int i=0;
			Element.sl(1);
			i=i+1;
			if (i>3){
				System.err.println("Нет письма с данными для авторизации");
				assertFalse("Нет письма с данными для авторизации", true);
				}
		}
		
		lnkLastLetter.click();
		try{
		user.login = txtLogin.getText();
		user.password = txtPass.getText();
		System.out.println("Получено письмо с данными для авторизации");
		}
		catch(Exception e){
			btnReload.click();
			user=readMail_aud_reg(user);
		}
		
		return user;
	}

	
	public void recPass(User user) {
		
		while (manager.Driver.findElements(By.xpath("html/body/div[1]/div[3]/div/div/div[4]/table/tbody/tr[3]")).isEmpty()) {
			btnReload.click();
			int i=0;
			Element.sl(1);
			i=i+1;
			if (i>3){
				System.err.println("Нет письма с восстановлением пароля");
				assertFalse("Нет письма с восстановлением пароля", true);
				}
		}
			
		lnkLastLetter.click();
		Element lnk = new Element("html/body/div[1]/div[3]/div/div[2]/table[2]/tbody/tr/td/table[2]/tbody/tr[8]/td[2]/a");
		lnk.click();
		System.out.println("Получено письмо с данными для восстановления пароля");
		Element fldNewPass1 = new Element("html/body/div[1]/div[1]/ng-view/div/div[2]/div/form/div/div[1]/label/input");
		fldNewPass1.sendKeys(user.password);
		Element fldNewPass2 = new Element("html/body/div[1]/div[1]/ng-view/div/div[2]/div/form/div/div[2]/label/input");
		fldNewPass2.sendKeys(user.password);
		Element btnSaveChanges= new Element("html/body/div[1]/div[1]/ng-view/div/div[2]/div/form/div/button");
		btnSaveChanges.click();
		Element.sl(2);
		
	}

	
	public void wlcmLttrReadDel(UserAud user) {
		while (manager.Driver.findElements(By.xpath("html/body/div[1]/div[3]/div/div/div[4]/table/tbody/tr[3]")).isEmpty()) {
			btnReload.click();
			int i=0;
			Element.sl(1);
			i=i+1;
			if (i>3){
				System.err.println("Нет приветственного письма");
				assertFalse("Нет приветственного письма", true);
				}
		}
		lnkLastLetter.click();
		String s1=txtWelcomeMsg.getText();
		
		if (welcomeMsg.equals(s1))
		{
			System.out.println("Получено приветственное письмо");
		}
		else{
			System.err.println("Некорректное письмо");
			assertFalse("Некорректное письмо", true);
		}
		
	}
}
/*
 * 
 * @FindBy(xpath="") public WebElement ; WebElement e =
 * wait.until(ExpectedConditions.visibilityOf(By.id(locatorArg)));
 */