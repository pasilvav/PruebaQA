package Pages;

import Utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BuscarLibro extends BaseClass {
    public BuscarLibro(WebDriver driver) {
        super(driver);
    }

    //Centralizar los localizadores

    By locatorTxtNombreLibro = By.xpath("//header/section[2]/section[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/input[1]");
    By locatorBtnBuscarLibro=By.xpath("//header/section[2]/section[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/button[1]");
    public void buscarLibro(String libro){
        esperarXSegundos(3000);
        agregarTexto(esperaExplicita(locatorTxtNombreLibro),libro);
        esperarXSegundos(3000);
        click(esperaExplicita(locatorBtnBuscarLibro));
        esperarXSegundos(3000);

    }
}
