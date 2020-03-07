package A_independent_practice;


import javax.swing.*;

/**
 * 2.3.9    独立实践
 *
 * 1、库存统计
 *
 * 某大学书店收到几箱教材。在一批教材中，每箱教材的数量是相同的。
 * 仓库管理员希望使用一台计算机来计算书店收到的每批教材的总数量。
 * 仓库管理员会输入一批教材中箱子的数目及每只箱子中所存放教材的固
 * 定数目，然后改应用程序将计算并显示出这批教材的数目。
 */
public class Exercise_1 {
    private static final String CRLF = "\r\n";

    public static void main(String[] args) {

        Box box  = new Box();
        String title = "Inventory Counter";

        box.setSizeOfBoxs(Integer.parseInt(showInputDialog("The number of box:", title)));
        box.setSizeOfBook(Integer.parseInt(showInputDialog("The number of books:", title)));

        showMessageDialog(
                "The total of Books:"+CRLF+box.getSizeOfAllBooks(),
                title
        );

    }



    static String showInputDialog(String message,String title){
        return JOptionPane.showInputDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
    }

    static void showMessageDialog(String message,String title){
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
    }



    static class Box{
        private int sizeOfBook;
        private int sizeOfBox;

        public Box(){
            this.sizeOfBook = 0;
            this.sizeOfBox = 0;
        }

        public int getSizeOfAllBooks(){
            return sizeOfBook*sizeOfBox;
        }

        public int getSizeOfBoxs() {
            return sizeOfBox;
        }

        public void setSizeOfBoxs(int sizeOfBoxs) {
            if(sizeOfBoxs<0){
                this.sizeOfBox = -1;
            }else{
                this.sizeOfBox = sizeOfBoxs;
            }
        }

        public int getSizeOfBook() {
            return sizeOfBook;
        }

        public void setSizeOfBook(int sizeOfBook) {
            if(sizeOfBox<0){
                this.sizeOfBox = -1;
            }else{
                this.sizeOfBook = sizeOfBook;
            }
        }


    }
}

