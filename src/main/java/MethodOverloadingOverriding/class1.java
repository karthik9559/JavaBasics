package MethodOverloadingOverriding;

public class class1 {
    protected int x;
    protected int y;

    public class1(){
        this.x = 0;
        this.y = 0;
    }
    public class1(int x, int y){
        this.x = x;
        this.y = y;
    }
    public  void display(int x, int y){
        System.out.println("[<<" + x + ">>, <<" + y + ">>]");
        
    }
}
