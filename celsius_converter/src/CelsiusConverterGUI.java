import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CelsiusConverterGUI extends JFrame{
    private JPanel mainPanel;
    private JTextField celsiusTexField;
    private JLabel celsiusLabel;
    private JButton convertButton;
    private JLabel fartLabel;

    public CelsiusConverterGUI(String title){
            super(title);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setContentPane(mainPanel);
            this.pack();

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int tempFahr = (int)((Double.parseDouble((celsiusTexField.getText())))*1.8+32);
                fartLabel.setText(tempFahr + " Fahrenheit");
            }
        });
    }

    public static void main(String[] args){
        JFrame frame= new CelsiusConverterGUI("Celsius Converte");
        frame.setVisible(true);
    }
}
