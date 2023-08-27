import java.util.*;
public class MainPage {
    Doctor d1 = new Doctor();
    Patient p1 = new Patient();
    Scanner sc = new Scanner(System.in);
    public void mainPage(){
        boolean flag = true;
        if(flag){
            System.out.println("----------------DASHBOARD--------------");
            System.out.println("1. Patient");
            System.out.println("2. Doctor");
            System.out.println("3. Login Page");
            System.out.print("Enter your choice : ");
            int ch = sc.nextInt();
            switch(ch){
                case 1 : 
                    case1();
                    break;
                case 2 : 
                    case2();
                    break;
                case 3:{
                    flag=false;
                   // mainPage();
                    break;
                }
                default: {
                    System.out.println("!!!Please select AVAILABLE option!!!");
                    mainPage();
                }
            }
        }
    }
public void case1(){
    System.out.println("1. Patient Registration");
    System.out.println("2. Search Patient");
    System.out.println("3. Display all Patient in Sorted order");
    System.out.println("4. Update Patient");
    System.out.println("5. Delete Patient");
    System.out.println("6. Go Back");
    System.out.print("Enter your choice: ");
    int ch1 = sc.nextInt();
    switch(ch1){
        case 1:
            p1.patientRegister();
            break;
        case 2:
            p1.searchPatient();
            break;
        case 3:
            p1.displayPatients();
            break;
        case 4:
            p1.updatePatients();
            break;
        case 5:
            p1.deletePatient();
            break;
        case 6:
            mainPage();
            break;
        default:
            System.out.println("invalid Choice");
            mainPage();
    }
}
public void case2(){
    System.out.println("1. Doctor Registration");
    System.out.println("2. Search Doctor");
    System.out.println("3. Display Doctor");
    System.out.println("4. Update Doctor");
    System.out.println("5. Delete Doctor");
    System.out.println("6. Go Back");
    System.out.print("Enter your choice: ");
    int ch2 = sc.nextInt();
    switch(ch2){
        case 1:
            d1.doctorRegister();
            break;
        case 2:
            d1.searchDoctor();
            break;
        case 3:
            d1.displayDoctor();
            break;
        case 4:
            d1.updateDoctor();
            break;
        case 5:
            d1.deleteDoctor();
            break;
        case 6:
            mainPage();
            break;
        default:
            System.out.println("invalid Choice");
            mainPage();
    }
}
public static void main(String[] args) {
        UserLogin u1 = new UserLogin();
//        MainPage m1 = new MainPage();
//        m1.mainPage();
    boolean flag=true;
    while(flag){
    System.out.println("-----------Welcome to Hospital Management System----------");
        System.out.println("1. Register User \n2. Login \n3. Exit ");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        int ch = sc.nextInt();
        switch(ch){
            case 1:
                u1.case1();
                break;
            case 2:
                u1.case2();
                break;
            case 3:
                flag=false;
                break;
            default:
                System.out.println("---------------------------------------------------------");
                System.out.println("please choose available option!!");              
//                m1.mainPage();
        }
    }
    }
}
