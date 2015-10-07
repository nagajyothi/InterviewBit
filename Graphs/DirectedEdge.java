public class DirectedEdge
{
    private final int v; // edge source
    private final int w; // edge target
    private final int weight; // edge weight
    public DirectedEdge(int v, int w, int weight)
    {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }
    public int weight()
    { return weight; }
    public int from()
    { return v; }
    public int to()
    { return w; }
    public String toString()
    { return String.format("%d->%d %.2f", v, w, weight); }
}