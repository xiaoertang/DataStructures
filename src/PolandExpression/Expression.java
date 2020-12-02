package PolandExpression;
import java.util.Scanner;
import java.util.Stack;
/*
使用栈完成表达式计算：
   1.通过一个index索引，来遍历表达式
   2.如果发现是一个数字分以下情况
     1)统计连续数字字符个数count，遇到运算发count为0
     2)如果字符是连续的就出栈乘以10加上当前的数字，在入栈
     3)如果是一个数字，就直接入栈
   3.如果发现扫描到是一个运算符，分如下情况：
     1）如果发现当前的符号栈为空，直接入栈
     2）如果符号栈有符号，就进行比较，如果当前的操作符的优先级
        小于或者等于栈中的操作符，就需要从数栈中pop两个数，在
        符号栈中pop一个符号，进行运算，将结果，入数栈。然后将
        当前的操作符入符号栈，如果当前的操作符的优先级大于栈中
        的操作符，就直接入符号栈。
   4.当表达式扫描完毕，就顺序的从数栈和符号栈pop出相应的数和符号，
     并运行
   5.最后在数栈只有个数字，就是表达式的结果
 */
public class Expression {
    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<Integer>();
        Stack<Character> charStack = new Stack<>();
        Expression exp = new Expression();
        // String s = "3+4*5-10";
        Scanner read = new Scanner(System.in);
        String s = read.nextLine();
        int idx = 0;
        int n1 = 0;
        int n2 = 0;
        int res = 0;
        int count = 0;//统计连续的数字字符
        while (true) {
            char ch = s.substring(idx, idx + 1).charAt(0);
            //ch = ch-
            if (ch >= '0' && ch <= '9') { //是数字直接入栈
                count++;
                int x = ch - '0';
                if (count > 1) {
                    int n = integerStack.pop();
                    n = n * 10 + x;
                    integerStack.push(n);
                } else {
                    integerStack.push(x);
                }
            } else {
                count = 0;//遇到运算符count为0
                if (charStack.isEmpty()) {//是空栈直接进栈
                    charStack.push(ch);
                } else {
                    if (exp.prior(ch) > exp.prior(charStack.peek())) {
                        charStack.push(ch);
                    } else {
                        n1 = integerStack.pop();
                        n2 = integerStack.pop();
                        res = exp.compute(charStack.pop(), n1, n2);
                        integerStack.push(res);
                        charStack.push(ch);
                    }
                }
            }
            idx++;
            if (idx >= s.length()) {
                break;
            }
        }
        while (true) {
            if (charStack.isEmpty()) {  //符号栈为空时，数栈只有一个，直接出栈，即结果
                break;
            } else {
                n1 = integerStack.pop();
                n2 = integerStack.pop();
                res = exp.compute(charStack.pop(), n1, n2);
                integerStack.push(res);
            }
        }
        System.out.println(res);
    }

    public int prior(char ch) {  //比较运算符
        if (ch == '+' || ch == '-') {
            return 0;
        } else if (ch == '*' || ch == '/') {
            return 1;
        } else {
            return -1;
        }
    }
    public int compute(char ch, int n1, int n2) {//计算两个数
        int res = 0;
        switch (ch) {
            case '+':
                res = n1 + n2;
                break;
            case '-':
                res = n2 - n1;
                break;
            case '*':
                res = n1 * n2;
                break;
            case '/':
                res = n2 / n1;
                break;
        }
        return res;
    }
}

