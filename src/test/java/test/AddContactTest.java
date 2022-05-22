package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddContactPage;
import page.DashboardPage;
import page.ListCustomerPage;
import page.LoginPage;
import util.BrowserFactory;


public class AddContactTest {
	
	WebDriver driver;
	
	//@Test
	@Parameters({"userName", "password", "FullName", "CompanyName", "Email", "Phone", "Address", "City", "Country", "State", "Zip"})
	public void validUserShouldBeAbleToAddCustomer(String userName,	String password, String fullName, String companyName, String email,	String phone, String address, String city, String country, String state, String zip) throws InterruptedException {
		
		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickSigninButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage("Dashboard");
		dashboardPage.clickCustomerMenuButton();
		dashboardPage.clickAddCustomerMenuButton();
		
		AddContactPage addContactPage = PageFactory.initElements(driver, AddContactPage.class);
		addContactPage.validateAddContactPage("Add Contact");
		addContactPage.insertFullName(fullName);
		addContactPage.selectCompany(companyName);
		addContactPage.insertEmail(email);
		addContactPage.insertPhone(phone);
		addContactPage.insertAddress(address);
		addContactPage.insertCity(city);
		addContactPage.insertState(state);
		addContactPage.insertZip(zip);
		addContactPage.selectCountry(country);
		addContactPage.clickSaveButton();
		
		dashboardPage.clickListCustomerMenuButton();
		
		addContactPage.varifyInsertedNameAndDelete();
		
		
	}
	
	


}
