import java.sql.*;
import java.util.*;
public class Search {
    Scanner sc = new Scanner(System.in);
    public void searchPatientId(int sid){
        MainPage m1 = new MainPage();
        System.out.println("Here are the Search Results:");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("ID\t NAME\t\t\t ADDRESS  \t\t CONTACT \t\t AGE\t\t GENDER\t\t BG\t PrescribedBy");
        try {
            Connection con=Connect.ConnectDB();
            String sql= "select id,name,address,contact,age,gender,bg,doctor from patientregistration where id = '"+sid+"'";
            PreparedStatement pst=con.prepareStatement(sql);
            ResultSet rs= pst.executeQuery(sql);
            while (rs.next()){
                String id = rs.getString("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String contact = rs.getString("contact");
                String age = rs.getString("age");
                String gender = rs.getString("gender");
                String bg = rs.getString("bg");
                String dname = rs.getString("doctor");
                System.out.println(id+"\t "+name+"\t\t "+address+"  \t\t "+contact+" \t\t "+age+"\t\t "+gender+"\t\t "+bg+"\t Dr. "+dname);
            }
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        } catch (SQLException ex) {
            System.out.println("Cannot access to database");
            m1.mainPage();
        }
//        System.out.print("Do you want to go Dashbord?(y/n): ");
//        String s = sc.next();
//        if(s.equals("yes")||s.equals("y")){
//            m1.mainPage();
//        }
        m1.case1();
    }
    public void searchPatientName(String sname){
        MainPage m1 = new MainPage();
        System.out.println("Here are the Search Results:");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("ID\t NAME\t\t\t ADDRESS  \t\t CONTACT \t\t AGE\t\t GENDER\t\t BG\t PrescribedBy");
        try {
            Connection con=Connect.ConnectDB();
            String sql= "select id,name,address,contact,age,gender,bg,doctor from patientregistration where name = '"+sname+"'";
            PreparedStatement pst=con.prepareStatement(sql);
            ResultSet rs= pst.executeQuery(sql);
            while (rs.next()){
                String id = rs.getString("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String contact = rs.getString("contact");
                String age = rs.getString("age");
                String gender = rs.getString("gender");
                String bg = rs.getString("bg");
                String dname = rs.getString("doctor");
                System.out.println(id+"\t "+name+"\t\t "+address+"  \t\t "+contact+" \t\t "+age+"\t\t "+gender+"\t\t "+bg+"\t Dr. "+dname);
            }
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        } catch (SQLException ex) {
            System.out.println("Cannot access to database");
            m1.mainPage();
        }
//        System.out.print("Do you want to go Dashbord?(y/n): ");
//        String s = sc.next();
//        if(s.equals("yes")||s.equals("y")){
//            m1.mainPage();
//        }
        m1.case1();
        
    }
    public void searchPatientNo(String sno){
        MainPage m1 = new MainPage();
        System.out.println("Here are the Search Results:");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("ID\t NAME\t\t\t ADDRESS  \t\t CONTACT \t\t AGE\t\t GENDER\t\t BG\t PrescribedBy");
        try {
            Connection con=Connect.ConnectDB();
            String sql= "select id,name,address,contact,age,gender,bg,doctor from patientregistration where contact = '"+sno+"'";
            PreparedStatement pst=con.prepareStatement(sql);
            ResultSet rs= pst.executeQuery(sql);
            while (rs.next()){
                String id = rs.getString("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String contact = rs.getString("contact");
                String age = rs.getString("age");
                String gender = rs.getString("gender");
                String bg = rs.getString("bg");
                String dname = rs.getString("doctor");
                System.out.println(id+"\t "+name+"\t\t "+address+"  \t\t "+contact+" \t\t "+age+"\t\t "+gender+"\t\t "+bg+"\t Dr. "+dname);
            }
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        } catch (SQLException ex) {
            System.out.println("Cannot access to database");
            m1.mainPage();
        }
//        System.out.print("Do you want to go Dashbord?(y/n): ");
//        String s = sc.next();
//        if(s.equals("yes")||s.equals("y")){
//            m1.mainPage();
//        }
        m1.case1();        
   }
    
    public void searchDoctorId(int sid){
        MainPage m1 = new MainPage();
        System.out.println("Here are the Search Results:");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.println("ID\t NAME\t\t\t ADDRESS\t CONTACT \t GENDER\t BG\t QUALIFICATION\t SPECIALITY");
        try {
            Connection con=Connect.ConnectDB();
            String sql= "select id,name,address,contact,gender,bg,qualification,speciality from doctorregistration where id = '"+sid+"'";
            PreparedStatement pst=con.prepareStatement(sql);
            ResultSet rs= pst.executeQuery(sql);
            while (rs.next()){
                String id = rs.getString("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String contact = rs.getString("contact");
                String gender = rs.getString("gender");
                String bg = rs.getString("bg");
                String qualification = rs.getString("qualification");
                String speciality = rs.getString("speciality");
                System.out.println(id+"\t "+name+"\t\t "+address+"\t\t "+contact+"\t "+gender+"\t "+bg+"\t "+qualification+"\t\t "+speciality);
                
            }
            System.out.println("----------------------------------------------------------------------------------------------------------------");
        } catch (SQLException ex) {
            System.out.println("Cannot access to database");
        }
//        System.out.print("Do you want to go Dashbord?(y/n): ");
//        String s = sc.next();
//        if(s.equals("yes")||s.equals("y")){
//            m1.mainPage();
//        }
         m1.case2();
    }
    
    public void searchDoctorName(String sname){
        MainPage m1 = new MainPage();
        System.out.println("Here are the Search Results:");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.println("ID\t NAME\t\t\t ADDRESS\t CONTACT \t GENDER\t BG\t QUALIFICATION\t SPECIALITY");
        try {
            Connection con=Connect.ConnectDB();
            String sql= "select id,name,address,contact,gender,bg,qualification,speciality from doctorregistration where name = '"+sname+"'";
            PreparedStatement pst=con.prepareStatement(sql);
            ResultSet rs= pst.executeQuery(sql);
            while (rs.next()){
                String id = rs.getString("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String contact = rs.getString("contact");
                String gender = rs.getString("gender");
                String bg = rs.getString("bg");
                String qualification = rs.getString("qualification");
                String speciality = rs.getString("speciality");
                System.out.println(id+"\t "+name+"\t\t "+address+"\t\t "+contact+"\t "+gender+"\t "+bg+"\t "+qualification+"\t\t "+speciality);
                
            }
            System.out.println("----------------------------------------------------------------------------------------------------------------");
        } catch (SQLException ex) {
            System.out.println("Cannot access to database");
        }
//        System.out.print("Do you want to go Dashbord?(y/n): ");
//        String s = sc.next();
//        if(s.equals("yes")||s.equals("y")){
//            m1.mainPage();
//        }
        m1.case2();
    }
    
    public void searchDoctorNo(String sno){
        MainPage m1 = new MainPage();
        System.out.println("Here are the Search Restlt:");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.println("ID\t NAME\t\t\t ADDRESS\t CONTACT \t GENDER\t BG\t QUALIFICATION\t SPECIALITY");
        try {
            Connection con=Connect.ConnectDB();
            String sql= "select id,name,address,contact,gender,bg,qualification,speciality from doctorregistration where contact = '"+sno+"'";
            PreparedStatement pst=con.prepareStatement(sql);
            ResultSet rs= pst.executeQuery(sql);
            while (rs.next()){
                String id = rs.getString("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String contact = rs.getString("contact");
                String gender = rs.getString("gender");
                String bg = rs.getString("bg");
                String qualification = rs.getString("qualification");
                String speciality = rs.getString("speciality");
                System.out.println(id+"\t "+name+"\t\t "+address+"\t\t "+contact+"\t "+gender+"\t "+bg+"\t "+qualification+"\t\t "+speciality);
                
            }
            System.out.println("----------------------------------------------------------------------------------------------------------------");
        } catch (SQLException ex) {
            System.out.println("Cannot access to database");
        }
//        System.out.print("Do you want to go Dashbord?(y/n): ");
//        String s = sc.next();
//        if(s.equals("yes")||s.equals("y")){
//            m1.mainPage();
//        }
        m1.case2();
    }
    
}
