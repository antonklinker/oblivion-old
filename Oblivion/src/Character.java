import java.util.Scanner;
public class Character {
    Scanner scanner = new Scanner(System.in);

    private int starsign=0;

    // This is used in the pickAction void
    private int pickAttack=0;

    // Determines the strength of each attribute
    private int magicStrength;
    private int stealthStrength;
    private int strengthStrength;

    // Determines if your strength should increase
    private int magicProg;
    private int stealthProg;
    private int strengthProg;

    // Determines how much damage you will give and receive
    private int damage;

    // Your standard health points
    private int health=100;

    // Resistance to schools of attack
    private int fResistance;
    private int mResistance;
    private int sResistance;

    private String name;

    public String getName() { return name; }

    public void setName(String name) { this.name=name;}


    Character (String name, int magicStrength, int stealthStrength, int strengthStrength) {
        this.name=name;
        this.magicStrength=magicStrength;
        this.stealthStrength=stealthStrength;
        this.strengthStrength=strengthStrength;

    }

    Character (String name, int health, int strength, int fRestistance, int mRestistance, int sResistance) {
        this.name=name;
        this.strengthStrength=strength;
        this.health=health;

        this.fResistance=fRestistance;
        this.mResistance=mRestistance;
        this.sResistance=sResistance;

    }

    public void pickAction(Character other) {

        pickAttack = scanner.nextInt();

        if (pickAttack == 1) {
            // MAGIC
            damage = (int) (Math.random() * magicStrength);
            other.health-=damage/other.mResistance;

            if (other.mResistance>1) {
                System.out.println("\t\tYour opponent is resistant to that type of damage!\n");
            }

            System.out.println(name + " hits " + other.name + " for " + damage + " damage. " + other.name + " now has " +
                    + other.health + " health left.");

            // Every time a type of attack has been used three times, that type will be stronger
            magicProg++;
            if (magicProg % 3 == 0) {
                magicStrength = magicStrength + 1 + (int) (Math.random() * 3);
                System.out.println("\tYour skills in the mystic arts has grown. You know have " + magicStrength + " points in the destruction tree.");
            }
        }
        else if (pickAttack==2) {
            // STEALTH
            damage = (int) (Math.random() * stealthStrength);
            other.health-=damage/other.sResistance;

            if (other.sResistance>1) {
                System.out.println("\t\tYour opponent is resistant to that type of damage!\n");
            }

            System.out.println(name + " hits " + other.name + " for " + (damage/other.sResistance) + " damage. " + other.name + " now has " +
                    + other.health + " health left.");

            // Every time a type of attack has been used three times, that type will be stronger
            stealthProg++;
            if (stealthProg%3==0) {
                stealthStrength=stealthStrength + 1 + (int) (Math.random() * 3);
                System.out.println("\tYour ability to remain unseen has grown. You know have " + stealthStrength + " points in the stealth tree.");
            }

        }
        else if (pickAttack==3) {
            // STRENGTH
            damage = (int) (Math.random() * strengthStrength);
            other.health-=damage/other.fResistance;

            if (other.fResistance>1) {
                System.out.println("\t\tYour opponent is resistant to that type of damage!\n");
            }

            System.out.println(name + " hits " + other.name + " for " + damage + " damage. " + other.name + " now has " +
                    + other.health + " health left.");

            // Every time a type of attack has been used three times, that type will be stronger
            strengthProg++;
            if (strengthProg%3==0) {
                strengthStrength=strengthStrength + 1 + (int) (Math.random() * 3);
                System.out.println("\tYour strength and brute force has grown. You know have " + strengthStrength + " points in physical strength.");
            }

        }


    }

    public void attack(Character other) {
        damage = (int) (Math.random() * strengthStrength);
        if (damage<strengthStrength/2) damage=strengthStrength/2;
        other.health-=damage;

        System.out.println(name + " hits " + other.name + " for " + damage + " damage. " + other.name + " now has " +
                + other.health + " health left.");

    }


    public void pickStarsign() {
        while(starsign==0) {
            System.out.println("\nPick a starsign.");
            System.out.println("\t(1) Magician");
            System.out.println("\t(2) Assassin");
            System.out.println("\t(3) Fighter");
            if (!scanner.hasNextInt()) {
                System.out.println("That was not one of options you were given. Try again.");
                return;
            }
            starsign = scanner.nextInt();
            if (starsign == 1) {
                magicStrength = 35;
            } else if (starsign == 2) {
                stealthStrength = 35;
            } else if (starsign == 3) {
                strengthStrength = 35;
            } else {
                System.out.println("That was not one of options you were given. Try again.");
                starsign=0;
            }
        }

    }

    public boolean isAlive() {
        if (health>0)  return true;
        else return false;
    }
}
