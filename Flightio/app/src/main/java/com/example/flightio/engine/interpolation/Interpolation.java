package com.example.flightio.engine.interpolation;


import java.util.ArrayList;

import com.example.flightio.engine.coordinates.Point;

public class Interpolation {

    public static double haversine(Point startPoint, Point endPoint) {
        double lat1 = startPoint.getLat()*Math.PI/180;
        double lat2 = endPoint.getLat()*Math.PI/180;
        double lon1 = startPoint.getLon()*Math.PI/180;
        double lon2 = endPoint.getLon()*Math.PI/180;
        //System.out.println(lat1 + lat2 + lon1 + lon2);

        double a = Math.pow(Math.sin((lat1 - lat2)/2), 2)
                + Math.cos(lat1)*Math.cos(lat2)*Math.pow(Math.sin((lon1 - lon2)/2), 2);
        double c = 2*Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        int r = 6378137;
        return r*c;

    }

    /**
     * Compute the number of shots that the device need to takes from startPoint to endPoint
     * @param sizeGroundBase
     * @param startPoint
     * @param endPoint
     * @return
     */
    public static int getShotsNumber(Point startPoint, Point endPoint, double sizeGroundBase) {
        double distance = 0;
        if ((startPoint.getX() == 0)&&(startPoint.getY() == 0)) {
            distance = haversine(startPoint, endPoint);
        }
        else {
            distance = Math.sqrt( Math.pow(startPoint.getX() - endPoint.getX(), 2) + Math.pow(startPoint.getY() - endPoint.getY(), 2) );
            //System.out.println("distance : " + distance);
        }
        return (int) Math.round(distance/sizeGroundBase);
    }


    /**
     * Create an interpolation from startPoint to endPoint
     * @param sizeGround
     * @return a list of interpolated points
     */
    public static ArrayList<Point> computeInterXYZ(Point startPoint, Point endPoint, double sizeGroundBase){
        ArrayList<Point> listInterpol = new ArrayList<>();
        int n = getShotsNumber(startPoint, endPoint, sizeGroundBase);
        for (int i = 0; i < n; i++) {
            double X = startPoint.getX() + listInterpol.size()*(endPoint.getX() - startPoint.getX())/n;
            double Y = startPoint.getY() + listInterpol.size()*(endPoint.getY() - startPoint.getY())/n;
            double Z = startPoint.getZ() + listInterpol.size()*(endPoint.getZ() - startPoint.getZ())/n;
            listInterpol.add(new Point(X, Y, Z));
        }
        return listInterpol;
    }

    /**
     * Create an interpolation from startPoint to endPoint
     * @param sizeGround
     * @return a list of interpolated points
     */
    public static ArrayList<Point> computeInterLatLon(Point startPoint, Point endPoint, double sizeGroundBase){
        ArrayList<Point> listInterpol = new ArrayList<>();
        int n = getShotsNumber(startPoint, endPoint, sizeGroundBase);
        double lat1 = startPoint.getLat();
        double lat2 = endPoint.getLat();
        double lon1 = startPoint.getLon();
        double lon2 = endPoint.getLon();

        for (int i = 0; i < n + 1; i++) {
            double lat = lat1 + listInterpol.size()*(lat2 - lat1)/n;
            double lon = lon1 + listInterpol.size()*(lon2 - lon1)/n;
            //System.out.println("lat : " + lat + "\n lon : " + lon + "\n");
            double Z = startPoint.getZ() + listInterpol.size()*(endPoint.getZ() - startPoint.getZ())/n;
            Point point = new Point(lat, lon);
            point.setZ(Z);
            listInterpol.add(point);

        }
        return listInterpol;
    }

    public static ArrayList<Point> computeInterSquare4(Point point1, Point point2, Point point3, Point point4, double sizeGroundBase){
        //ArrayList<Point> list12 = computeInterLatLon(point1, point2, sizeGroundBase);
        ArrayList<Point> list23 = computeInterLatLon(point2, point3, sizeGroundBase);
        //ArrayList<Point> list34 = computeInterLatLon(point3, point4, sizeGroundBase);
        ArrayList<Point> list41 = computeInterLatLon(point4, point1, sizeGroundBase);
        ArrayList<Point> listInter = new ArrayList<>();

        for (int i = 0; i < list23.size(); i++) {
            if (i % 2 == 0) {
                Point startPointMid = list23.get(i);
                Point endPointMid = list41.get(list41.size() - i - 1);
                ArrayList<Point> listInterMid = computeInterLatLon(startPointMid, endPointMid, sizeGroundBase);
                for (int j = 0; j < listInterMid.size(); j++) {
                    listInter.add(listInterMid.get(j));
                }
                //adding the point interpolated between the axes 23 - 41
            }
            else if ((i % 2 == 1) && (list41.size() - i - 1> 0)){
                Point endPointMid = list23.get(i);
                Point startPointMid = list41.get(list41.size() - i - 1);
                ArrayList<Point> listInterMid = computeInterLatLon(startPointMid, endPointMid, sizeGroundBase);
                for (int j = 0; j < listInterMid.size(); j++) {
                    listInter.add(listInterMid.get(j));
                }
                //adding the point interpolated between the axes 23 - 41
            }
        }
        return listInter;
    }


    /**
     * Create a drone map without stop point. Only intersections.
     * @param point1
     * @param point2
     * @param point3
     * @param point4
     * @param sizeGroundBase
     * @return
     */
    public static ArrayList<Point> computeInterSquareNoStop(Point point1, Point point2, Point point3, Point point4, double sizeGroundBase){
        ArrayList<Point> list23 = computeInterLatLon(point2, point3, sizeGroundBase);
        ArrayList<Point> list41 = computeInterLatLon(point4, point1, sizeGroundBase);
        ArrayList<Point> listInter = new ArrayList<>();

        for (int i = 0; i < (int) list23.size()/2; i++) {
            listInter.add(list23.get(2*i));
            listInter.add(list41.get(list41.size() -2*i - 1));
            listInter.add(list41.get(list41.size() -2*i - 2));
            listInter.add(list23.get(2*i + 1));
        }
        return listInter;
    }



}
