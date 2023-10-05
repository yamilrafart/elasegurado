package utils;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

@SuppressWarnings("serial")
/**
 * 
 * Esta clase se utiliza para limitar la cantidad de caracteres
 * ingresados en un campo
 * 
 */
public class DocumentFilterLimit extends PlainDocument {
	private int limit;

    public DocumentFilterLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null) {
            return;
        }

        if ((getLength() + str.length()) <= limit) {
            super.insertString(offset, str, attr);
        }
    }
}