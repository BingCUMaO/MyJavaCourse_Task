package B_independent_practice;

import java.io.*;

/**
 * 5.2.3 独立实践
 *
 * 4、
 *
 * 完成以下类的方法中的代码并测试这些方法。
 *
 * public class MyByteArrayInputStream{
 *
 *     //保存字节输入流数据的字节数组
 *     protected byte buf[];
 *     //下一个会被读取的字节的索引
 *     protected int pos;
 *     //字节流的长度
 *     protected int count;
 *
 *     //构造方法，创建一个内容为buf的字节流
 *     public MyByteArrayInputStream(byte buf1[]){
 *          //初始化“字节流对应的字节数组为buf”
 *          buf = buf1;
 *          //初始化“下一个要被服务的字节索引号为0”
 *          pos = 0;
 *          //初始化“字节流的长度为buf的长度”
 *          count = buf1.length;
 *     }
 *
 *     //读取下一个字节
 *     public int read(){
 *         //完成该方法
 *     }
 *
 *     //将“字节流buf的数据写入到字节数组b中”
 *     //off是“字节数组b的偏移地址”，表示从数组b的off开始写入数据
 *     //len是“写入的字节长度”
 *     public int read(byte b[], int off, int len){
 *         //完成该方法
 *     }
 *
 *     //“能否读取字节流的下一个字节”
 *     public int available(){
 *         //完成该方法
 *     }
 *
 * }
 *
 */
public class Exercise_4 {
    private static final int LEN = 10;

    public static void main(String[] args) throws Exception {

        //test int read()
        byte[] bs1 = "ABCD".getBytes();
        MyByteArrayInputStream mbais1 = new MyByteArrayInputStream(bs1);
        int temp;
        while (-1 != (temp =  mbais1.read())) {
            System.out.print((char)temp);
        }

        System.out.println();
        System.out.println("------------------------------------------------------");

        //test int read(byte b[], int off, int len)
        byte[] bs2 = "ABCD".getBytes();
        MyByteArrayInputStream mbais2 = new MyByteArrayInputStream(bs2);
        byte[] buffer = new byte[1024];
        int numOfRead = mbais2.read(buffer, 5, 20);
        System.out.println(numOfRead);
        for (byte b : buffer) {
            System.out.print(b);
        }

        System.out.println();
        System.out.println("------------------------------------------------------");

        //test int available()
        byte[] bs3 = "ABCD".getBytes();
        MyByteArrayInputStream mbais3 = new MyByteArrayInputStream(bs3);
        System.out.println(mbais3.available());
        mbais3.read();
        System.out.println(mbais3.available());
    }

    static class MyByteArrayInputStream {

        //保存字节输入流数据的字节数组
        protected byte buf[];
        //下一个会被读取的字节的索引
        protected int pos;
        //字节流的长度
        protected int count;

        //构造方法，创建一个内容为buf的字节流
        public MyByteArrayInputStream(byte buf1[]) {
            //初始化“字节流对应的字节数组为buf”
            buf = buf1;
            //初始化“下一个要被服务的字节索引号为0”
            pos = 0;
            //初始化“字节流的长度为buf的长度”
            count = buf1.length;
        }

        //读取下一个字节
        public int read() {
            if (pos < buf.length) {
                return (int)buf[pos++];
            }
            return -1;
        }

        //将“字节流buf的数据写入到字节数组b中”
        //off是“字节数组b的偏移地址”，表示从数组b的off开始写入数据
        //len是“写入的字节长度”
        public int read(byte b[], int off, int len) {
            if (off + len > b.length) {
                throw new IndexOutOfBoundsException();
            }

            int numOfRead = 0;
            for (int tick = off; tick < off + len; tick++) {
                if (pos >= buf.length)  break;

                b[tick] = buf[pos];
                pos++;
                numOfRead++;
            }

            return numOfRead;
        }

        //“能否读取字节流的下一个字节”
        public int available() {
            return buf.length - pos;
        }



    }

}
