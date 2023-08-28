package HeadFirstDesignPattern.Chapter1.Strategy;

public class MiniDuckSimulator {

    public static void main(String[] args){
//        Duck testDuck = new MallardDuck();
//        testDuck.performFly();
//        testDuck.performQuack();

        DuckCall testDuckCall = new DuckCall();
        testDuckCall.call();
    }
}
