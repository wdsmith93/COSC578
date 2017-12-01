package edu.towson;

import java.awt.BorderLayout;
import java.sql.*;
import java.util.LinkedList;
import javax.swing.SpinnerModel;

/**
 *
 * @author williamsmith
 */
public class AddCourse extends javax.swing.JPanel {

    private DatabaseView.Model model;
    /**
     * Creates new form AddCourse
     */
    public AddCourse() {
        initComponents();
    }
    
    public AddCourse(DatabaseView.Model model) {
        super(new BorderLayout());
        this.model = model;
        //model.addObserver(new DatabaseView.View.ModelObserver());
        
        initComponents();
        
        //Using a linked list here so it can grow dynamically - array could have empty spaces that might show up in combo box
        LinkedList<String> list = new LinkedList();
        //TODO: IMPORTANT!! Need to get this dynamically from the database (query result?) and remove these adds when done
        String sql = "SELECT DISTINCT Dept_Name From DEPARTMENT";
        try (Connection conn = Main.connect();
            Statement stmt = conn.createStatement()){
        	ResultSet rs = stmt.executeQuery(sql);
        	while (rs.next()) {
        		list.add(rs.getString("Dept_Name"));
        	}
        } catch (SQLException e) {

        }
 /*       list.add("Computer Science");
        list.add("Mathematics");
        list.add("English Composition");
        list.add("Biological and Physical Sciences");
        list.add("Social and Behavioral Sciences");
        list.add("Arts and Humanities");
        list.add("Interdisciplinary and Emerging Issues");*/
        
        String[] fromLinkedList = list.toArray(new String[list.size()]);
        
        ac_selectDeptCombo.setModel(new javax.swing.DefaultComboBoxModel<>(fromLinkedList));
        
        
    }

    //TODO: Wire up the add course button to write to a new db record
    
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ac_addCourse = new javax.swing.JButton();
        ac_mainMenu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ac_courseID = new javax.swing.JTextField();
        ac_cTitle = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ac_cStartDate = new javax.swing.JFormattedTextField();
        ac_cEndDate = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        ac_cDescription = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        ac_selectDeptCombo = new javax.swing.JComboBox<>();

        ac_addCourse.setForeground(new java.awt.Color(206, 17, 38));
        ac_addCourse.setText("Add Course");
        ac_addCourse.setToolTipText("");
        ac_addCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ac_addCourseActionPerformed(evt);
            }
        });

        ac_mainMenu.setForeground(new java.awt.Color(206, 17, 38));
        ac_mainMenu.setText("Main Menu");
        ac_mainMenu.setToolTipText("");
        ac_mainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RtnToMainMenuBtn(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add a Course");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel2.setText("Enter course ID");

        jLabel3.setText("Enter course title");

        ac_courseID.setToolTipText("Enter course ID");

        ac_cTitle.setToolTipText("Enter course title");

        jLabel4.setText("Enter start date");

        jLabel5.setText("Enter end date");

        ac_cStartDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
        ac_cStartDate.setToolTipText("Enter date format YYYY-MM-DD");

        ac_cEndDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
        ac_cEndDate.setToolTipText("Format YYYY-MM-DD");

        jLabel6.setText("Enter course description");

        ac_cDescription.setToolTipText("Enter course description");

        jLabel7.setText("Select offering department");

        ac_selectDeptCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ac_selectDeptCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCourseDeptSelected(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(ac_courseID, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ac_mainMenu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ac_addCourse))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel1))
                            .addComponent(jLabel5)
                            .addComponent(ac_cTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ac_cDescription, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(ac_cStartDate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ac_cEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(35, 35, 35))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(ac_selectDeptCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                    .addComponent(ac_courseID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ac_cTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ac_cStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ac_cEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ac_cDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ac_selectDeptCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ac_addCourse)
                    .addComponent(ac_mainMenu))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void RtnToMainMenuBtn(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RtnToMainMenuBtn
        String cmd = evt.getActionCommand();
            if ("Main Menu".equals(cmd)) {
                model.returnToMainMenu();
            }
    }//GEN-LAST:event_RtnToMainMenuBtn

    private void AddCourseDeptSelected(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddCourseDeptSelected
        // TODO add your handling code here:  REALLY NEED TO DO THIS TO PASS SELECTION TO DB!
    }//GEN-LAST:event_AddCourseDeptSelected

    private void ac_addCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ac_addCourseActionPerformed
        // TODO Navya could you add logic here to perform the write of the form info to the database?
    }//GEN-LAST:event_ac_addCourseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ac_addCourse;
    private javax.swing.JTextField ac_cDescription;
    private javax.swing.JFormattedTextField ac_cEndDate;
    private javax.swing.JFormattedTextField ac_cStartDate;
    private javax.swing.JTextField ac_cTitle;
    private javax.swing.JTextField ac_courseID;
    private javax.swing.JButton ac_mainMenu;
    private javax.swing.JComboBox<String> ac_selectDeptCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
