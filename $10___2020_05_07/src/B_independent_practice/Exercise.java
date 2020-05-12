package B_independent_practice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

/**
 * 独立实践7.10.3
 * <p>
 * 按照地址薄程序的结构，创建学生信息管理程序。
 * 学生的属性有学号，姓名，性别，出生日期，年龄。
 */
public class Exercise {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        int num = 20;
        for (int i = 0; i < num; i++) {
            manager.put(new Student(getId(), getName()));
        }

        for (Student s : manager.getList()) {
            System.out.println("[Debug]+++#Manager#---Output==>" + s);
        }
    }

    private static String getId(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    private static String getName(){
        String randomName = UUID.randomUUID().toString();
        StringBuilder result = new StringBuilder();

        int index = 0;
        while (index++ < randomName.length()-1) {
            if(Character.isLowerCase(randomName.charAt(index)))
                result.append(randomName.charAt(index));
        }

        return result.toString().toUpperCase();
    }

    private enum Sex {MAN, FEMAN}

    private static class StudentManager {
        private ArrayList<Student> list;

        public StudentManager() {
            list = new ArrayList<>();
        }

        public StudentManager(ArrayList<Student> list) {
            this.list = list;
        }

        public void put(Student student) {
            this.list.add(student);
        }

        public Student getById(String id) {
            for (Student s : list)
                if (s.getId().equals(id)) return s;

            return null;
        }

        public boolean removeById(String id) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId().equals(id)) {
                    list.remove(i);
                    return true;
                }
            }

            return false;
        }


        public ArrayList<Student> getList() {
            return list;
        }
    }


    private static class Student {
        private String id;
        private String name;
        private Sex sex;
        private LocalDate birthday;
        private int age;

        public Student(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public Student(String id, String name, Sex sex) {
            this.id = id;
            this.name = name;
            this.sex = sex;
        }

        public Student(String id, String name, Sex sex, LocalDate birthday, int age) {
            this.id = id;
            this.name = name;
            this.sex = sex;
            this.birthday = birthday;
            this.age = age;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Sex getSex() {
            return sex;
        }

        public void setSex(Sex sex) {
            this.sex = sex;
        }

        public LocalDate getBirthday() {
            return birthday;
        }

        public void setBirthday(LocalDate birthday) {
            this.birthday = birthday;
        }

        public void setBirthday(int year, int month, int day) {
            this.setBirthday(LocalDate.of(year, month, day));
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", sex=" + sex +
                    ", birthday=" + birthday +
                    ", age=" + age +
                    '}';
        }
    }
}
