package ArrayQueue;

public class ArrayQueue {
    private final int maxSize;//表示数组最大容量
    private final int[] arr;//该数据用于存储数据，模拟队列
    private int front;//队列头
    private int rear;//队列尾

    public ArrayQueue(int maxSize) {//构造队列，初始化
        this.maxSize = maxSize;
        arr = new int[maxSize];
        /*
        队列的输出输入是分别从前后端来处理，因此需要两个变量front和rear分别记录
        队列前后端的下标，front会随着数据输出而改变，而rear则是随着数据输入而改变
         */
        front = -1;
        rear = -1;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //添加数据
    public void addQueue(int n) {
        if (isFull()) {
            throw new RuntimeException("队列已满，不能添加数据！");
        }
        rear++;//为什么要先加1，因为rear从-1开始的
        arr[rear] = n;
    }

    //获取队列的数据，出队列
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列已空，不能取数据！");
        }
        front++; //为什么要先加1，因为rear从-1开始的
        return arr[front];
    }

    //显示所有数据,从队列头到队列尾之间的数据
    public void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列已空，队列中无数据！");
        }
        for (int i = front + 1; i <= rear; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    //获取队列的头数据，不出列
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列已空，队列无数据！");
        }
        return arr[front + 1];
    }
}
