package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class PageLogin extends BasePage{
	
	public PageLogin(WebDriver navegador) {
		super(navegador);
		// TODO Auto-generated constructor stub
	}

	//public WebDriver navegador = InformacoesUsuarioPageObjectsTest.NAVEGADOR;
	
	//Após definida a estrutura de uma página do pageobject eu vou pegar o primeiro comando do método
	 //que quero estruturar e fazer a pergunta! Depois que eu executar esse comando o que eu vou ver, ou 
	 //para que página eu vou e com isso eu crio o método de retorno//
	 //Porém eu devo criar o método que vai executar o comando que no caso foi "clickSignIn"
	 public LoginFormPage clicarSignIn(){
		
		 //Clicar no botão que possui o texto "Signin"
		navegador.findElement(By.linkText("Sign in")).click();
		 
		return new LoginFormPage(navegador);
	 }
	 
	 

}

