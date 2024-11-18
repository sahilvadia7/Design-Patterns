package creational_patterns.singleton_method;
class Phone{

    //step 1: private static variable for single instance
    private static Phone phone;

    //private phoneName variable
    private String phoneName;

    //step 2: Make constructor private to prevent instantiation.
    private Phone(String phoneName){
        this.phoneName = phoneName;
    }

    // Step 3: Provide a public static method to get the instance
    public static Phone getInstance(String phoneName){

        if(phone == null){
            phone = new Phone(phoneName);
        }
        return phone;
    }

    // Getter for the phone name
    public String getPhoneName() {
        return phoneName;
    }

}


public class SingletonMethod {
    public static void main(String[] args) {
       // Get the first instance of Phone
       Phone phone1 = Phone.getInstance("Galaxy S24");

       // Get another instance of Phone
       Phone phone2 = Phone.getInstance("iPhone 15");

       // Print the phone names to verify they are the same
       System.out.println("Phone 1 Name: " + phone1.getPhoneName());
       System.out.println("Phone 2 Name: " + phone2.getPhoneName());

       // Compare the memory addresses of both objects
       System.out.println("Are both instances the same? " + (phone1 == phone2));
       System.out.println("Phone 1 Address: " + System.identityHashCode(phone1));
       System.out.println("Phone 2 Address: " + System.identityHashCode(phone2));
    }
}


// Explanation
// When you call Phone.getInstance("Galaxy S23"), the Singleton instance is created with the name "Galaxy S23".
// When you call Phone.getInstance("iPhone 15"), it returns the existing instance rather than creating a new one. The name remains "Galaxy S23".
// The memory addresses of phone1 and phone2 are the same (System.identityHashCode), confirming they are the same object.





