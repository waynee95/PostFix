package me.waynee95.postfix.command;

import java.util.Stack;

public class PopCommand extends Command {

    @Override
    public void run(Stack<Integer> stack) {
        stack.pop();
    }

}
