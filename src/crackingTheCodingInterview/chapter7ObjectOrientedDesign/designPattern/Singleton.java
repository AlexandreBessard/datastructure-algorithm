package crackingTheCodingInterview.chapter7ObjectOrientedDesign.designPattern;

public class Singleton {

    /*
    The Singleton pattern ensures that a class has only one instance and ensures access to the instance through
the application. It can be useful in cases where you have a "global" object with exactly one instance. For
example, we may want to implement R estaurant such that it has exactly one instance of Restaurant
     */
    static class Restaurant {
        private static Restaurant instance = null;
        protected Restaurant() {}
        public static Restaurant getInstance() {
            if(instance == null) {
                instance = new Restaurant();
            }
            return instance;
        }
    }

}
