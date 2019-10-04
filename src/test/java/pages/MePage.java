package pages; 


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MePage extends BasePage {
	
public MePage(WebDriver navegador) {
		super(navegador);
		// TODO Auto-generated constructor stub
	}
//	public WebDriver navegador = InformacoesUsuarioPageObjectsTest.NAVEGADOR;
	
	
	public MePage clicarAbaMoreDataAboutU() {
		//CLicar em um link que possui o texto "MORE DATA ABOUT YOU"
		navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
		
		return this;
	}
	public AddContatoPage clicarBotaoAddMoreData() {
		navegador.findElement(By.id("moredata")).findElement(By.cssSelector("button[data-target]")).click();
		
		return new AddContatoPage (navegador);
	}

}
