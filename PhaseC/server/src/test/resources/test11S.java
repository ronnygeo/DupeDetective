package testfiles;

/**
 * Created by Aditya on 11/19/2017.
 */
public class test11S {
    public boolean isAdditive(String str, long num1, long num2) {
        if(str.equals("")) return true; // reaches the end of string means a yes

        long sum = num1+num2;
        String s = ((Long)sum).toString();
        String sa,aa;

        if(str.equals(".")) return true;

        return isAdditive(str.substring(s.length()), num2, sum); // recursively checks the remaining string
    }

    private void multiply(int i){

        System.out.print("i*i");
        System.out.println(i*i);
    }
}
