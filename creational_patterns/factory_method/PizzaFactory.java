/**
 * Interface Pizza
 */
interface Pizza {
    void prepare();
    void bake();
    void cut();
    void box();
}

class CheesePizza implements Pizza {

    @Override
    public void prepare() {
        System.out.println("Preparing Cheese Pizza");
    }

    @Override
    public void bake() {
        System.out.println("Baking Cheese Pizza");
    }

    @Override
    public void cut() {
        System.out.println("Cutting Cheese Pizza");
    }

    @Override
    public void box() {
        System.out.println("Packing Cheese Pizza");
    }
}

class VeggiePizza implements Pizza {

    @Override
    public void prepare() {
        System.out.println("Preparing Veggie Pizza");
    }

    @Override
    public void bake() {
        System.out.println("Baking Veggie Pizza");
    }

    @Override
    public void cut() {
        System.out.println("Cutting Veggie Pizza");
    }

    @Override
    public void box() {
        System.out.println("Packing Veggie Pizza");
    }
}

class PizzaStore {

    public Pizza createPizza(String type) {
        Pizza pizza = null;

        if (type.equalsIgnoreCase("cheese")) {
            pizza = new CheesePizza();
        } else if (type.equalsIgnoreCase("veggie")) {
            pizza = new VeggiePizza();
        } else {
            System.out.println("Invalid pizza type: " + type);
        }
        return pizza;
    }
}

public class PizzaFactory {

    public static void main(String[] args) {
        PizzaStore lapinozzPizzaStore = new PizzaStore();
        Pizza cheesePizza = lapinozzPizzaStore.createPizza("cheese");
        // if (cheesePizza != null) {
            cheesePizza.prepare();
            cheesePizza.bake();
            cheesePizza.cut();
            cheesePizza.box();
        // }
    }
}
