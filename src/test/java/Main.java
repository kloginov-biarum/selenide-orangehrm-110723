import java.util.*;

import static java.util.Collections.reverseOrder;
import static java.util.Collections.sort;

public class Main {

    public static void main(String[] args) {
        List<String> firstList = new LinkedList<>();
        firstList.add("Apple");
        firstList.add("Pear");
        firstList.add("Watermelon");
        firstList.add("Apple");
        System.out.println(firstList);
        Collections.sort(firstList, reverseOrder());
        System.out.println(firstList);

        String longestString = firstList.get(0);
        for (String el: firstList) {
            if (el.length()>longestString.length()){
                longestString = el;
            }
        }
        System.out.println(longestString);

    }
}
