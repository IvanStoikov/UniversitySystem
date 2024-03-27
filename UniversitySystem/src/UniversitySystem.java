import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class UniversitySystem {

private ArrayList<User> listUser;
private PrintStream printToClient;
private Scanner inputFromClient;


public UniversitySystem(){
    this.listUser=new ArrayList<>();
}

    public ArrayList<User> getListUser() {
        return listUser;
    }

    public void setListUser(ArrayList<User> listUser) {
        this.listUser = listUser;
    }

    public void logIn(Socket clintSocket) throws IOException {
        printToClient = new PrintStream(clintSocket.getOutputStream());
        inputFromClient = new Scanner(clintSocket.getInputStream());
        //Created test user to test our system works correctly
        Admin admin=new Admin("admin","123456");
        printToClient.println("Enter userName:  ");
        String userName=inputFromClient.next();
        printToClient.println("Enter password: ");
        String password=inputFromClient.next();
        for (User user : listUser) {
            if (userName.equals(user.getUserName()) && password.equals(user.getPassword())) {
                printToClient.println("Log is Successfully");
                switch (user.getUserType()) {
                    case Admin:
                        Admin administrator= (Admin) user;
                        adminMenu(administrator);
                        break;
                    case Teacher:
                        Teacher teacher= (Teacher) user;
                        break;
                    case Student:
                        Student student= (Student) user;
                        break;
                }
            }else{
                printToClient.println("Incorrect Username or Password");
            }
        }
    }


    public boolean createAdmin(){
    printToClient.println("Enter userName: ");
    String username=inputFromClient.next();
    printToClient.println("Enter password: ");
    String password=inputFromClient.next();
    Admin admin=new Admin(username,password);
    listUser.add(admin);
    return true;
}

public boolean createStudent(){
    printToClient.println("Enter userName");
    String username=inputFromClient.next();
    printToClient.println("Enter password: ");
    String password=inputFromClient.next();
    printToClient.println("Enter facultyNumber: ");
    String facultyNumber=inputFromClient.next();
    printToClient.println("Enter egn: ");
    String egn=inputFromClient.next();
    if(validStudent(facultyNumber,egn)) {
        Student student = new Student(username, password, facultyNumber, egn);
        listUser.add(student);
        return true;
    }
    return false;
}

public boolean createTeacher(){
    printToClient.println("Enter username: ");
    String userName=inputFromClient.next();
    printToClient.println("Enter password: ");
    String password=inputFromClient.next();
    printToClient.println("Enter email: ");
    String email=inputFromClient.next();
    if(validTeacher(email,password)) {
        Teacher teacher = new Teacher(userName, password, email);
        listUser.add(teacher);
        return true;
    }
    return false;
}

public void adminMenu(Admin admin){
    printToClient.println("You can create a new user profile");
    printToClient.println("1-Admin\n2-Teacher\n3-Student\n");
    printToClient.println("Enter your choice: ");
    int choiceUser=inputFromClient.nextInt();
    switch (choiceUser){
        case 1:
            if (createAdmin()){
                System.out.println("The user is created successfully");
            }else{
                printToClient.println("The user in not created");
            }
            break;
        case 2:
            if (createTeacher()){
                System.out.println("The user is created successfully");
            }else{
                printToClient.println("The user in not created");
            }
            break;
        case 3:
            if (createStudent()){
                System.out.println("The user is created successfully");
            }else{
                printToClient.println("The user in not created");
            }
            break;
    }
}



public boolean validTeacher(String email,String password){
    String regexEmail="[a-z]+@tu-sofia\\\\.bg";
    String regexPassword="\\\\S{5,}";
    if(!email.matches(regexEmail)){
        printToClient.println("Incorrect email!");
        return  false;
    }
    if (!password.matches(regexPassword)){
        printToClient.println("Incorrect password!");
        return  false;
    }
    return true;
}


public boolean validStudent(String facultyNumber,String egn){
    String regexFacultyNumber="[1-9]{9}";
    String regexEgn="[0-9]{10}";
    if(!facultyNumber.matches(regexFacultyNumber)){
        printToClient.println("Incorrect faculty number");
        return false;
    }
    if(!egn.matches(regexEgn)){
        printToClient.println("Incorrect egn");
        return false;
    }
    return true;
    }












}
