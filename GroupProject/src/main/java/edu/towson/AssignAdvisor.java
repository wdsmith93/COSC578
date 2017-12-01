/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.towson;

import java.awt.BorderLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.*;

import javax.swing.JOptionPane;


/**
 *
 * @author williamsmith
 */
public class AssignAdvisor extends javax.swing.JPanel {

    private DatabaseView.Model model;
    
    /**
     * Creates new form AssignAdvisor
     */
    public AssignAdvisor() {
        initComponents();
    }
    
    public AssignAdvisor(DatabaseView.Model model) {
        super(new BorderLayout());
        this.model = model;
        //model.addObserver(new DatabaseView.View.ModelObserver());
        
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        assignAdvAssignBtn = new javax.swing.JButton();
        assignAdvMMBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        addAdvisor_studentID = new javax.swing.JTextField();
        addAdvisor_advisorId = new javax.swing.JTextField();

        assignAdvAssignBtn.setForeground(new java.awt.Color(206, 17, 38));
        assignAdvAssignBtn.setText("Assign");
        assignAdvAssignBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AssignBtnHandler(evt);
            }
        });
   
        
        addAdvisor_studentID.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				
			}

			@Override
			public void focusLost(FocusEvent e) {

				CheckStudentId(e);
				
			}
			
        });
        
        addAdvisor_advisorId.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				CheckAdvisorId(e);
			}
        	
        });
            
        assignAdvMMBtn.setForeground(new java.awt.Color(206, 17, 38));
        assignAdvMMBtn.setText("Main Menu");
        assignAdvMMBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainMenuBtnHandler(evt);
            }
        });

        jLabel1.setText("Assign an Advisor to a Student");

        jLabel2.setText("Enter student ID#");

        jLabel3.setText("Enter advisor ID#");

        addAdvisor_studentID.setToolTipText("Enter student id#");

        addAdvisor_advisorId.setToolTipText("Enter advisor id#");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(assignAdvMMBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(assignAdvAssignBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(addAdvisor_studentID, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(84, 84, 84)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(addAdvisor_advisorId, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 58, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addAdvisor_studentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addAdvisor_advisorId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(assignAdvAssignBtn)
                    .addComponent(assignAdvMMBtn))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void MainMenuBtnHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MainMenuBtnHandler
        String cmd = evt.getActionCommand();
            if ("Main Menu".equals(cmd)) {
                model.returnToMainMenu();
            }
    }//GEN-LAST:event_MainMenuBtnHandler

    private void AssignBtnHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AssignBtnHandler
    	String sql = "UPDATE STUDENT SET Advisor_Id =?  WHERE Sid = ?";
		try (Connection conn = Main.connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, addAdvisor_advisorId.getText());
			stmt.setString(2, addAdvisor_studentID.getText());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Successfully assigned advisor");
			addAdvisor_advisorId.setText("");
			addAdvisor_studentID.setText("");
		} catch (SQLException e) {

		}
    	
    }//GEN-LAST:event_AssignBtnHandler

	private void CheckStudentId(java.awt.event.FocusEvent evt) {

		String sql = "SELECT * From STUDENT WHERE Sid = ?";
		try (Connection conn = Main.connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, addAdvisor_studentID.getText());
			ResultSet rs = stmt.executeQuery();

			if (!rs.next()) {
				JOptionPane.showMessageDialog(null, "Enter Valid Student Id");
			}

		} catch (SQLException e) {

		}

	}
    
    private void CheckAdvisorId(java.awt.event.FocusEvent evt){

    	String sql = "SELECT * From INSTRUCTOR WHERE Instructor_Id = ?";
		try (Connection conn = Main.connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, addAdvisor_advisorId.getText());
			ResultSet rs = stmt.executeQuery();

			if (!rs.next()) {
				JOptionPane.showMessageDialog(null, "Enter Valid Advisor Id");
			}

		} catch (SQLException e) {

		}
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addAdvisor_advisorId;
    private javax.swing.JTextField addAdvisor_studentID;
    private javax.swing.JButton assignAdvAssignBtn;
    private javax.swing.JButton assignAdvMMBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
