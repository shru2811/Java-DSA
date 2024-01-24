import java.util.*;

//undirected - unweighted graph
public class Graph {
    private LinkedList<Integer> graph[];
    public Graph(int vertex){
        graph = new LinkedList[vertex];
        for(int i=0; i<vertex;i++){
            graph[i] = new LinkedList<Integer>();
        }
    }
    //works perfectly for the graphs that are connected
//    void bfs(int startNode){
//        Boolean visit[] = new Boolean[graph.length];
//        for(int i=0;i< graph.length;i++){
//            visit[i] = false;
//        }
//        Queue<Integer> q = new LinkedList<>();
//        q.add(startNode);
//        visit[startNode] = true;
//        while ((!q.isEmpty())){
//            int front = q.poll();
//            System.out.print(front+ " ");
//            for(int i:graph[front]){
//                if(visit[i] == false){
//                    q.add(i);
//                    visit[i] = true;
//                }
//            }
//        }
//    }

    //include disconnected graph
    void bfsutil(Boolean visit[],int startNode){
        Queue<Integer> q = new LinkedList<>();          //create a queue for storing the neighbours
        q.add(startNode);                               //add the first node given at the start to queue
        visit[startNode] = true;                        //mark that as visited node
        while ((!q.isEmpty())){
            int front = q.poll();                       //pull out front element of queue print it and then one by one store each neigbour of the node in the queue
            System.out.print(front+ " ");
            for(int i:graph[front]){
                if(visit[i] == false){
                    q.add(i);
                    visit[i] = true;
                }
            }
        }
    }
    void bfs(int startNode){
        Boolean visit[] = new Boolean[graph.length];
        for(int i=0;i< graph.length;i++){
            visit[i] = false;
        }
        for(int i=0;i<visit.length;i++){
            if(!visit[i]){
                bfsutil(visit,i);
            }
        }
    }
    void dfsUtil(Boolean[] visit, int startNode){
        Stack<Integer> stk = new Stack<>();
        stk.add(startNode);
        visit[startNode] = true;
        while(!stk.isEmpty()){
            int top = stk.pop();
            System.out.print(top+" ");
            for(int i:graph[top]){
                if(!visit[i]){
                    stk.add(i);
                    visit[i] = true;
                }
            }
        }
    }
    void dfs(int startNode){
        Boolean[] visit = new Boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            visit[i] = false;
        }
        for(int i=0;i<visit.length;i++){
            if(!visit[i]){
                dfsUtil(visit,i);
            }
        }
    }
    void insert(int src, int dest){
        graph[src].add(dest);
        graph[dest].add(src);
        System.out.println("insertion done");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertex: ");
        int v = sc.nextInt();
        System.out.println("Enter the number of edges: ");
        int e = sc.nextInt();
        Graph gp = new Graph(v);
        for(int i=0;i<e;i++){
            System.out.println("Enter the source: ");
            int src = sc.nextInt();
            System.out.println("enter the destination: ");
            int dest = sc.nextInt();
            gp.insert(src, dest);
        }
        gp.dfs(0);
    }
}