package juliodelimamaven;


import static org.junit.Assert.*;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.PageLogin;
import suporte.NavegadorFirefox;
import suporte.Web;



@RunWith
(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InformacoesUsuarioPageObjectsTest.csv")

public class InformacoesUsuarioPageObjectsTest {
	

	//Criada a classe "InformacoesUsuarioPageObjectsTest" para ajustar tudo o que foi feito
	//na classe InformacoesUsuarioTest de forma não estruturada//
	
		private WebDriver navegador;
		//public static final WebDriver NAVEGADOR = Web.createBrowserStack();
		
		//Criado o Before como padrão pois é tudo o que quero que seja executado antes do teste
		@Before
		public void setUp() {
			navegador = Web.createChrome();
		}//Fim do Before
				
		@Test
		public void testInformacoesUsuario(@Param(name="login")String login,
				@Param(name="senha")String senha,
				@Param(name="tipo")String tipo,
				@Param(name="contato")String contato,
				@Param(name="mensagem")String mensagemEsperada){
				
				
			String textoToast = new PageLogin (navegador)
			
				.clicarSignIn()
				.fazerLogin(login,senha)
				.clicarTextoMe()
				.clicarAbaMoreDataAboutU()
				.clicarBotaoAddMoreData()
				.adicionarContato(tipo, contato)
				.capturarTextodoToast();
														
			assertEquals(mensagemEsperada, textoToast);
			System.out.println(textoToast);
			
		
				
}//Fim do método de testes-=-=-=-=-=-=-=-=-=-==
			
			
		
		@After
		public void tearDown() {
		navegador.quit();
		}// Fim do método tearDown ------------------------
		
	
	
}//Fim da classe -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
