import java.util.ArrayList;
import java.util.Scanner;

public class CarroApp {

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            ArrayList<Carro> lista = new ArrayList<>();

            int op = 0;

            while (op!=4) {
                System.out.println("-----Menu-----");
                System.out.println("1-Cadastrar");
                System.out.println("2-Listar");
                System.out.println("3-Remover");
                System.out.println("4-Sair");
                System.out.println("Digite uma opção: ");
                op=sc.nextInt();

                switch (op) {
                    case 1 -> {
                        System.out.println("Digite a marca do carro: ");
                        String marca=sc.next();
                        System.out.println("Digite o modelo do carro: ");
                        String modelo=sc.next();
                        System.out.println("Digite o ano de fabricação do carro: ");
                        String anoFabricado=sc.next();
                        lista.add(new Carro(marca, modelo, anoFabricado));
                    }
                    
                    case 2 -> {
                        if (lista.isEmpty()) {
                            System.out.println("Lista vazia");
                        } else{
                            for (Carro c : lista) {
                                System.out.println("Marca: "+c.marca+" Modelo: "+c.modelo+" Ano de fabricação: "+c.anoFabricado);
                            }
                        }
                    }
                    case 3 -> {
                        if (lista.isEmpty()) {
                            System.out.println("Lista vazia");
                        } else {
                            System.out.println("Digite o indice a Ser removido: ");
                            int indice=sc.nextInt();

                            if (indice>=0 && indice<lista.size()) {
                                lista.remove(indice);
                                System.out.println("Excluído com sucesso");
                            }
                        }
                    }
                    case 4 -> {
                        System.out.println("Saindo..");
                    }

                    default -> {
                    }
                }
                
            }
        }
    }
    
}
