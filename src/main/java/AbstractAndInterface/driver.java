package AbstractAndInterface;

import static AbstractAndInterface.child_c.x;

public class driver {
    public static void main(String[] args) {
//        child_c obj = new child_c();
//        obj.abstract_display_2();
//        obj.display();
        child_c.static_display();
        System.out.println(x);
        System.out.println(child_c.x);
    }
}
