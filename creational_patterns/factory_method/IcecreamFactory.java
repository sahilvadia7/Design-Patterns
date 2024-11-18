interface IceCream {
    void prepare();
    void serve();

}

class ChocolateIcecream implements IceCream{
    
    @Override
    public void prepare(){
        System.out.println("Preparing Chocolate Ice-Cream");
    }

    @Override
    public void serve(){
        System.out.println("Serve Chocolate Ice-Cream");
    }
}

class StrawberryIcecream implements IceCream{

    @Override
    public void prepare(){
        System.out.println("Preparing Strawberry Ice-Cream");
    }

    @Override
    public void serve(){
        System.out.println("Serve Strawberry Ice-Cream");
    }
}


//facatory
class IcecreamStore{


    public IceCream getIceCreamFlavour(String flavour){
        IceCream icecream = null;

        if(flavour.equalsIgnoreCase("Chocolate")){
            icecream = new ChocolateIcecream();
        }
        else if(flavour.equalsIgnoreCase("Strawberry")){
            icecream = new StrawberryIcecream();
        }
        else{
            System.out.println("Invalid Ice-Cream type: " + flavour);
        }

        return icecream;
    }
}


public class IcecreamFactory {

    public static void main(String[] args) {
        
        IcecreamStore havmor = new IcecreamStore();
        IceCream icecream = havmor.getIceCreamFlavour("chocolate");
        System.out.println();
        icecream.prepare();
        icecream.serve();
    }
    
}
