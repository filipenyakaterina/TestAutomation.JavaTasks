package collections.optionalTask.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class Converter {
    public List<String> reverseList(List<String> list){
        Collections.reverse(list);
        return list;
    }

    public Stack<Character> convertFromStringToStack(String numberInString){
        Stack<Character> numerals = new Stack<>();
        for (char numeral : numberInString.toCharArray()){
            numerals.push(numeral);
        }
        return numerals;
    }

    public List<String> sortByLineLength(List<String> linesList){
        linesList.sort(Comparator.comparingInt(String::length));
        return linesList;
    }

}
