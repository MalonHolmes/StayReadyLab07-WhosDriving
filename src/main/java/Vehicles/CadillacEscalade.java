package Vehicles;

import Driving.Car;

public class CadillacEscalade extends Car {

    private boolean changeOil = false;
    private String redLight = "Check engine light on!";
    private double distanceTraveled;
    private Double topSpeed = 0.0;

    public CadillacEscalade()
    {
        this.distanceTraveled = 0.0;
        this.topSpeed = 70.0;

    }

    public void setDistanceTraveled(double distanceTraveled)
    {
        this.distanceTraveled = distanceTraveled;
    }

    /**
     * A civic should need an oil change every
     * 50,000 miles traveled. Once the oil is
     * changed, the car may travel another 50,000
     * miles before needing another oil change.
     *
     * @return true if an oil change is needed
     */
    @Override
    public Boolean needsOilChange() {

        double distance = getDistanceTraveled();
        if(distance >= 50000){
            changeOil();
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method should reset any flags set
     * from when an oil change was needed. It
     * should also indicate that another 50,000
     * miles may be traveled before another oil
     * change is needed.
     */
    @Override
    public void changeOil() {

        if (changeOil == false){
            System.out.println("Another 50,000 miles may be traveled before another oil change is needed");
            this.setDistanceTraveled(0);
        } else {
            changeOil = true;
        }
    }

    /**
     * the check engine light should be on whenever
     * something is wrong with the car. This class
     * simply turns on the light when an oil change
     * is needed.
     * @return true if anything is wrong with the car
     */
    @Override
    public Boolean checkEngineLight() {

        if(needsOilChange()){
            System.out.println(redLight);
            return true;
        }
        return false;
    }

    /**
     * This method should return the total distance
     * traveled by the car. This number can never
     * decrease, so every time it is called the newest
     * value returned should be equal to or higher
     * than all previous values.
     * @return total distance as a Double
     */
    @Override
    public Double getDistanceTraveled() {
        return distanceTraveled;
    }

    /**
     * Should return the top speed for a Civic (70 MPH)
     * @return 70.0
     */
    public Double getTopSpeed() {
        return topSpeed;
    }

    /**
     * transport should calculate the time it takes in
     * seconds to travel a distance base on the top
     * speed and update the amount of miles traveled.
     *
     * @param distance - length of travel in miles
     * @return time in seconds to travel distance
     */
    public Integer transport(Double distance) {
        int seconds = 3600; //To convert a num to seconds multiply by 3600
        Integer timeInSeconds = Math.round((int)(distance / topSpeed) * seconds);
        distanceTraveled += distance;
        return timeInSeconds;
    }
}