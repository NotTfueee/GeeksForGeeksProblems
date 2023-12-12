package LinkedList;

//File Created by -- > anuragbhatt
//Created On -- > 19/11/23,Sunday

import java.util.HashMap;

public class IntersectionOfTwoSortedLinkedList {

    public static void main(String[] args) {

    }

    public static class Node
    {
        int data;
        Node next;

        Node(int data )
        {
            this.data = data;
            next = null;
        }
    }

    public static Node findIntersection(Node head1 , Node head2)
    {
        var map1 = new HashMap<Integer , Integer>();


        Node curr1 = head1 , curr2 = head2;

        while(curr1 != null)
        {
            map1.put(curr1.data , map1.getOrDefault(curr1.data , 0 ) + 1);
            curr1 = curr1.next;
        }

        Node dummy = new Node(-1);
        Node prev = dummy;

        while(curr2 != null)
        {
            if(map1.containsKey(curr2.data))
            {
                prev.next = new Node(curr2.data);
                prev = prev.next;

                int val = map1.get(curr2.data);

                if(val > 1)
                {
                    val--;
                    map1.put(curr2.data , val);
                }
                else map1.remove(curr2.data);

            }
            curr2 = curr2.next;
        }

        return dummy.next;

    }
}
