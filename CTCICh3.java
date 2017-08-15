class CTCICh3 {
    public static void main(String[] args) {
        Stack myStack = new Stack();
    }
}

class Stack {
    StackNode top;
    public Stack() {
        this.top = top;
    }
    
    public void push(int data) {
        StackNode new_node = new StackNode(data);
        new_node.next = this.top;
        this.top = new_node;
    }
    
    public int pop() {
        if (this.top == null) {
            System.out.println("Stack Underflow Error!");
            return 0;
        }
        else {
            int top_data = this.top.data;
            this.top = this.top.next;
            return top_data;
        }
    }
    
    public int peek() {
        if (this.top == null) {
            System.out.println("Stack Underflow Error!");
            return 0;
        }
        else {
            return this.top.data;
        }
    }
    
    public boolean is_empty() {
        return (this.top == null);
    }
}

class StackNode {
    int data;
    StackNode next;
    public StackNode(int data) {
        this.data = data;
    }
}

class ThreeStacksThroughArray {
    int len;
    int[] array = new int[len];
    int bottom_idx1 = (int)(len/3.0)-1;
    int top_idx1;
    int bottom_idx2 = (int)((2*len)/3.0)-1;
    int top_idx2;
    int bottom_idx3 = len-1;
    int top_idx3;
    public ThreeStacksThroughArray(int len) {
        this.len = len;
        this.array = new int[len];
        this.bottom_idx1 = (int)(len/3.0);
        this.top_idx1 = this.bottom_idx1 - 1;
        this.bottom_idx2 = (int)((2*len)/3.0);
        this.top_idx2 = this.bottom_idx2-1;
        this.bottom_idx3 = len-1;
        this.top_idx3 = this.bottom_idx3-1;
    }
    
    public void push1(int data) {
        int new_top_idx1 = this.top_idx1 + 1;
        if (new_top_idx1 < this.bottom_idx2) {
            // we gucci, go ahead and push
            this.array[new_top_idx1] = data;
            this.top_idx1 = new_top_idx1;
        }
        else {
            //need to resize the whole damn thing
            int len_stack1 = bottom_idx2 - bottom_idx1;
            //need to actually move elements also
            this.len = this.len + len_stack1;
            int[] new_array = new int[this.len];
            for (int i = this.bottom_idx1; i < this.top_idx1 + 1; i++) {
                new_array[i] = this.array[i];
            }
            int new_idx;
            for (int i = this.bottom_idx2; i < this.top_idx2 + 1; i++) {
                new_idx = i + len_stack1;
                new_array[new_idx] = array[i];
            }
            for (int i = this.bottom_idx3; i < this.top_idx3 + 1; i++) {
                new_idx = i + len_stack1;
                new_array[new_idx] = array[i];
            }
            this.bottom_idx2 = this.bottom_idx2 + len_stack1;
            this.top_idx2 = this.top_idx2 + len_stack1;
            this.bottom_idx3 = this.bottom_idx3 + len_stack1;
            this.top_idx3 = this.top_idx3 + len_stack1;
            this.array = new_array;
            this.top_idx1 = new_top_idx1;
            this.array[this.top_idx1] = data;
        }
    }
    
    public void push2(int data) {
        int new_top_idx2 = this.top_idx2 + 1;
        if (new_top_idx2 < this.bottom_idx3) {
            // we gucci, go ahead and push
            this.array[new_top_idx2] = data;
            this.top_idx2 = new_top_idx2;
        }
        else {
            //need to resize the whole damn thing
            int len_stack2 = bottom_idx3 - bottom_idx2;
            //need to actually move elements also
            this.len = this.len + len_stack2;
            int[] new_array = new int[this.len];
            for (int i = this.bottom_idx1; i < this.top_idx1 + 1; i++) {
                new_array[i] = this.array[i];
            }
            
            for (int i = this.bottom_idx2; i < this.top_idx2 + 1; i++) {
                
                new_array[i] = array[i];
            }
            int new_idx;
            for (int i = this.bottom_idx3; i < this.top_idx3 + 1; i++) {
                new_idx = i + len_stack2;
                new_array[new_idx] = array[i];
            }
            this.bottom_idx3 = this.bottom_idx3 + len_stack2;
            this.top_idx3 = this.top_idx3 + len_stack2;
            this.array = new_array;
            this.top_idx2 = new_top_idx2;
            this.array[this.top_idx2] = data;
        }
        
    }
    
    public void push3(int data) {
        int new_top_idx3 = this.top_idx3 + 1;
        if (new_top_idx3 < this.len) {
            // we gucci, go ahead and push
            this.array[new_top_idx3] = data;
            this.top_idx3 = new_top_idx3;
        }
        else {
            int len_stack3 = this.len - bottom_idx3;
            //need to actually move elements also
            this.len = this.len + len_stack3;
            int[] new_array = new int[this.len];
            for (int i = this.bottom_idx1; i < this.top_idx1 + 1; i++) {
                new_array[i] = this.array[i];
            }
            
            for (int i = this.bottom_idx2; i < this.top_idx2 + 1; i++) {
                
                new_array[i] = array[i];
            }
            for (int i = this.bottom_idx3; i < this.top_idx3 + 1; i++) {
                new_array[i] = array[i];
            }
            this.array = new_array;
            this.top_idx3 = new_top_idx3;
            this.array[this.top_idx3] = data;
        }
    }
    
    public int pop1() {
        if (this.top_idx1 == this.bottom_idx1 - 1) {
            System.out.println("Stack1 underflow error!");
            return 0;
        }
        else {
            int itm_to_pop = this.array[this.top_idx1];
            //this.array[this.top_idx1] = null;
            this.top_idx1 = this.top_idx1 - 1;
            return itm_to_pop;
        }
    }
    
    public int pop2() {        
        if (this.top_idx2 == this.bottom_idx2 - 1) {
            System.out.println("Stack2 underflow error!");
            return 0;
        }
        else {
            int itm_to_pop = this.array[this.top_idx2];
            //this.array[this.top_idx2] = null;
            this.top_idx2 = this.top_idx2 - 1;
            return itm_to_pop;
        }
    }
    
    public int pop3() {
        if (this.top_idx3 == this.bottom_idx3 - 1) {
            System.out.println("Stack3 underflow error!");
            return 0;
        }
        else {
            int itm_to_pop = this.array[this.top_idx3];
            //this.array[this.top_idx3] = null;
            this.top_idx3 = this.top_idx3 - 1;
            return itm_to_pop;
        }
    }
    
    public int peek1() {
        if (this.top_idx1 == this.bottom_idx1 - 1) {
            System.out.println("Stack1 underflow error!");
            return 0;
        }
        else {
            return this.array[this.top_idx1];
        }
    }
    
    public int peek2() {
        if (this.top_idx2 == this.bottom_idx2 - 1) {
            System.out.println("Stack2 underflow error!");
            return 0;
        }
        else {
            return this.array[this.top_idx2];
        }
    }
    
    public int peek3() {
        if (this.top_idx3 == this.bottom_idx3 - 1) {
            System.out.println("Stack3 underflow error!");
            return 0;
        }
        else {
            return this.array[this.top_idx3];
        }
    }
    
    
}