package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class PageLogin extends BasePage{
	
	public PageLogin(WebDriver navegador) {
		super(navegador);
		// TODO Auto-generated constructor stub
	}

	//public WebDriver navegador = InformacoesUsuarioPageObjectsTest.NAVEGADOR;
	
	//Ap�s definida a estrutura de uma p�gina do pageobject eu vou pegar o primeiro comando do m�todo
	 //que quero estruturar e fazer a pergunta! Depois que eu executar esse comando o que eu vou ver, ou 
	 //para que p�gina eu vou e com isso eu crio o m�todo de retorno//
	 //Por�m eu devo criar o m�todo que vai executar o comando que no caso foi "clickSignIn"
	 public LoginFormPage clicarSignIn(){
		
		 //Clicar no bot�o que possui o texto "Signin"
		navegador.findElement(By.linkText("Sign in")).click();
		 
		return new LoginFormPage(navegador);
	 }
	 
	 

}

