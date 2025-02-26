public class Carro {

    String marca;
    String modelo;
    String anoFabricado;

    public Carro(String marca, String modelo, String anoFabricado){
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricado= anoFabricado;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAnoFabricado() {
        return anoFabricado;
    }

    public void setAnoFabricado(String anoFabricado) {
        this.anoFabricado = anoFabricado;
    }

    
    
}
