public class Carro extends Veiculo{

    private int qtdPortas;

    public Carro(String nome, String marca, int ano, int qtdPortas) {
        super(nome, marca, ano);
        this.qtdPortas = qtdPortas;
    }

    public int getQtdPortas() {
        return qtdPortas;
    }

    public void setQtdPortas(int qtdPortas) {
        this.qtdPortas = qtdPortas;
    }
    
    @Override
    public void exibiInfo(){
        System.out.println("Nome: "+getNome()+ " Marca: "+getMarca() + " Ano: "+ getAno() + " Quantidade de portas: "+getQtdPortas());
    }
}
