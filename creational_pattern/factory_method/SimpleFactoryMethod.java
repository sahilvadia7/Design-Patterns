package creational_pattern.factory_method;

import java.util.Scanner;

/**
 * SmartPhone
 */
interface SmartPhone {

    void displayInfo();
    
}

class Iphone implements SmartPhone{

    public void displayInfo(){
        System.out.println("This is an iPhone.");
    }
}

class Samsung implements SmartPhone{

    public void displayInfo(){
        System.out.println("This is an Samsung.");
    }
}

class GooglePixel implements SmartPhone{

    public void displayInfo(){
        System.out.println("This is an GooglePixel.");
    }
}


class Factorymethod{

    public SmartPhone getSmartPhone(String phoneName){

        if(phoneName.compareToIgnoreCase("iphone") == 0){
            return new Iphone();
        }
        else if(phoneName.compareToIgnoreCase("Samsung")==0){
            return new Samsung();
        }
        else if(phoneName.compareToIgnoreCase("googlepixel")==0){
            return new GooglePixel();
        }
        else{
            return null;
        }


    }
}

public class SimpleFactoryMethod {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter brand name you have : ");
        String brand = input.next();
        
        Factorymethod factorymethod = new Factorymethod();        
        SmartPhone phone = factorymethod.getSmartPhone(brand);
        phone.displayInfo();
    }
    
}