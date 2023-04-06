package cscd212comparators.lab2;
import cscd212classes.lab2.Television;
import java.util.Comparator;


public class TelevisionScreenSizeComparator implements Comparator<Television>{

    @Override
    public int compare(Television t1, Television t2) {
        if (t1 == null || t2 == null) {
            throw new IllegalArgumentException("null parameter in TelevisionScreenSizeComparator");
        }

        int screenSize1 = t1.getScreenSize();
        int screenSize2 = t2.getScreenSize();

        if (screenSize1 == screenSize2) {
            return 0;
        } else if (screenSize1 > screenSize2) {
            return 1;
        } else {
            return -1;
        }
    }
}




