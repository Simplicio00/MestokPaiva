/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mestok1.Database.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import mestok1.Database.Entidade.Sistema;
import mestok1.Database.Scripts.ScriptEstatico;

/**
 *
 * @author user1
 */
public class SistemaRepository {
    public String identificador;
    public static int sistemaId;

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
    
    public void PostSistema(){
        try (Connection conn = DriverManager.getConnection(ScriptEstatico.bancoURL)) {
            if (conn != null) {

                Statement stmt = conn.createStatement();
                
                String insertQuery = 
                String.format(""" 
                    INSERT INTO ESistema(CodSistema)
                    VALUES('%s');
                """, identificador);
        
                stmt.execute(insertQuery);
                stmt.close();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar no banco: " + e.getMessage());
        }
    }
    
    public Sistema GetSistema() {
        Sistema sistema = null;
        
        try (Connection conn = DriverManager.getConnection(ScriptEstatico.bancoURL)) {
            if (conn != null) {

                Statement stmt = conn.createStatement();
                
                String query = 
                String.format(""" 
                    SELECT SistemaId, CodSistema FROM ESistema WHERE CodSistema = '%s'
                """, identificador);
        
                stmt.execute(query);

                // Lê dados
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    sistema = new Sistema();
                    sistema.setCodSistema(rs.getString("CodSistema"));
                    sistema.setSistemaId(rs.getInt("SistemaId"));
                    this.sistemaId = sistema.SistemaId;
                }
                
                rs.close();
                stmt.close();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar no banco: " + e.getMessage());
        }
        
        return sistema;
    }
    
}
