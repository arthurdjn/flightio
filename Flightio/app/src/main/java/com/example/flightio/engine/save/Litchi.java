package com.example.flightio.engine.save;


import com.example.flightio.engine.coordinates.Point;

public class Litchi {

    double lat;
    double lon;
    double altitude;

    double heading;
    double curvesize;
    double rotationdir;
    double gimbalmode;
    double gimbalpitchangle;

    int actiontype1;
    int actionparam1;
    int actiontype2;
    int actionparam2;
    int actionparam3;
    int actiontype3;
    int actionparam4;
    int actiontype4;
    int actionparam5;
    int actiontype5;

    int actionparam6;
    int actiontype6;
    int actionparam7;
    int actiontype7;
    int actionparam8;
    int actiontype8;
    int actionparam9;
    int actiontype9;
    int actionparam10;
    int actiontype10;

    int actionparam11;
    int actiontype11;
    int actionparam12;
    int actiontype12;
    int actionparam13;
    int actiontype13;
    int actionparam14;
    int actiontype14;
    int actionparam15;
    int actiontype15;

    double altitudemode;
    double speed;

    double poi_latitude;
    double poi_longitude;
    double poi_altitude;
    double poi_altitudemode;
    double photo_timeinterval;

    public Litchi(Point point) {
        lat = point.getLat();
        lon = point.getLon();
        altitude = point.getZ();
        heading = 0;
        curvesize = 0;
        rotationdir = 0;
        gimbalmode = 0;
        gimbalpitchangle = 0;

        actiontype1 = -1;
        actionparam1 = 0;
        actiontype2 = -1;
        actionparam2 = 0;
        actiontype3 = -1;
        actionparam3 = 0;
        actiontype4 = -1;
        actionparam4 = 0;
        actiontype5 = -1;
        actionparam5 = 0;


        actiontype6 = -1;
        actionparam6 = 0;
        actiontype7 = -1;
        actionparam7 = 0;
        actiontype8 = -1;
        actionparam8 = 0;
        actiontype9 = -1;
        actionparam9 = 0;
        actiontype10 = -1;
        actionparam10 = 0;


        actiontype11 = -1;
        actionparam11 = 0;
        actiontype12 = -1;
        actionparam12 = 0;
        actiontype13 = -1;
        actionparam13 = 0;
        actiontype14 = -1;
        actionparam14 = 0;
        actiontype15 = -1;
        actionparam15 = 0;

        altitudemode = 0;
        speed = 0;

        poi_latitude = 0;
        poi_longitude = 0;
        poi_altitude = 0;
        poi_altitudemode = 0;
        photo_timeinterval = 0;

    }










    // Getters Setters
    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public double getHeading() {
        return heading;
    }

    public void setHeading(double heading) {
        this.heading = heading;
    }

    public double getCurvesize() {
        return curvesize;
    }

    public void setCurvesize(double curvesize) {
        this.curvesize = curvesize;
    }

    public double getRotationdir() {
        return rotationdir;
    }

    public void setRotationdir(double rotationdir) {
        this.rotationdir = rotationdir;
    }

    public double getGimbalmode() {
        return gimbalmode;
    }

    public void setGimbalmode(double gimbalmode) {
        this.gimbalmode = gimbalmode;
    }

    public double getGimbalpitchangle() {
        return gimbalpitchangle;
    }

    public void setGimbalpitchangle(double gimbalpitchangle) {
        this.gimbalpitchangle = gimbalpitchangle;
    }

    public int getActiontype1() {
        return actiontype1;
    }

    public void setActiontype1(int actiontype1) {
        this.actiontype1 = actiontype1;
    }

    public int getActionparam1() {
        return actionparam1;
    }

    public void setActionparam1(int actionparam1) {
        this.actionparam1 = actionparam1;
    }

    public int getActiontype2() {
        return actiontype2;
    }

    public void setActiontype2(int actiontype2) {
        this.actiontype2 = actiontype2;
    }

    public int getActionparam2() {
        return actionparam2;
    }

    public void setActionparam2(int actionparam2) {
        this.actionparam2 = actionparam2;
    }

    public int getActionparam3() {
        return actionparam3;
    }

    public void setActionparam3(int actionparam3) {
        this.actionparam3 = actionparam3;
    }

    public int getActiontype3() {
        return actiontype3;
    }

    public void setActiontype3(int actiontype3) {
        this.actiontype3 = actiontype3;
    }

    public int getActionparam4() {
        return actionparam4;
    }

    public void setActionparam4(int actionparam4) {
        this.actionparam4 = actionparam4;
    }

    public int getActiontype4() {
        return actiontype4;
    }

    public void setActiontype4(int actiontype4) {
        this.actiontype4 = actiontype4;
    }

    public int getActionparam5() {
        return actionparam5;
    }

    public void setActionparam5(int actionparam5) {
        this.actionparam5 = actionparam5;
    }

    public int getActiontype5() {
        return actiontype5;
    }

    public void setActiontype5(int actiontype5) {
        this.actiontype5 = actiontype5;
    }

    public int getActionparam6() {
        return actionparam6;
    }

    public void setActionparam6(int actionparam6) {
        this.actionparam6 = actionparam6;
    }

    public int getActiontype6() {
        return actiontype6;
    }

    public void setActiontype6(int actiontype6) {
        this.actiontype6 = actiontype6;
    }

    public int getActionparam7() {
        return actionparam7;
    }

    public void setActionparam7(int actionparam7) {
        this.actionparam7 = actionparam7;
    }

    public int getActiontype7() {
        return actiontype7;
    }

    public void setActiontype7(int actiontype7) {
        this.actiontype7 = actiontype7;
    }

    public int getActionparam8() {
        return actionparam8;
    }

    public void setActionparam8(int actionparam8) {
        this.actionparam8 = actionparam8;
    }

    public int getActiontype8() {
        return actiontype8;
    }

    public void setActiontype8(int actiontype8) {
        this.actiontype8 = actiontype8;
    }

    public int getActionparam9() {
        return actionparam9;
    }

    public void setActionparam9(int actionparam9) {
        this.actionparam9 = actionparam9;
    }

    public int getActiontype9() {
        return actiontype9;
    }

    public void setActiontype9(int actiontype9) {
        this.actiontype9 = actiontype9;
    }

    public int getActionparam10() {
        return actionparam10;
    }

    public void setActionparam10(int actionparam10) {
        this.actionparam10 = actionparam10;
    }

    public int getActiontype10() {
        return actiontype10;
    }

    public void setActiontype10(int actiontype10) {
        this.actiontype10 = actiontype10;
    }

    public int getActionparam11() {
        return actionparam11;
    }

    public void setActionparam11(int actionparam11) {
        this.actionparam11 = actionparam11;
    }

    public int getActiontype11() {
        return actiontype11;
    }

    public void setActiontype11(int actiontype11) {
        this.actiontype11 = actiontype11;
    }

    public int getActionparam12() {
        return actionparam12;
    }

    public void setActionparam12(int actionparam12) {
        this.actionparam12 = actionparam12;
    }

    public int getActiontype12() {
        return actiontype12;
    }

    public void setActiontype12(int actiontype12) {
        this.actiontype12 = actiontype12;
    }

    public int getActionparam13() {
        return actionparam13;
    }

    public void setActionparam13(int actionparam13) {
        this.actionparam13 = actionparam13;
    }

    public int getActiontype13() {
        return actiontype13;
    }

    public void setActiontype13(int actiontype13) {
        this.actiontype13 = actiontype13;
    }

    public int getActionparam14() {
        return actionparam14;
    }

    public void setActionparam14(int actionparam14) {
        this.actionparam14 = actionparam14;
    }

    public int getActiontype14() {
        return actiontype14;
    }

    public void setActiontype14(int actiontype14) {
        this.actiontype14 = actiontype14;
    }

    public int getActionparam15() {
        return actionparam15;
    }

    public void setActionparam15(int actionparam15) {
        this.actionparam15 = actionparam15;
    }

    public int getActiontype15() {
        return actiontype15;
    }

    public void setActiontype15(int actiontype15) {
        this.actiontype15 = actiontype15;
    }

    public double getAltitudemode() {
        return altitudemode;
    }

    public void setAltitudemode(double altitudemode) {
        this.altitudemode = altitudemode;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getPoi_latitude() {
        return poi_latitude;
    }

    public void setPoi_latitude(double poi_latitude) {
        this.poi_latitude = poi_latitude;
    }

    public double getPoi_longitude() {
        return poi_longitude;
    }

    public void setPoi_longitude(double poi_longitude) {
        this.poi_longitude = poi_longitude;
    }

    public double getPoi_altitude() {
        return poi_altitude;
    }

    public void setPoi_altitude(double poi_altitude) {
        this.poi_altitude = poi_altitude;
    }

    public double getPoi_altitudemode() {
        return poi_altitudemode;
    }

    public void setPoi_altitudemode(double poi_altitudemode) {
        this.poi_altitudemode = poi_altitudemode;
    }

    public double getPhoto_timeinterval() {
        return photo_timeinterval;
    }

    public void setPhoto_timeinterval(double photo_timeinterval) {
        this.photo_timeinterval = photo_timeinterval;
    }




    public static String litchiHeader() {
        return "latitude; longitude; altitude(m); heading(deg); curvesize(m); rotationdir; gimbalmode; gimbalpitchangle; "
                + "actiontype1; actionparam1; actiontype2; actionparam2; actiontype3; actionparam3; actiontype4; actionparam4; "
                + "actiontype5; actionparam5; actiontype6; actionparam6; actiontype7; actionparam7; actiontype8; actionparam8; "
                + "actiontype9; actionparam9; actiontype10; actionparam10; actiontype11; actionparam11; actiontype12; actionparam12; "
                + "actiontype13; actionparam13; actiontype14; actionparam14; actiontype15; actionparam15; altitudemode; speed(m/s); "
                + "poi_latitude; poi_longitude; poi_altitude(m); poi_altitudemode; photo_timeinterval" ;
    }

    @Override
    public String toString() {
        return lat + "; " + lon + "; " + altitude + "; "
                + heading + "; " + curvesize + "; " + rotationdir + "; "
                + gimbalmode + "; " + gimbalpitchangle + "; "
                + actiontype1 + "; " + actionparam1 + "; "
                + actiontype2 + "; " + actionparam2 + "; "
                + actiontype3 + "; " + actionparam3 + "; "
                + actiontype4 + "; " + actionparam4 + "; "
                + actiontype5 + "; " + actionparam5 + "; "

                + actiontype6 + "; " + actionparam6 + "; "
                + actiontype7 + "; " + actionparam7 + "; "
                + actiontype8 + "; " + actionparam8 + "; "
                + actiontype9 + "; " + actionparam9 + "; "
                + actiontype10 + "; " + actionparam10 + "; "

                + actiontype11 + "; " + actionparam11 + "; "
                + actiontype12 + "; " + actionparam12 + "; "
                + actiontype13 + "; " + actionparam13 + "; "
                + actiontype14 + "; " + actionparam14 + "; "
                + actiontype15 + "; " + actionparam15 + "; "

                + speed + "; " + poi_latitude + "; " + poi_longitude + "; "
                + poi_altitude + "; " + poi_altitudemode + "; " + photo_timeinterval;

    }

}