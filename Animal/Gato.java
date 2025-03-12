public class Gato extends Animal{

    private String cor;

    public Gato(String nome, String cor, int patas) {
        super(nome, patas);
        this.cor = cor;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public void exibirSom(){
        System.out.println("miau");     
    }

    @Override
    public void exibInfo(){
        System.out.println("Nome: "+ getNome() + " Cor: "+getCor() + " Quantidade de patas: "+getPatas());
}
}