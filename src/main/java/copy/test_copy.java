package copy;

public class test_copy {
    public static void main(String[] args) {
//        learn_copy lc1 = new learn_copy(10, "John");
//        learn_copy lc2 = new learn_copy(lc1);
//        System.out.println(lc1.age + " " + lc1.name);
//        System.out.println(lc2.age + " " + lc2.name);

        String obj1 = "JavaTpoint is a very good site.";
        String obj2 = obj1;

        System.out.println(obj1.hashCode());
        System.out.println(obj2.hashCode());


    }
}
