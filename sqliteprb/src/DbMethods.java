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
        Object emptmn[]={"Jel", "Kód"};

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

    public void Insert(String kod, String nev, String szid, String lak, String iq){
        String sqlp="insert into emp values (" +kod+", '"+ nev+"', '"+ szid+"', '"+ lak+"', '"+ iq+"')";
        try{
            s=conn.createStatement();
            s.execute(sqlp);
            SM("insert OK!");

        }catch(SQLException e){
            SM("JDB Insert: "+ e.getMessage());
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

    public void deletById(int id){
        String sqlp="DELETE FROM emp WHERE (kod="+id+");";
        try{
            s=conn.createStatement();
            s.execute(sqlp);
            SM("Delete OK!");

        }catch(SQLException e){
            SM("JDB delete: "+ e.getMessage());
        }
    }

    public void changeIqByID(int id, int newIq){
        String sqlp="UPDATE emp \n" +
                    "SET iq="+newIq+"\n" +
                    "WHERE (kod="+id+");";
        try{
            s=conn.createStatement();
            s.execute(sqlp);
            SM("Change OK!");

        }catch(SQLException e){
            SM("JDB change: "+ e.getMessage());
        }
    }


    public void SM(String msg)
    {
        //System.out.println(msg);
        JOptionPane.showMessageDialog(null, msg, "ABKezelő üzenet", 2);
    }}
