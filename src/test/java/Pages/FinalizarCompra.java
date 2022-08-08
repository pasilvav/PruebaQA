package Pages;

import Utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FinalizarCompra extends BaseClass {
    public FinalizarCompra(WebDriver driver) {
        super(driver);
    }

    //Centralizar los localizadores

    By locatorBtnCarroCompra= By.xpath ("//label[contains(text(),'Carro de compras')]");
    By locatorBtnFinalizarCompra=By.xpath("//a[contains(text(),'Finalizar compra')]");
    By locatorBtnEnviar= By.xpath("//body/section[@id='carro']/div[1]/div[1]/div[2]/div[3]/div[1]/button[1]");

    By locatorbtnVolver= By.xpath("//header/article[@id='header-top']/div[@id='logo']/a[1]/img[1]");

    public void finalizarCompra(String pagina){
        esperarXSegundos(3000);
        click(esperaExplicita(locatorBtnCarroCompra));
        esperarXSegundos(3000);
        click(esperaExplicita(locatorBtnFinalizarCompra));
        esperarXSegundos(3000);
        click(esperaExplicita(locatorBtnEnviar));
        esperarXSegundos(3000);
        click(esperaExplicita(locatorbtnVolver));
    }
}
