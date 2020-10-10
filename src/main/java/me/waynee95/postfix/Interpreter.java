package me.waynee95.postfix;

import java.io.StringReader;
import java.util.Stack;

import me.waynee95.postfix.command.AddCommand;
import me.waynee95.postfix.command.DivCommand;
import me.waynee95.postfix.command.EqCommand;
import me.waynee95.postfix.command.GTCommand;
import me.waynee95.postfix.command.LTCommand;
import me.waynee95.postfix.command.MulCommand;
import me.waynee95.postfix.command.NGetCommand;
import me.waynee95.postfix.command.PopCommand;
import me.waynee95.postfix.command.RemCommand;
import me.waynee95.postfix.command.SelCommand;
import me.waynee95.postfix.command.SubCommand;
import me.waynee95.postfix.command.SwapCommand;
import me.waynee95.postfix.lex.Lexer;
import me.waynee95.postfix.lex.Token;

public class Interpreter {

    public int interpret(String p, String[] params) throws Exception {
        Stack<Integer> stack = new Stack<>();

        // End marker
        stack.push(-1);

        StringReader reader = new StringReader(p);
        Lexer lexer = new Lexer(reader);

        Token token = lexer.nextToken();
        if (token.id != "(") {
            throw new Error("Missing (");
        }

        token = lexer.nextToken();
        if (token.id != "postfix") {
            throw new Error("Not a valid PostFix program!");
        }

        token = lexer.nextToken();
        if (token.id != "int") {
            throw new Error("Missing args number!");
        }

        int argsNum = Integer.parseInt(token.value);
        if (!"".equals(params[0]) && argsNum != params.length) {
            throw new Error("Wrong number of parameters!");
        }

        for (int i = argsNum - 1; i >= 0; i--) {
            stack.push(Integer.parseInt(params[i]));
        }

        System.out.println("Initial stack: " + stack);

        token = lexer.nextToken();
        while (token != null) {
            if (token.id == "int") {
                stack.push(Integer.parseInt(token.value));
            } else if (token.id == "add") {
                new AddCommand().run(stack);
            } else if (token.id == "sub") {
                new SubCommand().run(stack);
            } else if (token.id == "mul") {
                new MulCommand().run(stack);
            } else if (token.id == "div") {
                new DivCommand().run(stack);
            } else if (token.id == "rem") {
                new RemCommand().run(stack);
            } else if (token.id == "gt") {
                new GTCommand().run(stack);
            } else if (token.id == "eq") {
                new EqCommand().run(stack);
            } else if (token.id == "lt") {
                new LTCommand().run(stack);
            } else if (token.id == "pop") {
                new PopCommand().run(stack);
            } else if (token.id == "sel") {
                new SelCommand().run(stack);
            } else if (token.id == "swap") {
                new SwapCommand().run(stack);
            } else if (token.id == "nget") {
                new NGetCommand().run(stack);
            }
            token = lexer.nextToken();
        }

        return stack.peek();

    }

}
