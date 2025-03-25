public class FormaApp {
    
    public static void main(String[] args) {

        Circulo cir = new Circulo(10);
        Retangulo ret = new Retangulo(5, 2);

        System.out.println("Área do círculo: "+cir.calcularArea());
        System.out.println("Área do Retângulo: "+ret.calcularArea());
        
    }
}
