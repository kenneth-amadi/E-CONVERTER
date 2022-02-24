package com.kixfobby.study.converter.unit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.kixfobby.study.converter.R;


public class Interpolation extends Fragment implements OnClickListener {
    private TextView tv;
    private EditText et;
    private EditText key1, key2, value1, value2;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.converter_main3, container, false);

        tv = view.findViewById(R.id.txt);
        et = view.findViewById(R.id.edit);
        key1 = view.findViewById(R.id.key1);
        key2 = view.findViewById(R.id.key2);
        value1 = view.findViewById(R.id.value1);
        value2 = view.findViewById(R.id.value2);

        view.findViewById(R.id.btnConvert).setOnClickListener(this);
        view.findViewById(R.id.bt_switch).setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnConvert:
                try {
                    double a = Double.parseDouble(key1.getText().toString());
                    double b = Double.parseDouble(key2.getText().toString());
                    double c = Double.parseDouble(et.getText().toString());
                    double x = Double.parseDouble(value1.getText().toString());
                    double y = Double.parseDouble(value2.getText().toString());
                    double z = ((x * b) - (x * c) + (y * c) - (a * y)) / (b - a);

                    tv.setText(android.text.Html.fromHtml(c + " " + " = " + "<b>" + z + "</b>"));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    tv.setText("Input not valid!");
                }
                break;
            case R.id.bt_switch:
                String a = key1.getText().toString();
                String b = key2.getText().toString();
                String c = et.getText().toString();
                String x = value1.getText().toString();
                String y = value2.getText().toString();

                key1.setText(x);
                key2.setText(y);
                value1.setText(a);
                value2.setText(b);
                tv.setText("");

                break;
        }
    }

}

