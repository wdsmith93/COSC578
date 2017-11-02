import java.sql.*;

public class TableCreation {
	private static String jdbcDriver = "com.mysql.jdbc.Driver";
	private static String dbAddress = "jdbc:mysql://localhost:3306/";
	private static String dbName = "DBMS";
	private static String userName = "root";
	private static String password = "root";

	public static void main(String args[]) {

		Connection con; // represents connection to specific database
		Statement stmt=null; // execute the SQL statement
		// Load the JdbcOdbc Driver
		// try {
		try {
			Class.forName(jdbcDriver);
			// Register JDBC driver
			System.out.println("Connecting to database");
			con = DriverManager.getConnection(dbAddress + dbName, userName, password);
			System.out.println("Connecting to database successful");
			stmt = con.createStatement();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String Student = "CREATE TABLE STUDENT " + "(FName VARCHAR(15)," + " Middle VARCHAR(15),"
				+ " LName VARCHAR(15)," + " SSN CHAR(9) NOT NULL," + "Sid VARCHAR(15)," + "Perm_address VARCHAR(30),"
				+ "Current_adress VARCHAR(30)," + "Grant_Auth VARCHAR(10)," + "Email_id VARCHAR(20),"
				+ "Sex VARCHAR(2), " + "DOB DATE," + "Advisor_Id INT," + "PRIMARY KEY(SSN),"
				+ "FOREIGN KEY (Advisor_Id) REFERENCES INSTRUCTOR(Instructor_Id),"
				+ "FOREIGN KEY (Sid) REFERENCES IDCARD(Id_No))";

		String Enrolls = "CREATE TABLE ENROLLS " + "(SSN CHAR(9) NOT NULL," + " Course_Id VARCHAR(15) NOT NULL,"
				+ " Grade VARCHAR(5)," + "PRIMARY KEY(SSN,Course_Id))";

		String StdPhone = "CREATE TABLE STUDENT_PHONE " + "(Phone VARCHAR(10) ," + " SSN CHAR(9) NOT NULL,"
				+ "PRIMARY KEY(Phone,SSN)," + "FOREIGN KEY(SSN) REFERENCES STUDENT(SSN))";

		String Course = "CREATE TABLE COURSE " + "(Course_Id VARCHAR(15) NOT NULL," + " Course_Title VARCHAR(20),"
				+ " Course_Desc VARCHAR(30)," + " Begin_date DATE," + "End_date DATE," + "Instructor_Id INT,"
				+ "PRIMARY KEY(Course_Id)," + "FOREIGN KEY (Instructor_Id) REFERENCES INSTRUCTOR(Instructor_Id))";

		String Instructor = "CREATE TABLE INSTRUCTOR " + "(Instructor_Id INT NOT NULL ," + " First VARCHAR(15),"
				+ " Middle VARCHAR(15)," + " Last VARCHAR(15)," + "Dept_Num INT NOT NULL,"
				+ "PRIMARY KEY(Instructor_Id)," + "FOREIGN KEY (Dept_Num) REFERENCES DEPARTMENT(Dept_Num))";

		String Department = "CREATE TABLE DEPARTMENT " + "(Dept_Name VARCHAR(15)," + " Dept_Num INT NOT NULL,"
				+ " Office_No INT ," + " Office_Ph_No VARCHAR(10)," + "PRIMARY KEY(Dept_Num))";

		String Prereq = "CREATE TABLE PREREQUISITE " + "(Course_Id VARCHAR(15) NOT NULL," + " PreReqId VARCHAR(15),"
				+ "PRIMARY KEY(Course_Id,PreReqId)," + "FOREIGN KEY (Course_Id) REFERENCES COURSE(Course_Id))";

		String IdCard = "CREATE TABLE IDCARD " + "(Id_No VARCHAR(15) NOT NULL," + " Name VARCHAR(15),"
				+ "Sex VARCHAR(2), " + "DOB DATE," + "Date_Issued DATE," + "Expire_Date DATE," + "Admin_id VARCHAR(15),"
				+ "PRIMARY KEY(Id_No)," + "FOREIGN KEY (Admin_Id) REFERENCES ADMIN(Admin_Id))";

		String Admin = "CREATE TABLE ADMIN " + "(Admin_Id VARCHAR(15) NOT NULL," + " FName VARCHAR(15),"
				+ " Middle VARCHAR(15)," + " LName VARCHAR(15)," + " Username VARCHAR(30)," + "Password VARCHAR(30),"
				+ "PRIMARY KEY(Admin_Id))";

		String Classroom = "CREATE TABLE CLASSROOM " + "(Class_Id INT NOT NULL," + " Location VARCHAR(20),"
				+ " Capacity INT," + "PRIMARY KEY(Class_Id))";

		String ClassCourse = "CREATE TABLE CLASSCOURSE " + "(Class_Id INT NOT NULL,"
				+ " Course_Id VARCHAR(15) NOT NULL," + " Day VARCHAR(15)," + "PRIMARY KEY(Class_Id,Course_Id),"
				+ "FOREIGN KEY (Class_Id) REFERENCES CLASSROOM(Class_Id),"
				+ "FOREIGN KEY (Course_Id) REFERENCES COURSE(Course_Id))";

		try {
			stmt.executeUpdate(Department);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		}
		try {
			stmt.executeUpdate(Admin);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		}
		try {
			stmt.executeUpdate(Instructor);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		}
		try {
			stmt.executeUpdate(IdCard);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		}
		try {
			stmt.executeUpdate(Classroom);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		}
		try {
			stmt.executeUpdate(Course);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		}
		try {
			stmt.executeUpdate(Prereq);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		}
		try {
			stmt.executeUpdate(ClassCourse);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		}
		try {
			stmt.executeUpdate(Student);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		}
		try {
			stmt.executeUpdate(StdPhone);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		}
		try {
			stmt.executeUpdate(Enrolls);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		}
		System.out.println("Table created");

	}

}
