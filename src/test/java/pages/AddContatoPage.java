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
	
	//Criando o método funcional para facilitar a execução do método de testes
	//Com a criação do método funcional, basta chamá-lo no método de teste
	//que serão executados os 3 métodos que compõem o funcional
	public MePage adicionarContato(String tipo, String contato) {
			escolherTipodeContato(tipo);
			digitarContato(contato);
			clicarSalvar();
		
		return new MePage(navegador);
	}
	
	
}
