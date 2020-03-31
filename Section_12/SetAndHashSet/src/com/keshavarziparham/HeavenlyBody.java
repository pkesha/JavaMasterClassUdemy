package com.keshavarziparham;

import java.util.HashSet;
import java.util.Set;

public final class HeavenlyBody {
    private  final String name;
    private  final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addMoon(HeavenlyBody moon){
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    @Override
    public int hashCode() {
        //This works because we're using generics but it's bad practice
        //Adding 57 guarantees that returning a non-zero #. The Hash Code will be offset by 57
        System.out.println("hashcode called");
        return this.name.hashCode() + 57;
        //HeavenlyBody "Pluto" will have different hashcode to String "Pluto"
    }

    @Override
    //This is overloading the method if using HeavenlyBody as a parameter.
    //To override, Have to keep the same parameters
    //This prevents from same planet from being added
    public boolean equals(Object obj) {
        //If they are the same object, return true
        if(this == obj) { return true; }

        System.out.println("obj.getClass() is " + obj.getClass());
        System.out.println("this.getClass() is " + this.getClass());

        //If it is null or a different class being compared, return false
        // 2nd comparison is unnecessary because it's a final and cannot be subclassed
        if((obj == null) || (obj.getClass() != this.getClass())) { return false; }

        String objName = ((HeavenlyBody) obj).getName();
        System.out.println("___________");
        return this.name.equals(objName);
    }
}
