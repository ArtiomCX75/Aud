package main.java.audHelpers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import main.java.audPages.ApplicationManager;

public class Element   {
	public String xp;
	private static WebDriver wd;
	public static Double t = 0.250;
	@SuppressWarnings("unused")
	private ApplicationManager manager;

	public Element(String s) {
		this.xp = s;
		
	}

	public Element(ApplicationManager manager) {
		this.manager = manager;
		wd = manager.Driver;
		
	}

	public void click(){
		sl(t);
		/*boolean present=false;;
		while (present==false){
			try {
				wd.findElement(By.xpath(xp));
				present = true;
				//System.out.println("true "+xp);
				} 
			catch (NoSuchElementException e) {
				present = false;
				System.out.println("false "+xp);
			}
		}*/
		wd.findElement(By.xpath(xp)).click();
		sl(t);
	}

	@SuppressWarnings("unused")
	private void safeClick() {
		sl(t);
		WebElement webElement = wd.findElement(By.xpath(xp)); 
		if(webElement != null) {
			wd.findElement(By.xpath(xp)).click();
		}
		else 
		{
			System.out.println("q");
			safeClick();
		}
	}
	
	
	public void clear() {
		wd.findElement(By.xpath(xp)).clear();
	}

	public String getTagName() {
		return wd.findElement(By.xpath(xp)).getTagName();
	}

	public String getText() {
		return wd.findElement(By.xpath(xp)).getText();
	}

	public boolean isDisplayed() {
		return wd.findElement(By.xpath(xp)).isDisplayed();
	}

	public boolean isEnabled() {
		return wd.findElement(By.xpath(xp)).isEnabled();
	}

	public boolean isSelected() {
		return wd.findElement(By.xpath(xp)).isSelected();
	}

	public void sendKeys(CharSequence... arg0) {
		sl(t);
		wd.findElement(By.xpath(xp)).sendKeys(arg0);
		sl(t);
		
	}

	public void submit() {
		wd.findElement(By.xpath(xp)).submit();

	}

	public String getAttribute(String arg0) {
		return wd.findElement(By.xpath(xp)).getAttribute(arg0);
	}
	
	public static void sl(double d) { 
		d = d * 1000;
		int i = (int) d;
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
		e.printStackTrace();
		}
	}

	public static String what_date(String i) { // узнает дату
		Date d = new Date();
		SimpleDateFormat format1;
		if (i == "post") {
			//format1 = new SimpleDateFormat("dd_MM_yyyy_kk_mm"); // дата для
			format1 = new SimpleDateFormat("ddMMyykkmmss");	// почты
		} else {
			format1 = new SimpleDateFormat("dd.MM.yyyy"); // дата для поля
															// "дата"
		}
		return format1.format(d);
	}
	/*
	 * @Override public <X> X getScreenshotAs(OutputType<X> arg0) throws
	 * WebDriverException { // Auto-generated method stub return null; }
	 * 
	 * public WebElement findElement(By arg0) { // Auto-generated method stub
	 * return null; }
	 * 
	 * @Override public List<WebElement> findElements(By arg0) { //
	 * Auto-generated method stub return null; }
	 * 
	 * @Override
	 * 
	 * 
	 * @Override public String getCssValue(String arg0) { // Auto-generated
	 * method stub return null; }
	 * 
	 * @Override public Point getLocation() { // Auto-generated method stub
	 * return null; }
	 * 
	 * @Override public Dimension getSize() { // Auto-generated method stub
	 * return null; }
	 * 
	 * 
	 */
}
///////////// JS

//JavascriptExecutor js = (JavascriptExecutor) Browser.driver;
//WebElement element =
//Browser.driver.findElement(By.xpath("//input[starts-with(@type,'file')][starts-with(@accept,'ap')]"));
//js.executeScript("arguments[0].setAttribute('style', 'position: absolute;
//width: 0px; height: 0px; z-index: -100000; border: none; margin: 0px;
//padding: 0px;')",element);
/*
public void sudo_sendkeys(WebElement el, String s ) {
	Actions actions = new Actions(driver);
	actions.moveToElement(el);
	actions.click();
	actions.sendKeys(s);
	actions.build().perform();
	}

public void sudo_click(WebElement el) {
	Actions actions = new Actions(driver);
	actions.moveToElement(el);
	actions.click();
	actions.build().perform();
	}
	
	
	public void sql(String sql)
{// Create a variable for the connection string.
String connectionUrl = "jdbc:sqlserver://192.168.0.105:1433;" +
   "databaseName=Discounter;user=sa;password=12345";

// Declare the JDBC objects.
Connection con = null;
Statement stmt = null;
ResultSet rs = null;

try {
   // Establish the connection.
   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
   con = DriverManager.getConnection(connectionUrl);

   // Create and execute an SQL statement that returns some data.
   stmt = con.createStatement();
   rs = stmt.executeQuery(sql);

   // Iterate through the data in the result set and display it.
   //while (rs.next()) {
    //  System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5));
   }
}

// Handle any errors that may have occurred.
catch (Exception e) {
   e.printStackTrace();
}
finally {
   if (rs != null) try { rs.close(); } catch(Exception e) {}
   if (stmt != null) try { stmt.close(); } catch(Exception e) {}
   if (con != null) try { con.close(); } catch(Exception e) {}
}
}
*/
