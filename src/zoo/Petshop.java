package zoo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Petshop {
    
private static final Logger LOG = LogManager.getLogger(Menu.class);

    public static void main(String[] args) {
        try {
        
        Menu petshopMenu = new Menu();
        
        String userInfoTemplate = "username" + "," + "userpass" + "," + "null" + "&";
        
        Files.write(Paths.get("users.txt"), userInfoTemplate.getBytes(), StandardOpenOption.CREATE);
        
        User.readUserInfo();
        
        petshopMenu.startMenu();
        } catch (IOException main) {
            System.out.println(main);
            LOG.error (main);
        }
    }
    
}
