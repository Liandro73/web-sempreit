package br.com.liandro.sempreit.web.steps;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class PurchaseSteps extends BaseSteps {

    Scenario scenario;
    String step;

    @Before
    public void setUp(Scenario scenario) {
        this.scenario = scenario;
    }

    @After
    public void finish() {
        if (scenario.isFailed()) {
            loginPageObject.takeScreenshot(scenario, scenario.getName());
        }
        loginPageObject.driverQuit();
    }

    @Dado("que eu esteja na tela de Login {string} {string}")
    public void queEuEstejaNaTelaDeLogin(String portal, String url) {
        step = "Dado que eu esteja na tela de Login";
        loginPageObject.goToURL(url);
        loginPageObject.waitURL(url);
        loginPageObject.checkTitlePage(portal);
        loginPageObject.checkVisibilityOfLogoPageLogin();
        loginPageObject.takeScreenshot(scenario, step);
    }

    @Quando("preencher o campo Usuario {string}")
    public void preencherOCampoUsuario(String usuario) {
        loginPageObject.fillInputUser(usuario);
    }

    @Quando("preencher o campo Senha {string}")
    public void preencherOCampoSenha(String senha) {
        loginPageObject.fillInputPassword(senha);
    }

    @Quando("clicar no botão Login")
    public void clicarNoBotãoLogin() {
        loginPageObject.clickOnButtonLogin();
    }

    @Quando("adicionar um produto ao carrinho")
    public void adicionarUmProdutoAoCarrinho() {
        step = "Quando adicionar um produto ao carrinho";
        productPageObject.checkVisibilityAndClickOnProduct(scenario, step);
        productPageObject.clickOnButtonAddToCart();

    }

    @Quando("ir para o carrinho")
    public void irParaOCarrinho() {
        productPageObject.clickOnButtonCart();
    }

    @Quando("clicar em Checkout")
    public void clicarEmCheckout() {
        cartPageObject.checkTitlePageCart("Your Cart".toUpperCase());
        cartPageObject.clickOnButtonCheckout();
    }

    @Quando("preencher dados solicitados {string} {string} {string}")
    public void preencherDadosSolicitados(String name, String lastName, String postalCode) {
        step = "Quando preencher dados solicitados";
        cartPageObject.checkTitlePageCart("Checkout: Your Information".toUpperCase());
        cartPageObject.fillInputFirstName(name);
        cartPageObject.fillInputLastName(lastName);
        cartPageObject.fillInputPostalCode(postalCode);
        cartPageObject.takeScreenshot(scenario, step);

    }

    @Quando("clicar em Continue")
    public void clicarEmContinue() {
        cartPageObject.clickOnButtonContinue();
    }

    @Quando("validar pagina do pedido")
    public void validarDadosDoPedido() {
        cartPageObject.checkTitlePageCart("Checkout: Overview".toUpperCase());
    }

    @Quando("clicar em finish")
    public void clicarEmFinish() {
        cartPageObject.clickOnButtonFinish();
    }

    @Então("devo validar mensagem de sucesso {string}")
    public void devoValidarMensagemDeSucesso(String msg) {
        step = "Então devo validar mensagem de sucesso";
        cartPageObject.checkMsgPurchaseSucess(msg);
        cartPageObject.takeScreenshot(scenario, step);
    }

}
