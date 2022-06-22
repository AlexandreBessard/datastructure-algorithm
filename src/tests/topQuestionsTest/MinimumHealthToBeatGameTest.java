package tests.topQuestionsTest;

public class MinimumHealthToBeatGameTest {

    public static void main(String[] args) {
        int[] damage = {2,7,4,3};
        int armor = 4;
        var obj = new MinimumHealthToBeatGameTest();
        System.out.println(obj.minimumHealth(damage, armor));
    }

    public int minimumHealth(int[] damage, int armor) {
        if(damage == null || damage.length == 0) return -1;
        int health = 1;
        int max = 0;
        for(int d : damage) {
            health += d;
            max = Math.max(max, d);
        }
        health -= Math.min(max, armor);
        return health;
    }
}
