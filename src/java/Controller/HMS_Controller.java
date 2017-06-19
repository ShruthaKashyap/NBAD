/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Business.Appointment;
import Business.EmailUtility;
import Business.User;
import Data.AppointmentDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Data.UserDB;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author shrut
 */
public class HMS_Controller extends HttpServlet {

    AppointmentDB obj = new AppointmentDB();
    UserDB userObj = new UserDB();
    int count=0;
    
    //email
    private String host;
    private String port;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HMS_Contoller</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HMS_Contoller at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String url ="/";
        response.setContentType("text/html");
        String action = request.getParameter("action");
        PrintWriter out = response.getWriter();   
        HttpSession session = request.getSession();
       
               
        System.out.print(action);
       try{
       if(action == null)
        {
            User UserObj = (User)session.getAttribute("theUser");
             if(UserObj != null)
            {
                out.print("object is not  null");
                url = "/userhome.jsp?user=theUser";
                out.print("url is" + url);
            }
            else
            {
                out.print("object is null");
                url = "/index.jsp";
            }
     
        }
       else if (action.equalsIgnoreCase("add"))
        {  
            Appointment appt = new Appointment();
              System.out.print("Action is" + action); 
             User UserObj_add = (User)session.getAttribute("theUser");
             
             appt.setUsername(UserObj_add.getName());
             String username = UserObj_add.getName();
             System.out.println(username);
             String email = UserObj_add.getEmail();
             appt.setEmail(email);
              System.out.println(email);
             if(UserObj_add != null)
             { 
                 // count=count+1;
                 System.out.print("object not null");
                 String pname = request.getParameter("patient_name");
                 String purpose = request.getParameter("purpose");
                 int age = Integer.parseInt(request.getParameter("age"));
                 String doctor = request.getParameter("doctor");
                 
                 DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
                 
                 String date=request.getParameter("date_time");
                 Date aptdate = (Date)formatter.parse(date);
                 
              //String code = request.getParameter("studyCode");
                 String status = request.getParameter("status");
                 
            
             appt.setPatientName(pname);
             appt.setPurpose(purpose);
             appt.setAppointDate(aptdate);
             appt.setAge(age);
             appt.setStatus(status);
             appt.setDoctor(doctor);
                 
             
            
             
             System.out.print("After creating object");
             //  System.out.print(study.getStudyName() + study.getStudyCode()+ study.getQuestion() + study.getRequestedParticipants() + study.getDescription() +study.getStatus());                  
             obj.addAppointment(appt);
                 
                 appt.setEmail(email);
                 List<Appointment> newAppointments = obj.getAppointmentsFor(email);  
                  UserDB.updateUserAppointments(UserObj_add);
                 System.out.println("hi");
                // newStudies.add(study);
                 System.out.println(appt.getStatus());
                 System.out.println("Hi");
                 request.setAttribute("newAppointment", newAppointments);    
                 System.out.println(newAppointments);
                 url = "/userhome.jsp?user=theUser";
             }
             else
             { 
                 System.out.println("object is null");
                 url = ("/login.jsp");
             }         
        }
       else if(action.equalsIgnoreCase("view"))
        {
            User UserObj = (User)session.getAttribute("theUser");
             if(UserObj != null)
            {
                
                String email = UserObj.getEmail();
                List<Appointment> newAppointments = obj.getAppointmentsFor(email);  
                  UserDB.updateUserAppointments(UserObj);
                 request.setAttribute("newAppointment", newAppointments);    
                 System.out.println(newAppointments);
                 url = "/view_appoint.jsp?user=theUser";
//                out.print("object is not  null");
//                url = "/userhome.jsp?user=theUser";
//                out.print("url is" + url);
            }
            else
            {
                out.print("object is null");
                url = "/index.jsp";
            }
     
        }
       else if (action.equalsIgnoreCase("approve"))
        {   out.print("Action is" + action);
             
             User UserObj_stop = (User)session.getAttribute("theAdmin");
             String email = UserObj_stop.getEmail();
             if(UserObj_stop!= null)
             {   
                 String code = request.getParameter("appointmentCode");
                 out.print("Code in approve is " + code);  
                 Appointment a = obj.getAppointment(code);
                 obj.updateAppointmentStatus(a,"Approved");
                  List<Appointment> adminAppointments=  obj.getAppointmentsForStatus("Pending");
                System.out.println("inside studies in my admin studies"+adminAppointments.size());
               
                
                request.setAttribute("newAppointment", adminAppointments);
                
                //Code to send email
                String resultMessage = "";
                String hostname="smtp.gmail.com";
                String port="587";
                String usrname=email;
                String password="gingerovitis";
                String recipient=a.getUsername();
                String subject="Appointment Confirmation";
                String content="Hi "+a.getPatientName()+",\n"+"Your appointment has been confirmed with "+a.getDoctor()+" on "+a.getAppointDate()+"."+"\n\nThanks,\nAdmin";
                
 
        try {
            EmailUtility.sendEmail(hostname,port , usrname,password, recipient,subject,content);
            resultMessage = "The e-mail was sent successfully";
        } catch (Exception ex) {
            ex.printStackTrace();
            resultMessage = "There were an error: " + ex.getMessage();
        } finally {
            request.setAttribute("Message", resultMessage);
            //getServletContext().getRequestDispatcher("/Result.jsp").forward(
                   // request, response);
                   url = ("/review_appoint.jsp?user=theAdmin");  
        }

                 //url = ("/review_appoint.jsp?user=theAdmin");               
             }
             else
             {
                 url = ("/login.jsp");
             }
             
             }
       
       else if (action.equalsIgnoreCase("decline"))
        {   out.print("Action is" + action);
             
             User UserObj_stop = (User)session.getAttribute("theAdmin");
             String email = UserObj_stop.getEmail();
             if(UserObj_stop!= null)
             {   
                 String code = request.getParameter("appointmentCode");
                 out.print("Code in approve is " + code);  
                 Appointment a = obj.getAppointment(code);
                 obj.updateAppointmentStatus(a,"Decline");
                  List<Appointment> adminAppointments=  obj.getAppointmentsForStatus("Pending");
                System.out.println("inside studies in my admin studies"+adminAppointments.size());
               
                
                request.setAttribute("newAppointment", adminAppointments);
              
                
                //Code to send email
                String resultMessage = "";
                String hostname="smtp.gmail.com";
                String port="587";
                String usrname=email;
                String password="gingerovitis";
                String recipient=a.getUsername();
                String subject="Appointment Declined";
                String content="Hi "+a.getPatientName()+",\n"+"Your appointment has been declined"+"\n\nRegards,\nAdmin";
                
 
        try {
            EmailUtility.sendEmail(hostname,port , usrname,password, recipient,subject,content);
            resultMessage = "The e-mail was sent successfully";
        } catch (Exception ex) {
            ex.printStackTrace();
            resultMessage = "There were an error: " + ex.getMessage();
        } finally {
            request.setAttribute("Message", resultMessage);
            //getServletContext().getRequestDispatcher("/Result.jsp").forward(
                   // request, response);
                   url = ("/review_appoint.jsp?user=theAdmin");  
        }
                
//                 url = ("/review_appoint.jsp?user=theAdmin");               
             }
             else
             {
                 url = ("/login.jsp");
             }
             
             }
       else if (action.equalsIgnoreCase("adminAppointments")){
            if(session.getAttribute("theAdmin") != null){
                List<Appointment> adminAppointments=  obj.getAppointmentsForStatus("Pending");
                System.out.println("inside studies in my admin studies"+adminAppointments.size());
               
                
                request.setAttribute("newAppointment", adminAppointments);
                url = ("/review_appoint.jsp?user=theAdmin");
            }
        }
       
       getServletContext().getRequestDispatcher(url).forward(request, response);
       }catch(Exception e){
           System.out.println(e);
       }
       
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
