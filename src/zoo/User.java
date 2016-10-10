package zoo;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class User {

ClearConsole petshopClearConsole = new ClearConsole();

private Scanner menuInput = new Scanner(System.in);
private static final Logger LOG = LogManager.getLogger(User.class);

String userName;
String userNameBuffer;
String userPass;

String isAdmin = "false";

String adminPassInput;
String adminPassBufferInput;
String adminPass = "admin123";

    public void createNewAccount() {
        try {
        
        petshopClearConsole.clearConsoleRobot();
        
        String userInfo = userName.toLowerCase() + "," + userPass + "," + isAdmin + "&";
        
        try (BufferedWriter writeToFile = new BufferedWriter(new FileWriter("users.txt", true))) {
            writeToFile.write(userInfo);
        }
        
        System.out.println("\nYour user information is saved. Returning to start menu...");
        
        try {

        TimeUnit.MILLISECONDS.sleep(1000);

        } catch (InterruptedException interruptEx) {
        System.out.println(interruptEx);
        LOG.error (interruptEx);
        }
        
        isAdmin = "false";
        } catch (IOException createNewAccountEx) {
            System.out.println(createNewAccountEx);
            LOG.error(createNewAccountEx);
        } finally {
            if (isAdmin.equalsIgnoreCase("true")) {
                LOG.info("New admin created: " + userName);
            } else {
            LOG.info ("New user created: " + userName);
            }
        }
    }
    
    public void adminPassAuth() {
        
        if (adminPassBufferInput.equals(adminPass)) {
            isAdmin = "true";
        } else {
            while (!adminPassBufferInput.equals(adminPass)) {
                petshopClearConsole.clearConsoleRobot();
                System.out.println("\nIncorrect password. Try again.");
                
                System.out.println("\nPlease state the password for administrative rights.");
                System.out.println("___________________________________________________________________________________________________\n");
                
                adminPassBufferInput = menuInput.nextLine();
                
            if (adminPassBufferInput.equals(adminPass)) {
                isAdmin = "true";
                break;
            }
            }
        }
    }
    
    public static ArrayList<User> readUserInfo() {
        ArrayList<User> userList = new ArrayList();
        
        try {
        
        BufferedReader readFile = new BufferedReader(new FileReader("users.txt"));
        
        String fileContents = readFile.readLine();
        
        String[] splitUsers = fileContents.split("&");
        
        int count = 0;
        String userInfoSplitter;
        
        while(count < splitUsers.length){
            userInfoSplitter = splitUsers[count];
            String[] userBuffer = userInfoSplitter.split(",");
            
            User readUserIntoUserList = new User();
            
            readUserIntoUserList.userName = userBuffer[0];
            readUserIntoUserList.userPass = userBuffer[1];
            readUserIntoUserList.isAdmin = userBuffer[2];
            
            userList.add(readUserIntoUserList);
            
            count++;
        }
        } catch (IOException readUserInfoEx) {
            System.out.println(readUserInfoEx);
            LOG.error (readUserInfoEx);
        }
        return userList;
    }
    
    public void checkIfUserNameTaken() {
        
        for (int userCount = 0; userCount < User.readUserInfo().size(); userCount++) {
            
            while (User.readUserInfo().get(userCount).userName.equalsIgnoreCase(userNameBuffer)) {

                petshopClearConsole.clearConsoleRobot();
                
                System.out.println("This username is occupied. Try again.");
                System.out.println("\nPlease state your desired username:");
                System.out.println("___________________________________________________________________________________________________\n");

                userNameBuffer = menuInput.nextLine();
            }
        }
        userName = userNameBuffer;
    }
}