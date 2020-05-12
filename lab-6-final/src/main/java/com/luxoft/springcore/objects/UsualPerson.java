package com.luxoft.springcore.objects;

import com.luxoft.springcore.ContextManager;
import com.luxoft.springcore.events.TravelEvent;
import com.luxoft.springcore.travel.Connection;
import com.luxoft.springcore.travel.TravellingOpportunities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsualPerson implements Person {
    private int id;

    private String name;
    private City city;
    private int distanceTravelled = 0;

    private int age;
    private boolean isProgrammer;

    @Autowired
    private ContextManager contextManager;
    @Autowired
    private TravellingOpportunities travellingOpportunities;

    public UsualPerson() {
    }

    public UsualPerson(String name, int age, City city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public City getCity() {
        return city;
    }

    public void setCountry(City city) {
        this.city = city;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(int distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    public boolean isProgrammer() {
        return isProgrammer;
    }

    public void setIsProgrammer(boolean isProgrammer) {
        this.isProgrammer = isProgrammer;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void travel(City source, City destination) {
        Connection connection = travellingOpportunities.getConnectionsList()
                .stream().filter(con -> con.getSource() != null)
                .filter(conn -> conn.getSource().equals(source) &&
                        conn.getDestination().equals(destination))
                .findFirst().get();

        setDistanceTravelled(getDistanceTravelled() + connection.getDistance());

        TravelEvent travelEvent = new TravelEvent(this, destination);
        contextManager.getApplicationContext().publishEvent(travelEvent);
    }

    public String toString() {
        String s = "Name: " + name + "\n"
                + "Age: " + age + "\n"
                + "City: " + city + "\n"
                + "Is Programmer?: " + isProgrammer + "\n";

        return s;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsualPerson person = (UsualPerson) o;

        if (age != person.age) return false;
        if (isProgrammer != person.isProgrammer) return false;
        if (city != null ? !city.equals(person.city) : person.city != null) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (name != null ? name.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (isProgrammer ? 1 : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }

}
