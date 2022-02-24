package com.kixfobby.study.converter.util;

import java.util.HashMap;

public class ShortCuts {

    private HashMap<String, String> unit;
    private HashMap<String, Integer> fac;
    private HashMap<String, Double> factor;
    private HashMap<String, Double> fact;

    public ShortCuts() {
        unit = new HashMap<>();
        fac = new HashMap<>();
        factor = new HashMap<>();

        //--------Area--------//
        unit.put("Acre", "ac");
        unit.put("Are", "a");
        unit.put("Barn", "b");
        unit.put("Board", "bd");
        unit.put("Circular", "circ in");
        unit.put("Cuerda", "cda");
        unit.put("Dunam", "dunam");
        unit.put("Guntha", "guntha");
        unit.put("Hectare", "ha");
        unit.put("Hide", "hide");
        unit.put("Ping", "ping");
        unit.put("Shed", "shed");
        unit.put("Square foot", "ft²");
        unit.put("Square inch", "in²");
        unit.put("Square kilometre", "km²");
        unit.put("Square metre", "m²");
        unit.put("Square mile", "mi²");
        unit.put("Square yard", "yd²");
        unit.put("Stremma", "stremma");
        unit.put("Township", "township");
        unit.put("Yardland", "yardland");

        factor.put("Acre", 4046.8564224);
        factor.put("Are", 100.0);
        factor.put("Barn", Math.pow(10, -28));
        factor.put("Board", 7.74192 * Math.pow(10, -3));
        factor.put("Circular", 5.067075 * Math.pow(10, -4));
        factor.put("Cuerda", 3930.395625);
        factor.put("Dunam", 1000.0);
        factor.put("Guntha", 101.17);
        factor.put("Hectare", 10000.0);
        factor.put("Hide", 5 * Math.pow(10, 5));
        factor.put("Ping", 3.306);
        factor.put("Shed", Math.pow(10, -52));
        factor.put("Square foot", 9.290304 * Math.pow(10, -2));
        factor.put("Square inch", 6.4516 * Math.pow(10, -4));
        factor.put("Square kilometre", Math.pow(10, 6));
        factor.put("Square metre", 1.0);
        factor.put("Square mile", 2.58999847 * Math.pow(10, 6));
        factor.put("Square yard", 0.83612736);
        factor.put("Stremma", 1000.0);
        factor.put("Township", 9.323994 * Math.pow(10, 7));


        //----------BASE----------//
        unit.put("Base 2", "(base 2)");
        unit.put("Base 3", "(base 3)");
        unit.put("Base 4", "(base 4)");
        unit.put("Base 5", "(base 5)");
        unit.put("Base 6", "(base 6)");
        unit.put("Base 7", "(base 7)");
        unit.put("Base 8", "(base 8)");
        unit.put("Base 9", "(base 9)");
        unit.put("Base 10", "(base 10)");
        unit.put("Base 11", "(base 11)");
        unit.put("Base 12", "(base 12)");
        unit.put("Base 13", "(base 13)");
        unit.put("Base 14", "(base 14)");
        unit.put("Base 15", "(base 15)");
        unit.put("Base 16", "(base 16)");
        unit.put("Base 17", "(base 17)");
        unit.put("Base 18", "(base 18)");
        unit.put("Base 19", "(base 19)");
        unit.put("Base 20", "(base 20)");
        unit.put("Base 21", "(base 21)");
        unit.put("Base 22", "(base 22)");
        unit.put("Base 23", "(base 23)");
        unit.put("Base 24", "(base 24)");
        unit.put("Base 25", "(base 25)");
        unit.put("Base 26", "(base 26)");
        unit.put("Base 27", "(base 27)");
        unit.put("Base 28", "(base 28)");
        unit.put("Base 29", "(base 29)");
        unit.put("Base 30", "(base 30)");
        unit.put("Base 31", "(base 31)");
        unit.put("Base 32", "(base 32)");
        unit.put("Base 33", "(base 33)");
        unit.put("Base 34", "(base 34)");
        unit.put("Base 35", "(base 35)");
        unit.put("Base 36", "(base 36)");

        fac.put("Base 2", 2);
        fac.put("Base 3", 3);
        fac.put("Base 4", 4);
        fac.put("Base 5", 5);
        fac.put("Base 6", 6);
        fac.put("Base 7", 7);
        fac.put("Base 8", 8);
        fac.put("Base 9", 9);
        fac.put("Base 10", 10);
        fac.put("Base 11", 11);
        fac.put("Base 12", 12);
        fac.put("Base 13", 13);
        fac.put("Base 14", 14);
        fac.put("Base 15", 15);
        fac.put("Base 16", 16);
        fac.put("Base 17", 17);
        fac.put("Base 18", 18);
        fac.put("Base 19", 19);
        fac.put("Base 20", 20);
        fac.put("Base 21", 21);
        fac.put("Base 22", 22);
        fac.put("Base 23", 23);
        fac.put("Base 24", 24);
        fac.put("Base 25", 25);
        fac.put("Base 26", 26);
        fac.put("Base 27", 27);
        fac.put("Base 28", 28);
        fac.put("Base 29", 29);
        fac.put("Base 30", 30);
        fac.put("Base 31", 31);
        fac.put("Base 32", 32);
        fac.put("Base 33", 33);
        fac.put("Base 34", 34);
        fac.put("Base 35", 35);
        fac.put("Base 36", 36);


        //--------Density--------//
        unit.put("Gram per millilitre", "g/mL");
        unit.put("Kilogram per cubic metre", "kg/m³");
        unit.put("Kilogram per litre", "kg/L");
        unit.put("Ounce per cubic foot", "oz/ft³");
        unit.put("Ounce per cubic inch", "oz/in³");
        unit.put("Ounce per gallon", "oz/gal");
        unit.put("Pound per cubic foot", "lb/ft³");
        unit.put("Pound per cubic inch", "lb/in³");
        unit.put("Pound per gallon", "lb/gal");
        unit.put("Slug per cubic foot", "slug/ft³");

        factor.put("Gram per millilitre", 1000.0);
        factor.put("Kilogram per cubic metre", 1.0);
        factor.put("Kilogram per litre", 1000.0);
        factor.put("Ounce per cubic foot", 1.001153961);
        factor.put("Ounce per cubic inch", 1.729994044 * Math.pow(10, 3));
        factor.put("Ounce per gallon", 6.236023291);
        factor.put("Pound per cubic foot", 16.01846337);
        factor.put("Pound per cubic inch", 2.767990471 * Math.pow(10, 4));
        factor.put("Pound per gallon", 99.77637266);
        factor.put("Slug per cubic foot", 515.3788184);


        //--------Energy--------//
        unit.put("Barrel of oil equivalent", "boe");
        unit.put("British thermal unit", "BTU");
        unit.put("Calorie", "cal");
        unit.put("Celsius heat unit", "CHU");
        unit.put("Cubic centimetre of atmosphere", "cc atm");
        unit.put("Cubic foot of atmosphere", "ft atm");
        unit.put("Cubic foot of natural gas", "ft ng");
        unit.put("Cubic yard of atmosphere", "cu yd atm");
        unit.put("Electronvolt", "eV");
        unit.put("Erg", "erg");
        unit.put("Foot pound force", "ft lbf");
        unit.put("Foot poundal", "ft pdl");
        unit.put("Gallon atmosphere", "gal atm");
        unit.put("Hartree", "E");
        unit.put("Horsepower hour", "hp·h");
        unit.put("Inch pound force", "in lbf");
        unit.put("Joule", "J");
        unit.put("Kilocalorie", "kcal");
        unit.put("Kilogrammeter", "kGm");
        unit.put("Kilojoule", "kJ");
        unit.put("Kilowatt hour", "kW·h");
        unit.put("Litre atmosphere", "l atm");
        unit.put("Quad", "quad");
        unit.put("Rydberg", "Ry");
        unit.put("Therm EC", "therm");
        unit.put("Therm US", "therm");
        unit.put("Thermie", "th");
        unit.put("Ton of coal equivalent", "TCE");
        unit.put("Tonne of oil equivalent", "toe");
        unit.put("Ton of TNT", "tTNT");
        unit.put("Watthour", "W.h");

        factor.put("Barrel of oil equivalent", 6.12 * Math.pow(10, 9));
        factor.put("British thermal unit", 1.0545 * Math.pow(10, 3));
        factor.put("Calorie", 4.1868);
        factor.put("Celsius heat unit", 1.899100534716 * Math.pow(10, 3));
        factor.put("Cubic centimetre of atmosphere", 0.101325);
        factor.put("Cubic foot of atmosphere", 2.8692044809344 * Math.pow(10, 3));
        factor.put("Cubic foot of natural gas", 1.05505585262 * Math.pow(10, 6));
        factor.put("Cubic yard of atmosphere", 77.4685209852288 * Math.pow(10, 3));
        factor.put("Electronvolt", 1.60217656535 * Math.pow(10, -19));
        factor.put("Erg", Math.pow(10, -7));
        factor.put("Foot pound force", 1.3558179483314004);
        factor.put("Foot poundal", 4.21401100938048 * Math.pow(10, -2));
        factor.put("Gallon atmosphere", 460.63256925);
        factor.put("Hartree", 4.359744 * Math.pow(10, -18));
        factor.put("Horsepower hour", 2.684519537696172792 * Math.pow(10, 6));
        factor.put("Inch pound force", 0.1129848290276167);
        factor.put("Joule", 1.0);
        factor.put("Kilocalorie", 4.1868 * Math.pow(10, 3));
        factor.put("Kilogrammeter", 9.80665);
        factor.put("Kilojoule", 1000.0);
        factor.put("Kilowatt hour", 3.6 * Math.pow(10, 6));
        factor.put("Litre atmosphere", 101.325);
        factor.put("Quad", 1.05505585262 * Math.pow(10, 18));
        factor.put("Rydberg", 2.179872 * Math.pow(10, -18));
        factor.put("Therm EC", 105.505585262 * Math.pow(10, 6));
        factor.put("Therm US", 105.4804 * Math.pow(10, 6));
        factor.put("Thermie", 4.1868 * Math.pow(10, 6));
        factor.put("Ton of coal equivalent", 29.288 * Math.pow(10, 9));
        factor.put("Tonne of oil equivalent", 41.868 * Math.pow(10, 9));
        factor.put("Ton of TNT", 4.184 * Math.pow(10, 9));
        factor.put("Watthour", 1.0);


        //Flow
        unit.put("Cubic foot per minute", "CFM");
        unit.put("Cubic foot per second", "ft³/s");
        unit.put("Cubic inch per minute", "in³/min");
        unit.put("Cubic inch per second", "in³/s");
        unit.put("Cubic metre per second", "m³/s");
        unit.put("Gallon per day", "GPD");
        unit.put("Gallon per hour", "GPH");
        unit.put("Gallon per minute", "GPM");
        unit.put("Litre per minute", "L/min");

        //Force
        unit.put("Atomic unit of force", "auf");
        unit.put("Dyne", "dyn");
        unit.put("Grave force", "Gf");
        unit.put("Gravet force", "gf");
        unit.put("Kilogram force", "kgf");
        unit.put("Kilopond", "kp");
        unit.put("KiloNewton", "kN");
        unit.put("Kip", "kip");
        unit.put("Long ton force", "tnf");
        unit.put("MegaNewton", "MN");
        unit.put("Milligrave force", "mGf");
        unit.put("Newton", "N");
        unit.put("Ounce force", "ozf");
        unit.put("Pound force", "lbf");
        unit.put("Poundal", "pdl");
        unit.put("Short ton force", "tnf");
        unit.put("Sthene", "sn");
        unit.put("TonForceMetric", "tf");

        //Frequency
        unit.put("Actions per minute", "APM");
        unit.put("Cycle per second", "cps");
        unit.put("Degree per second", "deg/s");
        unit.put("Hertz", "Hz");
        unit.put("Radian per second", "rad/s");
        unit.put("Revolutions per minute", "rpm");

        //length
        unit.put("Aͦngström", "Å");
        unit.put("Astronomical unit", "AU");
        unit.put("Attometre", "am");
        unit.put("Barleycorn", "barleycorn");
        unit.put("Bohr", "aₒ");
        unit.put("Cable length", "cable l");
        unit.put("Chain", "ch");
        unit.put("Cubit", "cubit");
        unit.put("Ell", "ell");
        unit.put("Fathom", "ftm");
        unit.put("Femtometre", "fm");
        unit.put("Fermi", "fm");
        unit.put("Finger", "finger");
        unit.put("Foot", "ft");
        unit.put("French", "F");
        unit.put("Furlong", "fur");
        unit.put("Hand", "hand");
        unit.put("Inch", "in");
        unit.put("League", "lea");
        unit.put("Light day", "lday");
        unit.put("Light hour", "lhr");
        unit.put("Light minute", "lmin");
        unit.put("Light second", "lsec");
        unit.put("Light year", "ly");
        unit.put("Line", "ln");
        unit.put("Link", "lnk");
        unit.put("Metre", "m");
        unit.put("Mickey", "mickey");
        unit.put("Micrometre", "Âµm");
        unit.put("Mil", "mil");
        unit.put("Mile", "mi");
        unit.put("Nail", "nail");
        unit.put("Nanometre", "nm");
        unit.put("Nautical league", "nl");
        unit.put("Nautical mile", "nmi");
        unit.put("Pace", "pace");
        unit.put("Palm", "palm");
        unit.put("Parsec", "pc");
        unit.put("Pica", "pica");
        unit.put("Picometre", "pm");
        unit.put("Point", "pt");
        unit.put("Quarter", "quater");
        unit.put("Rod", "rd");
        unit.put("Rope", "rope");
        unit.put("Shaku", "shaku");
        unit.put("Span", "span");
        unit.put("Spat", "spat");
        unit.put("Stick", "stick");
        unit.put("Toise", "T");
        unit.put("Twip", "twp");
        unit.put("X unit", "xu");
        unit.put("Yard", "yd");
        unit.put("Yoctometre", "ym");
        unit.put("Zeptometre", "zm");

        //Mass
        unit.put("Atomic mass unit", "amu");
        unit.put("Carat", "ct");
        unit.put("Centigram", "cg");
        unit.put("Decagram", "dg");
        unit.put("Decigram", "deci");
        unit.put("ElectronVolt", "ev");
        unit.put("Gamma", "Î³");
        unit.put("Grain", "gr");
        unit.put("Gram", "g");
        unit.put("Hectogram", "hectg");
        unit.put("Long hundred weight", "long cwt");
        unit.put("Kilogram", "kg");
        unit.put("LongTon", "AT");
        unit.put("Megagram", "Mg");
        unit.put("MetricTonne", "T");
        unit.put("Microgram", "Âµg");
        unit.put("Milligram", "mg");
        unit.put("Mite", "mite");
        unit.put("Ounce", "oz");
        unit.put("PlanckMass", "Pm");
        unit.put("Poundal", "pdl");
        unit.put("Pound", "lb");
        unit.put("PoundForce", "lbf");
        unit.put("Quintal", "q");
        unit.put("ShortTon", "sh tn");
        unit.put("Slug", "slug");
        unit.put("Stone", "st");
        unit.put("Short hundred weight", "sh cwt");
        unit.put("Talent", "talent");

        //Power
        unit.put("Atmosphere cubic centimetre per minute", "atm ccm");
        unit.put("Atmosphere cubic centimetre per second", "atm ccs");
        unit.put("Atmosphere cubic foot per hour", "atm cfh");
        unit.put("Atmosphere cubic foot per minute", "atm cfm");
        unit.put("Atmosphere cubic foot per second", "atm cfs");
        unit.put("BTU per hour", "BTU/h");
        unit.put("BTU per minute", "BTU/min");
        unit.put("BTU per second", "BTU/s");
        unit.put("Calorie per second", "cal/s");
        unit.put("Erg per second", "erg/s");
        unit.put("Foot pound force per hour)", "ft•lbf/h");
        unit.put("Foot pound force per minute", "ft•lbf/min");
        unit.put("Foot pound force per second", "ft•lbf/s");
        unit.put("Horsepower", "hp");
        unit.put("Kilowatt", "kW");
        unit.put("Litre atmosphere per minute", "L•atm/min");
        unit.put("Litre atmosphere per second", "L•atm/s");
        unit.put("Litre micrometre of mercury per second", "L•µmHg/s");
        unit.put("Lusec", "lusec");
        unit.put("Megawatt", "MW");
        unit.put("Poncelet", "p");
        unit.put("Square foot equivalent direct radiation", "sq ft EDR");
        unit.put("Ton of air conditioning", "tn");
        unit.put("Ton of refrigeration", "tn");
        unit.put("Watt", "W");

        //Pressure
        unit.put("Atmosphere", "atm");
        unit.put("Bar", "bar");
        unit.put("Barye", "barye");
        unit.put("Centimetre of mercury", "cmHg");
        unit.put("Centimetre of water", "cmH₂O");
        unit.put("Foot of mercury", "ftHg");
        unit.put("Foot of water", "ftH₂O");
        unit.put("Inch of mercury", "inHg");
        unit.put("Inch of water", "inH₂O");
        unit.put("Kilogram force per square millimetre", "kgf/mm²");
        unit.put("Kip per square inch", "ksi");
        unit.put("Long ton per square foot", "tn/ft²");
        unit.put("Micrometre of mercury", "µmHg");
        unit.put("Millimetre of mercury", "mmHg");
        unit.put("Millimetre of water", "mmH₂O");
        unit.put("Pascal", "Pa");
        unit.put("PiÃ¨ze", "pz");
        unit.put("Pound per square foot", "psf(lnf/ft²)");
        unit.put("Pound per square inch", "psi(lbf/in²)");
        unit.put("Poundal per square foot", "pdl/ft²");
        unit.put("Short ton per square foot", "tn/ft²");
        unit.put("Torr", "torr");

        unit.put("Hectopascal", "hPa");
        unit.put("Kilopascal", "kPa");
        unit.put("Megapascal", "MPa");
        unit.put("Newtonpersquaremillimeter", "N/mm^2");
        unit.put("Kilogrampersquaremeter", "K/m^2");


        //speed//
        unit.put("Foot per hour", "fph");
        unit.put("Foot per minute", "fpm");
        unit.put("Foot per second", "fps");
        unit.put("Furlong per fortnight", " fur/fortn");
        unit.put("Inch per hour", "iph");
        unit.put("Inch per minute", "ipm");
        unit.put("Inch per second", "ips");
        unit.put("Kilometre per hour", "km/h");
        unit.put("Knot", "kn");
        unit.put("Mach number", "M");
        unit.put("Metre per second", "m/s");
        unit.put("Mile per hour", "mph");
        unit.put("Mile per minute", "mpm");
        unit.put("Mile period second", "mps");
        unit.put("Speed of light", "c");
        unit.put("Speed of sound", "s");

        factor.put("Foot per hour", 8.46 * Math.pow(10, -5));
        factor.put("Foot per minute", 5.08 * Math.pow(10, -3));
        factor.put("foot per second", 3.048 * Math.pow(10, -1));
        factor.put("Furlong per fortnight", 1.663095 * Math.pow(10, -4));
        factor.put("Inch per hour", 7.05 * Math.pow(10, -6));
        factor.put("Inch per minute", 4.23 * Math.pow(10, -4));
        factor.put("Inch per second", 2.54 * Math.pow(10, -2));
        factor.put("Kilometre per hour", 2.7 * Math.pow(10, -1));
        factor.put("Knot", 0.514);
        factor.put("Mach number", 340.0);
        factor.put("Metre per second", 1.0);
        factor.put("Mile per hour", 0.44704);
        factor.put("Mile per minute", 26.8224);
        factor.put("Mile per second", 1609.344);
        factor.put("Speed of light", 299792458.0);
        factor.put("Speed of sound", 340.0);


        //Temperature
        unit.put("Celsius", "°C");
        unit.put("Delisle", "°De");
        unit.put("Fahrenheit", "°F");
        unit.put("Kelvin", "K");
        unit.put("Newton", "°N");
        unit.put("Rankine", "°R");
        unit.put("Réaumur", "°Ré");
        unit.put("Regulo Gas Mark", "GM");
        unit.put("Rømer", "°Rø");


        //Time
        unit.put("Nanosecond", "ns");
        unit.put("Microsecond", "us");
        unit.put("Millisecond", "ms");
        unit.put("Quadrans", "q");


        unit.put("Atomic unit of time", "au");
        unit.put("Callippic cycle", "callippic cycle");
        unit.put("Century", "c");
        unit.put("Day", "d");
        unit.put("Decade", "dec");
        unit.put("Fortnight", "fn");
        unit.put("Helek", "helek");
        unit.put("Hipparchic cycle", "hipparchic cycle");
        unit.put("Hour", "h");
        unit.put("Jiffy", "j");
        unit.put("Ke", "Ke");
        unit.put("Lustre", "lustre");
        unit.put("Lustrum", "lustrum");
        unit.put("Metonic cycle", "metonic cycle");
        unit.put("Millennium", "millennium");
        unit.put("Milliday", "md");
        unit.put("Minute", "min");
        unit.put("Moment", "moment");
        unit.put("Month", "mo");
        unit.put("Octaeteris", "octaaeteris");
        unit.put("Planck time", "Planck time");
        unit.put("Second", "s");
        unit.put("Shake", "shake");
        unit.put("Sigma", "sigma");
        unit.put("Sothic cycle", "Sothic cycle");
        unit.put("Svedberg", "S");
        unit.put("Week", "wk");
        unit.put("Year", "yr");
        unit.put("Leap Year", " yr");

        factor.put("Atomic unit of time", 2.418884254 * Math.pow(10, -17));
        factor.put("Callippic cycle", 2398377600.0);
        factor.put("Century", 3155695200.0);
        factor.put("Day", 86400.0);
        factor.put("Decade", 315569520.0);
        factor.put("Fortnight", 1209600.0);
        factor.put("Helek", 3.3);
        factor.put("Hipparchic cycle", 9593424000.0);
        factor.put("Hour", 3600.0);
        factor.put("Jiffy", 1.0 / 60);
        factor.put("Ke", 900.0);
        factor.put("Lustre", 157680000.0);
        factor.put("Lustrum", 157680000.0);
        factor.put("Metonic cycle", 599616000.0);
        factor.put("Millennium", 31.556952000);
        factor.put("Milliday", 86.4);
        factor.put("Minute", 60.0);
        factor.put("Moment", 99.0);
        factor.put("Month", 2.592 * Math.pow(10, 6));
        factor.put("Octaeteris", 252460800.0);
        factor.put("Planck time	", 5.39116 * Math.pow(10, -44));
        factor.put("Second", 1.0);
        factor.put("Shake", Math.pow(10, -8));
        factor.put("Sigma", Math.pow(10, -6));
        factor.put("Sothic cycle", 46074096000.0);
        factor.put("Svedberg", Math.pow(10, 13));
        factor.put("Week", 604800.0);
        factor.put("Year", 31536000.0);
        factor.put("Leap Year", 31622400.0);


        //VISCOSITY//
        // DYNAMIC
        unit.put("Pascal-second", "Pa.s");
        unit.put("Poise", "P");
        unit.put("Pound per foot hour", "lb/(ft·h)	");
        unit.put("Pound per foot second", "lb/(ft·s)");
        unit.put("Pound-force second per square foot", "lbf·s/ft2");
        unit.put("Pound-force second per square inch", "lbf·s/in2");

        //KINEMATIC
        unit.put("Square foot per second", "ft2/s");
        unit.put("Square metre per second", "m2/s");
        unit.put("Stokes", "St");

        //DYNAMIC
        factor.put("Pascal-second", 1.0);
        factor.put("Poise", 0.1);
        factor.put("Pound per foot hour", 4.133789 * Math.pow(10, -4));
        factor.put("Pound per foot second", 1.488164);
        factor.put("Pound-force second per square foot", 47.88026);
        factor.put("Pound-force second per square inch", 6894.757);

        //KINEMATIC
        factor.put("Square foot per second", 0.09290304);
        factor.put("Square metre per second", 1.0);
        factor.put("Stokes", Math.pow(10, -4));


        //VOLUME//
        unit.put("Acre-foot", "ac ft");
        unit.put("Acre-inch", "ac in");
        unit.put("Barrel", "barrel");
        unit.put("Board-foot", "fbm");
        unit.put("Bucket", "bkt");
        unit.put("Bushel", "bu");
        unit.put("Butt", "butt");
        unit.put("Coomb", "coomb");
        unit.put("Cord", "cord");
        unit.put("Cord-foot", "cord-foot");
        unit.put("Cubic fathom", "cu fm");
        unit.put("Cubic foot", "ft³");
        unit.put("Cubic inch", "in³");
        unit.put("Cubic metre", "m³");
        unit.put("Cubic mile", "cu mi");
        unit.put("Cubic yard", "yd³");
        unit.put("Cup", "c");
        unit.put("Dash", " dash");
        unit.put("Drop", "gtt");
        unit.put("Fifth", " fifth");
        unit.put("Firkin	", " firkin");
        unit.put("Fluid drachm", "fl dr");
        unit.put("Fluid scruple", "fl s");
        unit.put("Gallon", "gal");
        unit.put("Gill", "gi");
        unit.put("Hogshead", "hhd");
        unit.put("Lambda", "λ");
        unit.put("Last	", "last");
        unit.put("Litre", "L");
        unit.put("Load", "load");
        unit.put("Minim", "min");
        unit.put("Ounce", "fl oz");
        unit.put("Pail", "pail");
        unit.put("Peck", "pk	");
        unit.put("Perch", "per	");
        unit.put("Pint", "pt");
        unit.put("Pipe", "pipe");
        unit.put("Pony", "pony");
        unit.put("Quart", "qt");
        unit.put("Quarter", "quarter");
        unit.put("Sack", "sack");
        unit.put("Seam", "seam");
        unit.put("Strike", "strike");
        unit.put("Tablespoon", "tbsp");
        unit.put("Teaspoon", "tsp");
        unit.put("Timber Foot", "timber ft");
        unit.put("Ton", "ton");
        unit.put("Tun", "tun");
        unit.put("Wey", "wey");

        factor.put("Acre-foot", 1233.48183754752);
        factor.put("Acre-inch", 102.79015312896);
        factor.put("Barrel", 0.158987294928);
        factor.put("Board-foot", 2.359737216 * Math.pow(10, -3));
        factor.put("Bucket", 0.01818436);
        factor.put("Bushel", 0.03636872);
        factor.put("Butt", 0.476961884784);
        factor.put("Coomb", 0.14547488);
        factor.put("Cord", 3.624556363776);
        factor.put("Cord-foot", 0.453069545472);
        factor.put("Cubic fathom", 6.116438863872);
        factor.put("Cubic foot", 0.028316846592);
        factor.put("Cubic inch", 16.387064 * Math.pow(10, -6));
        factor.put("Cubic metre", 1.0);
        factor.put("Cubic mile", 4168181825.440579584);
        factor.put("Cubic yard", 0.764554857984);
        factor.put("Cup", 250.0 * Math.pow(10, -6));
        factor.put("Dash", 369.961751302083 * Math.pow(10, -9));
        factor.put("Drop", 98.6564670138 * Math.pow(10, -9));
        factor.put("Fifth", 757.0823568 * Math.pow(10, -6));
        factor.put("Firkin", 0.04091481);
        factor.put("Fluid drachm", 3.5516328125 * Math.pow(10, -6));
        factor.put("Fluid scruple", 1.18387760416 * Math.pow(10, -6));
        factor.put("Gallon", 4.54609 * Math.pow(10, -3));
        factor.put("Gill", 142.0653125 * Math.pow(10, -6));
        factor.put("Hogshead", 0.32731848);
        factor.put("Lambda", Math.pow(10, -9));
        factor.put("Last", 2.9094976);
        factor.put("Litre", 0.001);
        factor.put("Load", 1.4158423296);
        factor.put("Minim", 59.1938802083 * Math.pow(10, -9));
        factor.put("Ounce", 28.4130625 * Math.pow(10, -6));
        factor.put("Pail", 0.29094976);
        factor.put("Peck", 9.09218 * Math.pow(10, -3));
        factor.put("Perch", 0.700841953152);
        factor.put("Pint", 568.26125 * Math.pow(10, -6));
        factor.put("Pipe", 0.476961884784);
        factor.put("Pony", 22.180147171875 * Math.pow(10, -6));
        factor.put("Quart", 1.1365225 * Math.pow(10, -3));
        factor.put("Quarter", 0.29094976);
        factor.put("Sack", 0.10571721050064);
        factor.put("Seam", 0.29095);
        factor.put("Strike", 0.07273744);
        factor.put("Tablespoon", 17.7581640625 * Math.pow(10, -6));
        factor.put("Teaspoon", 5.91938802083 * Math.pow(10, -6));
        factor.put("Timber foot", 0.028316846592);
        factor.put("Ton", 1.01832416);
        factor.put("Tun", 0.953923769568);
        factor.put("Wey", 1.4095628066752);


        //POWER//
        unit.put("Acre-foot", "ac ft");
        unit.put("Acre-inch", "ac in");
        unit.put("Barrel", "barrel");
        unit.put("Board-foot", "fbm");
        unit.put("Bucket", "bkt");
        unit.put("Bushel", "bu");
        unit.put("Butt", "butt");
        unit.put("Coomb", "coomb");
        unit.put("Cord", "cord");
        unit.put("Cord-foot", "cord-foot");
        unit.put("Cubic fathom", "cu fm");
        unit.put("Cubic foot", "ft³");
        unit.put("Cubic inch", "in³");
        unit.put("Cubic metre", "m³");
        unit.put("Cubic mile", "cu mi");
        unit.put("Cubic yard", "yd³");
        unit.put("Cup", "c");
        unit.put("Dash", " dash");
        unit.put("Drop", "gtt");
        unit.put("Fifth", " fifth");
        unit.put("Firkin	", " firkin");
        unit.put("Fluid drachm", "fl dr");
        unit.put("Fluid scruple", "fl s");
        unit.put("Gallon", "gal");
        unit.put("Gill", "gi");
        unit.put("Hogshead", "hhd");
        unit.put("Lambda", "λ");
        unit.put("Last	", "last");
        unit.put("Litre", "L");
        unit.put("Load", "load");
        unit.put("Minim", "min");
        unit.put("Ounce", "fl oz");
        unit.put("Pail", "pail");
        unit.put("Peck", "pk	");
        unit.put("Perch", "per	");
        unit.put("Pint", "pt");
        unit.put("Pipe", "pipe");
        unit.put("Pony", "pony");
        unit.put("Quart", "qt");
        unit.put("Quarter", "quarter");
        unit.put("Sack", "sack");
        unit.put("Seam", "seam");
        unit.put("Strike", "strike");
        unit.put("Tablespoon", "tbsp");
        unit.put("Teaspoon", "tsp");
        unit.put("Timber Foot", "timber ft");
        unit.put("Ton", "ton");
        unit.put("Tun", "tun");
        unit.put("Wey", "wey");


        //power
        unit.put("Attowatt", "aW");
        unit.put("CalorieHour", "cal/h");
        unit.put("Centiwatt", "cW");
        unit.put("ErgHour", "erg/h");
        unit.put("Gigawatt", "GW");
        unit.put("Hectowatt", "hW");
        unit.put("HorsepowerMetric", "hp");
        unit.put("Kilowatt", "kW");
        unit.put("Megawatt", "MW");
        unit.put("Watt", "W");


    }

    public HashMap<String, String> getUnit() {
        return unit;
    }

    public HashMap<String, Integer> getFac() {
        return fac;
    }

    public HashMap<String, Double> getFactor() {
        return factor;
    }

    public HashMap<String, Double> getFact() {
        return fact;
    }

}
