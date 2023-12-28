package oops2;

public class Vehicle {

    final int gears = 4;
    public static void main(String[] args) {
  Vehicle v1 =new Vehicle();
        System.out.println(v1.gears);
    }

    int wheelsCount;
    String model;
    void start(){
        System.out.println("Vehicle is stating");
    }
    Vehicle(){
        System.out.println("Creating a Vehicle Instance");
    }
    Vehicle(int wheelsCount){
        this.wheelsCount =wheelsCount;
        System.out.println("Creating Vehicles with wheels");
    }
     final void accelerated(){
        System.out.println("vehicle is accelerating");
    }
}

