package zoo;

import java.util.Scanner;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Menu {
    
User petshopUser = new User();
LogIn petshopLogIn = new LogIn();
ClearConsole petshopClearConsole = new ClearConsole();
static ZooStore zs = new ZooStore();

private Scanner menuInput = new Scanner(System.in);
private static final Logger LOG = LogManager.getLogger(Menu.class);

    public void startMenu() {
        
        System.out.println("Hello and welcome to Zoo Store!");
        System.out.println("To navigate in the menues, type in the number that corresponds to your choice och finish by hitting the ENTER key.\n");
        
        System.out.println("1 - Create a new account.");
        System.out.println("2 - Log in with an existing account.");
        System.out.println("3 - Exit.");
        
        System.out.println("___________________________________________________________________________________________________\n");
        
        String navigateMenu = menuInput.nextLine();
        
        switch (navigateMenu) {
            
            case "1":
                petshopClearConsole.clearConsoleRobot();
                createNewAccountMenu();
                break;
            case "2":
                petshopClearConsole.clearConsoleRobot();
                logInMenu();
                break;
            case "3":
                petshopClearConsole.clearConsoleRobot();
                System.out.println("Thank you for using Zoo Store!");
                break;
            default:
                petshopClearConsole.clearConsoleRobot();
                System.out.println("The number does not correspond to a choice in the list, please try again.");
                startMenu();
                break;
        }
    }
    
    public void createNewAccountMenu() {

        System.out.println("\n1 - Create a new customer account.");
        System.out.println("2 - Create a new admin account.");
        System.out.println("3 - Go back to previous menu.");

        System.out.println("___________________________________________________________________________________________________\n");

        String navigateMenu = menuInput.nextLine();

        switch (navigateMenu) {

            case "1":
                petshopClearConsole.clearConsoleRobot();
                setUserInfoMenu();
                break;
            case "2":
                petshopClearConsole.clearConsoleRobot();
                setAdminInfoMenu();
                break;
            case "3":
                petshopClearConsole.clearConsoleRobot();
                startMenu();
                break;
            default:
                petshopClearConsole.clearConsoleRobot();
                System.out.println("The number does not correspond to a choice in the list, please try again.");
                createNewAccountMenu();
                break;
        }
    }

    public void setUserInfoMenu() {
        
        System.out.println("\nPlease state your desired username:");
        System.out.println("___________________________________________________________________________________________________\n");
        
        petshopUser.userNameBuffer = menuInput.nextLine();
            
        petshopUser.checkIfUserNameTaken();
        petshopClearConsole.clearConsoleRobot();
        
        System.out.println("\nYour username is " + petshopUser.userName + ".\n");
        System.out.println("Please state your desired password:");
        System.out.println("___________________________________________________________________________________________________\n");
        
        petshopUser.userPass = menuInput.nextLine();
        
        petshopUser.createNewAccount();
        petshopClearConsole.clearConsoleRobot();
        startMenu();
    }
    
    public void setAdminInfoMenu() {

        System.out.println("\nPlease state your desired password for administrative rights:");
        System.out.println("___________________________________________________________________________________________________\n");

        petshopUser.adminPassBufferInput = menuInput.nextLine();

        petshopUser.adminPassAuth();
        petshopClearConsole.clearConsoleRobot();

        System.out.println("\nPlease state your desired username:");
        System.out.println("___________________________________________________________________________________________________\n");

        petshopUser.userNameBuffer = menuInput.nextLine();
        
        petshopUser.checkIfUserNameTaken();

        petshopClearConsole.clearConsoleRobot();

        System.out.println("\nYour username is " + petshopUser.userName + ".\n");
        System.out.println("Please state your desired password:");
        System.out.println("___________________________________________________________________________________________________\n");

        petshopUser.userPass = menuInput.nextLine();

        petshopUser.createNewAccount();
        petshopClearConsole.clearConsoleRobot();
        
        startMenu();
    }
    
    public void logInMenu() {
        
        System.out.println("\nPlease state your username:");
        System.out.println("___________________________________________________________________________________________________\n");
        
        petshopLogIn.logInBuffer = menuInput.nextLine();
        
        petshopLogIn.logIn();
        petshopClearConsole.clearConsoleRobot();
        
        System.out.println("\nTrying to log in user " + petshopLogIn.logInBuffer + ".\n");
        System.out.println("Please state your password:");
        System.out.println("___________________________________________________________________________________________________\n");
        
        petshopLogIn.logInBuffer = menuInput.nextLine();
        
        petshopLogIn.checkLogInPass();
        
        petshopLogIn.checkIfAdmin();
        
        if (petshopLogIn.checkAdmin == true) {
            zs.storeStart();
            
        } else if (petshopLogIn.checkAdmin == false) {
            zs.storeStart();
        }
    }
}
