package A_independent_practice;

import javax.swing.*;

/**
 * 4.9.2 独立实践
 *
 * 3、数据查询
 *
 * 有一个二维数值数组args ，我们希望查找其中的每一个数在
 * 另一个二维数值数组table 中是否出现以及首次出现的位置。
 * 写一程序完成这一任务。
 *
 * Tip：
 * public class TestBreak{
 *     public static void main(String[] args){
 *         String output = "";
 *         int[][] args = new int[][]{{2,66,1},{7,4,2},{77,6,1},{98,2,3}};
 *         int[][] table = new int[][] {{70,2},{3,4},{5,6},{2,8}};
 *
 *         for(int[] a : args){
 *             //...
 *             for(int n : a){
 *                 //...
 *             }
 *
 *             //...
 *         }
 *     }
 * }
 *
 */
public class Exercise_3 {

    public static void main(String[] args) {
        String output = "";
        int[][] arguments = new int[][]{{2, 66, 1}, {7, 4, 2}, {77, 6, 1}, {98, 2, 3}};
        int[][] table = new int[][]{{70, 2}, {3, 4}, {5, 6}, {2, 8}};

        Position positn = new Position(table);
        StringBuilder result = new StringBuilder();
        for (int[] a : arguments)
            for (int n : a)
                if(positn.find(n)){
                    result.append("找到" + n + "在[" + positn.getPositnRow() + "][" + positn.getPositnColumn() + "]位置\r\n");
                }else {
                    result.append("没有找到" + n + "\r\n");
                }


        JOptionPane.showMessageDialog(
                null,
                result.toString(),
                "",
                JOptionPane.PLAIN_MESSAGE
        );
    }

    public static class Position{
        private int[][] table;
        
        private int positnRow;
        private int positnColumn;

        public Position(int[][] table){
            this.table = table;

            this.positnRow = -1;
            this.positnColumn  = -1;
        }

        public boolean find(int num) {
            setPositnRow(-1);
            setPositnColumn(-1);

            int tableRow = table.length;
            int tableColumn = table[0].length;

            for (int r = 0; r < tableRow; r++)
                for (int c = 0; c < tableColumn; c++)
                    if (table[r][c] == num) {
                        setPositnRow(r);
                        setPositnColumn(c);
                        return true;
                    }


            return false;
        }


        private void setPositnRow(int positnRow) {
            this.positnRow = positnRow;
        }

        private void setPositnColumn(int positnColumn) {
            this.positnColumn = positnColumn;
        }

        public int getPositnRow() {
            return positnRow;
        }

        public int getPositnColumn() {
            return positnColumn;
        }
    }
}