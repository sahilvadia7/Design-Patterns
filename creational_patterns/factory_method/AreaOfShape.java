

interface Shape{
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


class Factorymethod{


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

public class AreaOfShape {
    public static void main(String[] args) {
        Factorymethod factorymethod = new Factorymethod();
        factorymethod.shapePara(10);
        Shape circle = factorymethod.getShape("circle");
        circle.Area();

        factorymethod.shapePara(10, 20);
        Shape triangle = factorymethod.getShape("triangle");
        triangle.Area();

        factorymethod.shapePara(10, 20,1);
        Shape rectangle = factorymethod.getShape("rectangle");
        rectangle.Area();


    }    
}
