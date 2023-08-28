package HeadFirstDesignPattern.Chapter1.Strategy.Duck;

import HeadFirstDesignPattern.Chapter1.Strategy.Behavior.Fly.FlyWithWings;
import HeadFirstDesignPattern.Chapter1.Strategy.Behavior.Quack.Quack;

public class MallardDuck extends Duck{

    public MallardDuck(){
        super.flyBehavior = new FlyWithWings();
        super.quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("MallardDuck");
    }
}
