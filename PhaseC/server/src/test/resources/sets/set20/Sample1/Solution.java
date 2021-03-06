package File1;

import java.util.*;

public class Solution {
    /**
     * Main method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        List<String> result = new Solution().removeInvalidParentheses("()())()");
        result.forEach(System.out::println);
    }

    public List<String> removeInvalidParentheses(String s) {
        Set<String> set = new HashSet<>();
        List<String> result = new ArrayList<>();
        result.add("");
        //generate all combinations of unique parentheses
        for(int i = s.length() - 1; i >= 0; i --){
            for(int j = 0, l = result.size(); j < l; j++){
                String curr = s.charAt(i) + result.get(j);
                if(!set.contains(curr)){
                    result.add(curr);
                    set.add(curr);
                }
            }
        }
        //check for max length
        int maxLen = 0;
        for(int i=0;i <result.size();i++){
            if(isValid(result.get(i))){
                maxLen = Math.max(maxLen, result.get(i).length());
            }
        }
        //prepare the final list
        List<String> finalR = new ArrayList<>();
        for(int i=0;i <result.size();i++){
            if(isValid(result.get(i))) {
                if(maxLen == result.get(i).length()){
                    finalR.add(result.get(i));
                }
            }
        }
        return finalR;
    }

    /**
     * Check if the given string of parentheses is valid or not
     * @param s String of parentheses
     * @return true if valid
     */
    public boolean isValid(String s){
    	Stack<Character> stack = new Stack<Character>();
    	for(char c: s.toCharArray()){
    		if(c == '('){
    			stack.push(c);
    		} else if (c == ')'){
    			stack.pop();
    		}
    	}
    	
    	if(stack.isEmpty())
    		return true;
    	
    	return false;
    }
}
