package HeadFirstDesignPattern.Chapter1.Strategy.Duck;

import HeadFirstDesignPattern.Chapter1.Strategy.Behavior.Fly.FlyBehavior;
import HeadFirstDesignPattern.Chapter1.Strategy.Behavior.Quack.QuackBehavior;

public abstract class Duck {

    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck(){}

    public void performFly(){
        flyBehavior.fly();
    };

    public void performQuack(){
        quackBehavior.quack();
    };

    public void swim(){
        System.out.println("All ducks float, even decoys!");
    };

    public abstract void display();
}
