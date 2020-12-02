package CircleQueue;

public class CircleQueue {
    private final int maxSize;
    /*
    front 变量的含义做一个调整，front 就指向队列的第一个元素，也就是
    说Cirqueue[front]
    front的初始值为0
     */
    private int front;
    /*
    rear 变量的含义做一个调整，rear指向队列的最后一个元素的后一个位置，
    因为希望空出一个空间作为约定
    rear的初始值为0
     */
    private int rear;
    private final int[] Cirqueue;

    public CircleQueue(int maxSize) {
        this.maxSize = maxSize;
        front = 0;
        rear = 0;
        Cirqueue = new int[maxSize];
    }

    //判断队列是否为空
    public boolean isEmpty() {

        return rear == front;
    }

    //判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //添加数据
    public void addQueue(int n) {
        if (isFull()) {
            throw new RuntimeException("队列已满，不能添加数据！");
        }
        Cirqueue[rear] = n;
        //将rear后移，这里必须考虑取模
        rear = (rear + 1) % maxSize;
    }

    //获取队列的数据，出队列
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列已空，不能取数据！");
        }
        /*
        1.这里需要分析出front是指向队列的第一个元素
        2.将front后移，考虑取模
        3.将临时保存的变量返回
         */
        int value = Cirqueue[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //显示所有数据,队列中的有效数据
    public void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列已空，队列中无数据！");
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("Cirqueue[%d]=%d\n", i % maxSize, Cirqueue[i % maxSize]);
        }
    }

    //获取当前有效数据的个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    //获取队列的头数据，不出列
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列已空，队列无数据！");
        }
        return Cirqueue[front];
    }
}
