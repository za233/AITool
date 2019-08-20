package com.zeus.pathfinder;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.Map;

public class JumpCalc
{
	public static final Map<String,Double> JUMP_MAP;
    public static final DecimalFormat JUMP_FORMAT;
    public JumpCalc() 
    {
        super();
    }
    public static void calcJumpMap() 
    {
        final DecimalFormat df=new DecimalFormat("#.###");
        df.setRoundingMode(RoundingMode.FLOOR);
        int blocks=0;
        double x=0.0;
        while(blocks<=100) 
        {
            final double y=calcJumpHeight(x);
            final String format=df.format(y-blocks*0.1);
            if (format.equals("0")) 
            {
                JumpCalc.JUMP_MAP.put(""+(double)blocks*0.1,Double.valueOf(x));
                ++blocks;
            }
            x+=1.0E-6;
        }
    }
    
    public static double calcJumpHeight(final double x) 
    {
        return -0.1817584952*(x*x*x)+3.689713992*(x*x)+2.128599134*x-0.343930367;
    }
    static 
    {
        JUMP_MAP=new HashMap<String, Double>();
        JUMP_FORMAT=new DecimalFormat("#.#");
        final DecimalFormatSymbols symbols=new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        JumpCalc.JUMP_FORMAT.setRoundingMode(RoundingMode.FLOOR);
        JumpCalc.JUMP_FORMAT.setGroupingUsed(false);
        JumpCalc.JUMP_FORMAT.setDecimalFormatSymbols(symbols);
        JumpCalc.JUMP_MAP.put("0.0", Double.valueOf(0.13170400000011104));
        JumpCalc.JUMP_MAP.put("0.1", Double.valueOf(0.16291700000014225));
        JumpCalc.JUMP_MAP.put("0.2", Double.valueOf(0.19214500000017148));
        JumpCalc.JUMP_MAP.put("0.3", Double.valueOf(0.21973000000019907));
        JumpCalc.JUMP_MAP.put("0.4", Double.valueOf(0.24592700000022527));
        JumpCalc.JUMP_MAP.put("0.5", Double.valueOf(0.27093199999966927));
        JumpCalc.JUMP_MAP.put("0.6", Double.valueOf(0.29489799999902805));
        JumpCalc.JUMP_MAP.put("0.7", Double.valueOf(0.31794699999841136));
        JumpCalc.JUMP_MAP.put("0.8", Double.valueOf(0.3401799999978165));
        JumpCalc.JUMP_MAP.put("0.9", Double.valueOf(0.36167999999724126));
        JumpCalc.JUMP_MAP.put("1.0", Double.valueOf(0.38251799999668373));
        JumpCalc.JUMP_MAP.put("1.1", Double.valueOf(0.40275299999614234));
        JumpCalc.JUMP_MAP.put("1.2", Double.valueOf(0.4224359999956157));
        JumpCalc.JUMP_MAP.put("1.3", Double.valueOf(0.44161199999510264));
        JumpCalc.JUMP_MAP.put("1.4", Double.valueOf(0.46031899999460213));
        JumpCalc.JUMP_MAP.put("1.5", Double.valueOf(0.47859099999411325));
        JumpCalc.JUMP_MAP.put("1.6", Double.valueOf(0.4964589999936352));
        JumpCalc.JUMP_MAP.put("1.7", Double.valueOf(0.5139489999939415));
        JumpCalc.JUMP_MAP.put("1.8", Double.valueOf(0.5310859999944343));
        JumpCalc.JUMP_MAP.put("1.9", Double.valueOf(0.5478899999949175));
        JumpCalc.JUMP_MAP.put("2.0", Double.valueOf(0.5643809999953917));
        JumpCalc.JUMP_MAP.put("2.1", Double.valueOf(0.5805759999958574));
        JumpCalc.JUMP_MAP.put("2.2", Double.valueOf(0.5964929999963151));
        JumpCalc.JUMP_MAP.put("2.3", Double.valueOf(0.6121449999967652));
        JumpCalc.JUMP_MAP.put("2.4", Double.valueOf(0.6275459999972081));
        JumpCalc.JUMP_MAP.put("2.5", Double.valueOf(0.642707999997644));
        JumpCalc.JUMP_MAP.put("2.6", Double.valueOf(0.6576419999980735));
        JumpCalc.JUMP_MAP.put("2.7", Double.valueOf(0.6723589999984967));
        JumpCalc.JUMP_MAP.put("2.8", Double.valueOf(0.6868689999989139));
        JumpCalc.JUMP_MAP.put("2.9", Double.valueOf(0.7011799999993255));
        JumpCalc.JUMP_MAP.put("3.0", Double.valueOf(0.7153019999997315));
        JumpCalc.JUMP_MAP.put("3.1", Double.valueOf(0.7292410000001324));
        JumpCalc.JUMP_MAP.put("3.2", Double.valueOf(0.7430050000005282));
        JumpCalc.JUMP_MAP.put("3.3", Double.valueOf(0.7566010000009191));
        JumpCalc.JUMP_MAP.put("3.4", Double.valueOf(0.7700350000013054));
        JumpCalc.JUMP_MAP.put("3.5", Double.valueOf(0.7833130000016872));
        JumpCalc.JUMP_MAP.put("3.6", Double.valueOf(0.7964410000020647));
        JumpCalc.JUMP_MAP.put("3.7", Double.valueOf(0.8094240000024381));
        JumpCalc.JUMP_MAP.put("3.8", Double.valueOf(0.8222680000028074));
        JumpCalc.JUMP_MAP.put("3.9", Double.valueOf(0.8349760000031728));
        JumpCalc.JUMP_MAP.put("4.0", Double.valueOf(0.8475530000035345));
        JumpCalc.JUMP_MAP.put("4.1", Double.valueOf(0.8600040000038925));
        JumpCalc.JUMP_MAP.put("4.2", Double.valueOf(0.8723330000042471));
        JumpCalc.JUMP_MAP.put("4.3", Double.valueOf(0.8845430000045982));
        JumpCalc.JUMP_MAP.put("4.4", Double.valueOf(0.896637000004946));
        JumpCalc.JUMP_MAP.put("4.5", Double.valueOf(0.9086200000052905));
        JumpCalc.JUMP_MAP.put("4.6", Double.valueOf(0.920495000005632));
        JumpCalc.JUMP_MAP.put("4.7", Double.valueOf(0.9322640000059704));
        JumpCalc.JUMP_MAP.put("4.8", Double.valueOf(0.9439300000063059));
        JumpCalc.JUMP_MAP.put("4.9", Double.valueOf(0.9554980000066385));
        JumpCalc.JUMP_MAP.put("5.0", Double.valueOf(0.9669680000069684));
        JumpCalc.JUMP_MAP.put("5.1", Double.valueOf(0.9783440000072955));
        JumpCalc.JUMP_MAP.put("5.2", Double.valueOf(0.98962800000762));
        JumpCalc.JUMP_MAP.put("5.3", Double.valueOf(1.0008230000078504));
        JumpCalc.JUMP_MAP.put("5.4", Double.valueOf(1.0119310000069366));
        JumpCalc.JUMP_MAP.put("5.5", Double.valueOf(1.0229530000060298));
        JumpCalc.JUMP_MAP.put("5.6", Double.valueOf(1.0338930000051298));
        JumpCalc.JUMP_MAP.put("5.7", Double.valueOf(1.0447520000042365));
        JumpCalc.JUMP_MAP.put("5.8", Double.valueOf(1.0555310000033498));
        JumpCalc.JUMP_MAP.put("5.9", Double.valueOf(1.0662340000024693));
        JumpCalc.JUMP_MAP.put("6.0", Double.valueOf(1.076861000001595));
        JumpCalc.JUMP_MAP.put("6.1", Double.valueOf(1.0874140000007269));
        JumpCalc.JUMP_MAP.put("6.2", Double.valueOf(1.0978959999998645));
        JumpCalc.JUMP_MAP.put("6.3", Double.valueOf(1.108306999999008));
        JumpCalc.JUMP_MAP.put("6.4", Double.valueOf(1.1186489999981573));
        JumpCalc.JUMP_MAP.put("6.5", Double.valueOf(1.128922999997312));
        JumpCalc.JUMP_MAP.put("6.6", Double.valueOf(1.1391319999964722));
        JumpCalc.JUMP_MAP.put("6.7", Double.valueOf(1.1492749999956378));
        JumpCalc.JUMP_MAP.put("6.8", Double.valueOf(1.1593559999948084));
        JumpCalc.JUMP_MAP.put("6.9", Double.valueOf(1.1693739999939843));
        JumpCalc.JUMP_MAP.put("7.0", Double.valueOf(1.179331999993165));
        JumpCalc.JUMP_MAP.put("7.1", Double.valueOf(1.1892289999923509));
        JumpCalc.JUMP_MAP.put("7.2", Double.valueOf(1.1990689999915414));
        JumpCalc.JUMP_MAP.put("7.3", Double.valueOf(1.2088509999907366));
        JumpCalc.JUMP_MAP.put("7.4", Double.valueOf(1.2185769999899365));
        JumpCalc.JUMP_MAP.put("7.5", Double.valueOf(1.228247999989141));
        JumpCalc.JUMP_MAP.put("7.6", Double.valueOf(1.2378639999883498));
        JumpCalc.JUMP_MAP.put("7.7", Double.valueOf(1.2474269999875631));
        JumpCalc.JUMP_MAP.put("7.8", Double.valueOf(1.2569389999867806));
        JumpCalc.JUMP_MAP.put("7.9", Double.valueOf(1.2663979999860024));
        JumpCalc.JUMP_MAP.put("8.0", Double.valueOf(1.2758079999852283));
        JumpCalc.JUMP_MAP.put("8.1", Double.valueOf(1.2851679999844583));
        JumpCalc.JUMP_MAP.put("8.2", Double.valueOf(1.2944789999836923));
        JumpCalc.JUMP_MAP.put("8.3", Double.valueOf(1.3037429999829302));
        JumpCalc.JUMP_MAP.put("8.4", Double.valueOf(1.312958999982172));
        JumpCalc.JUMP_MAP.put("8.5", Double.valueOf(1.3221289999814176));
        JumpCalc.JUMP_MAP.put("8.6", Double.valueOf(1.331253999980667));
        JumpCalc.JUMP_MAP.put("8.7", Double.valueOf(1.34033399997992));
        JumpCalc.JUMP_MAP.put("8.8", Double.valueOf(1.3493709999791765));
        JumpCalc.JUMP_MAP.put("8.9", Double.valueOf(1.3583639999784367));
        JumpCalc.JUMP_MAP.put("9.0", Double.valueOf(1.3673139999777004));
        JumpCalc.JUMP_MAP.put("9.1", Double.valueOf(1.3762219999769676));
        JumpCalc.JUMP_MAP.put("9.2", Double.valueOf(1.3850889999762381));
        JumpCalc.JUMP_MAP.put("9.3", Double.valueOf(1.393915999975512));
        JumpCalc.JUMP_MAP.put("9.4", Double.valueOf(1.4027019999747892));
        JumpCalc.JUMP_MAP.put("9.5", Double.valueOf(1.4114489999740696));
        JumpCalc.JUMP_MAP.put("9.6", Double.valueOf(1.4201579999733531));
        JumpCalc.JUMP_MAP.put("9.7", Double.valueOf(1.4288279999726399));
        JumpCalc.JUMP_MAP.put("9.8", Double.valueOf(1.4374599999719297));
        JumpCalc.JUMP_MAP.put("9.9", Double.valueOf(1.4460549999712227));
        JumpCalc.JUMP_MAP.put("10.0", Double.valueOf(1.4546129999705186));
    }
}
