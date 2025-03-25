public class Gerente extends Funcionario{

    private final double salarioFixo = 8000.00;
    public String calcularSalario;

    public Gerente(String nome) {
        super(nome);
    }

    @Override
    public double calcularSalario(){
        return salarioFixo;
    }
}