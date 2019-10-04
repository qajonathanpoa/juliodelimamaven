package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class BasePage {

	//Quanto temos uma classe que extende outra classe com uma propriedade "protected"
	//Essa propriedade pode ser utilizada pela classe filha//

	//public WebDriver navegador;
	protected WebDriver navegador;
	
	public BasePage (WebDriver navegador) {
		
		this.navegador = navegador;
	}
	
	public String capturarTextodoToast() {
		
		return navegador.findElement(By.id("toast-container")).getText();
	
	}
	
//public String validaTextoMe() {
		
	
	//return navegador.findElement(By.className("me")).getText();		
	
		
	//}
	
	

}
