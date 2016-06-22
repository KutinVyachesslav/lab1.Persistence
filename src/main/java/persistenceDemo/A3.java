package persistenceDemo;

import javax.persistence.*;
import java.util.Map;

/**
 * Created by Student on 22.06.2016.
 */
@Entity
public class A3
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;

    String text;

    @ElementCollection
    @CollectionTable(name="PHONE_NUM")
    @MapKeyColumn(name = "PHONE_TYPE")
    @Column(name = "PHONE_NUM")
    Map<String,String> phoneNumber;

    public A3()
    {
    }

    public A3(String text)
    {
        this.text = text;
    }

    public void addPhone(String type,String value)
    {
        phoneNumber.put(type,value);
    }

    @Override
    public String toString() {
        return "A3{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
