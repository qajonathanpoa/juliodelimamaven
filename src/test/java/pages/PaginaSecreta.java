package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PaginaSecreta extends BasePage{
	public PaginaSecreta(WebDriver navegador) {
		super(navegador);
		// TODO Auto-generated constructor stub
	}
	//public WebDriver navegador = InformacoesUsuarioPageObjectsTest.NAVEGADOR;

	public MePage clicarTextoMe() {
		navegador.findElement(By.className("me")).click();
		
		return new MePage(navegador);
	}
	
			
	
}
