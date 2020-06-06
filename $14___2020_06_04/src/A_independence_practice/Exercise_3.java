package A_independence_practice;

import java.util.Iterator;

/**
 * 3、修改如下ListArray类，使用户可以对ListArray对象进行迭代。
 *
 * 并编写测试代码对ListArray对象进行迭代。
 *
 * public class ListArray{
 *     private int maxSize;
 *     private int listSize;
 *     private Object[] listArray;
 *     //Maximum size of list
 *     //Array holding list element
 *
 *     ListArray(int size){
 *         maxSize = size;
 *         listSize = 0;
 *         listArray = new Object[size];    //create listArray
 *     }
 *
 *     public void clear(){     //Reinitialine the list
 *         listSize = 0;            //Simply reinitialize value
 *     }
 *
 *     //Append "it" to list
 *     public void add(Object it){
 *         listArray[listSize++] = it;
 *     }
 *
 *     //return list size
 *     public int length(){
 *         return listSize;
 *     }
 *
 *     public Object get(int i){
 *         return listArray[i];
 *     }
 *
 * }
 */
public class Exercise_3 {
    private static class Test{
        public static void main(String[] args) {
            ListArray la = new ListArray(20);

            for (int i = 1; i <= 10; i++) {
                la.add("XX" + i);
            }

//            Iterator iterator = la.iterator();
//            while (iterator.hasNext()) {
//                System.out.println((String) iterator.next());
//            }

            for (Object o : la) {
                System.out.println((String)o);
            }


        }
    }


      private static class ListArray implements Iterable{

          private int maxSize;
          private int listSize;
          private Object[] listArray;
          //Maximum size of list
          //Array holding list element

          ListArray(int size){
              maxSize = size;
              listSize = 0;
              listArray = new Object[size];    //create listArray
          }

          public void clear(){     //Reinitialine the list
              listSize = 0;            //Simply reinitialize value
          }

          //Append "it" to list
          public void add(Object it){
              listArray[listSize++] = it;
          }

          //return list size
          public int length(){
              return listSize;
          }

          public Object get(int i){
              return listArray[i];
          }

          @Override
          public Iterator iterator() {
              return new arrItr();
          }

          private class arrItr implements Iterator {
              private int cursor = -1;

              public arrItr() {
              }

              @Override
              public boolean hasNext() {
                  return cursor+1 !=  listSize;
              }

              @Override
              public Object next() {
                  return ListArray.this.get(++cursor);
              }
          }
      }

}
