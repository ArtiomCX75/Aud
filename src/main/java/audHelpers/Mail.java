package main.java.audHelpers;

public interface Mail {
	public Object open();
	public String getEmail() throws Exception;
	public String setMail(String s);
	public UserAud readMail_aud_reg(UserAud user);
	public void recPass(User user);
	public void wlcmLttrReadDel(UserAud user);
}
