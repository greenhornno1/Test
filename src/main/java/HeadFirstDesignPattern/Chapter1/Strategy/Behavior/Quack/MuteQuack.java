package HeadFirstDesignPattern.Chapter1.Strategy.Behavior.Quack;

public class MuteQuack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("<<Silence>>");
    }
}
