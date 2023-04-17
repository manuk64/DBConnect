package main.java.com.example.myrepo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
        Class.forName("oracle.jdbc.pool.OracleDataSource");
        String url = "jdbc:oracle:thin:@192.168.5.101:1521:demo", user = "istat", password = "taxi";
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

/*    public Statement getComando() {
        return _comando;
    }

    public Connection getConnessione() {
        return _connessione;
    }
*/
    public void chiudiTutto() throws Exception {
        _comando.close();
        _connessione.close();
    }
}
