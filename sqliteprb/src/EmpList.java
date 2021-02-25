import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class EmpList extends JFrame {
    private JPanel controlPanel;
    private JButton btnBezar;
    private JTable tabla;




   public EmpList(String title){

       super(title);


       setBounds(100, 100,500,300);

       createTable();

       btnBezar.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               setVisible(false);

           }
       });

       this.setPreferredSize(new Dimension(400, 400));

       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       this.setContentPane(controlPanel);


       this.pack();

   }

   /*
    public static void main(String[] args){
        JFrame frame= new EmpList("Lista");

        frame.setVisible(true);
    }

    */

    public void createTable(){

        Object[][] data={
                {31,"Jég Elek","1985.05.06","Miskolc",112},
                {32,"Rossz Géza","1981.11.09","Miskolc",105},
                {33,"Keksz Zoé","1993.02.13","Eger",125}

        };

        tabla.setModel(new DefaultTableModel(
                data,
                new String[]{"Kód","Név","Szülidő","Lakóhely","IQ"}
        ));
        TableColumnModel columns= tabla.getColumnModel();
        columns.getColumn(0).setMaxWidth(250);

        DefaultTableCellRenderer ceneterRender=new DefaultTableCellRenderer();
        ceneterRender.setHorizontalAlignment(JLabel.CENTER);
        columns.getColumn(1).setCellRenderer(ceneterRender);
        columns.getColumn(2).setCellRenderer(ceneterRender);
        columns.getColumn(3).setCellRenderer(ceneterRender);

    }
}
