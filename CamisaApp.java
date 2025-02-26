import java.util.ArrayList;
import java.util.Scanner;

public class CamisaApp{

    public static void main(String[] args) {
        
        try (Scanner sc = new Scanner(System.in)) {
            ArrayList<Camisa> lista = new ArrayList<>();
            
            int op=0;
            
            while (op != 4) {
                System.out.println("---Menu---");
                System.out.println("1-Cadastrar");
                System.out.println("2-Listar");
                System.out.println("3-Remover");
                System.out.println("4-Sair");
                System.out.println("Escolha a opção:");
                op=sc.nextInt();
                
                switch (op) {
                    case 1 -> {
                        System.out.println("Digite a cor da camisa: ");
                        String cor=sc.next();
                        System.out.println("Digite o tipo da camisa: ");
                        String tipo=sc.next();
                        System.out.println("Digite o tamanho da camisa: ");
                        String tamanho=sc.next();
                        lista.add(new Camisa(cor, tipo, tamanho));
                    }
                    
                    case 2 ->{
                        if (lista.isEmpty()) {
                            System.out.println("Lista vazia");
                        } else{
                            for (Camisa c : lista) {
                                System.out.println("cor: "+c.getCor()+ " Tipo: "+ c.getTipo()+ " Tamanho: "+c.getTamanho());
                                
                            }
                        }
                    }

                    case 3 -> {
                        if (lista.isEmpty()) {
                            System.out.println("Lista vazia");
                        } else {
                            System.out.println("Digite o indice a ser removido");
                            int indice = sc.nextInt();

                            if (indice >=0 && indice<lista.size()) {
                                lista.remove(indice);
                                System.out.println("Camisa excluída com sucesso");
                            }

                        }
                    }

                    case 4 -> {
                        System.out.println( "Saindo...");
                    }
                    default -> {
                    }
                }
                
            }
        }
    }

}