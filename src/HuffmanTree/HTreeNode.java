package HuffmanTree;

public class HTreeNode {
    char data;  //字符
    int weight; //权值
    int parent; //双亲的位置
    int lchild; //左孩子
    int rchild; //右孩子
    int index;

    HTreeNode next;
//    public void addHtn(HTreeNode htn){
//       this.htn = htn;
//    }
//    public HTreeNode getHtn(){
//        return htn;
//    }

    public void setIndex(int index) {
        this.index = index;
    }
    public int getIndex(){
        return index;
    }

    public void setData(char data) {
        this.data =data;
    }
    public void setWeight(int weight){
        this.weight = weight;
    }
    public void setParent(int parent){
        this.parent = parent;
    }
    public void setLchild(int lchild){
        this.lchild = lchild;
    }
    public void setRchild(int rchild){
        this.rchild = rchild;
    }
    public char getData(){
        return data;
    }
    public int getWeight(){
        return weight;
    }
    public int getParent(){
        return parent;
    }
    public int getLchild(){
        return lchild;
    }
    public int getRchild(){
        return rchild;
    }
}
