package zoo;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class ZooStore {
    static int money;
    static final int FRESHPRICE = 40;
    static final int FROZENPRICE = 30;
    
    static ZooStore zs = new ZooStore();
    static Pet p = new Pet();
    static Accessories acc = new Accessories();
    static Terrarium tr = new Terrarium();
    static Aquarium aq = new Aquarium();
    static RodentCage rc = new RodentCage();
    static BirdCage bc = new BirdCage();
    static FreshFood freF = new FreshFood();
    static FrozenFood froF = new FrozenFood();
    ClearConsole petshopClearConsole = new ClearConsole();
    
    public void storeStart() {
        ArrayList<Terrarium> terrariumList = new ArrayList();
        ArrayList<Aquarium> aquariumList = new ArrayList();
        ArrayList<RodentCage> rodentCageList = new ArrayList();
        ArrayList<BirdCage> birdCageList = new ArrayList();
        
        ArrayList<Bird> birdList = new ArrayList();
        ArrayList<Amphibian> amphibianList = new ArrayList();
        ArrayList<Fish> fishList = new ArrayList();
        ArrayList<Rodent> rodentList = new ArrayList();
        ArrayList<Reptile> reptileList = new ArrayList();
        ArrayList<Insect> insectList = new ArrayList();
        
        ArrayList<FreshFood> freshFoodList = new ArrayList();
        ArrayList<FrozenFood> frozenFoodList = new ArrayList();
        
        readFile(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
        
        petshopClearConsole.clearConsoleRobot();
        System.out.println("Welcome to Zoo Store!");
        zs.mainMenu(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
    }
    protected void mainMenu(ArrayList<Bird> birdList, ArrayList<Amphibian> amphibianList, ArrayList<Fish> fishList, ArrayList<Rodent> rodentList, ArrayList<Reptile> reptileList, ArrayList<Insect> insectList, 
            ArrayList<Terrarium> terrariumList, ArrayList<Aquarium> aquariumList, ArrayList<RodentCage> rodentCageList, ArrayList<BirdCage> birdCageList, ArrayList<FreshFood> freshFoodList, ArrayList<FrozenFood> frozenFoodList)
    {
        System.out.println("\n================================================");
        System.out.println("1 - Add          2 - Remove          3 - Sell\n4 - Update       5 - List stock      6 - Balance\n7 - Exit");
        System.out.println("================================================");
        System.out.print("Please enter your choice: ");
        Scanner inChoice = new Scanner(System.in);
        String choice;
        choice = inChoice.nextLine().toLowerCase();
        switch(choice)
        {
            case "add":
            case "1":
                petshopClearConsole.clearConsoleRobot();
                System.out.println("Add\n1 - Pet\n2 - Accessory");
                System.out.println("____________________________");
                System.out.print("Please enter your choice: ");
                choice = inChoice.nextLine().toLowerCase();
                switch(choice)
                {
                    case "pet":
                    case "1":
                        petshopClearConsole.clearConsoleRobot();
                        p.addPet(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
                        break;
                    case "accessory":
                    case "2":
                        petshopClearConsole.clearConsoleRobot();
                        acc.addAcc(freshFoodList, frozenFoodList, terrariumList, aquariumList, rodentCageList, birdCageList, birdList, amphibianList, fishList, rodentList, reptileList, insectList);
                        break;
                    default:
                        petshopClearConsole.clearConsoleRobot();
                        System.out.println("Invalid input, please make a valid choice from the menu.");
                        zs.mainMenu(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
                        break;
                }
                break;
            case "remove":
            case "2":
                petshopClearConsole.clearConsoleRobot();
                System.out.println("\nRemove\n1 - Pet\n2 - Accessory");
                System.out.println("____________________________");
                System.out.print("Please enter your choice: ");
                choice = inChoice.nextLine().toLowerCase();
                switch(choice)
                {
                    case "pet":
                    case "1":
                        petshopClearConsole.clearConsoleRobot();
                        p.removePet(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
                        break;
                    case "accessory":
                    case "2":
                        petshopClearConsole.clearConsoleRobot();
                        acc.removeAcc(freshFoodList, frozenFoodList, terrariumList, aquariumList, rodentCageList, birdCageList, birdList, amphibianList, fishList, rodentList, reptileList, insectList);
                        break;
                    default:
                        petshopClearConsole.clearConsoleRobot();
                        System.out.println("Invalid input, please make a valid choice from the menu.");
                        zs.mainMenu(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
                        break;
                }
                break;
            case "sell":
            case "3":
                petshopClearConsole.clearConsoleRobot();
                System.out.println("\nSell\n1 - Pet\n2 - Accessory");
                System.out.println("____________________________");
                System.out.print("Please enter your choice: ");
                choice = inChoice.nextLine().toLowerCase();
                switch(choice)
                {
                    case "pet":
                    case "1":
                        petshopClearConsole.clearConsoleRobot();
                        p.sellPet(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
                        break;
                    case "accessory":
                    case "2":
                        petshopClearConsole.clearConsoleRobot();
                        acc.sellAcc(freshFoodList, frozenFoodList, terrariumList, aquariumList, rodentCageList, birdCageList, birdList, amphibianList, fishList, rodentList, reptileList, insectList);
                        break;
                    default:
                        petshopClearConsole.clearConsoleRobot();
                        System.out.println("Invalid input, please make a valid choice from the menu.");
                        zs.mainMenu(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
                        break;
                }
                break;
            case "update":
            case "4":
                System.out.println("\nUpdate\n1 - Pet\n2 - Accessory");
                System.out.println("____________________________");
                System.out.print("Please enter your choice: ");
                choice = inChoice.nextLine().toLowerCase();
                switch(choice)
                {
                    case "pet":
                    case "1":
                        petshopClearConsole.clearConsoleRobot();
                        p.updatePet(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
                        break;
                    case "accessory":
                    case "2":
                        petshopClearConsole.clearConsoleRobot();
                        acc.updateAcc(freshFoodList, frozenFoodList, terrariumList, aquariumList, rodentCageList, birdCageList, birdList, amphibianList, fishList, rodentList, reptileList, insectList);
                        break;
                    default:
                        petshopClearConsole.clearConsoleRobot();
                        System.out.println("Invalid input, please make a valid choice from the menu.");
                        zs.mainMenu(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
                        break;
                }
                break;
            case "list":
            case "list stock":
            case "5":
                displayList(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
                break;
            case "balance":
            case "6":
                checkBalance(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
                break;
            case "exit":
            case "7":
                zs.writeFile(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
                petshopClearConsole.clearConsoleRobot();
                System.exit(0);
            default:
                petshopClearConsole.clearConsoleRobot();
                System.out.println("Invalid input, please make a valid choice from the menu.");
                zs.mainMenu(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
                break;
        }
    }
    private void displayList(ArrayList<Bird> birdList, ArrayList<Amphibian> amphibianList, ArrayList<Fish> fishList, ArrayList<Rodent> rodentList, ArrayList<Reptile> reptileList, ArrayList<Insect> insectList, 
            ArrayList<Terrarium> terrariumList, ArrayList<Aquarium> aquariumList, ArrayList<RodentCage> rodentCageList, ArrayList<BirdCage> birdCageList, ArrayList<FreshFood> freshFoodList, ArrayList<FrozenFood> frozenFoodList)
    {
        petshopClearConsole.clearConsoleRobot();
        System.out.println("\nSpecies        Age       Weight    Price");
        System.out.println("========================================");
        for (Bird bir : birdList)
        {
            System.out.printf("%-15s%-10s%-10s%-10s\n" , bir.getType().substring(0, 1).toUpperCase() + bir.getType().substring(1), bir.getAge(), bir.getWeight(), bir.getPrice());
        }
        for (Amphibian amph : amphibianList)
        {
            System.out.printf("%-15s%-10s%-10s%-10s\n" , amph.getType().substring(0, 1).toUpperCase() + amph.getType().substring(1), amph.getAge(), amph.getWeight(), amph.getPrice());
        }
        for (Fish fish : fishList)
        {
            System.out.printf("%-15s%-10s%-10s%-10s\n" , fish.getType().substring(0, 1).toUpperCase() + fish.getType().substring(1), fish.getAge(), fish.getWeight(), fish.getPrice());
        }
        for (Rodent rod : rodentList)
        {
            System.out.printf("%-15s%-10s%-10s%-10s\n" , rod.getType().substring(0, 1).toUpperCase() + rod.getType().substring(1), rod.getAge(), rod.getWeight(), rod.getPrice());
        }
        for (Reptile rep : reptileList)
        {
            System.out.printf("%-15s%-10s%-10s%-10s\n" , rep.getType().substring(0, 1).toUpperCase() + rep.getType().substring(1), rep.getAge(), rep.getWeight(), rep.getPrice());
        }
        for (Insect ins : insectList)
        {
            System.out.printf("%-35s%-10s\n" , ins.getType().substring(0, 1).toUpperCase() + ins.getType().substring(1), ins.getPrice());
        }
        System.out.println("========================================");
        System.out.println("Item            Price              Amount");
        System.out.println("=========================================");
        System.out.printf("%-15s%-20d%-30d\n" , "Terrarium", tr.getTerrPrice(), terrariumList.size());
        System.out.printf("%-15s%-20d%-30d\n" , "Aquarium", aq.getAqPrice(), aquariumList.size());
        System.out.printf("%-15s%-20d%-30d\n" , "Rodent Cage", rc.getRcPrice(), rodentCageList.size());
        System.out.printf("%-15s%-20d%-30d\n" , "Bird Cage", bc.getBcPrice(), birdCageList.size());
        System.out.println("=========================================");
        System.out.print("Press ENTER to go back to main menu. ");
        Scanner choice = new Scanner(System.in);
        String inp = choice.nextLine();
        
        petshopClearConsole.clearConsoleRobot();
        mainMenu(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
    }
    private void checkBalance(ArrayList<Bird> birdList, ArrayList<Amphibian> amphibianList, ArrayList<Fish> fishList, ArrayList<Rodent> rodentList, ArrayList<Reptile> reptileList, ArrayList<Insect> insectList, 
            ArrayList<Terrarium> terrariumList, ArrayList<Aquarium> aquariumList, ArrayList<RodentCage> rodentCageList, ArrayList<BirdCage> birdCageList, ArrayList<FreshFood> freshFoodList, ArrayList<FrozenFood> frozenFoodList)
    {
        petshopClearConsole.clearConsoleRobot();
        System.out.println("\n-------------------------");
        System.out.println("Current balance: " + money + ":-");
        System.out.println("-------------------------");
        
        System.out.print("\nPress ENTER to go back to main menu. ");
        Scanner choice = new Scanner(System.in);
        String inp = choice.nextLine();
        
        petshopClearConsole.clearConsoleRobot();
        zs.mainMenu(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
    }
    protected void writeFile(ArrayList<Bird> birdList, ArrayList<Amphibian> amphibianList, ArrayList<Fish> fishList, ArrayList<Rodent> rodentList, ArrayList<Reptile> reptileList, ArrayList<Insect> insectList, 
            ArrayList<Terrarium> terrariumList, ArrayList<Aquarium> aquariumList, ArrayList<RodentCage> rodentCageList, ArrayList<BirdCage> birdCageList, ArrayList<FreshFood> freshFoodList, ArrayList<FrozenFood> frozenFoodList)
    {
        try
        {
        String birdFile = "Birds.txt";
        FileWriter birdWriter = new FileWriter(birdFile);
        BufferedWriter bufferedBirdWriter = new BufferedWriter(birdWriter);
        
        String amphibianFile = "Amphibian.txt";
        FileWriter amphibianWriter = new FileWriter(amphibianFile);
        BufferedWriter bufferedAmphibianWriter = new BufferedWriter(amphibianWriter);
        
        String fishFile = "Fish.txt";
        FileWriter fishWriter = new FileWriter(fishFile);
        BufferedWriter bufferedFishWriter = new BufferedWriter(fishWriter);
        
        String rodentFile = "Rodent.txt";
        FileWriter rodentWriter = new FileWriter(rodentFile);
        BufferedWriter bufferedRodentWriter = new BufferedWriter(rodentWriter);
        
        String reptileFile = "Reptile.txt";
        FileWriter reptileWriter = new FileWriter(reptileFile);
        BufferedWriter bufferedReptileWriter = new BufferedWriter(reptileWriter);
        
        String insectFile = "Insect.txt";
        FileWriter insectWriter = new FileWriter(insectFile);
        BufferedWriter bufferedInsectWriter = new BufferedWriter(insectWriter);
        
        int i = 1;
        for (Bird bir : birdList)
        {
            bufferedBirdWriter.write(bir.getType().substring(0, 1).toUpperCase() + bir.getType().substring(1) + "," + bir.getAge() + "," + bir.getWeight() + "," + bir.getPrice());
            bufferedBirdWriter.newLine();
            i += 1;
        }
        for (Amphibian amph : amphibianList)
        {
            bufferedAmphibianWriter.write(amph.getType().substring(0, 1).toUpperCase() + amph.getType().substring(1) + "," + amph.getAge() + "," + amph.getWeight() + "," + amph.getPrice());
            bufferedAmphibianWriter.newLine();
            i += 1;
        }
        for (Fish fish : fishList)
        {
            bufferedFishWriter.write(fish.getType().substring(0, 1).toUpperCase() + fish.getType().substring(1) + "," + fish.getAge() + "," + fish.getWeight() + "," + fish.getPrice());
            bufferedFishWriter.newLine();
            i += 1;
        }
        for (Rodent rod : rodentList)
        {
            bufferedRodentWriter.write(rod.getType().substring(0, 1).toUpperCase() + rod.getType().substring(1) + "," + rod.getAge() + "," + rod.getWeight() + "," + rod.getPrice());
            bufferedRodentWriter.newLine();
            i += 1;
        }
        for (Reptile rep : reptileList)
        {
            bufferedReptileWriter.write(rep.getType().substring(0, 1).toUpperCase() + rep.getType().substring(1) + "," + rep.getAge() + "," + rep.getWeight() + "," + rep.getPrice());
            bufferedReptileWriter.newLine();
            i += 1;
        }
        for (Insect ins : insectList)
        {
            bufferedInsectWriter.write(ins.getType().substring(0, 1).toUpperCase() + ins.getType().substring(1) + "," + ins.getAge() + "," + ins.getWeight() + "," + ins.getPrice());
            bufferedInsectWriter.newLine();
            i += 1;
        }
        bufferedBirdWriter.close();
        bufferedAmphibianWriter.close();
        bufferedFishWriter.close();
        bufferedRodentWriter.close();
        bufferedReptileWriter.close();
        bufferedInsectWriter.close();
        /*
        bufferedWriter.newLine();
        bufferedWriter.write(tr.getAccType() + "," + tr.getTerrPrice() + "," + terrariumList.size());
        bufferedWriter.newLine();
        bufferedWriter.write(aq.getAccType() + "," + aq.getAqPrice() + "," + aquariumList.size());
        bufferedWriter.newLine();
        bufferedWriter.write(rc.getAccType() + "," + rc.getRcPrice() + "," + rodentCageList.size());
        bufferedWriter.newLine();
        bufferedWriter.write(bc.getAccType() + "," + bc.getBcPrice() + "," + birdCageList.size());
        bufferedWriter.newLine();
        bufferedWriter.write(freF.getFoodType() + "," + freshFoodList.size());
        bufferedWriter.newLine();
        bufferedWriter.write(froF.getFoodType() + "," + frozenFoodList.size());
        bufferedWriter.close();
        */
        }
        catch (IOException ex)
        {
            System.err.println("IO Exception occurred.");
            System.exit(0);
        }
    }
    private void readFile(ArrayList<Bird> birdList, ArrayList<Amphibian> amphibianList, ArrayList<Fish> fishList, ArrayList<Rodent> rodentList, ArrayList<Reptile> reptileList, ArrayList<Insect> insectList, 
            ArrayList<Terrarium> terrariumList, ArrayList<Aquarium> aquariumList, ArrayList<RodentCage> rodentCageList, ArrayList<BirdCage> birdCageList, ArrayList<FreshFood> freshFoodList, ArrayList<FrozenFood> frozenFoodList)
    {
        try
        {
        String birdFile = "Birds.txt";
        FileReader birdReader = new FileReader(birdFile);
        BufferedReader bufferedBirdReader = new BufferedReader(birdReader);
        
        String amphibianFile = "Amphibian.txt";
        FileReader amphibianReader = new FileReader(amphibianFile);
        BufferedReader bufferedAmphibianReader = new BufferedReader(amphibianReader);
        
        String fishFile = "Fish.txt";
        FileReader fishReader = new FileReader(fishFile);
        BufferedReader bufferedFishReader = new BufferedReader(fishReader);
        
        String rodentFile = "Rodent.txt";
        FileReader rodentReader = new FileReader(rodentFile);
        BufferedReader bufferedRodentReader = new BufferedReader(rodentReader);
        
        String reptileFile = "Reptile.txt";
        FileReader reptileReader = new FileReader(reptileFile);
        BufferedReader bufferedReptileReader = new BufferedReader(reptileReader);
        
        String insectFile = "Insect.txt";
        FileReader insectReader = new FileReader(insectFile);
        BufferedReader bufferedInsectReader = new BufferedReader(insectReader);
                
        int i = 1;
        for (int j = 0; j < 4; j++)
        {
            bufferedBirdReader.read();
            i += 1;
        }
        for (Amphibian amph : amphibianList)
        {
            bufferedAmphibianReader.read();
            i += 1;
        }
        for (Fish fish : fishList)
        {
            bufferedFishReader.read();
            i += 1;
        }
        for (Rodent rod : rodentList)
        {
            bufferedRodentReader.read();
            i += 1;
        }
        for (Reptile rep : reptileList)
        {
            bufferedReptileReader.read();
            i += 1;
        }
        for (Insect ins : insectList)
        {
            bufferedInsectReader.read();
            i += 1;
        }
        bufferedBirdReader.close();
        bufferedAmphibianReader.close();
        bufferedFishReader.close();
        bufferedRodentReader.close();
        bufferedReptileReader.close();
        bufferedInsectReader.close();
        }
        catch (IOException ex)
        {
            System.err.println("IO Exception occurred.");
            System.exit(0);
        }
    }
}