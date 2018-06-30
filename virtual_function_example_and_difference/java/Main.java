public class Main {
    public static void main(String[] args){
        Child c = new Child();
        Base b = c;
        b.print();
        c.print();
    }
}
