package test.java.audTests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import main.java.audHelpers.Constants;
import main.java.audHelpers.Element;
import main.java.audHelpers.Files;
import main.java.audHelpers.UserAud;
import main.java.audHelpers.UserPred;
import main.java.audPages.AudBid.Mark;

public class TestDeal extends TestBase {
	public UserPred Pred1;
	public UserAud Aud1;

	@Test
	public void makeDeal() throws Exception {
		//System.out.println("1");
		whatToDo();
		app.landPred.open().btnVhodClick().login(Pred1).btnReloadStatus.click();
		assertTrue("Некорректный статус", app.cabPred.verifyStatus(Constants.statusNaProverke));
		app.cabPred.btnExit.click();
		app.landAud.open().btnVhodClick().login(Aud1);
		app.list.chooseBid(Pred1).downloadOrder().makeZakl(Mark.notBad,"notbad1","notbad2").checkAll().btnSendOrder.click();
		Element.sl(50);
		app.audbid.btnExit.click();
		System.out.println(Pred1.orderNumber);
		app.admin.open().login().ordOpen().chooseAndAccept(Pred1).btnExit.click();
		app.landPred.open().btnVhodClick().login(Pred1);
		Element.sl(1);
		assertTrue("Некорректный статус", app.cabPred.verifyStatus(Constants.statusVipoln));
		app.cabPred.naDorabotku("aufull", Files.pdffile2);
		assertTrue("Некорректный статус", app.cabPred.verifyStatus(Constants.statusNaDorab));
		app.cabPred.btnExit.click();
		app.landAud.open().btnVhodClick().login(Aud1).chooseCurrent().makeZakl(Mark.notBad,"notbad1000","notbad2000").btnSendOrder.click();
		Element.sl(50);
		app.audbid.btnExit.click();
		System.out.println(Pred1.orderNumber);
		app.admin.open().login().ordOpen().chooseAndAccept(Pred1).btnExit.click();
		app.landPred.open().btnVhodClick().login(Pred1);
		Element.sl(1);
		assertTrue("Некорректный статус", app.cabPred.verifyStatus(Constants.statusVipoln));
		app.cabPred.btnAcceptWork.click();
		Element.sl(2);
		assertTrue("Некорректный статус", app.cabPred.verifyStatus(Constants.statusRabPrin));
		app.cabPred.fldPost.sendKeys("faa1192@gmail.com");
		app.cabPred.btnSendPost.click();
		app.cabPred.btnExit.click();
		Element.t=2.0;
	}

	private void whatToDo() throws Exception {
		Pred1 = UserPred.readLast();
		Aud1 = UserAud.readLast();
		app.landAud.open().btnVhodClick().login(Aud1);
		Element.sl(2);
		Boolean isCurrentPresentDisplayed;
		try{
		isCurrentPresentDisplayed = app.Driver.findElement(By.xpath(".//h5[contains(text(), 'Принята вами')]"))
				.isDisplayed();}
		catch(NoSuchElementException e){
			isCurrentPresentDisplayed=false;		}
		String s1 = ".//div[3]/ul[./li/div/div/p[contains(text(),'";
		String s2 = Pred1.contactName;
		String s3 = "')]]/li/div/div[2]/button";
		Boolean isBidAvailableEmpty = app.Driver.findElements(By.xpath(s1 + s2 + s3)).isEmpty();
		app.audbid.btnExit.click();

		if (isCurrentPresentDisplayed == true) {
			System.out.println("Есть активная заявка. Регистрируем нового аудитора");
			UserAud user = new UserAud();
			user.email = app.mail.setMail(user.semiEmail);
			app.audHelper.reg_aud(user);
			this.whatToDo();
			return;
		} else {
			System.out.println("Нет активной заявки");
		}
		if (isBidAvailableEmpty == true) {
			System.out.println("Не доступна заявка. Проверяю ее статус у предпринимателя");
			app.landPred.open().btnVhodClick().login(Pred1);
			if (app.cabPred.verifyStatus(Constants.statusRabPrin) == false) {
				System.out.println("Есть текущая заявка. Регистрируем нового предпринимателя");
				Element.sl(2);
				app.cabPred.btnExit.click();
				Element.sl(2);
				UserPred user = new UserPred();
				user.email = app.mail.setMail(user.semiEmail);
				app.audHelper.reg_pred(user);
				this.whatToDo();
				return;
			} else if (app.cabPred.verifyStatus(Constants.statusRabPrin) == true){
				System.out.println("Нет текущей заявки. Создаем новую");
				app.audHelper.create_bid(Pred1).btnVhodClick().login(Pred1);
				assertTrue("Некорректный статус", app.cabPred.verifyStatus(Constants.statusNaProverke));
				Element.sl(2);
				app.cabPred.btnExit.click();
				this.whatToDo();
				return;
			}
		} else {
			System.out.println("Заявка доступна");
		}
	}
}

