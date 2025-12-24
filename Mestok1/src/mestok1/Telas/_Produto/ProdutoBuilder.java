
package mestok1.Telas._Produto;

import Utils.SysUtils;
import java.net.MalformedURLException;
import javax.swing.JFrame;

public class ProdutoBuilder {
    public void Builder() throws MalformedURLException{
    
        JFrame frame = new JFrame("Produto");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(new ProdutoForm());
        SysUtils.SetLogo(frame);
        frame.setVisible(true);
    }
}
