package lab3.part2;

public class TreeGarden implements Garden {
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