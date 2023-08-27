import java.sql.*;
import java.util.*;

public class UserLogin {
    Scanner sc = new Scanner(System.in);
    public void case1(){
        System.out.println("-------------------------------------------------");
        System.out.println("Enter your details to Register:");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Username: ");
        String uname = sc.next();
        System.out.print("Password: ");
        String pwd  = sc.next();
        System.out.print("email: ");
        String mail = sc.next();
        register(name, uname, pwd, mail);
        case2();
}
    public void case2(){
        System.out.println("-------------------------------------------------");
        System.out.println("Enter Your login credentials:");
        System.out.print("Username: ");
        String luname = sc.next();
        System.out.print("Password: ");
        String lpwd = sc.next();
        login(luname, lpwd);       
    }
    public void register(String name,String uname,String pwd,String mail){
       try {
            Connection con = Connect.ConnectDB();
            String sql= "insert into registration(name,username,password,email)values('"+ name + "','" + uname + "','" + pwd + "','" + mail + "')";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();
            System.out.println("Successfully Registered!");
        } catch (SQLException ex) {
            System.out.println("---Sorry!! Username has been already taken---");
            System.out.println("Please reenter details with unique username...");
            case1();
            //Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void login(String luname,String lpwd){
        try {
            Connection con=Connect.ConnectDB();
            String sql= "select username,password from registration";
            PreparedStatement pst=con.prepareStatement(sql);
            ResultSet rs= pst.executeQuery(sql);
            while (rs.next()){
                String uname = rs.getString("username");
                String pwd = rs.getString("password");
               // System.out.println(uname+"\t"+pwd+"\n"+luname+"\t"+lpwd);
                if(luname.equals(uname) && lpwd.equals(pwd)){
                    System.out.println("----------Logged In Successfully!--------------");
                    MainPage m1 = new MainPage();
                    m1.mainPage();
                    break;
                }
            }
            if(rs.isAfterLast()){
                
                System.out.println("Username or password didnot match");
                System.out.println("-------------------------------------------------");
                System.out.println("Please Enter correct Detail...");
                case2();
            }
            
        } catch (SQLException ex) {
            System.out.println("SQL exception"+ex);
        }
    }
}

