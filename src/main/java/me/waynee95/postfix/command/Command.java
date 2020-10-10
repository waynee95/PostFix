package me.waynee95.postfix.command;

import java.util.Stack;

public abstract class Command {
    
    public abstract void run(Stack<Integer> stack);

}
