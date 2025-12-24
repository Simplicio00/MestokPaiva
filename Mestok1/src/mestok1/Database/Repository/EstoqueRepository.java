package mestok1.Database.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import mestok1.Database.Entidade.Estoque;
import mestok1.Database.Scripts.ScriptEstatico;

public class EstoqueRepository extends Commom {
    
    public ArrayList<Estoque> GetEstoquesDoProduto(int idProduto){
        var retorno = new ArrayList<Estoque>();
        
        try (Connection conn = DriverManager.getConnection(ScriptEstatico.bancoURL)) {
            if (conn != null) {

                Statement stmt = conn.createStatement();

                String query = 
                String.format(
                """ 
                    SELECT ProdutoEstoqueNome, ProdutoEstoqueValorContabil, ProdutoEstoqueId FROM EProdutoEstoque 
                    WHERE 
                    ProdutoId = '%d'
                """, idProduto);

                // Lê dados
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    var ret = new Estoque();
                    ret.setId(rs.getInt("ProdutoEstoqueId"));
                    ret.setNome(rs.getString("ProdutoEstoqueNome"));
                    ret.setValorContabil(rs.getFloat("ProdutoEstoqueValorContabil"));
                    retorno.add(ret);
                }

                rs.close();
                stmt.close();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar no banco: " + e.getMessage());
        }

        return retorno;
    }
    
    public void PostEstoqueCategoria(int idProduto, String estoqueNome, float valor){
        try (Connection conn = DriverManager.getConnection(ScriptEstatico.bancoURL)) {
            if (conn != null) {

                Statement stmt = conn.createStatement();
                
                String insertQuery = 
                String.format(""" 
                    INSERT INTO EProdutoEstoque(ProdutoEstoqueNome, ProdutoEstoqueValorContabil, ProdutoId)
                    VALUES('%s','%f','%d');
                """, estoqueNome, valor, idProduto);
        
                stmt.execute(insertQuery);
                stmt.close();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar no banco: " + e.getMessage());
        }
    }

    @Override
    public Object Get() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object GetById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
