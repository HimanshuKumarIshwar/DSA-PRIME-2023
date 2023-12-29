package oopsLive;

import java.util.Objects;

public class LearnObjectClass {

    public static void main(String[] args) {

        Car obj =new Car("Honda",2020);
        Car obj2 =new Car("Honda", 2020);
        System.out.println(obj.equals(obj2));
        System.out.println(obj);
        System.out.println(obj2);



    }
}

class Car{
    String model;
    int year;

    public Car(String model, int year) {
        this.model = model;
        this.year = year;
    }
//@Override
//   public String toString(){
//        return "Car ka Mode "+ model +" and year is "+year;
//   }

//    public boolean equals(Object obj){
//          Car that = (Car)obj;
//         if(this.model.equals(that.model) && this.year == that.year)return true;
//         return false;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car car)) return false;
        return year == car.year && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, year);
    }
}
