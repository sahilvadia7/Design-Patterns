package creational_patterns.abstract_factory_method;

interface Flower {
    void getDescription();
}

class Rose implements Flower {

    @Override
    public void getDescription() {
        System.out.println("This is a Rose.");
    }
}

class Tulip implements Flower {

    @Override
    public void getDescription() {
        System.out.println("This is a Tulip.");
    }
}

abstract class FlowerShop {

    public abstract Flower createFlower();
}

class RoseShop extends FlowerShop {

    @Override
    public Flower createFlower() {
        return new Rose();
    }
}

class TulipShop extends FlowerShop {

    @Override
    public Flower createFlower() {
        return new Tulip();
    }
}

public class FlowerFactory {

    public static void main(String[] args) {
        FlowerShop roseshop = new RoseShop();
        Flower rose = roseshop.createFlower();

        rose.getDescription();

    }
}
