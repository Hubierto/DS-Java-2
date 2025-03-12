import java.util.ArrayList;
import java.util.Scanner;

public class ArApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Ar> ArCondicionados = new ArrayList<>();

        int opcao = 0;

        while (opcao != 3) {
            System.out.println("1- Cadastrar: ");
            System.out.println("2- Relatório: ");
            System.out.println("3- Sair");
            System.out.println("Digite uma opção: ");
            sc.nextInt();


            switch (opcao) {
                case 1:
                System.out.println("Nome do modelo: ");
                String modelo = sc.nextLine();
                System.out.println("Código: ");
                String codigo = sc.next();
                System.out.println("Marca: ");   
                String marca = sc.next(); 
                System.out.println("BTU: "); 
                String btu = sc.next();
                System.out.println("Defeito?: ");
                String bty = sc.next();

                ArCondicionados.add(new Ar(modelo, codigo, marca, btu, codigo));
                    break;
            
                default:
                    break;
            }
            
        }

        sc.close();
    }
    
}
