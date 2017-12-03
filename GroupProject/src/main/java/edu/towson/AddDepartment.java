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
public class AddDepartment extends javax.swing.JPanel {

    private Model model = new Model();
    Model.ModelObserver mObserver = model.new ModelObserver();
    /**
     * Creates new form AddDepartment
     */
    public AddDepartment() {
        initComponents();
    }
    
    public AddDepartment(Model model) {
        super(new BorderLayout());
        this.model = model;
        model.addObserver(mObserver);
        
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ad_AddDeptBtn = new javax.swing.JButton();
        ad_mainMenuBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ad_deptName = new javax.swing.JTextField();
        ad_deptCode = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ad_deptOfficeNum = new javax.swing.JTextField();
        ad_addPhNumFormatted = new javax.swing.JFormattedTextField();

        ad_AddDeptBtn.setForeground(new java.awt.Color(206, 17, 38));
        ad_AddDeptBtn.setText("Add Dept");
        ad_AddDeptBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ad_AddDeptBtnActionPerformed(evt);
            }
        });

        ad_mainMenuBtn.setForeground(new java.awt.Color(206, 17, 38));
        ad_mainMenuBtn.setText("Main Menu");
        ad_mainMenuBtn.setToolTipText("");
        ad_mainMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RtnToMainMenuBtn(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add a Department");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel2.setText("Enter department name");

        jLabel3.setText("Enter department code");

        ad_deptName.setToolTipText("Enter department name");

        ad_deptCode.setToolTipText("Enter department code");

        jLabel4.setText("Enter office number");

        jLabel5.setText("Enter office phone number");

        ad_deptOfficeNum.setToolTipText("Enter office number");

        try {
            ad_addPhNumFormatted.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ad_addPhNumFormatted.setToolTipText("Enter only phone number digits");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(165, 165, 165)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(ad_mainMenuBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ad_AddDeptBtn))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(ad_deptOfficeNum)
                                    .addComponent(ad_deptName, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ad_deptCode, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(ad_addPhNumFormatted, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(0, 54, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ad_deptName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ad_deptCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ad_addPhNumFormatted, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ad_deptOfficeNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ad_AddDeptBtn)
                    .addComponent(ad_mainMenuBtn))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void RtnToMainMenuBtn(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RtnToMainMenuBtn
        String cmd = evt.getActionCommand();
            if ("Main Menu".equals(cmd)) {
                model.returnToMainMenu();
            }
    }//GEN-LAST:event_RtnToMainMenuBtn

    private void ad_AddDeptBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ad_AddDeptBtnActionPerformed
        // TODO Navya could you add logic here to perform the write of the form info to the database?
    	boolean sIdIsValid = checkDeptId();
    	boolean showErrorMsg = false;
        String errorMessage = "";
        String sql = "INSERT INTO DEPARTMENT(Dept_Name, Dept_Num, Office_No, Office_Ph_No) VALUES(?,?,?,?)";
        if(sIdIsValid==true){
            try (Connection conn = Main.connect();
                    PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.setString(1, ad_deptName.getText());
                pstmt.setInt(2, Integer.parseInt(ad_deptCode.getText()));
                pstmt.setInt(3, Integer.parseInt(ad_deptOfficeNum.getText()));
                pstmt.setString(4, ad_addPhNumFormatted.getText());
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Successfully added department");
                ad_deptName.setText("");
                ad_deptCode.setText("");
                ad_deptOfficeNum.setText("");
                ad_addPhNumFormatted.setText("");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
             
        else {
            if(sIdIsValid == false){
                errorMessage = errorMessage + "department code already exist \n";
                showErrorMsg = true;
            }
        }
        if(showErrorMsg == true){
            JOptionPane.showMessageDialog(null, errorMessage);
        }
    }//GEN-LAST:event_ad_AddDeptBtnActionPerformed
    
	private boolean checkDeptId() {
		boolean result = false;

		String sql = "SELECT * From DEPARTMENT WHERE Dept_Num = ?";
		try (Connection conn = Main.connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, ad_deptCode.getText());
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				result = false;
			} else {
				result = true;
			}

		} catch (SQLException e) {

		}
		return result;

	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ad_AddDeptBtn;
    private javax.swing.JFormattedTextField ad_addPhNumFormatted;
    private javax.swing.JTextField ad_deptCode;
    private javax.swing.JTextField ad_deptName;
    private javax.swing.JTextField ad_deptOfficeNum;
    private javax.swing.JButton ad_mainMenuBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
