import java.util.ArrayList;
import java.util.Scanner;

public class ArApp {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            ArrayList<Ar> arCondicionados = new ArrayList<>();
            int opcao = 0;

            while (opcao != 3) {
                System.out.println("\n1- Cadastrar: ");
                System.out.println("2- Relatório: ");
                System.out.println("3- Sair");
                System.out.print("Digite uma opção: ");
                opcao = sc.nextInt();
                sc.nextLine();

                switch (opcao) {
                    case 1 -> {
                        System.out.print("Nome do modelo (Splinter ou Portátil): ");
                        String modelo = sc.nextLine();
                        System.out.print("Código: ");
                        String codigo = sc.nextLine();
                        System.out.print("Marca: ");
                        String marca = sc.nextLine();
                        System.out.print("BTU: ");
                        String btu = sc.nextLine();
                        System.out.print("Defeito?(se sim, especifique qual): ");
                        String defeito = sc.nextLine();
                        
                        if ("Splinter".equalsIgnoreCase(modelo)) {
                            System.out.print("Tamanho do Splinter: ");
                            String tamanho = sc.nextLine();
                            System.out.print("Tipo do Splinter: ");
                            String tipo = sc.nextLine();
                            arCondicionados.add(new Splinter(tamanho, tipo, modelo, codigo, marca, btu, defeito));
                        } else if ("Portátil".equalsIgnoreCase(modelo)) {
                            System.out.print("Voltagem do Portátil: ");
                            double voltagem = sc.nextDouble();
                            sc.nextLine();  // Consume the remaining newline
                            System.out.print("Cor do Portátil: ");
                            String cor = sc.nextLine();
                            arCondicionados.add(new Portatil(modelo, codigo, marca, btu, voltagem, cor, defeito));
                        } else {
                            System.out.println("Modelo inválido. Deve ser 'Splinter' ou 'Portátil'.");
                        }
                    }
                    case 2 -> {
                        if (arCondicionados.isEmpty()) {
                            System.out.println("Lista vazia");
                        } else {
                            for (Ar a : arCondicionados) {
                                a.exibInfo();
                            }
                        }
                    }
                    case 3 -> System.out.println("Saindo...");
                    default -> System.out.println("Opção inválida.");
                }
            }
        }
    }
}
