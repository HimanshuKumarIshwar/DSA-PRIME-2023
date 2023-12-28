package oops2;

public class Car extends Vehicle {
    String color;
    void start(){
        Scooter scooterObj = new Scooter();
        scooterObj.breaking(this);
        super.start();
        System.out.println(this);
        System.out.println(this.model+ " car is starting");
    }
    Car(){
        super(3);
        System.out.println("Car is being created");
    }
    public static void main(String[] args) {
        Car obj =new Car();
        obj.wheelsCount =4;
       obj.color="Black";
        obj.model ="i10";

        obj.start();
        System.out.println(obj.wheelsCount);


    }
}

class Scooter{
    void breaking(Car car){
        System.out.println(car.model +" is breaking");
    }
}
