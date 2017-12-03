package edu.towson;

import java.util.Observable;
import java.util.Observer;

/**
 * Model class that is part of the MVC-architecture paradigm used in this program
 * @author williamsmith
 */
public class Model extends Observable {
    
    private final CardSelection[] pages = CardSelection.values();
    private CardSelection cSelection = init();
    private TableList tl = tlInit();
    
    //TODO: This is ugly. Make it better
    private CardSelection init() {
        return pages[0];  //0 equates to the main menu
    }
    
    private TableList tlInit() {
        return TableList.CLASSROOM;
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

    public void goToQueryResult(TableList item) {
        tl = item;
        cSelection = CardSelection.QUERY_RESULT;
        setChanged();
        notifyObservers(tl);
    }

        
    public class ModelObserver implements Observer {
        @Override
        public void update(Observable o, Object arg) {
           if (arg == CardSelection.MAIN_MENU) 
                DatabaseView.setLayout("main_menu");
             
           else if (arg == CardSelection.ADD_STUDENT) 
                DatabaseView.setLayout("add_student");
             
           else  if (arg == CardSelection.ADD_COURSE) 
                DatabaseView.setLayout("add_course");
             
           else  if (arg == CardSelection.ADD_DEPT) 
                DatabaseView.setLayout("add_dept");
             
           else  if (arg == CardSelection.ADD_INSTRUCTOR) 
                DatabaseView.setLayout("add_instructor");
             
           else  if (arg == CardSelection.ADD_ADMIN) 
                DatabaseView.setLayout("add_admin");
             
           else  if (arg == CardSelection.SEARCH_MENU) 
                DatabaseView.setLayout("search_menu");
             
           else  if (arg == CardSelection.ASSIGN_ADVISOR) 
                DatabaseView.setLayout("assign_advisor");
             
           else  if (arg == CardSelection.ASSIGN_INSTRUCTOR) 
                DatabaseView.setLayout("assign_instructor");
            
           else  if (arg == CardSelection.QUERY_RESULT) 
                DatabaseView.setLayout("query_result", tl);
           else {
               DatabaseView.setLayout("query_result", (TableList)arg);
               
           }
        }
    }
}
