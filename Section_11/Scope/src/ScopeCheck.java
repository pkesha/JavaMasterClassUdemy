public class ScopeCheck {
    public int publicVar = 0;
    private int varOne = 1;

    public ScopeCheck(){
        System.out.println(
                "ScopeCheck created, publicVar = " + this.publicVar
                        + ": privateVar = " + this.varOne
        );
    }

    public int getVarOne(){
        return this.varOne;
    }

    public void timesTwo(){
        //Will use local privateVar and not the field of the class
        int varTwo = 2;
        for (int i = 0; i < 10; i++){
            System.out.println(i + " times two is " + (i * varTwo));
        }
    }

    public void useInner() {
        InnerClass innerClass = new InnerClass();
        System.out.println("varThree from outer class: " + innerClass.varThree);
    }

    public class InnerClass{
        private int varThree = 3;

        public InnerClass() {
            System.out.println("InnerClass created, " +
                    "varOne is " + varOne +
                    "varThree is " + this.varThree);
        }

        public void timesTwo(){
            //Will use local privateVar and not the field of the class
            //Has been changed to ScopeCheck.this.privateVar to refer to outer scope
            //int privateVar = 2;
            System.out.println("varOne is still available here " + varOne);
            for (int i = 0; i < 10; i++){
                System.out.println(i + " times two is " + (i *
                        this.varThree));
            }
            //Will use outer class to run a method within the inner class
            ScopeCheck.this.timesTwo();
        }
    }
}


