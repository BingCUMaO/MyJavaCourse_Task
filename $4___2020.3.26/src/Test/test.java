package Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    public static void main(String[] args) {
        String content = "My hOney";
        StringBuilder result = new StringBuilder();
        int len = content.length();

        //regEx
        String regex = "[aeiouAEIOU]";
        Pattern ptn = Pattern.compile(regex);
        Matcher matcher = null;

        for(int i  = 0;i<len;i++){
            char character = content.charAt(i);
            matcher = ptn.matcher(Character.toString(character));
            //If successfully matching, add "egg" to result String.
            if(matcher.matches()){
                result.append("egg");
            }
            result.append(character);
        }

        System.out.println(content);
        System.out.println(result);

    }
}
