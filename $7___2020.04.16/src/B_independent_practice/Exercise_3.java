package B_independent_practice;


/**
 * 7.4.5 独立实践
 *
 * 3、链式风格
 *
 * 改写如下Student类，一边使用链式风格创建Student对象，
 * 例如：
 *
 * Student student = new Student()
 *                              .setAge(24)
 *                              .setName("zs");
 *
 * Student 类
 * public class Student{
 *     private String name;
 *     private int age;
 *
 *     public String getName() {
 *         return name;
 *     }
 *
 *     public void setName(String name) {
 *         this.name = name;
 *     }
 *
 *     public int getAge() {
 *         return age;
 *     }
 *
 *     public void setAge(int age) {
 *         this.age = age;
 *     }
 *
 * }
 *
 *
 */
public class Exercise_3 {
    public static void main(String[] args) {
         Student student = new Student().setAge(24).setName("zs");

        System.out.println(student.getName());
        System.out.println(student.getAge());

    }

    private static class Student{
        private String name;
        private int age;

        public Student() {
        }

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public Student setName(String name) {
            this.name = name;
            return this;
        }

        public int getAge() {
            return age;
        }

        public Student setAge(int age) {
            this.age = age;
            return this;
        }
    }

}


