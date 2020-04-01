package com.keshavarziparham;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class HeavenlyBody {
    private final Key key;
    //private  final String name;
    private  final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
    //private final BodyTypes bodyType;


    public enum BodyTypes{
        STAR,
        PLANET,
        DWARF_PLANET,
        MOON,
        COMET,
        ASTEROID
    }

    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {
        //this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
        //this.bodyType = bodyType;
        this.key = new Key(name, bodyType);
    }

//    public String getName() {
//        return name;
//    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

//    public BodyTypes getBodyType() {
//        return bodyType;
//    }


    public Key getKey() {
        return key;
    }

    public boolean addSatellites (HeavenlyBody moon){
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    @Override
    public final int hashCode() {
        //This works because we're using generics but it's bad practice
        //Adding 57 guarantees that returning a non-zero #. The Hash Code will be offset by 57
        //System.out.println("hashcode called");
        //return this.name.hashCode() + 57 + this.bodyType.hashCode();
        //HeavenlyBody "Pluto" will have different hashcode to String "Pluto"
        return this.key.hashCode();
    }

    public static Key makeKey(String name, BodyTypes bodyType){
        return new Key(name, bodyType);
    }

    @Override
    public String toString() {
        return this.key.name + "; " + this.key.bodyType + ", " + this.orbitalPeriod;
    }

    @Override
    //This is overloading the method if using HeavenlyBody as a parameter.
    //To override, Have to keep the same parameters
    //This prevents from same planet from being added
    public final boolean equals(Object obj) {
        //If they are the same object, return true
        if(this == obj) { return true; }

        if (obj instanceof HeavenlyBody){
            HeavenlyBody theObject = (HeavenlyBody) obj;
            return this.key.equals(theObject.getKey());
//             if (this.name.equals(theObject.getName())){
//                return this.bodyType == theObject.getBodyType();
//            }
        }
        return false;

        //If it is null or a different class being compared, return false
        // 2nd comparison is unnecessary because it's a final and cannot be subclassed
        //if((obj == null) || (obj.getClass() != this.getClass())) { return false; }

//        String objName = ((HeavenlyBody) obj).key.getName();
//        System.out.println("___________");
//        return this.key.equals(objName);
    }

    public static final class Key {
        private String name;
        private BodyTypes bodyType;

        private Key(String name, BodyTypes bodyType){
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyType() {
            return bodyType;
        }

        @Override
        public String toString() {
            return this.name + ": " + this.bodyType;
        }

        @Override
        public boolean equals(Object o) {
            Key key =(Key) o;
            if(this.name.equals(key.getName())){
                return (this.bodyType == key.getBodyType());
            }
            return false;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + 57 + this.bodyType.hashCode();
        }
    }
}
