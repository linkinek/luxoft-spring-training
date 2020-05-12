package com.luxoft.springcore.travel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class TravellingOpportunities {

    @Autowired
    private List<Connection> connections;

    public List<Connection> getConnectionsList() {
        return Collections.unmodifiableList(connections);
    }

    public void setConnectionsList(List<Connection> connections) {
        this.connections = connections;
    }

}
