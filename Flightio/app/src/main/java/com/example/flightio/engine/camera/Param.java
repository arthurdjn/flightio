package com.example.flightio.engine.camera;

public class Param {

    private double[] base;
    private double alti;
    private boolean canExport;

    public Param(){
        base = new double[] {1, 1};
        canExport = false;
    }

    public double[] getBase(){
        return base;
    }

    public void setBase(double[] b){
        base = b;
    }

    public double getAlti(){
        return alti;
    }

    public void setAlti(double a){
        alti = a;
    }

    public boolean getCanExport(){
        return canExport;
    }

    public void setCanExport(boolean canExp){
        canExport = canExp;
    }

}
