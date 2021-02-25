import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createGUI();
            }
        });

    }
    private static void createGUI() {

        ABKezeloPrg ui= new ABKezeloPrg("Ablak");

        JPanel root = ui.getRootPanel();
        JFrame frame=new JFrame();
        frame.setContentPane(root);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
