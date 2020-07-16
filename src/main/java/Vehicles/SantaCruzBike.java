package Vehicles;

import Driving.Bike;

public class SantaCruzBike extends Bike{

    private int PSI;

    public SantaCruzBike(){
        PSI = 40;
    }

    public Double getTopSpeed() {
        return 28.5 - (recommendedTirePressure() - PSI);
    }

    public Integer transport(Double distance) {
        int time = 3600;
        Double seconds = (distance / 28.5) * time;
        while(distance >= 30 && PSI > 20){
            PSI--;
            distance -= 30;
        }
        return (int)Math.round(seconds);
    }

    @Override
    public void inflateTires() {
        PSI = recommendedTirePressure();
    }

    @Override
    public Integer recommendedTirePressure() {
        return 30;
    }

    @Override
    public Integer getTirePressure() {
        return PSI;
    }

}