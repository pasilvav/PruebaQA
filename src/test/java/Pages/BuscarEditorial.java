package Pages;

import Utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BuscarEditorial extends BaseClass {
    public BuscarEditorial(WebDriver driver) {
        super(driver);
    }

    //Centralizar los localizadores
    By locatorBtnLibro=By.xpath("//header/section[1]/section[1]/nav[1]/ul[1]/li[2]/a[1]");
    By locatorTxtEditorial= By.xpath("//body/div[1]/section[1]/div[2]/section[1]/div[1]/div[1]/input[1]");
    By locatorBtnEditorial= By.xpath("//body/div[1]/section[1]/div[2]/section[1]/div[1]/div[2]/a[2]/div[1]/p[1]");

    public void buscarEditorial(String editorial){
        esperarXSegundos(3000);
        click(esperaExplicita(locatorBtnLibro));
        esperarXSegundos(3000);
        agregarTexto(esperaExplicita(locatorTxtEditorial),editorial);
        esperarXSegundos(3000);
        click(esperaExplicita(locatorBtnEditorial));
        esperarXSegundos(3000);

    }
}
