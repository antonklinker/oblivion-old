public class Methods {



    public static int rollDie() {
        int die = 1 + (int) (Math.random() * 6);
        return die;
    }

    public static int rollDice() {
        int dice = rollDie() + rollDie();
        System.out.println(dice);
        return dice;
    }


}
