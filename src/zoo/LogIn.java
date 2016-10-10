package zoo;

import java.util.Scanner;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class LogIn {

ClearConsole petshopClearConsole = new ClearConsole();

private Scanner menuInput = new Scanner(System.in);
private static final Logger LOG = LogManager.getLogger(LogIn.class);

String logInName;
String logInPass;
String logInBuffer;

Boolean userExists = false;
Boolean passMatch = false;
Boolean checkAdmin = false;

int userCount = 0;
int passCount = 0;
    
    public void logIn() {
        
        while (userCount < User.readUserInfo().size()) {
            
            if (logInBuffer.equalsIgnoreCase(User.readUserInfo().get(userCount).userName)) {
                userExists = true;
                passCount = userCount;
            }
            userCount++;
        }
        
        if (!userExists) {
            noUserFound();
        }
    }
    
    public void checkLogInPass() {
                
        if (logInBuffer.equals(User.readUserInfo().get(passCount).userPass)) {
            passMatch = true;
        } else if (!passMatch) {
            noPassMatch();
        }
    }
    
    public void checkIfAdmin() {
        
        if (User.readUserInfo().get(passCount).isAdmin.equalsIgnoreCase("true")) {
            checkAdmin = true;
        } else if (User.readUserInfo().get(passCount).isAdmin.equalsIgnoreCase("false")) {
            checkAdmin = false;
        }
    }
    
    public void noUserFound() {
        
        petshopClearConsole.clearConsoleRobot();

        System.out.println("\nFound no existing user by the name of " + logInBuffer + ". Try again.");
        System.out.println("\nPlease state your username");
        System.out.println("___________________________________________________________________________________________________\n");

        logInBuffer = menuInput.nextLine();
        
        userCount = 0;

        logIn();
    }
    
    public void noPassMatch() {
        
        petshopClearConsole.clearConsoleRobot();

        System.out.println("\nIncorrect password for user " + User.readUserInfo().get(passCount).userName + ". Try again.");
        System.out.println("\nPlease state your password:");
        System.out.println("___________________________________________________________________________________________________\n");

        logInBuffer = menuInput.nextLine();

        checkLogInPass();
    }
}