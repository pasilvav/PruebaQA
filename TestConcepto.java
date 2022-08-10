package cl.patricia.qa.tests;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cl.patricia.qa.helpers.Helper;
import cl.patricia.qa.pages.LoginPage;
import cl.patricia.qa.pages.PaginaPrincipalPage;
import cl.patricia.qa.pages.RegistroPage;



public class TestConcepto {
	private WebDriver driver;
	private ExtentReports extent;
	private ExtentTest test;
	private static String SUBDIR = "AmbienteBase\\";
	private static Boolean TAKE_SS = true;
	private static int WAITING = 10;

	@BeforeSuite
	
	//tenemos la configuraci�n de lo que es el Extent Reports
	//toda esta informaci�n la agrega en el archivo de configuraci�n
	public void configExtentReports() {
		// ExtentReports config
		this.extent = new ExtentReports("ExtentReports/PruebaCurso.html", true);
		this.extent.addSystemInfo("Host Name", "Tecnova Soluciones Informaticas SA");
		this.extent.addSystemInfo("Enviroment", "Automation Testing");
		this.extent.addSystemInfo("User Name", "Heliam Ordejoiti");
        //llamada a objeto de configuracion de Extent report
		//todos los extents reports van atados al archivo de configuraci�n
		
		File conf = new File("src/test/resources/extentReports/" + "extent-config.xml");
		this.extent.loadConfig(conf);
	}

	@BeforeMethod
	@Parameters({ "URL_PRINCIPAL" })
	//todos esto es configuracion
	public void configSelenium(String URL_PRINCIPAL) {
		// Selenium config
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("Empresa", "Tecnova");
		System.setProperty("webdriver.chrome.driver", "DRIVERS/chromedriver.exe");
		//esta es la forma de llamar al Helpers
		Helper.robotMoveMouse(2000, 2000);
		//inicializo el driver
		driver = new ChromeDriver();
		//Implicit Waits No usar si se estan usando explicit wait
		driver.manage().timeouts().implicitlyWait(WAITING, TimeUnit.SECONDS);
		//Maximisar Ventana
		driver.manage().window().maximize();
		//Navegar a url principal
		driver.navigate().to(URL_PRINCIPAL);
	}

	@Test
	@Parameters ({"nombre","apellido","pass"})
	
	public void crearRegistro(String nombre, String apellido,String pass ) {
		String subDir = SUBDIR + Thread.currentThread().getStackTrace()[1].getMethodName();
		test = extent.startTest("Prueba CONCEPTO más", "Probando conceptos MáS.");
		test.log(LogStatus.INFO, "Prueba inicial conceptos");
				//llamo el objeto.
			
		//aca agrega todos los elementos que yo le puse en mi constructor.
		PaginaPrincipalPage principal= new PaginaPrincipalPage(driver, test, TAKE_SS, 20);
		//llamo el m�todo
		principal.clickLogin();
		
		LoginPage login= new LoginPage(driver, test, TAKE_SS, WAITING);
		login.registroMail("pasilvav9999@gmail.com",subDir);
			
		RegistroPage registro= new RegistroPage(driver, test, TAKE_SS, WAITING);
		registro.informacionPersonal(nombre, apellido, pass,subDir);
		registro.informacionDireccion(subDir);
		registro.registrarInformacion();
				
	}
	
	@Test
	public void loginUsuario() {
		String subDir = SUBDIR + Thread.currentThread().getStackTrace()[1].getMethodName();
		test = extent.startTest("Prueba CONCEPTO más", "Probando conceptos MáS.");
		test.log(LogStatus.INFO, "Prueba inicial conceptos");
		PaginaPrincipalPage principal= new PaginaPrincipalPage(driver, test, TAKE_SS, 20);
		//llamo el m�todo
		principal.clickLogin();
		
		LoginPage login= new LoginPage(driver, test, TAKE_SS, WAITING);
		login.enviarLogin();
		login.assertIngreso("MY ACCOUNT");	
		
	}
	
	@Test
	
	public void crearRegistroConTelefonoCasa() {
		String subDir = SUBDIR + Thread.currentThread().getStackTrace()[1].getMethodName();
		test = extent.startTest("Crear registro con tel�fono casa", "Prueba de registro con tel�fono");
		test.log(LogStatus.INFO, "Prueba con telefono");
				//llamo el objeto.
			
		//aca agrega todos los elementos que yo le puse en mi constructor.
		PaginaPrincipalPage principal= new PaginaPrincipalPage(driver, test, TAKE_SS, 20);
		//llamo el m�todo
		principal.clickLogin();
		
		LoginPage login= new LoginPage(driver, test, TAKE_SS, WAITING);
		login.registroMail("pasilvav9999@gmail.com",subDir);
			
		RegistroPage registro= new RegistroPage(driver, test, TAKE_SS, WAITING);
		//Polimorfismo: Distintos datos para un mismo m�todo
		registro.informacionPersonal("Patricia", "Vergara", "123456",subDir);
		registro.informacionDireccion(subDir);
		registro.ingresarTelefonoCasa();
		registro.registrarInformacion();
				
	}
	
	@AfterMethod
	//Configuraci�n post prueba.
	//indica si la prueba fallo o paso y lo agrega al reporte
	
	public void afterMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, "Test failed.- <br>" + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, "Test skipped.- <br>" + result.getThrowable());
		} else {
			test.log(LogStatus.PASS, "Test passed.-");
		}
		// driver.close();
		extent.endTest(test);
	}

	@AfterSuite
	//Configuraci�n post prueba.
	public void closeExtentReports() {
		// Escribimos los datos al reporte.
		extent.flush();
	}
}
