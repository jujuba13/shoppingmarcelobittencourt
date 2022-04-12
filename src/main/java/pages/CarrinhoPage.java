package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarrinhoPage {
	private static WebDriver driver;

	private By nomeProduto = By.cssSelector(".product-line-info a");
	private By precoProduto = By.cssSelector("span.price");
	private By tamanhoProduto = By
			.xpath("//div[contains(@class, 'product-line-grid-body')]//div[3]/span[contains(@class, 'value')]");
	private By corProduto = By
			.xpath("//div[contains(@class, 'product-line-grid-body')]//div[4]/span[contains(@class, 'value')]");
	private By input_quantidadeProduto = By.cssSelector("input.js-cart-line-product-quantity");
	private By subtotalProduto = By.cssSelector("span.product-price strong");
	private By numeroItensTotal = By.cssSelector("span.js-subtotal");
	private By subtotalTotal = By.cssSelector("#cart-subtotal-products span.value");
	private By shippingTotal = By.cssSelector("#cart-subtotal-shipping span.value");
	private By totalTaxExlTotal = By
			.cssSelector("div.cart-sumary-toatals div.cart-sumary-line:nth-child(1) span.value");
	private By totalTaxIncTotal = By.cssSelector("iv.cart-sumary-toatals div.cart-sumary-line:nth-child(2) span.value");
	private By taxesTotal = By.cssSelector("div.cart-sumary-totals div.cart-sumary-line:nth-child(3) span.value");
	
	private By botaoProceedToCheckout = By.cssSelector("a.btn-primary");
	

	public CarrinhoPage(WebDriver driver) {
		CarrinhoPage.driver = driver;
	}

	
	public String obter_nomeProduto() {
		return driver.findElement(nomeProduto).getText();
	}
	
	
	
	public String obter_precoProduto() {
		return driver.findElement(precoProduto).getText();
		
	}
	 
	
	public String obter_tamanhoProduto() {
		return driver.findElement(tamanhoProduto).getText();
	}
	
	
	
	public String obter_corProduto() {
		return driver.findElement(corProduto).getText();
	}
	
	
	public String obter_input_quantidadeProduto() {
		return driver.findElement(input_quantidadeProduto).getAttribute("value");
	}
	
	
	public String obter_subtotalProduto() {
		return driver.findElement(subtotalProduto).getText();
	}
	
	
	public String obter_numeroItensTotal() {
		return driver.findElement(numeroItensTotal).getText();
	}
	
	
	public String obter_subtotalTotal() {
		return driver.findElement(subtotalTotal).getText();
	}
	
	
	public String obter_shippingTotal() {
		return driver.findElement(shippingTotal ).getText();
	}
	
    
    public String obter_totalTaxExlTotal() {
		return driver.findElement(totalTaxExlTotal).getText();
	}
	
	
	public String obter_totalTaxIncTotal() {
		return driver.findElement(totalTaxIncTotal).getText();
	}
	
	
	public String obter_taxesTotal() {
		return driver.findElement(taxesTotal).getText();
	}
	
	public  CheckoutPage clicarBotaoProceedToChekout() {
		driver.findElement(botaoProceedToCheckout).click();
		return new CheckoutPage(driver);
	}
}
