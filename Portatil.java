public class Portatil extends Ar{

    private double Voltagem;
    private String cor;

    public Portatil(String modelo, String codigo, String marca, String btu, double Voltagem, String cor, String defeito) {
        super(modelo, codigo, marca, btu, defeito);
        this.Voltagem = Voltagem;
        this.cor = cor;
    }

    
    public double getVoltagem() {
        return Voltagem;
    }

    public void setVoltagem(double Voltagem) {
        this.Voltagem = Voltagem;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public void exibInfo(){
        System.out.println("Modelo: "+ getModelo()+ "\n Código" + getCodigo() + "\nMarca: "+getMarca() + "\n BTU: "+ getBtu() + "\n Voltagem: "+ getVoltagem() + "\nCor: "+getCor() + "\n Defeito: "+getDefeito());
    }
    
}
