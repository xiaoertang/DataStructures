/*package HuffmanTree;

import java.util.*;

public class Huffman {
    //HTreeNode ht= new HTreeNode;//哈夫曼树结点的类型
    HashMap<Character,String> htcode = new HashMap<Character, String>();//存放哈夫曼树
    NodeType e, e1, e2; //
    public int n;
    public int m = 2 * n -1;
    public void setN(int n){
        this.n = n;
    }
    HTreeNode htn = new HTreeNode;

    public void CreateHTree() {  //构造哈夫曼树
        HTreeNode p1 = htn.next;
        for (int i = 0; i < 2 * n - 1; i++) {
            p1.setLchild(0);
            p1.setRchild(0);
            p1.setParent(0);
            p1.setIndex(i);
            p1 = p1.next;

        }
        Scanner scanner = new Scanner(System.in);
        HTreeNode p2 = htn.next;
        for (int i = 0; i < n; i++) {
            char ch = ' ';
            int w;
            ch = scanner.next().charAt(0);
            w = scanner.nextInt();
            p2.setData(ch);
            p2.setWeight(w);
            p2 = p2.next;
        }
        PriorityQueue<NodeType> q= new PriorityQueue<NodeType>();
        e = new NodeType();
        HTreeNode p3 = htn.next;
        for (int i = 0; i < n; i++) {//将n个结点放进链表中
            e.setNo(i);
            e.setData(p3.getData());
            e.setWeight(p3.getWeight());
            q.add(e);
            p3 = p3.next;
        }
        e1 = new NodeType();
        e2 = new NodeType();
        HTreeNode p4 = htn.next;
        for (int i = n; i < m; i++) {//构造叶子哈夫曼树的n-1个非叶子结点

            e1 = q.poll();//获得最小的权值，并删除
            e2 = q.poll();//获得次小的权值，并删除
            p4.setWeight(e1.getWeight() + e2.getWeight());//构建哈夫曼树的非叶子结点i
            p4.setLchild(e1.getNo()); //
            p4.setRchild(e2.getNo());
            HTreeNode x = p4.next;
            while(true){
                if(x.index == e1.getNo()){
                    break;
                }
                x = x.next;
            }
            x.setParent(i);
            p4.e1.getNo().setParent(i);//修改e1.no的双亲的结点为i
            ht[e2.getNo()].setParent(i);
            e.setNo(i);
            e.setWeight(e1.getWeight() + e2.getWeight());
            q.add(e);
        }
    }

    public void CreateHCode() {//构造哈夫曼编码
        String code; //保存编码
        for (int i = 0; i < n; i++) {//构造叶子结点i的哈夫曼编码
            code = " ";
            int curno = i;
            int f = ht[curno].getParent();
            while (f != -1) {  //循环到根节点
                if (ht[f].getLchild() == curno) {//curno为双亲f的左孩子
                    code += "0";
                } else if (ht[f].getRchild() == curno) {//curno为双亲f的右孩子
                    code += "1";

                }
                curno = f;
                f = ht[curno].getParent();
            }
            htcode.put(ht[i].getData(), code);  //获得ht[i].data字符的哈夫曼编码
        }
    }
    int len[] = new int[101];//保存每个结点编码的长度
    public void DisHCode() {
        int i = 0;
        Set<Character> keySet = htcode.keySet();
        for(Character key: keySet){
            String code = htcode.get(key);//获得键key对应的编码
            System.out.println(key + ": " + code);
            len[i++] = code.length();
        }

    }
    public int WPL() {//求WPL值
        int wpl = 0;
        for (int i = 0; i < n; i++) {
            wpl += ht[i].getWeight() * len[i];
        }
        return wpl;
    }
}
*/