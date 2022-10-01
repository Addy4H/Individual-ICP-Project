import java.util.*;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

/**
 * This class is responsible for finding the route from the source to the destination using the breadth first search
 * algorithm
 */
public class FindRoute {
    // retrieving access to attributes created in the FileReader class
    public HashMap<String, ArrayList<Route>> routeMap = FileReader.routeMap;
    public HashMap<String, ArrayList<Airport>> airportMap = FileReader.airportMap;
    public HashMap<String, String> airportCountryDict = FileReader.airportsToCountries;

    public HashMap<String, Airport> iataAirportDict = FileReader.iataToAirports;

    int pathCost = 0;
    public String source = FileReader.sourceInfo;
    public String destination = FileReader.destinationInfo;
    String inputFileName = FileReader.inputFile;


    /**
     * If the airport code of the current state is in the dictionary, then return true if the country and city of the current state
     * is the same as the destination country and city. Otherwise, return false
     *
     * @param state The current state of the search.
     * @return The goal state is being returned.
     */
    public boolean isGoal(Airport state){

        String airportCode = state.getIataCode();
        // making sure the route exists from the route file
        if (airportCountryDict.containsKey(airportCode))
            return airportCountryDict.get(airportCode).equals(destination);
        else {
            return false;
        }
    }

    /**
     * > Given an airport, return all the routes that originate from that airport
     *
     * @param state The current state of the search.
     * @return The actions that can be taken from the current state.
     */
    private ArrayList<Route> actions(Airport state){
        String key = state.getIataCode();
        // making sure the route exists from the route file
        ArrayList<Route> actions = new ArrayList<>();
        if(routeMap.containsKey(key))
            actions = routeMap.get(key);

        return actions;
    }


    /**
     * The function takes in a source airport and a destination airport and returns the shortest path between the two
     * airports
     *
     * @return The return value is an ArrayList of Route objects.
     */
    public ArrayList<Route> breadthFirstSearch() {
        Node node = null;
        Queue<Node> frontier = new LinkedList<>();

        // making sure the route exists from the route file
        if (airportCountryDict.containsValue(source)) {
            ArrayList<Airport> airports = airportMap.get(source);

            // for all available airports in the source city and country, create a root node (source airport)
            for (Airport airport: airports){
                frontier.add(new Node(airport));
            }
        }

        HashSet<Airport> explored = new HashSet<>();  // Node.state(airports) is stored here

        while(!frontier.isEmpty()){
            Node curr_node = frontier.remove();
            explored.add(curr_node.getState()); // after exploring a node, it is added to this set
            ArrayList<Route> actions = actions(curr_node.getState()); //possible routes that can be travelled from the airport

            for(Route route : actions){
                if(iataAirportDict.get(route.getDestinationAirportCode()) == null){
                    continue;
                }
                // generating child nodes (destination airports) if they exist
                Node childNode = new Node(iataAirportDict.get(route.getDestinationAirportCode()),
                        curr_node, route,curr_node.getPathCost()+1);

                if(!explored.contains(childNode.getState()) && !frontier.contains(childNode)){
                   //checking if the child Node is a goal once it is generated
                    if(isGoal(childNode.getState())){
                        pathCost = childNode.getPathCost();
                        return childNode.solutionPath(); // returns a list of route objects
                        }
                    // add child Node to the frontier to generate destination nodes
                    frontier.add(childNode);
                    }
                }
            }


        return new ArrayList<>(); // return empty list in case no solution is returned
    }

    /**
     * It takes the route path returned by the breadth first search function and writes it to a file
     */
    public void writeOutputToFile(){
        ArrayList<Route> routePath = breadthFirstSearch();
        PrintWriter output = null;
        String[] fileNameBreakdown = inputFileName.split("\\.");
        String outputFileName = fileNameBreakdown[0]+"_output."+fileNameBreakdown[1];  // creating output file name
        try{
            output = new PrintWriter(new FileOutputStream(outputFileName));
        }
        catch(FileNotFoundException fnfe){
            fnfe.printStackTrace();
            fnfe.getMessage();
        }
        if (!routePath.isEmpty()) {
            int totalStops = 0;
            int numList = 1;
            for (Route route: routePath){
                String airlineCode = route.getAirlineCode();
                String sourceCode = route.getSourceAirportCode();
                String destinationCode = route.getDestinationAirportCode();
                String stops = route.getStops();
                totalStops += Integer.parseInt(stops);
                String message = airlineCode + " from "+ sourceCode + " to " + destinationCode + " " + stops + " stops";
                output.println(String.valueOf(numList)+". "+ message);
                numList += 1;
            }
            output.println("Total flights: "+ pathCost);
            output.println("Total additional stops: "+ totalStops);
            output.println("Optimality criteria: flights");
        }
        else{
            System.out.println("No such route exists");
        }
        output.close();
    }



}
