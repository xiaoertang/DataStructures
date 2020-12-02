package PrimAlgorithm;

import java.util.Arrays;

class Graph {
    int verxs;//结点个数
    char ch[];//存放值
    int weight[][];//存放边，

    public Graph(int verxs) {
        this.verxs = verxs;
        ch = new char[verxs];
        weight = new int[verxs][verxs];
    }
}

class GreatTree {
    //创建邻接矩阵

    /**
     * @param graph  图对象
     * @param verxs  结点个数
     * @param ch     各个节点的值
     * @param weight 边的权值
     */
    public void GreatGraph(Graph graph, int verxs, char ch[], int weight[][]) {
        for (int i = 0; i < verxs; i++) {
            graph.ch[i] = ch[i];
            for (int j = 0; j < verxs; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    public void showGraph(Graph graph) {
        for (int[] v : graph.weight) {
            System.out.println(Arrays.toString(v));
        }
    }

    //显示邻接矩阵
    public void showGraph(Graph graph, int verxs) {
        for (int i = 0; i < verxs; i++) {
            for (int j = 0; j < verxs; j++) {
                System.out.print(graph.weight[i][j] + ",");
            }
            System.out.println();
        }
    }
    //实现prim算法

    /**
     * @param graph 图
     * @param verxs 从第几个顶点开始生成最小树
     */
    public void PrimGraph(Graph graph, int verxs) {
        int visied[] = new int[graph.verxs];
        int minWeight = Integer.MAX_VALUE;
        int x = -1;
        int y = -1;
        visied[verxs] = 1;//表示已经访问
        for (int i = 1; i < graph.verxs; i++) {
            for (int j = 0; j < graph.verxs; j++) {
                for (int k = 0; k < graph.verxs; k++) {
                    if (visied[j] == 1 && visied[k] == 0 && graph.weight[j][k] < minWeight) {
                        minWeight = graph.weight[j][k];
                        x = j;
                        y = k;
                    }
                }
            }
            System.out.println("[" + graph.ch[x] + "," + graph.ch[y] + "]" + minWeight);
            minWeight = Integer.MAX_VALUE;
            visied[y] = 1;
        }
    }
}

public class Prim {
    public static void main(String[] args) {
        Graph graph = new Graph(6);
        char ch[] = new char[]{'a', 'b', 'c', 'd', 'e', 'f'};
        int weight[][] = new int[][]{{Integer.MAX_VALUE, 2, 5, 5, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {2, Integer.MAX_VALUE, 9, 4, 7, Integer.MAX_VALUE},
                {5, 9, Integer.MAX_VALUE, Integer.MAX_VALUE, 3, Integer.MAX_VALUE},
                {5, 4, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 6},
                {Integer.MAX_VALUE, 1, 3, Integer.MAX_VALUE, 7, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 6, 7, Integer.MAX_VALUE}

        };
        GreatTree greatTree = new GreatTree();

        greatTree.GreatGraph(graph, graph.verxs, ch, weight);
        greatTree.showGraph(graph);
        greatTree.PrimGraph(graph,0);
    }
}
