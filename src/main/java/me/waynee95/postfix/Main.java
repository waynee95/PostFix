package me.waynee95.postfix;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in)) {
            System.out.println("=== PostFix Interpreter ===");

            Interpreter interpreter = new Interpreter();
            while (in.hasNextLine()) {

                String p = in.nextLine();
                if ("".equals(p)) {
                    throw new Error("Not a valid PostFix program!");
                }

                System.out.print("Arguments: ");
                String[] params = in.nextLine().split(" ");

                int result = interpreter.interpret(p, params);
                System.out.println("Result: " + result);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
