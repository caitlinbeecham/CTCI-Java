import java.util.ArrayList;
import java.lang.Math;

//remove dups from an unsorted linkedlist
class CTCICh2P1 {
    public static void main(String[] args) {
        Node head = new Node(0);
        LinkedList my_list = new LinkedList(head);
        my_list.append(1);
        my_list.append(1);
        my_list.append(1);
        my_list.append(2);
        my_list.append(3);
        my_list.prepend(-1);
        my_list.prepend(-2);
        my_list.append(1);
        my_list.prepend(-3);
        System.out.println(my_list.size());
        System.out.println(my_list.is_empty());
        my_list.remove_dups();
        System.out.println(my_list.size());
        
        LinkedList list1 = new LinkedList(null);
        list1.prepend(6);
        list1.prepend(1);
        list1.prepend(7);
        LinkedList list2 = new LinkedList(null);
        list2.prepend(2);
        list2.prepend(9);
        list2.prepend(5);
        LinkedList answer = list1.sum_lists(list2);
        answer.print_elts();
        System.out.println();
        //System.out.println(answer.size());
    }
}

class LinkedList {
    Node head;
    public LinkedList(Node head) {
        this.head = head;
    }
    
    public void append(int data) {
        Node new_node = new Node(data);
        if (this.head == null) {
            this.head = new_node;
        }
        else {
            Node current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new_node;
        }
    }
    
    public void prepend(int data) {
        Node new_node = new Node(data);
        if (this.head != null) {
            new_node.next = this.head;
            this.head = new_node;
        }
        else {
            this.head = new_node;
        }
    }
    
    public boolean is_empty() {
        if (this.head == null) {
            return true;
        }
        return false;
    }
    
    public int size() {
        int count = 0;
        Node current = this.head;
        while (current != null) {
            count = count + 1;
            current = current.next;
        }
        return count;
    }
    
    public void remove_dups() {
        boolean broken = false;
        if (this.head == null) {
            
        }
        else {
            ArrayList<Integer> seen = new ArrayList<Integer>();
            Node current = this.head;
            seen.add(current.data);
            while (current.next != null) {
                //System.out.println(current.next.data);
                //System.out.println(current.next.next);
                if (!seen.contains(current.next.data)) {
                    seen.add(current.next.data);
                }
                else {
                    while (seen.contains(current.next.data)) {
                        if (current.next.next != null) {
                            current.next = current.next.next;
                        }
                        else {
                            current.next = null;
                            broken = true;
                            break;
                        }
                    }
                }
                if (broken == false) {
                    current = current.next;
                }
                else {
                    break;
                }
                //System.out.println(seen);
            } 
        }
    }
    
    public int return_data_k_from_end(int k) {
        int last_idx = this.size();
        int desired_idx = last_idx - k;
        int current_idx = 0;
        Node current = this.head;
        while (current_idx < desired_idx) {
            current = current.next;
            current_idx = current_idx + 1;
        }
        return current.data;
    }
    public LinkedList partition(int data) {
        LinkedList listless = new LinkedList(null);
        LinkedList listmore = new LinkedList(null);
        Node current = this.head;
        while (current != null) {
            if (current.data < data) {
                listless.prepend(current.data);
            }
            else {
                listmore.prepend(current.data);
            }
        }
        Node headless = listless.head;
        Node headmore = listmore.head;
        current = headless;
        while (current.next != null) {
            current = current.next;
        }
        current.next = headmore;
        return listless;
    }
    
    public boolean is_palindrome() {
        int len = this.size();
        int complement = 0;
        int[] array_w_data = new int[len];
        Node current = this.head;
        int idx = 0;
        while (current != null) {
            array_w_data[idx] = current.data;
            current = current.next;
            idx = idx + 1;
        }
        for (int i = 0; i < (int)(Math.floor(len/2.0)); i++) {
            complement = len - i;
            if (array_w_data[i] != array_w_data[complement]) {
                return false;
            }
        }
        return true;
    }
    
    public LinkedList sum_lists(LinkedList l2) {
        Node current1 = this.head;
        Node current2 = l2.head;
        System.out.println();
        System.out.println("head1:");
        System.out.println(current1);
        System.out.println("head2");
        System.out.println(current2);
        System.out.println();
        int tens_factor = 1;
        int sum = 0;
        int place_sum = 0;
        int digit = 0;
        int rem = 0;
        while ((current1 != null) && (current2 != null)) {
            place_sum = current1.data + current2.data + rem;
            digit = place_sum % 10;
            rem = (int)((place_sum - digit)/10.0);
            sum = sum + (tens_factor*digit);
            tens_factor = tens_factor * 10;
            current1 = current1.next;
            current2 = current2.next;
            System.out.println();
            System.out.println("place_sum:");
            System.out.println(place_sum);
            System.out.println("digit:");
            System.out.println(digit);
            System.out.println("tens_factor");
            System.out.println(tens_factor);
            System.out.println("sum");
            System.out.println(sum);
            System.out.println();
        }
        while (current1 != null) {
            place_sum = current1.data + rem;
            digit = place_sum % 10;
            rem = (int)((place_sum - digit)/10.0);
            tens_factor = tens_factor * 10;
            sum = sum + (tens_factor*digit);
            current1 = current1.next;
        }
        while (current2 != null) {
            place_sum = current2.data + rem;
            digit = place_sum % 10;
            rem = (int)((place_sum - digit)/10.0);
            tens_factor = tens_factor * 10;
            sum = sum + (tens_factor*digit);
            current2 = current2.next;
        }
        String string_sum = Integer.toString(sum);
        System.out.println();
        System.out.println("string_sum:");
        System.out.println(string_sum);
        System.out.println();
        char[] char_array_sum = string_sum.toCharArray();
        int char_int = 0;
        LinkedList ret = new LinkedList(null);
        for (int i = 0; i < char_array_sum.length; i++) {
            char_int = Character.getNumericValue(char_array_sum[i]);
            ret.prepend(char_int);
        }
        return ret;
    }
    
    public static boolean lists_intersect(LinkedList l1, LinkedList l2) {
        int len1 = l1.size();
        Node[] node_array_1 = new Node[len1];
        int len2 = l2.size();
        Node[] node_array_2 = new Node[len2];
        Node current1 = l1.head;
        int count1 = 0;
        while (current1 != null) {
            node_array_1[count1] = current1;
            current1 = current1.next;
            count1 = count1 + 1;
        }
        Node current2 = l2.head;
        int count2 = 0;
        while (current2 != null) {
            node_array_2[count2] = current2;
            current2 = current2.next;
            count2 = count2 + 1;
        }
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (node_array_1[i] == node_array_2[j]) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public Node loop_detection() {
        ArrayList<Node> seen_nodes = new ArrayList<Node>();
        Node current = this.head;
        while (current != null) {
            if (!seen_nodes.contains(current)) {
                seen_nodes.add(current);
            }
            else {
                return current;
            }
            current = current.next;
        }
        return null;
    }
    public void print_elts() {
        Node current = this.head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}

class Node {
    Node next;
    int data;
    public Node(int data) {
        this.data = data;
    }
}

