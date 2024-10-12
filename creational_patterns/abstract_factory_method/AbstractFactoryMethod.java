package creational_patterns.abstract_factory_method;

interface  Color {
    void Colors();
}

interface Shape {
    void Area();
}


class Circle implements Shape{

    private double AreaOfCircle;

    public Circle(int radius){
        this.AreaOfCircle = 2*Math.PI*radius;
    } 

    public void Area(){
        System.out.println("Area of Circle : "+AreaOfCircle);
    }

}


class Triangle implements Shape{

    private double base;
    private double height;

    public Triangle(double base,double height){
        this.base = base;
        this.height = height;
    } 

    public void Area(){
        System.out.println("Area of Triangle : "+ 0.5 * base * height);
    }

}

class Rectangle implements Shape{

    private double width;
    private double height;

    public Rectangle(double width,double height,int no){
        this.width = width;
        this.height = height;
    } 

    public void Area(){
        System.out.println("Area of Rectangle : "+ width * height);
    }

}

class Red implements Color{
   
    public void Colors(){
        System.out.println("Red");
    }
}

class Yellow implements Color{
   
    public void Colors(){
        System.out.println("Yellow");
    }
}


class Blue implements Color{
   
    public void Colors(){
        System.out.println("Blue");
    }
}


class AbFactroyMethodShape{

    private int radius,no;
    private double base,height,width;

    //overriding method for diffrent shape but here the catch triangle and rectangle both have only 2 parameter so passing extra 
    //varible in rectangle no = 1 
    //circle
    public void shapePara(int radius){
        this.radius = radius;
    }

    //triangle
    public void shapePara(double base,double height){
        this.base = base;
        this.height=height;
    }

    //Rectangle
    public void shapePara(double width, double height,int no){
        this.no=no;
        this.width = width;
        this.height=height;
    }


    public Shape getShape(String shapname){

        

        if(shapname.equalsIgnoreCase("Circle")){
            return new Circle(radius);
        }  
        else if(shapname.equalsIgnoreCase("triangle")){
            return new Triangle(base,height);
        }
        else if(shapname.equalsIgnoreCase("rectangle")){
            return new Rectangle(width,height,no);
        }
        else{
            return null;
        }

    }
}


class  AbFactroyMethodColor {

    public Color getColor(String color){
        if(color.equalsIgnoreCase("red")){
            return new Red();
        }
        else if(color.equalsIgnoreCase("Yellow")){
            return new Yellow();
        }
        else if(color.equalsIgnoreCase("blue")){
            return new Blue();
        }
        else{
            return null;
        }
    }
    
}


public class AbstractFactoryMethod {

    static final  String shapecolortag = "Shape Color : ";
    public static void main(String[] args) {
        AbFactroyMethodShape factorymethodShape = new AbFactroyMethodShape();
        AbFactroyMethodColor abFactroyMethodColor = new AbFactroyMethodColor();


        Color red = abFactroyMethodColor.getColor("Red");
        System.out.print(shapecolortag);red.Colors();

        factorymethodShape.shapePara(10);
        Shape circle = factorymethodShape.getShape("circle");
        circle.Area();
        System.out.println();
       

        Color yellow = abFactroyMethodColor.getColor("yellow");
        System.out.print(shapecolortag);yellow.Colors();
        factorymethodShape.shapePara(10, 20);
        Shape triangle = factorymethodShape.getShape("triangle");
        triangle.Area();
        System.out.println();


        Color blue = abFactroyMethodColor.getColor("blue");
        System.out.print(shapecolortag);blue.Colors();
        factorymethodShape.shapePara(10, 20,1);
        Shape rectangle = factorymethodShape.getShape("rectangle");
        rectangle.Area();

    }
}