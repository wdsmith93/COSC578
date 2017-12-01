package edu.towson;

import java.awt.BorderLayout;

/**
 *
 * @author williamsmith
 */
public class MainMenu extends javax.swing.JPanel {

    private DatabaseView.Model model;
    /**
     * Creates new form MainMenu
     */
    public MainMenu() {
        initComponents();
    }
    
    public MainMenu(DatabaseView.Model model) {
        super(new BorderLayout());
        this.model = model;
        initComponents();
        //TODO: Add new "adds" here to this list to show in combo box
        String[] list = new String[]{" ", "Add a student", "Add a department", "Add an advisor", "Add admin data", 
            "Add a course"};
        mm_addCombo.setModel(new javax.swing.DefaultComboBoxModel<>(list));
        
        //TODO: Add new "actions" here to this list to show in combo box
        String[] actionList = new String[]{" ", "Assign advisor to student", "", "", "", 
            ""};
        mm_selectActionComboBx.setModel(new javax.swing.DefaultComboBoxModel<>(actionList));
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        populateDbButton = new javax.swing.JButton();
        searchMMButton = new javax.swing.JButton();
        mm_addCombo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        mm_selectActionComboBx = new javax.swing.JComboBox<>();

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Main Menu");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        populateDbButton.setForeground(new java.awt.Color(206, 17, 38));
        populateDbButton.setText("Populate database with randomized data");
        populateDbButton.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        populateDbButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                populateDbButtonActionPerformed(evt);
            }
        });

        searchMMButton.setForeground(new java.awt.Color(206, 17, 38));
        searchMMButton.setText("Search Records");
        searchMMButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchMMButtonActionPerformed(evt);
            }
        });

        mm_addCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        mm_addCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainMenuAddItemSelected(evt);
            }
        });

        jLabel2.setText("Select data to add:");

        jLabel3.setText("Search for data:");

        jLabel4.setText("Select an action:");

        mm_selectActionComboBx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        mm_selectActionComboBx.setToolTipText("");
        mm_selectActionComboBx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectAnActionCBHandler(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 120, Short.MAX_VALUE)
                        .addComponent(populateDbButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mm_addCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mm_selectActionComboBx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchMMButton))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(mm_addCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(searchMMButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(mm_selectActionComboBx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(populateDbButton)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void populateDbButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_populateDbButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_populateDbButtonActionPerformed

    private void MainMenuAddItemSelected(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MainMenuAddItemSelected
        int selection = mm_addCombo.getSelectedIndex();
        switch(selection){
            case 1:
                model.goToAddStudent();
                break;
            case 2:
                model.goToAddDept();
                break;
            case 3:
                model.goToAddAdvisor();
                break;
            case 4:
                model.goToAddAdmin();
                break;
            case 5:
                model.goToAddCourse();
                break;
        }
        
    }//GEN-LAST:event_MainMenuAddItemSelected

    private void searchMMButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchMMButtonActionPerformed
        String cmd = evt.getActionCommand();
            if ("Search Records".equals(cmd)) {
                model.goToSearchMenu();
            }
    }//GEN-LAST:event_searchMMButtonActionPerformed

    private void SelectAnActionCBHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectAnActionCBHandler
        int selection = mm_selectActionComboBx.getSelectedIndex();
        switch(selection){
            case 1:
                model.goToAssignAdvisor();
                break;
            case 2:
                //TODO
                break;
            case 3:
                //TODO
                break;
            case 4:
                //TODO
                break;
            case 5:
                //TODO
                break;
        }
    }//GEN-LAST:event_SelectAnActionCBHandler


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JComboBox<String> mm_addCombo;
    private javax.swing.JComboBox<String> mm_selectActionComboBx;
    private javax.swing.JButton populateDbButton;
    private javax.swing.JButton searchMMButton;
    // End of variables declaration//GEN-END:variables
}
