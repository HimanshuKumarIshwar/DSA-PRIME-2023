package collectionFrameWorkLive;

public class Animal implements Comparable<Animal>{

    int age;
    int weight;
    String name;

    public Animal(int age, int weight, String name) {
        this.age = age;
        this.weight = weight;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "age=" + age +
                ", weight=" + weight +
                ", name='" + name + '\'' +
                '}'+"\n";
    }

    @Override
    public int compareTo(Animal that) {
        if(this.age == that.age)return this.name.compareTo(that.name);
        return this.age-that.age;
    }
}
