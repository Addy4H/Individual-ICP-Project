/**
 * @author Adelle Hasford
 * This class represents an airline
 */
public class Airline {
    private String airlineId;
    private String name;
    private String alias;
    private String iataCode;
    private String icaoCode;
    private String callsign;
    private String country;
    private String active;

    public Airline(String airlineId,
                   String name,
                   String alias,
                   String iataCode,
                   String icaoCode,
                   String callsign,
                   String country,
                   String active) {
        this.airlineId = airlineId;
        this.name = name;
        this.alias = alias;
        this.iataCode = iataCode;
        this.icaoCode = icaoCode;
        this.callsign = callsign;
        this.country = country;
        this.active = active;
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
     * > This function returns the alias of the current user
     *
     * @return The alias of the object.
     */
    public String getAlias() {
        return alias;
    }

    /**
     * This function returns the IATA code of the airport
     *
     * @return The iataCode of the airport.
     */
    public String getIataCode() {
        return iataCode;
    }

    /**
     * This function returns the ICAO code of the airport
     *
     * @return The icaoCode
     */
    public String getIcaoCode() {
        return icaoCode;
    }

     /**
      * This function returns the country of the user
      *
      * @return The country variable is being returned.
      */
     public String getCountry() {
        return country;
    }

    /**
     * This function returns the value of the active variable
     *
     * @return The active variable is being returned.
     */
    public String getActive() {
        return active;
    }

    @Override
    // A function that returns a string representation of the object.
    public String toString() {
        return "Airline{" +
                "airlineId='" + airlineId + '\'' +
                ", name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                ", iataCode='" + iataCode + '\'' +
                ", icaoCode='" + icaoCode + '\'' +
                ", callsign='" + callsign + '\'' +
                ", country='" + country + '\'' +
                ", active='" + active + '\'' +
                '}';
    }
}
