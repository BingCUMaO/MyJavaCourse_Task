package Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test2 {
    public static void main(String[] args) {
        String regex = "^\\d+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher("12");
        System.out.println(matcher.matches());
    }
}
