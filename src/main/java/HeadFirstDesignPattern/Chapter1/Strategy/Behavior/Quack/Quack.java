package HeadFirstDesignPattern.Chapter1.Strategy.Behavior.Quack;

public class Quack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("Quack");
    }
}
