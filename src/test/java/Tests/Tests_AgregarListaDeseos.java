package Tests;

import Pages.AgregarListaDeseos;
import Pages.EditarDatosPersonales;
import Pages.HomePage;
import Pages.LoginPage;
import Utils.DataDriven;
import Utils.PropertiesDriven;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.file.Paths;
import java.util.ArrayList;

public class Tests_AgregarListaDeseos {
    //Atributos
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private AgregarListaDeseos listaDeseos;

    private String url;
    private ArrayList<String> dataCP1;
    private ArrayList<String> dataCP2;
    private String browser;
    private String propertyDriver;
    private String rutaDriver;


    //Métodos
    @BeforeTest
    public void preparacion(){
        browser = PropertiesDriven.getProperty("browser");
        propertyDriver = PropertiesDriven.getProperty("propertyDriver");
        rutaDriver = Paths.get(System.getProperty("user.dir"),PropertiesDriven.getProperty("rutaDriver")).toString();
    }

    @BeforeMethod
    public void preTests(){
        dataCP1 = new ArrayList<>();
        dataCP2 = new ArrayList<>();
        homePage = new HomePage(driver);
        homePage.conexionDriver(browser,rutaDriver,propertyDriver);
        loginPage = new LoginPage(homePage.getDriver());
        listaDeseos= new AgregarListaDeseos(homePage.getDriver());
        url = PropertiesDriven.getProperty("url");
        homePage.cargarSitio(url);
        homePage.maximizarBrowser();
    }

    @Test
    public void CP_AgregarListaDeseos(){
        dataCP1 = DataDriven.getData("CP010_Login_Correcto");
        homePage.irABancaEnLinea();
        //-------------------------
        loginPage.esperarXSegundos(3000);
        loginPage.login(dataCP1.get(1),dataCP1.get(2));
        //-------------------------
        dataCP2 = DataDriven.getData("CP013_Agregar_Lista_Deseos");
        listaDeseos.esperarXSegundos(3000);
        listaDeseos.agregarListaDeseos(dataCP2.get(1));
        listaDeseos.esperarXSegundos(3000);
        //-------------------------
        Assert.assertEquals(listaDeseos.obtenerUrlPagina(),dataCP2.get(2));
        listaDeseos.esperarXSegundos(3000);


    }

    @AfterMethod
    public void postTests(){

        listaDeseos.cerrarBrowser();
        //loginPage.cerrarBrowser();
    }
}
