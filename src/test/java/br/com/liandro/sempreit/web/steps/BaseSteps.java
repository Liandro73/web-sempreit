package br.com.liandro.sempreit.web.steps;

import br.com.liandro.sempreit.web.page.BasePage;
import br.com.liandro.sempreit.web.page.CartPageObject;
import br.com.liandro.sempreit.web.page.LoginPageObject;
import br.com.liandro.sempreit.web.page.ProductPageObject;
import br.com.liandro.sempreit.web.utils.Utils;

public class BaseSteps {

    private Utils utils = new Utils();
    BasePage basePage;
    public LoginPageObject loginPageObject;
    public ProductPageObject productPageObject;
    public CartPageObject cartPageObject;

    public BaseSteps() {
        utils.setUp();
        this.basePage = new BasePage(utils.driver);
        this.loginPageObject = basePage.getLoginPageObject();
        this.productPageObject = basePage.getProductPageObject();
        this.cartPageObject = basePage.getCartPageObject();
    }

}
