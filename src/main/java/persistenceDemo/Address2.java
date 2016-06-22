package persistenceDemo;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by Student on 22.06.2016.
 */
@Embeddable @Access(AccessType.FIELD)
public class Address2
{
    String street;
    String city;
    @Column(name="ZIP_CODE")
    String zip;

    public Address2() {
    }

    public Address2(String street, String city, String zip)
    {
        this.street = street;
        this.city = city;
        this.zip = zip;
    }
}
