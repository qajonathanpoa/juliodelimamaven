package suporte;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Web {
	
	public static final String USERNAME = "jonathan917";
	public static final String AUTOMATE_KEY = "qnHybjVFVgoump6qyXhY";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	public static WebDriver createChrome() {
		
						
				//Definindo o caminho do ChromeDriver
				System.setProperty("webdriver.chrome.driver","./src\\test\\resources\\chromedriver.exe");
				
				//Instanciando o ChromeDriver
				WebDriver navegador = new ChromeDriver();
			
				//Fazendo uma espera implícita para carregamento da página 
				navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				//Comando para abrir navegador maximizado
				navegador.manage().window().maximize();
				
				//Abrindo a página desejada
				navegador.get("C:\\Users\\Jonathan\\eclipse-workspace\\campodetreinamento\\src\\test\\resources\\componentes.html");
				
				return navegador;
	}
	
	public static WebDriver createBrowserStack() {
			
			DesiredCapabilities caps = new DesiredCapabilities();
		    caps.setCapability("browser", "IE");
		    caps.setCapability("browser_version", "10.0");
		    caps.setCapability("os", "Windows");
		    caps.setCapability("os_version", "7");
		    caps.setCapability("resolution", "1024x768");
		    caps.setCapability("name", "Bstack-[Java] Sample Test");

			   
			    WebDriver navegador = null; 
			    
			try {navegador = new RemoteWebDriver(new java.net.URL(URL), caps);
			//Fazendo uma espera implícita para carregamento da página 
			navegador.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			//Abrindo a página desejada
			navegador.get("http://www.juliodelima.com.br/taskit");
			
			}catch (MalformedURLException e) {
				e.printStackTrace();
				System.out.println("Houveram problemas com a url"+ e.getMessage());
			}
			    return navegador;
				
		
	}
}
