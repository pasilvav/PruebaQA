package Pages;

import Utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BaseClass {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Centralizar los localizadores
    //By locatorBtnRegistrarse= By.xpath("//p[contains(text(),'Ingresa o Regístrate')]");
    By locatorTxtUserName = By.xpath("//input[@id='signin_username']");
    By locatorBtnContinuar=By.id("submit_login");
    By locatorTxtPassword = By.xpath("//input[@id='signin_password']");
    By locatorBtnIngresarLogin= By.xpath("//button[contains(text(),'Ingresar')]");



    //Definir las acciones de la Página
    public void login(String user, String pass){
        esperarXSegundos(2000);
        System.out.println(user);
        System.out.println(pass);
        agregarTexto(esperaExplicita(locatorTxtUserName),user);
        click(esperaExplicita(locatorBtnContinuar));
        esperarXSegundos(3000);
        agregarTexto(esperaExplicita(locatorTxtPassword),pass);
        click(esperaExplicita(locatorBtnIngresarLogin));
    }
}
