/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mestok1.Telas.Categoria;

import javax.swing.JFrame;

/**
 *
 * @author user1
 */
public class CategoriaBuilder {
    public void Builder(){
        JFrame frame = new JFrame("Categoria");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(new CategoriaForm());
        frame.setVisible(true);
    }
}
