package Strings;

//File Created by -- > anuragbhatt
//Created On -- > 14/11/23,Tuesday

public class CheckIfTheStringsAreRotationOfEachOther {

    public static void main(String[] args) {

        System.out.println(areRotation("mightandmagic" , "andmagicmigth"));
    }

    public static boolean areRotation(String s1 , String s2)
    {
        if(s1.length() != s2.length())return false;

        String combined = s1 + s1;

        for(int i = 0 ; i < combined.length() ; ++i)
        {
            char item = combined.charAt(i);

            if(s2.charAt(0) == item &&  i + s2.length() < combined.length())
            {
                String sub = combined.substring(i , i + s2.length());
                if(sub.equals(s2))return true;
            }

        }

        return false;
    }

}
