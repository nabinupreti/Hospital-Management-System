import java.sql.*;
import java.util.*;
public class Patient {
    Scanner sc = new Scanner(System.in);
    public void patientRegister(){
        MainPage m1 = new MainPage();
        try {
            System.out.println("Enter patient details:");
           // System.out.print("ID: ");
            //int id = sc.nextInt();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Address: ");
            String address = sc.nextLine();
            System.out.print("Contact no.: ");
            String contact = sc.next();
            System.out.print("Age: ");
            int age = sc.nextInt();
            System.out.print("Gender: ");
            String gender = sc.next();
            System.out.print("Blood Group: ");
            String bg = sc.next();
            System.out.print("Enter Doctor ID:");
            int did = sc.nextInt();
            Connection con = Connect.ConnectDB();
            String sql1= "select name from doctorregistration where id = '"+did+"'";
            PreparedStatement pst1=con.prepareStatement(sql1);
            ResultSet rs= pst1.executeQuery(sql1);
            String dname = null;
            while(rs.next()){
                dname = rs.getString("name");
            }
            String sql= "insert into patientregistration(name,address,contact,age,gender,bg,doctor)values('" + name + "','" + address + "','" + contact + "','" + age + "','" + gender + "','" + bg + "','"+dname+"')";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();
            
            System.out.println("Patient successfully added.");
            System.out.println("--------------------------------------------------------------------------");
        } catch (SQLException ex) {
            System.out.println("Cannot access database"+ex);
            m1.mainPage();
        }
//        System.out.print("Do you want to go Dashbord?(y/n): ");
//        String s = sc.next();
//        if(s.equals("yes")||s.equals("y")){
//            m1.mainPage();
//        }
        m1.case1();
    }
    public void displayPatients(){
        MainPage m1 = new MainPage();
        System.out.println("Here are the patient details:");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("ID\t NAME\t\t\t ADDRESS  \t\t CONTACT \t\t AGE\t\t GENDER\t\t BG\t PrescribedBy");
        try {
            Connection con=Connect.ConnectDB();
            String sql= "select id,name,address,contact,age,gender,bg,doctor from patientregistration";
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
    public void updatePatients(){
       // displayPatients();
       Scanner sc1 = new Scanner(System.in);
        MainPage m1 = new MainPage();
        try{
            System.out.print("Enter id of patient you want to update: ");
            int id = sc.nextInt();
            Connection con=Connect.ConnectDB();
            String sql= "select id from patientregistration";
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
                updatePatients();
            }
            System.out.println("Enter updated details:");
            System.out.print("Name: ");
            String name = sc1.nextLine();
            System.out.print("Address: ");
            String address = sc.next();
            System.out.print("Contact no.: ");
            String contact = sc.next();
            System.out.print("Age: ");
            int age = sc.nextInt();
            System.out.print("Gender: ");
            String gender = sc.next();
            System.out.print("Blood Group: ");
            String bg = sc.next();
            String sql1 = "update patientregistration set name = '" + name + "',address = '" + address + "',contact = '" + contact + "',age = '" + age + "',gender = '" + gender + "',bg = '" + bg + "'where id = '"+id+"'";
            PreparedStatement pst1;
            pst1 = con.prepareStatement(sql1);
            pst1.execute();
            System.out.println("Patient's data successfully updated.");
            displayPatients();
        }catch (SQLException ex) {
            System.out.println("Cannot connect to database"+ex);
            m1.mainPage();
        }
//        System.out.print("Do you want to go Dashbord?(y/n): ");
//        String s = sc.next();
//        if(s.equals("yes")||s.equals("y")){
//            m1.mainPage();
//        }
        m1.case1();
    }
    public void deletePatient(){
        MainPage m1 = new MainPage();
        try {
            System.out.print("Enter patient ID to delete: ");
            int id = sc.nextInt();
            Connection con = Connect.ConnectDB();
            String sql= "select id from patientregistration";
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
                deletePatient();
            }
            String sql1= "delete from patientregistration where id = '"+id+"'";
            PreparedStatement pst1=con.prepareStatement(sql1);
            pst1.execute();
            System.out.println("Patient's data successfully deleted.");
            displayPatients();
        } catch (SQLException ex) {
            System.out.println("Cannot access to database"+ex);
        }
        m1.case1();
    }
    public void searchPatient(){
        Scanner sc1 = new Scanner(System.in);
        Search s1 = new Search();
        System.out.println("1. Search by ID ");
        System.out.println("2. Search by Name");
        System.out.println("3. Search by Contact");
        System.out.print("Enter your choice:");
        int ch = sc.nextInt();
        switch (ch){
            case 1:
                System.out.print("Enter Patient ID: ");
                int id = sc.nextInt();
                s1.searchPatientId(id);
                break;
            case 2:
                System.out.print("Enter patient Name: ");
                String name = sc1.nextLine();
                s1.searchPatientName(name);
                break;
            case 3:
                System.out.print("Enter Patient Contact: ");
                String no = sc1.next();
                s1.searchPatientNo(no);
                break;
                
        }
    }
}

