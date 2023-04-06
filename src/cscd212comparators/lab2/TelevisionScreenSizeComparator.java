package cscd212comparators.lab2;
import cscd212classes.lab2.Television;
import java.util.Comparator;

public class TelevisionScreenSizeComparator implements Comparator<Television>{

    @Override
    public int compare(Television t1, Television t2) {

        if (t1.getScreenSize() == t2.getScreenSize()) {
            return 0;
        } else if (t1.getScreenSize() > t2.getScreenSize()) {
            return 1;
        } else {
            return -1;
        }
    }

}
