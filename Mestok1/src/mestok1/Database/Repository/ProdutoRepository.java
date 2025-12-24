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
import mestok1.Database.Entidade.Produto;
import mestok1.Database.Scripts.ScriptEstatico;

/**
 *
 * @author Acer
 */
public class ProdutoRepository extends Commom {
    CategoriaRepository cat_repository = new CategoriaRepository();
    
    public Produto GetProdutoPorNome(String produto, int categoriaId){
        Produto produtoRetorno = null;
        
        try (Connection conn = DriverManager.getConnection(ScriptEstatico.bancoURL)) {
            if (conn != null) {

                Statement stmt = conn.createStatement();
                
                String query = 
                String.format(
                """ 
                    SELECT ProdutoId, ProdutoNome FROM EProduto WHERE 
                    CategoriaId = '%d' AND
                    ProdutoNome LIKE '%s'
                """, categoriaId, produto);
                
                // Lê dados
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    produtoRetorno = new Produto();
                    produtoRetorno.setProdutoNome(rs.getString("ProdutoNome"));
                    produtoRetorno.setProdutoId(rs.getInt("ProdutoId"));
                }
                
                rs.close();
                stmt.close();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar no banco: " + e.getMessage());
        }
        
        return produtoRetorno;
    }
    
    public void PostProduto(String nomeProduto, String nomeCategoria){
        Categoria categoria = cat_repository.GetCategoriaPorNome(nomeCategoria, SistemaRepository.sistemaId, Boolean.TRUE);
        
        if (categoria != null) {
            PostProduto(nomeProduto, categoria.getCagegoriaId());
        }  
    }
    
    public void PostProduto(String nomeProduto, int categoriaId){
        try (Connection conn = DriverManager.getConnection(ScriptEstatico.bancoURL)) {
            if (conn != null) {

                Statement stmt = conn.createStatement();
                
                String insertQuery = 
                String.format(""" 
                    INSERT INTO EProduto(ProdutoNome, CategoriaId)
                    VALUES('%s','%d');
                """, nomeProduto, categoriaId);
        
                stmt.execute(insertQuery);
                stmt.close();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar no banco: " + e.getMessage());
        }
    }

    public ArrayList<Produto> GetProdutosPorCategoria(int categoriaId){
        ArrayList<Produto> lista = new ArrayList<Produto>();
        
        try (Connection conn = DriverManager.getConnection(ScriptEstatico.bancoURL)) {
            if (conn != null) {

                Statement stmt = conn.createStatement();
                
                String query = 
                String.format(
                """ 
                    SELECT ProdutoId, ProdutoNome FROM EProduto WHERE CategoriaId = '%d'
                """, categoriaId);
                
                // Lê dados
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    Produto produto = new Produto();
                    produto.setProdutoNome(rs.getString("ProdutoNome"));
                    produto.setProdutoId(rs.getInt("ProdutoId"));
                    
                    lista.add(produto);
                }
                
                rs.close();
                stmt.close();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar no banco: " + e.getMessage());
        }
        
        return lista;
    }
    
    @Override
    public Produto Get() {
        return null;
    }

    @Override
    public Produto GetById(String id) {
        return null;
    }

    @Override
    public void Post() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Delete() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
