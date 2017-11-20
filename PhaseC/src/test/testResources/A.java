public class A {

    public static void main(String[] args) {
        System.out.println("String".hashCode());
        int i = 10;
        switch (i) {
            case 10: i = 1; break;
            case 20: i = 2; break;
        }
    }
}