package mestok1.Telas._Estoque;

import Utils.SysUtils;
import java.net.MalformedURLException;
import javax.swing.JFrame;

public class EstoqueBuilder {
    public void Builder() throws MalformedURLException{
        JFrame frame = new JFrame("ESTOQUE");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(450,450);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(new EstoqueForm());
        SysUtils.SetLogo(frame);
        frame.setVisible(true);
    }
}
