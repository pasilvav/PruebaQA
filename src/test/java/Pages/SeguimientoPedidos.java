package Pages;

import Utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeguimientoPedidos extends BaseClass {
    public SeguimientoPedidos(WebDriver driver) {
        super(driver);
    }

    //Centralizar los localizadores

    By locatorBtnHola= By.xpath("//h6[contains(text(),'Hola Patricia')]");
    By locatorBtnSeguimiento= By.xpath ("//body/div[1]/section[1]/section[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]");

    public void seguimientoPedidos(){

        click(esperaExplicita(locatorBtnHola));
        esperarXSegundos(3000);
        click(esperaExplicita(locatorBtnSeguimiento));

    }
}
