package vip.tanghong.datastructure.leetcode.栈;

import vip.tanghong.datastructure.stack.Stack;

import java.util.HashMap;
import java.util.Map;

public class _20_有效的括号 {

    public boolean isValid(String s) {
        if(s.length() % 2 == 1) {
            return false;
        }

        while (s.contains("{}") || s.contains("()") || s.contains("[]")) {
            s = s.replace("{}", "");
            s = s.replace("()", "");
            s = s.replace("[]", "");
        }
        return s.isEmpty();
    }

    public boolean isValid2(String s) {
        if(s.length() % 2 == 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        int length = s.length();
        for(int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{') {  //左括号
                stack.push(c);
            }else { //右括号
                if(stack.isEmpty()) {
                    return false;
                }
                char left = stack.pop();
                if(left == '(' && c != ')') {
                    return false;
                }
                if(left == '[' && c != ']') {
                    return false;
                }
                if(left == '{' && c != '}') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static Map<Character, Character> map = new HashMap<>();

    static {
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
    }

    public boolean isValid3(String s) {
        if(s.length() % 2 == 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        int length = s.length();
        for(int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {  //左括号
                stack.push(c);
            }else { //右括号
                if(stack.isEmpty()) {
                    return false;
                }
                if(c != map.get(stack.pop())) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        /*_20_有效的括号 s = new _20_有效的括号();
        System.out.println(s.isValid("()"));
        System.out.println(s.isValid("()[]{}"));
        System.out.println(s.isValid("(]"));
        System.out.println(s.isValid("([)]"));
        System.out.println(s.isValid("{[]}"));*/

//        test();
    }

    public static void test() {
        Stack<Integer> stack = new Stack<>();

        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());

        System.out.println(stack.pop());
        System.out.println(stack.peek());

        stack.clear();

        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
    }

}
