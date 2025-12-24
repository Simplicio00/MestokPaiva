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
import java.util.ArrayList;
import javax.swing.JOptionPane;
import mestok1.Database.Entidade.Categoria;
import mestok1.Database.Scripts.ScriptEstatico;

/**
 *
 * @author Acer
 */
public class CategoriaRepository extends Commom {
    
    public void PostCategoria(String nomeCategoria, int sistemaId){
        try (Connection conn = DriverManager.getConnection(ScriptEstatico.bancoURL)) {
            if (conn != null) {

                Statement stmt = conn.createStatement();
                
                String insertQuery = 
                String.format(""" 
                    INSERT INTO ECategoria(CategoriaNome, SistemaId)
                    VALUES('%s','%d');
                """, nomeCategoria, sistemaId);
        
                stmt.execute(insertQuery);
                stmt.close();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar no banco: " + e.getMessage());
        }
    }
    
    public ArrayList<Categoria> GetCategoria(int codSistema){
        ArrayList<Categoria> lista = new ArrayList<>();
        
        try (Connection conn = DriverManager.getConnection(ScriptEstatico.bancoURL)) {
            if (conn != null) {

                Statement stmt = conn.createStatement();
                
                String query = 
                String.format(
                """ 
                    SELECT CategoriaId, CategoriaNome FROM ECategoria WHERE SistemaId = '%d'
                """, codSistema);
                
                // Lê dados
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    Categoria categoria = new Categoria();
                    categoria.setCategoriaNome(rs.getString("CategoriaNome"));
                    categoria.setCagegoriaId(rs.getInt("CategoriaId"));
                    
                    lista.add(categoria);
                }
                
                rs.close();
                stmt.close();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar no banco: " + e.getMessage());
        }
        
        return lista;
    }
    
    public Categoria GetCategoriaPorNome(String categoriaBuscada, int codSistema, Boolean exato){
        Categoria categoria = null;
        
        try (Connection conn = DriverManager.getConnection(ScriptEstatico.bancoURL)) {
            if (conn != null) {

                Statement stmt = conn.createStatement();
                
                String query = 
                        "SELECT "
                        + "CategoriaId, "
                        + "CategoriaNome FROM ECategoria "
                        + "WHERE SistemaId = " + codSistema + " AND " 
                        + "UPPER(CategoriaNome) LIKE '%" + categoriaBuscada.toUpperCase() + "%'";
                
                if (exato == true) {
                    query = 
                        "SELECT "
                        + "CategoriaId, "
                        + "CategoriaNome FROM ECategoria "
                        + "WHERE SistemaId = " + codSistema + " AND "
                        + "UPPER(CategoriaNome) = '" + categoriaBuscada.toUpperCase() + "'";
                }
                
                // Lê dados
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    categoria = new Categoria();
                    categoria.setCategoriaNome(rs.getString("CategoriaNome"));
                    categoria.setCagegoriaId(rs.getInt("CategoriaId"));
                }
                
                rs.close();
                stmt.close();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar no banco: " + e.getMessage());
        }
        
        return categoria;
    }

    @Override
    public Object Get() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object GetById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void Post() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Delete() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
