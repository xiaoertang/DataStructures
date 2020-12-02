package CircleQueue;
import java.util.Scanner;

public class CircleArrayQueueTest {
    public static void main(String[] args) {

        CircleQueue circleQueue = new CircleQueue(100);
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
                        circleQueue.showQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'a':
                    System.out.println("向队列添加数据：");
                    int value = scanner.nextInt();
                    try {
                        circleQueue.addQueue(value);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try {
                        System.out.println("获取数据：" + circleQueue.getQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        System.out.println("获取队列头的数据：" + circleQueue.headQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    loop = false;
                    System.out.println("程序退出！！！");
                    break;
            }
        }
    }
}



