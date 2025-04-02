import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CadastroProduto {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        try {
            FileWriter escritor = new FileWriter("produtos.txt", true);

            System.out.println("Digite o nome do produto: ");
            String nome = sc.nextLine();

            System.out.println("Digite o preço do produto: ");
            double preco = sc.nextDouble();

            escritor.write(nome + "- R$ "+ preco+ "\n");
            escritor.close();

            System.out.println("Produto cadastrado com sucesso!"); 

        } catch (IOException e) {
            System.out.println("Erro ao salvar o produto.");
            e.printStackTrace();
        } finally{
            sc.close();
        }
    }
    
}
