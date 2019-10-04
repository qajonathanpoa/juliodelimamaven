package juliodelimamaven;


import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import suporte.Generator;
import suporte.NavegadorFirefox;
import suporte.Screenshot;


@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = {"testInformacoesUsuario.csv"})

//@RunWith (DataDrivenTestRunner)
//A notação "@RunWith",serve para utilizar a classe e biblioteca de testes do Easytest//
//@DataLoader (filePaths = "testAdicionarInformacaoUsuario.csv" )
//Utilizando o filepaths que serve para dizer os arquivos que quero utilizar para guardar as informações dos meus testes
//O interessante é colocar o nome do arquivo como sendo o nome da classe para facilitar a localização dos arquivos de testes//
//Após informar ao DataLoader o nome e tipo do arquivo que criarei para guardar os dados dos meus testes devo informar
//o diretório que esse arquivo será armazenado
//Caso não tenha criado, devo criar a pasta "resources" no seguinte diretório /src/test/resources
//E dentro do diretório "resources" eu crio o arquivo que será o nomedaclasse.csv

public class InformacoesUsuarioTest {

		
	//Variável navegador criada para ser chamada em vários métodos 
	private WebDriver navegador;
	
	//Utilizando a notação Rule, para que seja possível utilizar o método getMethodName.
	//Com isso o screenshot será criado com o nome do método que está sendo testado
	@Rule
	public TestName test = new TestName();
	
	
	@Before
	public void setUP() {
		navegador = NavegadorFirefox.createFirefox();
		
		//Clicar no botão que possui o texto "Signin"
		navegador.findElement(By.linkText("Sign in")).click();
				
		//Identificando o campo "login" que está dentro do formulário de id"signinbox"//
		WebElement formularioSigninbox = navegador.findElement(By.id("signinbox"));
		
		//Digitar no campo com name"login" que está dentro do formulário de id"signinbox" o texto "julio0001"//
		formularioSigninbox.findElement(By.name("login")).sendKeys("julio0001");
			
		//Digitar no campo com name"login" que está dentro do formulário de id"signinbox" o texto "123456"
		formularioSigninbox.findElement(By.name("password")).sendKeys("123456");
		
		//Clicar no botão com o texto "Sign in"
		navegador.findElement(By.linkText("SIGN IN")).click();
				
		//Validar que dentro do elemento com class "me" está 
		//o texto "HI, Julio"
		WebElement me = navegador.findElement(By.className("me"));
				
		//o comando pega o que está entre a "Tag", no caso abaixo dentro da tag "a"//
		String textonoElementome = me.getText();
		Assert.assertEquals("Hi, Julio", textonoElementome);
				
		//Clicar no link que possui a classe "me"
		navegador.findElement(By.className("me")).click();
				
		//CLicar em um link que possui o texto "MORE DATA ABOUT YOU"
		navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
		
	}//Método padrão para todos os testes
	
	@Test
	//O name do param deve ser exatamente o nome da coluna que está no arquivo, já o nome da string pode ser
	//o que eu achar melhor
	public void testInformacoesUsuario(@Param(name="tipo1")String tipo, @Param (name="contato1") String contato, @Param (name="mensagem2") String mensagemEsperada){
	
				
		//Clicar no botão através do id"moredata" que foi o primeiro elemento anterior 
		WebElement divMoreData = navegador.findElement(By.id("moredata"));
		
		//Clicado no botão "+ADD MORE DATA" através do cssSelector do elemento
		divMoreData.findElement(By.cssSelector("button[data-target]")).click();
		
		//Identificar o formulário anterior dentro da div antecessora de id"addmoredata" 
		WebElement popupAddmoredata = navegador.findElement(By.id("addmoredata"));
		
		//No combobox de name "type" escolher a opção "Phone" no Selenium quando é questão de SELECT
		// podemos selecionar pelo índice (1 ou 2), pelo "value" ou pelo "texto". nesse caso
		//Será utilizado o texto que é o que mais se assemelha ao usuário.
		
		WebElement campoType = popupAddmoredata.findElement(By.name("type"));
		new Select(campoType).selectByVisibleText(tipo);
				
		//Colocar no campo de select.by name "contact" telefone "51983136802"
		popupAddmoredata.findElement(By.name("contact")).sendKeys(contato);
				
		//No link de text save "SAVE" que está na popup (utilizar o linktext) que está dentro
		//do id="addmoredata"
		popupAddmoredata.findElement(By.linkText("SAVE")).click();
				
		//Na mensagem de id "toast-container" validar que o texto é "Your contact has been added!"
		WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
		String mensagem = mensagemPop.getText();
		Assert.assertEquals(mensagemEsperada, mensagem);
		
	}//Fim do método Execução dos testes 
	
	//@Test
	
	public void removerUmContatoDeUmUsuario() {
		
		
		//Clicar no elemento pelo seu xpath //span[text()="36550808848"]/following-sibling::a
		navegador.findElement(By.xpath("//span[text()='+553125880488']/following-sibling::a")).click();
		
		//Confirmar a janela javascript (utilizando o metodo Switchto)
		//no caso abaixo eu vou aceitar a janela, mas se eu quisesse
		//rejeitar seria utilizado o "dismiss"  
		navegador.switchTo().alert().accept();
		
		//Identificar o elemento pela classe "toast rounded" e validar a mensagem "Rest in peace, dear phone!"
		WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
		String mensagem = mensagemPop.getText();
		Assert.assertEquals("Rest in peace, dear phone!", mensagem);
		
		//Utilizando a classe screenshot.tirar e método generator//
		//Importante destacar que com a notação @Rule foi possível definir que a imagem
		//Será criada com o nome do método
				
		String screenshotArquivo = "\\Users\\Jonathan\\Desktop\\testeSelenium" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
		Screenshot.tirar(navegador, screenshotArquivo);
		
		//Aguardar até 10 segundos para que a jenela desapareça (utlizando espera explícita)
		//WebDriverWait é a espera explícita, onde eu digo quanto tempo o navegador vai aguardar
		//o desaparecimento do elemento
		//O stalenessOf é dizer para script aguardar até o elemento desaparecer do DOM
		WebDriverWait aguardar = new WebDriverWait(navegador, 10);
		aguardar.until(ExpectedConditions.stalenessOf(mensagemPop));
		
		//Clicar no link com texto "logout"
		navegador.findElement(By.linkText("Logout")).click();		

		
	}//Fim do segundo método de testes ------------------------------------------------------------------
	
@After
public void tearDown() {
	navegador.close();
	
}//Fim do método utilizando o @After

}

