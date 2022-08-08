package Pages;

import Utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditarDatosPersonales extends BaseClass {
    public EditarDatosPersonales(WebDriver driver) {
        super(driver);
    }

    //Centralizar los localizadores
    By locatorBtnHola= By.xpath("//h6[contains(text(),'Hola Patricia')]");
    By locatorTxtNombre = By.xpath("//body/div[1]/section[1]/section[1]/div[1]/div[2]/div[3]/form[1]/div[1]/div[2]/input[1]");
    By locatorTxtApellido= By.xpath("//body/div[1]/section[1]/section[1]/div[1]/div[2]/div[3]/form[1]/div[2]/div[2]/input[1]");
    By locatorTxtDia=By.xpath("//body/div[1]/section[1]/section[1]/div[1]/div[2]/div[3]/form[1]/div[4]/div[2]/select[1]");
    By locatorTxtMes=By.xpath("//body/div[1]/section[1]/section[1]/div[1]/div[2]/div[3]/form[1]/div[4]/div[2]/select[2]");
    By locatorTxtAnno=By.xpath("//body/div[1]/section[1]/section[1]/div[1]/div[2]/div[3]/form[1]/div[4]/div[2]/select[3]");
    By locatorBtnGuardar= By.xpath("//body/div[1]/section[1]/section[1]/div[1]/div[2]/div[3]/form[1]/div[5]/div[1]/button[1]");


    public void editarDatosPersonales(String nombre, String apellido, String dia, String mes, String anno){
        click(esperaExplicita(locatorBtnHola));

        limpiarTexto(esperaExplicita(locatorTxtNombre));
        agregarTexto(esperaExplicita(locatorTxtNombre),nombre);
        esperarXSegundos(3000);

        limpiarTexto(esperaExplicita(locatorTxtApellido));
        agregarTexto(esperaExplicita(locatorTxtApellido),apellido);
        esperarXSegundos(3000);
        agregarTexto(esperaExplicita(locatorTxtDia),dia);
        esperarXSegundos(3000);
        agregarTexto(esperaExplicita(locatorTxtMes),mes);
        esperarXSegundos(3000);
        agregarTexto(esperaExplicita(locatorTxtAnno),anno);
        esperarXSegundos(3000);
        click(esperaExplicita(locatorBtnGuardar));
        esperarXSegundos(3000);


    }
}
