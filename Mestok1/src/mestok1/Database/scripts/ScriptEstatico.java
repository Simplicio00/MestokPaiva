/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mestok1.Database.Scripts;

/**
 *
 * @author user1
 */
public class ScriptEstatico {
    
    public static String bancoURL = "jdbc:sqlite:mestok.db";

    public static String CriarBanco = 
        """
            CREATE TABLE IF NOT EXISTS ESistema (
                SistemaId INTEGER PRIMARY KEY AUTOINCREMENT,    
                CodSistema VARCHAR(100) UNIQUE
            );
            
            CREATE TABLE IF NOT EXISTS ECategoria (    
                CategoriaId INTEGER PRIMARY KEY AUTOINCREMENT,    
                SistemaId INTEGER,    
                CategoriaNome VARCHAR(20),    
                FOREIGN KEY(SistemaId) REFERENCES ESistema(SistemaId)
            );
            
            CREATE TABLE IF NOT EXISTS EProduto (    
                ProdutoId INTEGER PRIMARY KEY AUTOINCREMENT,    
                CategoriaId INTEGER,    
                ProdutoNome VARCHAR(20),    
                FOREIGN KEY(CategoriaId) REFERENCES ECategoria(CategoriaId)
            );
            
            CREATE TABLE IF NOT EXISTS EProdutoEstoque (    
                ProdutoEstoqueId INTEGER PRIMARY KEY AUTOINCREMENT,    
                ProdutoId INTEGER,    
                ProdutoEstoqueNome VARCHAR(20),    
                ProdutoEstoqueDataCadastro INTEGER,    
                ProdutoEstoqueAtivo BOOLEAN,    
                ProdutoEstoqueValorContabil VARCHAR(20),
                FOREIGN KEY(ProdutoId) REFERENCES EProduto(ProdutoId)
            );
            
            CREATE TABLE IF NOT EXISTS EPedido (    
                PedidoId INTEGER PRIMARY KEY AUTOINCREMENT,    
                PedidoDataHora INTEGER,    
                PedidoChaveNF VARCHAR(50)
            );
            
            CREATE TABLE IF NOT EXISTS EProdutoEstoque_EPedido (    
                IdProdutoEstoque_Pedido INTEGER PRIMARY KEY AUTOINCREMENT,
                ProdutoEstoqueId INTEGER,
                PedidoId INTEGER,
                FOREIGN KEY(ProdutoEstoqueId) REFERENCES EProdutoEstoque(ProdutoEstoqueId),
                FOREIGN KEY(PedidoId) REFERENCES EPedido(PedidoId)
            );
        
        """;
    
}
