package challenge2;

import com.sun.tools.jdi.IntegerValueImpl;

import java.util.List;

public class Third {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        if(angle >= 180) return points.size();
        int num = 0;
        double[] ags = new double[points.size()];
        int halfAngle = angle / 2;
        for (int i = 0; i < points.size(); i++){
            List<Integer> point = points.get(i);
            if(point.get(0) == location.get(0) && point.get(1) == location.get(1)){
                num++;
                ags[i] = -1;
                continue;
            }
            else if(point.get(0) == location.get(0) && point.get(1) > location.get(1)){
                ags[i] = 0;
                continue;
            }
            else if(point.get(0) == location.get(0) && point.get(1) < location.get(1)){
                ags[i] = 180;
                continue;
            }
            else if(point.get(0) > location.get(0) && point.get(1) == location.get(1)){
                ags[i] = 90;
                continue;
            }
            else if(point.get(0) < location.get(0) && point.get(1) == location.get(1)){
                ags[i] = 270;
                continue;
            }
            else{
                ags[i] = Math.toDegrees(Math.atan((double)(point.get(1) - location.get(1)) / (double)(point.get(0) - location.get(0))));
            }
        }
        return 0;
    }
}
