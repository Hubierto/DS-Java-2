
import javax.swing.JOptionPane;

public class CaixaEntrada {
    
    public static void main(String[] args) {
        String nome = JOptionPane.showInputDialog("Digite seu nome: ");
        JOptionPane.showMessageDialog(null, "olá "+ nome + "!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
    }
}
