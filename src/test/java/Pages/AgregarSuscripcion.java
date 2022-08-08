package Pages;

import Utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AgregarSuscripcion extends BaseClass {
    public AgregarSuscripcion(WebDriver driver) {
        super(driver);
    }

    //Centralizar los localizadores

    By locatortxtEmailSubs= By.xpath ("//input[@id='emailSubs']");
    By locatorbtnRecibirOfertas=By.xpath("//body/div[1]/footer[1]/section[1]/section[1]/div[1]/div[4]/div[1]/form[1]/span[1]/input[2]");

    public void agregarSuscripcion(String email){
        agregarTexto(esperaExplicita(locatortxtEmailSubs),email);
        esperarXSegundos(3000);
        click(esperaExplicita(locatorbtnRecibirOfertas));
    }
}
