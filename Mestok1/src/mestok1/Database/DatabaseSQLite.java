
package mestok1.Database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import mestok1.Database.Scripts.ScriptEstatico;

/**
 *
 * @author user1
 */
public class DatabaseSQLite {
    
    
    
    public void InicializarBanco() throws IOException{

        try (Connection conn = DriverManager.getConnection(ScriptEstatico.bancoURL)) {
            if (conn != null) {

                Statement stmt = conn.createStatement();

                stmt.execute("PRAGMA foreign_keys = ON;");
                

                String criarBanco = ScriptEstatico.CriarBanco;

                //stmt.execute(criarBanco);

                String[] comandos = criarBanco.split(";");
                for (String sql : comandos) {
                    sql = sql.trim();
                    if (!sql.isEmpty()) {
                        stmt.execute(sql + ";");
                    }
                }
                
                
                
                stmt.close();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro ao conectar no banco: " + e.getMessage());
        }
    
    
    }
    
}
