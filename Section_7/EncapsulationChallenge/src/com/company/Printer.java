package com.company;

public class Printer {
    private int tonerLevel;
    private int numberOfPagesPrinted;
    private boolean isDuplexPrinter;

    private int fillToner(int tonerPercentage){
        this.tonerLevel = ((this.tonerLevel + tonerPercentage) >= 100) ? 100 :
                this.tonerLevel + tonerPercentage;
        System.out.println("Toner level" + tonerPercentage);
        return this.tonerLevel;
    }

    public Printer(int tonerLevel, boolean isDuplexPrinter) {
        //Making sure levels fall between 0 and 100 percent
        this.tonerLevel = (tonerLevel < 0) ? 0 : tonerLevel;
        this.tonerLevel = (this.tonerLevel >= 100) ? 100: this.tonerLevel;

        this.numberOfPagesPrinted = 0;
        this.isDuplexPrinter = isDuplexPrinter;
    }

    private int useToner(int tonerPercentage){
        this.tonerLevel = ((this.tonerLevel - tonerPercentage) <= 0) ? 0 :
                this.tonerLevel - tonerPercentage;
        System.out.println("Toner level" + tonerPercentage);
        return this.tonerLevel;
    }

    private int pagesPrinted(int numberOfPagesPrinted){
        return this.numberOfPagesPrinted = (this.isDuplexPrinter) ?
                this.numberOfPagesPrinted + ((numberOfPagesPrinted / 2) + (numberOfPagesPrinted % 2)) :
                this.numberOfPagesPrinted + (numberOfPagesPrinted);
    }

    public int getTonerLevel() {
        return tonerLevel;
    }

    public int getNumberOfPagesPrinted() {
        return numberOfPagesPrinted;
    }

    public boolean isDuplexPrinter() {
        return isDuplexPrinter;
    }

    private void setDuplexPrinter(boolean isDuplexPrinter){
        this.isDuplexPrinter = isDuplexPrinter;
    }
}
