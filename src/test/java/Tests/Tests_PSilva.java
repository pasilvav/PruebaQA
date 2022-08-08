package Tests;

import Pages.*;
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

public class Tests_PSilva {
    //Atributos
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private BuscarLibro buscarLibroPage;
    private BuscarEditorial buscarEditorialPage;

    private String url;
    private ArrayList<String> dataCP1;
    private ArrayList<String> dataCP2;
    private ArrayList<String> dataCP3;
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
        dataCP3 = new ArrayList<>();
        homePage = new HomePage(driver);
        homePage.conexionDriver(browser,rutaDriver,propertyDriver);
        loginPage = new LoginPage(homePage.getDriver());
        buscarLibroPage= new BuscarLibro(homePage.getDriver());
        buscarEditorialPage= new BuscarEditorial(homePage.getDriver());
        url = PropertiesDriven.getProperty("url");
        homePage.cargarSitio(url);
        homePage.maximizarBrowser();
    }

    @Test
    public void CP_Login(){
        dataCP1 = DataDriven.getData("CP010_Login_Correcto");
        homePage.irABancaEnLinea();
        //-------------------------
        loginPage.esperarXSegundos(3000);
        loginPage.login(dataCP1.get(1),dataCP1.get(2));
        //-------------------------

    }

    @Test
    public void CP_Buscar_Libro(){
        //-------------------------
        dataCP2 = DataDriven.getData("CP011_Buscar_Libro");
        buscarLibroPage.esperarXSegundos(3000);
        buscarLibroPage.buscarLibro(dataCP2.get(1));
        //-------------------------
        Assert.assertEquals(buscarLibroPage.obtenerUrlPagina(), dataCP2.get(2));
        //-------------------------

    }

    @Test
    public void CP_Buscar_Editorial(){

        //-------------------------
        dataCP3 = DataDriven.getData("CP020_Buscar_Editorial");
        buscarEditorialPage.esperarXSegundos(3000);
        buscarEditorialPage.buscarEditorial(dataCP3.get(1));
        //-------------------------
        Assert.assertEquals(buscarEditorialPage.obtenerUrlPagina(),dataCP2.get(2));
        //-------------------------

    }


    @AfterMethod
    public void postTests(){
        buscarLibroPage.cerrarBrowser();
        buscarEditorialPage.cerrarBrowser();

    }
}
