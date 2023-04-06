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
            throw new IllegalArgumentException("Invalid parameter in constructor");

        this.model = model;
        this.smart = smart;
        this.screenSize = screenSize;
        this.resolution = resolution;
        this.make = make;
        if (resolution == 2160)
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
            tvDescription += "smart ";

        tvDescription += "tv ";

        if (this.resolution == 2160)
            tvDescription += "with 4K resolution";
        else
            tvDescription += "with " + this.resolution + " resolution";
        return tvDescription;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Television)) return false;
        Television that = (Television) o;
        return this.smart == that.smart &&
                screenSize == that.screenSize &&
                resolution == that.resolution &&
                Objects.equals(make, that.make) &&
                Objects.equals(model, that.model);
    }




    @Override
    public int hashCode() {
        return make.hashCode() + model.hashCode() + resolution + Boolean.hashCode(smart) + Boolean.hashCode(fourK);
    }



    @Override
    public int compareTo(Television another) {
        if (another == null) {
            throw new IllegalArgumentException("null parameter in the compareTo method");
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
