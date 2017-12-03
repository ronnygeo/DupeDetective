public class TestClass1 {
    public Integer val;

    public TestClass1() {}

    public TestClass1(Integer val) {
        this();
        this.val = val;
    }
    public void main(String[] args) {
        int[] ind = {0,1,2,3,4};
        TestClass tc = new TestClass(100);
        for (int i: ind)
            System.out.println(tc.val);
            continue;
    }
}