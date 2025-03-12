public class Veiculo {
    private String nome;
    private String marca;
    private int ano;

    public Veiculo(String nome, String marca, int ano) {
        this.nome = nome;
        this.marca = marca;
        this.ano = ano;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    
    public void exibiInfo(){
        System.out.println("nome: "+nome);
        System.out.println("Marca: "+marca);
        System.out.println("Marca: "+ano);
    }
}
