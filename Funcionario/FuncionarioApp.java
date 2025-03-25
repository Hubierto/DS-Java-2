public class FuncionarioApp {

    public static void main(String[] args) {
        
    
        Gerente gerente = new Gerente("André");

        Programador programador =  new Programador("Roberto", 5);
    
        System.out.println("\nNome do gerente: " + gerente.nome + " Salário do gerente: "+" R$" + gerente.calcularSalario());
        System.out.println("Nome do programador: " + programador.nome + " Salário do Programador: "+ programador.calcularSalario());
    }
}