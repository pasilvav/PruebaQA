package Pages;

import Utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditarDatosFacturacion extends BaseClass {
    public EditarDatosFacturacion(WebDriver driver) {
        super(driver);
    }

    //Centralizar los localizadores

    By locatorBtnHola= By.xpath("//h6[contains(text(),'Hola Patricia')]");
    By locatorBtnFacturacion= By.xpath("//body/div[1]/section[1]/section[1]/div[1]/div[1]/div[1]/div[4]/ul[1]/li[4]/a[1]");
    By locatorTxtRut= By.xpath("//body/div[1]/section[1]/section[1]/div[1]/div[2]/div[7]/form[1]/div[1]/div[2]/input[1]");
    By locatorTxtRazonSocial= By.xpath ("//body/div[1]/section[1]/section[1]/div[1]/div[2]/div[7]/form[1]/div[2]/div[2]/input[1]");
    By locatorTxtGiro= By.xpath ("//body/div[1]/section[1]/section[1]/div[1]/div[2]/div[7]/form[1]/div[3]/div[2]/input[1]");
    By locatorBtnGuardar= By.xpath("//body/div[1]/section[1]/section[1]/div[1]/div[2]/div[7]/form[1]/div[8]/div[1]/button[1]");



    public void editarDatosFacturacion(String rut, String razonsocial, String giro){

        click(esperaExplicita(locatorBtnHola));

        click(esperaExplicita(locatorBtnFacturacion));

        esperarXSegundos(3000);
        limpiarTexto(esperaExplicita(locatorTxtRut));
        agregarTexto(esperaExplicita(locatorTxtRut),rut);

        limpiarTexto(esperaExplicita(locatorTxtRazonSocial));
        agregarTexto(esperaExplicita(locatorTxtRazonSocial),razonsocial);

        limpiarTexto(esperaExplicita(locatorTxtGiro));
        agregarTexto(esperaExplicita(locatorTxtGiro),giro);

        esperarXSegundos(3000);
        click(esperaExplicita(locatorBtnGuardar));
        esperarXSegundos(3000);

    }
}
