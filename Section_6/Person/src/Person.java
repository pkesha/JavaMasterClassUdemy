public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setAge (int age){
        this.age =  ( (age > 0) && (age < 101)) ? age : 0;
    }

    public int getAge(){
        return age;
    }

    public boolean isTeen(){
        return ((age > 12) && (age < 20)) ? true : false;
    }

    public String getFullName(){
        if (this.firstName.isEmpty() && this.lastName.isEmpty()){
            return "";
        } else if (this.lastName.isEmpty()){
            return firstName;
        } else if (this.firstName.isEmpty()){
            return lastName;
        } else{
            return this.firstName + " " + this.lastName;
        }
    }
}
