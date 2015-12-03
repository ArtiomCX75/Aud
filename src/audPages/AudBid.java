package audPages;

import org.openqa.selenium.WebDriver;

import audHelpers.Element;
import audHelpers.Files;


public class AudBid {
	private ApplicationManager manager;
	private WebDriver wd;
	private String url="/#/bid";
	
	public AudBid(ApplicationManager manager) {
		this.manager=manager;
		this.wd=manager.Driver;
		
		}

	public AudBid open(){
		wd.get(manager.BaseUrl+url);
		return new AudBid(manager);
	}
	
	public AudBid downloadOrder(){
		dwnDownloadFile.sendKeys(Files.pdffile1);
		Element.sl(5);
		return new AudBid(manager);
	}
	
	public Element dwnDownloadFile = new Element("//input[@type='file']");
	public Element btnSendOrder = new Element("html/body/div[1]/div/ng-view/div/div/div[2]/div[2]/button");
	public Element lnkZajavka = new Element("html/body/div[1]/div/ng-view/div/div/div[3]/div[1]/div[1]");
	
	public Element lnkAudZakl = new Element("html/body/div[1]/div/ng-view/div/div/div[3]/div[1]/div[2]");
	public Element chkGood = new Element("html/body/div[1]/div[1]/ng-view/div/div/div[3]/div[3]/div[1]/div[1]");
	public Element chkNotBad = new Element("html/body/div[1]/div[1]/ng-view/div/div/div[3]/div[3]/div[2]/div[1]");
	public Element fldNotBadDopPar = new Element("html/body/div[1]/div[1]/ng-view/div/div/div[3]/div[3]/div[2]/div[3]/textarea[1]");
	public Element fldNotBadOsnovanie = new Element("html/body/div[1]/div[1]/ng-view/div/div/div[3]/div[3]/div[2]/div[3]/textarea[2]");
	public Element chkBad = new Element("html/body/div[1]/div[1]/ng-view/div/div/div[3]/div[3]/div[3]/div[1]");
	public Element fldBadDopPar = new Element("html/body/div[1]/div[1]/ng-view/div/div/div[3]/div[3]/div[3]/div[3]/textarea");
	public Element chkDecline = new Element("html/body/div[1]/div[1]/ng-view/div/div/div[3]/div[3]/div[4]/div[1]");
	public Element fldDeclineDopPar = new Element("html/body/div[1]/div[1]/ng-view/div/div/div[3]/div[3]/div[4]/div[3]/textarea");
	
	public Element lnkAudRabDoc = new Element("html/body/div[1]/div/ng-view/div/div/div[3]/div[1]/div[3]");
//	public Element btnSend = new Element("html/body/div[1]/div/ng-view/div/div[2]/div/form/div[2]/div/div[5]/button");
//	public Element btnSendNext = new Element("html/body/div[1]/div/ng-view/div/div[2]/div/a");
	public Element btnExit = new Element("html/body/div[1]/div[1]/ng-view/header/span[1]");

	public enum Mark{good,notBad,bad,decline};
	public AudBid makeZakl(Mark mark, String...strings){
		lnkAudZakl.click();
		switch(mark) {
	    case good: 
		    chkGood.click();
			break;
		case notBad: 
		    chkNotBad.click();
		    fldNotBadDopPar.sendKeys(strings[0]);
		    fldNotBadOsnovanie.sendKeys(strings[1]);
			break;
		case bad: 
		    chkBad.click();
		    fldBadDopPar.sendKeys(strings[0]);
			break;
		case decline: 
		    chkDecline.click();
		    fldDeclineDopPar.sendKeys(strings[0]);
			break;
		}
		return new AudBid(manager);
	}
	
	public AudBid checkAll() {
		lnkAudRabDoc.click();
		double d=Element.t;
		Element.t=0.05;		
		String[] chk = { "010303", "020304", "030204", "040304", "050304", "060305", "070403", "080202", "090306", "101500", "110306", "120306", "130506", "140605", "150205", "160202", "170503"};
		for(String i : chk) {
			String i1=i.substring(0, 2);
			String i2=i.substring(2, 4);
			String i3=i.substring(4, 6);
			String s1="html/body/div[1]/div[1]/ng-view/div/div/div[3]/div[4]/uib-accordion/div/div[";
			String s2="]/div[2]/div/div/div[";
			String s3="]/div[";
			String s4="]/div[4]";
			String pr1=".//*[@id='program-";
			int pr2=(Integer.parseInt(i1)-1);
			String pr3="']/div";
			String pr4=pr1+pr2+pr3;
			Element prog = new Element(pr4);
			prog.click();
			Element.sl(0.5);
			for (int k1=2;k1<(Integer.parseInt(i2)+2);k1++){
				String s = s1+i1+s2+"1"+s3+k1+s4;
				Element el1 = new Element(s);
				el1.click();
			}
			for (int k2=2;k2<(Integer.parseInt(i3)+2);k2++){
				String s = s1+i1+s2+"2"+s3+k2+s4;
				Element el2 = new Element(s);
				el2.click();
			}	//html/body/div[1]/div[1]/ng-view/div/div/div[3]/div[4]/uib-accordion/div/div[1]/div[2]/div/div/div[1]/div[contains(@class, 'not')]
		}
		Element.t=d;
		//hack
		/*Element nds1 = new Element(".//div/div[14]/div[1]/h4/a/span/div/div");
		Element nds2 = new Element(".//div/div[14]/div[2]/div/div/div[2]/div[2]/div[4]");
		nds1.click();
		nds2.click();
		*/// hack end
		return new AudBid(manager);
	}

	
}