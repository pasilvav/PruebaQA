package Pages;

import Utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BaseClass {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Centralizar los localizadores
    //By locatorBtnBcoEnLinea = By.id("intro-step2");
    By locatorBtnBcoEnLinea = By.xpath("//p[contains(text(),'Ingresa o Regístrate')]");

    //Definir las acciones de la Página
    public void irABancaEnLinea(){
        click(esperaExplicita(locatorBtnBcoEnLinea));
    }
}
