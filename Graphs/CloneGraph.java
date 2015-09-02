/*
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 */
import java.util.*;
public class CloneGraph{
    HashMap<UndirectedGraphNode,UndirectedGraphNode> map;
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        map=new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        return auxCloneGraph(node);
    }
    public UndirectedGraphNode auxCloneGraph(UndirectedGraphNode node){
        if(node==null)
            return node;
        if(map.containsKey(node)){
            return map.get(node);
        }
        UndirectedGraphNode clone=new UndirectedGraphNode(node.label);
        map.put(node,clone);
        for(UndirectedGraphNode neighbor:node.neighbors){
            clone.neighbors.add(auxCloneGraph(neighbor));
        }
        return clone;
    }
    public static void main(String[] args){
    }
}