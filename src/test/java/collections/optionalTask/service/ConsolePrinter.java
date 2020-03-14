package collections.optionalTask.service;

import java.util.Collection;
import java.util.Stack;

public class ConsolePrinter {
    public void printReversedNumberToConsole(Stack<Character> numerals){
        while(!numerals.empty()){
            System.out.print(numerals.pop());
        }
    }

    public void print(Collection<String> strings){
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
