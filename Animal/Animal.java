public class Animal {

    private String nome;
    private int Patas;

    public Animal(String nome, int patas) {
        this.nome = nome;
        this.Patas = patas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPatas() {
        return Patas;
    }

    public void setPatas(int Patas) {
        this.Patas = Patas;
    }
    
    public void exibirSom(){
    }

    public void exibInfo(){
        System.out.println("nome: "+nome);
        System.out.println("Quantidade de patas: "+Patas);
    }
}
