package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(id = "user-name")
    public static WebElement inputUsername;
    @FindBy(id = "password")
    public static WebElement inputSenha;
    @FindBy(id = "login-button")
    public static WebElement btnLogin;
    @FindBy(className = "login_logo")
    public static WebElement logoPaginaInicial;

}
