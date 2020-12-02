package PolandExpression;

import java.util.LinkedList;
import java.util.Stack;
/*
思路分析：
   1.从左向右遍历，因为字符中用空格分开，所以尽心分割，然后将分割后的字符块放在链表中
   2.遍历链表中的字符
   3.如果是数字字符直接入栈
   4.如果是运算符，从栈中出栈两个，用parsetInt()方法，将字符转换为数字
   5.接着进行运算，将结果入栈
   6.链表遍历后，栈中的字符就是结果
 */
public class suffixExpression {
    public static void main(String[] args) {
        String s = "30 5 9 * + 40 -"; //3+5*9-4=44
        LinkedList<String> list = new LinkedList<String>();
        String split[] = s.split(" ");//对字符串分割
        for(String item: split){
            list.add(item);
        }
        Stack<String> stack = new Stack<String>();
        for(String val:list){
            if(val.matches("\\d+")){
                //使用正则表达式
                stack.push(val);
            }else{
                int num1 = Integer.parseInt(stack.pop());//将字符数字转换成正整数
                int num2 = Integer.parseInt(stack.pop());
                int res = 0;
                if(val.equals("+")){
                    res = num1+num2;
                }else if(val.equals("-")){
                    res = num2 - num1;
                }else if(val.equals("*")){
                    res = num1*num2;
                }else if(val.equals("/")){
                    res = num2 / num1;
                }else{
                    throw new RuntimeException("不是运算符");
                }
                stack.push(res+"");//将正整数转换成字符
            }
        }
        System.out.println(Integer.parseInt(stack.pop()));
    }
}
