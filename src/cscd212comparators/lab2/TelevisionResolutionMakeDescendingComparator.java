package cscd212comparators.lab2;
import cscd212classes.lab2.Television;
import java.util.Comparator;

public class TelevisionResolutionMakeDescendingComparator implements Comparator<Television>
{
    @Override
    public int compare(Television t1, Television t2) {
        if (t1.getResolution() == t2.getResolution()) {
            return t2.getMake().compareTo(t1.getMake());
        } else {
            return Integer.compare(t2.getResolution(), t1.getResolution());
        }
    }

}
