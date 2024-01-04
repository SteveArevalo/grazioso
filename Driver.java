import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
	// Create ArrayLists to store Dog and Monkey objects
	private static ArrayList<Dog> dogList = new ArrayList<>();
	private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();
	private static Scanner scanner;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Initialize default dog list and monkey list
        initializeDogList();
        initializeMonkeyList();
        char choice;

        do {
            try {
                displayMenu(); // Display the menu options
                System.out.print("Enter your choice: ");
                choice = scanner.next().charAt(0); // Read user's choice
                scanner.nextLine(); // Consume newline left-over
                
                switch (choice) {
                    case '1':
                        intakeNewDog(scanner); // Intake a new dog
                        break;
                    case '2':
                        intakeNewMonkey(scanner); // Intake a new monkey
                        break;
                    case '3':
                        reserveAnimal(scanner); // Reserve an animal
                        break;
                    case '4':
                        printAnimals("dog"); // Print a list of all dogs
                        break;
                    case '5':
                        printAnimals("monkey"); // Print a list of all monkeys
                        break;
                    case '6':
                        printAnimals("available"); // Print a list of available animals
                        break;
                    case 'q':
                        System.out.println("Exiting the application..."); // Quit application
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option."); // Invalid choice message
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage()); // Catch and display any exceptions
                scanner.nextLine(); // Consume newline left-over after exception
                choice = '\0'; // Reset choice to avoid infinite loop on exception
            }
        } while (choice != 'q'); // Repeat until user chooses to quit

    }
    
    // This method prints the menu options
    // Method to print the menu options
    public static void displayMenu() {
        // Display the rescue animal system menu options
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }

    // Method to initialize a default list of dogs
    public static void initializeDogList() {
        // Create default Dog instances and add them to the dogList
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", false, "Canada");

        // Add dogs to the dogList
        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }

    // Method to initialize a default list of monkeys
    public static void initializeMonkeyList() {
        // Create default Monkey instances and add them to the monkeyList
        Monkey monkey1 = new Monkey("Milo", "Capuchin", "male", "1", "25.6", 20.5, 30.2, 40.0, "05-12-2019", "United States", "intake", false, "United States");
        Monkey monkey2 = new Monkey("Buddy", "Spider", "male", "3", "35.2", 32.0, 22.8, 45.5, "02-03-2020", "United States", "Phase I", false, "United States");
        Monkey monkey3 = new Monkey("Charlie", "Tamarin", "female", "4", "25.6", 18.9, 28.5, 36.7, "12-12-2019", "Canada", "in service", false, "Canada");

        // Add monkeys to the monkeyList
        monkeyList.add(monkey1);
        monkeyList.add(monkey2);
        monkeyList.add(monkey3);
    }
    
    public static void intakeNewDog(Scanner scanner) {
        System.out.println("Intaking a new dog...");

        System.out.println("Enter the dog's name:");
        String name = scanner.nextLine();

        // Input validation - check if the dog already exists
        for (Dog dog : dogList) {
            if (dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\nThis dog is already in our system.\n");
                return; // Returns to the main menu
            }
        }

        System.out.println("Enter the dog's breed:");
        String breed = scanner.nextLine();

        System.out.println("Enter the dog's gender:");
        String gender = scanner.nextLine();

        System.out.println("Enter the dog's age:");
        String age = scanner.nextLine();

        System.out.println("Enter the dog's weight in kg:");
        String weight = scanner.nextLine();

        System.out.println("Enter the acquisition date (mm-dd-yyyy):");
        String acquisitionDate = scanner.nextLine();

        System.out.println("Enter the acquisition country:");
        String acquisitionCountry = scanner.nextLine();

        System.out.println("Enter the training status \n(Phase I, Phase II, Phase III, "  
        		           + "Phase IV, Phase V, in service, farm:");
        String trainingStatus = scanner.nextLine();

        System.out.println("Is the dog reserved? (true/false):");
        boolean reserved = scanner.nextBoolean();
        scanner.nextLine(); // Consume newline left-over after nextBoolean()

        System.out.println("Enter the in-service country:");
        String inServiceCountry = scanner.nextLine();

        // Create a new dog instance with user-provided data
        Dog newDog = new Dog(name, breed, gender, age, weight, acquisitionDate,
                             acquisitionCountry, trainingStatus, reserved, inServiceCountry);

        // Add the new dog to the dogList
        dogList.add(newDog);
        System.out.println("\nNew dog added successfully!\n");
    }
    
    public static void intakeNewMonkey(Scanner scanner) {
        try {
            System.out.println("Intaking a new monkey...");
            System.out.println("Enter the monkey's name:");
            String name = scanner.nextLine();

            // Input validation - check if the monkey already exists
            for (Monkey monkey : monkeyList) {
                if (monkey.getName().equalsIgnoreCase(name)) {
                    System.out.println("\nThis monkey is already in our system.\n");
                    return; // Returns to the main menu
                }
            }

            String species;
            boolean isValidSpecies = false;
            do {
                System.out.println("Enter the monkey's species: \"Capuchin\", \"Spider\", \"Howler\", \"Squirrel\", \"Tamarin\"");
                species = scanner.nextLine();

                if (isValidSpecies(species)) {
                    isValidSpecies = true;
                } else {
                    System.out.println("Invalid species. Please try again.");
                }
            } while (!isValidSpecies);

            System.out.println("Enter the monkey's gender:");
            String gender = scanner.nextLine();

            System.out.println("Enter the monkey's age:");
            String age = scanner.nextLine();

            System.out.println("Enter the monekys's weight in kg: ");
            String weight = scanner.nextLine();
            
            System.out.println("Enter the monkey's height in cm:");
            double height = scanner.nextDouble();

            System.out.println("Enter the monkey's tail length in cm: ");
            double tailLength = scanner.nextDouble();

            System.out.println("Enter the monkey's body length in cm:");
            double bodyLength = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Enter the acquisition date (mm-dd-yyyy):");
            String acquisitionDate = scanner.nextLine();

            System.out.println("Enter the acquisition country:");
            String acquisitionCountry = scanner.nextLine();

            System.out.println("Enter the training status \n(Phase I, Phase II, Phase III, "  
            		           + "Phase IV, Phase V, in service, farm:");
            String trainingStatus = scanner.nextLine();

            System.out.println("Is the dog reserved? (true/false):");
            boolean reserved = scanner.nextBoolean();
            scanner.nextLine(); // Consume newline left-over after nextBoolean()

            System.out.println("Enter the in-service country:");
            String inServiceCountry = scanner.nextLine();


            // Create a new monkey object with validated attributes
            Monkey newMonkey = new Monkey(name, species, gender, age, weight, height, tailLength, bodyLength, acquisitionDate, acquisitionCountry,
           	trainingStatus, reserved, inServiceCountry);


            // Add the validated monkey to the monkeyList
            monkeyList.add(newMonkey);
            System.out.println("\nNew monkey added successfully!\n");
            
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid number.");
            scanner.nextInt();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage() + ". Please input valid species.");
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + ". Enter valid input.");
            scanner.next();
        }
    }


    // Method to validate species type
    private static boolean isValidSpecies(String species) {
        // Define an array or list of valid species
        String[] validSpecies = {"Capuchin", "Spider", "Howler", "Squirrel", "Tamarin", "Guenon"};

        // Convert input to lowercase for case-insensitive comparison
        String lowercaseSpecies = species.toLowerCase();

        // Check if the provided species exists in the valid species list
        for (String valid : validSpecies) {
            if (valid.toLowerCase().equals(lowercaseSpecies)) {
                return true;
            }
        }
        return false; // If not found in the list of valid species
    }
    
    // Method to reserve an animal
    public static void reserveAnimal(Scanner scanner) {
        System.out.println("Reserving an animal...");

        // Collect the desired animal type and country from the user
        boolean validAnimal = false;
        boolean validCountry = false;
        String animalType = "";
        String desiredCountry = "";

        // Validate the desired animal type (dog or monkey)
        while (!validAnimal) {
            System.out.println("Enter the desired animal type (dog/monkey):");
            animalType = scanner.nextLine();

            if (animalType.equalsIgnoreCase("dog") || animalType.equalsIgnoreCase("monkey")) {
                validAnimal = true;
            } else {
                System.out.println("\nError: Please enter either dog or monkey.\n");
            }
        }

        // Validate the desired country
        while (!validCountry) {
            System.out.println("Enter the desired country:");
            desiredCountry = scanner.nextLine();

            if (isValidCountry(desiredCountry)) {
                validCountry = true;
            } else {
                System.out.println("\nError: Invalid country. Try again.\n");
            }
        }

        // Search for and reserve an animal of the specified type in the desired country
        boolean animalFound = false;
        Object reservedAnimal = null;

        try {
            // Check if the animal type is a dog
            if (animalType.equalsIgnoreCase("dog")) {
                for (Dog dog : dogList) {
                    if (!dog.getReserved() && dog.getInServiceLocation().equalsIgnoreCase(desiredCountry)) {
                        dog.setReserved(true);
                        System.out.println("\nDog reserved successfully!\n");
                        reservedAnimal = dog;
                        animalFound = true;
                        break;
                    }
                }
            } else if (animalType.equalsIgnoreCase("monkey")) {
                // Check if the animal type is a monkey
                for (Monkey monkey : monkeyList) {
                    if (!monkey.getReserved() && monkey.getInServiceLocation().equalsIgnoreCase(desiredCountry)) {
                        monkey.setReserved(true);
                        System.out.println("\nMonkey reserved successfully!\n");
                        reservedAnimal = monkey;
                        animalFound = true;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        // Output message if no animal was found in the desired country
        if (!animalFound) {
            System.out.println("\nNo available animals of type " + animalType + " in " + desiredCountry + ".\n");
        }
    }

    
    // Method to check the validity of a country
    private static boolean isValidCountry(String country) {
        // Validate if the country is either "United States" or "Canada"
        return country.equalsIgnoreCase("United States") || country.equalsIgnoreCase("Canada");
    }

    // Method to format details of a Dog
    public static String dogDetails(Dog dog) {
        // Format Dog details into a readable string
        return "Name: " + dog.getName() + ", Breed: " + dog.getBreed() + ", Gender: " + dog.getGender() +
                ", Age: " + dog.getAge() + ", Weight: " + dog.getWeight() + "kg, Acquisition Date: " +
                dog.getAcquisitionDate() + ", Acquisition Country: " + dog.getAcquisitionLocation() +
                ", Training status: " + dog.getTrainingStatus() + ", Reserved: " + dog.getReserved();
    }

    // Method to format details of a Monkey
    public static String monkeyDetails(Monkey monkey) {
        // Format Monkey details into a readable string
        return "Name: " + monkey.getName() + ", Species: " + monkey.getSpecies() + ", Gender: " +
                monkey.getGender() + ", Age: " + monkey.getAge() + ", Weight: " + monkey.getWeight() +
                "kg" + ", Tail Length: " + monkey.getTailLength() + "cm, Height: " + monkey.getHeight() +
                "cm, Body Length: " + monkey.getBodyLength() + "cm, Acquisition Date: " +
                monkey.getAcquisitionDate() + ", Acquisition Country: " + monkey.getAcquisitionLocation() +
                " Training status: " + monkey.getTrainingStatus() + ", Reserved: " + monkey.getReserved();
    }

    // Method to print a list of dogs, monkeys, or available animals
    public static void printAnimals(String listType) {
        // Print a list based on the specified type: dog, monkey, or available animals
        if (listType.equalsIgnoreCase("dog")) {
            // Print a list of all dogs
            System.out.println("List of Dogs:");
            for (Dog dog : dogList) {
                System.out.println(dogDetails(dog));
            }
        } else if (listType.equalsIgnoreCase("monkey")) {
            // Print a list of all monkeys
            System.out.println("List of Monkeys:");
            for (Monkey monkey : monkeyList) {
                System.out.println(monkeyDetails(monkey));
            }
        } else if (listType.equalsIgnoreCase("available")) {
            // Print a list of animals that are in service and available
            System.out.println("List of Animals In Service and Available:");
            boolean foundAvailableAnimal = false;

            // Check available dogs
            for (Dog dog : dogList) {
                if (dog.getTrainingStatus().equalsIgnoreCase("in service") && !dog.getReserved()) {
                    System.out.println("Dog: \n" + dogDetails(dog));
                    System.out.println();
                    foundAvailableAnimal = true;
                }
            }

            // Check available monkeys
            for (Monkey monkey : monkeyList) {
                if (monkey.getTrainingStatus().equalsIgnoreCase("in service") && !monkey.getReserved()) {
                    System.out.println("Monkey: \n" + monkeyDetails(monkey));
                    foundAvailableAnimal = true;
                }
            }

            // Output if no available animals are found
            if (!foundAvailableAnimal) {
                System.out.println("No available animals at this time.");
            }
        }
    }
}

    
    
