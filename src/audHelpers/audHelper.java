package audHelpers;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import audPages.ApplicationManager;
import audPages.AudLandPred;

public class audHelper {
	private ApplicationManager manager;
	private WebDriver wd;
	// private String url="/#/create";

	public audHelper(ApplicationManager manager) {
		this.manager = manager;
		this.wd = manager.Driver;

	}

	public AudLandPred reg_pred(UserPred user) {
		newBid(user, "new");
		writeObject(user, "temp_pred.txt");
		return new AudLandPred(manager);
	}

	public AudLandPred create_bid(UserPred user) throws Exception {
		newBid(user, "old");
		return new AudLandPred(manager);
	}

	private void newBid(UserPred user, String userType)  {
		manager.landPred.open().btnZakazAudClick().fillTheFields(100, 100, 100, 100, 100, 100, 100, 100)
				.fillTheCompany(user).chkAgree.click();
		if ("new".equals(userType)) {
			manager.anketaPred1.fillAccount(user);
		}
		manager.anketaPred1.btnZakaz.click();
		Element.sl(2);
		manager.pay.btnGetBill.click();
		Element.sl(2);
		manager.anketaPred2.open().fillFields(user);
		Element.sl(2);
		manager.doc.dwnDownloadFile.sendKeys(Files.pdffile1);
		Element.sl(5);
		manager.doc.btnSend.click();
		Element.sl(2);
		user.orderNumber = wd.findElement(By.xpath(".//div[3]/div[2]")).getText();
		manager.cabPred.btnReloadStatus.click();
		manager.cabPred.btnExit.click();
	}

	public void writeObject(Object obj, String s) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(s);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			oos = new ObjectOutputStream(fos);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			oos.writeObject(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void reg_aud(UserAud user) {
		manager.landAud.open().btnStartWork.click();
		manager.anketa1.fillFields(user);
		manager.mail.setMail(user.semiEmail);
		manager.mail.wlcmLttrReadDel(user);

		manager.admin.open().login().regOpen().regUser(user).btnExit.click();
		manager.mail.setMail(user.semiEmail);
		user = manager.mail.readMail_aud_reg(user);
		manager.landAud.open().btnVhodClick().login(user);
		manager.anketa2.fillFields(user);
		manager.list.btnExit.click();
		writeObject(user, "temp_aud.txt");
		System.out.println("A email: " + user.email + " pass: " + user.password);
	}

}
