import java.util.ArrayList;
import java.util.EmptyStackException;

class CTCICh4P1 {
    public static void main(String[] args) {
        GraphNode zero = new GraphNode(0);
        GraphNode one = new GraphNode(1);
        GraphNode two = new GraphNode(2);
        GraphNode three = new GraphNode(3);
        GraphNode four = new GraphNode(4);
        GraphNode five = new GraphNode(5);
        GraphNode six = new GraphNode(6);
        
        one.adjacent.add(three);
        one.adjacent.add(four);
        two.adjacent.add(five);
        two.adjacent.add(six);
        three.adjacent.add(one);
        three.adjacent.add(four);
        three.adjacent.add(five);
        four.adjacent.add(one);
        four.adjacent.add(three);
        five.adjacent.add(two);
        five.adjacent.add(three);
        six.adjacent.add(two);
        
        ArrayList<GraphNode> myNodes = new ArrayList<GraphNode>();
        myNodes.add(zero);
        myNodes.add(one);
        myNodes.add(two);
        myNodes.add(three);
        myNodes.add(four);
        myNodes.add(five);
        myNodes.add(six);
        
        Graph myGraph = new Graph(myNodes);
        myGraph.BFS(zero);
        System.out.println(myGraph.existsPathBetweenNodes(zero, five));
        System.out.println(myGraph.existsPathBetweenNodes(zero, zero));
        System.out.println(myGraph.existsPathBetweenNodes(four, five));
        System.out.println();
        System.out.println(myGraph.existsPathBetweenNodesBi(zero, five));
        System.out.println(myGraph.existsPathBetweenNodesBi(zero, zero));
        System.out.println(myGraph.existsPathBetweenNodesBi(four, five));
        
    }
}

class Graph {
    ArrayList<GraphNode> nodes;
    public Graph(ArrayList<GraphNode> nodes) {
        this.nodes = nodes;
    }
    
    public void BFS(GraphNode node) {
        GraphQueue queue = new GraphQueue();
        queue.enqueue(node);
        node.visited = true;
        while (!(queue.isEmpty())) {
            GraphNode current_node = queue.dequeue();
            for (GraphNode adj_node : current_node.adjacent) {
                if (adj_node.visited == false) {
                    adj_node.visited = true;
                    queue.enqueue(adj_node);
                }
            }
        }
    }
    
    public boolean existsPathBetweenNodes(GraphNode a, GraphNode b) {
        for (GraphNode node : this.nodes) {
            node.visited = false;
        }
        this.BFS(a);
        if (b.visited == true) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public static boolean arrayListsContainCommonNode(ArrayList<GraphNode> l1, ArrayList<GraphNode> l2) {
        for (GraphNode node1 : l1) {
            for (GraphNode node2 : l2) {
                if (node1 == node2) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean existsPathBetweenNodesBi(GraphNode a, GraphNode b) {
        GraphQueue queueA = new GraphQueue();
        ArrayList<GraphNode> visitedA = new ArrayList<GraphNode>();
        GraphQueue queueB = new GraphQueue();
        ArrayList<GraphNode> visitedB = new ArrayList<GraphNode>();
        queueA.enqueue(a);
        visitedA.add(a);
        queueB.enqueue(b);
        visitedB.add(b);
        while ((!(queueA.isEmpty())) && (!(queueB.isEmpty()))) {
            GraphNode nodeA = queueA.dequeue();
            for (GraphNode adjA : nodeA.adjacent) {
                if (!(visitedA.contains(adjA))) {
                    visitedA.add(adjA);
                    queueA.enqueue(adjA);
                }
            }
            GraphNode nodeB = queueB.dequeue();
            for (GraphNode adjB : nodeB.adjacent) {
                if (!(visitedB.contains(adjB))) {
                    visitedB.add(adjB);
                    queueB.enqueue(adjB);
                }
            }
            if (arrayListsContainCommonNode(visitedA,visitedB)) {
                return true;
            }   
        }
        while (!(queueA.isEmpty())) {
            GraphNode nodeA = queueA.dequeue();
            for (GraphNode adjA : nodeA.adjacent) {
                if (!(visitedA.contains(adjA))) {
                    visitedA.add(adjA);
                    queueA.enqueue(adjA);
                }
            }
            if (arrayListsContainCommonNode(visitedA,visitedB)) {
                return true;
            }   
        }
        while (!(queueB.isEmpty())) {
            GraphNode nodeB = queueB.dequeue();
            for (GraphNode adjB : nodeB.adjacent) {
                if (!(visitedB.contains(adjB))) {
                    visitedB.add(adjB);
                    queueB.enqueue(adjB);
                }
            }
            if (arrayListsContainCommonNode(visitedA,visitedB)) {
                return true;
            }   
        }
        return false;
    }
}

class GraphNode {
    int data;
    boolean visited;
    ArrayList<GraphNode> adjacent; 
    public GraphNode(int data) {
        this.visited = false;
        this.adjacent = new ArrayList<GraphNode>();
        this.data = data;
    }
}

class GraphQueue {
    GraphQueueNode head;
    GraphQueueNode tail;
    public GraphQueue() {
        this.head = null;
        this.tail = null;
    }
    
    public boolean isEmpty() {
        return (this.head == null);
    }
    
    public void enqueue(GraphNode node) {
        GraphQueueNode queueNode = new GraphQueueNode(node);
        if (this.isEmpty()) {
            this.head = queueNode;
            this.tail = queueNode;
        }
        else {   
            this.tail.next = queueNode;
            this.tail = queueNode;
        }
    }
    
    public GraphNode dequeue() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        else {
            GraphNode ret = this.head.node;
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

class GraphQueueNode {
    GraphNode node;
    GraphQueueNode next;
    public GraphQueueNode(GraphNode node) {
        this.node = node;
        this.next = null;
    }
    
}



