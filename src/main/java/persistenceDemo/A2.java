package persistenceDemo;

import javax.persistence.*;

/**
 * Created by Student on 22.06.2016.
 */
@Entity
public class A2
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;

    @OneToOne
    A1 a1;

    @Embedded
    private Address2 address;

    protected A2()
    {

    }


    public A2(String text) {
        this.text = text;
    }

    public A2(String text, A1 a1)
    {
        this.text = text;
        this.a1 = a1;
    }

    public A2(Address2 address, String text)
    {
        this.address = address;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    String text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public A1 getA1() {
        return a1;
    }

    public void setA1(A1 a1) {
        this.a1 = a1;
    }

    @Override
    public String toString() {
        return "A2{" +
                "id=" + id +
                ", a1=" + a1 +
                ", address=" + address +
                ", text='" + text + '\'' +
                '}';
    }
}
