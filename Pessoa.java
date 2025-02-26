public class Pessoa{

    private String nome;
    private String telefone;

    //Construtor
    public Pessoa(String nome, String telefone){
        this.telefone=telefone;
        this.nome=nome;
        

    }
    // Acessador

    public String getNome() {
        return nome;
    }
    
    //Modificador

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}