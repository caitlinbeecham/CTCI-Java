import java.util.EmptyStackException;
import java.util.ArrayList;

public class CTCICh4P2 {
    /**
     * @param args
     */
    public static ArrayList<Integer> iterativelyFindMidIdxs(int len) {
        int[] idxs = new int[len];
        for (int i = 0; i < len; i++) {
            idxs[i] = i;
        }
        int lo = 0;
        int hi = len;
        int mid = (lo+hi)/2;
        Queue queue = new Queue();
        int[] LoHiList = {lo,hi};
        queue.enqueue(LoHiList);
        ArrayList<Integer> ret = new ArrayList<Integer>();
        while (ret.size() < len) {
            int[] CurrentData = queue.dequeue();
            //KEEP WRITING HERE
            lo = CurrentData[0];
            hi = CurrentData[1];
            mid = (lo + hi)/2;
            if (!(ret.contains(mid))) {    
                ret.add(mid);
                int[] itm_to_enqueue_1 = {lo,mid};
                int[] itm_to_enqueue_2 = {mid,hi};
                queue.enqueue(itm_to_enqueue_1);
                queue.enqueue(itm_to_enqueue_2);
            }
        }
        return ret;
    }
    
    public static void printArrayListInt(ArrayList<Integer> list) {
        String str = "{";
        for (int i = 0; i < list.size()-1; i++) {
            str = str + list.get(i) + ", ";
        }
        str = str + list.get(list.size()-1) + "}";
        System.out.println(str);
    }
    
    
    public static Tree ConstructBST(int[] List) {
        //list is assumed to be sorted
        ArrayList<Integer> MidIdxs = iterativelyFindMidIdxs(List.length);
        int[] BSTList = new int[List.length];
        for (int i = 0; i < MidIdxs.size(); i++) {
            int idx = MidIdxs.get(i);
            int itm_to_add = List[idx];
            BSTList[i] = itm_to_add;
        }
        TreeNode root = new TreeNode(BSTList[0]);
        Tree t = new Tree(root);
        for (int i = 1; i < BSTList.length; i++) {
            int data = BSTList[i];
            TreeNode current = t.root;
            while (current != null) {
                if (data <= current.data) {
                    if (current.left == null) {
                        TreeNode new_node = new TreeNode(data);
                        current.left = new_node;
                        break;
                    } else {
                        current = current.left;
                    }
                }
                else {
                    if (current.right == null) {
                        TreeNode new_node = new TreeNode(data);
                        current.right = new_node;
                        break;
                    } else {
                        current = current.right;
                    }
                }
            }
        }
        return t;
    }
    
    public static void printInOrder(TreeNode t) {
        TreeNode current = t;
        if (current != null) {
            printInOrder(current.left);
            System.out.println(current.data);
            printInOrder(current.right);
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList<Integer> list0 = iterativelyFindMidIdxs(10);
        printArrayListInt(list0);
        int[] listy = {1,3,7,28,39,46,72,108};
        Tree t = ConstructBST(listy);
        printInOrder(t.root);
        
    }
    
}

class Queue {
    QueueNode head;
    QueueNode tail;
    public Queue() {
        this.head = null;
        this.tail = null;
    }
    
    public boolean isEmpty() {
        return (this.head == null);
    }
    
    public void enqueue(int[] data) {
        QueueNode new_node = new QueueNode(data);
        if (this.isEmpty()) {
            this.head = new_node;
            this.tail = new_node;
        }
        else {
            this.tail.next = new_node;
            this.tail = new_node;
        }
    }
    
    public int[] dequeue() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        else {
            int[] ret = this.head.data;
            if (this.head == this.tail) {
                this.head = null;
                this.tail = null;
            }
            else {
                this.head = this.head.next;
            }
            return ret;
        }
    }
}

class QueueNode {
    int[] data;
    QueueNode next;
    public QueueNode(int[] data) {
        this.data = data;
        this.next = null;
    }
}

class Tree {
    TreeNode root;
    public Tree(TreeNode root) {
        this.root = root;
    }
    
    public static ArrayList<Integer> iterativelyFindMidIdxs(int len) {
        int[] idxs = new int[len];
        for (int i = 0; i < len; i++) {
            idxs[i] = i;
        }
        int lo = 0;
        int hi = len;
        int mid = (lo+hi)/2;
        Queue queue = new Queue();
        int[] LoHiList = {lo,hi};
        queue.enqueue(LoHiList);
        ArrayList<Integer> ret = new ArrayList<Integer>();
        while (ret.size() < len) {
            int[] CurrentData = queue.dequeue();
            //KEEP WRITING HERE
            lo = CurrentData[0];
            hi = CurrentData[1];
            mid = (lo + hi)/2;
            if (!(ret.contains(mid))) {    
                ret.add(mid);
                int[] itm_to_enqueue_1 = {lo,mid};
                int[] itm_to_enqueue_2 = {mid,hi};
                queue.enqueue(itm_to_enqueue_1);
                queue.enqueue(itm_to_enqueue_2);
            }
        }
        return ret;
    }
    
    public static Tree ConstructBST(int[] List) {
        //list is assumed to be sorted
        ArrayList<Integer> MidIdxs = iterativelyFindMidIdxs(List.length);
        int[] BSTList = new int[List.length];
        for (int i = 0; i < MidIdxs.size(); i++) {
            int idx = MidIdxs.get(i);
            int itm_to_add = List[idx];
            BSTList[i] = itm_to_add;
        }
        TreeNode root = new TreeNode(BSTList[0]);
        Tree t = new Tree(root);
        for (int i = 1; i < BSTList.length; i++) {
            int data = BSTList[i];
            TreeNode current = t.root;
            while (current != null) {
                if (data <= current.data) {
                    if (current.left == null) {
                        TreeNode new_node = new TreeNode(data);
                        current.left = new_node;
                        break;
                    } else {
                        current = current.left;
                    }
                }
                else {
                    if (current.right == null) {
                        TreeNode new_node = new TreeNode(data);
                        current.right = new_node;
                        break;
                    } else {
                        current = current.right;
                    }
                }
            }
        }
        return t;
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
    
    public static void printInOrder(TreeNode t) {
        TreeNode current = t;
        if (current != null) {
            printInOrder(current.left);
            System.out.println(current.data);
            printInOrder(current.right);
        }
    }
}
