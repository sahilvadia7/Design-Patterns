interface Furniture {
    void hasLegs();
    void sitOn();
}

interface FurnitureVariants {
    void variants();
}

class Chair implements Furniture {
    public void hasLegs() {
        System.out.println("4 Legs");
    }

    public void sitOn() {
        System.out.println("1 Person");
    }
}

class Sofa implements Furniture {
    public void hasLegs() {
        System.out.println("4 Legs");
    }

    public void sitOn() {
        System.out.println("4 Persons");
    }
}

class CoffeeTable implements Furniture {
    public void hasLegs() {
        System.out.println("4 Legs");
    }

    public void sitOn() {
        System.out.println("No one");
    }
}

class ArtDeco implements FurnitureVariants {
    public void variants() {
        System.out.println("ArtDeco");
    }
}

class Victorian implements FurnitureVariants {
    public void variants() {
        System.out.println("Victorian");
    }
}

class Modern implements FurnitureVariants {
    public void variants() {
        System.out.println("Modern");
    }
}

abstract class AbstractFactory {
    abstract Furniture getFurniture(String furniture);
    abstract FurnitureVariants getVariants(String variants);
}

class FurnitureFactory extends AbstractFactory {
    public Furniture getFurniture(String furnitureType) {
        if (furnitureType == null) {
            return null;
        }

        if (furnitureType.equalsIgnoreCase("Chair")) {
            return new Chair();
        } else if (furnitureType.equalsIgnoreCase("Sofa")) {
            return new Sofa();
        } else if (furnitureType.equalsIgnoreCase("CoffeeTable")) {
            return new CoffeeTable();
        }

        return null;
    }

    FurnitureVariants getVariants(String variants) {
        return null;
    }
}

class VariantsFactory extends AbstractFactory {
    public FurnitureVariants getVariants(String variantsType) {
        if (variantsType == null) {
            return null;
        }

        if (variantsType.equalsIgnoreCase("ArtDeco")) {
            return new ArtDeco();
        } else if (variantsType.equalsIgnoreCase("Victorian")) {
            return new Victorian();
        } else if (variantsType.equalsIgnoreCase("Modern")) {
            return new Modern();
        }

        return null;
    }

    Furniture getFurniture(String furniture) {
        return null;
    }
}

class FactoryProducer {
    public static AbstractFactory getFactory(String choice) {
        if (choice.equalsIgnoreCase("FURNITURE")) {
            return new FurnitureFactory();
        } else if (choice.equalsIgnoreCase("VARIANTS")) {
            return new VariantsFactory();
        }

        return null;
    }
}

public class abstrtShopMethod {
    public static void main(String[] args) {
        // get furniture factory
        AbstractFactory furnitureFactory = FactoryProducer.getFactory("FURNITURE");

        // get an object of type Chair
        Furniture furniture1 = furnitureFactory.getFurniture("Chair");
        furniture1.hasLegs();
        furniture1.sitOn();
    }
}