/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author shrut
 */
public class Appointment implements Serializable
{
    private String appointmentCode;
    private String patientName;
    private int age;
    private String purpose;
    private Date date_time;
    private String aptDateString;
    private String doctor;
    private String username;
    private String email;
    private Date dateCreated;
    private String status;
    
    public Date getAppointDate() {
        return date_time;
    }

    public void setAppointDate(Date date_time) {
        this.date_time = date_time;
    }
    
    public String getDateString() {
         return date_time.toString();
    }

//    public void setDateString(String aptDateString) {
//        this.aptDateString = aptDateString;
//    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getAppointmentCode() {
        return appointmentCode;
    }

    public void setAppointmentCode(String appointmentCode) {
        this.appointmentCode = appointmentCode;
    }
    
    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
    
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
    
    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
    
    public void Appointment(String patientName, int age, String purpose, Date date_time, String doctor, String username, String email)
    {
        this.patientName=patientName;
        this.age=age;
        this.purpose=purpose;
        this.date_time=date_time;
        this.doctor=doctor;
        this.username=username;
        this.email=email;
    }
    
    public void Appointment()
    {
        this.patientName="";
        this.age=0;
        this.purpose="";
        this.date_time=null;
        this.doctor="";
        this.username="";
        this.email="";
    }
}
