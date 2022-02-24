package com.kixfobby.study.converter.unit;

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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.kixfobby.study.converter.ui.Converter;
import com.kixfobby.study.converter.R;
import com.kixfobby.study.converter.util.ShortCuts;

public class Mass extends Fragment implements OnClickListener {
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
    private ArrayAdapter<String> fromAdap, toAdap;
    private String[] units;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.converter_main, container, false);

        shortcut = new ShortCuts();

        tv = view.findViewById(R.id.txt);
        et = view.findViewById(R.id.edit);

        view.findViewById(R.id.btnConvert).setOnClickListener(this);

        sfrom = view.findViewById(R.id.fromSpin);
        sto = view.findViewById(R.id.toSpin);

        units = getResources().getStringArray(R.array.mass);

        fromAdap = new ArrayAdapter<String>(getContext(), R.layout.spinner_item, units);
        sfrom.setAdapter(fromAdap);

        toAdap = new ArrayAdapter<String>(getContext(), R.layout.spinner_item, units);
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
    public static TextView normForm(TextView tv) {
        try {
            In1 = Html.fromHtml(nf.format(input) + " " + "<b>" + shortcut.getUnit().get(from) + "</b>" + " ");
            tv.setText(In1);
            tv.append(Html.fromHtml(" = " + String.valueOf(nf.format(output)) + " " + "<b>" + shortcut.getUnit().get(to) + "</b>"));
        } catch (Exception e) {
            tv.setHint("Ʈσ cσηνɛгȶ εηȶεг α ναℓυɛ");
        }
        return tv;
    }

    //Standard Format
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

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static String dp(Double dbl) {
        return Double.valueOf(new DecimalFormat("#.#########").format(dbl)).toString();
    }

    public enum Mass_Ratio {
        Atomic_mass_unit(1.6605 * Math.pow(10, -24)),
        Carat(0.2),
        Centigram(1 * Math.pow(10, -2)),
        Decagram(1 * Math.pow(10, 1)),
        Decigram(1 * Math.pow(10, -1)),
        ElectronVolt(1.782661 * Math.pow(10, -33)),
        Gamma(1 * Math.pow(10, -9)),
        Grain(0.0648),
        Gram(1),
        Hectogram(1 * Math.pow(10, 2)),
        Long_hundred_weight(50802.3554),
        Kilogram(1 * Math.pow(10, 3)),
        LongTon(1.0160 * Math.pow(10, 6)),
        Megagram(1 * Math.pow(10, 6)),
        MetricTonne(1 * Math.pow(10, 6)),
        Microgram(1 * Math.pow(10, -6)),
        Milligram(1 * Math.pow(10, -3)),
        Mite(3.2399455 * Math.pow(10, -6)),
        Ounce(28.3495),
        PlanckMass(2.1765 * Math.pow(10, -5)),
        Poundal(0.01408672),
        Pound(453.5924),
        PoundForce(14.593902937),
        Quintal(1 * Math.pow(10, 5)),
        ShortTon(9.0718474 * Math.pow(10, 5)),
        Slug(14593.903),
        Stone(6350.29318),
        Short_hundred_weight(45359.237),
        Talent(20400);

        private final double ratio;

        Mass_Ratio(double ratio) {
            this.ratio = ratio;
        }

        private double getRatio() {
            return ratio;
        }
    }


    private static Double solve(double input) {
        return input * factor(from, to);
    }

    private static Double factor(String from, String to) {
        return getFactor(from, to);
    }

    private static double getFactor(String from, String to) {
        return Mass_Ratio.valueOf(from).getRatio() / Mass_Ratio.valueOf(to).getRatio();
    }
}


