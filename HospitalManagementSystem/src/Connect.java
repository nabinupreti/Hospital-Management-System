import java.sql.*;

public class Connect {
    Connection con=null;
   
        public static Connection ConnectDB(){
        try{
           Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");
           return con;
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Couldnot connect tp database."+e);
        }      
        return null;
    }
}
