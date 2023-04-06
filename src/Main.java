import java.sql.ResultSet;

public class Main {
    public static void main() throws Exception {
        ResultSet _rs;
        Database _db = new Database();
        _db.connettiDatabase();
        System.out.println("Connessione stabilita!");
        _rs = _db.eseguiQuery("select count(*) as conta from istat.aggregazioni;") ;
        String name =_rs.getString("conta");
        System.out.println(name);
        _rs.close();
        _db.chiudiTutto();
    }
}