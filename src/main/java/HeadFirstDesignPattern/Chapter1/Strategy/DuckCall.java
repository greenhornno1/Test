package HeadFirstDesignPattern.Chapter1.Strategy;

import HeadFirstDesignPattern.Chapter1.Strategy.Duck.Duck;
import HeadFirstDesignPattern.Chapter1.Strategy.Duck.MallardDuck;

public class DuckCall {
    Duck duck;

    DuckCall(){
        this.duck = new MallardDuck();
    }

    public void call(){
        duck.performQuack();
    }

    public void setDuck(Duck duck){
        this.duck = duck;
    }
}
