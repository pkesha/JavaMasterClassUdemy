public class Main {

    public static void main(String[] args) {
        String varFour = "this is private to main()";

        //Will refer to privateVar from the class since it's referring to the class
        ScopeCheck scopeCheck = new ScopeCheck();
        /*Outer class Will still be able to have access to private fields
        in inner classes.  Breaks encapsulation to certain extent.*/
        scopeCheck.useInner();
        System.out.println("scopeInstance varOne is "
                + scopeCheck.getVarOne());

        scopeCheck.timesTwo();
        System.out.println(" ");
        ScopeCheck.InnerClass innerClass = scopeCheck.new InnerClass();
        innerClass.timesTwo();

        // Moving away from scope and towards visibility & access
        ScopeCheck.InnerClass innerClass1 = scopeCheck.new InnerClass();

    }

}
