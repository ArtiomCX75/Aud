package main.java.audPages;

import org.openqa.selenium.WebDriver;

import main.java.audHelpers.Element;
import main.java.audHelpers.UserPred;

public class AudAnketPred2   {
	private ApplicationManager manager;
	private WebDriver wd;
	private String url = "/#/create/info";

	public AudAnketPred2(ApplicationManager manager) {
		this.manager = manager;
		this.wd = manager.Driver;
		
	}

	public AudAnketPred2 open() {
		wd.get(manager.BaseUrl + url);
		return new AudAnketPred2(manager);
	}
	
	public AudDocs fillFields(UserPred user) {
		fldFIndex.sendKeys(user.index);
		fldFRegion.sendKeys(user.region);
		fldFCity.sendKeys(user.city);
		fldFStreet.sendKeys(user.street);
		fldFHouse.sendKeys(user.house);
		fldFBuilding.sendKeys(user.building);
		fldFOffice.sendKeys(user.flat);
		chkNotTheSame.click();
		fldJIndex.sendKeys(user.index);
		fldJRegion.sendKeys(user.region);
		fldJCity.sendKeys(user.city);
		fldJStreet.sendKeys(user.street);
		fldJHouse.sendKeys(user.house);
		fldJBuilding.sendKeys(user.building);
		fldJOffice.sendKeys(user.flat);
		fldGenDir.sendKeys(user.genDir);
		fldOGRN.sendKeys(user.ogrn);
		btnGoToDocs.click();
		return new AudDocs(manager);
	}
	public Element fldFIndex = new Element("html/body/div[1]/div[1]/ng-view/div/div/div/form/div[1]/div[1]/label[1]/input");
	public Element fldFRegion = new Element("html/body/div[1]/div[1]/ng-view/div/div/div/form/div[1]/div[1]/label[2]/input");
	public Element fldFCity = new Element("html/body/div[1]/div[1]/ng-view/div/div/div/form/div[1]/div[2]/label[1]/input");
	public Element fldFStreet = new Element("html/body/div[1]/div[1]/ng-view/div/div/div/form/div[1]/div[2]/label[2]/input");
	public Element fldFHouse = new Element("html/body/div[1]/div[1]/ng-view/div/div/div/form/div[1]/div[3]/label[1]/input");
	public Element fldFBuilding = new Element("html/body/div[1]/div[1]/ng-view/div/div/div/form/div[1]/div[3]/label[2]/input");
	public Element fldFOffice = new Element("html/body/div[1]/div[1]/ng-view/div/div/div/form/div[1]/div[3]/label[3]/input");
	
	public Element chkNotTheSame = new Element("html/body/div[1]/div[1]/ng-view/div/div/div/form/div[2]/div/ul/div/label");
	
	public Element fldJIndex = new Element("html/body/div[1]/div[1]/ng-view/div/div/div/form/div[3]/div[1]/label[1]/input");
	public Element fldJRegion = new Element("html/body/div[1]/div[1]/ng-view/div/div/div/form/div[3]/div[1]/label[2]/input");
	public Element fldJCity = new Element("html/body/div[1]/div[1]/ng-view/div/div/div/form/div[3]/div[2]/label[1]/input");
	public Element fldJStreet = new Element("html/body/div[1]/div[1]/ng-view/div/div/div/form/div[3]/div[2]/label[2]/input");
	public Element fldJHouse = new Element("html/body/div[1]/div[1]/ng-view/div/div/div/form/div[3]/div[3]/label[1]/input");
	public Element fldJBuilding = new Element("html/body/div[1]/div[1]/ng-view/div/div/div/form/div[3]/div[3]/label[2]/input");
	public Element fldJOffice = new Element("html/body/div[1]/div[1]/ng-view/div/div/div/form/div[3]/div[3]/label[3]/input");
	
	public Element fldGenDir = new Element("html/body/div[1]/div[1]/ng-view/div/div/div/form/div[4]/div/label[1]/input");
	public Element fldOGRN = new Element("html/body/div[1]/div[1]/ng-view/div/div/div/form/div[4]/div/label[2]/input");
	
	public Element btnGoToDocs = new Element("html/body/div[1]/div[1]/ng-view/div/div/div/form/div[5]/button");

	

}