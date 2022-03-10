package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarrinhoPage {
	private static  WebDriver driver;
	
	private By nomeProduto = By.cssSelector("div.product-line-info a");
	
	
	public CarrinhoPage(WebDriver driver) {
		 CarrinhoPage.driver = driver;
		}
	

}
