package com.example.flightio;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.flightio.engine.camera.Camera;
import com.example.flightio.Frag2Flight;
import com.example.flightio.engine.camera.Param;

public class Frag1Param extends Fragment {

    private Param paramBase;

    public Frag1Param(Param base){
        paramBase = base;
    }


    // Fragment section
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        LayoutInflater lf = getActivity().getLayoutInflater();
        final View view =  lf.inflate(R.layout.frag1_param_layout, container, false); //pass the correct layout name for the fragment

        //Button compute
        final View compute = view.findViewById(R.id.compute);

        //Text boxes
        final TextView captorBox = (TextView) view.findViewById(R.id.captor);
        final TextView groundImageBox = (TextView) view.findViewById(R.id.ground_image);
        final TextView pixSizeBox = (TextView) view.findViewById(R.id.pix_size);
        final TextView grdPixSizeBox = (TextView) view.findViewById(R.id.ground_pix_size);
        final TextView focalBox = (TextView) view.findViewById(R.id.focal);

        //Param
        final Spinner spinnerDevice = (Spinner) view.findViewById(R.id.spinnerDevice);
        final Spinner spinnerPlan = (Spinner) view.findViewById(R.id.spinnerPlan);
        final EditText textAlti = view.findViewById(R.id.altitude);
        final EditText textCover = view.findViewById(R.id.covering);



        compute.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        /* DO SOMETHING UPON THE CLICK */
                        // Test if all fields are empty

                        //Converted str param
                        String strDevice = spinnerDevice.getSelectedItem().toString();
                        String strPlan = spinnerPlan.getSelectedItem().toString();
                        String strAlti = textAlti.getText().toString();
                        String strCover = textCover.getText().toString();

                        String param = "Captor size :\n";
                        captorBox.setText("" + strDevice);

                        if (strAlti.length()*strCover.length()*(strDevice.length() - 18)*(strPlan.length() - 12) != 0) {  // - 18  & - 12 because length of "select your device" is 18 ...
                            // If not, do action
                            Camera camera = new Camera(strDevice);
                            double[] captorSize = camera.getSizeCap();
                            int[] imgSize = camera.getSizeImg();
                            double focal = camera.getFocal();
                            double focaleq = camera.getFocalEq();
                            double alti = Double.parseDouble("" + strAlti);
                            double cover = Double.parseDouble("" + strCover);
                            double sizePixGround = camera.getSizePixGround(alti);
                            double sizePix = camera.getSizePix();
                            double[] base = camera.getGroundBase(alti, cover);
                            double[] sizeImgGround = camera.getSizeImgGround(alti);


                            //Math.floor to have #.## digits nulbers
                            String captorText = "Captor size :\n" + captorSize[0] + " x " + captorSize[1] + "\n\n" +
                                    "Image size :\n" + imgSize[0] + " x " + imgSize[1];
                            captorBox.setText(captorText);

                            String focalText = "Focal length :\n" + Math.floor(focal*10000)/10000 + "mm\n\n" +
                                    "Equivalent focal :\n" + Math.floor(focaleq*100)/100 + "mm";
                            focalBox.setText(focalText);

                            String pixSizeText = "Pixel size :\n" + Math.floor(sizePix*1000000)/1000000;
                            pixSizeBox.setText(pixSizeText);

                            String grdPixSizeText = "Ground pixel size :\n" + Math.floor(sizePixGround*10000)/100 + "cm";
                            grdPixSizeBox.setText(grdPixSizeText);

                            String grdImgText = "Ground Image size :\n" + Math.floor(sizeImgGround[0]*10000)/10000 + " x " + Math.floor(sizeImgGround[1]*10000)/10000 + "\n\n" +
                                    "Base :\n" + Math.floor(base[0]*100)/100 + "m x " + Math.floor(base[1]*100)/100 + "m";
                            groundImageBox.setText(grdImgText);


                            // Get informations for the other fragment
                            paramBase.setBase(base);
                            paramBase.setAlti(alti);
                            paramBase.setCanExport(true);

                        }
                    }
                }
        );


        return view;

    }



}
