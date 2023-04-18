package main.java.com.example.myrepo;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import oracle.jdbc.pool.OracleDataSource;

public class Database {
    private Statement _comando;
    private Connection _connessione;

    public Database() {
        super();
        this._comando = null;
        this._connessione = null;
    }

    public void connettiDatabase() throws Exception {
        // Read Resource data from Initial Context
        Scanner keyb = new Scanner(System.in);
        Class.forName("oracle.jdbc.pool.OracleDataSource");
        String url = "jdbc:oracle:thin:@192.168.5.101:1521:demo", user , password = "";
        System.out.println("Utente:");
        user = keyb.nextLine();
        System.out.println("Password:");
        Console cons;
        char[] passwd;
        if ((cons = System.console()) != null &&
                (passwd = cons.readPassword("[%s]", "Password:")) != null ) {
            java.util.Arrays.fill(passwd, ' ');
        }

        OracleDataSource ds = new OracleDataSource();
        ds.setURL(url);
        ds.setUser(user);
        ds.setPassword(password);

        
        _connessione = ds.getConnection();
        // Use the Connection to create a Statement object
        _comando = _connessione.createStatement();
    }

    public ResultSet eseguiQuery (String query) throws Exception {
        ResultSet risultato = _comando.executeQuery(query);
        return risultato;
    }

    public void chiudiTutto() throws Exception {
        _comando.close();
        _connessione.close();
    }
}
