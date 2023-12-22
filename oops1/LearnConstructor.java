package oops1;

public class LearnConstructor {
    public static void main(String[] args) {
        Complex num1 =new Complex(2,3);
        Complex num2 =new Complex(4,1);
         num1.print();
         num2.print();
        System.out.println("adding two number");
       Complex result = num1.add(num2);
        result.print();
    }
}

class Complex{
    int a, b;

public Complex(int real){
    a =real;
    b=12;
}

    public Complex(int a, int b){
        this.a =a;
        this.b =b;
    }
    void print(){
        System.out.println(a+" + "+b+"i");
    }

    Complex add(Complex num2){
    this.print();
        return new Complex(a+ num2.a, b+num2.b);
    }
}