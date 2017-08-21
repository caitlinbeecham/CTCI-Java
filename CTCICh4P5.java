import java.util.ArrayList;
import java.util.EmptyStackException;


public class CTCICh4P5 {
    
    /**
     * write method to check if a binary tree is a bst
     * imma do it iteratively cause why the fuck not
     */
    public static Tree addBSTNode(Tree t, int data) {
        TreeNode current = t.root;
        while (current != null) {
            if (data <= current.data) {
                if (current.left == null) {
                    TreeNode new_node = new TreeNode(data);
                    current.left = new_node;
                    break;
                }
                else {
                    current = current.left;
                }
            }
            else {
                if (current.right == null) {
                    TreeNode new_node = new TreeNode(data);
                    current.right = new_node;
                    break;
                }
                else {
                    current = current.right;
                }
            }
        }
        return t;
    }
    
    public static Tree ConstructBST(int[] list) {
        //list is assumed to be sorted
        ArrayList<Integer> midIdxs = IterativelyFindMidIdxs(list.length);
        //System.out.println("Mids");
        //printArrayListInt(midIdxs);
        //System.out.println();
        int[] BSTList = new int[list.length];
        for (int i = 0; i < midIdxs.size(); i++) {
            int idx = midIdxs.get(i);
            int itm_to_add = list[idx];
            BSTList[i] = itm_to_add;
        }
        //System.out.println("BSTList");
        //printIntList(BSTList);
        //System.out.println();
        TreeNode root = new TreeNode(BSTList[0]);
        Tree t = new Tree(root);
        //System.out.println("a");
        //System.out.println();
        for (int i = 1; i < BSTList.length; i++) {
            t = addBSTNode(t,BSTList[i]);
            //System.out.println(i);
        }
        //System.out.println("for loop exited");
        return t;
        
    }
    
    public static ArrayList<Integer> IterativelyFindMidIdxs(int len) {
        int lo = 0;
        int hi = len;
        int[] LoHiList = {lo,hi};
        ArrayList<Integer> ret = new ArrayList<Integer>();
        Queue q = new Queue();
        q.enqueue(LoHiList);
        while (ret.size() < len) {
            int[] LoHiPair = q.dequeue();
            int Lo = LoHiPair[0];
            int Hi = LoHiPair[1];
            int Mid = (Lo + Hi)/2;
            if (!(ret.contains(Mid))) {
                ret.add(Mid);
                int[] LoHi1 = {Lo,Mid};
                int[] LoHi2 = {Mid,Hi};
                q.enqueue(LoHi1);
                q.enqueue(LoHi2);
            }
        }
        return ret;
    }
    
    public static boolean ValidateBST(Tree t) {
        TreeNode current  = t.root;
        TreeStack stack = new TreeStack();
        //stack.push(current);
        while ((!(stack.isEmpty())) || (current != null)) {
            if (current != null) {
                if ((current.left != null) && (current.data < current.left.data)) {
                    return false;
                }
                stack.push(current);
                current = current.left;
            }
            else {
                current = stack.pop();
                if ((current.right != null) && (current.data >= current.right.data)) {
                    return false;
                }
                current = current.right;
            }
        }
        return true;
        
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] listy = {1,2,5,9,17,18,21,37,89};
        Tree t = ConstructBST(listy);
        
        boolean answer = ValidateBST(t);
        System.out.println(answer);
    }
    
}

class ListNode {
    int[] data;
    ListNode next;
    public ListNode(int[] data) {
        this.data = data;
        this.next = null;
    }
}

class Queue {
    ListNode head;
    ListNode tail;
    
    public Queue() {
        this.head = null;
        this.tail = null;
    }
    
    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public void enqueue(int[] data) {
        if (this.isEmpty()) {
            ListNode new_node = new ListNode(data);
            this.head = new_node;
            this.tail = new_node;
        }
        else {
            ListNode new_node = new ListNode(data);
            this.tail.next = new_node;
            this.tail = new_node;
        }
    }
    
    public int[] dequeue() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        else if (this.head == this.tail) {
            int[] ret = this.head.data;
            this.head = null;
            this.tail = null;
            return ret;
        }
        else {
            int[] ret = this.head.data;
            this.head = this.head.next;
            return ret;
        }
    }
}

class Tree {
    TreeNode root;
    public Tree(TreeNode root) {
        this.root = root;
    }
}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class TreeStack {
    TreeStackNode top;
    public TreeStack() {
        this.top = null;
    }
    
    public boolean isEmpty() {
        if (this.top == null) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public void push(TreeNode node) {
        TreeStackNode new_node = new TreeStackNode(node);
        if (this.isEmpty()) {
            this.top = new_node;
        }
        else {
            new_node.next = this.top;
            this.top = new_node;
        }
    }
    
    public TreeNode pop() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        else {
            TreeNode ret = this.top.data;
            this.top = this.top.next;
            return ret;
        }
        
    }
}

class TreeStackNode {
    TreeNode data;
    TreeStackNode next;
    public TreeStackNode(TreeNode data) {
        this.data = data;
        this.next = null;
    }
}