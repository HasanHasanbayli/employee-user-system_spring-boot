package employe;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Location.findAll", query = "SELECT 1 FROM Location 1"),
        @NamedQuery(name = "Location.findDepartmentById", query = "SElECT 1 FROM Location 1 " +
                "LEFT OUTER JOIN FETCH 1.departments WHERE 1.locationId = :locationId")
})

public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "location_id", nullable = false, unique = true)
    private long locationId;

    @Column(length = 25)
    private String streetAddress;

    @Column(name = "postalCode")
    private int postalCode;

    private String city;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "location")
    private List<Department> departments;

    public Location() {
    }

    public Location(String streetAddress, int postalCode, String city) {
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
        this.city = city;
    }

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;

        Location location = (Location) o;

        return locationId == location.locationId;
    }

    @Override
    public int hashCode() {
        return (int) (locationId ^ (locationId >>> 32));
    }
}