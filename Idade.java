import javax.swing.JOptionPane;

public class Idade {

    public static void main(String[] args) {
        try {
            // Solicita a idade ao usuário através de uma caixa de entrada
            String entrada = JOptionPane.showInputDialog("Digite sua idade:");

            // Converte a entrada para um número inteiro
            int idade = Integer.parseInt(entrada);

            // Verifica se a idade é menor de 18 ou maior de 18
            if (idade < 18) {
                JOptionPane.showMessageDialog(null, "Você é de menor.", "Resultado", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Você é de maior.", "Resultado", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (NumberFormatException e) {
            // Se ocorrer um erro na conversão da entrada, exibe uma mensagem de erro
            JOptionPane.showMessageDialog(null, "Erro: Você deve digitar um número válido!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
