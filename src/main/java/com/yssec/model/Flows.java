package com.yssec.model;

import java.util.List;
public class Flows {
    private List<Locations> locations ;

    public void setLocations(List<Locations> locations){
        this.locations = locations;
    }
    public List<Locations> getLocations(){
        return this.locations;
    }

}
