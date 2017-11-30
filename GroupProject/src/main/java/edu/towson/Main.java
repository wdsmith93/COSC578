package edu.towson;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;
import java.sql.*;
import java.util.Random;
import javax.swing.JFrame;

public class Main implements Runnable {

    private static final String FIRST_NAME_INPUT = "firstnames.txt";
    private static final String LAST_NAME_INPUT = "lastnames.txt";
    private static final String CITY_NAME_INPUT = "cities.txt";
    private static final String STREET_NAME_INPUT = "streets.txt";
    private static final String ZIP_CODE_INPUT = "zipcodes.txt";
    private static final String STATES_INPUT = "states.txt";
    private static String[] firstNameArray = new String[100];
    private static String[] lastNameArray = new String[100];
    private static String[] streetNameArray = new String[100];
    private static String[] cityNameArray = new String[432];
    private static String[] zipCodeArray = new String[432];
    private static String[] statesArray = new String[10];
    private static Random rand = new Random(System.currentTimeMillis());

    
   
    
    
    public static void main(String[] args) {
        //Generated random data lists via this website: https://www.randomlists.com/random-names
        readFromFile(FIRST_NAME_INPUT, firstNameArray);
        readFromFile(LAST_NAME_INPUT, lastNameArray);
        readFromFile(CITY_NAME_INPUT, cityNameArray);
        readFromFile(STREET_NAME_INPUT, streetNameArray);
        readFromFile(ZIP_CODE_INPUT, zipCodeArray);
        readFromFile(STATES_INPUT, statesArray);

        //TODO: Uncomment the following lines!!
        createTables();
        //After creating the tables, the following methods will generate fake data for the individual tables
        initDepartment();
        initInstructor();
        initClassroom();
        initCourse();
        
        EventQueue.invokeLater(new Main());
        
    }
        
        @Override
        public void run() {
        JFrame frame = new JFrame("BCCC Database");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new DatabaseView());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    


    }
    
      
    /**
     * Allows single records to be inserted into the COURSE table
     * @param id  course id
     * @param title course title
     * @param description  course description
     * @param bDate  course begin date
     * @param eDate  course end date
     * @param iId  instructor id
     */
    private static void insertIntoCourse(String id, String title, String description, String bDate, String eDate, int iId){
        String sql = "INSERT INTO Course(Course_Id, Course_Title, Course_Desc, Begin_date, End_date, Instructor_Id) VALUES(?,?,?,?,?,?)";
        
        try (Connection conn = Main.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, id);
            pstmt.setString(2, title);
            pstmt.setString(3, description);
            pstmt.setString(4, bDate);
            pstmt.setString(5, eDate);
            pstmt.setInt(6, iId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Internal method to populate the Course table with random data
     */
    private static void initCourse(){
        String[] courseId = new String[20];  
        int id = 11000;
        String[] courseTitle = new String[20];
        String[] courseDesc = new String[20];
        String[] begin = new String[20];
        String[] end = new String[20];
        String[] beginDateArray = new String[]{"2017-08-28", "2017-08-28", "2017-09-25", "2017-10-23", "2018-01/02"};
        String[] endDateArray = new String[]{"2017-12-15", "2017-10-21", "2017-12-15", "2017-12-15", "2018-01-21"};
        String[] titleArray = new String[]{"BIO 212", "ENG 101", "BIO 102", "CHE 101", "MAT 128", "CHE 213", "BIO 207", "MAT 125", "ACCT 235",
            "ACCT 241", "BUAD 207", "MKTG 223", "HLF", "CLT 100", "CSC 108", "BCWB 252", "ITDB 241", "ITSA 233", "CISS 116", "MAT 125"}; 
        String[] descArray = new String[]{"Microbiology", "English Writing", "General Biology", "General Chemistry I", "College Algebra",
            "Organic Chemistry", "Genetics", "Finite Math", "Cost Accounting", "Auditing Concepts", "Business Law I", "Marketing",
            "Health and Life Fitness", "Computer Literacy", "Programming in C", "Introduction to JavaScript", "Database Programming",
            "Ethical Hacking", "Structured Design", "Finite Mathematics"};
        int[] iId = new int[50];
        
        for (int i = 0; i < courseId.length; i++){
            id = id + 1;
            courseId[i] = String.valueOf(id);
            int selection = Integer.valueOf(genRandomNumber(0,titleArray.length - 1));
            courseTitle[i] = titleArray[selection];
            courseDesc[i] = descArray[selection];
            selection = Integer.valueOf(genRandomNumber(0,beginDateArray.length - 1));
            begin[i] = beginDateArray[selection];
            end[i] = endDateArray[selection];
            iId[i] = Integer.valueOf(genRandomNumber(10000000, 10000100));
            
        }
        for (int j = 0; j < courseId.length; j++){
            insertIntoCourse(courseId[j], courseTitle[j], courseDesc[j], begin[j], end[j], iId[j]);
        }
    }
    
    /**
     * Allows single records to be inserted into the CLASSROOM table
     * @param id  classroom id
     * @param location classroom location
     * @param capacity  classroom capacity
     */
    private static void insertIntoClassroom(int id, String location, int capacity){
        String sql = "INSERT INTO CLASSROOM(Class_Id, Location, Capacity) VALUES(?,?,?)";
        
        try (Connection conn = Main.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, id);
            pstmt.setString(2, location);
            pstmt.setInt(3, capacity);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Internal method to populate the Classroom table with random data
     */
    private static void initClassroom(){
        int[] cId = new int[100];  //int max 11, increment unique
        int id = 1000;
        String[] locationArray = new String[] {"Liberty Heights", "Downtown Harbor", "Reisterstown Plaza", "Life Sciences", "NWTC"};
        String[] cLocation = new String[100];
        int[] cCapacity = new int[100];
        
        for (int i = 0; i < cId.length; i++){
            id = id + 1;
            cId[i] = id;
            cLocation[i] = pickFromArray(locationArray);
            cCapacity[i] = Integer.valueOf(genRandomNumber(15, 50));
            
        }
        for (int j = 0; j < cId.length; j++){
            insertIntoClassroom(cId[j], cLocation[j], cCapacity[j]);
        }
    }
    
    /**
     * Allows single records to be inserted into the INSTRUCTOR table
     * @param id instructor id
     * @param fName  first name
     * @param mName  middle name
     * @param lName  last name
     * @param dNum   department number
     */
    private static void insertIntoInstructor(int id, String fName, String mName, String lName, int dNum){
        String sql = "INSERT INTO INSTRUCTOR(Instructor_Id, First, Middle, Last, Dept_Num) VALUES(?,?,?,?,?)";
        
        try (Connection conn = Main.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, id);
            pstmt.setString(2, fName);
            pstmt.setString(3, mName);
            pstmt.setString(4, lName);
            pstmt.setInt(5, dNum);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Internal method to populate the Instructor table with random data
     */
    private static void initInstructor(){
        int[] iId = new int[100];  //int max 11, increment unique
        int id = 10000000;
        String[] iFName = new String[100];
        String[] iMName = new String[100];
        String[] iLName = new String[100];
        String[] iDNumArray = new String[]{"1", "2", "3", "4", "5", "6", "7"}; //limited to choices between 1 and 7
        int[] iDNum = new int[100];
        
        for (int i = 0; i < iId.length; i++){
            id = id + 1;
            iId[i] = id;
            iFName[i] = pickFromArray(firstNameArray);
            iMName[i] = pickFromArray(firstNameArray);
            iLName[i] = pickFromArray(lastNameArray);
            iDNum[i] = Integer.valueOf(pickFromArray(iDNumArray));
            
        }
        for (int j = 0; j < iId.length; j++){
            insertIntoInstructor(iId[j], iFName[j], iMName[j], iLName[j], iDNum[j]);
        }
    }
    
    
    /**
     * Allows single records to be inserted into the DEPARTMENT table
     * @param deptName name of dept
     * @param deptNum dept number
     * @param oNum office number
     * @param phNum  office phone number
     */
    private static void insertIntoDepartment(String deptName, int deptNum, int oNum, String phNum){
        String sql = "INSERT INTO DEPARTMENT(Dept_Name, Dept_Num, Office_No, Office_Ph_No) VALUES(?,?,?,?)";
        
        try (Connection conn = Main.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, deptName);
            pstmt.setInt(2, deptNum);
            pstmt.setInt(3, oNum);
            pstmt.setString(4, phNum);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Internal method to populate the Department table with random data
     */
    private static void initDepartment(){
        String[] dName = new String[] {"Computer Science", "Mathematics", "English Composition", "Biological and Physical Sciences", 
            "Social and Behavioral Sciences", "Arts and Humanities", "Interdisciplinary and Emerging Issues"};
        int[] dNumber = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] oNumber = new int[7];
        String[] oPhoneNum = new String[7];
        
        for (int i = 0; i < dName.length; i++){
            oPhoneNum[i] = genRandomNumber(10);
            oNumber[i] = Integer.valueOf(genRandomNumber(3));
        }
        for (int j = 0; j < dName.length; j++){
            insertIntoDepartment(dName[j], dNumber[j], oNumber[j], oPhoneNum[j]);
        }
    }
    
    /**
     * Method that returns a database connection
     * @return connection 
     */
    private static Connection connect(){
        String jdbcDriver = "com.mysql.jdbc.Driver";
        String dbAddress = "jdbc:mysql://localhost:3306/";
        String dbName = "DBMS";
        String userName = "root";
        String password = "root";
        Connection con = null; // represents connection to specific database
        // Load the JdbcOdbc Driver
        try {
            Class.forName(jdbcDriver);
            // Register JDBC driver
            System.out.println("Connecting to database");
            con = DriverManager.getConnection(dbAddress + dbName, userName, password);
            System.out.println("Connecting to database successful");
        } catch (ClassNotFoundException | SQLException e1) {
            e1.printStackTrace();
        } 
        return con;
    }
    
    /**
     * Method to create the various database tables for the database
     */
    private static void createTables(){

        String Student = "CREATE TABLE IF NOT EXISTS STUDENT " + "(FName VARCHAR(35)," + " Middle VARCHAR(35),"
                        + " LName VARCHAR(35)," + " SSN CHAR(9) NOT NULL," + "Sid VARCHAR(15)," + "Perm_address VARCHAR(255),"
                        + "Current_adress VARCHAR(255)," + "Grant_Auth VARCHAR(10)," + "Email_id VARCHAR(255),"
                        + "Sex VARCHAR(2), " + "DOB DATE," + "Advisor_Id INT," + "PRIMARY KEY(SSN),"
                        + "FOREIGN KEY (Advisor_Id) REFERENCES INSTRUCTOR(Instructor_Id),"
                        + "FOREIGN KEY (Sid) REFERENCES IDCARD(Id_No))";

        String Enrolls = "CREATE TABLE IF NOT EXISTS ENROLLS " + "(SSN CHAR(9) NOT NULL," + " Course_Id VARCHAR(15) NOT NULL,"
                        + " Grade VARCHAR(5)," + "PRIMARY KEY(SSN,Course_Id))";

        String StdPhone = "CREATE TABLE IF NOT EXISTS STUDENT_PHONE " + "(Phone VARCHAR(10) ," + " SSN CHAR(9) NOT NULL,"
                        + "PRIMARY KEY(Phone,SSN)," + "FOREIGN KEY(SSN) REFERENCES STUDENT(SSN))";

        String Course = "CREATE TABLE IF NOT EXISTS COURSE " + "(Course_Id VARCHAR(15) NOT NULL," + " Course_Title VARCHAR(20),"
                        + " Course_Desc VARCHAR(30)," + " Begin_date DATE," + "End_date DATE," + "Instructor_Id INT,"
                        + "PRIMARY KEY(Course_Id)," + "FOREIGN KEY (Instructor_Id) REFERENCES INSTRUCTOR(Instructor_Id))";

        String Instructor = "CREATE TABLE IF NOT EXISTS INSTRUCTOR " + "(Instructor_Id INT NOT NULL ," + " First VARCHAR(35),"
                        + " Middle VARCHAR(35)," + " Last VARCHAR(35)," + "Dept_Num INT NOT NULL,"
                        + "PRIMARY KEY(Instructor_Id)," + "FOREIGN KEY (Dept_Num) REFERENCES DEPARTMENT(Dept_Num))";

        String Department = "CREATE TABLE IF NOT EXISTS DEPARTMENT " + "(Dept_Name VARCHAR(70)," + " Dept_Num INT NOT NULL,"
                        + " Office_No INT ," + " Office_Ph_No VARCHAR(10)," + "PRIMARY KEY(Dept_Num))";

        String Prereq = "CREATE TABLE IF NOT EXISTS PREREQUISITE " + "(Course_Id VARCHAR(15) NOT NULL," + " PreReqId VARCHAR(15),"
                        + "PRIMARY KEY(Course_Id,PreReqId)," + "FOREIGN KEY (Course_Id) REFERENCES COURSE(Course_Id))";

        String IdCard = "CREATE TABLE IF NOT EXISTS IDCARD " + "(Id_No VARCHAR(15) NOT NULL," + " Name VARCHAR(35),"
                        + "Sex VARCHAR(2), " + "DOB DATE," + "Date_Issued DATE," + "Expire_Date DATE," + "Admin_id VARCHAR(15),"
                        + "PRIMARY KEY(Id_No)," + "FOREIGN KEY (Admin_Id) REFERENCES ADMIN(Admin_Id))";

        String Admin = "CREATE TABLE IF NOT EXISTS ADMIN " + "(Admin_Id VARCHAR(15) NOT NULL," + " FName VARCHAR(35),"
                        + " Middle VARCHAR(35)," + " LName VARCHAR(35)," + " Username VARCHAR(70)," + "Password VARCHAR(30),"
                        + "PRIMARY KEY(Admin_Id))";

        String Classroom = "CREATE TABLE IF NOT EXISTS CLASSROOM " + "(Class_Id INT NOT NULL," + " Location VARCHAR(70),"
                        + " Capacity INT," + "PRIMARY KEY(Class_Id))";

        String ClassCourse = "CREATE TABLE IF NOT EXISTS CLASSCOURSE " + "(Class_Id INT NOT NULL,"
                        + " Course_Id VARCHAR(15) NOT NULL," + " Day VARCHAR(15)," + "PRIMARY KEY(Class_Id,Course_Id),"
                        + "FOREIGN KEY (Class_Id) REFERENCES CLASSROOM(Class_Id),"
                        + "FOREIGN KEY (Course_Id) REFERENCES COURSE(Course_Id))";

        try (Connection conn = Main.connect();
                Statement stmt = conn.createStatement()){
                stmt.executeUpdate(Department);
                stmt.executeUpdate(Admin);
                stmt.executeUpdate(Instructor);
                stmt.executeUpdate(IdCard);
                stmt.executeUpdate(Classroom);
                stmt.executeUpdate(Course);
                stmt.executeUpdate(Prereq);
                stmt.executeUpdate(ClassCourse);
                stmt.executeUpdate(Student);
                stmt.executeUpdate(StdPhone);
                stmt.executeUpdate(Enrolls);
        } catch (SQLException e) {

        }
        System.out.println("Table created");
    }

    /**
     * Function that reads in a file. Files external to project must have an associated path as part of the name
     * @param filename to read
     * @param array to populate
     */
    private static void readFromFile(String filename, String[] array) {
        BufferedReader bufferedReader;
        FileReader fileReader;

        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {

            String currentLine;
            int count = 0;

            while ((currentLine = br.readLine()) != null) {
                //System.out.println(sCurrentLine);
                array[count] = currentLine;
                count++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Method to split a string at a space
     * @param s String to split
     * @return string array with original String split at spaces
     */
    public String[] splitString(String s){
        StringBuffer sb = new StringBuffer();
        s = sb.toString();
        String result[] = s.split(" ");
        return result;
    }
    
    /**
     * Generates a random number 
     * TO USE: Pass in an arg for the length of the number. For example, a phone
     * number would have an arg of 10, or a SSN# would have arg of 9
     * @param length
     * @return generated number
     */
    public static String genRandomNumber(int length){
        String s = "";
        int first;
        for (int i = 0; i < length; i++) {
            first = 0 + rand.nextInt(10);
            String newStr = s + first;
            s = newStr;
        }
        return s;
    }
    
    /**
     * Generates a random number 
     * TO USE: Pass in an arg for the low bound, and an arg for the high bound. For example, if
     * generating a date of birth, you may want to pass in 1960 for the low bound and 2000 for the high bound. 
     * This would return a string with a value corresponding to a year between 1960 and 2000.  
     * @param lowBound
     * @param highBound
     * @return generated number
     */
    public static String genRandomNumber(int lowBound, int highBound){
        String s = "";
        int first = ThreadLocalRandom.current().nextInt(lowBound, highBound + 1);
        return s = "" + first;
    }
    
    /**
     * Method to help choose an item at random from an array
     * TO USE: Pass in an array as an arg. This should return a random selection from 
     * one of the strings in the array for you to use
     * PURPOSE: Used to assemble addresses/names/etc. Would call this once to pick a first
     * name from the firstNameArray and then call this again to get a random last name from
     * the lastNameArray
     * @param array
     * @return random string from the array
     */
    public static String pickFromArray(String[] array){
        int first = 0 + rand.nextInt(array.length);
        return array[first];
    }
    
    public static String generateEmailAddress(String fname, String lname){
        String[] emailProvider = new String[]{"aol", "hotmail", "msn", "yahoo", "gmail", "excite",
            "juno", "netzero", "postmark", "hushmail", "inbox", "mail", "icloud"};
        int random;
        String result = "";
        random = 0 + rand.nextInt(emailProvider.length);
        result = fname + "." + lname + "@" + emailProvider[random] + ".com";
        
        return result;        
    }
    
    /**
     * Returns corresponding gender to match the first name
     * TO USE: Pass in a first name, method will return correct gender
     * @param name first name on which to base gender
     * @return corresponding gender
     */
    public static String getSex(String name){
        String result = "F";
        int position = findMatchFromArray(name, firstNameArray);
        //The first fifty entries in the array are all male names
        if (position < 50){
            result = "M";
        }
        return result;
    }
    /**
     * Internal method to search for position of matching item in an array
     * TO USE: Pass in a string to search for and the containing array 
     * @param s provided string
     * @param arry array to search for matching string
     * @return either position if found or -1 if the item does not exist in the array
     */
    private static int findMatchFromArray(String s, String[] arry){
        int res = -1;
        for(int i = 0; i < arry.length; i++){
            if(s.equals(arry[i])){
                res = i;
                break;
            }
        }
        return res;
    }
    
    /**
     * Generates a random date with given high/low bounds for a range of years
     * NOTE: To make simpler, just cuts days off at a max of 28 to avoid writing logic for
     * Feb, and 30/31 day months. 
     * TO USE: Designate what range of years to generate a date for
     * @param yrLowBound "do not generate an answer with a year earlier than this arg"
     * @param yrHighBound "do not generate an answer with a year later than this arg"
     * @return String in a date format of mm/dd/yyyy
     */
    public static String generateRandomDate(int yrLowBound, int yrHighBound){
        String result = "";
        result = genRandomNumber(1, 12);
        result = result + "/" + genRandomNumber(1,28);
        result = result + "/" + genRandomNumber(yrLowBound, yrHighBound);
        return result;
    }


}



