import java.util.*;
public class EdgeWeightedDigraph
{
    private final int V; // number of vertices
    private int E; // number of edges
    private Bag<DirectedEdge>[] adj; // adjacency lists
    public EdgeWeightedDigraph(int V)
    {
        this.V = V;
        this.E = 0;
        adj = (Bag<DirectedEdge>[]) new Bag[V];
        for (int v = 0; v < V; v++)
            adj[v] = new Bag<DirectedEdge>();
    }
    public EdgeWeightedDigraph(ArrayList<Integer> A, ArrayList<Integer> B) {
        for(int i =0; i < A.size(); i++) {
            int v = i;
            int w = A.get(i);
            DirectedEdge e = new DirectedEdge(v, w, 0);
            addEdge(e);
        }
        for(int i =0; i < B.size(); i++) {
            int v = i;
            int w = B.get(i);
            DirectedEdge e = new DirectedEdge(v, w, 1);
            addEdge(e);
        }
    }
    public int V() { return V; }
    public int E() { return E; }
    public void addEdge(DirectedEdge e)
    {
        adj[e.from()].add(e);
        E++;
    }
    public Iterable<DirectedEdge> adj(int v)
    { return adj[v]; }
    public Iterable<DirectedEdge> edges()
    {
        Bag<DirectedEdge> bag = new Bag<DirectedEdge>();
        for (int v = 0; v < V; v++)
        for (DirectedEdge e : adj[v])
            bag.add(e);
        return bag;
    }
}