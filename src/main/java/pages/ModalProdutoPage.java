package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;


public class ModalProdutoPage {
	private static WebDriver driver;
	private By mensagemProdutoAdicionado = By.id("myModalLabel");
	private By descricaoProdruto = By.className("product-name");
	private By precoProduto = By.cssSelector("div.modal-body p.product-price");
	private By listaValoresInformados = By.cssSelector("div.divide-right .col-md-6:nth-child(2) span strong");
	private By subTotal = By.cssSelector(".cart-content p:nth-child(2) span.value");
	private By clicarBotaoProceedToCheckout = By.cssSelector("div.cart-content-btn a.btn-primary");
	
	

	public ModalProdutoPage(WebDriver driver) {
		ModalProdutoPage.driver = driver;
		}
	
	
	public String obterMensagemProdutoAdicionado() {
	
		
		FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mensagemProdutoAdicionado));
		return driver.findElement(mensagemProdutoAdicionado).getText();
	}
	
	public String obterDescricaoProduto() {
		return driver.findElement(descricaoProdruto).getText();

	}
	
	public String obterPrecoProduto() {
		return driver.findElement(precoProduto).getText();
	}
	
	public String obterTamanhoProduto() {
		return driver.findElements(listaValoresInformados).get(0).getText();
		
	}
	
	public String obterCorProduto() {
		return driver.findElements(listaValoresInformados).get(1).getText();
		
	}
		
		public String obterQuantidadeProduto() {
			return driver.findElements(listaValoresInformados).get(2).getText();
		}
	
		public String obterSubTotal() {
			return driver.findElement(subTotal).getText();
			
			}
		
		public CarrinhoPage clicarBotaoProceedToCheckout() {
			driver.findElement(clicarBotaoProceedToCheckout).click();
			return CarrinhoPage(driver);
		}


		private CarrinhoPage CarrinhoPage(WebDriver driver2) {
			// TODO Auto-generated method stub
			return null;
		}


		

}


		
