/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mestok1;

import java.io.IOException;
import javax.swing.JFrame;
import mestok1.Database.DatabaseSQLite;

/**
 *
 * @author user1
 */
public class Mestok1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
                
        new DatabaseSQLite().InicializarBanco();
        
        
        JFrame frame = new JFrame("LOG IN");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(388, 200);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(new MyPanelForm());
        frame.setVisible(true);
        
    }
    
}
