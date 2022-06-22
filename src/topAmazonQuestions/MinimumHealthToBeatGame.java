package topAmazonQuestions;

//https://leetcode.com/problems/minimum-health-to-beat-game/
public class MinimumHealthToBeatGame {

    public static void main(String[] args) {
        int[] damage = {2,7,4,3};
        int armor = 10;
        var obj = new MinimumHealthToBeatGame();
        System.out.println(obj.minimumHealth(damage, armor));
    }

    public long minimumHealth(int[] damage, int armor) {
        int max = 0;
        long health = 1;
        for(int i = 0; i < damage.length; i++) {
            health += damage[i];
            max = Math.max(damage[i], max);
        }
        health -= Math.min(armor, max);
        return health;
    }


}
