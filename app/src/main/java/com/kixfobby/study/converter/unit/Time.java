package com.kixfobby.study.converter.unit;

import android.annotation.SuppressLint;
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

import java.text.DecimalFormat;
import java.util.Objects;

public class Time extends Fragment implements OnClickListener {
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

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.converter_main, container, false);

        shortcut = new ShortCuts();

        tv = view.findViewById(R.id.txt);
        et = view.findViewById(R.id.edit);

        view.findViewById(R.id.btnConvert).setOnClickListener(this);

        sfrom = view.findViewById(R.id.fromSpin);
        sto = view.findViewById(R.id.toSpin);

        String[] units = getResources().getStringArray(R.array.time);

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

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {
        nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(10);

        try {
            String insert = et.getText().toString();
            input = Double.parseDouble(insert);
            output = solve(input);

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

    @NonNull
    public static String dp(Double dbl) {
        return Double.valueOf(new DecimalFormat("#.#########").format(dbl)).toString();
    }

    @NonNull
    private static Double solve(double input) {
        return input * factor(from, to);
    }

    private static double factor(String from, String to) {
        return shortcut.getFactor().get(from) / shortcut.getFactor().get(to);
    }
}


