package HeadFirstDesignPattern.Chapter1.Strategy.Behavior.Fly;

public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying");
    }
}
