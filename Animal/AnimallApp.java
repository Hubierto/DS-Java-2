public class AnimallApp {

    public static void main(String[] args) {
        
        Cachorro c = new Cachorro("Bulldog", "Luke", 4);
        Gato g = new Gato("Cat", "Azul", 4);

        c.exibInfo();
        c.exibirSom();
        g.exibInfo();
        g.exibirSom();
    }
    
}
