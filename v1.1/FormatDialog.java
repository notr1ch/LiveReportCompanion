/**
 * This class creates a dialog box in which the user inputs the number of sets
 * per match and the number of total matches according to the specifications 
 * required elsewhere in the program. On submission the class becomes not visible,
 * and information is extracted from the TextField elements before disposal.
 * <p>
 * Large portions of this code was generated by NetBeans
 * <p>
 * This class was created for MHacks - Fall 2013
 * 
 * @author   packrat386
 * @version  %I%, %G%
 * @see      javax.swing.JTextField
 */

public class FormatDialog extends javax.swing.JDialog {
  
  /**
   * Creates new form FormatDialog <code> parent specifies a parent
   * relationship for this dialog, and modal toggles whether or not
   * the window is able to be de-selected.
   * 
   * @param   parent  either the frame object that created the dialog
   *                  or null
   * @param   modal   toggles whether the window can be deselected
   */
  public FormatDialog(java.awt.Frame parent, boolean modal) {
    super(parent, modal);
    initComponents();
  }
  
  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    
    bestOfPrompt = new javax.swing.JLabel();
    bestOfTextField = new javax.swing.JTextField();
    numMatchesPrmopt1 = new javax.swing.JLabel();
    numMatchesPrompt2 = new javax.swing.JLabel();
    numMatchesTextField = new javax.swing.JTextField();
    submit = new javax.swing.JButton();
    
    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    
    bestOfPrompt.setText("Please enter the number of sets per match");
    
    bestOfTextField.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bestOfTextFieldActionPerformed(evt);
      }
    });
    
    numMatchesPrmopt1.setText("Please enter the number of matches to be played");
    
    numMatchesPrompt2.setText("(If you selected the Dual Tournament option, this should be 2)");
    
    submit.setText("Submit");
    submit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        submitActionPerformed(evt);
      }
    });
    
    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
                              layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(bestOfPrompt)
                                                                                .addComponent(bestOfTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(numMatchesPrmopt1)
                                                                                .addComponent(numMatchesPrompt2))
                                                                    .addContainerGap(41, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                    .addComponent(numMatchesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                    .addGap(0, 0, Short.MAX_VALUE)
                                                                    .addComponent(submit))))
                             );
    layout.setVerticalGroup(
                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addGroup(layout.createSequentialGroup()
                                          .addContainerGap()
                                          .addComponent(bestOfPrompt)
                                          .addGap(18, 18, 18)
                                          .addComponent(bestOfTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addGap(18, 18, 18)
                                          .addComponent(numMatchesPrmopt1)
                                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                          .addComponent(numMatchesPrompt2)
                                          .addGap(18, 18, 18)
                                          .addComponent(numMatchesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                          .addComponent(submit)
                                          .addContainerGap())
                           );
    
    pack();
  }// </editor-fold>//GEN-END:initComponents
  
  /**
   * This function is called if a particular action is done to bestOfTextField, but
   * it is empty
   * 
   * @param   evt  the ActionEvent that triggers the function
   */
  private void bestOfTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bestOfTextFieldActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_bestOfTextFieldActionPerformed
  
  /**
   * This function is called if the Submit button is pressed and makes the
   * Dialog box no longer visible
   * 
   * @param   evt  the ActionEvent that triggers the function
   */
  private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
    setVisible(false);
  }//GEN-LAST:event_submitActionPerformed
  
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
      java.util.logging.Logger.getLogger(FormatDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(FormatDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(FormatDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(FormatDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>
    
    /* Create and display the dialog */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        FormatDialog dialog = new FormatDialog(new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
          @Override
          public void windowClosing(java.awt.event.WindowEvent e) {
            System.exit(0);
          }
        });
        dialog.setVisible(true);
      }
    });
  }
  
  /**
   * Returns the content of the bestOfTextField as an integer
   * 
   * @return   The integer representation of bestOfTextField
   * @see      #bestOfTextField
   */
  public int getBestOf(){
    return Integer.parseInt(bestOfTextField.getText());
  }
  
   /**
   * Returns the content of the numMatchesTextField as an integer
   * 
   * @return   The integer representation of numMatchesTextField
   * @see      #numMatchesTextField
   */
  public int getNumMatches(){
    return Integer.parseInt(numMatchesTextField.getText());
  }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  
  /**
   * This JLabel holds the prompt for the user to enter the number of sets
   * per match.
   */
  private javax.swing.JLabel bestOfPrompt;
  
  /**
   * This JTextField takes in the information provided by the user about the
   * number of sets per match
   * 
   * @see   #getBestOf()
   */
  private javax.swing.JTextField bestOfTextField;
  
  /**
   * This JLabel holds the first part prompt for the user to enter the 
   * total number of matches
   */
  private javax.swing.JLabel numMatchesPrmopt1;
  
  /**
   * This JLabel holds the first part prompt for the user to enter the 
   * total number of matches
   */
  private javax.swing.JLabel numMatchesPrompt2;
  
  /**
   * This JTextField takes in the information provided by the user about the
   * total number of matches
   * 
   * @see   #getNumMatches
   */
  private javax.swing.JTextField numMatchesTextField;
  
  /**
   * This JButton is the trigger to close the window and extract the user
   * provided data
   */
  private javax.swing.JButton submit;
  // End of variables declaration//GEN-END:variables
}