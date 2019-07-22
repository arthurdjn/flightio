package com.example.flightio;

import android.content.Context;
import android.os.Bundle;
import android.transition.ChangeTransform;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.flightio.engine.camera.Camera;
import com.example.flightio.engine.coordinates.Point;
import com.example.flightio.engine.interpolation.Interpolation;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class SaveWorking extends  Fragment {
    private TextView textView;
    private Button save;
    private static final String FILE_NAME = "example.csv";

    private StringBuilder text = new StringBuilder();

    // Fragment section
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        final LayoutInflater lf = getActivity().getLayoutInflater();
        final View view =  lf.inflate(R.layout.frag2_flight_layout, container, false); //pass the correct layout name for the fragment
        super.onViewCreated(view, savedInstanceState);


        //Button compute
        final View save = view.findViewById(R.id.save);

        save.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        /* DO SOMETHING UPON THE CLICK */

                        EditText editText = view.findViewById(R.id.editText);
                        final String text = editText.getText().toString();
                        FileOutputStream fos = null;

                        try {
                            fos = lf.getContext().openFileOutput(FILE_NAME, lf.getContext().MODE_PRIVATE);
                            fos.write(text.getBytes());

                            // clear the editText
                            editText.getText().clear();

                            // Message succesful write
                            /*
                            Toast.makeText(this, "Saved to " + lf.getContext().getFilesDir() + "/" + FILE_NAME,
                                    Toast.LENGTH_LONG).show();
                            */

                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            if (fos != null){
                                try {
                                    fos.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }


                    }
                }
        );

        return view;

    }





    /*
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String content = null;
        try {

            InputStream is = getActivity().getAssets().open("i.txt");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            content = new String(buffer,"UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            Log.d("error","error");
        }


        TextView output= (TextView)getView().findViewById(R.id.editText);
        output.setText(content);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_3, container, false);
        return rootView;
    }
    */

}