import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.FileReader;
import java.util.Date;
import java.util.Scanner;
 
public class LerArquivo {
 
  public static void main(String[] args) throws ParseException {
	 
	boolean primeiro_colocado = false, segundo_colocado = false, terceiro_colocado = false, 
		desclassificado = false, quarto_colocado = false, quinto_colocado = false;       
  
    Scanner leitor = new Scanner(System.in); 
    System.out.printf("Informe o nome de arquivo texto:\n");
    String nome = leitor.nextLine(); 
    System.out.printf("\nResultado da Corrida:\n");
    
    try {
      FileReader arq = new FileReader(nome);
      BufferedReader lerArq = new BufferedReader(arq); 
      String linha = lerArq.readLine(); // lê a primeira linha
      linha = lerArq.readLine(); //faz o programa desconsiderar a primeira linha dos titulos
      
      //leitura do arquivo
      while (linha != null){    	
    	String finalizou_volta = linha.substring(0, 12); //posicao da hora que finalizou a volta 
    	String nome_piloto = linha.substring(18, 38); //posicao do nome do piloto
    	String volta_corrente = linha.substring(58,59); //posicao da volta corrente 
    	String tempo_volta = linha.substring(72,80); //posicao do tempo da volta  
    
    	if (volta_corrente.equals("4") && (primeiro_colocado == false)) { 
    		System.out.println("Posição Chegada: 1 - " + "Piloto: " + nome_piloto + " - Voltas Completas: " + volta_corrente);
    		primeiro_colocado = true;
    		linha = lerArq.readLine(); 
    		nome_piloto = linha.substring(18, 38); 
    	}
    		
    	if (volta_corrente.equals("4") && (primeiro_colocado == true) && (segundo_colocado == false)) {
    		System.out.println("Posição Chegada: 2 - " + "Piloto: " + nome_piloto + " - Voltas Completas: " + volta_corrente);
    		segundo_colocado = true;   
    		linha = lerArq.readLine(); 
    		nome_piloto = linha.substring(18, 38);
    	}
    	
    	if (volta_corrente.equals("4") && (segundo_colocado == true) && (terceiro_colocado == false)) {
    		System.out.println("Posição Chegada: 3 - " + "Piloto: " + nome_piloto + " - Voltas Completas: " + volta_corrente);
    		terceiro_colocado = true;  
    		linha = lerArq.readLine(); 
    		nome_piloto = linha.substring(18, 38); 
    	}
    	
    	if (volta_corrente.equals("4") && (terceiro_colocado == true) && (quarto_colocado == false)) {
    		System.out.println("Posição Chegada: 4 - " + "Piloto: " + nome_piloto + " - Voltas Completas: " + volta_corrente);
    		quarto_colocado = true;
    		linha = lerArq.readLine(); 
    		nome_piloto = linha.substring(18, 38); 
    	}
    	
    	if (volta_corrente.equals("4") && (quarto_colocado == true)) {
    		System.out.println("Posição Chegada: 5 - " + "Piloto: " + nome_piloto + " - Voltas Completas: " + volta_corrente);    
    		linha = lerArq.readLine(); 
    		nome_piloto = linha.substring(18, 38); 
    		quinto_colocado = true;
    	}    	
    	
    	if ((quinto_colocado == true) && (!volta_corrente.equals("4")) && (desclassificado == false)){ 
    		System.out.println("Não completou a prova: " + "Piloto: " + nome_piloto + " - Voltas Completas: " + volta_corrente);
    		desclassificado = true;
    	}
    	
    	linha = lerArq.readLine(); 
      }
      
      //fecha o arquivo
      arq.close();
      
    } catch (IOException e) {
        System.err.printf("Erro na abertura do arquivo: %s.\n",
          e.getMessage());
    }
 
    System.out.println();
  }
}