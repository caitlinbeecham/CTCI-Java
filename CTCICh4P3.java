import java.util.EmptyStackException;
import java.util.ArrayList;

public class CTCICh4P3 {
    
    /**
     * @param args
     * make a method that takes in a binary tree and spits out an arraylist of linkedlists (one 
     * linkedlist for each level, left to right)
     * 
     * apparently the tree size method probably isn't working
     * need to fix that
     */
    public static void printArrayListInt(ArrayList<Integer> list) {
        String str = "{";
        for (int i = 0; i < list.size()-1; i++) {
            str = str + list.get(i) + ", ";
        }
        str = str + list.get(list.size()-1) + "}";
        System.out.println(str);
    }
    
    public static void printIntList(int[] list) {
        String str = "{";
        for (int i = 0; i < list.length - 1; i++) {
            str = str + list[i] + ", ";
        }
        str = str + list[list.length - 1] + "}";
        System.out.println(str);
    }
    
    public static Tree ConstructBST(int[] list) {
        //list is assumed to be sorted
        ArrayList<Integer> midIdxs = IterativelyFindMidIdxs(list.length);
        int[] BSTList = new int[list.length];
        for (int i = 0; i < midIdxs.size(); i++) {
            int idx = midIdxs.get(i);
            int itm_to_add = list[idx];
            BSTList[i] = itm_to_add;
        }
        TreeNode root = new TreeNode(BSTList[0]);
        Tree t = new Tree(root);
        for (int i = 1; i < BSTList.length; i++) {
            t = addBSTNode(t,BSTList[i]);
        }
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
    
    public static void printProblemAnswer(ArrayList<LinkedTreeList> answer) {
        String line = "{{";
        ListTreeNode current = answer.get(0).head;
        while (current.next != null) {
            line = line + current.data.data + ", ";
            current = current.next;
        }
        line = line + current.data.data + "},";
        System.out.println(line);
        for (int i = 1; i < answer.size()-1; i++) {
            line = "";
            current = answer.get(i).head;
            line = line + "{";
            while (current.next != null) {
                line = line + current.data.data + ", ";
                current = current.next;
            }
            line = line + current.data.data + "},";
            System.out.println(line);
        }
        line = "";
        current = answer.get(answer.size()-1).head;
        line = line + "{";
        while (current.next != null) {
            line = line + current.data.data + ", ";
            current = current.next;
        }
        line = line + current.data.data + "}" + "}";
        System.out.println(line);
    }
    
    public static void main(String[] args) {
        int[] list = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        Tree t = ConstructBST(list);
        ArrayList<LinkedTreeList> answer = t.returnLevelLists();
        printProblemAnswer(answer);
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

class ListNode {
    int[] data;
    ListNode next;
    public ListNode(int[] data) {
        this.data = data;
        this.next = null;
    }
}

class ListTreeNode {
    TreeNode data;
    ListTreeNode next;
    public ListTreeNode(TreeNode data) {
        this.data = data;
        this.next = null;
    }
}

class TreeQueueNode {
    TreeNode data;
    TreeQueueNode next;
    public TreeQueueNode(TreeNode data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    ListNode head;
    public LinkedList(ListNode head) {
        this.head = head;
    }
}

class LinkedTreeList {
    ListTreeNode head;
    public LinkedTreeList(ListTreeNode head) {
        this.head = head;
    }
    
    public void addAtEnd(TreeNode node) {
        ListTreeNode new_node = new ListTreeNode(node);
        ListTreeNode current = this.head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new_node;
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

class TreeQueue {
    TreeQueueNode head;
    TreeQueueNode tail;
    
    public TreeQueue() {
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
    
    public void enqueue(TreeNode data) {
        if (this.isEmpty()) {
            TreeQueueNode new_node = new TreeQueueNode(data);
            this.head = new_node;
            this.tail = new_node;
        }
        else {
            TreeQueueNode new_node = new TreeQueueNode(data);
            this.tail.next = new_node;
            this.tail = new_node;
        }
    }
    
    public TreeNode dequeue() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        else if (this.head == this.tail) {
            TreeNode ret = this.head.data;
            this.head = null;
            this.tail = null;
            return ret;
        }
        else {
            TreeNode ret = this.head.data;
            this.head = this.head.next;
            return ret;
        }
    }
    
    public void printTreeQueueElts() {
        TreeQueueNode current = this.head;
        while (current != null) {
            System.out.println(current.data.data);
            current = current.next;
        }
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
    
    public static void printInOrder(TreeNode node) {
        //usually the node fed in will be the root of a tree
        if (node != null) {
            printInOrder(node.left);
            System.out.println(node.data);
            printInOrder(node.right);
        }
    }
    
}

class Tree {
    TreeNode root;
    public Tree(TreeNode root) {
        this.root = root;
    }
    
    public int get_size() {
        TreeStack stack = new TreeStack();
        TreeNode current = this.root;
        int count = 0;
        while ((current != null) || (!(stack.isEmpty()))) {
            if (current != null) {
                stack.push(current);
                current = current.left;
                
            }
            else {
                //i.e. if (!(stack.isEmpty()))
                current = stack.pop();
                count = count + 1;
                current = current.right;
            }
        }
        return count;
        
    }
    
    
    public ArrayList<LinkedTreeList> returnLevelLists() {
        TreeQueue queue = new TreeQueue();
        ArrayList<TreeNode> NodesByLevel = new ArrayList<TreeNode>();
        queue.enqueue(this.root);
        boolean test = (NodesByLevel.size() < this.get_size());
        while (NodesByLevel.size() < this.get_size()) {
            TreeNode current = queue.dequeue();
            NodesByLevel.add(current);
            if (current.left != null) {
                queue.enqueue(current.left);
            }
            if (current.right != null) {
                queue.enqueue(current.right);
            }
        }
        ArrayList<LinkedTreeList> ret = new ArrayList<LinkedTreeList>();
        ListTreeNode rootNode = new ListTreeNode(NodesByLevel.get(0));
        LinkedTreeList level_0_list = new LinkedTreeList(rootNode);
        ret.add(level_0_list);
        if (this.get_size() > 2) {
            int level_start_idx = 1;
            int level_end_idx = 2;
            while (level_end_idx < NodesByLevel.size()) {
                ListTreeNode head_node = new ListTreeNode(NodesByLevel.get(level_start_idx));
                LinkedTreeList list_to_add = new LinkedTreeList(head_node);
                int diff = level_end_idx - level_start_idx + 1;
                for (int i = level_start_idx + 1; i < level_end_idx + 1; i++) {
                    list_to_add.addAtEnd(NodesByLevel.get(i));
                }
                diff = 2*diff - 1;
                level_start_idx = level_end_idx + 1;
                level_end_idx = level_start_idx + diff;
                if ((NodesByLevel.size() - 1 >= level_start_idx) && (NodesByLevel.size() - 1 < level_end_idx)) {
                    level_end_idx = NodesByLevel.size() - 1;
                }
                ret.add(list_to_add);
            }
        }
        return ret;
    }
    
}
