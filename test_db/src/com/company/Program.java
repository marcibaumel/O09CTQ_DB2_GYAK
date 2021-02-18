package com.company;

public class Program {

    static  DbMethods dbm= new DbMethods();

    public static void main(String[] args) {
        dbm.Reg();
        dbm.Connect();
        dbm.ReadAllData();
        dbm.DisConnect();
    }
}
