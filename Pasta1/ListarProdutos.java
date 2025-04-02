import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ListarProdutos {

    public static void main(String[] args) {
        try {
            BufferedReader leitor = new BufferedReader(new FileReader("produtos.txt"));
            String linha;

            System.out.println("Lista de produtos: ");
            while ((linha = leitor.readLine()) != null) {
                System.out.println(linha);
            }

            leitor.close();

        } catch (IOException e) {
            System.out.println("Erro ao ler os produtos");
            e.printStackTrace();
        }
    }
}
