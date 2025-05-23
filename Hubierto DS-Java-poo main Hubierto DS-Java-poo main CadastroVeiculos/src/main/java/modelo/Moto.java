/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class Moto extends Veiculo {
    private int cilindrada;

    public Moto(String marca, String modelo, int cilindrada) {
        super(marca, modelo);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }
    
    
    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }


    @Override
    public String getDescricao() {
        return "Moto - Marca: " + marca + ", Modelo: " + modelo + ", Cilindrada: " + cilindrada + "cc";
    }
}

