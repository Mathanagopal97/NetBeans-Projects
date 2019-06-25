/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mathan.frames;

import com.mathan.gopal.DataRetreiver;
import com.mathan.gopal.SearchClass;
import com.mathan.gopal.TextClass;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.DefaultCaret;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;

/**
 *
 * @author HP For highlight purposes -
 * http://www.java2s.com/Tutorials/Java/Swing_How_to/JEditorPane/Highlight_few_of_the_words_of_a_text_file_in_JEditorPane.htm
 * For jTextField listener -
 * http://www.java2s.com/Tutorial/Java/0260__Swing-Event/ListeningtoJTextFieldEventswithaDocumentListener.htm
 */
class MyHighlightPainter extends DefaultHighlighter.DefaultHighlightPainter {

    public MyHighlightPainter(Color color) {
        super(color);
    }
}

public class MainFrame extends javax.swing.JFrame {

    MyHighlightPainter myHighlightPainter = new MyHighlightPainter(
            Color.red);

    ArrayList<String> phrases = new ArrayList<String>();

    /**
     * Creates new form MainFrame
     *
     * @param textComp
     * @param pattern
     * @throws java.lang.Exception
     */
    public void highlight(JTextComponent textComp, String pattern)
            throws Exception {
        removeHighlights(textComp);
        Highlighter hilite = textComp.getHighlighter();
        Document doc = textComp.getDocument();
        String text = doc.getText(0, doc.getLength());
        int pos = 0;
        for (String str : phrases) {
            str = str.trim();
            while ((pos = text.indexOf(str, pos)) >= 0) {
                hilite.addHighlight(pos, pos + str.length(), myHighlightPainter);
                pos += str.length();
            }
            pos = 0;
        }
    }

    public void removeHighlights(JTextComponent textComp) {
        Highlighter hilite = textComp.getHighlighter();
        Highlighter.Highlight[] hilites = hilite.getHighlights();

        for (int i = 0; i < hilites.length; i++) {
            if (hilites[i].getPainter() instanceof MyHighlightPainter) {
                hilite.removeHighlight(hilites[i]);
            }
        }
    }

    public MainFrame() throws Exception {
        initComponents();
        ArrayList<TextClass> textClassArrayList = new ArrayList<TextClass>();
        ArrayList<String> name = new ArrayList<String>();
        //   String searchString = "Hello";
        DefaultCaret caret = (DefaultCaret) jTextArea1.getCaret();
        caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);

        File actual = new File(".\\Subtitles");
        for (File f : actual.listFiles()) {
            String fileName = f.getName();
            fileName = fileName.replaceFirst("[.][^.]+$", "");
            name.add(fileName);
        }

        for (int i = 0; i < 10; i++) {
            int escapeChar;
            TextClass textClassObject = new TextClass();
            if (i == 3) {
                escapeChar = 10;
            } else {
                escapeChar = 13;
            }
            textClassArrayList.add(DataRetreiver.retreiveData(textClassObject, name.get(i), escapeChar));
        }

        DocumentListener documentListener;
        documentListener = new DocumentListener() {
            public void changedUpdate(DocumentEvent documentEvent) {
                try {
                    printIt(documentEvent);
                } catch (Exception ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            public void insertUpdate(DocumentEvent documentEvent) {
                try {
                    printIt(documentEvent);
                } catch (Exception ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            public void removeUpdate(DocumentEvent documentEvent) {
                try {
                    printIt(documentEvent);
                } catch (Exception ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            private void printIt(DocumentEvent documentEvent) throws Exception {
                DocumentEvent.EventType type = documentEvent.getType();
                String typeString = null;
                if (type.equals(DocumentEvent.EventType.CHANGE)) {
                    typeString = "Change";
                } else if (type.equals(DocumentEvent.EventType.INSERT)) {
                    typeString = "Insert";
                } else if (type.equals(DocumentEvent.EventType.REMOVE)) {
                    typeString = "Remove";
                    jTextArea1.setText("");
                }
                //  System.out.print("Type : " + typeString);
                Document source = documentEvent.getDocument();
                int length = source.getLength();
                String textFromField = jTextField1.getText();
                //    System.out.println("Length: " + length + " " + textFromField);
                if (length >= 3) {
                    ArrayList<ArrayList<String>> finalResult
                            = SearchClass.searchFunction(textClassArrayList, textFromField);;
                    ArrayList<String> result = finalResult.get(0);
                    phrases = finalResult.get(1);
                    jTextArea1.setText("");
                    for (String str : result) {
                        // System.out.println(str);
                        if (jTextArea1.getText().equals("") || jTextArea1.getText() == null) {
                            jTextArea1.setText(str + "\n");
                        } else {
                            jTextArea1.setText(jTextArea1.getText() + "\n" + str + "\n");
                        }
                    }
                    highlight(jTextArea1, textFromField);
//                    highlight(jTextArea1, textFromField.toLowerCase());
//                    highlight(jTextArea1, textFromField.toUpperCase());
                }
            }
        };

        jTextField1.getDocument().addDocumentListener(documentListener);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));

        jTextField1.setBackground(new java.awt.Color(0, 0, 0));
        jTextField1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setToolTipText("");
        jTextField1.setCaretColor(new java.awt.Color(255, 255, 255));

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(102, 102, 102));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Lucida Sans", 0, 20)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setBorder(null);
        jTextArea1.setDragEnabled(true);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 952, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainFrame().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
