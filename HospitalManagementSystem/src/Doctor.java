import java.sql.*;
import java.util.*;
public class Doctor {
    Scanner sc = new Scanner(System.in);
    public void doctorRegister(){
        MainPage m1 = new MainPage();
        try {
            System.out.println("Enter Doctor details:");
           // System.out.print("ID: ");
            //int id = sc.nextInt();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Address: ");
            String address = sc.nextLine();
            System.out.print("Contact no.: ");
            String contact = sc.next();
            System.out.print("Gender: ");
            String gender = sc.next();
            System.out.print("Blood Group: ");
            String bg = sc.next();
            System.out.print("Qualification: ");
            String qualification = sc.next();
            System.out.print("Speciality: ");
            String speciality = sc.next();
            Connection con = Connect.ConnectDB();
            String sql= "insert into doctorregistration(name,address,contact,gender,bg,qualification,speciality)values('" + name + "','" + address + "','" + contact + "','" + gender + "','" + bg + "','" + qualification + "','" + speciality + "')";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();
            System.out.println("Doctor successfully added.");
            System.out.println("---------------------------------------------------------------------------------------");
        } catch (SQLException ex) {
            System.out.println("Cannot access database"+ex);
            //Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
//        System.out.print("Do you want to go Dashbord?(y/n): ");
//        String s = sc.next();
//        if(s.equals("yes")||s.equals("y")){
//            m1.mainPage();
//        }
m1.case2();
    }
    public void displayDoctor(){
        MainPage m1 = new MainPage();
        System.out.println("Here are the doctor details:");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.println("ID\t NAME\t\t\t ADDRESS\t CONTACT \t GENDER\t BG\t QUALIFICATION\t SPECIALITY");
        try {
            Connection con=Connect.ConnectDB();
            String sql= "select id,name,address,contact,gender,bg,qualification,speciality from doctorregistration";
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
    public void updateDoctor(){ 
        Scanner sc1 = new Scanner(System.in);
        MainPage m1 = new MainPage();
        //displayDoctor();
        try {
            System.out.print("Enter ID of Doctor you want to update: ");
            int id = sc.nextInt();
            Connection con=Connect.ConnectDB();
            String sql= "select id from doctorregistration";
            PreparedStatement pst=con.prepareStatement(sql);
            ResultSet rs= pst.executeQuery(sql);
            while (rs.next()){
                int did = rs.getInt("id");
                if(did==id){
                    System.out.println("Id found Successfully!!");
                    System.out.println("-----------------------------------------------------");
                    break;
                }
            }
            if(rs.isAfterLast()){
                System.out.println("Id doesnot found");
                System.out.println("-------------------------------------------------");
                System.out.println("Please Enter correct ID...");
                updateDoctor();
            }
            System.out.println("Enter updated detail:");
            System.out.print("Name: ");
            String name = sc1.nextLine();
            System.out.print("Address: ");
            String address = sc.next();
            System.out.print("Contact no.: ");
            String contact = sc.next();
            System.out.print("Gender: ");
            String gender = sc.next();
            System.out.print("Blood Group: ");
            String bg = sc.next();
            System.out.print("Qualification: ");
            String qualification = sc.next();
            System.out.print("Speciality: ");
            String speciality = sc.next();
            String sql1 = "update doctorregistration set name = '" + name + "',address = '" + address + "',contact = '" + contact + "',gender = '" + gender + "',bg = '" + bg +"',qualification = '" + qualification+"',speciality = '" + speciality + "'where id = '"+id+"'";
            PreparedStatement pst1 = con.prepareStatement(sql1);
            pst1.execute();
            System.out.println("Doctor detail successfully updated.");
            displayDoctor();
        } catch (SQLException ex) {
            System.out.println("Cannot access database"+ex);
            //Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);(
            m1.mainPage();
        }
//        System.out.print("Do you want to go Dashbord?(y/n): ");
//        String s = sc.next();
//        if(s.equals("yes")||s.equals("y")){
//            m1.mainPage();
//        }
m1.case2();
    }  
    public void deleteDoctor(){
         MainPage m1 = new MainPage();
        try {
            System.out.print("Enter doctor ID to delete: ");
            int id = sc.nextInt();
            Connection con = Connect.ConnectDB();
            String sql= "select id from doctorregistration";
            PreparedStatement pst=con.prepareStatement(sql);
            ResultSet rs= pst.executeQuery(sql);
            while (rs.next()){
                int pid = rs.getInt("id");
                if(pid==id){
                    System.out.println("Id found Successfully!!");
                    System.out.println("-----------------------------------------------------");
                    break;
                }
            }
            if(rs.isAfterLast()){
                System.out.println("Id doesnot found");
                System.out.println("-------------------------------------------------");
                System.out.println("Please Enter correct ID...");
                deleteDoctor();
            }
            String sql1= "delete from doctorregistration where id = '"+id+"'";
            PreparedStatement pst1=con.prepareStatement(sql1);
            pst1.execute();
            System.out.println("Doctor's data successfully deleted.");
            displayDoctor();
        } catch (SQLException ex) {
            System.out.println("Cannot access to database"+ex);
        }
        m1.case2();
    }
    public void searchDoctor(){
        Scanner sc1 = new Scanner(System.in);
        Search s1 = new Search();
        System.out.println("1. Search by ID ");
        System.out.println("2. Search by Name");
        System.out.println("3. Search by Contact");
        System.out.print("Enter your choice:");
        int ch = sc.nextInt();
        switch (ch){
            case 1:
                System.out.print("Enter Doctor ID: ");
                int id = sc.nextInt();
                s1.searchDoctorId(id);
                break;
            case 2:
                System.out.print("Enter Doctor Name: ");
                String name = sc1.nextLine();
                s1.searchDoctorName(name);
                break;
            case 3:
                System.out.print("Enter Doctor Contact: ");
                String no = sc1.next();
                s1.searchDoctorNo(no);
                break;     
        }
    }
}
