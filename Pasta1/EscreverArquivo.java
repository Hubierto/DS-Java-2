import java.io.FileWriter;
import java.io.IOException;

public class EscreverArquivo{
        public static void main(String[] args) {
            try {
                //objeto FileWriter para escrever no arquivo .txt
                FileWriter escritor = new FileWriter("Arquivo txt");
                //.write() para adicionar texto ao arquivo
                escritor.write("olá! Este é um arquivo de teste\n");
                escritor.write("Podemos escrever várias linhas\n");
                //.close() para garantir que os dados sejam salvos. 
                escritor.close();
                System.out.println("Arquivo criado");
                
            } catch (IOException e) {
                System.out.println("ocorreu um erro");
                e.printStackTrace();
            }
        }
        
    }
