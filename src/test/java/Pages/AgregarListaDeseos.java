package Pages;

import Utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AgregarListaDeseos extends BaseClass {
    public AgregarListaDeseos(WebDriver driver) {
        super(driver);
    }

    //Centralizar los localizadores

    By locatorTxtBuscar= By.xpath("//header/section[2]/section[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/input[1]");
    By locatorBtnBuscar= By.xpath ("//header/section[2]/section[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/button[1]");
    By locatorBtnListaDeseos=By.xpath("//body/div[1]/section[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/form[1]/button[1]/div[1]/div[1]");
    By locatorTxtNombreLista= By.xpath("//body/div[4]/form[1]/select[1]");
    By locatorBtnAgregar= By.xpath("//body/div[4]/form[1]/button[1]");
    //By locatorBtnCerrar= By.xpath("//body/div[5]/i[1]");




    public void agregarListaDeseos(String libro){
        agregarTexto(esperaExplicita(locatorTxtBuscar),libro);
        esperarXSegundos(3000);
        click(esperaExplicita(locatorBtnBuscar));
        esperarXSegundos(3000);
        click(esperaExplicita(locatorBtnListaDeseos));
        agregarTexto(esperaExplicita(locatorTxtNombreLista),"ListaPati(1)");
        esperarXSegundos(3000);
        click(esperaExplicita(locatorBtnAgregar));
        esperarXSegundos(3000);
    }
}
