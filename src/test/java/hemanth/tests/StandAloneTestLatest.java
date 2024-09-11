package hemanth.tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import hemanth.SelenuiumFrameworkDesign.PageObjects.CheckOutPage;
import hemanth.SelenuiumFrameworkDesign.PageObjects.ConfirmationPage;
import hemanth.SelenuiumFrameworkDesign.PageObjects.OrderPage;
import hemanth.SelenuiumFrameworkDesign.PageObjects.ProductCatalog;
import hemanth.SelenuiumFrameworkDesign.PageObjects.cartPage;
import hemanth.TestComponents.BaseTest;

public class StandAloneTestLatest extends BaseTest {

	String productName = "IPHONE 13 PRO";

	@Test(dataProvider = "getData", groups = { "Purchase" })
	public void StandAloneTestLatest(HashMap<String, String> input) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		ProductCatalog productCatalog = landingpage.loginApplication(input.get("email"), input.get("password"));

		List<WebElement> products = productCatalog.getProductList();

		productCatalog.addProductToCart(input.get("productName"));

		cartPage cartpage = productCatalog.goToCartPage();

		boolean match = cartpage.verifyProductDisplay(input.get("productName"));
		Assert.assertTrue(match);

		CheckOutPage checkoutpage = cartpage.goToCheckOut();
		checkoutpage.selectCountry("India");

		ConfirmationPage confirmationpage = checkoutpage.submitOrder();
		String confirmMessage = confirmationpage.getCoinfirmationMessage();

		Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));

	}

	@Test(dependsOnMethods = { "StandAloneTestLatest" })
	public void orderHistoryTest() {
		ProductCatalog productCatalog = landingpage.loginApplication("Keerthana077@gmail.com", "Keerthana077@");
		OrderPage orderpage = productCatalog.goToOrderPage();
		Assert.assertTrue(orderpage.verifyOrderDisplay(productName));

	}
	


	@DataProvider
	public Object[][] getData() throws IOException {
		/*
		 * HashMap<String, String> map = new HashMap<String, String>(); map.put("email",
		 * "Keerthana077@gmail.com"); map.put("password", "Keerthana077@");
		 * map.put("productName", "IPHONE 13 PRO");
		 * 
		 * HashMap<String, String> map1 = new HashMap<String, String>();
		 * map1.put("email", "Keerthana077@gmail.com"); map1.put("password",
		 * "Keerthana077@"); map1.put("productName", "ADIDAS ORIGINAL");
		 */

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "\\src\\test\\java\\hemanth\\data\\PurchaseOrder.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}

}
