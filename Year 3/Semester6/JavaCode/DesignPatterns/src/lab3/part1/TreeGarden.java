package lab3.part1;

public class TreeGarden extends Garden {
    public Plant getShade() {
        return new Plant("Fir");
    }
    public Plant getCenter() {
        return new Plant("Ash");
    }
    public Plant getBorder() {
        return new Plant("Redwood");
    }

}