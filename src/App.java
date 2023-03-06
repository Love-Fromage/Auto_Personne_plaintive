import java.util.Random;
import java.util.Scanner;

public class App {
    
    private static int sexNumber;

    public static void main(String[] args) {

        System.out.println("Welcome to the complainer generator");
        String firstName ="";
        String sex = ChooseSex();

        if(sexNumber == 0){
             firstName =  GenerateFirstNameM();
        } else if(sexNumber == 1){
             firstName = GenerateFirstNameF();
        }

        String lastName = ChooseLastName();
        String complaint = ChooseComplaint();

        GeneratePerson(sex, firstName, lastName, complaint);
    }

    public static String ChooseSex() {
        Random random = new Random();

        int selection = random.nextInt(2);
        sexNumber = selection; 

        switch (selection) {
            case 0:
                return "Male 👨‍🦱";
            case 1:
                return "Female 👩‍🦰";
            default:
                return ChooseSex();
        }
    }

    
    public static String GenerateFirstNameM(){
        Random random = new Random();
        int index = random.nextInt(10);

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

    public static String GenerateFirstNameF(){
        Random random = new Random();
        int index = random.nextInt(10);

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

    public static String ChooseLastName() {
        Random random = new Random();
        int index = random.nextInt(10);

        String[] lastNames = {
            "Tremblay",
            "Desjardins",
            "Dubois",
            "Gagnon",
            "Belanger",
            "Leblanc",
            "Dupont",
            "Fortin",
            "Lefebre",
            "Beaudoin",
        };

        return lastNames[index];
    }

    public static String ChooseComplaint() {
        Random random = new Random();
        int index = random.nextInt(10);

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
        return complaints[index];
    }

    public static void GeneratePerson(String sex, String firstName, String lastName, String complaint) {
        Person person = new Person(sex, firstName, lastName, complaint);


        // on clear la console pour faire un truc plus clean dans le programme
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("* * * * * * * * * * * * * * * * * * * * * \n");
        System.out.println("Here is your Generated person complainer:\n");
        System.out.println(person.firstName + " " + person.lastName + ", " + person.sex + " said :");
        System.out.println(person.complaint);
        System.out.println("\n* * * * * * * * * * * * * * * * * * * * *\n");
    }
}
