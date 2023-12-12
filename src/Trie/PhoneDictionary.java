package Trie;

//File Created by -- > anuragbhatt
//Created On -- > 09/12/23,Saturday

import java.util.ArrayList;

public class PhoneDictionary {

    public static void main(String[] args) {

        String[] contact = {"geeikistest", "geeksforgeeks",
                "geeksfortest"};
        System.out.println(displayContacts(contact.length , contact , "geeips"));
    }

    public static class Node
    {
        Node[] children;

        boolean isEnding;

        Node()
        {
            children = new Node[26];
        }
    }

    public static ArrayList<ArrayList<String>> displayContacts(int n , String[] contact , String s)
    {
        Node root = new Node();

        for(String c : contact)
        {
            insert(c , root);
        }

        ArrayList<ArrayList<String>> ans = new ArrayList<>();

        for(int i = 0 ; i < s.length() ; ++i)
        {
            var str = new ArrayList<String>();

            // for each substring we have to print the strings that start with that substring so we are finding the substrings
            String pre = s.substring(0, i + 1);

            findString(root , pre , str);

            ans.add(str);
        }

        return ans;
    }

    public static void findString(Node root , String pre , ArrayList<String> str)
    {

        /*
        we first check if there is a string that has a substring starting with pre if yes then we move forward if no we add
        0 to our str array list and return it from here only
         */

        Node curr = root;

        for(int i = 0 ; i < pre.length() ; ++i)
        {
            char ch = pre.charAt(i);

            if(curr.children[ch-'a'] == null)
            {
                str.add("0");
                return;
            }

            curr = curr.children[ch-'a'];
        }

        /*
        we will only reach here if there is a string with that starts with pre
        we will pass the curr node we are at and the pre string to find the remaining characters of the complete string
        which has pre as their starting
         */
        collectString(curr , pre , str);
    }

    public static void collectString(Node curr , String fullString , ArrayList<String> currentStringCollection)
    {

        // we check if the curr node we are at is an ending meaning that we have reached a word end and we add it to our collection
        if(curr.isEnding)
        {
            currentStringCollection.add(fullString);
        }

        /*
        now for the current node we will iterate through its all indexes and check if there is an index which is not null
        and contains a node if yes we will pass that node as our new root and will start recursion which will check all the conditions
         for that node and so on add also the current nodes character to the prefix string to complete the word
         */
        for(char c = 'a' ; c <= 'z' ; ++c)
        {
            Node next = curr.children[c-'a'];

            if(next != null)collectString(next , fullString + c , currentStringCollection);
        }
    }



    public static void insert(String word , Node root)
    {
        Node curr = root;

        for(int i = 0 ; i < word.length() ; ++i)
        {
            char ch = word.charAt(i);

            if(curr.children[ch-'a'] == null)curr.children[ch-'a'] = new Node();

            curr = curr.children[ch-'a'];
        }

        curr.isEnding = true;
    }
}
