package Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test7 {
    public static void main(String[] args) {
        String numRegex = "^-?\\d+$|^-?\\d+[.]\\d+$";
        String positionNumRegex = "^\\d+$|^\\d+[.]\\d+$";
        String negativeNumRegex = "^-\\d+$|^-\\d+[.]\\d+$";
        Pattern numPattern = Pattern.compile(numRegex);

        Matcher m = numPattern.matcher("-5");
        System.out.println(m.matches());

        double num = Double.parseDouble("-5");
        System.out.println(num);

    }
}
