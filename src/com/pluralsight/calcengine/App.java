package com.pluralsight.calcengine;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // double value1 = 100.0d;
        // double value2 = 50.0d;
        // double result = 0.0d;
        // char opCode = 'd';

        double[] leftVals = {100.0d, 25.0d, 225.0d, 11.0d};
        double[] rightVals = {50.0d, 92.0d, 17.0d, 3.0d};
        char[] opCodes = {'a', 's', 'm', 'd'};
        double[] results = new double[opCodes.length];

        // if (opCode == 'a')
        //     result = value1 + value2;
        // else if (opCode == 's')
        //     result = value1 - value2;
        // else if (opCode == 'm')
        //     result = value1 * value2;
        // else if (opCode == 'd')
        //     result = value1 / value2;
        // else {
        //     System.out.println("Invalid opCode: " + opCode);
        //     result = 0.0d;
        // }

        String s1 = "Java";
        System.out.println(s1.startsWith("J", 1));

        if(args.length == 0) {
            for(int i = 0; i < opCodes.length; i++) {
                results[i] = execute(opCodes[i], leftVals[i], rightVals[i]);
            }

        // switch(opCode) {
        //     case 'a':
        //         result = value1 + value2;
        //         break;
        //     case 's':
        //         result = value1 - value2;
        //         break;
        //     case 'm':
        //         result = value1 * value2;
        //         break;
        //     case 'd':
        //         result = value2 != 0 ?value1 / value2 : 0.0d;
        //         break;
        //     default:
        //         System.out.println("Invalid opCode: " + opCode);
        //         result = 0.0d;
        // }

        for(double result : results)
            System.out.println("result: " + result);
        } else if(args.length == 1 && args[0].equals("interactive"))
            executeInteractively();
        else if(args.length == 3)
            handleCommandLine(args);
        else
            System.out.println("Please provide an operation code and 2 numeric values");

        for(int i = 1; i < 100; i *= 2)
            System.out.println(i);
    }

    static void executeInteractively() {
        System.out.println("Enter an operation and two numbers");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] parts = userInput.split(" ");
        performOperation(parts);
    }

    private static void performOperation(String[] parts) {
        char opCode = opCodeFromString(parts[0]);
        double leftVal = valueFromWord(parts[1]);
        double rightVal = valueFromWord(parts[2]);
        double result = execute(opCode, leftVal, rightVal);
        System.out.println(result);
    }

    private static void handleCommandLine(String[] args) {
        char opCode = args[0].charAt(0);
        double leftVal = Double.parseDouble(args[1]);
        double rightVal = Double.parseDouble(args[2]);
        double result = execute(opCode, leftVal, rightVal);
        System.out.println(result);
    }

    static double execute(char opCode, double leftVal, double rightVal) {
        double result;
        switch (opCode) {
                case 'a':
                    result = leftVal + rightVal;
                    break;
                case 's':
                    result = leftVal - rightVal;
                    break;
                case 'm':
                    result = leftVal * rightVal;
                    break;
                case 'd':
                    result = leftVal / rightVal;
                    break;
                default:
                    System.out.println("Invalid opCode: " + opCode);
                    result = 0.0d;
                    break;
        }
        return result;
    }

    static char opCodeFromString(String operationName) {
        char opCode = operationName.charAt(0);
        return opCode;
    }

    static double valueFromWord(String word) {
        String[] numberWords = {
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
        };
        double value = 0d;
        for(int index = 0; index < numberWords.length; index++) {
            if(word.equals(numberWords[index])) {
                value = index;
                break;
            }
        }
        return value;
    }
}
