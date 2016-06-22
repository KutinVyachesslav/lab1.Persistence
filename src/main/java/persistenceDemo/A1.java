package persistenceDemo;

import javax.persistence.*;

/**
 * Created by Student on 22.06.2016.
 */
@Entity
public class A1
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;

    String text;

    @Embedded
    private Address2 address;

    protected A1()
    {

    }

    public A1(Address2 address,String text) {
        this.text = text;
        this.address = address;
    }

    public A1(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "A1{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", address=" + address +
                '}';
    }
}
