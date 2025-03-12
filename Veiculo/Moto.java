public class Moto extends Veiculo{
    private int cilindrado;

    public Moto(String nome, String marca, int ano, int cilindrado) {
        super(nome, marca, ano);
        this.cilindrado = cilindrado;
    }

    public int getCilindrado() {
        return cilindrado;
    }

    public void setCilindrado(int cilindrado) {
        this.cilindrado = cilindrado;
    }

    @Override    
    public void exibiInfo(){
        System.out.println("Nome: "+getNome() + " Marca: "+ getMarca() + " Ano: "+getAno()+ " Cilindrada: "+getCilindrado());
    }
    
}
