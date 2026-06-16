class Overriding {
    public static void main(String[] args) {
        Parent p = new Parent();
        Parent c = new child();
        p.display();
        c.display();
    }
}

public class O2 extends Overriding {
    public static void main(String[] args) {
        Parent p = new Parent();
        Parent c = new child();
        p.display();
        c.display();
    }
}
class Parent{
    private int a = 10;
    public int b = 100;
    static public void display() {
        System.out.println("This is the parent class.");
    }
}

class child extends Parent{
    private int a = 20;
    @Override
    b = 200;
    static public void display() {
        System.out.println("This is the child class.");
    }
}