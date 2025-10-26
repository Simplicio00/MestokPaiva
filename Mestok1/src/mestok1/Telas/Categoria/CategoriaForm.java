package mestok1.Telas.Categoria;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

/**
 *
 * @author user1
 */
public class CategoriaForm extends javax.swing.JPanel {

    /**
     * Creates new form CategoriaForm
     */
    public CategoriaForm() {
        initComponents();
        PopularGridCategoria();
    }
    
    public void PopularGridCategoria(){
        jp_tela_categoria.setLayout(new GridLayout(0,2,10,10));
        
        for (int i = 1; i <= 100; i++) {
            JLabel label = new JLabel("Label número " + i);
            jp_tela_categoria.add(label);
        }
        
        JScrollPane scrollPane = new JScrollPane(jp_tela_categoria);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.add(scrollPane);

        
        jp_tela_categoria.setPreferredSize(new Dimension(550, jp_tela_categoria.getPreferredSize().height));


        //panel.setPreferredSize(new Dimension(550, panel.getPreferredSize().height));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        categoria_nome_cadastrar = new javax.swing.JTextField();
        jp_tela_categoria = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(500, 500));

        jLabel1.setText("CATEGORIA");

        categoria_nome_cadastrar.setToolTipText("Pressione a tecla [ENTER] para cadastrar a categoria");
        categoria_nome_cadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        categoria_nome_cadastrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                categoria_nome_cadastrarKeyPressed(evt);
            }
        });

        jp_tela_categoria.setBackground(new java.awt.Color(255, 255, 255));
        jp_tela_categoria.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jp_tela_categoria.setForeground(new java.awt.Color(255, 255, 255));
        jp_tela_categoria.setMaximumSize(new java.awt.Dimension(300, 300));
        jp_tela_categoria.setMinimumSize(new java.awt.Dimension(300, 300));
        jp_tela_categoria.setPreferredSize(new java.awt.Dimension(400, 422));
        jp_tela_categoria.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jp_tela_categoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(categoria_nome_cadastrar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(categoria_nome_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jp_tela_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        categoria_nome_cadastrar.getAccessibleContext().setAccessibleName("Digite o nome da categoria que deseja cadastrar");
    }// </editor-fold>//GEN-END:initComponents

    private void categoria_nome_cadastrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_categoria_nome_cadastrarKeyPressed
        
        if (evt.getKeyCode() == 10) {
            
            String categoria = categoria_nome_cadastrar.getText();
            
            if (categoria.trim() == "") {
                JOptionPane.showMessageDialog(null, "Digite uma categoria válida para prosseguir com o cadastro!");
            }
            
        }
        
    }//GEN-LAST:event_categoria_nome_cadastrarKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField categoria_nome_cadastrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jp_tela_categoria;
    // End of variables declaration//GEN-END:variables
}
