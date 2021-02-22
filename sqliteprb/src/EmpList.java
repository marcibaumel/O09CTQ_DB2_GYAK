import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmpList  {

    private JPanel controlPanel;
    private JButton BezarBtn;
    private JTable showTable;
    private EmpTM etm;
    private Statement s = null;
    private Connection conn= null;
    private ResultSet rs= null;


    public EmpList() {

        //createTable();

        Object[][] data={
                {"The Dark Knight", 2008, 9.0, 1886938},
                {"Star Wars", 2001, 8.1, 1313},
                {"Inception", 1990, 10, 3131344}

        };

        showTable.setModel(new DefaultTableModel(
                data,
                new String[]{"Title", "Year", "Rating", "Num Votes"}
        ));
        TableColumnModel columns= showTable.getColumnModel();
        columns.getColumn(0).setMaxWidth(250);

        DefaultTableCellRenderer ceneterRender=new DefaultTableCellRenderer();
        ceneterRender.setHorizontalAlignment(JLabel.CENTER);
        columns.getColumn(1).setCellRenderer(ceneterRender);
        columns.getColumn(2).setCellRenderer(ceneterRender);
        columns.getColumn(3).setCellRenderer(ceneterRender);

        BezarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public JPanel getRootPanel(){
        return controlPanel;
    }

    public void createTable(){

    }

    public void CreateTable(){

        /*
        Object emptmn[]={"Jel", "Kód"};
        EmpTM etm= new EmpTM(emptmn, 0);
        String nev="", szid="", lak="", x="/t";
        int kod=0, iq=0;
        String sqlp="select kod, nev, szulido, lakohely, iq from emp";
        try{
            s=conn.createStatement();
            rs=s.executeQuery(sqlp);
            while(rs.next()){
                kod=rs.getInt("kod");
                nev=rs.getString("nev");
                szid=rs.getString("szulido");
                lak= rs.getString("lakohely");
                iq=rs.getInt("iq");
                //System.out.println("Lekérdezés:");
                //SM(kod +" "+nev+" "+szid+" "+lak+" "+iq);
                etm.addRow(new Object[]{false, kod, szid, lak, iq});
            }
        }catch (SQLException e){
            SM(e.getMessage());
        }
        return etm;
         */

        Object[][] data={
                {"The Dark Knight", 2008, 9.0, 1886938},
                {"Star Wars", 2001, 8.1, 1313},
                {"Inception", 1990, 10, 3131344}

        };

        showTable.setModel(new DefaultTableModel(
                data,
                new String[]{"Title", "Year", "Rating", "Num Votes"}
        ));
        TableColumnModel columns= showTable.getColumnModel();
        columns.getColumn(0).setMaxWidth(250);

        DefaultTableCellRenderer ceneterRender=new DefaultTableCellRenderer();
        ceneterRender.setHorizontalAlignment(JLabel.CENTER);
        columns.getColumn(1).setCellRenderer(ceneterRender);
        columns.getColumn(2).setCellRenderer(ceneterRender);
        columns.getColumn(3).setCellRenderer(ceneterRender);

    }

    public void SM(String msg)
    {
        //System.out.println(msg);
        JOptionPane.showMessageDialog(null, msg, "ABKezelő üzenet", 2);
    }

}




