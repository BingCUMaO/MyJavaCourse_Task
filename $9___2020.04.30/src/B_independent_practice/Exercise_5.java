package B_independent_practice;


/**
 * 7.8.3 独立实践
 * <p>
 * 5、链式调用（选做题）
 * <p>
 * 修改Student类（不允许修改Student类中如下的2个属性
 * 和4个方法，只允许增加方法），以便可以使用如下链式
 * 样式创建Student对象
 *
 * Student student = Student.ofName("zs").setAge(24);
 *
 * //Student类：
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
 */
public class Exercise_5 {
    public static void main(String[] args) {
//        Student student = Student.ofName("zs").setAge(24);
    }

    private static class Student{
        private String name;
        private int age;

        private Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public static Student ofName(String name){
            return new Student(name, 0);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

    }
}


