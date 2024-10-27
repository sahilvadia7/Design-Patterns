package creational_patterns.builder_pattern;

class Pizza {

    private String sauce;
    private String base;
    private String cheese;
    private String toppings;

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

    @Override
    public String toString() {
        return (
            "Pizza With " +
            sauce +
            " ," +
            base +
            " ," +
            cheese +
            ", " +
            toppings
        );
    }
}

interface PizzaBuilder {
    void buildSauce();
    void buildBase();
    void buildCheese();
    void buildToppings();
    Pizza getPizza();
}

class SevenCheesePizza implements PizzaBuilder {

    private Pizza pizza;

    public SevenCheesePizza() {
        this.pizza = new Pizza();
    }

    @Override
    public void buildSauce() {
        pizza.setSauce("Tomato");
    }

    @Override
    public void buildBase() {
        pizza.setBase("Thin crust");
    }

    @Override
    public void buildCheese() {
        pizza.setCheese("Mozzarella");
    }

    @Override
    public void buildToppings() {
        // pizza.setToppings("Basil");
        pizza.setToppings("Onions");
    }

    @Override
    public Pizza getPizza() {
        return this.pizza;
    }
}

class Chef {

    public Pizza constructorPizza(PizzaBuilder builder) {
        builder.buildSauce();
        builder.buildBase();
        builder.buildCheese();
        builder.buildToppings();
        return builder.getPizza();
    }
}

public class BuilderPizza {

    public static void main(String[] args) {
        PizzaBuilder SevenCheese = new SevenCheesePizza();
        Chef chef = new Chef();

        Pizza Cook = chef.constructorPizza(SevenCheese);
        System.out.println(Cook);
    }
}
