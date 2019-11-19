import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        //THREE VARIABLES OF TYPE STRENGTH (MAGIC, STEALTH AND STRENGTH)

        //THREE VARIABLES THAT WILL MAKE STRENGTHS INCREASE USING MODULO

        //ONE VARIABLE OF TYPE HEALTH

        //ARRAY WITH VALUES

        //CLASSES

        //VALIDATION (if program does not receive valid input, it should not crash)

        //VARIABLES (example health points)

        //RECURSION (directional count has recursion)

        //DICE ALGORYTHM

        //NUMBER GUESSING

        //BRUTE FORCE?

        //FUNCTIONAL MARRIAGE / UNHAPPY ENDING

        //CARD / DECK


        /* GAME PROGRESSION (oblivion):
        Character creation
            Star sign
            Race
            Class?
        Begin journey from prison
            Escape through the secret exit opened by the emperor
            Receive Amulet of Kings from the Emperor
            Make Amulet of Kings with ARCII art
        Make choices in Cyrodil
            Return the Amulet of Kings
            Join the Dark Brotherhood
            Join Mages Guild




         */

        // Character[] characters = new Character[10];

        // INITIATING ALL CHARACTERS
        Character you = new Character("TEMP", 20, 20, 20);
        Character assassin = new Character("Assassin", 100, 20, 1, 1, 2);
        Character guard = new Character ("Guard", 100, 20, 2, 1, 1);

        Scanner scanner = new Scanner(System.in);
        Storyline storyline = new Storyline();

        // FIRST PART OF THE STORY
        storyline.partOne();


        // SELECTING YOUR CHARACTERS NAME
        System.out.println("\nPick a name for your character: ");
        you.setName(scanner.nextLine());

        // INITIATING CHARACTER AND CREATING THE LOOP THAT CONSTANTLY CHECKS IF YOU'RE HEALTH IS MORE THAN 0
        while (you.isAlive()) {

            System.out.println("\n\t- ''" + you.getName() + ".. Ahh yes, I see now.. My time must be short." +
                    " Which stars were showing on the day of your birth, " + you.getName() + "?'' asks the emperor.");

            // PICKING A STARSIGN THAT DETERMINES YOUR STRENGTHS
            you.pickStarsign();

            // SECOND PART OF THE STORY
            System.out.println("The emperor and his body guards open a secret exit in your cell.");
            System.out.println("\n\t- ''It's your lucky day'' one of the guards says.");
            System.out.println("\nThe exit seems to lead to an underground sewer system.");
            System.out.println("\nSuddenly your party");


            System.out.println("\tSKIPPING THE STORY A BIT TO TRY THE COMBAT.\n");
            System.out.println("THE EMPEROR HAS BEEN KILLED.\n");
            System.out.println("The assassin now focuses on you. The assassin starts to attack.\n");
            while (assassin.isAlive()) {
                System.out.println("\n\tPick your next action?" +
                        "\n\t\t(1) Attack with destruction magic" +
                        "\n\t\t(2) Attack with stealth" +
                        "\n\t\t(3) Attack with physical strength" +
                        "\n");
                you.pickAction(assassin);
                assassin.attack(you);
            }

            System.out.print("A guard sees you and starts to attack because of your dangerous reputation");

            while (guard.isAlive()) {
                System.out.println("\n\tPick your next action?" +
                        "\n\t\t(1) Attack with destruction magic" +
                        "\n\t\t(2) Attack with stealth" +
                        "\n\t\t(3) Attack with physical strength" +
                        "\n");
                you.pickAction(guard);
                guard.attack(you);
            }
        }
    }
}
