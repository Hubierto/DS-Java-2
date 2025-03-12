public class Cachorro extends Animal{

    private String raca;

    public Cachorro(String raca, String nome, int patas) {
        super(nome, patas);
        this.raca = raca;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    @Override
    public void exibirSom(){
        System.out.println("Woof Woof");
    }

    @Override
    public void exibInfo(){
        System.out.println("Nome: "+ getNome() + " Raça: "+getRaca() + " Quantidade de patas: "+getPatas());
    }
    
}
