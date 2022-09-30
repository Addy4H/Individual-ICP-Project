import java.util.Objects;

/**
 * @author Adelle Hasford
 * This class represents an airport
 */
public class Airport {
    private String airportId;
    private String name;
    private String city;
    private String country;
    private String iataCode;
    private String icaoCode;
    private double latitude;
    private double longitude;
    private int altitude;
    private String timezone;
    private String daylightSavingsTime;
    private String databaseTimeZone;
    private String type;
    private String sourceData;

    public Airport(String airportId,
                   String name,
                   String city,
                   String country,
                   String iataCode,
                   String icaoCode,
                   double latitude,
                   double longitude,
                   int altitude,
                   String timezone,
                   String daylightSavingsTime,
                   String databaseTimeZone,
                   String type,
                   String sourceData) {
        this.airportId = airportId;
        this.name = name;
        this.city = city;
        this.country = country;
        this.iataCode = iataCode;
        this.icaoCode = icaoCode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.timezone = timezone;
        this.daylightSavingsTime = daylightSavingsTime;
        this.databaseTimeZone = databaseTimeZone;
        this.type = type;
        this.sourceData = sourceData;
    }

    /**
     * This function returns the airportId of the airport
     *
     * @return The airportId
     */
    public String getAirportId() {
        return airportId;
    }

    /**
     * This function returns the city of the address
     *
     * @return The city variable is being returned.
     */
    public String getCity() {
        return city;
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

    @Override
    // A method that returns a string representation of the object.
    public String toString() {
        return "Airport{" +
                "airportId='" + airportId + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", iataCode='" + iataCode + '\'' +
                ", icaoCode='" + icaoCode + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", altitude=" + altitude +
                ", timezone=" + timezone +
                ", daylightSavingsTime='" + daylightSavingsTime + '\'' +
                ", databaseTimeZone='" + databaseTimeZone + '\'' +
                ", type='" + type + '\'' +
                ", sourceData='" + sourceData + '\'' +
                '}';
    }

    @Override
    // Comparing the object to another object.
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airports = (Airport) o;
        return Objects.equals(airportId, airports.airportId);
    }

    @Override
    // A method that returns a hash code value for the object.
    public int hashCode() {
        return Objects.hash(airportId);
    }
}
