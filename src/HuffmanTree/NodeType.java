package HuffmanTree;

public  class NodeType implements Comparable<NodeType> {//存放哈夫曼树
    public int no;//对应哈夫曼树htn中的位置
    public char data;//字符
    public int weight;//权值

    public void setData(char data) {
        this.data = data;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public void setWeight(int data) {
        this.weight = weight;
    }
    public char getData(){
        return data;
    }
    public int getNo(){
        return no;
    }
    public int getWeight(){
        return weight;
    }
    @Override
    public int compareTo(NodeType o) {  //重写自然排序
        return this.weight - o.weight;
    }

}
