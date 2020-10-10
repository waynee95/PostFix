package me.waynee95.postfix;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Stack;

import me.waynee95.postfix.command.AddCommand;
import me.waynee95.postfix.command.Command;
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

    private HashMap<String, Command> commands;

    public Interpreter() {
        commands = new HashMap<>();
        commands.put("add", new AddCommand());
        commands.put("sub", new SubCommand());
        commands.put("mul", new MulCommand());
        commands.put("div", new DivCommand());
        commands.put("rem", new RemCommand());
        commands.put("gt", new GTCommand());
        commands.put("lt", new LTCommand());
        commands.put("eq", new EqCommand());
        commands.put("pop", new PopCommand());
        commands.put("sel", new SelCommand());
        commands.put("nget", new NGetCommand());
        commands.put("swap", new SwapCommand());
    }

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
            } else {
                Command command = commands.get(token.id);
                if (command != null) {
                    command.run(stack);
                }
            }
            token = lexer.nextToken();
        }

        return stack.peek();

    }

}
