package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class HomePage {
	private static WebDriver driver;
	
	List<WebElement> listaProdutos = new ArrayList<>();
	private By produtos = By.className("product-description");
	private By descricoesDosProdutos = By.cssSelector(".product-description a");
	private By textoProdutosNoCarrinho = By.className("cart-products-count");
	private By precoDosProdutos = By.className("price");
    private By botaoSingIn = By.cssSelector("#_desktop_user_info span.hidden-sm-down");
    private By ususarioLogado = By.cssSelector("#_desktop_user_info span.hidden-sm-down");
	
		
	
	
	
     public  HomePage(WebDriver driver) {
	
	this.driver = driver;
		
}
	
public int contarProdutos() {
	carregarListaProdutos();
	return listaProdutos.size();
	
}

private void carregarListaProdutos() {
	listaProdutos = driver.findElements(produtos);
	
}
public int obterQuantidadeProdutosNoCarrinho() {
	String quantidadeProdutosNoCarrinho = driver.findElement(textoProdutosNoCarrinho).getText();
			quantidadeProdutosNoCarrinho = quantidadeProdutosNoCarrinho.replace("(", "");
	        quantidadeProdutosNoCarrinho = quantidadeProdutosNoCarrinho.replace(")", "");
	int qtdProdutosNoCarrinho = Integer.parseInt(quantidadeProdutosNoCarrinho);
	   return qtdProdutosNoCarrinho;
	
}
	public String obterNomeProduto(int indice) {
		return driver.findElements(descricoesDosProdutos).get(indice).getText().toString();
	 }
	
	
public String obterPrecoProduto(int indice) {
	return driver.findElements(precoDosProdutos).get(indice).getText().toString();	
	
}

public ProdutoPage ClicarProduto(int indece) {
	driver.findElements(descricoesDosProdutos).get(indece).click();
	return new ProdutoPage(driver);
}

public LoginPage clicarBotaoSingIn() {
	driver.findElement(botaoSingIn).click();
	return new LoginPage(driver);
	}

public boolean estaLogado(String texto) {
	 return texto.contentEquals(driver.findElement(ususarioLogado).getText().toString());
}

}
