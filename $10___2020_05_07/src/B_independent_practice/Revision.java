package B_independent_practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Revision {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        manager.setVisible(true);
    }




    private enum Sex {MAN, FEMAN}

    private static class StudentManager extends JFrame {
        private static final int COLUMN = 30;

        private ArrayList<Student> list;
        private int currentIndex = 0;

        private JLabel labelID;
        private JLabel labelName;
        private JLabel labelSex;
        private JLabel labelBirthdy;
        private JLabel labelAge;

        private JTextField tfID;
        private JTextField tfName;
        private JTextField tfBirthdyYear;
        private JTextField tfBirthdyMonth;
        private JTextField tfBirthdyDay;
        private JTextField tfAge;

        ButtonGroup bg;
        private JRadioButton rbSex1;
        private JRadioButton rbSex2;

        private JButton buttonFirst;
        private JButton buttonLast;
        private JButton buttonPre;
        private JButton buttonNext;
        private JButton buttonModify;
        private JButton buttonAdd;
        private JButton buttonRemove;

        {
            init();
            setConfigs();
            layoutPanel();
            registerEventHandler();

            pack();
        }

        public StudentManager() {
            list = new ArrayList<>();
        }

        public StudentManager(int capacity){
            list = new ArrayList<>(capacity);
        }

        public StudentManager(Student student) {
            this();
            list.add(student);
        }

        public StudentManager(ArrayList<Student> list) {
            this.list = list;
        }

        private void init(){
            labelID = new JLabel("学生ID");
            labelName = new JLabel("姓名");
            labelSex = new JLabel("性别");
            labelBirthdy = new JLabel("生日");
            labelAge = new JLabel("年龄");

            tfID = new JTextField();
            tfName = new JTextField();
            tfBirthdyYear = new JTextField();
            tfBirthdyMonth = new JTextField();
            tfBirthdyDay = new JTextField();
            tfAge = new JTextField();

            bg = new ButtonGroup();
            rbSex1 = new JRadioButton("男");
            rbSex2 = new JRadioButton("女");

            buttonFirst = new JButton("第一条");
            buttonLast = new JButton("最后一条");
            buttonPre = new JButton("上一条");
            buttonNext = new JButton("下一条");
            buttonModify = new JButton("修改");
            buttonAdd = new JButton("添加");
            buttonRemove = new JButton("删除");
        }

        private void setConfigs(){
            tfID.setColumns(COLUMN);
            tfName.setColumns(COLUMN);
            tfBirthdyYear.setColumns(COLUMN/3);
            tfBirthdyMonth.setColumns(COLUMN/3);
            tfBirthdyDay.setColumns(COLUMN/3);
            tfAge.setColumns(COLUMN);

            setTitle("学生信息管理程序");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        private void layoutPanel(){
            JPanel labelPanel = new JPanel(new GridLayout(0, 1));
            labelPanel.add(labelID);
            labelPanel.add(labelName);
            labelPanel.add(labelSex);
            labelPanel.add(labelBirthdy);
            labelPanel.add(labelAge);

            JPanel sexPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            sexPanel.add(rbSex1);
            sexPanel.add(rbSex2);
            bg.add(rbSex1);
            bg.add(rbSex2);

            JPanel birthPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JLabel labelBar1 = new JLabel("-");
            JLabel labelBar2 = new JLabel("-");
            birthPanel.add(tfBirthdyYear);
            birthPanel.add(labelBar1);
            birthPanel.add(tfBirthdyMonth);
            birthPanel.add(labelBar2);
            birthPanel.add(tfBirthdyDay);

            JPanel tfPanel = new JPanel(new GridLayout(0, 1));
            tfPanel.add(tfID);
            tfPanel.add(tfName);
            tfPanel.add(sexPanel);
            tfPanel.add(birthPanel);
            tfPanel.add(tfAge);

            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            buttonPanel.add(buttonFirst);
            buttonPanel.add(buttonLast);
            buttonPanel.add(buttonPre);
            buttonPanel.add(buttonNext);
            buttonPanel.add(buttonModify);
            buttonPanel.add(buttonAdd);
            buttonPanel.add(buttonRemove);

            JPanel topPanel = new JPanel(new BorderLayout());
            topPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            topPanel.add(labelPanel, BorderLayout.CENTER);
            topPanel.add(tfPanel, BorderLayout.EAST);

            JPanel panel = new JPanel(new BorderLayout());
            panel.add(topPanel, BorderLayout.CENTER);
            panel.add(buttonPanel, BorderLayout.SOUTH);

            this.getContentPane().add(panel);
        }

        private void registerEventHandler(){

            buttonAdd.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Student s = insertStudent();
                    if(s==null) return;

                    list.add(s);
                    toNewBlankPage();
                }
            });

            buttonModify.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (currentIndex == list.size()) {
                        buttonAdd.doClick();
                        return;
                    }

                    Student s = insertStudent();
                    if(s==null) return;

                    list.set(currentIndex, s);
                    toNewBlankPage();
                }
            });

            buttonRemove.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (currentIndex == list.size()) return;

                    list.remove(currentIndex);
                    if (currentIndex < list.size()) {
                        showTextByIndex();
                    } else {
                        clearTexts();
                    }
                }
            });

            buttonPre.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (currentIndex-1 >= 0) {
                        currentIndex--;
                        showTextByIndex();
                    }
                }
            });

            buttonNext.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (currentIndex+1<list.size()) {
                        currentIndex++;
                        showTextByIndex();
                    } else if (currentIndex + 1 == list.size()) {
                        currentIndex++;
                        clearTexts();
                    }
                }
            });

            buttonFirst.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    currentIndex=0;
                    showTextByIndex();
                }
            });

            buttonLast.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    currentIndex=list.size()-1;
                    showTextByIndex();
                }
            });
        }

        private Student insertStudent(){
            String regex = "^\\d+$";
            Pattern pattern = Pattern.compile(regex);

            String errorMsg = "内容为空或格式错误！";

            String id = tfID.getText();
            if (id.equals("")) {
                tfID.setText(errorMsg);
                return null;
            }

            String name = tfName.getText();
            if (name.equals("")) {
                tfName.setText(errorMsg);
                return null;
            }

            String birthYear = tfBirthdyYear.getText();
            if (!pattern.matcher(birthYear).matches()) {
                tfBirthdyYear.setText(errorMsg);
                return null;
            }

            String birthMonth = tfBirthdyMonth.getText();
            if (!pattern.matcher(birthMonth).matches()) {
                tfBirthdyMonth.setText(errorMsg);
                return null;
            }

            String birthDay = tfBirthdyDay.getText();
            if (!pattern.matcher(birthDay).matches()) {
                tfBirthdyDay.setText(errorMsg);
                return null;
            }

            String age = tfAge.getText();
            if (!pattern.matcher(age).matches()) {
                tfAge.setText(errorMsg);
                return null;
            }

            Sex sex = rbSex1.isSelected() ? Sex.MAN : rbSex2.isSelected() ? Sex.FEMAN : null;
            if(sex==null) return null;

            //防止输入输入的数字超过日期的范围
            LocalDate birth = null;
            try {
                birth = LocalDate.of(Integer.parseInt(birthYear), Integer.parseInt(birthMonth), Integer.parseInt(birthDay));
            } catch (Exception e) {
                tfBirthdyYear.setText(errorMsg);
                tfBirthdyMonth.setText(errorMsg);
                tfBirthdyDay.setText(errorMsg);
                return null;
            }

            return new Student(id, name, sex, birth, Integer.parseInt(age));
        }

        private void toNewBlankPage(){
            currentIndex = list.size();
            clearTexts();
        }

        private void clearTexts(){
            tfID.setText("");
            tfName.setText("");
            tfBirthdyYear.setText("");
            tfBirthdyMonth.setText("");
            tfBirthdyDay.setText("");
            tfAge.setText("");

            bg.clearSelection();
        }

        private void showTextByIndex(){
            tfID.setText(list.get(currentIndex).getId());
            tfName.setText(list.get(currentIndex).name);
            tfBirthdyYear.setText(String.valueOf(list.get(currentIndex).getBirthday().getYear()));
            tfBirthdyMonth.setText(String.valueOf(list.get(currentIndex).getBirthday().getMonthValue()));
            tfBirthdyDay.setText(String.valueOf(list.get(currentIndex).getBirthday().getDayOfMonth()));
            tfAge.setText(String.valueOf(list.get(currentIndex).getAge()));

            if (list.get(currentIndex).getSex() == Sex.MAN) {
                rbSex1.doClick();
            } else {
                rbSex2.doClick();
            }
        }













        public boolean putStudent(Student student) {
            if (student != null) {
                this.list.add(student);
                return true;
            } else return false;

        }

        public Student getStudentById(String id) {
            for (Student s : list)
                if (s.getId().equals(id)) return s;

            return null;
        }

        public boolean removeStudentById(String id) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId().equals(id)) {
                    list.remove(i);
                    return true;
                }
            }

            return false;
        }

        public Student removeStudent(int index){
            return list.remove(index);
        }

        public boolean removeStudent(Student tartget) {
            return list.remove(tartget);
        }

        public ArrayList<Student> getList() {
            return list;
        }

        public int length(){
            return list.size();
        }

        public void ensureCapacity(int minCapacity) {
            list.ensureCapacity(minCapacity);
        }

        public void clear(){
            list.clear();
        }

        public void  insertStudentInto(int index, Student value){
            list.add(index, value);
        }

        public boolean contains(Student tartget) {
            return list.contains(tartget);
        }

        public int indexOf(Student find) {
            return list.indexOf(find);
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
