package StudentCRUD.StudentCRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
	private static StudentDAO instance;
	Connection con;
	private static List<StudentModel> data = new ArrayList<>();
	private Connection GetConn() {
		Connection con1=null ;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_project", "root",""); 		
		} catch (Exception e) {
			System.out.println("Error In Connection OF My Sql"+e.getMessage());
			System.out.println(e);			
		}
		return con1;
	}

	public List<StudentModel> listAll() {
		con=GetConn();
		Statement stmt;
		try {
			stmt = con.createStatement();
			System.out.println(stmt);
			ResultSet rs = stmt.executeQuery("select student_no,student_name,student_dob,student_doj from Student");
			while (rs.next()) {			
				StudentModel stdata=new StudentModel();
				stdata.setStudent_no(rs.getInt("student_no"));
				stdata.setStudent_name(rs.getString("student_name"));
				stdata.setStudent_dob(rs.getString("student_dob"));
				stdata.setStudent_doj(rs.getString("student_doj"));
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
				data.add(stdata);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return new ArrayList<StudentModel>(data);
	}
//Insert new student Details.
	public boolean add(StudentModel student) {
		Statement stmt;
		con=GetConn();
		try {
			stmt = con.createStatement();	
		    stmt.executeUpdate("insert into Student (student_no,student_name,student_dob,student_doj) Values("+student.getStudent_no()+" ,'"+student.getStudent_name()+"','"+student.getStudent_dob()+"','"+student.getStudent_doj()+"') ");
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
			return true;
	}
//get Single student Details using stud id
	public StudentModel getSingleStudDtls(int student_no) {
		StudentModel stdata=new StudentModel();
		con=GetConn();
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select student_no,student_name,student_dob,student_doj from Student where student_no="+student_no+"");
			while (rs.next()) {			
				stdata.setStudent_no(rs.getInt("student_no"));
				stdata.setStudent_name(rs.getString("student_name"));
				stdata.setStudent_dob(rs.getString("student_dob"));
				stdata.setStudent_doj(rs.getString("student_doj"));
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
				}
			rs.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stdata;
	}

	//update student details using student_no
	public boolean update(StudentModel student) {
		Statement stmt;		
		con=GetConn();
		try {
			stmt = con.createStatement();	
			stmt.executeUpdate("Update Student set student_name='"+student.getStudent_name()+"',student_dob='"+student.getStudent_dob()+"',student_doj='"+student.getStudent_doj()+"' where student_no="+student.getStudent_no()+" ");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;	
		}
	}
///Write Delete query where studet_no
	public boolean delete(int student_no) {
		Statement stmt;		
		con=GetConn();
		try {
			stmt = con.createStatement();	
			stmt.executeUpdate("Delete from Student where student_no='"+student_no+"' ");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;	
		}		
	}
}
