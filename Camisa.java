public class Camisa {
    
    private String cor;
    private String tipo;
    private String tamanho;

    public Camisa(String cor, String tipo, String tamanho){
        this.cor = cor;
        this.tipo = tipo;
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
 
    
}
