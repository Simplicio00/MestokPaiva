
package Utils;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.DocumentFilter.FilterBypass;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class DecUtils {

    public static boolean tryParseFloat(String s, float[] out) {
        try {
            out[0] = Float.parseFloat(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void Listener(JTextField textoFormatarValor){

        textoFormatarValor.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                SwingUtilities.invokeLater(() -> FormataValores(textoFormatarValor));
            }
            
            
            @Override
            public void removeUpdate(DocumentEvent e) {
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
    }
    
    private static void FormataValores(JTextField textoFormatarValor) {

        String inserido = textoFormatarValor.getText().trim();

        // Mantém apenas números
        inserido = inserido.replaceAll("\\D", "");

        if (inserido.length() > 2) {
            int lastPos = inserido.length() - 2;

            String tratado = inserido.substring(0, lastPos);
            String decimal = "." + inserido.substring(lastPos);

            inserido = tratado + decimal;
        }

        textoFormatarValor.setText(inserido);
    }
    
   
                
 
}
