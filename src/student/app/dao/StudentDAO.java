/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.app.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import student.app.database.Database;
import student.app.model.Student;

/**
 *
 * @author Sithu
 */
public class StudentDAO {
     
    public void save(Student student)throws  SQLException{
        String name=student.getName();
	String email=student.getEmail();
        String gender=student.getGender();
        Date dob=student.getDob();
        Connection conn = Database.getInstance().getConnection();
        String sql="insert into students(name,email,gender,dob) value (?,?,?,?)";
       PreparedStatement stmt=conn.prepareStatement(sql);
        stmt.setString(1, name);
		stmt.setString(2, email);
                stmt.setString (3,gender);
                stmt.setDate(4,dob);
		boolean check=stmt.execute();//Resultset
		System.out.println(check);
        
    }
    public List<Student> getStudents() throws SQLException{
            Connection conn = Database.getInstance().getConnection();
			String sql="select * from students";
			Statement stmt=conn.createStatement();
			
			ResultSet result=stmt.executeQuery(sql);
			
					
				List<Student> students=new ArrayList<>();
			
			while(result.next()){
				int id=result.getInt("Id");
				String name=result.getString("Name");
				String email=result.getString("Email");
                                String gender=result.getString("Gender");
                               Date dob=result.getDate("dob");
				students.add(new Student(id,name,email,gender,dob));
			}
			return students;
		
		}
    
    public int deleteStudent(int id) throws SQLException{
        Connection conn = Database.getInstance().getConnection();
        String sql=("delete from students where id=?");
          PreparedStatement stmt=conn.prepareStatement(sql);
          stmt.setInt(1, id);
      
        return stmt.executeUpdate();
       
    }

    public void updateStudent(Student sd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
			
}
