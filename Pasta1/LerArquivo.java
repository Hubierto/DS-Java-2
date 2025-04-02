import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LerArquivo {

    public static void main(String[] args) {
        
        try {
            //FileReader para ler o arquivo.
            FileReader leitor = new FileReader("Pasta1");
            //BufferedReader para melhorar a leitura
            BufferedReader bufferRedReader = new BufferedReader(leitor);
            String linha;

            //while lê linha por linha até encontrar null (fim do arquivo)
            while ((linha = bufferRedReader.readLine()) != null) {
                System.out.println(linha);
            }
            bufferRedReader.close();

        } catch (IOException e) {
            System.out.println("Erro");
            e.printStackTrace();
        }
    }
    
}
