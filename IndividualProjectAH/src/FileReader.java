import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

/**
 * @author Adelle Hasford
 * This class takes an input file, an airport file, a route file and an airline file and reads the data from them
 * For the first, values are stored in String variables
 * For the latters, objects are created for most records
 */
public class FileReader {
    static HashMap<String, ArrayList<Airport>> airportMap = new HashMap<>();
    static HashMap<String, ArrayList<Airline>> airlineMap = new HashMap<>();
    static HashMap<String, ArrayList<Route>> routeMap = new HashMap<>();
    // maps the airport IATA code to its city, country
    static HashMap<String, String> airportsToCountries = new HashMap<>();
    // maps the airport IATA code to their unique airport objects
    static HashMap<String, Airport> iataToAirports = new HashMap<>();
    static String sourceInfo;
    static String destinationInfo;

    static Scanner inputStream = null;

    static String inputFile;
    private String airportFile;
    private String airlineFile;
    private String routeFile;

    public FileReader(String inputFile, String airportFile, String airlineFile, String routeFile) {
        this.inputFile = inputFile;
        this.airportFile = airportFile;
        this.airlineFile = airlineFile;
        this.routeFile = routeFile;
    }


    /**
     * This function reads the route file and creates a hashmap of routes with the key being the source Airport code
     */
    private void readRoutes(){
        Route route;
        try{
            inputStream = new Scanner(new FileInputStream(routeFile));
        }
        catch (FileNotFoundException fnfe){
            fnfe.printStackTrace();
            fnfe.getMessage();
        }

        while(inputStream.hasNextLine()){
            String[] line= inputStream.nextLine().split(",");
            if (line.length == 9) {
                route = new Route(line[0], line[1],
                        line[2], line[3], line[4],
                        line[5], line[6],
                        line[7], line[8]);

                String routeKey = line[2];


                if (routeMap.containsKey(routeKey)) {
                    routeMap.get(routeKey).add(route);
                } else {
                    routeMap.put(routeKey, new ArrayList<Route>());
                    routeMap.get(routeKey).add(route);
                }
            }
        }

    }




    /**
     * The function reads the airport file and creates a hashmaps of airport objects with the key being the airport country and
     * city name, with the value being an array of airport objects
     * Also creates a hashmap mapping airport IATA codes to airport objects and one mapping IATA codes to the city and country name
     */
    private void readAirports() {
        Airport airport;
        try{
            inputStream = new Scanner(new FileInputStream(airportFile));
        }
        catch (FileNotFoundException fnfe){
            fnfe.printStackTrace();
            fnfe.getMessage();
        }

        while (inputStream.hasNextLine()){
            String[] line= inputStream.nextLine().split(",");
            if (line.length == 14) {
                airport = new Airport(line[0], line[1],
                        line[2], line[3], line[4],
                        line[5], Double.parseDouble(line[6]),
                        Double.parseDouble(line[7]), Integer.parseInt(line[8]),
                        line[9], line[10],
                        line[11], line[12], line[13]);

                String airportKey = line[2]+ ", "+line[3];

                // measure to check if the IATA code exists for the airport. If not, ignore it
                String acdKey = line[4];
                if(acdKey != "\\N") {
                    airportsToCountries.put(acdKey, airportKey);
                    iataToAirports.put(acdKey, airport);
                }
                // placing the
                if (airportMap.containsKey(airportKey)) {
                    airportMap.get(airportKey).add(airport);
                } else {
                    airportMap.put(airportKey, new ArrayList<Airport>());
                    airportMap.get(airportKey).add(airport);
                }
            }
        }

    }


    /**
     * This function reads the airline file and creates a hashmap of airline objects where the key is the country and
     * the values are an array of airline objects
     */
    private void readAirlines(){
        Airline airline;
        try{
            inputStream = new Scanner(new FileInputStream(airlineFile));
        }
        catch (FileNotFoundException fnfe){
            fnfe.printStackTrace();
            fnfe.getMessage();
        }

        while (inputStream.hasNextLine()){
            String[] line= inputStream.nextLine().split(",");
            if (line.length == 8) {
                airline = new Airline(line[0], line[1],
                        line[2], line[3], line[4],
                        line[5], line[6],
                        line[7]);

                String airlineKey = line[6];


                if (airlineMap.containsKey(airlineKey)) {
                    airlineMap.get(airlineKey).add(airline);
                } else {
                    airlineMap.put(airlineKey, new ArrayList<Airline>());
                    airlineMap.get(airlineKey).add(airline);
                }
            }
        }

    }



    /**
     * This function reads the input file and stores the source and destination information in the sourceInfo and
     * destinationInfo variables
     */
    private void readInputFile(){
        try{
            inputStream = new Scanner(new FileInputStream(inputFile));
        }
        catch (FileNotFoundException fnfe){
            fnfe.printStackTrace();
            fnfe.getMessage();
        }
        sourceInfo = inputStream.nextLine();
        destinationInfo = inputStream.nextLine();
    }

    /**
     * This function reads all the files needed for the program to run
     */
    public void readAllFiles(){
        readRoutes();
        readAirports();
        readAirlines();
        readInputFile();
    }

}
