package 稀疏数组;

import java.util.Scanner;
/*
二维数组转稀疏数组的思路
1.遍历原始的二维数组，得到有效数据的个数
2.根据count就可以创建稀疏数组sArr int[count+1][3]
3.将二维数组的有效数据存入到系数数据
稀疏数组转原始二维数组的思路
1.先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，int Arr2[][]=new int[sArray[0][0]][sArray[0][1]];
2.在读取稀疏数组后几行的数据，并赋给原始二维数组即可：
  for (int i = 1; i < sArray.length; i++) {
            Arr2[sArray[i][0]][sArray[i][1]] = sArray[i][2];
        }
 */
public class sparseArray {
    public static void main(String[] args) {
        int n;//二维数组的大小
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        //创建二维数组并赋值
        int[][] Arr1 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arr1[i][j] = scanner.nextInt();
            }
        }
        int count = 0;//统计非零数的个数
        for (int[] row : Arr1) {
            for (int data : row) {
                if (data != 0) {
                    count++;
                }
            }
        }
        //将二维数组转换为稀疏数组
        int[][] sArray = new int[count + 1][3];
        sArray[0][0] = n;  //二维数组的行数
        sArray[0][1] = n;  //二维数组的列数
        sArray[0][2] = count;//二维数组中非零个数
        //遍历二维数组中的非零数
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Arr1[i][j] != 0) {
                    k++;
                    sArray[k][0] = i;//保存非零数所在行的位置
                    sArray[k][1] = j;//保存非零数所在列的位置
                    sArray[k][2] = Arr1[i][j];//保存非零数的值
                }
            }
        }

        System.out.println();
        System.out.println("输出稀疏数组的形式：");
        for (int i = 0; i < sArray.length; i++) {
            System.out.printf("%d\t%d\t%d\n", sArray[i][0], sArray[i][1], sArray[i][2]);
        }
        System.out.println();
        //将稀疏数组转换为二维数组
        int[][] Arr2 = new int[sArray[0][0]][sArray[0][1]];
        for (int i = 1; i < sArray.length; i++) {
            Arr2[sArray[i][0]][sArray[i][1]] = sArray[i][2];
        }
        //输出恢复后的二维数组
        System.out.println("输出二维数组的形式：");
        for(int [] row:Arr2){
            for(int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}
