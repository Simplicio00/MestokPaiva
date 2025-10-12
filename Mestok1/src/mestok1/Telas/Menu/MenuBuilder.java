/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mestok1.Telas.Menu;

import javax.swing.JFrame;

public class MenuBuilder {
    public String codigoSistema;
    
    public void Build(){
        JFrame frame = new JFrame("MENU");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        var menu = new MenuForm();
        menu.codigoExibicao = this.codigoSistema;
        frame.add(menu);
        frame.setVisible(true);
    }
}
