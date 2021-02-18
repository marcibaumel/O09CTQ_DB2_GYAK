public class Program {

    static  DbMethods dbm= new DbMethods();
    static ConsoleMethods cm= new ConsoleMethods();

    public static void main(String[] args) {
        dbm.Reg();
        dbm.Connect();


        String kod = cm.ReadData("Add meg a kódot: ");
        String nev = cm.ReadData("Add meg a neved: ");
        String szi= cm.ReadData("Add meg mikor születtél: ");
        String lak=cm.ReadData("Hol laksz :");
        String iq= cm.ReadData("Mennyi az IQ-od: ");
        dbm.Insert(kod, nev, szi, lak, iq);

        dbm.ReadAllData();

        dbm.DisConnect();
    }
}
