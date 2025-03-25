public class VeiculoApp {
    public static void main(String[] args) {
        
        Carro c1 = new Carro("Fiat", "Argo", 2000, 4);
        Moto m1 = new Moto("Fan", "Honda", 2000, 130);

        c1.exibiInfo();
        m1.exibiInfo();
    }
    
}
