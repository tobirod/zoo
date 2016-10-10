package zoo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import static zoo.ZooStore.money;
import static zoo.ZooStore.FRESHPRICE;
import static zoo.ZooStore.FROZENPRICE;

public class Accessories {
    static ZooStore zs = new ZooStore();
    static Terrarium tr = new Terrarium();
    static Aquarium aq = new Aquarium();
    static RodentCage rc = new RodentCage();
    static BirdCage bc = new BirdCage();
    static FreshFood freF = new FreshFood();
    static FrozenFood froF = new FrozenFood();
    ClearConsole petshopClearConsole = new ClearConsole();
    
    public Accessories()
    {
    }
    protected void addAcc(ArrayList<FreshFood> freshFoodList, ArrayList<FrozenFood> frozenFoodList, ArrayList<Terrarium> terrariumList, ArrayList<Aquarium> aquariumList, ArrayList<RodentCage> rodentCageList, ArrayList<BirdCage> birdCageList,
            ArrayList<Bird> birdList, ArrayList<Amphibian> amphibianList, ArrayList<Fish> fishList, ArrayList<Rodent> rodentList, ArrayList<Reptile> reptileList, ArrayList<Insect> insectList)
    {
        Scanner input = new Scanner(System.in);
        String type = "";
        int amount = 0;
        
        System.out.println("Which type of item would you like to add?\n1 - Terrarium    2 - Aquarium    3 - Rodent cage    4 - Bird cage    5 - Fresh Food    6 - Frozen Food");
        System.out.println("____________________________________________________________________________________");
        System.out.println("Or press ENTER to go back to main menu.\n");
        
        try
        {
        System.out.print("Enter accessory type: ");
        type = input.nextLine().toLowerCase();
        if (type.equals(""))
        {
            zs.mainMenu(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
        }
        System.out.print("Enter amount of items: ");
        amount = input.nextInt();
        }
        catch (InputMismatchException ex)
        {
            petshopClearConsole.clearConsoleRobot();
            System.err.println("Invalid type of characters, please try again.\n");
            System.exit(0);
        }
        switch (type)
        {
        case "terrarium":
        case "1":
            for (int i = amount; i > 0; i--)
            {
                terrariumList.add(new Terrarium(tr.getAccType(), 0));
            }
        break;
        case "aquarium":
        case "2":
            for (int i = amount; i > 0; i--)
            {
                aquariumList.add(new Aquarium(aq.getAccType(), 0));
            }
        break;
        case "rodent cage":
        case "3":
            for (int i = amount; i > 0; i--)
            {
                rodentCageList.add(new RodentCage(rc.getAccType(), 0));
            }
        break;
        case "bird cage":
        case "4":
            for (int i = amount; i > 0; i--)
            {
                birdCageList.add(new BirdCage(bc.getAccType(), 0));
            }
        case "fresh food":
        case "5":
            for (int i = amount; i > 0; i--)
            {
                freshFoodList.add(new FreshFood(freF.getFoodType()));
            }
            break;
        case "frozen food":
        case "6":
            for (int i = amount; i > 0; i--)
            {
                frozenFoodList.add(new FrozenFood(froF.getFoodType()));
            }
            break;
        case "":
            petshopClearConsole.clearConsoleRobot();
            zs.mainMenu(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
        break;
        default:
            petshopClearConsole.clearConsoleRobot();
            System.out.println("\nYou must type in a valid type of item!");
            System.out.println("1 - Terrarium    2 - Aquarium    3 - Rodent cage    4 - Bird cage    5 - Fresh Food    6 - Frozen Food");
            addAcc(freshFoodList, frozenFoodList, terrariumList, aquariumList, rodentCageList, birdCageList, birdList, amphibianList, fishList, rodentList, reptileList, insectList);
        }
        petshopClearConsole.clearConsoleRobot();
        zs.writeFile(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
        zs.mainMenu(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
    }
    protected void removeAcc(ArrayList<FreshFood> freshFoodList, ArrayList<FrozenFood> frozenFoodList, ArrayList<Terrarium> terrariumList, ArrayList<Aquarium> aquariumList, ArrayList<RodentCage> rodentCageList, ArrayList<BirdCage> birdCageList,
            ArrayList<Bird> birdList, ArrayList<Amphibian> amphibianList, ArrayList<Fish> fishList, ArrayList<Rodent> rodentList, ArrayList<Reptile> reptileList, ArrayList<Insect> insectList)
    {
        int c;
        
        System.out.println("\nItem            Price              Amount");
        System.out.println("=========================================");
        System.out.printf("%-2s%-15s%-20d%-25d\n", "1", "Terrarium", tr.getTerrPrice(), terrariumList.size());
        System.out.printf("%-2s%-15s%-20d%-25d\n", "2", "Aquarium", aq.getAqPrice(), aquariumList.size());
        System.out.printf("%-2s%-15s%-20d%-25d\n", "3", "Rodent Cage", rc.getRcPrice(), rodentCageList.size());
        System.out.printf("%-2s%-15s%-20d%-25d\n", "4", "Bird Cage", bc.getBcPrice(), birdCageList.size());
        System.out.printf("%-2s%-15s%-20d%-25d\n", "5", "Fresh Food", FRESHPRICE, freshFoodList.size());
        System.out.printf("%-2s%-15s%-20d%-25d\n", "6", "Frozen Food", FROZENPRICE, frozenFoodList.size());
        System.out.println("=========================================");
        
        Scanner choice = new Scanner(System.in);
        System.out.println("Which type of item would you like to remove?\n1 - Terrarium    2 - Aquarium    3 - Rodent cage    4 - Bird cage    5 - Fresh Food    6 - Frozen Food");
        System.out.println("____________________________________________________________________________________");
        System.out.println("Or press ENTER to go back to main menu.\n");
        System.out.print("Please enter your choice: ");
        String accChoice = choice.nextLine().toLowerCase();
        
        try {
        switch (accChoice)
        {
            case "terrarium":
            case "1":
                System.out.print("How many terrariums would you like to remove?\nChoose a number: ");
                c = choice.nextInt();
                for (int i = c; i > 0; i--)
                {
                terrariumList.remove(terrariumList.size() - 1);
                }
                break;
            case "aquarium":
            case "2":
                System.out.print("How many aquariums would you like to remove?\nChoose a number: ");
                c = choice.nextInt();
                for (int i = c; i > 0; i--)
                {
                aquariumList.remove(aquariumList.size() - 1);
                }
                break;
            case "rodent cage":
            case "3":
                System.out.print("How many rodent cages would you like to remove?\nChoose a number: ");
                c = choice.nextInt();
                for (int i = c; i > 0; i--)
                {
                rodentCageList.remove(rodentCageList.size() - 1);
                }
                break;
            case "bird cage":
            case "4":
                System.out.print("How many bird cages would you like to remove?\nChoose a number: ");
                c = choice.nextInt();
                for (int i = c; i > 0; i--)
                {
                birdCageList.remove(birdCageList.size() - 1);
                }
                break;
            case "fresh food":
            case "5":
                System.out.print("How many fresh food would you like to remove?\nChoose a number: ");
                c = choice.nextInt();
                for (int i = c; i > 0; i--)
                {
                    freshFoodList.remove(freshFoodList.size() - 1);
                }
                break;
            case "frozen food":
            case "6":
                System.out.print("How many frozen food would you like to remove?\nChoose a number: ");
                c = choice.nextInt();
                for (int i = c; i > 0; i--)
                {
                    frozenFoodList.remove(frozenFoodList.size() - 1);
                }
                break;
            case "":
                zs.mainMenu(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
            default:
                System.out.println("\nYou must type in a valid type of accessory!\n");
                removeAcc(freshFoodList, frozenFoodList, terrariumList, aquariumList, rodentCageList, birdCageList, birdList, amphibianList, fishList, rodentList, reptileList, insectList);
        }
        }
        catch(IndexOutOfBoundsException ex)
        {
            petshopClearConsole.clearConsoleRobot();
            System.err.println("You must choose a valid number.\n");
            removeAcc(freshFoodList, frozenFoodList, terrariumList, aquariumList, rodentCageList, birdCageList, birdList, amphibianList, fishList, rodentList, reptileList, insectList);
        }
        petshopClearConsole.clearConsoleRobot();
        System.out.println("Item(s) removed!");
        zs.writeFile(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
        zs.mainMenu(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
    }
    protected void sellAcc(ArrayList<FreshFood> freshFoodList, ArrayList<FrozenFood> frozenFoodList, ArrayList<Terrarium> terrariumList, ArrayList<Aquarium> aquariumList, ArrayList<RodentCage> rodentCageList, ArrayList<BirdCage> birdCageList,
            ArrayList<Bird> birdList, ArrayList<Amphibian> amphibianList, ArrayList<Fish> fishList, ArrayList<Rodent> rodentList, ArrayList<Reptile> reptileList, ArrayList<Insect> insectList)
    {
        int c;
        
        System.out.println("\nItem            Price              Amount");
        System.out.println("=========================================");
        System.out.printf("%-2s%-15s%-20d%-25d\n", "1", "Terrarium", tr.getTerrPrice(), terrariumList.size());
        System.out.printf("%-2s%-15s%-20d%-25d\n", "2", "Aquarium", aq.getAqPrice(), aquariumList.size());
        System.out.printf("%-2s%-15s%-20d%-25d\n", "3", "Rodent Cage", rc.getRcPrice(), rodentCageList.size());
        System.out.printf("%-2s%-15s%-20d%-25d\n", "4", "Bird Cage", bc.getBcPrice(), birdCageList.size());
        System.out.printf("%-2s%-15s%-20d%-25d\n", "5", "Fresh Food", FRESHPRICE, freshFoodList.size());
        System.out.printf("%-2s%-15s%-20d%-25d\n", "6", "Frozen Food", FROZENPRICE, frozenFoodList.size());
        System.out.println("=========================================");
        
        Scanner choice = new Scanner(System.in);
        System.out.println("Which type of item would you like to sell?\n1 - Terrarium    2 - Aquarium    3 - Rodent cage    4 - Bird cage    5 - Fresh Food    6 - Frozen Food");
        System.out.println("____________________________________________________________________________________");
        System.out.println("Or press ENTER to go back to main menu.\n");
        System.out.print("Please enter your choice: ");
        String accChoice = choice.nextLine().toLowerCase();
        
        try {
        switch (accChoice)
        {
            case "terrarium":
            case "1":
                System.out.print("How many terrariums would you like to sell?\nChoose a number: ");
                c = choice.nextInt();
                for (int i = c; i > 0; i--)
                {
                    money += tr.getTerrPrice();
                    terrariumList.remove(terrariumList.size() - 1);
                }
                break;
            case "aquarium":
            case "2":
                System.out.print("How many aquariums would you like to sell?\nChoose a number: ");
                c = choice.nextInt();
                for (int i = c; i > 0; i--)
                {
                    money += aq.getAqPrice();
                    aquariumList.remove(aquariumList.size() - 1);
                }
                break;
            case "rodent cage":
            case "3":
                System.out.print("How many rodent cages would you like to sell?\nChoose a number: ");
                c = choice.nextInt();
                for (int i = c; i > 0; i--)
                {
                    money += rc.getRcPrice();
                    rodentCageList.remove(rodentCageList.size() - 1);
                }
                break;
            case "bird cage":
            case "4":
                System.out.print("How many bird cages would you like to sell?\nChoose a number: ");
                c = choice.nextInt();
                for (int i = c; i > 0; i--)
                {
                    money += bc.getBcPrice();
                    birdCageList.remove(birdCageList.size() - 1);
                }
                break;
            case "fresh food":
            case "5":
                System.out.print("How many fresh food would you like to sell?\nChoose a number: ");
                c = choice.nextInt();
                for (int i = c; i > 0; i--)
                {
                    money += FRESHPRICE;
                    freshFoodList.remove(freshFoodList.size() - 1);
                }
                break;
            case "frozen food":
            case "6":
                System.out.print("How many frozen food would you like to sell?\nChoose a number: ");
                c = choice.nextInt();
                for (int i = c; i > 0; i--)
                {
                    money += FROZENPRICE;
                    frozenFoodList.remove(frozenFoodList.size() - 1);
                }
                break;
            case "":
                petshopClearConsole.clearConsoleRobot();
                zs.mainMenu(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
            default:
                petshopClearConsole.clearConsoleRobot();
                System.out.println("\nYou must type in a valid type of accessory!\n");
                sellAcc(freshFoodList, frozenFoodList, terrariumList, aquariumList, rodentCageList, birdCageList, birdList, amphibianList, fishList, rodentList, reptileList, insectList);
        }
        }
        catch(IndexOutOfBoundsException ex)
        {
            petshopClearConsole.clearConsoleRobot();
            System.err.println("You must choose a valid number.\n");
            sellAcc(freshFoodList, frozenFoodList, terrariumList, aquariumList, rodentCageList, birdCageList, birdList, amphibianList, fishList, rodentList, reptileList, insectList);
        }
        System.out.println("Item(s) sold!");
        petshopClearConsole.clearConsoleRobot();
        zs.writeFile(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
        zs.mainMenu(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
    }
    protected void updateAcc(ArrayList<FreshFood> freshFoodList, ArrayList<FrozenFood> frozenFoodList, ArrayList<Terrarium> terrariumList, ArrayList<Aquarium> aquariumList, ArrayList<RodentCage> rodentCageList, ArrayList<BirdCage> birdCageList,
            ArrayList<Bird> birdList, ArrayList<Amphibian> amphibianList, ArrayList<Fish> fishList, ArrayList<Rodent> rodentList, ArrayList<Reptile> reptileList, ArrayList<Insect> insectList)
    {
        int c;
        
        System.out.println("\nItem            Price              Amount");
        System.out.println("=========================================");
        System.out.printf("%-2s%-15s%-20d%-25d\n", "1", "Terrarium", tr.getTerrPrice(), terrariumList.size());
        System.out.printf("%-2s%-15s%-20d%-25d\n", "2", "Aquarium", aq.getAqPrice(), aquariumList.size());
        System.out.printf("%-2s%-15s%-20d%-25d\n", "3", "Rodent Cage", rc.getRcPrice(), rodentCageList.size());
        System.out.printf("%-2s%-15s%-20d%-25d\n", "4", "Bird Cage", bc.getBcPrice(), birdCageList.size());
        System.out.println("=========================================");
        
        Scanner choice = new Scanner(System.in);
        System.out.println("Which type of item would you like to set the price for?\n");
        System.out.println("Or press ENTER to go back to main menu.\n");
        System.out.print("Please enter your choice: ");
        String accChoice = choice.nextLine().toLowerCase();
        
        switch(accChoice)
        {
            case "terrarium":
            case "1":
                System.out.print("Set new price for Terrarium: ");
                c = choice.nextInt();
                tr.setTerrPrice(c);
                break;
            case "aquarium":
            case "2":
                System.out.print("Set new price for Aquarium: ");
                c = choice.nextInt();
                aq.setAqPrice(c);
                break;
            case "rodent cage":
            case "3":
                System.out.print("Set new price for Rodent Cage: ");
                c = choice.nextInt();
                rc.setRcPrice(c);
                break;
            case "bird cage":
            case "4":
                System.out.print("Set new price for Bird Cage: ");
                c = choice.nextInt();
                bc.setBcPrice(c);
                break;
            case "":
                petshopClearConsole.clearConsoleRobot();
                zs.mainMenu(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
            default:
                petshopClearConsole.clearConsoleRobot();
                System.out.println("\nYou must type in a valid type of accessory!\n");
                updateAcc(freshFoodList, frozenFoodList, terrariumList, aquariumList, rodentCageList, birdCageList, birdList, amphibianList, fishList, rodentList, reptileList, insectList);
        }
        petshopClearConsole.clearConsoleRobot();
        System.out.println("\nPrice updated!");
        zs.writeFile(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
        zs.mainMenu(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
    }
}
