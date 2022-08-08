package Pages;

import Utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CentroDeSoporte extends BaseClass {
    public CentroDeSoporte(WebDriver driver) {
        super(driver);
    }

    //Centralizar los localizadores

    By locatorBtnSolicitarAyuda= By.xpath("//button[contains(text(),'Ir a Centro de Soporte')]");
    By locatorBtnContactar= By.xpath("//button[contains(text(),'Contactar con Servicio al Cliente')]");
    By locatorBtnSi= By.xpath("//button[contains(text(),'SI')]");
    By locatorBtnVolverMenu= By.xpath("//header/section[2]/section[1]/div[1]/div[1]/div[1]/div[2]/a[1]/img[1]");

    public void centroDeSoporte(){

        click(esperaExplicita(locatorBtnSolicitarAyuda));
        esperarXSegundos(3000);
        click(esperaExplicita(locatorBtnContactar));
        esperarXSegundos(3000);
        click(esperaExplicita(locatorBtnSi));
        esperarXSegundos(3000);
        click(esperaExplicita(locatorBtnVolverMenu));

    }
}
