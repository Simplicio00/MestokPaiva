/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mestok1.Telas._Categoria;

import Utils.SysUtils;
import java.net.MalformedURLException;
import javax.swing.JFrame;

/**
 *
 * @author user1
 */
public class CategoriaBuilder {
    public void Builder() throws MalformedURLException{
        JFrame frame = new JFrame("Categoria");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(new CategoriaForm());
        SysUtils.SetLogo(frame);
        frame.setVisible(true);
    }
}
