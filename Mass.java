package com.dixfobby.myworld.Calculator;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Spinner;
import android.text.Html;

import com.dixfobby.myworld.R;

import java.text.DecimalFormat;
import android.icu.text.*;

public class Mass extends Fragment implements OnClickListener
{
	private TextView tv;
    private EditText et;
	private Double input, output;
	private Spinner sfrom, sto;
    private String from, to;
	private ArrayAdapter<String> fromAdap, toAdap;
	private String[] units;
	private ShortCuts shortcut;
	private String prefix, sufix;
	private NumberFormat nf,mf;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.activity_mass, container, false);

		mf = nf = NumberFormat.getInstance();
		nf.setMaximumIntegerDigits(9);


		shortcut = new ShortCuts();

		tv = view.findViewById(R.id.txtWeight);
		et = view.findViewById(R.id.editWeight);

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
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
				{
					from = sfrom.getSelectedItem().toString();
				}

				@Override
				public void onNothingSelected(AdapterView<?> parent)
				{

				}
			});

		sto.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
				@Override
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
				{
					to = sto.getSelectedItem().toString();
				}

				@Override
				public void onNothingSelected(AdapterView<?> parent)
				{

				}
			});

		return view;
	}

	public int reverse(int i)
	{
		int rev = 0;
		while (i > 0)
		{
			int rem = i % 10;
			rev = (rev * 10) + rem;
			i = i / 10;
		}
		return rev;
	}

	@Override
	public void onClick(View v)
	{
		//try
		//{
		input = Double.parseDouble(et.getText().toString());

		output = (solve(input, from, to));

		if (input < 10000000)
		{
			/*String a = String.valueOf(input);
		    String b = a.replace(".0", "");
		    Integer c = Integer.valueOf(b);
		    Integer d = Integer.valueOf(KixfInteger.reverse(c));
			String e = String.valueOf(d);
			Double f = Double.valueOf(e);
			String g = nf.format(f);
			String h = g.replace(",", "");
			Integer i = Integer.valueOf(h);
			Integer j = Integer.valueOf(KixfInteger.reverse(i));
			Double k = Double.valueOf(j);
			String l = mf.format(k);
			String m = l.toString();*/
			
			int iPower;
			String a = String.valueOf(input);
			String b = a.replace(".0", "");
			
			String dot = ".";
			String base = " x 10^";
			
			if (b.contains(".")) {
			String rp = b.replaceAll(".", "#");
			String[] parts = rp.split("#");
			String suf = parts[1];
			int ext = suf.length();
			iPower = b.length() + ext -1;
			}
			else {
			iPower = b.length() - 1;
			}
			
			String power = String.valueOf(iPower);
			String c1 = b.substring(0,1);
			String c2 = b.substring(1);
			String d = c1.concat(dot).concat(c2);
			
			String e = d.concat(base).concat(power);
			
			tv.setText(e);
		}

		//))).toString()));

		/*if (output > 1000 || output < 0.001)
		 {
		 String str = String.valueOf(output);

		 String power = str.replaceAll("E", " x 10#");
		 String[] parts = power.split("#");
		 prefix = parts[0];
		 sufix = parts[1];

		 try
		 {
		 tv.setText(Html.fromHtml(input + "</small></sup>" + " " + "<b>" + shortcut.getShortCutMap().get(from) + "</b>" + " = " + prefix + "<sup><small>" + sufix + "</small></sup>" + " " + "<b>" + shortcut.getShortCutMap().get(to) + "</b>"));
		 }

		 catch (Exception e)
		 {
		 tv.setText(Html.fromHtml(input + " " + "<b>" + shortcut.getShortCutMap().get(from) + "</b>" + " = " + fmt(solve(input, from, to)) + " " + "<b>" + shortcut.getShortCutMap().get(to) + "</b>"));
		 }
		 }
		 else if (output <= 1000 || output >= 0.001 || output == 0)
		 {
		 tv.setText(Html.fromHtml(input + " " + "<b>" + shortcut.getShortCutMap().get(from) + "</b>" + " = " + formatDecimal(solve(input, from, to)) + " " + "<b>" + shortcut.getShortCutMap().get(to) + "</b>"));

		 if (input <= 1000 || input >= 0.001 || input == 0)
		 {
		 tv.setText(Html.fromHtml(formatDecimal(input) + " " + "<b>" + shortcut.getShortCutMap().get(from) + "</b>" + " = " + formatDecimal(solve(input, from, to)) + " " + "<b>" + shortcut.getShortCutMap().get(to) + "</b>"));
		 }
		 }*/

		//}
		/*catch (NumberFormatException e)
		 {
		 tv.setText("To Convert Enter A Value");
		 }*/
	}

	public static Double fmt(Double dbl)
	{
		return Double.valueOf(new DecimalFormat("#.###").format(dbl));
	}

	public static String formatDecimal(Double dbl)
	{
		return Double.valueOf(new DecimalFormat("#.####").format(dbl)).toString();
	}

	public enum Mass_Ratio
	{
		Atomic_Mass_Unit(1.6605*Math.pow(10,-24)),
		Carat (0.2),
		Centigram(1*Math.pow(10,-2)),
		Decagram(1*Math.pow(10,1)),
		Decigram(1*Math.pow(10,-1)),
		ElectronVolt(1.782661*Math.pow(10,-33)),
		Gamma(1*Math.pow(10,-9)),
		Grain(0.0648),
		Gram(1),
		Hectogram(1*Math.pow(10,2)),
		Long_Hundred_Weight(50802.3554),
		Kilogram (1*Math.pow(10,3)),
		LongTon(1.0160*Math.pow(10,6)),
		Megagram(1*Math.pow(10,6)),
		MetricTonne(1*Math.pow(10,6)),
		Microgram(1*Math.pow(10,-6)),
        Milligram(1*Math.pow(10,-3)),
		Mite(3.2399455*Math.pow(10,-6)),
		Ounce (28.3495),
		PlanckMass(2.1765*Math.pow(10,-5)),
		Poundal(0.01408672),
        Pound (453.5924),
		PoundFource(14.593902937),
		Quintal(1*Math.pow(10,5)),
		ShortTon(9.0718474*Math.pow(10,5)),
        Slug(14593.903),  
        Stone(6350.29318),
        Short_Hundred_Weight(45359.237),
        Talent(20400);

		private final double ratio;

        Mass_Ratio(double ratio){
            this.ratio = ratio;
        }
        private double getRatio(){
            return ratio;
        }
	}

	private Double solve(double input, String from, String to)
	{
		Double factor = getFactor(from, to);
        return input * factor;
	}

	private double getFactor(String from, String to)
	{
        return  Mass_Ratio.valueOf(from).getRatio() /  Mass_Ratio.valueOf(to).getRatio();
    }
}


