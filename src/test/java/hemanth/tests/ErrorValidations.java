package hemanth.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import hemanth.SelenuiumFrameworkDesign.PageObjects.CheckOutPage;
import hemanth.SelenuiumFrameworkDesign.PageObjects.ConfirmationPage;
import hemanth.SelenuiumFrameworkDesign.PageObjects.ProductCatalog;
import hemanth.SelenuiumFrameworkDesign.PageObjects.cartPage;
import hemanth.TestComponents.BaseTest;

public class ErrorValidations extends BaseTest {

	@Test(groups = { "ErrorHandling" }, retryAnalyzer= hemanth.TestComponents.Retry.class)
	public void LoginErrorValidation() throws IOException {
		// TODO Auto-generated method stub

		landingpage.loginApplication("Keerthana077@gmail.om", "Keerthana077@");

		System.out.println(landingpage.getErrorMessage());
		Assert.assertEquals("Incorrect email r password.", landingpage.getErrorMessage());

	}

	@Test

	public void ProductErrorValidation() throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		String productName = "IPHONE 13 PRO";

		ProductCatalog productCatalog = landingpage.loginApplication("Keerthana077@gmail.com", "Keerthana077@");

		List<WebElement> products = productCatalog.getProductList();

		productCatalog.addProductToCart(productName);

		cartPage cartpage = productCatalog.goToCartPage();
		
	//	Thread.sleep(2000);
	//	boolean match = cartpage.verifyProductDisplay(productName);
		
	//	Assert.assertTrue(match);

	}

}
