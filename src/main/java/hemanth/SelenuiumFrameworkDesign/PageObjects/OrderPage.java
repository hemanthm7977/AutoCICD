package hemanth.SelenuiumFrameworkDesign.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hemanth.SelenuiumFrameworkDesign.AbstractComponents.AbstractComponents;

public class OrderPage extends AbstractComponents {

	WebDriver driver;

	public OrderPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "tr td:nth-child(3)")
	List<WebElement> orderPrdoucts;
	
	@FindBy(css = ".totalRow button")
	WebElement checkOutEle;
	
	public Boolean verifyOrderDisplay(String productName) {

		boolean match = orderPrdoucts.stream()
				.anyMatch(product -> product.getText().equalsIgnoreCase(productName));
		return match;
	}

}
