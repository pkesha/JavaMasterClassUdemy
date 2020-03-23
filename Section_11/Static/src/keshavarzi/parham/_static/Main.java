package keshavarzi.parham._static;

public class Main {

    public static int multiplier;

    public static void main(String[] args) {
//        /*when numInstance is not static, it will always show 1 for the # of instances
//        //Because it makes multiple copies.*/
//
//        /*But when changed to static, it will share the one copy variable
//        between all instances*/
//        StaticTest firstInstance = new StaticTest("1st Instance");
//        System.out.println(firstInstance.getName() + " is instance number " +
//                firstInstance.getNumInstances());
//
//        StaticTest secondInstance = new StaticTest("2nd instance");
//        System.out.println(secondInstance.getName() + " is instance number " +
//                secondInstance.getNumInstances());
//
//        /*Doesn't matter what instance we use, secondInstance.getNumInstances()
//        will still have access the static field.  Leaving it is bad practice*/
//        StaticTest thirdInstance = new StaticTest("3rd instance");
//        System.out.println(thirdInstance.getName() + " is instance number " +
//                secondInstance.getNumInstances());
//
//        //When using static methods in class, don't have to instantiate
//        System.out.println(StaticTest.getNumInstances());

        System.out.println(multiply(6));

    }

    public static int multiply(int number){
        return number * multiplier;
    }
}
