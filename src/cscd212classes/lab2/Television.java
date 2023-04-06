package cscd212classes.lab2;


import java.util.Objects;

public class Television implements Comparable<Television>
{
    private final boolean fourK;
    private final String make;
    private final String model;
    private final int resolution;
    private final int screenSize;
    private final boolean smart;

    public Television(final String make, final String model, final boolean smart, final int screenSize, final int resolution) {
        if (make == null || make.isEmpty() || model == null || model.isEmpty() || screenSize < 32 || resolution < 720)
            throw new IllegalArgumentException("Bad TV parameters");

        this.model = model;
        this.smart = smart;
        this.screenSize = screenSize;
        this.resolution = resolution;
        this.make = make;
        if (resolution > 2160)
            this.fourK = true;

        else
            this.fourK = false;


    }
    public Television(final String model, final boolean smart, final int screenSize, final int resolution, final String make)
    {
        this(make, model, smart, screenSize, resolution);

    }

    public int getScreenSize() {
        return screenSize;
    }

    public int getResolution() {
        return resolution;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        String tvDescription = this.make + "-" + this.model + ", " + this.screenSize + " inch ";

        if (this.smart)
            tvDescription += "smart";

        tvDescription += "tv with ";

        if (this.resolution == 2160)
            tvDescription += "4K resolution";
        else
            tvDescription += " with " + this.resolution + " resolution";
        return tvDescription;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        Television other = (Television) obj;
        return this.fourK == other.fourK &&
                this.resolution == other.resolution &&
                this.screenSize == other.screenSize &&
                this.smart == other.smart &&
                this.make.equals(other.make) &&
                this.model.equals(other.model);
    }



    @Override
    public int hashCode() {
        return Objects.hash(fourK, make, model, resolution, screenSize, smart);
    }


    @Override
    public int compareTo(Television another) {
        if (another == null) {
            throw new IllegalArgumentException("Argument cannot be null");
        }

        int makeComp = this.make.compareTo(another.make);
        if (makeComp != 0) {
            return makeComp;
        }

        int modelComp = this.model.compareTo(another.model);
        if (modelComp != 0) {
            return modelComp;
        }

        return this.screenSize - another.screenSize;
    }


}
