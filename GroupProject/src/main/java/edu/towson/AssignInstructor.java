/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.towson;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author williamsmith
 */
public class AssignInstructor extends javax.swing.JPanel {

    private DatabaseView.Model model;
    /**
     * Creates new form AssignInstructor
     */
    public AssignInstructor() {
        initComponents();
    }
    
    public AssignInstructor(DatabaseView.Model model) {
        super(new BorderLayout());
        this.model = model;
        initComponents();
        
    }
    
    private boolean checkInstId() {
        boolean result = false;
            String sql = "SELECT * From INSTRUCTOR WHERE Instructor_Id = ?";
            try (Connection conn = Main.connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, assignInst_enterInstId.getText());
                ResultSet rs = stmt.executeQuery();

                if (!rs.next()) {
                        result = false;
                } else {
                    result = true;
                }
            } catch (SQLException e) {

            }
            return result;
    }
    
    private boolean checkCourseNum(){
        boolean result = false;
    	String sql = "SELECT * From COURSE WHERE Course_Id = ?";
		try (Connection conn = Main.connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, assignInst_enterCourseNum.getText());
			ResultSet rs = stmt.executeQuery();

			if (!rs.next()) {
                                result = false;
			} else {
                            result = true;
                        }

		} catch (SQLException e) {

		}
                return result;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        assignBtn = new javax.swing.JButton();
        mainMenuBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        assignInst_enterInstId = new javax.swing.JTextField();
        assignInst_enterCourseNum = new javax.swing.JTextField();

        assignBtn.setForeground(new java.awt.Color(206, 17, 38));
        assignBtn.setText("Assign");
        assignBtn.setToolTipText("");
        assignBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignBtnActionPerformed(evt);
            }
        });

        mainMenuBtn.setForeground(new java.awt.Color(206, 13, 38));
        mainMenuBtn.setText("Main Menu");
        mainMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenuBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Assign Instructor to a Course");

        jLabel2.setText("Enter instructor id#");

        jLabel3.setText("Enter course#");

        assignInst_enterInstId.setToolTipText("Enter instructor id#");

        assignInst_enterCourseNum.setToolTipText("Enter course number");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mainMenuBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(assignBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(assignInst_enterInstId, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(assignInst_enterCourseNum, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(assignInst_enterInstId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(assignInst_enterCourseNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(assignBtn)
                    .addComponent(mainMenuBtn))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void assignBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignBtnActionPerformed
        boolean instIdIsValid = checkInstId();
        boolean cNumIsValid = checkCourseNum();
        boolean showErrorMsg = false;
        String errorMessage = "";
        String sql = "UPDATE COURSE SET Instructor_Id =?  WHERE Course_Id = ?";
        
        if (instIdIsValid == true && cNumIsValid == true){
		try (Connection conn = Main.connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, assignInst_enterInstId.getText());
			stmt.setString(2, assignInst_enterCourseNum.getText());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Successfully assigned instructor");
			assignInst_enterInstId.setText("");
			assignInst_enterCourseNum.setText("");
		} catch (SQLException e) {

		}
        } else {
            if(instIdIsValid == false){
                errorMessage = errorMessage + "Please enter a valid instructor id number\n";
                showErrorMsg = true;
            }
            if(cNumIsValid == false){
                errorMessage = errorMessage + "Please enter a valid course number\n";
                showErrorMsg = true;
            }
        }
        if(showErrorMsg == true){
            JOptionPane.showMessageDialog(null, errorMessage);
        }
    }//GEN-LAST:event_assignBtnActionPerformed

    private void mainMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenuBtnActionPerformed
        String cmd = evt.getActionCommand();
            if ("Main Menu".equals(cmd)) {
                model.returnToMainMenu();
            }
    }//GEN-LAST:event_mainMenuBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignBtn;
    private javax.swing.JTextField assignInst_enterCourseNum;
    private javax.swing.JTextField assignInst_enterInstId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton mainMenuBtn;
    // End of variables declaration//GEN-END:variables
}