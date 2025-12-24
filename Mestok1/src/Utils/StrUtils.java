/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.awt.Toolkit;
import java.text.DecimalFormat;
import java.text.Normalizer;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author Acer
 */
public class StrUtils {
    public static String RetiraCaracteresEspeciais(String texto){
         if (texto == null) return null;

        // Passo 1: normaliza o texto (acentos viram caracteres básicos)
        String normalizado = Normalizer.normalize(texto, Normalizer.Form.NFD);

        // Passo 2: remove todos os caracteres que não são letras ou números
        //String semEspeciais = normalizado.replaceAll("[^\\p{Alnum}]", "");

        return normalizado.toUpperCase();
    }

    
    // Função que aplica o filtro de limite
    public static void limitarCaracteres(JTextField campo, int limite) {
        AbstractDocument doc = (AbstractDocument) campo.getDocument();
        
        doc.setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String string, AttributeSet attr)
                    throws BadLocationException {
                if ((fb.getDocument().getLength() + string.length()) <= limite) {
                    super.insertString(fb, offset, string, attr);
                } 
                /*else {
                    Toolkit.getDefaultToolkit().beep(); // opcional
                }*/
            }

            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
                if ((fb.getDocument().getLength() - length + text.length()) <= limite) {
                    super.replace(fb, offset, length, text, attrs);
                } 
                /*else {
                    Toolkit.getDefaultToolkit().beep(); // opcional
                }*/
            }
        });
    }
    
    
}
