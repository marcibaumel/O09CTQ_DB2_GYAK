public class Program {

    static  DbMethods dbm= new DbMethods();
    static ConsoleMethods cm= new ConsoleMethods();

    public static void main(String[] args) {
        dbm.Reg();
        dbm.Connect();
        //dbm.ReadAllData();
        dbm.CommandExec("insert into user values('marton', 'marton');");
        LogIn();
        while(1!=0){
            menu();
        }

        /*
        dbm.CommandExec("create table user(\n" +
                "name varchar(30),\n" +
                "pswd varchar(30)\n" +
                ");");


         */



        /*
        String kod = cm.ReadData("Add meg a kódot: ");
        String nev = cm.ReadData("Add meg a neved: ");
        String szi= cm.ReadData("Add meg mikor születtél: ");
        String lak=cm.ReadData("Hol laksz :");
        String iq= cm.ReadData("Mennyi az IQ-od: ");
        dbm.Insert(kod, nev, szi, lak, iq);
         */

        //int id= cm.ReadID("Adj meg id-t amit törölni szeretnél:");
        //dbm.deletById(id);


        //int id= cm.ReadID("Adj meg id-t amit változtatni szeretnél:");
        //int newIq= cm.ReadID("Add meg az IQ:");


        //dbm.changeIqByID(id, newIq);

        //dbm.ReadAllData();

        //dbm.DisConnect();
    }


    public static void LogIn(){
        dbm.SM("Bejelentkezés");
        String nev= cm.ReadData("Add meg a neved: \n");
        String jel= cm.ReadData("Add meg a jelszód: \n");
        int pc = dbm.Identification(nev, jel);

        if(pc == 1) {
            dbm.SM("Minden oké.");
        }
        else{
            dbm.SM("You can't touch this");
            System.exit(0);
        }
    }

    static void menu(){
        dbm.SM("\n");
        dbm.SM("Menü");
        dbm.SM("=================\n\n");
        dbm.SM("0.Kilépés \n");
        dbm.SM("1. Listázás \n");
        dbm.SM("2. Beszúrás \n");
        dbm.SM("3. Törlés \n");

        String ms= cm.ReadData("Add meg a meg melyik funkciót akarod használni");
        int m= -1;

        if(test(ms))m = StringToInt(ms);
        switch(m){
            case 0: dbm.SM("A program leállt!"); System.exit(0); break;
            case 1: Listening(); break;
            case 2: Insertion(); break;
            case 3: Deletion();
        }
    }


    static void Listening(){
        dbm.ReadAllData();
    }
    static void Insertion(){
        String kod = cm.ReadData("Add meg a kódot: ");
        String nev = cm.ReadData("Add meg a neved: ");
        String szi= cm.ReadData("Add meg mikor születtél: ");
        String lak=cm.ReadData("Hol laksz :");
        String iq= cm.ReadData("Mennyi az IQ-od: ");
        dbm.Insert(kod, nev, szi, lak, iq);
    }

    static void Deletion(){
        int id= cm.ReadID("Adj meg id-t amit törölni szeretnél:");
        dbm.deletById(id);
    }

    static boolean test(String s){
        if(s.length() == 0){
            dbm.SM("Próbáld újra");
            return  false;
        }
        else{
            try{

                int x= Integer.valueOf(s);
                if(x>=0 && x<4) return true;
                else{
                    dbm.SM("Valami nem jó :(");
                    return false;
                }

            }catch (NumberFormatException nfe)
            {
                dbm.SM("Ez se jó");
                return false;
            }
        }
    }

    static int StringToInt(String s){
        int x= 0;
        try{
            x=Integer.valueOf(s);

        }catch (NumberFormatException nfe){}
        return x;
    }
}
