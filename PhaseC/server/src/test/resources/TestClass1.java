public class TestClass1 {
    public Integer val;

    public TestClass1() {}

    public TestClass1(Integer val) {
        this();
        this.val = val;
    }
    public void main(String[] args) {
        TestClass tc = new TestClass(100);
        for (int i = 0; i < 5; i++)
        System.out.println(tc.val);
    }
}