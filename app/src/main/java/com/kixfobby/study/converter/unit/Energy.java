package com.kixfobby.study.converter.unit;

import android.annotation.SuppressLint;
import android.icu.text.NumberFormat;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;

import com.kixfobby.study.converter.R;
import com.kixfobby.study.converter.ui.Converter;
import com.kixfobby.study.converter.util.ShortCuts;

import java.text.DecimalFormat;
import java.util.Objects;

//import org.jetbrains.annotations.Contract;

@SuppressLint("StaticFieldLeak")
public class Energy extends Fragment implements OnClickListener {
    private static final Double apprMax = 9999999.999999999;
    public static TextView tv;
    public static String Out, Out1, Out2;
    private static String from, to;
    private static String prefixI, prefixO, sufixI, sufixO;
    private static ShortCuts shortcut;
    private static Spanned In1;
    private static Double input, output;
    private static NumberFormat mf, nf;
    public LinearLayoutCompat background;
    private Spinner sfrom, sto;
    private EditText et;
    private long f, t;

    //Normal Format
    //@Contract("_ -> param1")
    public static TextView normForm(TextView tv) {
        try {
            In1 = Html.fromHtml(format((input)) + " " + "<b>" + shortcut.getUnit().get(from) + "</b>" + " ");
            tv.setText(In1);
            tv.append(Html.fromHtml(" = " + format((output)) + " " + "<b>" + shortcut.getUnit().get(to) + "</b>"));
        } catch (Exception e) {
            tv.setHint("Ʈσ cσηνɛгȶ εηȶεг α ναℓυɛ");
        }
        return tv;
    }

    //Standard Format
    //@Contract("_ -> param1")
    public static TextView stdForm(TextView tv) {
        try {
            /*if (input > apprMax || input < 0.001 && input > 0) {
                String strI = String.valueOf(input);
                String powerI = strI.replaceAll("E", " x 10#");
                String[] partsI = powerI.split("#");
                prefixI = partsI[0];
                sufixI = partsI[1];
                String[] part = prefixI.split("x");
                String pre = part[0];
                String pre2 = part[1];
                In1 = Html.fromHtml((dp(Double.valueOf(pre)) + " x" + pre2) + "<sup><small>" + sufixI + "</small></sup>" + " " + "<b>" + shortcut.getUnit().get(from) + "</b>" + " ");
            }

            if (input < -apprMax || input > -0.001) {
                String strI = String.valueOf(input);
                String powerI = strI.replaceAll("E", " x 10#");
                String[] partsI = powerI.split("#");
                prefixI = partsI[0];
                sufixI = partsI[1];
                String[] part = prefixI.split("x");
                String pre = part[0];
                String pre2 = part[1];
                In1 = Html.fromHtml((dp(Double.valueOf(pre)) + " x" + pre2) + "<sup><small>" + sufixI + "</small></sup>" + " " + "<b>" + shortcut.getUnit().get(from) + "</b>" + " ");
            }
*/
            inFunc();

            if (output > apprMax || output < 0.001) {
                String[] part = prefixO.split("x");
                String pre = part[0];
                String pre2 = part[1];
                tv.setText(In1);
                tv.append(Html.fromHtml(" = " + (stdFormatOut(pre) + " x" + pre2) + "<sup><small>" + sufixO + "</small></sup>" + " " + "<b>" + shortcut.getUnit().get(to) + "</b>"));
            } else {
                normForm(tv);
            }
        } catch (Exception e) {
            tv.setHint("Ʈσ cσηνɛгȶ εηȶεг α ναℓυɛ");
        }
        return tv;
    }

    @NonNull
    public static Double dp(Double dbl) {
        String pattern;
        pattern = "#.####";
        return Double.valueOf(new DecimalFormat(pattern).format(dbl));
    }

    @NonNull
    public static String dps(String dbl) {
        String pattern;
        pattern = "#.#####";
        return new DecimalFormat(pattern).format(dbl);
    }

    @NonNull
    private static Double solve(double input) {
        return input * factor(from, to);
    }

    @SuppressWarnings("ConstantConditions")
    private static double factor(String from, String to) {
        return shortcut.getFactor().get(from) / shortcut.getFactor().get(to);
    }

    public static void inFunc() {
        //Input
        if (input > apprMax || input < 0.001 && input > 0) {
            String strI = String.valueOf(input);
            String powerI = strI.replaceAll("E", " x 10#");
            String[] partsI = powerI.split("#");
            prefixI = partsI[0];
            sufixI = partsI[1];
            String[] part = prefixI.split("x");
            String pre = part[0];
            String pre2 = part[1];
            In1 = Html.fromHtml((stdFormatIn(pre) + " x" + pre2) + "<sup><small>" + sufixI + "</small></sup>" + " " + "<b>" + shortcut.getUnit().get(from) + "</b>" + " ");
        } else
            In1 = Html.fromHtml(format(dp(input)) + " " + "<b>" + shortcut.getUnit().get(from) + "</b>" + " ");

        if (input < -apprMax || input > -0.001) {
            String strI = String.valueOf(input);
            String powerI = strI.replaceAll("E", " x 10#");
            String[] partsI = powerI.split("#");
            prefixI = partsI[0];
            sufixI = partsI[1];
            String[] part = prefixI.split("x");
            String pre = part[0];
            String pre2 = part[1];
            In1 = Html.fromHtml((stdFormatIn(pre) + " x" + pre2) + "<sup><small>" + sufixI + "</small></sup>" + " " + "<b>" + shortcut.getUnit().get(from) + "</b>" + " ");
        } else
            In1 = Html.fromHtml(format(dp(input)) + " " + "<b>" + shortcut.getUnit().get(from) + "</b>" + " ");

    }

    //@Contract(pure = true)
    public static int reverse(int i) {
        int rev = 0;
        while (i > 0) {
            int rem = i % 10;
            rev = (rev * 10) + rem;
            i = i / 10;
        }
        return rev;
    }

    @NonNull
    public static String stdFormatIn(String input) {
        String[] parts = input.split("\\.");
        String suf = parts[1].trim();
        int c = Integer.parseInt(suf);
        int d = reverse(c);
        String e = String.valueOf(d);
        Double f = Double.valueOf(e);
        String g = mf.format(f);
        String h = g.replace(",", "");
        int i = Integer.parseInt(h);
        int j = reverse(i);
        Double k = (double) j;
        String l = k.toString();
        String m = parts[0].concat(".").concat(l);
        String b = m.replace(".0", "");
        Double n = Double.valueOf(b);

        return mf.format(n);
    }

    @NonNull
    public static String stdFormatOut(String output) {
        String[] parts = output.split("\\.");
        String suf = parts[1].trim();
        int c = Integer.parseInt(suf);
        int d = reverse(c);
        String e = String.valueOf(d);
        Double f = Double.valueOf(e);
        String g = mf.format(f);
        String h = g.replace(",", "");
        int i = Integer.parseInt(h);
        int j = reverse(i);
        Double k = (double) j;
        String l = k.toString();
        String m = parts[0].concat(".").concat(l);
        String b = m.replace(".0", "");
        Double n = Double.valueOf(b);

        return mf.format(n);
    }

    public static String format(Double input) {
        return mf.format(input);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.converter_main, container, false);

        /*kixfInteger = new KixfInteger();*/
        nFormat();

        shortcut = new ShortCuts();

        tv = view.findViewById(R.id.txt);
        et = view.findViewById(R.id.edit);
        PreferenceManager.getDefaultSharedPreferences(getContext()).edit().putString("input", et.getText().toString()).apply();

        //view.findViewById(R.id.bt_switch).setOnClickListener(this);
        view.findViewById(R.id.btnConvert).setOnClickListener(this);

        sfrom = view.findViewById(R.id.fromSpin);
        sto = view.findViewById(R.id.toSpin);

        String[] units = getResources().getStringArray(R.array.energy);

        ArrayAdapter<String> fromAdap = new ArrayAdapter<>(Objects.requireNonNull(getContext()), R.layout.spinner_item, units);
        sfrom.setAdapter(fromAdap);

        ArrayAdapter<String> toAdap = new ArrayAdapter<>(getContext(), R.layout.spinner_item, units);
        sto.setAdapter(toAdap);

        sfrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                f = sfrom.getSelectedItemId();
                from = sfrom.getSelectedItem().toString();
                PreferenceManager.getDefaultSharedPreferences(getContext()).edit().putString("input", et.getText().toString()).apply();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sto.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                t = sto.getSelectedItemId();
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
    public void onClick(@NonNull View v) {
        if (v.getId() == R.id.btnConvert) {
            nFormat();

            try {
                String in = PreferenceManager.getDefaultSharedPreferences(getContext()).getString("input", "i");
                //String insert = in;
                String insert = et.getText().toString();
                input = Double.parseDouble(insert);
                output = solve(input);
                try {
                    //Output
                    if (output > apprMax || output < 0.001) {
                        String strO = String.valueOf(output);
                        String powerO = strO.replaceAll("E", " x 10#");
                        String[] partsO = powerO.split("#");
                        prefixO = partsO[0];
                        sufixO = partsO[1];
                        inFunc();

                        try {
                            if (Converter.isChecked) stdForm(tv);
                            else normForm(tv);
                        } catch (Exception e) {
                            tv.setText(In1);
                            tv.append(Html.fromHtml(" = " + format(dp(output)) + " " + "<b>" + shortcut.getUnit().get(to) + "</b>"));
                        }
                    } else {
                        inFunc();
                        tv.setText(In1);
                        tv.append(Html.fromHtml(" = " + format(dp(output)) + " " + "<b>" + shortcut.getUnit().get(to) + "</b>"));
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
                tv.append(Html.fromHtml(" = " + format(dp(output)) + " " + "<b>" + shortcut.getUnit().get(to) + "</b>"));

            }
        }

        if (v.getId() == R.id.bt_switch) {
            sto.setSelection((int) f);
            sfrom.setSelection((int) t);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void nFormat() {
        int pattern;
        pattern = 7;
        mf = NumberFormat.getInstance();
        nf = NumberFormat.getInstance();
        nf.setMaximumIntegerDigits(pattern);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}


