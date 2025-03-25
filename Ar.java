public class Ar {

    private String modelo; 
    private String codigo;
    private String marca;
    private String btu;
    private String defeito;

    public Ar(String modelo, String codigo, String marca, String btu,  String defeito) {
        this.modelo = modelo;
        this.codigo = codigo;
        this.marca = marca;
        this.btu = btu;
        this.defeito = defeito;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getBtu() {
        return btu;
    }

    public void setBtu(String btu) {
        this.btu = btu;
    }

    public String getDefeito() {
        return defeito;
    }

    public void setDefeito(String defeito) {
        this.defeito = defeito;
    }

    public void exibInfo(){
        System.out.println("Modelo: " + getModelo() +
        "\nCódigo: " + getCodigo() + 
        "\nMarca: " + getMarca() + 
        "\nBTU: " + getBtu() + 
        "\nDefeito: " + getDefeito());
    }
    
}