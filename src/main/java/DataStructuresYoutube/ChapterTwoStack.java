package DataStructuresYoutube;

import java.util.Stack;

public class ChapterTwoStack {

    public static void main(String[] args){
        Stack<String> stack = new Stack<>();

        stack.push("Game1");
        stack.push("Game2");
        stack.push("Game3");
        stack.push("Game4");
        stack.push("Game5");

        stack.add("Game10");

        stack.pop();
        stack.pop();

        System.out.println(stack);

        String gameName = stack.pop();



    }
}
