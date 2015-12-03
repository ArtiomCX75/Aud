package main.java.audPages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import main.java.audHelpers.Element;
import main.java.audHelpers.LoginHelper;
import main.java.audHelpers.Mail;
//import main.java.audHelpers.TempMail1;
import main.java.audHelpers.TempMail2;
import main.java.audHelpers.audHelper;

public class ApplicationManager {

	public String BaseUrl;
	public WebDriver Driver;
	public AudAnketa1 anketa1;
	public AudAnketa2 anketa2;
	public AudAnketPred1 anketaPred1;
	public AudBid audbid;
	public AudCabPred cabPred;
	public AudDocs doc;
	public AudLandAud landAud;
	public AudLandPred landPred;
	public AudList list;
	public AudAnketPred2 anketaPred2;
	public AudPay pay;
	//public TempMail1 tempMail1;
	public Element el;
	public TempMail2 tempMail2;
	public Mail mail;
	public Admin admin;
	public AdminAud adminAud;
	public AdminOrder adminOrder;
	public audHelper audHelper;
	public LoginHelper loginH;
	
	public ApplicationManager(String baseUrl) {
		System.setProperty("webdriver.chrome.driver", ".//chromedriver.exe");
		Driver=new ChromeDriver();
		//Driver = new FirefoxDriver();
		Driver.manage().window().maximize();
		Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		BaseUrl=baseUrl;
		el = new Element(this);
		anketa1 = new AudAnketa1(this);
		anketa2 = new AudAnketa2(this);
		anketaPred1 = new AudAnketPred1(this);
		audbid = new AudBid(this);
		cabPred = new AudCabPred(this);
		doc = new AudDocs(this);
		landAud = new AudLandAud(this);
		landPred = new AudLandPred(this);
		list= new AudList(this);
		anketaPred2 = new AudAnketPred2(this);
		pay = new AudPay(this);
	//	tempMail1 = new TempMail1(this);
		tempMail2 = new TempMail2(this);
		loginH = new LoginHelper(this);
		audHelper = new audHelper(this);
		//mail = this.tempMail1;
		admin = new Admin(this);
		adminAud = new AdminAud(this);
		adminOrder = new AdminOrder(this);
		
	
		
	}

}
