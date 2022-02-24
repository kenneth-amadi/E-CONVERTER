package com.kixfobby.study.converter.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.tabs.TabLayout;
import com.kixfobby.study.converter.R;
import com.kixfobby.study.converter.unit.Area;
import com.kixfobby.study.converter.unit.Base;
import com.kixfobby.study.converter.unit.Currencies;
import com.kixfobby.study.converter.unit.Density;
import com.kixfobby.study.converter.unit.Energy;
import com.kixfobby.study.converter.unit.Flow;
import com.kixfobby.study.converter.unit.Force;
import com.kixfobby.study.converter.unit.Frequency;
import com.kixfobby.study.converter.unit.Interpolation;
import com.kixfobby.study.converter.unit.Length;
import com.kixfobby.study.converter.unit.Mass;
import com.kixfobby.study.converter.unit.Power;
import com.kixfobby.study.converter.unit.Pressure;
import com.kixfobby.study.converter.unit.Speed;
import com.kixfobby.study.converter.unit.Temperature;
import com.kixfobby.study.converter.unit.Time;
import com.kixfobby.study.converter.unit.Viscosity;
import com.kixfobby.study.converter.unit.Volume;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//import org.jetbrains.annotations.Nullable;


public class Converter extends AppCompatActivity {
    private static final String TAG = "GpActivity";
    private static final String APP_ID = "ca-app-pub-2571017324761827~9409368734";
    public static boolean isChecked;
    private ViewPager viewPager;
    private AdView mAdView;
    private BottomSheetBehavior mBehavior;
    private BottomSheetDialog mBottomSheetDialog;
    private CheckBox sf_checkBox, bg_checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {
                //Toasty.success(getBaseContext(), "Load Successful!");
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        View bottom_sheet = findViewById(R.id.bottom_sheet);
        mBehavior = BottomSheetBehavior.from(bottom_sheet);

        /* NB  The default value is the actual thing you had in mind to set up bt preference and should be caught by on the first click */
        if (getSharedPreferences("bg", Context.MODE_PRIVATE).getBoolean("light", false))
            viewPager.setBackgroundColor(getResources().getColor(R.color.background_dark));
        else viewPager.setBackgroundColor(getResources().getColor(R.color.background_light));

        isChecked = (getSharedPreferences("cb", Context.MODE_PRIVATE).getBoolean("check", false));
    }

    private void setupViewPager(@NonNull ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new Interpolation(), "INTERPOLATION");
        adapter.addFrag(new Area(), "AREA");
        adapter.addFrag(new Base(), "BASE");
        adapter.addFrag(new Density(), "DENSITY");
        adapter.addFrag(new Energy(), "ENERGY");
        adapter.addFrag(new Flow(), "FLOW");
        adapter.addFrag(new Force(), "FORCE");
        adapter.addFrag(new Frequency(), "FREQUENCY");
        adapter.addFrag(new Length(), "LENGTH");
        adapter.addFrag(new Mass(), "MASS");
        adapter.addFrag(new Power(), "POWER");
        adapter.addFrag(new Pressure(), "PRESSURE");
        adapter.addFrag(new Speed(), "SPEED");
        adapter.addFrag(new Temperature(), "TEMPERATURE");
        adapter.addFrag(new Time(), "TIME");
        adapter.addFrag(new Viscosity(), "VISCOSITY");
        adapter.addFrag(new Volume(), "VOLUME");
        adapter.addFrag(new Currencies(), "CURRENCY");
        viewPager.setAdapter(adapter);

        adapter.getPageTitle(1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        menu.add("Options")
                .setIcon(R.drawable.ic_menu)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        showMenu_A();
        return true;
    }

    @Nullable
    private TextView sf() {
        isChecked = false;
        switch (ViewPagerAdapter.mFragmentList.toString()) {
            case "Area":
                return Area.stdForm(Area.tv);

            case "Density":
                return Density.stdForm(Density.tv);

            case "Energy":
                return Energy.stdForm(Energy.tv);

            case "Flow":
                return Flow.stdForm(Flow.tv);

            case "Force":
                return Force.stdForm(Force.tv);

            case "Frequency":
                return Frequency.stdForm(Frequency.tv);

            case "Length":
                return Length.stdForm(Length.tv);

            case "Mass":
                return Mass.stdForm(Mass.tv);

            case "Power":
                return Power.stdForm(Power.tv);

            case "Pressure":
                return Pressure.stdForm(Pressure.tv);

            case "Speed":
                return Speed.stdForm(Speed.tv);

            case "Temperature":
                return Temperature.stdForm(Temperature.tv);

            case "Time":
                return Time.stdForm(Time.tv);

            case "Viscosity":
                return Viscosity.stdForm(Viscosity.tv);

            case "Volume":
                return Volume.stdForm(Volume.tv);

            case "Currencies":
                return Currencies.stdForm(Currencies.tv);

            default:
        }
        return null;
    }

    @Nullable
    private TextView nf() {
        isChecked = true;
        switch (ViewPagerAdapter.mFragmentList.toString()) {
            case "Area":
                return Area.normForm(Area.tv);

            case "Density":
                return Density.normForm(Density.tv);

            case "Energy":
                return Energy.normForm(Energy.tv);

            case "Flow":
                return Flow.normForm(Flow.tv);

            case "Force":
                return Force.normForm(Force.tv);

            case "Frequency":
                return Frequency.normForm(Frequency.tv);

            case "Length":
                return Length.normForm(Length.tv);

            case "Mass":
                return Mass.normForm(Mass.tv);

            case "Power":
                return Power.normForm(Power.tv);

            case "Pressure":
                return Pressure.normForm(Pressure.tv);

            case "Speed":
                return Speed.normForm(Speed.tv);

            case "Temperature":
                return Temperature.normForm(Temperature.tv);

            case "Time":
                return Time.normForm(Time.tv);

            case "Viscosity":
                return Viscosity.normForm(Viscosity.tv);

            case "Volume":
                return Volume.normForm(Volume.tv);

            case "Currencies":
                return Currencies.normForm(Currencies.tv);

            default:
        }
        return null;
    }


    private void showMenu_A() {
        if (mBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            mBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }

        @SuppressLint("InflateParams") View view = getLayoutInflater().inflate(R.layout.menu_sheet_1, null);

        sf_checkBox = view.findViewById(R.id.check_box1);
        if (getSharedPreferences("cb", Context.MODE_PRIVATE).getBoolean("check", false))
            sf_checkBox.setChecked(true);
        else sf_checkBox.setChecked(false);

        bg_checkBox = view.findViewById(R.id.check_box2);
        if (getSharedPreferences("bg", Context.MODE_PRIVATE).getBoolean("light", false)) {
            bg_checkBox.setChecked(true);
        } else
            bg_checkBox.setChecked(false);

        view.findViewById(R.id.standard_form).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ((getSharedPreferences("cb", Context.MODE_PRIVATE).getBoolean("check", false))) {
                    sf_checkBox.setChecked(false);
                    SharedPreferences.Editor editor = getSharedPreferences("cb", Context.MODE_PRIVATE).edit();
                    editor.putBoolean("check", false);
                    editor.apply();
                    sf();
                } else {
                    sf_checkBox.setChecked(true);
                    SharedPreferences.Editor editor = getSharedPreferences("cb", Context.MODE_PRIVATE).edit();
                    editor.putBoolean("check", true);
                    editor.apply();
                    nf();
                }
            }
        });

        view.findViewById(R.id.background).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((getSharedPreferences("bg", Context.MODE_PRIVATE).getBoolean("light", false))) {
                    bg_checkBox.setChecked(false);
                    SharedPreferences.Editor editor = getSharedPreferences("bg", Context.MODE_PRIVATE).edit();
                    editor.putBoolean("light", false);
                    editor.apply();
                    //PreferenceManager.getDefaultSharedPreferences(getContext()).edit().putBoolean("light", false).apply();
                    viewPager.setBackgroundColor(getResources().getColor(R.color.background_light));
                } else {
                    bg_checkBox.setChecked(true);
                    SharedPreferences.Editor editor = getSharedPreferences("bg", Context.MODE_PRIVATE).edit();
                    editor.putBoolean("light", true);
                    editor.apply();
                    viewPager.setBackgroundColor(getResources().getColor(R.color.background_dark));
                }
            }
        });

        view.findViewById(R.id.clear_inputs).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //clearInputs();
            }
        });

        view.findViewById(R.id.remove_all).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //removeAll();
            }
        });

        view.findViewById(R.id.more).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //showMenu_B();
            }
        });


        mBottomSheetDialog = new BottomSheetDialog(this);
        mBottomSheetDialog.setContentView(view);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Objects.requireNonNull(mBottomSheetDialog.getWindow()).addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        mBottomSheetDialog.show();
        mBottomSheetDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                mBottomSheetDialog = null;
            }
        });
    }


    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
        /*if (!mInterstitialAd.isLoaded()) {
            requestNewInterstitial();
        }*/
    }

    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }

    @VisibleForTesting
    public AdView getAdView() {
        return mAdView;
    }

    private void checkIds() {
        if (APP_ID.equals(getString(R.string.admob_app_id))) {
            android.util.Log.w(TAG, "Your admob_app_id is not configured correctly, please see the README");
        }
    }


    public static class ViewPagerAdapter extends FragmentPagerAdapter {

        static final List<Fragment> mFragmentList = new ArrayList<>();
        static final List<String> mFragmentTitleList = new ArrayList<>();

        ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
