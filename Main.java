import java.io.*;
import javax.swing.*;
 
public class Main {
 
    public static void main(String[] args) {
        final JFrame frame = new JFrame("Codificador/Decodificador");
        Boolean isOn = true;

        while(isOn) {
            // escolher função (0-codificar 1-decodificar)
            int op = 0;  
        
            Object[] functions = { "Codificar", "Decodificar" };
            op = JOptionPane.showOptionDialog(null, "Escolha a função desejada:", "Função", JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE, null, functions, functions[0]);
            
            if(op == 0) {
                System.out.println("Codificar: " + op);
            } else if(op == 1) {
                System.out.println("Decodificar: " + op);
            } else {
                isOn = false;
                break;
            }
            
            // seleção de arquivo
            final JFileChooser fileChooser = new JFileChooser();
            fileChooser.setMultiSelectionEnabled(false);
    
            int retVal = fileChooser.showOpenDialog(frame);
            if (retVal == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                JOptionPane.showMessageDialog(frame, selectedFile.getName());
            }

            System.out.println("retVal: " + retVal); // APPROVE_OPTION = 0 : CANCEL = 1
            
            // escolher codificador (0: Golomb, 1:Elias-Gamma, 2:Fibonacci, 3:Unária e 4:Delta)
            Object[] items = { "Golomb", "Elias-Gamma", "Fibonacci", "Unária", "Delta" };
            Object selectedValue = JOptionPane.showInputDialog(null, "Escolha um codificador:", "Opção",
                JOptionPane.INFORMATION_MESSAGE, null, items, items[0]);

            System.out.println("cod: " + selectedValue); // CANCEL = null

            if(op == 1) {
                isOn = false;
            }
        }
        System.exit(0);
    }
}
