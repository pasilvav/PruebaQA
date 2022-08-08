package Pages;

import Utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CerrarSesion extends BaseClass {
    public CerrarSesion(WebDriver driver) {
        super(driver);
    }

    //Centralizar los localizadores

    By locatorBtnUsuario= By.xpath("//header/section[2]/section[1]/div[1]/div[3]/div[3]/a[1]/span[1]");

      By locatorBtnCerrar = By.xpath ("//header/section[2]/section[1]/div[1]/div[3]/div[3]/div[1]/nav[1]/ul[1]/li[2]/a[1]");



    public void cerrarSesion(){
        esperarXSegundos(3000);
        click(esperaExplicita(locatorBtnUsuario));
        esperarXSegundos(3000);
        click(esperaExplicita(locatorBtnCerrar));
        esperarXSegundos(3000);


    }
}
