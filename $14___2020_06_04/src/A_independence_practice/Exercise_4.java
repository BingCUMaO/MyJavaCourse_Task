package A_independence_practice;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;

/**
 * 4、编写班级类，在班级类的对象中存储有该班所有的学生，要求可以对班
 * 级类的对象进行迭代，以输出它存储的一系列学生对象。
 *
 * 并编写程序测试班级类 。
 */
public class Exercise_4 {
    private static class Test{
        public static void main(String[] args) {
            Clazz clz = new Clazz();

            for (int i = 1; i <= 10; i++) {
                clz.add(new Student(i+"  ==> "+newRandomName()));
            }

//            Iterator iterator = clz.iterator();
//            while (iterator.hasNext()) {
//                System.out.println(((Student) iterator.next()).getName());
//            }

            for (Object o : clz) {
                System.out.println(((Student)o).getName());
            }
        }

        public static String newRandomName(){
            return UUID.randomUUID().toString().replace("-", "");
        }
    }

    private static class Clazz implements Iterable{
        private LinkedList list;

        public Clazz() {
            list = new LinkedList<Student>();
        }


        public int size() {
            return list.size();
        }

        public int indexOf(Student s) {
            return list.indexOf(s);
        }

        public Student get(int index) {
            return (Student)list.get(index);
        }

        public boolean add(Student s) {
            return list.add(s);
        }

        public void add(int index, Student element) {
            list.add(index, element);
        }

        public Student remove(int index) {
            return (Student)list.remove(index);
        }

        public boolean remove(Student s) {
            return list.remove(s);
        }


        @Override
        public Iterator iterator() {
            return new ClsItr();
        }

        private class ClsItr implements Iterator <Student>{
            private int cursor = -1;

            @Override
            public boolean hasNext() {
                return ++cursor!=list.size();
            }

            @Override
            public Student next() {
                return (Student) list.get(cursor);
            }
        }
    }

    private static class Student{
        private String name;

        public Student(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
