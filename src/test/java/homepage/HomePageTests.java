package homepage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import base.BaseTests;
import pages.CarrinhoPage;
import pages.LoginPage;
import pages.ModalProdutoPage;
import pages.ProdutoPage;

public class HomePageTests extends BaseTests {
	@Test

	public void testContarProdutos_oitoProdutosDiferentes() {
		carregarPaginaInicial();
		assertThat(homePage.contarProdutos(), is(8));

	}

	@Test

	public void testValidarCarrinhoZerado_ZeroItensNoCarrinho() {
		int produtosNoCarinho = homePage.obterQuantidadeProdutosNoCarrinho();
		assertThat(produtosNoCarinho, is(0));

	}

	ProdutoPage produtoPage;
	String nomeProduto_ProdutoPage;

	@Test

	public void testValidarDetalhesDoProdruto_DescricaoEValorIguais() {
		int indice = 0;
		String nomeProduto_HomePage = homePage.obterNomeProduto(indice);
		String PrecoProduto_HomePage = homePage.obterPrecoProduto(indice);

		System.out.println(nomeProduto_HomePage);
		System.out.println(PrecoProduto_HomePage);

		produtoPage = homePage.ClicarProduto(indice);

	    nomeProduto_ProdutoPage = produtoPage.obterNomeProduto();
		String precoProduto_ProdutoPage = produtoPage.obterPrecoProduto();

		System.out.println(nomeProduto_ProdutoPage);
		System.out.println(precoProduto_ProdutoPage);

		assertThat(nomeProduto_HomePage.toUpperCase(), is(nomeProduto_ProdutoPage.toUpperCase()));
		assertThat(PrecoProduto_HomePage, is(precoProduto_ProdutoPage));

	}

	LoginPage loginPage;

	@Test

	public void testLoginComSucesso_UsuarioLogado() {
		// Clicar no botão Sign In na home page

		 loginPage = homePage.clicarBotaoSingIn();

		// Preencher usuario e senha

		loginPage.preencherEmail("juliana@testando.com");
		loginPage.preencherpassword("juliana");

		// Clicar no botão Sign In para logar

		loginPage.clicarBotaoSignIn();

		// validar se o usuario esta logado de fato

		assertThat(homePage.estaLogado("Juliana Souza"), is(true));

		carregarPaginaInicial();

	}
	ModalProdutoPage modalProdutoPage; 
	@Test

	public void incluirProdutoNoCarrinho_ProdutoIncluidoComSucesso() {

		String tamanhoProduto = "M";
		String corProduto = "Black";
		Integer quantidadeProduto = 2;

		// ---Pré_Condição
		// Usuário_Logado
		if (!homePage.estaLogado("Juliana Souza")) {
			testLoginComSucesso_UsuarioLogado();
		}
		// ---Teste
		// Selecionando_Produto
		testValidarDetalhesDoProdruto_DescricaoEValorIguais();

		// Selecionar_tamanho
		List<String> listaOpcoes = produtoPage.obterOpcoesSelecionada();

		System.out.println(listaOpcoes.get(0));
		System.out.println("tamanho da lista" + listaOpcoes.size());

		produtoPage.selecionarOpcaoDropDown(tamanhoProduto);
		listaOpcoes = produtoPage.obterOpcoesSelecionada();

		System.out.println(listaOpcoes.get(0));
		System.out.println("tamanho da lista" + listaOpcoes.size());

		// Selecionar_cor
		produtoPage.selecionarCorPreta();

		// Selecionar_quantidade
		produtoPage.alterarQuantidade(quantidadeProduto);

		// Adicionar_carrinho
		modalProdutoPage = produtoPage.clicarbotaoAddToCar();

		// Validações

		
		assertTrue(modalProdutoPage.obterMensagemProdutoAdicionado()
				.endsWith("Product successfully added to your shopping cart"));
		
		System.out.println();
		assertThat(modalProdutoPage.obterDescricaoProduto().toUpperCase(), is  (nomeProduto_ProdutoPage.toUpperCase()));
		
		String precoProdutoString = modalProdutoPage.obterPrecoProduto();
		precoProdutoString = precoProdutoString.replace("$", "");
		Double precoProduto = Double.parseDouble(precoProdutoString);

		assertThat(modalProdutoPage.obterTamanhoProduto(), is(tamanhoProduto));
		assertThat(modalProdutoPage.obterCorProduto(), is(corProduto));
		assertThat(modalProdutoPage.obterQuantidadeProduto(), is(Integer.toString(quantidadeProduto)));
		
		String subTotalString = modalProdutoPage.obterSubTotal();
		subTotalString = subTotalString.replace("$", "");
		Double subTotal = Double.parseDouble(subTotalString);
		
		Double subtotalCalculado = quantidadeProduto * precoProduto;
		
		assertThat(subTotal, is(subtotalCalculado));

	}
 @Test
 
 public void IrParaCarrinho_IformacoesPersistidas() {
	 //--Pré_condições 
	 //ProdutoPage Incluido na tela ModalProdutoPage
	 
	 incluirProdutoNoCarrinho_ProdutoIncluidoComSucesso(); 

	 CarrinhoPage carrinhoPage = modalProdutoPage.clicarBotaoProceedToCheckout();
	 
	 //Teste
	 //Validar todos elementos da tela 
 } 
 }
