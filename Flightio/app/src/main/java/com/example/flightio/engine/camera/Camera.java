package com.example.flightio.engine.camera;


public class Camera {

    private double[] sizeCap;
    private int[] sizeImg;
    private double focal;

    public Camera(double[] sizeCap, int[] sizeImg, double focal) {
        super();
        this.sizeCap = sizeCap;
        this.sizeImg = sizeImg;
        this.focal = focal;
    }

    public Camera(String cameraName){
        super();
        if (cameraName.equals("Parrot Sequoia")){
            this.sizeImg = new int[] {1280, 960};
            this.sizeCap = new double[] {0.0048, 0.0036};
            this.focal = 0.00398;
        }
        else if (cameraName.equals("DJI Mavic 2 Pro")){
            this.sizeImg = new int[] {5472, 3648};
            this.sizeCap = new double[] {0.0132, 0.0088};
            this.focal = 0.0103;
        }
    }


    /**
     * Compute the frequency of shots that is necessary to have the covering wanted
     * @param alti
     * @param covering
     * @param velocity
     * @param axe
     * @return
     */
    public double computeFrequencyShot(double alti, double covering, double velocity, int axe) {
        velocity = velocity/3.6;
        if (axe == 0) {
            return getGroundBase(alti, covering)[0]/velocity;
        }
        else if (axe == 1) {
            return getGroundBase(alti, covering)[1]/velocity;
        }
        System.out.println("Please insert valid parameters to compute the frequency of your shots.");
        return -1;
    }

    /**
     * Compute the velocity to ensure the covering
     * @param alti
     * @param covering
     * @param frequency
     * @param axe
     * @return
     */
    public double computeVelocity(double alti, double covering, double frequency, int axe) {
        if (axe == 0) {
            return getGroundBase(alti, covering)[0]/frequency*3.6;
        }
        else if (axe == 1) {
            return getGroundBase(alti, covering)[1]/frequency*3.6;
        }
        System.out.println("Please insert valid parameters to compute the velocity of your device.");
        return -1;
    }


    // Compute sizePix
    public double getSizePix() {
        return sizeCap[0]/sizeImg[0];
    }


    /**
     * Compute the length of the focal as if the captor size was 36mm x 24mm
     * @param focal
     * @param sizeCapt
     * @return in mm
     */
    public double getFocalEq() {
        return focal*36/sizeCap[0];
    }

    public double getSizePixGround(double alti) {
        return getSizePix()*alti/focal;
    }

    public double[] getSizeImgGround(double alti) {
        double sizePxGrd = getSizePixGround(alti);
        return new double[] {sizePxGrd*sizeImg[0], sizePxGrd*sizeImg[1]};
    }

    public double[] getGroundBase(double alti, double covering) {
        return new double[] {getSizeImgGround(alti)[0]*(1 - covering/100), getSizeImgGround(alti)[1]*(1 - covering/100)};
    }

    // Getters
    public double[] getSizeCap() {
        return sizeCap;
    }

    public int[] getSizeImg() {
        return sizeImg;
    }

    public double getFocal() {
        return focal;
    }

    // Setters
    public void setSizeCap(double[] sizeCap) {
        this.sizeCap = sizeCap;
    }

    public void setSizeImg(int[] sizeImg) {
        this.sizeImg = sizeImg;
    }

    public void setFocal(double focal) {
        this.focal = focal;
    }


    @Override
    public String toString() {
        return "The camera's parameters are : \nCaptor size : " + sizeCap[0] + " x " + sizeCap[1] + "\n"
                + "Image resolution : " + sizeImg[0] + " x " + sizeImg[1] + "\n"
                + "Focal length : " + focal + " and equivalent length : " + getFocalEq();

    }


}
