package aed.analisecomplexidade.algoritmos;

import java.awt.geom.Point2D;
import java.util.Arrays;

import aed.utils.Par;

public class PontosMaisProximos {

    public static Par<Point2D, Point2D> execute(Point2D... points) {

        if (points.length < 2)
            throw new IllegalArgumentException("Must have at least 2 points");
        if (points.length == 2)
            return new Par<Point2D, Point2D>(points[0], points[1]);

        double minDistance = Double.MAX_VALUE;
        double distance = 0;
        Par<Point2D, Point2D> nearbyPair = null;

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                distance = points[i].distanceSq(points[j]);
                if (distance < minDistance) {
                    minDistance = distance;
                    nearbyPair = new Par<>(points[i], points[j]);
                }
            }
        }
        return nearbyPair;
    }

    public static void show(Point2D... points) {
        try {
            Par<Point2D, Point2D> nearbyPair = execute(points);
            System.out.println("nearest points(" + Arrays.toString(points) + ") = " + nearbyPair);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
