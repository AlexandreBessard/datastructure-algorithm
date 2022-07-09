package crackingTheCodingInterview.chapter7ObjectOrientedDesign.designPattern;

/*
The Factory Method offers an interface for creating an instance of a class, with its subclasses deciding
which class to instantiate. You might want to implement this with the creator class being abstract and not
providing an implementation for the Factory method. Or, you could have the Creator class be a concrete
class that provides an implementation for the Factory method. In this case, the Factory method would take
a parameter representing which class to instantiate.
 */
public class FactoryMethod {

    static class CardGame {
        public static CardGame createCardGame(GameType type) {
            if(type == GameType.Poker) {
                return new PokerGame();
            } else if(type == GameType.BlackJack) {
                return new BlackJackGame();
            }
            return null;
        }
    }
    enum GameType {
        Poker, BlackJack;
    }
    static class PokerGame extends CardGame {}
    static class BlackJackGame extends CardGame {}
}
