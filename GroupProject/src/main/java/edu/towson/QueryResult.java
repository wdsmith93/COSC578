package edu.towson;


import java.awt.BorderLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

/**
 *
 * @author williamsmith
 */
public class QueryResult extends javax.swing.JPanel {
    
    ResultSet rs, rsForSelection;
    List<Object> options = new ArrayList<>();
    String sql = "";
    //static TableList tableList = TableList.COURSE;
    TableList tableList;
    
    //This is the column in a table holding a primary key to uniquely id a row for edits/deletions
    int keyColumn;
    String keyColumnName;
    
    private Model model = new Model();
    Model.ModelObserver mObserver = model.new ModelObserver();
    
    /**
     * Creates new form QueryResult
     */
    public QueryResult() {
        initComponents();
    }
    
    public TableList getQueryResultTableListItem() {
        return tableList;
    }
    
    public void setQueryResultTableListItem(TableList tl) {
        this.tableList = tl;
    }
    
    /**
     * This constructor is used to help identify the table used in the query results
     * Options for selecting records to edit/delete will be based on which table
     * was included in the results. 
     * For example, queries on the STUDENT table would use Sid for the combo box to select which item to edit/delete
     * @param model 
     * @param item enum representing table used in query
     */
    public QueryResult(Model model, TableList item) {
        super(new BorderLayout());
        this.model = model;
        this.tableList = item;
        model.addObserver(mObserver);
        switch(item){
            case STUDENT:
                keyColumn = 1;
                tableList = TableList.STUDENT;
                keyColumnName = "student id#";
                sql = "SELECT * From STUDENT";
                break;
        case ENROLLS:
            //TODO: For this we need to show option for composite key?
                keyColumn = 1;
                keyColumnName = "SSN#";
                break;
        case STUDENT_PHONE:
            //TODO: For this we need to show option for composite key?
                keyColumn = 2;
                keyColumnName = "SSN#";
                break;
        case COURSE:
                keyColumn = 1;
                tableList = TableList.COURSE;
                keyColumnName = "course id#";
                sql = "SELECT * From COURSE";
                break;
        case INSTRUCTOR:
                keyColumn = 1;
                //DatabaseView.setItem(TableList.INSTRUCTOR);
                tableList = TableList.INSTRUCTOR;
                keyColumnName = "instructor id#";
                sql = "SELECT * From INSTRUCTOR";
                break;
        case DEPARTMENT:
                keyColumn = 2;
                tableList = TableList.DEPARTMENT;
                keyColumnName = "department#";
                sql = "SELECT * From DEPARTMENT";
                break;
        case PREREQUESITE:
            //TODO: For this we need to show option for composite key?
                keyColumn = 1;
                keyColumnName = "course id#";
                break;
        case IDCARD:
                keyColumn = 1;
                tableList = TableList.IDCARD;
                keyColumnName = "id card#";
                sql = "SELECT * From IDCARD";
                break;
        case ADMIN:
                keyColumn = 1;
                keyColumnName = "admin id#";
                break;
        case CLASSROOM:
                keyColumn = 1;
                keyColumnName = "class id#";
                sql = "SELECT * From CLASSROOM";
                break;
        case CLASSCOURSE:
            //TODO: For this we need to show option for composite key?
                keyColumn = 1;
                keyColumnName = "class id#";
                break;
        case COMPLEX_QUERY1:
                keyColumn = 4;
                keyColumnName = "course id#";
                sql = "SELECT s.FName, s.Middle, s.LName, c.Course_Id, c.Course_Title, e.Grade FROM STUDENT s, ENROLLS e, COURSE c WHERE s.SSN = e.SSN AND c.Course_Id=e.Course_Id";
                break;
        case COMPLEX_QUERY2:
                keyColumn = 4;
                keyColumnName = "course id#";
                sql = "SELECT i.First, i.Middle, i.Last, d.Dept_Num FROM INSTRUCTOR i, DEPARTMENT d WHERE i.Dept_Num=d.Dept_Num";
                break;
        case COMPLEX_QUERY3:
                keyColumn = 4;
                keyColumnName = "course id#";
                sql = "SELECT i.Instructor_Id, i.First, i.Middle, i.Last, c.Course_Title FROM COURSE c, INSTRUCTOR i WHERE c.Instructor_Id=i.Instructor_Id";
                break;
        case COMPLEX_QUERY4:
                keyColumn = 4;
                keyColumnName = "course id#";
                sql = "SELECT Class_Id FROM CLASSROOM WHERE Location ='Liberty Heights'";
                break;
        case COMPLEX_QUERY5:
                keyColumn = 4;
                keyColumnName = "course id#";
                sql = "SELECT s.FName, s.LName, i.First, i.Last FROM STUDENT s, INSTRUCTOR i WHERE s.Advisor_Id=i.Instructor_Id;";
                break;
        
        }
        
        initComponents();
        updateTableWithResults(sql);
    }
    
    private void updateTableWithResults(String s) {
            try (Connection conn = Main.connect(); 
                    PreparedStatement stmt = conn.prepareStatement(s)) {	
                //stmt.setString(1, TODO.getText());
                rs = stmt.executeQuery();
                if (!rs.next()) {
                } else {
                    resultTable.setModel(ReusableTableModel.buildTableModel(rs));
                }
                rsForSelection = stmt.executeQuery();
                while (rsForSelection.next()) {
                    options.add(rsForSelection.getString(keyColumn));
                }
                conn.close();
            } catch (SQLException e) {

            }
            
            jLabel1.setText(s);
            jScrollPane1.setViewportView(resultTable);

	}

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainMenuBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();
        selectRecordEditBtn = new javax.swing.JButton();
        selectRecordDeleteBtn = new javax.swing.JButton();

        mainMenuBtn.setForeground(new java.awt.Color(206, 17, 38));
        mainMenuBtn.setText("Main Menu");
        mainMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenuBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Search Result");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        resultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        resultTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(resultTable);

        selectRecordEditBtn.setForeground(new java.awt.Color(206, 17, 38));
        selectRecordEditBtn.setText("Select Record to Edit");
        selectRecordEditBtn.setToolTipText("");
        selectRecordEditBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectRecordEditBtnActionPerformed(evt);
            }
        });

        selectRecordDeleteBtn.setForeground(new java.awt.Color(206, 17, 38));
        selectRecordDeleteBtn.setText("Select Record to Delete");
        selectRecordDeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectRecordDeleteBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(selectRecordDeleteBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectRecordEditBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mainMenuBtn))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mainMenuBtn)
                    .addComponent(selectRecordDeleteBtn)
                    .addComponent(selectRecordEditBtn))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void mainMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenuBtnActionPerformed
        String cmd = evt.getActionCommand();
            if ("Main Menu".equals(cmd)) {
                model.returnToMainMenu();
            }
    }//GEN-LAST:event_mainMenuBtnActionPerformed

    private void selectRecordEditBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectRecordEditBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectRecordEditBtnActionPerformed

    private void selectRecordDeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectRecordDeleteBtnActionPerformed
        String selectedChoice =  (String) JOptionPane.showInputDialog(null,
            "Select " + keyColumnName  + " to delete",
            "Delete a Record",
            JOptionPane.QUESTION_MESSAGE,
            null,
            options.toArray(),
            options.get(3));
        System.out.println(selectedChoice);      
 //   	int row = resultTable.getSelectedRow();
 //   	String ssn = (String) resultTable.getValueAt(row, 3);
    	/*String sql = "DELETE FROM STUDENT WHERE SSN = "+ssn;
    	try (Connection conn = Main.connect(); Statement stmt = conn.createStatement()) {
			int rs = stmt.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Successfully deleted record");
			System.out.println(rs);
		} catch (SQLException e) {
			//System.out.println(e);
			logger.log(Level.INFO, "Failed to delete from STUDENT.", e);
			JOptionPane.showMessageDialog(null, "Cannot delete! Foriegn Key constraint");

		}*/
        deleteResult(model, tableList);
      }//GEN-LAST:event_selectRecordDeleteBtnActionPerformed
    
    public void deleteResult(Model model, TableList item) {
        this.model = model;
        this.tableList = item;
        model.addObserver(mObserver);
        int row = resultTable.getSelectedRow();
        switch(item){
        case STUDENT:
               keyColumn = 1;
               tableList = TableList.STUDENT;
               keyColumnName = "student id#";
               String ssn = (String) resultTable.getValueAt(row, 3);
               sql = "DELETE FROM STUDENT WHERE SSN = "+ssn;
               break;
       case COURSE:
               keyColumn = 1;
               tableList = TableList.COURSE;
               keyColumnName = "course id#";
               String courseId = (String) resultTable.getValueAt(row, 0);
               sql = "DELETE FROM COURSE WHERE Course_Id = "+courseId;
               break;
       case INSTRUCTOR:
               keyColumn = 1;
               //DatabaseView.setItem(TableList.INSTRUCTOR);
               tableList = TableList.INSTRUCTOR;
               keyColumnName = "instructor id#";
               int instructorId = (Integer) resultTable.getValueAt(row, 0);
               sql = "DELETE FROM INSTRUCTOR WHERE Instructor_Id = "+instructorId;
               break;
       case IDCARD:
               keyColumn = 1;
               tableList = TableList.IDCARD;
               keyColumnName = "id card#";
               String sId = (String) resultTable.getValueAt(row, 0);
               sql = "DELETE FROM IDCARD WHERE Id_No = "+sId;
               break;
       case CLASSROOM:
           keyColumn = 1;
           keyColumnName = "class id#";
           int classId = (Integer) resultTable.getValueAt(row, 0);
           sql = "DELETE FROM CLASSROOM WHERE Class_Id = "+classId;
           break;
        }
        
        deleteRecWithResults(sql);
    }
    
    private void deleteRecWithResults(String s) {
        try (Connection conn = Main.connect(); 
                PreparedStatement stmt = conn.prepareStatement(s)) {	
            //stmt.setString(1, TODO.getText());
           int rs = stmt.executeUpdate();
           JOptionPane.showMessageDialog(null, "Deletion successful");
            conn.close();
        } catch (SQLException e) {
        	//logger.log(Level.INFO, "Failed to delete.", e);
			JOptionPane.showMessageDialog(null, "Cannot delete! Foriegn Key constraint");
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton mainMenuBtn;
    private javax.swing.JTable resultTable;
    private javax.swing.JButton selectRecordDeleteBtn;
    private javax.swing.JButton selectRecordEditBtn;
    // End of variables declaration//GEN-END:variables
}
