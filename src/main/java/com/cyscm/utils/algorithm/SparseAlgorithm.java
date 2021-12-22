package com.cyscm.utils.algorithm;

/**
 * @author zhoutao
 */
public class SparseAlgorithm{
    public static void main(String[] args) {
        Sparse.sparseAlgo();
    }
}


class Sparse {

    /**
     * 实现稀疏算法
     * 1:首先将数组转成稀疏数组
     * 2:将稀疏数组还原
     */
    public static void sparseAlgo(){
        //1、定义数组
        int col = 11, row = 11;
        int[][] oldArray = new int[col][row];
        oldArray[1][2] = 1;
        oldArray[2][3] = 2;

        print(oldArray, "原始数组");

        //2:将数组转成稀疏数组
        //2.1:获取数组除0外有效数值
        int count = 0;
        for (int[] ints : oldArray) {
            for (int anInt : ints) {
                if (anInt > 0) {
                    count ++;
                }
            }
        }
        //2.2:定义稀疏数组
        int[][] sparseArr = new int[count + 1][3];
        sparseArr[0][0] = col;
        sparseArr[0][1] = row;
        sparseArr[0][2] = count;

        //todo 可以添加是否需要转稀疏数组判断
        //2.3:给稀疏数组设值
        int sum = 1;
        for (int i = 0; i < oldArray.length; i++) {
            int[] ints = oldArray[i];
            for (int i1 = 0; i1 < ints.length; i1++) {
                if (ints[i1] > 0) {
                    sparseArr[sum][0] = i;
                    sparseArr[sum][1] = i1;
                    sparseArr[sum][2] = ints[i1];
                    sum++;
                }
            }
        }
        print(sparseArr, "稀疏数组");

        //3、转原数组
        //3.1:定义新数组
        int[][] newArray = new int[sparseArr[0][0]][sparseArr[0][1]];
        //3.2:根据行和列直接赋值
        for (int i = 1; i < sparseArr.length; i++) {
            newArray[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        print(newArray, "新数组");
    }

    private static void print(int[][] sparseArr, String name) {
        //打印
        System.out.println(name);
        for (int[] ints : sparseArr) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t\t");
            }
            System.out.println();
        }
    }

}
