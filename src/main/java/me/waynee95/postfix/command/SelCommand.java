package me.waynee95.postfix.command;

import java.util.Stack;

public class SelCommand extends Command {

    @Override
    public void run(Stack<Integer> stack) {
        int v1 = stack.pop();
        int v2 = stack.pop();
        int v3 = stack.pop();
        if (v3 == 0) {
            stack.push(v1);
        } else {
            stack.push(v2);
        }
    }

}
