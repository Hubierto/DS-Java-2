import java.util.ArrayList;
import java.util.Scanner;

public class animalApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ArrayList<Animal> animais = new ArrayList<>();

            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1 - Adicionar novo animal");
                System.out.println("2 - Fazer um animal emitir som");
                System.out.println("3 - Sair");
                System.out.print("Escolha uma opção: ");

                int opcao = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcao) {
                    case 1:
                        System.out.print("Digite o tipo de animal (Cachorro, Gato ou Vaca): ");
                        String tipoAnimal = scanner.nextLine();

                        if (tipoAnimal.equalsIgnoreCase("Cachorro")) {
                            animais.add(new Cachorro());
                            System.out.println("Cachorro adicionado!");
                        } else if (tipoAnimal.equalsIgnoreCase("Gato")) {
                            animais.add(new Gato());
                            System.out.println("Gato adicionado!");
                        } else if (tipoAnimal.equalsIgnoreCase("Vaca")) {
                            animais.add(new Vaca());
                            System.out.println("Vaca adicionada!");
                        } else {
                            System.out.println("Tipo de animal inválido.");
                        }
                        break;
                    case 2:
                        if (animais.isEmpty()) {
                            System.out.println("Nenhum animal cadastrado.");
                        } else {
                            System.out.println("Animais cadastrados:");
                            for (int i = 0; i < animais.size(); i++) {
                                System.out.println(i + " - " + animais.get(i).getClass().getSimpleName());
                            }
                            System.out.print("Escolha um animal: ");
                            int escolhaAnimal = scanner.nextInt();
                            scanner.nextLine(); 

                            if (escolhaAnimal >= 0 && escolhaAnimal < animais.size()) {
                                animais.get(escolhaAnimal).fazerSom();
                            } else {
                                System.out.println("Escolha inválida.");
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Encerrando o programa...");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Opção inválida.");
                }
            }
        }
    }
}
