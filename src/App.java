import java.util.Random;
import java.util.Scanner;

public class App {
    
    private static int sexNumber;

    public static void main(String[] args) {
        // initialiasation d'un scanner pour lire des inputs dans le programme
        Scanner scanner = new Scanner(System.in);

        // System.out.println("Welcome to the complainer generator");
        // String sex = ChooseSex(scanner);
        // String firstName = ChooseFirstName(sexNumber);
        // String lastName = ChooseLastName(scanner);
        // String complaint = ChooseComplaint(scanner);
        // GeneratePerson(sex, firstName, lastName, complaint);

        scanner.close();
    }

    public static String ChooseSex(Scanner scanner) {

        Random random = new Random();

        int selection = random.nextInt(1);
        sexNumber = selection; 
        // scanner.nextLine(); // ici on viens "annuler le enter Enter sinon ca bug dans
        // le choose name tantot"

        switch (selection) {
            case 0:
                return "Male 👨‍🦱";
            case 1:
                return "Female 👩‍🦰";
            default:
                // System.out.println("Please choose between the two values");
                return ChooseSex(scanner);
        }
    }

    public static String ChooseFirstName(int sex) {
        // System.out.print("Please choose a first name : ");
        Random random = new Random();
        int nameNumber = random.nextInt(10);
        if(sex == 0){
            //c'est des noms masculins
            return GenerateFirstNameM(nameNumber);
        } else if(sex == 1){
            //c'est des noms Feminins
            return GenerateFirstNameF(nameNumber);
        }
    }
    
    public static String GenerateFirstNameM(int index){
           String[] nomsGars = {
            "Mathieu",
            "David",
            "Chu",
            "Orlando",
            "Virgil",
            "Pier-Olivier",
            "Sam",
            "Yassine",
            "Yousaif",
            "Jean-Guy",
           }; 
           return nomsGars[index];
           

    }

    public static String GenerateFirstNameF(int index){

           String[] nomsFilles = {
            "Laura",
            "Audrey",
            "Alexia",
            "Marie",
            "Sarah",
            "Channel",
            "Camille",
            "Roxanne",
            "Isabelle",
            "Christine",
           }; 
           return nomsFilles[index];
    }

    public static String ChooseLastName(Scanner scanner) {
        System.out.println("Would you like to choose a last name?");
        System.out.println("[0] : Yes");
        System.out.println("[1] : No");

        int selection = scanner.nextInt();
        scanner.nextLine();

        if (selection == 0) {
            System.out.print("Please choose a last name : ");
            return scanner.nextLine();
        }

        return "";
    }

    public static String ChooseComplaint(Scanner scanner) {
        System.out.println("Please enter a number between 1 and 10 to choose a complaint.");
        System.out.println("Your answer : ");

        int complaintChosen = scanner.nextInt();
        scanner.nextLine();

        if (complaintChosen > 10 || complaintChosen < 1) {
            System.out.println("Please choose between number 1 and 10.");

            return ChooseComplaint(scanner);
        }

        String[] complaints = {
                "The font choice in this ad is incredibly dull and uninteresting.",
                "This ad lacks any kind of creativity and is completely forgettable.",
                "The color scheme is so boring and uninspired, it's hard to even look at.",
                "The layout is so basic and unimaginative, it feels like the designer didn't even try",
                "The imagery used in this ad is so cliche and overdone, it's almost painful.",
                "The text is so small and hard to read, I have no idea what this ad is even trying to say.",
                "The design is so unremarkable, I can't even remember what brand this ad was for.",
                "The ad is so cluttered and disorganized, it's difficult to know where to focus.",
                "The design is so generic and unoriginal, it's like the designer copied and pasted from a stock image website.",
                "The overall design of this ad is so bland and unappealing, I wouldn't even consider buying the product.",
        };
        return complaints[complaintChosen - 1];
    }

    public static void GeneratePerson(String sex, String firstName, String lastName, String complaint) {
        Person person = new Person(sex, firstName, lastName, complaint);

        if (person.lastName != "") {
            person.firstName += " ";
        }

        // on clear la console pour faire un truc plus clean dans le programme
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("Given the prior prompt, this is your new complaint generated card:\n");
        System.out.println(person.firstName + person.lastName + ", " + person.sex + " said :");
        System.out.println(person.complaint + "\n\n");
    }
}
