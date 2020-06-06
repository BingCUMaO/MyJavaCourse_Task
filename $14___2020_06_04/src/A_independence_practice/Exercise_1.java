package A_independence_practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

/**
 * 独立实践 9.4.6
 *
 * 1、创建PersonList类，PersonList对象可储存一系列Person类的对象，要求
 * 可以对PersonList的对象进行迭代，以输出它存储的一系列对象。
 * 并编写程序测试PersonList类。
 *
 */
public class Exercise_1 {
    private static class Test{
        public static void main(String[] args) {
            PersonList plist = new PersonList(20);
            for (int i = 1; i <= 6; i++) {
                plist.add(new Person(i+" ==> "+newRandomName()));
            }

            System.out.println("size:"+plist.size());
//            Iterator plistItr = plist.iterator();
//            while (plistItr.hasNext()) {
//                System.out.println(((Person)plistItr.next()).getName());
//            }

            for (Object o : plist) {
                System.out.println(((Person)o).getName());
            }

        }

        public static String newRandomName(){
            return UUID.randomUUID().toString().replace("-", "");
        }
    }

    private static class PersonList implements Iterable{
        private ArrayList list;

        public PersonList() {
            list = new ArrayList<Person>();
        }

        public PersonList(int capicity){
            list = new ArrayList<Person>(capicity);
        }

        
        public int size() {
            return list.size();
        }

        
        public int indexOf(Person o) {
            return list.indexOf(o);
        }

        
        public Person get(int index) {
            return (Person)list.get(index);
        }

        
        public boolean add(Person o) {
            return list.add(o);
        }

        
        public void add(int index, Person element) {
            list.add(index, element);
        }

        
        public Person remove(int index) {
            return (Person)list.remove(index);
        }

        
        public boolean remove(Person o) {
            return list.remove(o);
        }

        @Override
        public Iterator iterator() {
//            return list.iterator();
            return new ListItr();
        }

        private class ListItr implements Iterator<Person>{
            private int cursor = -1;

            public ListItr() {
            }

            
            public boolean hasNext() {
                return cursor+1 != list.size();
            }

            
            public Person next() {
                return (Person)list.get(++cursor);
            }
        }
    }

    static class Person{
        private String name;

        public Person() {
        }

        public Person(String name) {
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


