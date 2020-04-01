package Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test6 {
    public static void main(String[] args) {
        String numRegex = "^-?\\d+$|^-?\\d+[.]\\d+$";
        Pattern pattern = Pattern.compile(numRegex);
        Matcher m = pattern.matcher("235.2234234");
        System.out.println(m.matches());
    }
}
