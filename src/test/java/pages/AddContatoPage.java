package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



public class AddContatoPage extends BasePage{

public AddContatoPage(WebDriver navegador) {
		super(navegador);
		// TODO Auto-generated constructor stub
	}
//public WebDriver navegador = InformacoesUsuarioPageObjectsTest.NAVEGADOR;

	public AddContatoPage escolherTipodeContato(String tipo) {
		
		WebElement campoType = navegador.findElement(By.id("addmoredata")).findElement(By.name("type"));
		new Select(campoType).selectByVisibleText(tipo);
				
		return this;
	}
	public AddContatoPage digitarContato(String contato) {
		navegador.findElement(By.id("addmoredata")).findElement(By.name("contact")).sendKeys(contato);
		
		return this;
	}
	public MePage clicarSalvar() {
		navegador.findElement(By.id("addmoredata")).findElement(By.linkText("SAVE")).click();
			
		return new MePage(navegador);
	}
	
	//Criando o m�todo funcional para facilitar a execu��o do m�todo de testes
	//Com a cria��o do m�todo funcional, basta cham�-lo no m�todo de teste
	//que ser�o executados os 3 m�todos que comp�em o funcional
	public MePage adicionarContato(String tipo, String contato) {
			escolherTipodeContato(tipo);
			digitarContato(contato);
			clicarSalvar();
		
		return new MePage(navegador);
	}
	
	
}
