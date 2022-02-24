package com.kixfobby.study.converter.unit;

import android.os.Bundle;
import android.text.Html;
import android.text.InputType;
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
import androidx.fragment.app.Fragment;

import com.kixfobby.study.converter.R;
import com.kixfobby.study.converter.util.ShortCuts;

import java.math.BigInteger;
import java.util.Objects;


public class Base extends Fragment implements OnClickListener
{
	private TextView tv;
    private EditText et;
    private Spinner sfrom, sto;
    private String from, to;
    private ShortCuts shortcut;

	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.converter_main, container, false);

		shortcut = new ShortCuts();

		tv = view.findViewById(R.id.txt);
		et = view.findViewById(R.id.edit);

		view.findViewById(R.id.btnConvert).setOnClickListener(this);

		sfrom = view.findViewById(R.id.fromSpin);
		sto = view.findViewById(R.id.toSpin);

        String[] units = getResources().getStringArray(R.array.base);

        ArrayAdapter<String> fromAdap = new ArrayAdapter<>(Objects.requireNonNull(getContext()), R.layout.spinner_item, units);
		sfrom.setAdapter(fromAdap);

        ArrayAdapter<String> toAdap = new ArrayAdapter<>(getContext(), R.layout.spinner_item, units);
		sto.setAdapter(toAdap);

		sfrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				from = sfrom.getSelectedItem().toString();

				if (factor(from) > 10)
				{
					et.setInputType(InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS);
				}
				else
				{
					et.setInputType(InputType.TYPE_CLASS_NUMBER);
				}
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
	@Override
	public void onClick(View v)
	{
		try
		{
            String input = et.getText().toString().toUpperCase();
			BigInteger i= new BigInteger(input, factor(from));
            String output = i.toString(factor(to)).toUpperCase();
			tv.setText(Html.fromHtml(input + " " + "<b>" + shortcut.getUnit().get(from) + "</b>" + " = " + output + " " + "<b>" + shortcut.getUnit().get(to) + "</b>"));
		}
		catch (NumberFormatException e)
		{
			e.printStackTrace();
			tv.setText("Input not valid!");
		}
	}


	private Integer factor(String from)
	{
		return shortcut.getFac().get(from);
	}

}

