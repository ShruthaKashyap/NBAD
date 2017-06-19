/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.HashMap;
import Business.Appointment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
/**
 *
 * @author shrut
 */
public class AppointmentDB {
    
    int count=1;
    static private int codegenerate=1003;
    
    public HashMap<String, Appointment> appointments = new HashMap<String, Appointment>();
    
    public String codeGenerator()
    {
        StringBuilder sb=new StringBuilder();
        String code = "";
        Random randomGenerator = new Random();
        int num = randomGenerator.nextInt(100) + 1;
        sb.append(num);
        sb.append(count);
        code=sb.toString();
        
        count++;
        return code;
    }
    
    public void addAppointment(Appointment app) throws ClassNotFoundException, SQLException
  {         //working
     System.out.println("I am inside put");
     String code1,code2;
     String option1="";
     String option2=""; 
     String option3="";
     String option4="";
     String option5="";
     code1= codeGenerator();
     app.setAppointmentCode(code1);
     code2=codeGenerator();
   
     String patientName=app.getPatientName();
     int age=app.getAge();
     String email=app.getEmail();
     String purpose=app.getPurpose();
     String doctor=app.getDoctor();
     Date date_time=app.getAppointDate();
     String username = app.getUsername();
     Date dateCreated=app.getDateCreated();
     
     String appStatus=app.getStatus();
    // String option4=answers.get(3);
    // String option5=answers.get(4);
      //ConnectionPool pool = ConnectionPool.getInstance();
      //Connection connection = pool.getConnection();
      ConnectionPool pool = new ConnectionPool();
      Connection connection=pool.getConnection();
      PreparedStatement ps1 = null;
      //PreparedStatement ps2 = null;
      ResultSet resultSet = null;
      
      String query1 = "insert into Appointment"
				+ "(AppointmentID, PatientName, Age,Username,DateCreated, AppointmentDate,Purpose,Doctor,Status) VALUES"
				+ "(?,?,?,?,?,?,?,?,?)";
      
//      String query2 = "insert into Question"
//				+ "(QuestionID, StudyID, Question, AnswerType,Option1,Option2,Option3,Option4,Option5) VALUES"
//				+ "(?,?,?,?,?,?,?,?,?)";
 
      try {
            System.out.println("I am inside try block in put");
            ps1 = connection.prepareStatement(query1);
            ps1.setString(1,code1);
            ps1.setString(2, patientName);
            ps1.setInt(3, age);
            ps1.setString(4,email);
            //ps1.setString(5,email);
            java.util.Date date = new Date();
            ps1.setTimestamp(5, new java.sql.Timestamp(date.getTime()));
            //ps.setDate(5, dateCreated);
            
            ps1.setTimestamp(6,new java.sql.Timestamp(date_time.getTime()));
           
            ps1.setString(7,purpose);
            ps1.setString(8, doctor);
            ps1.setString(9,appStatus);
            ps1.executeUpdate();
            
//            ps2 = connection.prepareStatement(query2);
//            ps2.setString(1,code2);
//            ps2.setString(2, code1);
//            ps2.setString(3, question);
//            ps2.setString(4, answerType);
//            ps2.setString(5, option1);
//            ps2.setString(6, option2);
//            ps2.setString(7, option3);
//            ps2.setString(8, option4);
//            ps2.setString(9, option5);
//              
//             ps2.executeUpdate();
          
            System.out.println("Insertion done");
                
        } catch (SQLException e) {
            System.out.println(e);
             
    }
  }
    
    public List<Appointment> getAppointmentsFor(String username) throws ClassNotFoundException, SQLException                
    {            
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Appointment> newAppointments = new ArrayList<Appointment>();
         
        //ConnectionPool pool = ConnectionPool.getInstance();
        //Connection connection = pool.getConnection();
        ConnectionPool pool = new ConnectionPool();
        Connection connection=pool.getConnection();
        String query = "select * from Appointment where Username = '" + username + "'";
        
        try {
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            while(resultSet.next()) {
                    Appointment appt = new Appointment();
                    System.out.println("I am inside foooorrr");
                    String pName =  resultSet.getString("PatientName");
                    System.out.println(pName);
                    String aCode =  resultSet.getString("AppointmentID");
                    String purpose =  resultSet.getString("Purpose");
                    String email =  resultSet.getString("Username");
                   Date dateCreated =  resultSet.getDate("DateCreated");
                   Date aptDate= resultSet.getDate("AppointmentDate");
                   // String question =  resultSet.getString("Question");
                    int age =  resultSet.getInt("Age");
                    String doctor= resultSet.getString("Doctor");
                    String aStatus =  resultSet.getString("Status");
                    //System.out.println("Study details is " + sName);
                    appt.setPatientName(pName);
                    appt.setAppointmentCode(aCode);
                    appt.setDoctor(doctor);
                    appt.setAge(age);
                    appt.setAppointDate(aptDate);
                    appt.setPurpose(purpose);
                    appt.setStatus(aStatus);      
                  
                    newAppointments.add(appt);
                 
            }
                  return newAppointments;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closePreparedStatement(ps);
            //pool.freeConnection(connection);
            connection.close();
        }

    }
    
    public List<Appointment> getAppointmentsForStatus(String status) throws ClassNotFoundException, SQLException                
    {            
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Appointment> newAppointments = new ArrayList<Appointment>();
         
        //ConnectionPool pool = ConnectionPool.getInstance();
        //Connection connection = pool.getConnection();
        ConnectionPool pool = new ConnectionPool();
        Connection connection=pool.getConnection();
        String query = "select * from Appointment where Status = '" + status + "'";
        
        try {
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            while(resultSet.next()) {
                    Appointment appt = new Appointment();
                    System.out.println("I am inside foooorrr");
                    String pName =  resultSet.getString("PatientName");
                    System.out.println(pName);
                    String aCode =  resultSet.getString("AppointmentID");
                    String purpose =  resultSet.getString("Purpose");
                    String email =  resultSet.getString("Username");
                   Date dateCreated =  resultSet.getDate("DateCreated");
                   Date aptDate= resultSet.getDate("AppointmentDate");
                   // String question =  resultSet.getString("Question");
                    int age =  resultSet.getInt("Age");
                    String doctor= resultSet.getString("Doctor");
                    String aStatus =  resultSet.getString("Status");
                    //System.out.println("Study details is " + sName);
                    appt.setPatientName(pName);
                    appt.setAppointmentCode(aCode);
                    appt.setDoctor(doctor);
                    appt.setAge(age);
                    appt.setAppointDate(aptDate);
                    appt.setPurpose(purpose);
                    appt.setStatus(aStatus);  
                    appt.setUsername(email);
                  
                    newAppointments.add(appt);
                 
            }
                  return newAppointments;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closePreparedStatement(ps);
            //pool.freeConnection(connection);
            connection.close();
        }

    }
    
    public Appointment getAppointment(String aptcode) throws ClassNotFoundException, SQLException                
    {            
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        //List<Appointment> newAppointments = new ArrayList<Appointment>();
         
        //ConnectionPool pool = ConnectionPool.getInstance();
        //Connection connection = pool.getConnection();
        ConnectionPool pool = new ConnectionPool();
        Connection connection=pool.getConnection();
        String query = "select * from Appointment where AppointmentID = '" + aptcode + "'";
        
        try {
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            Appointment appt = new Appointment();
            while(resultSet.next()) {
                    //Appointment appt = new Appointment();
                    System.out.println("I am inside foooorrr");
                    String pName =  resultSet.getString("PatientName");
                    System.out.println(pName);
                    String aCode =  resultSet.getString("AppointmentID");
                    String purpose =  resultSet.getString("Purpose");
                    String email =  resultSet.getString("Username");
                   Date dateCreated =  resultSet.getDate("DateCreated");
                   Date aptDate= resultSet.getDate("AppointmentDate");
                   // String question =  resultSet.getString("Question");
                    int age =  resultSet.getInt("Age");
                    String doctor= resultSet.getString("Doctor");
                    String aStatus =  resultSet.getString("Status");
                    //System.out.println("Study details is " + sName);
                    appt.setPatientName(pName);
                    appt.setAppointmentCode(aCode);
                    appt.setDoctor(doctor);
                    appt.setAge(age);
                    appt.setAppointDate(aptDate);
                    appt.setPurpose(purpose);
                    appt.setStatus(aStatus);  
                    appt.setUsername(email);
                  
                    //newAppointments.add(appt);
                 
            }
                  return appt;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closePreparedStatement(ps);
            //pool.freeConnection(connection);
            connection.close();
        }

    }
    
    public void updateAppointmentStatus(Appointment apt,String status) throws ClassNotFoundException, SQLException
    {
        
        PreparedStatement ps = null;
        //PreparedStatement ps1 = null;
       
        //String questionCode ="";
        ResultSet resultSet = null;
       
        //ConnectionPool pool = ConnectionPool.getInstance();
        //Connection connection = pool.getConnection();
        ConnectionPool pool = new ConnectionPool();
        Connection connection=pool.getConnection();
       
       String query = "update Appointment SET Status = ?"
				                  + " WHERE AppointmentID = ?";
       
        try {
//            ps1 = connection.prepareStatement(query1);
//            resultSet = ps1.executeQuery();
//            if(resultSet.next()) {
//            questionCode = resultSet.getString("QuestionID");
//      }
//            System.out.println("I am inside try block in put");
            ps = connection.prepareStatement(query);
            ps.setString(1, status);
           
           // ps.setString(2, study.getQuestion());
            ps.setString(2, apt.getAppointmentCode());
           
            ps.executeUpdate();
            
            System.out.println("Updation done");
                
        } catch (SQLException e) {
            System.out.println(e);
         
        } finally {
            DBUtil.closePreparedStatement(ps);
            
            //pool.freeConnection(connection);
            connection.close();
        }
        
        
        
    }
}
