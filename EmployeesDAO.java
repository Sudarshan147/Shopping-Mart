/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Emart.Dao;

import Emart.dbutil.DBConnection;
import Emart.pojo.EmployeesPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class EmployeesDAO {
  public static String getNextEmpId()throws SQLException
  {
      Connection conn = DBConnection.getConnection();
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery("Select max(empid) from employees");
      rs.next();
      String empid = rs.getString(1);
      int empno = Integer.parseInt(empid.substring(1));
      empno= empno+1;
      return "E"+empno;
  } 
  public static boolean addEmployees(EmployeesPojo e)throws SQLException
    {
        Connection conn= DBConnection.getConnection();
        PreparedStatement ps= conn.prepareStatement("Insert into employees values(?,?,?,?)");
        ps.setString(1, e.getEmpId());
        ps.setString(2, e.getEmpName());
        ps.setString(3, e.getJob());
        ps.setDouble(4, e.getSalary());
        
        
        int result= ps.executeUpdate();
        return result==1;//this is the condition shortcut which cheque if result ==1 reuturn true else false
    }
  public static List<EmployeesPojo> getAllEmployees() throws SQLException
  {
      Connection conn= DBConnection.getConnection();
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery("Select * from employees order by empid");
      ArrayList <EmployeesPojo> empList= new ArrayList<>();
      while(rs.next())
      {
          EmployeesPojo emp = new EmployeesPojo();
          emp.setEmpId(rs.getString(1));
          emp.setEmpName(rs.getString(2));
          emp.setJob(rs.getString(3));
          emp.setSalary(rs.getDouble(4));
          empList.add(emp);
      }
      return empList;
  }
  public static List<String> getAllEmpId() throws SQLException
  {
      Connection conn= DBConnection.getConnection();
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery("Select * from employees order by empid");
      ArrayList <String> allId = new ArrayList<>();
      while(rs.next())
      {
          allId.add(rs.getString(1));
          
      }
      return allId;
  }
  public static EmployeesPojo FindEmpById(String empid)throws SQLException
  {
     Connection conn = DBConnection.getConnection();
     PreparedStatement ps = conn.prepareStatement("Select * from employees where empid=?");
     ps.setString(1, empid);
     ResultSet rs = ps.executeQuery();
     rs.next();
     EmployeesPojo e = new EmployeesPojo();
     e.setEmpId(rs.getString(1));
     e.setEmpName(rs.getString(2));
     e.setJob(rs.getString(3));
     e.setSalary(rs.getDouble(4));
     return e;
  }
  public static boolean updateEmployee(EmployeesPojo e) throws SQLException
  {
     Connection conn = DBConnection.getConnection();
     PreparedStatement ps = conn.prepareStatement("Update employees set empName=?,job=?,Salary=? where empid=?");
     ps.setString(1, e.getEmpName());
     ps.setString(2, e.getJob());
     ps.setDouble(3, e.getSalary());
     ps.setString(4, e.getEmpId());
     int x = ps.executeUpdate();
    if(x==0)
        return false;
    else 
    {
        boolean result = UserDAO.isUserPresent(e.getEmpId());
        if(result==false)
            return true;
     ps = conn.prepareStatement("Update users set username=?,usertype=? where empid=?");
     ps.setString(1, e.getEmpName());
     ps.setString(2, e.getJob());
     ps.setString(3, e.getEmpId());
     int y = ps.executeUpdate();
     return y==1;
    }
   
  }
   public static boolean deleteEmployee(EmployeesPojo e) throws SQLException
   {
       Connection conn = DBConnection.getConnection();
     PreparedStatement ps = conn.prepareStatement("delete employees where empid=?");
     ps.setString(1,e.getEmpId()); 
     int x = ps.executeUpdate();
     return x==1;
   }
}
