package edu.towson;

import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 * Contains the View portion of the MVC model
 * @author williamsmith
 */
public class DatabaseView extends JPanel {
    
        static CardLayout layout = new CardLayout();
        //This is the panel that will hold all the other panels we switch between
        static JPanel panelSet = new JPanel();
        TableList item = TableList.COURSE;
        static QueryResult queryResult;
        static Model model_old;
    
    
    public DatabaseView() {
        
        model_old = new Model();
        MainMenu mainMenu = new MainMenu(model_old);
        AddStudent addStudent = new AddStudent(model_old);
        AddCourse addCourse = new AddCourse(model_old);
        AddDepartment addDepartment = new AddDepartment(model_old);
        AddAdmin addAdmin = new AddAdmin(model_old);
        AddInstructor addInstructor = new AddInstructor(model_old);
        SearchMenu searchMenu = new SearchMenu(model_old);
        AssignAdvisor assignAdvisor = new AssignAdvisor(model_old);
        AssignInstructor assignInstructor = new AssignInstructor(model_old);
        QueryResult queryResult = new QueryResult(model_old, item);
        AddPreferences prefs = new AddPreferences(model_old);
        RegisterForCourse registerForCourse = new RegisterForCourse(model_old);
        DropCourse dropCourse = new DropCourse(model_old);
        item = queryResult.getQueryResultTableListItem();
        Control control2 = new Control(model_old, mainMenu);
        Control control3 = new Control(model_old, addStudent);
        Control control4 = new Control(model_old, addCourse);
        Control control5 = new Control(model_old, addDepartment);
        Control control6 = new Control(model_old, addInstructor);
        Control control7 = new Control(model_old, addAdmin);
        Control control8 = new Control(model_old, searchMenu);
        Control control9 = new Control(model_old, assignAdvisor);
        Control control1 = new Control(model_old, assignInstructor);
        Control control11 = new Control(model_old, queryResult, item);
        Control control12 = new Control(model_old, prefs);
        Control control13 = new Control(model_old, registerForCourse);
        Control control14 = new Control(model_old, dropCourse);
        
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

        //panelSet.add(queryResult, "query_result");
        panelSet.add(prefs, "preferences");
        panelSet.add(registerForCourse, "register_course");
        panelSet.add(dropCourse, "drop_course");

        panelSet.add(control1);
        panelSet.add(control2);
        panelSet.add(control3);
        panelSet.add(control4);
        panelSet.add(control5);
        panelSet.add(control6);
        panelSet.add(control7);
        panelSet.add(control8);
        panelSet.add(control9);
        //panelSet.add(control11);
        panelSet.add(control12);
        panelSet.revalidate();
        setLayout("main_menu");
    }
    
    public static void setLayout(String s){
        layout.show(panelSet, s);
        panelSet.revalidate();
    }
    
    public static void setLayout(String s, TableList tl){
        if(s.equals("query_result"))
            queryResult = new QueryResult(model_old, tl);
        panelSet.remove(queryResult);
        panelSet.add(queryResult, s);
        panelSet.revalidate();
        panelSet.repaint();
        layout.show(panelSet, s);
 
        
    }
}

