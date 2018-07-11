package testProject;

public class ScaleIncrement {
    int scale;
    int increment;

    private ScaleIncrement() {
    }

    public static ScaleIncrement valueOf(int scale, int increment) {
        ScaleIncrement result = new ScaleIncrement();
        result.scale = scale;
        result.increment = increment;
        return result;
    }
}
