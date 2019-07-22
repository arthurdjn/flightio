package com.example.flightio;

import android.content.Context;
import android.os.Bundle;
import android.transition.ChangeTransform;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.flightio.engine.camera.Camera;
import com.example.flightio.engine.coordinates.Point;
import com.example.flightio.engine.interpolation.Interpolation;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Frag1Param extends Fragment {

    private Button compute;

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
        final EditText textCover = view.findViewById(R.id.altitude);



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

                            String focalText = "Focal length :\n" + Math.floor(focal*10000)/10000 + "\n\n" +
                                    "Equivalent focal :\n" + Math.floor(focaleq*100)/100;
                            focalBox.setText(focalText);

                            String pixSizeText = "Pixel size :\n" + Math.floor(sizePix*1000000)/1000000;
                            pixSizeBox.setText(pixSizeText);

                            String grdPixSizeText = "Ground pixel size :\n" + Math.floor(sizePixGround*100)/100;
                            grdPixSizeBox.setText(grdPixSizeText);

                            String grdImgText = "Ground Image size :\n" + Math.floor(sizeImgGround[0]*10000)/10000 + " x " + Math.floor(sizeImgGround[1]*10000)/10000 + "\n\n" +
                                    "Base :\n" + Math.floor(base[0]*10000)/10000 + " x " + Math.floor(base[1]*10000)/10000;
                            groundImageBox.setText(grdImgText);

                        }
                    }
                }
        );

        return view;

    }

}
