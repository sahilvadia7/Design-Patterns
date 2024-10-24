package creational_patterns.builder_pattern;

class House {

    private String walls;
    private String roof;
    private String doors;

    public void setWalls(String walls) {
        this.walls = walls;
    }

    public void setRoof(String roof) {
        this.roof = roof;
    }

    public void setDoors(String doors) {
        this.doors = doors;
    }

    @Override
    public String toString() {
        return "House With " + walls + " ," + roof + " ," + doors;
    }
}

interface HouseBuilder {
    void buildWalls();
    void buildRoof();
    void buildDoors();
    House getHouse();
}

class WoodenHouseBuilder implements HouseBuilder {

    private House house;

    public WoodenHouseBuilder() {
        this.house = new House();
    }

    @Override
    public void buildWalls() {
        house.setWalls("Wooden Walls");
    }

    @Override
    public void buildRoof() {
        house.setRoof("Wooden Roof");
    }

    @Override
    public void buildDoors() {
        house.setDoors("Wooden Doors");
    }

    @Override
    public House getHouse() {
        return this.house;
    }
}

class Diractor {

    public House constructorHouse(HouseBuilder builder) {
        builder.buildWalls();
        builder.buildRoof();
        builder.buildDoors();
        return builder.getHouse();
    }
}

public class BuilderPattern {

    public static void main(String[] args) {
        HouseBuilder woodenHouseBuilder = new WoodenHouseBuilder();
        Diractor diractor = new Diractor();

        House woodHouse = diractor.constructorHouse(woodenHouseBuilder);
        System.out.println(woodHouse);
    }
}
