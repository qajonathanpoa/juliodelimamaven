package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class LoginFormPage extends BasePage{
public LoginFormPage(WebDriver navegador) {
		super(navegador);
		// TODO Auto-generated constructor stub
	}
//public WebDriver navegador = InformacoesUsuarioPageObjectsTest.NAVEGADOR;
	
	
	public LoginFormPage digitarLogin (String login){
		navegador.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys(login);
		return this;
	}
	public LoginFormPage digitarSenha (String password) {
		navegador.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys(password);
	return this;
	}
	
	public PaginaSecreta clicarBotaoSignIn() {
		
		navegador.findElement(By.linkText("SIGN IN")).click();
	return new PaginaSecreta(navegador);	
	}
	
	//Exemplo de método "FUNCIONAL", onde eu posso definir mais de uma execução para um mesmo método
	public PaginaSecreta fazerLogin (String login,String senha) {
		navegador.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys(login);
		navegador.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys(senha);
		navegador.findElement(By.linkText("SIGN IN")).click();
		
	return new PaginaSecreta(navegador);	
	}
	
	//Exemplo de método "FUNCIONAL" com os estruturais dentro dele
	public PaginaSecreta fazerLogin2(String login, String password) {
		digitarLogin(login);
		digitarSenha(password);
		clicarBotaoSignIn();
		return new PaginaSecreta(navegador);
	}
	
}
