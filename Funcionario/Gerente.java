public class Gerente extends Funcionario{

    private double salarioFixo = 8000.00;
    public String calcularSalario;

    public Gerente(String nome) {
        super(nome);
    }

    public double calcularSalario(){
        return salarioFixo;
    }
}