package com.parhamkeshavarzi;

public class StringUtilities {
    private StringBuilder sBuilder = new StringBuilder();
    private int charsAdded = 0;

    public void addChar(StringBuilder sBuilder, char c){
        //this.sBuilder is being appended, not the one from main class - remove 'this'
        sBuilder.append(c);
        charsAdded++;
    }

    public String upperAndPrefix(String str){
        String upper = str.toUpperCase();
        return "Prefix_" + upper;
    }

    public String addSuffix(String str){
        return str + "__Suffix";
    }
}
