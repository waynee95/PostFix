package me.waynee95.postfix.command;

import java.util.Stack;

public class NGetCommand extends Command {

    @Override
    public void run(Stack<Integer> stack) {
        int i = stack.pop();
        stack.push(stack.get(i));
    }

}
