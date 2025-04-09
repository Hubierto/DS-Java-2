
import javax.swing.JOptionPane;

public class CaixaConfirmacao {
    
    public static void main(String[] args) {
        int respsta = JOptionPane.showConfirmDialog(null, "Deseja continuar? ", "Confirmação", JOptionPane.YES_NO_OPTION);

        if (respsta == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "voçê escolheu sim", "Resultado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "voçê escolheu não", "Resultado", JOptionPane.WARNING_MESSAGE);
        }
    }
}
