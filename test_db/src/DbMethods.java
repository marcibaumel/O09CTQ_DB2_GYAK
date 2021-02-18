import javax.swing.*;
import java.sql.*;

public class DbMethods {

    private Statement s = null;
    private Connection conn= null;
    private ResultSet rs= null;


    public void Connect() {
        try {
            String url="jdbc:sqlite:D:/Program Files (x86)/SQLite/empdb.db";
            conn = DriverManager.getConnection(url);
            SM("Connection OK!");
        } catch (SQLException e) {

            SM("Sikertelen driver regisztráció"+e.getMessage());
        }

    }

    public void ReadAllData(){
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
                SM(kod +" "+nev+" "+szid+" "+lak+" "+iq);
            }
        }catch (SQLException e){
            SM(e.getMessage());
        }
    }

    public void DisConnect(){
        try{
            conn.close();
            SM("Disconected");
        }catch (SQLException e){

        }
    }

    public void Reg() {
        try {
            Class.forName("org.sqlite.JDBC");
            SM("Sikeres driver regisztráció");

        } catch (ClassNotFoundException e){

            SM("Sikertelen driver regisztráció"+e.getMessage());
        }

    }

    public void SM(String msg)
    {
        System.out.println(msg);
        //JOptionPane.showMessageDialog(null, msg, "ABKezelő üzenet", 2);
    }}
