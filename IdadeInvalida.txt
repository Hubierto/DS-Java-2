import java.util.InputMismatchException;
import java.util.Scanner;

public class IdadeInvalida {

    public static void main(String[] args) {
        
        try(Scanner sc = new Scanner(System.in)){

            int idade = 0;

            while (idade < 1) {
                
                try {
                    System.out.println("Digite sua idade: ");
                    idade = sc.nextInt();
                    
                    if (idade < 1) {
                        System.out.println("Idade inválida! Digite uma idade acima de 1");
                    } else {
                        System.out.println("Idade cadastrada com sucesso: "+idade);
                    }

                } catch (InputMismatchException e) {
                    
                    System.out.println("Idade Invalida! Digite um número válido");
                    sc.next();

                } finally {
                    System.out.println("\nFinalizando..");
                }

                
            }
        }
    }
    
}
