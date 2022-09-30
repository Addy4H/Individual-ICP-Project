public class Main {
    public static void main(String[] args) {
        FileReader file = new FileReader("accra-winnipeg.txt", "airports.csv",
                "airlines.csv", "routes.csv");
        file.readAllFiles();
//        System.out.println(file.routeMap);
        FindRoute routeFinder = new FindRoute();
        routeFinder.writeOutputToFile();


    }

}