import java.util.ArrayList;
import java.util.Scanner;

public class PessoaApp {
    public static void main(String[] args) {
        

        try (Scanner sc = new Scanner(System.in)) {
            ArrayList<Pessoa> list = new ArrayList<>();
            
            int op = 0;
            
            
            while(op != 4){
                System.out.println("---Menu---");
                System.out.println("1-Cadastrar");
                System.out.println("2-Listar");
                System.out.println("3-Remover");
                System.out.println("4-Sair");
                System.out.println("Escolha a opção:");
                op=sc.nextInt();
                
                switch (op) {
                    case 1 -> {
                        System.out.println("Digite o nome: ");
                        String nome=sc.next();
                        System.out.println("Digite o telefone: ");
                        String telefone=sc.next();
                        list.add(new Pessoa(nome, telefone));
                    }
                        
                    case 2 -> {
                        if (list.isEmpty()) {
                            System.out.println("lista vazia");
                            
                        }    else{
                            
                            for (Pessoa p : list) {
                                System.out.println("nome: "+ p.getNome()+" Telefone: "+ p.getTelefone());
                            }
                        }
                    }
                        
                    case 3 -> {
                        if (list.isEmpty()) {
                            System.out.println("lista vazia");
                            
                        } else{
                            System.out.println("Digite o indice a ser removido: ");
                            int indice=sc.nextInt();
                            
                            if (indice>=0 && indice<list.size()) {
                                list.remove(indice);
                                System.out.println("Contato removido com sucesso!");
                            }
                        }
                    }
                        
                    case 4 -> System.out.println("Saindo...");
                        
                    default -> {
                    }
                }
            }
        }
        }
}