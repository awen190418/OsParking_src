/*
 * Copyright (C) 2016 Open Source Parking, Inc.(www.osparking.com)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.osparking.osparking;

import static com.osparking.global.CommonData.buttonHeightNorm;
import static com.osparking.global.CommonData.buttonWidthNorm;
import static com.osparking.global.Globals.OSPiconList;
import static com.osparking.global.Globals.checkOptions;
import static com.osparking.global.Globals.font_Size;
import static com.osparking.global.Globals.font_Style;
import static com.osparking.global.Globals.font_Type;
import static com.osparking.global.Globals.head_font_Size;
import static com.osparking.global.Globals.initializeLoggers;
import static com.osparking.global.names.ControlEnums.ButtonTypes.CLOSE_BTN;
import static com.osparking.global.names.ControlEnums.TitleTypes.STAT_FORM_TITLE;
import static com.osparking.global.names.DB_Access.readSettings;
import java.awt.Dimension;
import java.awt.event.KeyEvent;

/**
 *
 * @author Open Source Parking, Inc.(www.osparking.com)
 */
public class DisplayStatFrame extends javax.swing.JFrame {
    ControlGUI mainGUI = null;
    
    /**
     * Creates new form DisplayStatFrame
     */
    public DisplayStatFrame(String message, ControlGUI mainGUI) {
        this.mainGUI = mainGUI;
        initComponents();
        messageArea.setText(message);
        setIconImages(OSPiconList);        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        messageArea = new javax.swing.JTextArea();
        closeFormButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(560, 600));
        setPreferredSize(new java.awt.Dimension(560, 600));

        messageArea.setEditable(false);
        messageArea.setColumns(20);
        messageArea.setFont(new java.awt.Font(font_Type, font_Style, font_Size));
        messageArea.setRows(5);
        messageArea.setText("단절회수 : 0번");
        jScrollPane1.setViewportView(messageArea);

        closeFormButton.setFont(new java.awt.Font(font_Type, font_Style, font_Size));
        closeFormButton.setMnemonic('c');
        closeFormButton.setText(CLOSE_BTN.getContent());
        closeFormButton.setMaximumSize(new Dimension(buttonWidthNorm, buttonHeightNorm));
        closeFormButton.setMinimumSize(new Dimension(buttonWidthNorm, buttonHeightNorm));
        closeFormButton.setPreferredSize(new Dimension(buttonWidthNorm, buttonHeightNorm));
        closeFormButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeFormButtonActionPerformed(evt);
            }
        });
        closeFormButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                closeFormButtonKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font(font_Type, font_Style, head_font_Size));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText(STAT_FORM_TITLE.getContent());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(closeFormButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE))))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(closeFormButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeFormButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeFormButtonActionPerformed
        if (mainGUI != null) {
            mainGUI.setStatPan(null);
        }
        dispose();
    }//GEN-LAST:event_closeFormButtonActionPerformed

    private void closeFormButtonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_closeFormButtonKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            dispose();
        }
    }//GEN-LAST:event_closeFormButtonKeyReleased

    static String indent4 = "    ";
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
            java.util.logging.Logger.getLogger(DisplayStatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DisplayStatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DisplayStatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DisplayStatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        initializeLoggers();
        checkOptions(args);
        readSettings();        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String message = 
                        "[장치별 소켓 단절 건수]" + System.lineSeparator()
                        + indent4 + "카메라 #1: 소켓 단절 없음." + System.lineSeparator()
                        + indent4 + "카메라 #2: 소켓 단절 없음." + System.lineSeparator()
                        + System.lineSeparator()
                        + indent4 + "전광판 #1: 소켓 단절 없음." + System.lineSeparator()
                        + indent4 + "전광판 #2: 소켓 단절 없음." + System.lineSeparator()
                        + System.lineSeparator()
                        + indent4 + "차단기 #1: 소켓 단절 없음." + System.lineSeparator()
                        + indent4 + "차단기 #2: 소켓 단절 없음." + System.lineSeparator()
                        + System.lineSeparator()
                        + "[통과 지연 평균(ms)]" + System.lineSeparator()
                        + indent4 + "입구#1: 23.9ms on 2016-11-06 12:02:19(10대)" + System.lineSeparator()
                        + indent4 + "입구#2: 44.5ms on 2016-11-07 17:40:53(10대)" + System.lineSeparator()
                        + System.lineSeparator()
                        + "* 인공 오류율 : N/A" + System.lineSeparator()
                        + "* 통과 지연 정의:" + System.lineSeparator()
                        + indent4 + "<차량 영상 첫 바이트 도달> ! <차단기 개방 지시 인지>" + System.lineSeparator();
                
                new DisplayStatFrame(message, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton closeFormButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea messageArea;
    // End of variables declaration//GEN-END:variables
}
