package oopsLive;

public class MainClass {

    public static void main(String[] args) {
        int a =12;
        Data d = new Data();
        d.data =123;
        System.out.println(a);
        addSum(a,d);
        System.out.println(a);
        System.out.println(d.data);

    }
    static void addSum(int a, Data obj){
        a =123;
        obj.data =100;
    }
}

class Data{
    int data;
}

