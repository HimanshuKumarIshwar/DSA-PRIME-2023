package oops3;

public class LearnAbstract {
    public static void main(String[] args) {


    }
}

 abstract class Vehicle{
    public abstract void accelerated();
    abstract void breaks(int wheels);
}

class Car extends Vehicle{

    @Override
    public void accelerated() {

    }

    @Override
    void breaks(int wheels) {

    }
}
