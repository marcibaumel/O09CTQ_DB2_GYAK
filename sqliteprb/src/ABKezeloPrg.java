import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ABKezeloPrg extends JFrame{

    private JButton btnReg;
    private JPanel mainPanel;
    private JButton listaBtn;
    private JButton Kilépés;


    DbMethods dbm=new DbMethods();


    public ABKezeloPrg(String title){
        super(title);

        this.setPreferredSize(new Dimension(400, 400));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        btnReg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dbm.Reg();
            }
        });

        listaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmpList el = new EmpList("Teszt");
                el.setVisible(true);
            }
        });

        Kilépés.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    /*
    public static void main(String[] args){
        JFrame frame= new ABKezeloPrg("AbKezeloProg");

        frame.setVisible(true);
    }
    */


    public JPanel getRootPanel(){
        return mainPanel;
    }

}
