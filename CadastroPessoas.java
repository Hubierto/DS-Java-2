import java.io.*;
import java.util.Scanner;

public class CadastroPessoas {
    private static final String ARQUIVO = "pessoas.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        while (true) {
            // Exibir menu
            System.out.println("1 - Cadastrar pessoa");
            System.out.println("2 - Listar pessoas cadastradas");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    cadastrarPessoa(scanner);
                    break;
                case 2:
                    listarPessoas();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    // Função para cadastrar pessoa
    private static void cadastrarPessoa(Scanner scanner) {
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine(); 

        // Salvar dados no arquivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO, true))) {
            writer.write(nome + "," + idade);
            writer.newLine();
            System.out.println("Pessoa cadastrada com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    // Função para listar pessoas
    private static void listarPessoas() {
        File arquivo = new File(ARQUIVO);
        if (!arquivo.exists()) {
            System.out.println("Nenhuma pessoa cadastrada.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO))) {
            String linha;
            System.out.println("Pessoas cadastradas:");
            System.out.println("Nome\t\tIdade");
            System.out.println("-------------------------");

            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                String nome = dados[0];
                String idade = dados[1];

                System.out.println(nome + "\t\t" + idade);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler os dados: " + e.getMessage());
        }
    }
}
