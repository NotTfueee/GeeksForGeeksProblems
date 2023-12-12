package Strings;

//File Created by -- > anuragbhatt
//Created On -- > 12/11/23,Sunday

public class CheckIfStringIsRotatedByTwoPlaces {

    public static void main(String[] args) {

        System.out.println(isRotated("amazon" , "azonam"));
    }

    public static boolean isRotated(String s1 , String s2)
    {if (s1.length() != s2.length()) return false;

        int n = s1.length();
        StringBuilder antiClockwise = new StringBuilder(n);
        StringBuilder clockwise = new StringBuilder(n);

        for (int i = 2; i < n; ++i) {
            antiClockwise.append(s1.charAt(i));
        }

        for (int i = 0; i < 2; ++i) {
            antiClockwise.append(s1.charAt(i));
        }

        for (int i = n - 2; i < n; ++i) {
            clockwise.append(s1.charAt(i));
        }

        for (int i = 0; i <= n - 1 - 2; ++i) {
            clockwise.append(s1.charAt(i));
        }

        return antiClockwise.toString().equals(s2) || clockwise.toString().equals(s2);

    }

//    approach 2 using O(1) space

    public static boolean opti(String s1 , String s2)
    {

        if(s1.length() != s2.length())return false;
        boolean isClock = true;
        boolean isAnti = true;

        int n = s1.length();

        /*
        for anti clock wise we would add the 2 characters from the start at the end of the string meaning the original string would have all the
        characters of the rotated string at +2 indices note ** we will check for rotated string **
         */
        for(int i = 0 ; i < n ;++i)
        {
            if(s2.charAt(i) != s1.charAt((i + 2 ) % n))
            {
                isAnti = false;
                break;
            }
        }

        /*
        for clock wise rotation we would be removing the character from the end and placing it at the front so the rotated string would have all the
        characters of the original string at +2 indices ** we will check for original string **
         */
        for(int i = 0 ; i < n ; ++i)
        {
            if(s1.charAt(i) != s2.charAt((i+2) % n))
            {
                isClock = false;
                break;
            }
        }

        return (isClock || isAnti);
    }
}
