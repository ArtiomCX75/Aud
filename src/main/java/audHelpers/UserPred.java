package main.java.audHelpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

@SuppressWarnings("serial")
public class UserPred extends User {
	public int[] urSusch = new int[9];
	public String orgName;
	public String contactName;
	public String genDir;
	public String vidDej;
	public String usualPhone;
	public String ogrn;
	public String orderNumber;

	public UserPred() {
		this.setDefault();
		semiEmail = "pred" + Element.what_date("post");
		contactName = contactName + Element.what_date("post");
	}

	private void setDefault() {
		name = "Ivan";
		middleName = "Ivanovich";
		surName = "Ivanov";
		email = "faa1192@gmail.com";
		password = "123456";
		phoneNumber = "9172890647";
		orgName = "OOO DefaultName";
		contactName = "Петров Пётр Петрович";
		genDir = "Иванов Иван Иванович";
		vidDej = "производство";
		usualPhone = "9172890647";
		urSusch[0] = 10;
		urSusch[1] = 20;
		urSusch[2] = 30;
		urSusch[3] = 40;
		urSusch[4] = 50;
		urSusch[5] = 60;
		urSusch[6] = 70;
		urSusch[7] = 80;
		FIO = surName + " " + name + " " + middleName;
		index = "420042";
		region = "Татарстан";
		city = "Казань";
		street = "Баумана";
		house = "21";
		building = "1";
		flat = "2";
		ogrn = "1234567890123";
	}

	static FileInputStream fis;
	static ObjectInputStream oin;

	public static UserPred readLast() {
		UserPred user = null;
		try {
			fis = new FileInputStream("temp_pred.txt");
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		ObjectInputStream oin = null;
		try {
			oin = new ObjectInputStream(fis);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			user = (UserPred) oin.readObject();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			oin.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("P email= " + user.email);
		System.out.println("P pass= " + user.password);
		return user;
	}

}
