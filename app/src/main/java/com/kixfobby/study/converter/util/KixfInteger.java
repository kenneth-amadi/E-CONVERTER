package com.kixfobby.study.converter.util;

import android.icu.text.NumberFormat;
import android.os.Build;

import androidx.annotation.RequiresApi;

public class KixfInteger {
    private static NumberFormat mf, nf;
    private Integer c, d, i, j;
    private Double f, k;
    private String a, b, e, g, h, l;

    public int reverse(int i) {
        int rev = 0;
        while (i > 0) {
            int rem = i % 10;
            rev = (rev * 10) + rem;
            i = i / 10;
        }
        return rev;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void nFormat() {
        int pattern;
        pattern = 5;
        mf = NumberFormat.getInstance();
        nf = NumberFormat.getInstance();
        nf.setMaximumIntegerDigits(pattern);
    }

    public String stdFormat(Double input) {
        //if (input < 10000000) {
        a = String.valueOf(input);
        String[] parts = a.split(".");
        String suf = parts[1];
        //b = a.replace(".0", "");
            c = Integer.valueOf(suf);
            d = reverse(c);
            e = String.valueOf(d);
            f = Double.valueOf(e);
            g = nf.format(f);
            h = g.replace(",", "");
            i = Integer.valueOf(h);
            j = reverse(i);
            k = Double.valueOf(j);
            l = mf.format(k);
        //}
        return parts[0].concat(".").concat(l);
    }

    public String format(Double input) {
        return mf.format(input);
    }

}
