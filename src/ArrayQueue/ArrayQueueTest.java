package ArrayQueue;

import java.util.Scanner;

public class ArrayQueueTest {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(100);
//        arrayQueue.addQueue(13);
//        arrayQueue.addQueue(2);
//        arrayQueue.addQueue(133);
//        arrayQueue.addQueue(23);
//        arrayQueue.addQueue(18);
//        arrayQueue.addQueue(52);
//        arrayQueue.addQueue(123);
//        arrayQueue.addQueue(28);
        boolean loop = true;
        char Key = ' ';
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列中获取数据");
            System.out.println("h(hear):查看队列头的值");
            Key = scanner.next().charAt(0);//获取一个字符
            switch (Key) {
                case 's':
                    try {
                        arrayQueue.showQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'a':
                    System.out.println("向队列添加数据：");
                    int value = scanner.nextInt();
                    try {
                        arrayQueue.addQueue(value);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try {
                        System.out.println("获取数据：" + arrayQueue.getQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        System.out.println("获取队列头的数据：" + arrayQueue.headQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    loop = false;
                    System.out.println("程序退出！！！");
            }
        }
    }
}
