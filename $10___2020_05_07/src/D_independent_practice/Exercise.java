package D_independent_practice;

import java.time.LocalDate;

/**
 * 独立实践
 *
 * 1、在Person类中，属性性别为一美剧类型Sex。
 *      定义Person类和枚举类Sex。
 *
 * 2、编写程序测试Person类。
 */
public class Exercise {
    public static void main(String[] args) {
        LocalDate birthday = LocalDate.now();
        Person person = new Person("法外狂徒张某三", birthday, Sex.FEMAN);


        System.out.println(person.getName());
        System.out.println(person.getBirthday());
        System.out.println(person.getSex());
    }


    private  static class   Person{
        private String name;
        private LocalDate birthday;
        private Sex sex;

        public Person() {
        }

        public Person(String name, LocalDate birthday, Sex sex) {
            this.name = name;
            this.birthday = birthday;
            this.sex = sex;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public LocalDate getBirthday() {
            return birthday;
        }

        public void setBirthday(LocalDate birthday) {
            this.birthday = birthday;
        }

        public Sex getSex() {
            return sex;
        }

        public void setSex(Sex sex) {
            this.sex = sex;
        }
    }

    private enum Sex{
        MAN,
        FEMAN
    }
}
