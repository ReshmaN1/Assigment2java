package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    public Object Job;
    public String toString;
    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency=coreCompetency;
    }
    public Job(){
        id = nextId;
        nextId++;
    }

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fieds. The second constructor should also call the first in order to initialize
    //  the 'id' field.


    /*public void Job(String name, Employer employer , Location location , PositionType positionType , CoreCompetency coreCompetency){
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this. coreCompetency = coreCompetency;
    }*/

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    /*@Override
    public  boolean equals(Oject o){
        if(this == o )return true;
        if(o == null || getClass() !=o.getClass())return false;
        Job job = (Job) o;
        return id == job.id;
    }
*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name  = name;
    }
    public Employer getEmployer(){
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString(){
        String output = "";

        if (name == ""){
            return "Data is not available";

        }

        if (employer.getValue() == ""){
            return "Deta ia not available";
        }

        if (location.getValue() == ""){
            return "Deta is not available";
        }

        if(positionType.getValue() == ""){
            return "Deta ia not available";
        }

        if(coreCompetency.getValue() ==""){
            return "Data is not available";
        }
        output =
                       "\n" + "ID:" + id + "\n" +
                        "\n"  + "Name:" + name + "\n" +
                         "\n"  + "Employer:" + employer + "\n"  +
                          "\n"  + "Location:" + location + "\n" +
                           "\n" + "Position Type:" + positionType + "\n" +
                            "\n" + "Core Competency:" + coreCompetency + "\n";
         return output;


    }
}
