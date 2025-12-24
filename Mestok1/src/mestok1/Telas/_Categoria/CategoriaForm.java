package mestok1.Telas._Categoria;

import static Utils.StrUtils.RetiraCaracteresEspeciais;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import mestok1.Database.Entidade.Categoria;
import mestok1.Database.Repository.CategoriaRepository;
import mestok1.Database.Repository.SistemaRepository;

/**
 *
 * @author user1
 */
public class CategoriaForm extends javax.swing.JPanel {
    
    CategoriaRepository categoriaRepository = new CategoriaRepository();

    /**
     * Creates new form CategoriaForm
     */
    public CategoriaForm() {
        initComponents();
        PopularGridCategoria();
        MontarSeletorTB();
    }
    
    public void MontarSeletorTB(){
        tb_categoria.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int linha = tb_categoria.getSelectedRow();
                    int coluna = tb_categoria.getSelectedColumn();
                    if (linha != -1 && coluna != -1) {
                        JOptionPane.showMessageDialog(null, "Célula selecionada: (" + linha + ", " + coluna + ")");                        
                    }
                }
            }
        });
    }
    
    public void PopularGridCategoria(){
        
        ArrayList<Categoria> lista = categoriaRepository.GetCategoria(SistemaRepository.sistemaId);
        
        int comprimentoLista = lista.size();
        
        if (comprimentoLista == 0) {
            return;
        }
        
        DefaultTableModel model = (DefaultTableModel) tb_categoria.getModel();
        model.setRowCount(0);
        
        for (int i = 0; i <= (comprimentoLista-1); i++) {
            String content = lista.get(i).getCategoriaNome();
            int idContent = lista.get(i).getCagegoriaId();

            model.addRow(new Object[] { idContent, content });
        }

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tb_categoria = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        categoria_nome_cadastrar = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(400, 400));

        tb_categoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tb_categoria);
        if (tb_categoria.getColumnModel().getColumnCount() > 0) {
            tb_categoria.getColumnModel().getColumn(0).setResizable(false);
            tb_categoria.getColumnModel().getColumn(0).setPreferredWidth(5);
            tb_categoria.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 3, 12)); // NOI18N
        jLabel1.setText("CATEGORIA");
        jLabel1.setAutoscrolls(true);
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        categoria_nome_cadastrar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        categoria_nome_cadastrar.setToolTipText("Pressione a tecla [ENTER] para cadastrar a categoria");
        categoria_nome_cadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        categoria_nome_cadastrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                categoria_nome_cadastrarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(categoria_nome_cadastrar))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(jLabel1)
                .addContainerGap(184, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(categoria_nome_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                .addContainerGap())
        );

        categoria_nome_cadastrar.getAccessibleContext().setAccessibleName("Digite o nome da categoria que deseja cadastrar");
    }// </editor-fold>//GEN-END:initComponents


    private Boolean ValidaCategoriaNome(String categoria){
        if (categoria.isEmpty()) {
            return false;
        }
        else if (categoria.length() <= 3) {
            return false;
        }
        
        return true;        
    }
    private void categoria_nome_cadastrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_categoria_nome_cadastrarKeyPressed
        
        if (evt.getKeyCode() == 10) {
            
            String categoria = categoria_nome_cadastrar.getText();
            
            if (ValidaCategoriaNome(categoria.trim()) == false) {
                JOptionPane.showMessageDialog(null, "Digite uma categoria válida para prosseguir com o cadastro!");
                return;
            }
            
            int resposta = JOptionPane.showConfirmDialog(
                null,
                "Deseja realmente cadastrar esta categoria?",
                "Confirmação",
                JOptionPane.OK_CANCEL_OPTION
            );

            if (resposta == JOptionPane.OK_OPTION) {
                categoria = RetiraCaracteresEspeciais(categoria).toUpperCase();
                
                Categoria _categoria = categoriaRepository.GetCategoriaPorNome(categoria, SistemaRepository.sistemaId, true);
                
                if (_categoria != null) {
                    JOptionPane.showMessageDialog(null, "A categoria que você digitou já está cadastrada!");
                    PopularGridCategoria();
                    categoria_nome_cadastrar.setText(null);
                    return;
                }
                
                categoriaRepository.PostCategoria(categoria, SistemaRepository.sistemaId);
            }
            
            categoria_nome_cadastrar.setText(null);
            PopularGridCategoria();
        }
        
    }//GEN-LAST:event_categoria_nome_cadastrarKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField categoria_nome_cadastrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_categoria;
    // End of variables declaration//GEN-END:variables
}
