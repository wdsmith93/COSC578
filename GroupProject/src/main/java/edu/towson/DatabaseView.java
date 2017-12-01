package edu.towson;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

/**
 *
 * @author williamsmith
 */
public class DatabaseView extends JPanel {
    
        CardLayout layout = new CardLayout();
        //This is the panel that will hold all the other panels we switch between
        JPanel panelSet = new JPanel();
    
    
    public DatabaseView() {
        Model model = new Model();
        View view = new View(model);
        MainMenu mainMenu = new MainMenu(model);
        AddStudent addStudent = new AddStudent(model);
        AddCourse addCourse = new AddCourse(model);
        AddDepartment addDepartment = new AddDepartment(model);
        AddAdmin addAdmin = new AddAdmin(model);
        AddInstructor addInstructor = new AddInstructor(model);
        SearchMenu searchMenu = new SearchMenu(model);
        AssignAdvisor assignAdvisor = new AssignAdvisor(model);
        AssignInstructor assignInstructor = new AssignInstructor(model);
        QueryResult queryResult = new QueryResult(model);
        Control control2 = new Control(model, mainMenu);
        Control control3 = new Control(model, addStudent);
        Control control4 = new Control(model, addCourse);
        Control control5 = new Control(model, addDepartment);
        Control control6 = new Control(model, addInstructor);
        Control control7 = new Control(model, addAdmin);
        Control control8 = new Control(model, searchMenu);
        Control control9 = new Control(model, assignAdvisor);
        Control control1 = new Control(model, assignInstructor);
        Control control10 = new Control(model, queryResult);
      
        panelSet = this;
        panelSet.setLayout(layout);
        
        //first one added will always be first to show
        panelSet.add(mainMenu, "main_menu");
        panelSet.add(addStudent, "add_student");
        panelSet.add(addCourse, "add_course");
        panelSet.add(addDepartment, "add_dept");
        panelSet.add(addAdmin, "add_admin");
        panelSet.add(addInstructor, "add_instructor");
        panelSet.add(searchMenu, "search_menu");
        panelSet.add(assignAdvisor, "assign_advisor");
        panelSet.add(assignInstructor, "assign_instructor");
        panelSet.add(queryResult, "query_result");
        panelSet.add(control1);
        panelSet.add(control2);
        panelSet.add(control3);
        panelSet.add(control4);
        panelSet.add(control5);
        panelSet.add(control6);
        panelSet.add(control7);
        panelSet.add(control8);
        panelSet.add(control9);
        panelSet.add(control10);
    }
    
/**
 * Control portion of the MVC-architecture paradigm
 */   
class Control extends JPanel {

    private Model model;
    private View view;
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

    public Control(Model model, View view) {
        this.model = model;
        this.view = view;
    }
    
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
    
    public Control(Model model, QueryResult qr) {
        this.model = model;
        this.queryResult = qr;
    }

    
}

/*
 * View
 */
class View extends JPanel {

    private Model model;

    public View(Model model) {
        super(new BorderLayout());
        this.model = model;
        model.addObserver(new ModelObserver());
    }

/**
 * Controls which card is visible based on the observed
 */
    public class ModelObserver implements Observer {
        @Override
        public void update(Observable o, Object arg) {
            if (arg == CardSelection.MAIN_MENU) {
                layout.show(panelSet, "main_menu");
            } 
            if (arg == CardSelection.ADD_STUDENT) {
                layout.show(panelSet, "add_student");
            } 
            if (arg == CardSelection.ADD_COURSE) {
                layout.show(panelSet, "add_course");
            } 
            if (arg == CardSelection.ADD_DEPT) {
                layout.show(panelSet, "add_dept");
            } 
            if (arg == CardSelection.ADD_INSTRUCTOR) {
                layout.show(panelSet, "add_instructor");
            } 
            if (arg == CardSelection.ADD_ADMIN) {
                layout.show(panelSet, "add_admin");
            } 
            if (arg == CardSelection.SEARCH_MENU) {
                layout.show(panelSet, "search_menu");
            } 
            if (arg == CardSelection.ASSIGN_ADVISOR) {
                layout.show(panelSet, "assign_advisor");
            } 
            if (arg == CardSelection.ASSIGN_INSTRUCTOR) {
                layout.show(panelSet, "assign_instructor");
            }
            if (arg == CardSelection.QUERY_RESULT) {
                layout.show(panelSet, "query_result");
            }
        }
    }
}

/*
 * Model class that is part of the MVC-architecture paradigm used in this program
 */
class Model extends Observable {

    private final CardSelection[] pages = CardSelection.values();
    private CardSelection cSelection = init();
//TODO: This is ugly. Make it better
    private CardSelection init() {
        return pages[0];  //0 equates to the main menu
    }
    
    public void goToAssignAdvisor() {
        cSelection = CardSelection.ASSIGN_ADVISOR;
        setChanged();
        notifyObservers(cSelection);
    }
 
    public void returnToMainMenu() {
        cSelection = init();
        setChanged();
        notifyObservers(cSelection);
    }
    
    public void goToAddStudent() {
        cSelection = CardSelection.ADD_STUDENT;
        setChanged();
        notifyObservers(cSelection);
    }
    
    public void goToAddDept() {
        cSelection = CardSelection.ADD_DEPT;
        setChanged();
        notifyObservers(cSelection);
    }
    
    public void goToAddCourse() {
        cSelection = CardSelection.ADD_COURSE;
        setChanged();
        notifyObservers(cSelection);
    }
    
    public void goToAddAdvisor() {
        cSelection = CardSelection.ADD_INSTRUCTOR;
        setChanged();
        notifyObservers(cSelection);
    }
    
    public void goToAddAdmin() {
        cSelection = CardSelection.ADD_ADMIN;
        setChanged();
        notifyObservers(cSelection);
    }
    
    public void goToSearchMenu() {
        cSelection = CardSelection.SEARCH_MENU;
        setChanged();
        notifyObservers(cSelection);
    }
    
    public void goToAssignInstructor() {
        cSelection = CardSelection.ASSIGN_INSTRUCTOR;
        setChanged();
        notifyObservers(cSelection);
    }
    
    public void goToQueryResult() {
        cSelection = CardSelection.QUERY_RESULT;
        setChanged();
        notifyObservers(cSelection);
    }

}
/**
 * Enum representing the different card views
 */
public enum CardSelection {
    MAIN_MENU, ADD_STUDENT, ADD_COURSE, ADD_DEPT, ADD_INSTRUCTOR, ADD_ADMIN, SEARCH_MENU, ASSIGN_ADVISOR,
       ASSIGN_INSTRUCTOR, QUERY_RESULT;
    }
}
