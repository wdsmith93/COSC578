package edu.towson;

import javax.swing.JPanel;

/**
 * Control portion of the MVC-architecture paradigm
 * @author williamsmith
 */
public class Control extends JPanel {
    private Model model;
    private MainMenu mainMenu;
    private AddStudent addStudent;
    private AddCourse addCourse;
    private AddDepartment addDepartment;
    private AddInstructor addInstructor;
    private AddAdmin addAdmin;
    private SearchMenu searchMenu;
    private AssignAdvisor assignAdvisor;
    private AssignInstructor assignInstructor;
    private QueryResult queryResult;
    private TableList item;
    
    public Control(Model model, SearchMenu sm) {
        this.model = model;
        this.searchMenu = sm;
    }
    
    public Control(Model model, AddAdmin aa) {
        this.model = model;
        this.addAdmin = aa;
    }
    
    public Control(Model model, AddInstructor ai) {
        this.model = model;
        this.addInstructor = ai;
    }
    
    public Control(Model model, AddDepartment ad) {
        this.model = model;
        this.addDepartment = ad;
    }
    
    public Control(Model model, MainMenu mm) {
        this.model = model;
        this.mainMenu = mm;
    }
    
    public Control(Model model, AddStudent as) {
        this.model = model;
        this.addStudent = as;
    }
    
    public Control(Model model, AddCourse ac) {
        this.model = model;
        this.addCourse = ac;
    }
    
    public Control(Model model, AssignAdvisor aa) {
        this.model = model;
        this.assignAdvisor = aa;
    }
    
    public Control(Model model, AssignInstructor ai) {
        this.model = model;
        this.assignInstructor = ai;
    }
    
    public Control(Model model, QueryResult qr, TableList item) {
        this.model = model;
        this.queryResult = qr;
        this.item = item;
    }
}
