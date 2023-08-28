package HeadFirstDesignPattern.Chapter1.Strategy.Behavior.Fly;

public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I can't fly");
    }
}
