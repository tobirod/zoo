package zoo;

import java.awt.Robot;
import java.awt.AWTException;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class ClearConsole {
    
private static final Logger LOG = LogManager.getLogger(LogIn.class);
    
    public void clearConsoleRobot() {
        
        try {

        Robot pressButtonBot = new Robot();

        pressButtonBot.keyPress(17);
        pressButtonBot.keyPress(76);
        pressButtonBot.keyRelease(17);
        pressButtonBot.keyRelease(76);

        } catch (AWTException awtEx1) {
        System.out.println(awtEx1);
        LOG.error(awtEx1);
        }

        try {

        TimeUnit.MILLISECONDS.sleep(200);

        } catch (InterruptedException clearConsoleRobotEx) {
        System.out.println(clearConsoleRobotEx);
        LOG.error (clearConsoleRobotEx);
        }
    }
    
}
