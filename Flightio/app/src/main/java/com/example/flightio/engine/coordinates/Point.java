package com.example.flightio.engine.coordinates;


public class Point {

    private double X;
    private double Y;
    private double Z;
    private double lat;
    private double lon;


    public Point(double x, double y, double z) {
        X = x;
        Y = y;
        Z = z;
        lat = 0;
        lon = 0;
    }

    public Point(double Lat, double Lon) {
        lat = Lat;
        lon = Lon;
        X = 0;
        Y = 0;
        Z = 0;
    }

    // Getters
    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

    public double getZ() {
        return Z;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }


    // Setters
    public void setX(double x) {
        X = x;
    }

    public void setY(double y) {
        Y = y;
    }

    public void setZ(double z) {
        Z = z;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "The coordinates of the point are\nX :" + X + "\nY : " + Y + "\nZ : " + Z +
                "\nIn geocentric : Lat : " + lat + "\nLon : " + lon + "\n";
    }

}