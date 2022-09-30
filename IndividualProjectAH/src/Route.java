/**
 * @author Adelle Hasford
 * This class represents a route between two airports
 */
public class Route {
    private String airlineCode;
    private String airlineId;
    private String sourceAirportCode;
    private String sourceAirportId;
    private String destinationAirportCode;
    private String destinationAirportId;
    private String codeshare;
    private String stops;
    private String equipment;

    public Route(String airlineCode,
                 String airlineId,
                 String sourceAirportCode,
                 String sourceAirportId,
                 String destinationAirportCode,
                 String destinationAirportId,
                 String codeshare,
                 String stops,
                 String equipment) {
        this.airlineCode = airlineCode;
        this.airlineId = airlineId;
        this.sourceAirportCode = sourceAirportCode;
        this.sourceAirportId = sourceAirportId;
        this.destinationAirportCode = destinationAirportCode;
        this.destinationAirportId = destinationAirportId;
        this.codeshare = codeshare;
        this.stops = stops;
        this.equipment = equipment;
    }

    /**
     * This function returns the airline code of the flight
     *
     * @return The airline code.
     */
    public String getAirlineCode() {
        return airlineCode;
    }

    /**
     * This function returns the airlineId of the flight
     *
     * @return The airlineId is being returned.
     */
    public String getAirlineId() {
        return airlineId;
    }

    /**
     * This function returns the source airport code
     *
     * @return The sourceAirportCode is being returned.
     */
    public String getSourceAirportCode() {
        return sourceAirportCode;
    }

    /**
     * This function returns the source airport id
     *
     * @return The sourceAirportId
     */
    public String getSourceAirportId() {
        return sourceAirportId;
    }

    /**
     * This function returns the destination airport code
     *
     * @return The destination airport code.
     */
    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    /**
     * This function returns the destination airport id
     *
     * @return The destinationAirportId
     */
    public String getDestinationAirportId() {
        return destinationAirportId;
    }

    /**
     * This function returns the stops variable
     *
     * @return The stops variable is being returned.
     */
    public String getStops() {
        return stops;
    }


    @Override
    // A method that returns a string representation of the object.
    public String toString() {
        return "Route{" +
                "airlineCode='" + airlineCode + '\'' +
                ", airlineId='" + airlineId + '\'' +
                ", sourceAirportCode='" + sourceAirportCode + '\'' +
                ", sourceAirportId='" + sourceAirportId + '\'' +
                ", destinationAirportCode='" + destinationAirportCode + '\'' +
                ", destinationAirportId='" + destinationAirportId + '\'' +
                ", codeshare='" + codeshare + '\'' +
                ", stops='" + stops + '\'' +
                ", equipment='" + equipment + '\'' +
                '}';
    }
}
