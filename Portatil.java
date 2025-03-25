public class Portatil extends Ar{

    private double voltagem;
    private String cor;

    public Portatil(String modelo, String codigo, String marca, String btu, double voltagem, String cor, String defeito) {
        super(modelo, codigo, marca, btu, defeito);
        this.voltagem = voltagem;
        this.cor = cor;
    }

    
    public double getVoltagem() {
        return voltagem;
    }

    public void setVoltagem(double voltagem) {
        this.voltagem = voltagem;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public void exibInfo(){
        System.out.println("\nModelo: " + getModelo() + 
        "\nCódigo: " + getCodigo() + 
        "\nMarca: " + getMarca() + 
        "\nBTU: " + getBtu() + 
        "\nVoltagem: " + getVoltagem() + 
        "\nCor: " + getCor() + 
        "\nDefeito: " + getDefeito());
    }
    
}