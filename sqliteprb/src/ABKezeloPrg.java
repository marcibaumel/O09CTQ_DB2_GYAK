import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ABKezeloPrg extends JFrame{
    private JButton btnReg;
    private JPanel mainPanel;
    DbMethods dbm=new DbMethods();

    public ABKezeloPrg(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setPreferredSize(new Dimension(640, 480));
        this.pack();

        btnReg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dbm.Reg();
            }
        });
    }

    public static void main(String[] args){
        JFrame frame= new ABKezeloPrg("AbKezeloProg");

        frame.setVisible(true);
    }

}
