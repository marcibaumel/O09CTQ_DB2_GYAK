import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmpList extends JFrame {
    private JButton btnBezar;
    private JTable tabla;
    private JPanel mainTablePanel;

    /*
    public EmpList(JFrame f, EmpTM betm) {
        super(f, "Dolgozók listája", true);
        etm = betm;
    }
    */
    
    DbMethods dbm=new DbMethods();

    public EmpList(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainTablePanel);
        this.setPreferredSize(new Dimension(640, 480));
        this.pack();

        btnBezar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dbm.Reg();
            }
        });
    }

    public static void main(String[] args){
        JFrame frame= new EmpList("Tabla");

        frame.setVisible(true);
    }
}
