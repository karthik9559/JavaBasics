package copy;

public class learn_copy {
    int age;
    String name;
    public learn_copy(int age, String name){
        this.age = age;
        this.name = name;
    }

    public learn_copy(learn_copy lc){
        this.age = lc.age;
        this.name = lc.name;
    }
}
