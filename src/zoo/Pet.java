package zoo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import static zoo.ZooStore.money;

public class Pet {
    public String type;
    private int age, price;
    private double weight;
    
    static ZooStore zs = new ZooStore();
    ClearConsole petshopClearConsole = new ClearConsole();
    
    public Pet(String type, int age, double weight, int price)
    {
        this.type = type;
        this.age = age;
        this.price = price;
        this.weight = weight;
    }
    public Pet()
    {
    }
    protected String getType()
    {
        return type;
    }
    protected int getAge()
    {
        return age;
    }
    protected int getPrice()
    {
        return price;
    }
    protected double getWeight()
    {
        return weight;
    }
    public void setAge(int age)
    {
        this.age = age;
    }
    public void setPrice(int price)
    {
        this.price = price;
    }
    public void setWeight(double weight)
    {
        this.weight = weight;
    }
    protected void addPet(ArrayList<Bird> birdList, ArrayList<Amphibian> amphibianList, ArrayList<Fish> fishList, ArrayList<Rodent> rodentList, ArrayList<Reptile> reptileList, ArrayList<Insect> insectList, 
            ArrayList<Terrarium> terrariumList, ArrayList<Aquarium> aquariumList, ArrayList<RodentCage> rodentCageList, ArrayList<BirdCage> birdCageList, ArrayList<FreshFood> freshFoodList, ArrayList<FrozenFood> frozenFoodList)
    {
        Scanner input = new Scanner(System.in);
        String petType = "";
        int petAge = 0;
        int petPrice = 0;
        double petWeight = 0;
        
        System.out.println("\nWhich type of animal would you like to add?\n1 - Zebra finch         2 - Cockatiel         3 - Parrot         4 - Frog         5 - Salamander"
                + "\n6 - Fish                7 - Hamster           8 - Mouse          9 - Guinea pig   10 - Rabbit\n"
                + "11 - Snake              12 - Lizard           13 - Mantis        14 - Walking stick");
        System.out.println("________________________________________________________________________________________________________________");
        System.out.println("Or press ENTER to go back to main menu.\n");
        try
        {
        System.out.print("Enter animal species: ");
        petType = input.nextLine().toLowerCase();
        if (petType.equals(""))
        {
            petshopClearConsole.clearConsoleRobot();
            zs.mainMenu(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
        }
        if ((petType.equals("mantis")) || petType.equals("walking stick") || petType.equals("13") || petType.equals("14"))
        {
            petAge = 0;
            petWeight = 0;
        }
        else
        {
            System.out.print("Enter age of animal: ");
            petAge = input.nextInt();
            System.out.print("Enter weight of animal: ");
            petWeight = input.nextDouble();
        }
        System.out.print("Enter price of animal: ");
        petPrice = input.nextInt();
        }
        catch (InputMismatchException ex)
        {
            petshopClearConsole.clearConsoleRobot();
            System.err.println("Invalid type of characters, please try again.\n");
            System.exit(0);
        }
        switch (petType)
        {
        case "zebra finch":
        case "1":
            birdList.add(new ZebraFinch("Zebra Finch", petAge, petWeight, petPrice));
        break;
        case "cockatiel":
        case "2":
            birdList.add(new Cockatiel("Cockatiel", petAge, petWeight, petPrice));
        break;
        case "parrot":
        case "3":
            birdList.add(new Parrot("Parrot", petAge, petWeight, petPrice));
        break;
        case "frog":
        case "4":
            amphibianList.add(new Frog("Frog", petAge, petWeight, petPrice));
        break;
        case "salamander":
        case "5":
            amphibianList.add(new Salamander("Salamander", petAge, petWeight, petPrice));
        break;
        case "fish":
        case "6":
            fishList.add(new Fish("Fish", petAge, petWeight, petPrice));
        break;
        case "hamster":
        case "7":
            rodentList.add(new Hamster("Hamster", petAge, petWeight, petPrice));
        break;
        case "mouse":
        case "8":
            rodentList.add(new Mouse("Mouse", petAge, petWeight, petPrice));
        break;
        case "guinea pig":
        case "9":
            rodentList.add(new GuineaPig("Guinea Pig", petAge, petWeight, petPrice));
        break;
        case "rabbit":
        case "10":
            rodentList.add(new Rabbit("Rabbit", petAge, petWeight, petPrice));
        break;
        case "snake":
        case "11":
            reptileList.add(new Snake("Snake", petAge, petWeight, petPrice));
        break;
        case "lizard":
        case "12":
            reptileList.add(new Lizard("Lizard", petAge, petWeight, petPrice));
        break;
        case "mantis":
        case "13":
            insectList.add(new Mantis("Mantis", petAge, petWeight, petPrice));
        break;
        case "walking stick":
        case "14":
            insectList.add(new WalkingStick("Walking Stick", petAge, petWeight, petPrice));
        break;
        default:
            petshopClearConsole.clearConsoleRobot();
            System.out.println("\nYou must type in a valid animal species!\n");
            addPet(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
    }
        petshopClearConsole.clearConsoleRobot();
        zs.writeFile(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
        zs.mainMenu(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
    }
    protected void removePet(ArrayList<Bird> birdList, ArrayList<Amphibian> amphibianList, ArrayList<Fish> fishList, ArrayList<Rodent> rodentList, ArrayList<Reptile> reptileList, ArrayList<Insect> insectList, 
            ArrayList<Terrarium> terrariumList, ArrayList<Aquarium> aquariumList, ArrayList<RodentCage> rodentCageList, ArrayList<BirdCage> birdCageList, ArrayList<FreshFood> freshFoodList, ArrayList<FrozenFood> frozenFoodList)
    {
        int i = 1;
        int c;
        
        Scanner choice = new Scanner(System.in);
        System.out.println("\nWhich type of animal would you like to remove?\n1 - Bird    2 - Amphibian    3 - Fish    4 - Rodent    5 - Reptile    6 - Insect");
        System.out.println("____________________________________________________________________________________");
        System.out.println("Or press ENTER to go back to main menu.\n");
        System.out.print("Please enter your choice: ");
        String animalChoice = choice.nextLine().toLowerCase();
        petshopClearConsole.clearConsoleRobot();
        
        System.out.println("\n  Species       Age       Weight    Price");
        System.out.println("=========================================");
        try {
        switch (animalChoice)
        {
            case "bird":
            case "1":
                for (Bird bir : birdList)
                {
                    System.out.printf("%-2d%-15s%-10s%-10s%-10s\n" , i, bir.getType().substring(0, 1).toUpperCase() + bir.getType().substring(1), bir.getAge(), bir.getWeight(), bir.getPrice());
                    i += 1;
                }
                System.out.println("=========================================");
                System.out.print("Which bird would you like to remove?\nChoose a number: ");
                c = choice.nextInt();
                birdList.remove(c - 1);
                break;
            case "amphibian":
            case "2":
                for (Amphibian amph : amphibianList)
                {
                    System.out.printf("%-2d%-15s%-10s%-10s%-10s\n" , i, amph.getType().substring(0, 1).toUpperCase() + amph.getType().substring(1), amph.getAge(), amph.getWeight(), amph.getPrice());
                    i += 1;
                }
                System.out.println("=========================================");
                System.out.print("Which amphibian would you like to remove?\nChoose a number: ");
                c = choice.nextInt();
                amphibianList.remove(c - 1);
                break;
            case "fish":
            case "3":
                for (Fish fish : fishList)
                {
                    System.out.printf("%-2d%-15s%-10s%-10s%-10s\n" , i, fish.getType().substring(0, 1).toUpperCase() + fish.getType().substring(1), fish.getAge(), fish.getWeight(), fish.getPrice());
                    i += 1;
                }
                System.out.println("=========================================");
                System.out.print("Which fish would you like to remove?\nChoose a number: ");
                c = choice.nextInt();
                fishList.remove(c - 1);
                break;
            case "rodent":
            case "4":
                for (Rodent rod : rodentList)
                {
                    System.out.printf("%-2d%-15s%-10s%-10s%-10s\n" , i, rod.getType().substring(0, 1).toUpperCase() + rod.getType().substring(1), rod.getAge(), rod.getWeight(), rod.getPrice());
                    i += 1;
                }
                System.out.println("=========================================");
                System.out.print("Which rodent would you like to remove?\nChoose a number: ");
                c = choice.nextInt();
                rodentList.remove(c - 1);
                break;
            case "reptile":
            case "5":
                for (Reptile rep : reptileList)
                {
                    System.out.printf("%-2d%-15s%-10s%-10s%-10s\n" , i, rep.getType().substring(0, 1).toUpperCase() + rep.getType().substring(1), rep.getAge(), rep.getWeight(), rep.getPrice());
                    i += 1;
                }
                System.out.println("=========================================");
                System.out.print("Which reptile would you like to remove?\nChoose a number: ");
                c = choice.nextInt();
                reptileList.remove(c - 1);
                break;
            case "insect":
            case "6":
                for (Insect ins : insectList)
                {
                    System.out.printf("%-2d%-35s%-10s\n" , i, ins.getType().substring(0, 1).toUpperCase() + ins.getType().substring(1), ins.getPrice());
                    i += 1;
                }
                System.out.println("=========================================");
                System.out.print("Which insect would you like to remove?\nChoose a number: ");
                c = choice.nextInt();
                insectList.remove(c - 1);
                break;
            case "":
                System.out.println("=========================================");
                petshopClearConsole.clearConsoleRobot();
                zs.mainMenu(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
            default:
                System.out.println("\nYou must type in a valid animal species!\n");
                removePet(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
        }
        }
        catch(IndexOutOfBoundsException ex)
        {
            petshopClearConsole.clearConsoleRobot();
            System.err.println("You must choose a valid number.\n");
            removePet(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
        }
        petshopClearConsole.clearConsoleRobot();
        System.out.println("Animal removed!");
        zs.writeFile(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
        zs.mainMenu(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
    }
    protected void sellPet(ArrayList<Bird> birdList, ArrayList<Amphibian> amphibianList, ArrayList<Fish> fishList, ArrayList<Rodent> rodentList, ArrayList<Reptile> reptileList, ArrayList<Insect> insectList, 
            ArrayList<Terrarium> terrariumList, ArrayList<Aquarium> aquariumList, ArrayList<RodentCage> rodentCageList, ArrayList<BirdCage> birdCageList, ArrayList<FreshFood> freshFoodList, ArrayList<FrozenFood> frozenFoodList)
    {
        int i = 1;
        int c;
        
        Scanner choice = new Scanner(System.in);
        System.out.println("\nWhich type of animal would you like to sell?\n1 - Bird    2 - Amphibian    3 - Fish    4 - Rodent    5 - Reptile    6 - Insect");
        System.out.println("____________________________________________________________________________________");
        System.out.println("Or press ENTER to go back to main menu.\n");
        System.out.print("Please enter your choice: ");
        String animalChoice = choice.nextLine().toLowerCase();
        petshopClearConsole.clearConsoleRobot();
        
        System.out.println("\n  Species       Age       Weight    Price");
        System.out.println("=========================================");
        try {
        switch (animalChoice)
        {
            case "bird":
            case "1":
                for (Bird bir : birdList)
                {
                    System.out.printf("%-2d%-15s%-10s%-10s%-10s\n" , i, bir.getType().substring(0, 1).toUpperCase() + bir.getType().substring(1), bir.getAge(), bir.getWeight(), bir.getPrice());
                    i += 1;
                }
                System.out.println("=========================================");
                if (birdList.isEmpty())
                {
                    petshopClearConsole.clearConsoleRobot();
                    System.out.println("There are no birds available in stock.");
                    sellPet(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
                }
                System.out.print("Which bird would you like to sell?\nChoose a number: ");
                c = choice.nextInt();
                money += birdList.get(c - 1).getPrice();
                birdList.remove(c - 1);
                break;
            case "amphibian":
            case "2":
                for (Amphibian amph : amphibianList)
                {
                    System.out.printf("%-2d%-15s%-10s%-10s%-10s\n" , i, amph.getType().substring(0, 1).toUpperCase() + amph.getType().substring(1), amph.getAge(), amph.getWeight(), amph.getPrice());
                    i += 1;
                }
                System.out.println("=========================================");
                if (amphibianList.isEmpty())
                {
                    petshopClearConsole.clearConsoleRobot();
                    System.out.println("There are no amphibians available in stock.");
                    sellPet(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
                }
                System.out.print("Which amphibian would you like to sell?\nChoose a number: ");
                c = choice.nextInt();
                money += amphibianList.get(c - 1).getPrice();
                amphibianList.remove(c - 1);
                break;
            case "fish":
            case "3":
                for (Fish fish : fishList)
                {
                    System.out.printf("%-2d%-15s%-10s%-10s%-10s\n" , i, fish.getType().substring(0, 1).toUpperCase() + fish.getType().substring(1), fish.getAge(), fish.getWeight(), fish.getPrice());
                    i += 1;
                }
                System.out.println("=========================================");
                if (fishList.isEmpty())
                {
                    petshopClearConsole.clearConsoleRobot();
                    System.out.println("There are no fish available in stock.");
                    sellPet(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
                }
                System.out.print("Which fish would you like to sell?\nChoose a number: ");
                c = choice.nextInt();
                money += fishList.get(c - 1).getPrice();
                fishList.remove(c - 1);
                break;
            case "rodent":
            case "4":
                for (Rodent rod : rodentList)
                {
                    System.out.printf("%-2d%-15s%-10s%-10s%-10s\n" , i, rod.getType().substring(0, 1).toUpperCase() + rod.getType().substring(1), rod.getAge(), rod.getWeight(), rod.getPrice());
                    i += 1;
                }
                System.out.println("=========================================");
                if (rodentList.isEmpty())
                {
                    petshopClearConsole.clearConsoleRobot();
                    System.out.println("There are no rodents available in stock.");
                    sellPet(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
                }
                System.out.print("Which rodent would you like to sell?\nChoose a number: ");
                c = choice.nextInt();
                money += rodentList.get(c - 1).getPrice();
                rodentList.remove(c - 1);
                break;
            case "reptile":
            case "5":
                for (Reptile rep : reptileList)
                {
                    System.out.printf("%-2d%-15s%-10s%-10s%-10s\n" , i, rep.getType().substring(0, 1).toUpperCase() + rep.getType().substring(1), rep.getAge(), rep.getWeight(), rep.getPrice());
                    i += 1;
                }
                System.out.println("=========================================");
                if (reptileList.isEmpty())
                {
                    petshopClearConsole.clearConsoleRobot();
                    System.out.println("There are no reptiles available in stock.");
                    sellPet(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
                }
                System.out.print("Which reptile would you like to sell?\nChoose a number: ");
                c = choice.nextInt();
                money += reptileList.get(c - 1).getPrice();
                reptileList.remove(c - 1);
                break;
            case "insect":
            case "6":
                for (Insect ins : insectList)
                {
                    System.out.printf("%-2d%-35s%-10s\n" , i, ins.getType().substring(0, 1).toUpperCase() + ins.getType().substring(1), ins.getPrice());
                    i += 1;
                }
                System.out.println("=========================================");
                if (insectList.isEmpty())
                {
                    petshopClearConsole.clearConsoleRobot();
                    System.out.println("There are no insects available in stock.");
                    sellPet(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
                }
                System.out.print("Which insect would you like to sell?\nChoose a number: ");
                c = choice.nextInt();
                money += insectList.get(c - 1).getPrice();
                insectList.remove(c - 1);
                break;
            case "":
                System.out.println("=========================================");
                petshopClearConsole.clearConsoleRobot();
                zs.mainMenu(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
            default:
                System.out.println("=========================================");
                petshopClearConsole.clearConsoleRobot();
                System.out.println("\nYou must type in a valid animal species!\n");
                sellPet(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
        }
        } catch(IndexOutOfBoundsException ex)
        {
            petshopClearConsole.clearConsoleRobot();
            System.err.println("You must choose a valid number.\n");
            sellPet(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
        }
        petshopClearConsole.clearConsoleRobot();
        System.out.println("Animal sold!");
        zs.writeFile(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
        zs.mainMenu(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
    }
    protected void updatePet(ArrayList<Bird> birdList, ArrayList<Amphibian> amphibianList, ArrayList<Fish> fishList, ArrayList<Rodent> rodentList, ArrayList<Reptile> reptileList, ArrayList<Insect> insectList, 
            ArrayList<Terrarium> terrariumList, ArrayList<Aquarium> aquariumList, ArrayList<RodentCage> rodentCageList, ArrayList<BirdCage> birdCageList, ArrayList<FreshFood> freshFoodList, ArrayList<FrozenFood> frozenFoodList)
    {
        int i = 1;
        int c, a, p;
        double w;
        
        Scanner choice = new Scanner(System.in);
        System.out.println("\nWhich type of animal would you like to update?\n1 - Bird    2 - Amphibian    3 - Fish    4 - Rodent    5 - Reptile    6 - Insect");
        System.out.println("____________________________________________________________________________________");
        System.out.println("Or press ENTER to go back to main menu.\n");
        System.out.print("Please enter your choice: ");
        String animalChoice = choice.nextLine().toLowerCase();
        petshopClearConsole.clearConsoleRobot();
        
        System.out.println("\n  Species       Age       Weight    Price");
        System.out.println("=========================================");
        try {
        switch (animalChoice)
        {
            case "bird":
            case "1":
                for (Bird bir : birdList)
                {
                    System.out.printf("%-2d%-15s%-10s%-10s%-10s\n" , i, bir.getType().substring(0, 1).toUpperCase() + bir.getType().substring(1), bir.getAge(), bir.getWeight(), bir.getPrice());
                    i += 1;
                }
                System.out.println("=========================================");
                if (birdList.isEmpty())
                {
                    petshopClearConsole.clearConsoleRobot();
                    System.out.println("There are no birds available in stock.");
                    updatePet(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
                }
                System.out.print("Which bird would you like to update?\nChoose a number: ");
                c = choice.nextInt();
                System.out.print("\nEnter age of animal: ");
                a = choice.nextInt();
                birdList.get(c - 1).setAge(a);
                System.out.print("Enter weight of animal: ");
                w = choice.nextDouble();
                birdList.get(c - 1).setWeight(w);
                System.out.print("Enter price of animal: ");
                p = choice.nextInt();
                birdList.get(c - 1).setPrice(p);
                break;
            case "amphibian":
            case "2":
                for (Amphibian amph : amphibianList)
                {
                    System.out.printf("%-2d%-15s%-10s%-10s%-10s\n" , i, amph.getType().substring(0, 1).toUpperCase() + amph.getType().substring(1), amph.getAge(), amph.getWeight(), amph.getPrice());
                    i += 1;
                }
                System.out.println("=========================================");
                if (amphibianList.isEmpty())
                {
                    petshopClearConsole.clearConsoleRobot();
                    System.out.println("There are no amphibians available in stock.");
                    updatePet(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
                }
                System.out.print("Which amphibian would you like to update?\nChoose a number: ");
                c = choice.nextInt();
                System.out.print("\nEnter age of animal: ");
                a = choice.nextInt();
                amphibianList.get(c - 1).setAge(a);
                System.out.print("Enter weight of animal: ");
                w = choice.nextDouble();
                amphibianList.get(c - 1).setWeight(w);
                System.out.print("Enter price of animal: ");
                p = choice.nextInt();
                amphibianList.get(c - 1).setPrice(p);
                break;
            case "fish":
            case "3":
                for (Fish fish : fishList)
                {
                    System.out.printf("%-2d%-15s%-10s%-10s%-10s\n" , i, fish.getType().substring(0, 1).toUpperCase() + fish.getType().substring(1), fish.getAge(), fish.getWeight(), fish.getPrice());
                    i += 1;
                }
                System.out.println("=========================================");
                if (fishList.isEmpty())
                {
                    petshopClearConsole.clearConsoleRobot();
                    System.out.println("There are no fish available in stock.");
                    updatePet(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
                }
                System.out.print("Which fish would you like to update?\nChoose a number: ");
                c = choice.nextInt();
                System.out.print("\nEnter age of animal: ");
                a = choice.nextInt();
                fishList.get(c - 1).setAge(a);
                System.out.print("Enter weight of animal: ");
                w = choice.nextDouble();
                fishList.get(c - 1).setWeight(w);
                System.out.print("Enter price of animal: ");
                p = choice.nextInt();
                fishList.get(c - 1).setPrice(p);
                break;
            case "rodent":
            case "4":
                for (Rodent rod : rodentList)
                {
                    System.out.printf("%-2d%-15s%-10s%-10s%-10s\n" , i, rod.getType().substring(0, 1).toUpperCase() + rod.getType().substring(1), rod.getAge(), rod.getWeight(), rod.getPrice());
                    i += 1;
                }
                System.out.println("=========================================");
                if (rodentList.isEmpty())
                {
                    petshopClearConsole.clearConsoleRobot();
                    System.out.println("There are no rodents available in stock.");
                    updatePet(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
                }
                System.out.print("Which rodent would you like to update?\nChoose a number: ");
                c = choice.nextInt();
                System.out.print("\nEnter age of animal: ");
                a = choice.nextInt();
                rodentList.get(c - 1).setAge(a);
                System.out.print("Enter weight of animal: ");
                w = choice.nextDouble();
                rodentList.get(c - 1).setWeight(w);
                System.out.print("Enter price of animal: ");
                p = choice.nextInt();
                rodentList.get(c - 1).setPrice(p);;
                break;
            case "reptile":
            case "5":
                for (Reptile rep : reptileList)
                {
                    System.out.printf("%-2d%-15s%-10s%-10s%-10s\n" , i, rep.getType().substring(0, 1).toUpperCase() + rep.getType().substring(1), rep.getAge(), rep.getWeight(), rep.getPrice());
                    i += 1;
                }
                System.out.println("=========================================");
                if (reptileList.isEmpty())
                {
                    petshopClearConsole.clearConsoleRobot();
                    System.out.println("There are no reptiles available in stock.");
                    updatePet(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
                }
                System.out.print("Which reptile would you like to update?\nChoose a number: ");
                c = choice.nextInt();
                System.out.print("\nEnter age of animal: ");
                a = choice.nextInt();
                reptileList.get(c - 1).setAge(a);
                System.out.print("Enter weight of animal: ");
                w = choice.nextDouble();
                reptileList.get(c - 1).setWeight(w);
                System.out.print("Enter price of animal: ");
                p = choice.nextInt();
                reptileList.get(c - 1).setPrice(p);
                break;
            case "insect":
            case "6":
                for (Insect ins : insectList)
                {
                    System.out.printf("%-2d%-35s%-10s\n" , i, ins.getType().substring(0, 1).toUpperCase() + ins.getType().substring(1), ins.getPrice());
                    i += 1;
                }
                System.out.println("=========================================");
                if (insectList.isEmpty())
                {
                    petshopClearConsole.clearConsoleRobot();
                    System.out.println("There are no insects available in stock.");
                    updatePet(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
                }
                System.out.print("Which insect would you like to update?\nChoose a number: ");
                c = choice.nextInt();
                System.out.print("\nEnter age of animal: ");
                a = choice.nextInt();
                insectList.get(c - 1).setAge(a);
                System.out.print("Enter weight of animal: ");
                w = choice.nextDouble();
                insectList.get(c - 1).setWeight(w);
                System.out.print("Enter price of animal: ");
                p = choice.nextInt();
                insectList.get(c - 1).setPrice(p);
                break;
            case "":
                System.out.println("=========================================");
                petshopClearConsole.clearConsoleRobot();
                zs.mainMenu(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
            default:
                petshopClearConsole.clearConsoleRobot();
                System.out.println("\nYou must type in a valid animal species!\n");
                updatePet(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
        }
        }
        catch(IndexOutOfBoundsException ex)
        {
            petshopClearConsole.clearConsoleRobot();
            System.err.println("You must choose a valid number.\n");
            updatePet(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
        }
        petshopClearConsole.clearConsoleRobot();
        System.out.println("Animal updated!");
        zs.writeFile(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
        zs.mainMenu(birdList, amphibianList, fishList, rodentList, reptileList, insectList, terrariumList, aquariumList, rodentCageList, birdCageList, freshFoodList, frozenFoodList);
    }
}
