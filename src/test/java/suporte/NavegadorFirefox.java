package suporte;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavegadorFirefox {
	
	public static WebDriver createFirefox() {
		
		System.setProperty("webdriver.gecko.driver", "./src\\test\\resources\\geckodriver.exe");
		WebDriver navegador = new FirefoxDriver();
		
		//Comando para abrir navegador maximizado
		navegador.manage().window().maximize();
		
		navegador.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Abrindo a página desejada
		navegador.get("http://juliodelima.com.br/taskit");
		
		return navegador;
	}

}
