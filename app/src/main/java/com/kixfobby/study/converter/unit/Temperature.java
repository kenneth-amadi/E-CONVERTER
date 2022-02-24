package com.kixfobby.study.converter.unit;

import android.annotation.SuppressLint;
import android.icu.text.DecimalFormat;
import android.icu.text.NumberFormat;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.kixfobby.study.converter.ui.Converter;
import com.kixfobby.study.converter.R;
import com.kixfobby.study.converter.util.ShortCuts;

//import org.jetbrains.annotations.Contract;

import java.util.Objects;


public class Temperature extends Fragment implements OnClickListener {
    @SuppressLint("StaticFieldLeak")
    public static TextView tv;
    public static String Out, Out1, Out2;
    private static String from, to;
    private static String prefixI, prefixO, sufixI, sufixO;
    private static ShortCuts shortcut;
    private static Spanned In1;
    private static NumberFormat nf;
    private static Double input, output;
    private static final Double apprMax = 9999999.999999999;
    private Spinner sfrom, sto;
    private EditText et;
    private Double mC, mDe, mF, mK, mN, mR, mRe, mGM, mRo;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.converter_main2, container, false);

        shortcut = new ShortCuts();

        tv = view.findViewById(R.id.txt);
        et = view.findViewById(R.id.edit);

        Button btn = view.findViewById(R.id.btnConvert);
        btn.setOnClickListener(this);

        sfrom = view.findViewById(R.id.fromSpin);
        sto = view.findViewById(R.id.toSpin);

        String[] units = getResources().getStringArray(R.array.temperature);

        ArrayAdapter<String> fromAdap = new ArrayAdapter<>(Objects.requireNonNull(getContext()), R.layout.spinner_item, units);
        sfrom.setAdapter(fromAdap);

        ArrayAdapter<String> toAdap = new ArrayAdapter<>(getContext(), R.layout.spinner_item, units);
        sto.setAdapter(toAdap);

        sfrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                from = sfrom.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sto.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                to = sto.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }

    //Button Click
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {
        nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(7);

        try {
            String insert = et.getText().toString();
            input = Double.parseDouble(insert);
            tempData();

            //Input
            if (input > apprMax || input < 0.001 && input > 0) {
                String strI = String.valueOf(input);
                String powerI = strI.replaceAll("E", " x 10#");
                String[] partsI = powerI.split("#");
                prefixI = partsI[0];
                sufixI = partsI[1];
                In1 = Html.fromHtml(prefixI + "<sup><small>" + sufixI + "</small></sup>" + " " + "<b>" + shortcut.getUnit().get(from) + "</b>" + " ");
            } else
                In1 = Html.fromHtml(nf.format(input) + " " + "<b>" + shortcut.getUnit().get(from) + "</b>" + " ");

            if (input < -apprMax || input > -0.001) {
                String strI = String.valueOf(input);
                String powerI = strI.replaceAll("E", " x 10#");
                String[] partsI = powerI.split("#");
                prefixI = partsI[0];
                sufixI = partsI[1];
                In1 = Html.fromHtml(prefixI + "<sup><small>" + sufixI + "</small></sup>" + " " + "<b>" + shortcut.getUnit().get(from) + "</b>" + " ");
            } else
                In1 = Html.fromHtml(nf.format(input) + " " + "<b>" + shortcut.getUnit().get(from) + "</b>" + " ");

            try {
                //Output
                if (output > apprMax || output < 0.001) {
                    String strO = String.valueOf(output);
                    String powerO = strO.replaceAll("E", " x 10#");
                    String[] partsO = powerO.split("#");
                    prefixO = partsO[0];
                    sufixO = partsO[1];

                    try {
                        if (Converter.isChecked) stdForm(tv);
                        else normForm(tv);
                    } catch (Exception e) {
                        tv.setText(In1);
                        tv.append(Html.fromHtml(" = " + (nf.format(output)) + " " + "<b>" + shortcut.getUnit().get(to) + "</b>"));
                    }
                } else {
                    tv.setText(In1);
                    tv.append(Html.fromHtml(" = " + nf.format(output) + " " + "<b>" + shortcut.getUnit().get(to) + "</b>"));
                }
            } catch (NumberFormatException e) {
                tv.setHint("Ʈσ cσηνɛгȶ εηȶεг α ναℓυɛ");
            }
        } catch (NegativeArraySizeException e) {
            tv.setHint("Cσηνɛгsíση ɛгrσг!");
        } catch (NumberFormatException e) {
            tv.setHint("Ʈσ cσηνɛгȶ εηȶεг α ναℓυɛ");
        } catch (Exception e) {
            tv.setText(In1);
            tv.append(Html.fromHtml(" = " + (nf.format(output)) + " " + "<b>" + shortcut.getUnit().get(to) + "</b>"));

        }
    }


    //Normal Format
    //@Contract("_ -> param1")
    public static TextView normForm(TextView tv) {
        try {
            In1 = Html.fromHtml(nf.format(input) + " " + "<b>" + shortcut.getUnit().get(from) + "</b>" + " ");
            tv.setText(In1);
            tv.append(Html.fromHtml(" = " + nf.format((output)) + " " + "<b>" + shortcut.getUnit().get(to) + "</b>"));
        } catch (Exception e) {
            tv.setHint("Ʈσ cσηνɛгȶ εηȶεг α ναℓυɛ");
        }
        return tv;
    }

    //Standard Format
    //@Contract("_ -> param1")
    public static TextView stdForm(TextView tv) {
        try {
            if (input > apprMax || input < 0.001 && input > 0) {
                String strI = String.valueOf(input);
                String powerI = strI.replaceAll("E", " x 10#");
                String[] partsI = powerI.split("#");
                prefixI = partsI[0];
                sufixI = partsI[1];
                In1 = Html.fromHtml(prefixI + "<sup><small>" + sufixI + "</small></sup>" + " " + "<b>" + shortcut.getUnit().get(from) + "</b>" + " ");
            }

            if (input < -apprMax || input > -0.001) {
                String strI = String.valueOf(input);
                String powerI = strI.replaceAll("E", " x 10#");
                String[] partsI = powerI.split("#");
                prefixI = partsI[0];
                sufixI = partsI[1];
                In1 = Html.fromHtml(prefixI + "<sup><small>" + sufixI + "</small></sup>" + " " + "<b>" + shortcut.getUnit().get(from) + "</b>" + " ");
            }

            if (output > apprMax || output < 0.001) {
                tv.setText(In1);
                tv.append(Html.fromHtml(" = " + prefixO + "<sup><small>" + sufixO + "</small></sup>" + " " + "<b>" + shortcut.getUnit().get(to) + "</b>"));
            } else {
                normForm(tv);
            }
        } catch (Exception e) {
            tv.setHint("Ʈσ cσηνɛгȶ εηȶεг α ναℓυɛ");
        }
        return tv;
    }

    //Decimal Place
    @NonNull
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static String dp(Double dbl) {
        return Double.valueOf(new DecimalFormat("#.#########").format(dbl)).toString();
    }

    //Data
    private void tempData()
    {
        //---Input
        switch (from) {
            case "Celsius":
                mC = input;
                mF = ((mC * 9) / 5) + 32;
                mK = mC + 273.15;
                mR = ((mC + 273.15) * 9) / 5;
                mN = (mC * 33) / 100;
                mDe = ((100 - mC) * 3) / 2;
                mRe = (mC * 4) / 5;
                mRo = ((mC * 21) / 40) + 7.5;
                mGM = ((mC - 148.888) * 9) / 125;
                break;
            case "Delisle":
                mDe = input;
                mC = 100 - ((mDe * 2) / 3);
                mF = 212 - ((mDe * 6) / 5);
                mK = 373.15 - ((mDe * 2) / 3);
                mR = 671.67 - ((mDe * 6) / 5);
                mN = 33 - ((mDe * 11) / 50);
                mRe = 80 - ((mDe * 8) / 15);
                mRo = 60 - ((mDe * 7) / 20);
                mGM = ((-mDe - 73.332) * 6) / 125;
                break;
            case "Fahrenheit":
                mF = input;
                mC = (((mF - 32) * 5) / 9);
                mK = ((mF + 459.67) * 5) / 9;
                mR = mF + 459.67;
                mN = ((mF - 32) * 11) / 60;
                mDe = ((212 - mF) * 5) / 6;
                mRe = ((mF - 32) * 4) / 9;
                mRo = (((mF - 32) * 7) / 24) + 7.5;
                mGM = (mF + 37.632) * 0.04;
                break;
            case "Kelvin":
                mK = input;
                mC = mK - 273.15;
                mF = ((mK - 273.15) * 1.8000) + 32.00;
                mR = (mK * 9) / 5;
                mN = ((mK - 273.15) * 33) / 100;
                mDe = ((373.15 - mK) * 3) / 2;
                mRe = ((mK - 273.15) * 4) / 5;
                mRo = (((mK - 273.15) * 21) / 40) + 7.5;
                mGM = (mK - 422.038) * 0.072;
                break;
            case "Newton":
                mN = input;
                mC = (mN * 100) / 33;
                mF = ((mN * 60) / 11) + 32;
                mK = ((mN * 100) / 33) + 273.15;
                mR = ((mN * 60) / 11) + 491.67;
                mDe = ((33 - mN) * 50) / 11;
                mRe = (mN * 80) / 33;
                mRo = ((mN * 35) / 22) + 7.5;
                mGM = (mN - 49.13304) * (12 / 55);
                break;
            case "Rankine":
                mR = input;
                mC = ((mR * 5) / 9) - 273.15;
                mF = mR - 459.67;
                mK = (mR * 5) / 9;
                mN = ((mR - 491.67) * 11) / 60;
                mDe = ((671.67 - mR) * 5) / 6;
                mRe = ((((mR * 5) / 9) + 273.15) * 4) / 5;
                mRo = (((mR - 491.67) * 7) / 24) + 7.5;
                mGM = (mR - 759.6684) * 0.04;
                break;
            case "Réaumur":
                mRe = input;
                mC = (mRe * 5) / 4;
                mF = ((mRe * 9) / 4) + 32;
                mK = ((mRe * 4) / 4) + 273.15;
                mR = ((mRe * 9) / 4) + 491.67;
                mN = (mRe * 33) / 80;
                mDe = ((373.15 - mK) * 3) / 2;
                mRo = ((mRe * 21) / 32) + 7.5;
                mGM = (mRe - 119.1104) * 0.09;
                break;
            case "Regulo Gas Mark":
                mGM = input;
                mC = ((mGM * 125) / 9) + 148.888;
                mF = (mGM * 25) - 37.632;
                mK = ((mGM * 125) / 9) + 422.038;
                mR = (mGM * 25) + 759.6684;
                mN = ((mGM * 55) / 12) + 49.13304;
                mDe = ((-mGM * 125) / 6) - 73.332;
                mRe = ((mGM * 100) / 9) + 119.1104;
                mRo = (((mGM * 175) / 24) + 78.162) + 7.5;
                break;
            case "Rømer":
                mRo = input;
                mC = ((mRo - 7.5) * 40) / 21;
                mF = (((mRo - 7.5) * 24) / 7) + 32;
                mK = (((mRo - 7.5) * 40) / 21) + 273.15;
                mR = (((mRo - 7.5) * 24) / 7) + 491.67;
                mN = ((mRo - 7.5) * 22) / 35;
                mDe = ((60 - mRo) * 20) / 7;
                mRe = ((mRo - 7.5) * 32) / 21;
                mGM = ((mRo - 7.5) - 78.162) * (24 / 175);
                break;
        }

        //---Output
        switch (to) {
            case "Celsius":
                output = mC;
                break;
            case "Delisle":
                output = mDe;
                break;
            case "Fahrenheit":
                output = mF;
                break;
            case "Kelvin":
                output = mK;
                break;
            case "Newton":
                output = mN;
                break;
            case "Rankine":
                output = mR;
                break;
            case "Réaumur":
                output = mRe;
                break;
            case "Rømer":
                output = mRo;
                break;
            case "Regulo Gas Mark":
                output = mGM;
                break;
        }
    }
}

