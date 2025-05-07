/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class Carro extends Veiculo {
    private int numeroPortas;

    public Carro(String marca, String modelo, int numeroPortas) {
        super(marca, modelo);
        this.numeroPortas = numeroPortas;
    }

    public int getNumeroPortas() {
        return numeroPortas;
    }
    
    
    public void setNumeroPortas(int portas) {
        this.numeroPortas = portas;
    }


    @Override
    public String getDescricao() {
        return "Carro - Marca: " + marca + ", Modelo: " + modelo + ", Portas: " + numeroPortas;
    }
}

