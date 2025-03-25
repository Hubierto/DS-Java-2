public class FuncionarioApp {

    public static void main(String[] args) {
        
    
        Gerente gerente = new Gerente("André");

        Programador programador =  new Programador("André", 5);
    
        System.out.println("Salário do gerente: "+" R$" + gerente.calcularSalario());
        System.out.println("Salário do Programador: "+ programador.calcularSalario());
    }
}