package edu.towson;

import java.awt.BorderLayout;

/**
 *
 * @author williamsmith
 */
public class AddPreferences extends javax.swing.JPanel {
    private Model model = new Model();
    Model.ModelObserver mObserver = model.new ModelObserver();
    
    private String userName = "";
    private String pWord = "";
    private String adminId = "";
    private String fName = "";
    private String mName = "";
    private String lName = "";
    
    /**
     * Creates new form AddPreferences
     */
    public AddPreferences() {
        initComponents();
    }
    
    public AddPreferences(Model model) {
        super(new BorderLayout());
        this.model = model;
        model.addObserver(mObserver);
        
        initComponents();
        
    }
    
    public String getPWord(){
        return pWord;
    }
    
    public String getuserName(){
        return userName;
    }
    
    public String getFName(){
        return fName;
    }
    
    public String getMName(){
        return mName;
    }
    
    public String getLName(){
        return lName;
    }
    
    public String getAdminId(){
        return adminId;
    }
    
    public void setPWord(String s){
        this.pWord = s;
    }
    
    public void setUserName(String s){
        this.userName = s;
    }
    
    public void setFName(String s){
        this.fName = s;
    }
    
    public void setMName(String s){
        this.mName = s;
    }
    
    public void setLName(String s){
        this.lName = s;
    }
    
    public void setAdminId(String s){
        this.adminId = s;
    }
    
    
    
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        mainMenuBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        mname = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        idNum = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        uname = new javax.swing.JTextField();
        pfield = new javax.swing.JPasswordField();

        jLabel6.setText("jLabel6");

        saveButton.setForeground(new java.awt.Color(206, 17, 38));
        saveButton.setText("Save");
        saveButton.setToolTipText("");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        mainMenuBtn.setForeground(new java.awt.Color(206, 17, 38));
        mainMenuBtn.setText("Main Menu");
        mainMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenuBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Configure User Preferences");

        jLabel2.setText("First name");

        jLabel3.setText("Middle name");

        jLabel4.setText("Last name");

        fname.setToolTipText("Enter first name");

        mname.setToolTipText("Enter middle name");

        lname.setToolTipText("Enter last name");

        jLabel5.setText("Id#");

        idNum.setToolTipText("Enter id#");

        jLabel7.setText("User name");

        jLabel8.setText("Password");

        uname.setToolTipText("Enter user name to access remote database");

        pfield.setToolTipText("Enter password for accessing remote database");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(mainMenuBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idNum, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(mname, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel1)
                            .addComponent(uname, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(lname, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                            .addComponent(jLabel8)
                            .addComponent(pfield))
                        .addGap(11, 11, 11)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 285, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(mainMenuBtn))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        //Navya we may want to look at not having the user preferences saved in the external db - that can expose passwords/etc
        //Might just want to save via instance variables or something like what I wrote here
        
        String f, m, l, u, p, a;
        f = fname.getText();
        m = mname.getText();
        l = lname.getText();
        u = uname.getText();
        p = pfield.getText();
        a = idNum.getText();
        
        if(!isNull(f))
            setFName(f);
        if(!isNull(m))
            setMName(m);
        if(!isNull(l))
            setLName(l);
        if(!isNull(u))
            setUserName(u);
        if(!isNull(p))
            setPWord(p);
        if(!isNull(a))
            setAdminId(a);
        
        fname.setText("");
        mname.setText("");
        lname.setText("");
        uname.setText("");
        pfield.setText("");
        idNum.setText("");
        
        
    }//GEN-LAST:event_saveButtonActionPerformed

    
    private boolean isNull(String s){
        return s.isEmpty();
    }
    
    
    private void mainMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenuBtnActionPerformed
        String cmd = evt.getActionCommand();
            if ("Main Menu".equals(cmd)) {
                model.returnToMainMenu();
            }
    }//GEN-LAST:event_mainMenuBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fname;
    private javax.swing.JTextField idNum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField lname;
    private javax.swing.JButton mainMenuBtn;
    private javax.swing.JTextField mname;
    private javax.swing.JPasswordField pfield;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField uname;
    // End of variables declaration//GEN-END:variables
}
