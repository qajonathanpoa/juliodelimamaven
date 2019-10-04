package suporte;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Generator {
	
	//M�todo publico est�tico que ir� retornar a data hora para o arquivo
	public static String dataHoraParaArquivo() {
		
		//Criada uma vari�vel do tipo timestamp que ir� se basear nos milisegundos atuais
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		
		//Realizado o retorno com o objeto SimpleDateFormat onde irei definir como o arquivo ser� gerado na string
		return new SimpleDateFormat("yyyyMMddhhmmss").format(ts);

}
	
}