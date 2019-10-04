package suporte;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Generator {
	
	//Método publico estático que irá retornar a data hora para o arquivo
	public static String dataHoraParaArquivo() {
		
		//Criada uma variável do tipo timestamp que irá se basear nos milisegundos atuais
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		
		//Realizado o retorno com o objeto SimpleDateFormat onde irei definir como o arquivo será gerado na string
		return new SimpleDateFormat("yyyyMMddhhmmss").format(ts);

}
	
}