package me.waynee95.postfix.command;

import java.util.Stack;

public class EqCommand extends Command {

    @Override
    public void run(Stack<Integer> stack) {
        int v1 = stack.pop();
        int v2 = stack.pop();
        stack.push(v2 == v1 ? 1 : 0);
    }

}
