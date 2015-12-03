package audHelpers;

@SuppressWarnings("serial")
public class User implements java.io.Serializable  {
	public String email;
	public String semiEmail;
	public String password;
	public String phoneNumber;
	public String name;
	public String middleName;
	public String surName;
	public String FIO=name+" "+middleName+" "+surName;
	public String index;
	public String region;
	public String city;
	public String street;
	public String house;
	public String building;
	public String flat;

public static User makeAdmin(){
	User user = new User();
	user.email="admin";
	user.password="Maxpass5";
	return user;
}

}