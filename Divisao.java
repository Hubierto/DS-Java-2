import java.util.Scanner;

public class Divisao {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
        
        int numero1;
        int numero2;
        int resultado;

        System.out.println("Vamos realizar uma divisão!: ");
        System.out.println("Digite um número: ");
        numero1 = sc.nextInt();
        System.out.println("Digite outro número: ");
        numero2 = sc.nextInt();
        
        try {
            resultado = numero1/numero2;
            System.out.println("Resultado: "+resultado);

        } catch (ArithmeticException e) {
            
            System.out.println("Conta inválida");

        } finally{
            System.out.println("Finalizando..");
        }

        }
    }
    
}
