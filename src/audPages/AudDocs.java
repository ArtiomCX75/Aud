package audPages;

import org.openqa.selenium.WebDriver;

import audHelpers.Element;

public class AudDocs {
	private ApplicationManager manager;
	private WebDriver wd;
	private String url="/#/documents";
	
	public AudDocs(ApplicationManager manager) {
		this.manager=manager;
		this.wd=manager.Driver;
	}
	
	public AudDocs open(){
		wd.get(manager.BaseUrl+url);
		return new AudDocs(manager);
	}
	
	public Element dwnDownloadFile=new Element("//input[starts-with(@type,'file')][starts-with(@accept,'ap')]");
	public Element fldSearch=new Element("html/body/div[1]/div/ng-view/div/div[2]/div/form/div[2]/div/div[4]/div[1]/input");
	public Element chkAnyAuditor=new Element("html/body/div[1]/div/ng-view/div/div[2]/div/form/div[2]/div/div[3]/div/div/label");
	public Element chkAuditor1=new Element("html/body/div[1]/div/ng-view/div/div[2]/div/form/div[2]/div/div[4]/div[2]/div[1]");
	public Element btnSend=new Element("html/body/div[1]/div/ng-view/div/div[2]/div/form/div[2]/div/div[5]/button[@class='documents__submit btn btn_green']");
	public Element btnSendNext=new Element("html/body/div[1]/div/ng-view/div/div[2]/div/a");

	
}


//<button class="documents__submit btn btn_green documents__submit_disabled" ng-class="{documents__submit_disabled: !auditInfo.files.length}" ng-disabled="!auditInfo.files.length" ng-hide="isLoad" disabled="disabled">Отправить на проверку</button>


//<button class="documents__submit btn btn_green" ng-class="{documents__submit_disabled: !auditInfo.files.length}" ng-disabled="!auditInfo.files.length" ng-hide="isLoad">Отправить на проверку</button>