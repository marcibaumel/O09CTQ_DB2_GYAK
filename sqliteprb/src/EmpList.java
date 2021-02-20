import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
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
    private EmpTM etm;


    public EmpList(String title){


        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainTablePanel);
        tabla = new JTable(etm);
        this.setPreferredSize(new Dimension(640, 480));
        this.pack();

        TableColumn tc = null;
        for (int i = 0; i < 6; i++) {
            tc = tabla.getColumnModel().getColumn(i);
            if (i==0 || i==1 || i==5) tc.setPreferredWidth(30);
            else {tc.setPreferredWidth(100);}
        }

        tabla.setAutoCreateRowSorter(true);
        TableRowSorter<EmpTM> trs =
                (TableRowSorter<EmpTM>)tabla.getRowSorter();
        trs.setSortable(0, false);


        btnBezar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); setVisible(false);
            }
        });
    }

    public static void main(String[] args){
        JFrame frame= new EmpList("Tabla");

        frame.setVisible(true);
    }
}
