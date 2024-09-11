package hemanth.SelenuiumFrameworkDesign.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hemanth.SelenuiumFrameworkDesign.AbstractComponents.AbstractComponents;

public class cartPage extends AbstractComponents {

	WebDriver driver;

	public cartPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class ='cartSection'] /h3")
	List<WebElement> cartProducts;
	
	@FindBy(css = ".totalRow button")
	WebElement checkOutEle;
	
	public Boolean verifyProductDisplay(String productName) {

		boolean match = cartProducts.stream()
				.anyMatch(product -> product.getText().equalsIgnoreCase(productName));
		return match;
	}

	public CheckOutPage goToCheckOut()
	{
		checkOutEle.click();
		return new CheckOutPage(driver);
	}

}
