public class Splinter extends Ar{

    private String tipos;
    private String tamanho;

    public Splinter(String tamanho, String tipos, String modelo, String codigo, String marca, String btu, String defeito) {
        super(modelo, codigo, marca, btu, defeito);
        this.tamanho = tamanho;
        this.tipos = tipos;
    }

    public String getTipos() {
        return tipos;
    }

    public void setTipos(String tipos) {
        this.tipos = tipos;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public void exibInfo(){
        System.out.println("\nModelo: " + getModelo() + 
        "\nCódigo: " + getCodigo() + 
        "\nMarca: " + getMarca() + 
        "\nBTU: " + getBtu() + 
        "\nTipo: " + getTipos() + 
        "\nTamanho: " + getTamanho() + 
        "\nDefeito: " + getDefeito());
    }
    
}