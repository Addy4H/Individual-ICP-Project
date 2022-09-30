import java.util.ArrayList;
import java.util.Objects;
import java.util.Collections;

/**
 * @author Adelle Hasford
 * A node is an airport state, a parent node, a route action, and a path cost
 * Used for the search tree algorithm
 */
public class Node {
    private Airport state;
    private Node parent;
    private Route action;
    private int pathCost;

    // creates an instance for root nodes in the search tree
    public Node(Airport state) {
        this.state = state;
        this.parent = null;
        this.action = null;
        this.pathCost = 0;
    }

    public Node(Airport state, Node parent, Route action, int pathCost) {
        this.state = state;
        this.parent = parent;
        this.action = action;
        this.pathCost = pathCost;
    }

    @Override
    // Checking if the object is equal to the current object.
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(state, node.state);
    }

    /**
     * This function returns the sequence of routes that lead to the current node
     *
     * @return The solution path is being returned.
     */
    public ArrayList<Route> solutionPath(){
        ArrayList<Route> routeSeqeunce = new ArrayList<>();
        routeSeqeunce.add(this.action);
        Node sourceRoute = this.parent;
        while(sourceRoute.parent != null){
            routeSeqeunce.add(sourceRoute.action);
            sourceRoute = sourceRoute.parent;
        }
        Collections.reverse(routeSeqeunce);
        return routeSeqeunce;
    }

    @Override
    // A method that returns a string representation of the object.
    public String toString() {
        return "Node{" +
                "state=" + state +
                ", parent=" + parent +
                ", action=" + action +
                ", pathCost=" + pathCost +
                '}';
    }

    /**
     * > This function returns the state of the airport
     *
     * @return The state of the airport.
     */
    public Airport getState() {
        return state;
    }

    /**
     * Returns the parent of this node.
     *
     * @return The parent node of the current node.
     */
    public Node getParent() {
        return parent;
    }

    /**
     * This function returns the action of the route.
     *
     * @return The action of the route.
     */
    public Route getAction() {
        return action;
    }

    /**
     * This function returns the path cost of the current node
     *
     * @return The path cost of the node.
     */
    public int getPathCost() {
        return pathCost;
    }

    @Override
    // A method that returns a hash code value for the object.
    public int hashCode() {
        return Objects.hash(state);
    }
}
