package main.java.com.example.myrepo;

import java.sql.ResultSet;

public class DBConnect {
    public static void main(String[] args) throws Exception {
        ResultSet _rs;
        Database _db = new Database();
        _db.connettiDatabase();
        System.out.println("Connessione stabilita!");
        _rs = _db.eseguiQuery("select count(*) as conta from istat.aggregazioni") ;
        _rs.next();
        String name =_rs.getString("conta");
        System.out.println(name);
        _rs.close();
        _db.chiudiTutto();
        System.out.println("Connessione chiusa!");
    }
}