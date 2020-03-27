package com.keshavarziparham;

import java.util.HashMap;
import java.util.Map;

public class MapProgram {
    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();

        if(languages.containsKey("Java")) System.out.println("Java is already in the map");
        else {
            languages.put("Java", "a compiled high level, object-oriented, platform independent language");
            System.out.println("java added successfully");
        }

        languages.put("Java", "a compiled high level, object-oriented, platform independent " +
                "language");
        languages.put("Python", "an interpreted, object-oriented, high-level programming language with dynamic " +
                "semantics");
        languages.put("Algol", "an algorithmic language");

        //Print's previous Key's value - this will show null because it's new
        System.out.println(languages.put("BASIC", "Beginners All purpose symbolic instruction code"));
        System.out.println(languages.put("Lisp", "Therein lies madness"));

        //System.out.println(languages.get("Java"));

        //Way to make sure your only adding when Java is not being used, instead of above
        if(languages.containsKey("Java")) System.out.println("Java is already in the map");
        else languages.put("Java", "this course is about Java");

        /*//The key's value is overwritten
        languages.put("Java", "this course is about Java");
        System.out.println(languages.get("Java"));*/

        System.out.println("-------------------------");
        languages.remove("Lisp");

        //While the key exists, if the value is not the same, it will not be removed.
        if(languages.remove("Algol", "a family of algorithmic languages")){
            System.out.println("Algol removed");
        } else {
            System.out.println("Algol not removed, key/value pair not found");
        }

        if (languages.replace("Lisp", "Therein lies madness",
                "a functional programming language with imperative features")){
            System.out.println("Lisp replaced");
        } else{
            System.out.println("Lisp not replaced");
        }

        //System.out.println(languages.replace("Scalar", "this will not be added"));

        //Cycles through the map
        for (String key: languages.keySet()){
            System.out.println(key + " : " + languages.get(key));
        }

    }
}
