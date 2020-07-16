package Driving;

public class Teleporter implements Drivable {

    private double topSpeed = 0.0;

    public Double getTopSpeed() {
        return topSpeed;
    }

    public Integer transport(Double distance) {
        Double time = distance * topSpeed;
        return time.intValue();
    }

}