package com.gesua;

import java.math.BigDecimal;

public class Calculator {

    public static final BigDecimal TWO = new BigDecimal("2");
    public static final BigDecimal PI = new BigDecimal("3.14");
    public static final BigDecimal FOUR = new BigDecimal("4");
    public static final int MODE = BigDecimal.ROUND_UP;
    public static final BigDecimal THOUSAND = new BigDecimal("1000");
    public static final BigDecimal ZERO = new BigDecimal(0);//Table
    public static final BigDecimal G = new BigDecimal("0.277777778");

    public static void main(String[] args) {
        // вход
        BigDecimal n_трубок = new BigDecimal("9");
        BigDecimal t2sht = new BigDecimal("10");// Т2вх
        BigDecimal T1par = new BigDecimal("102.66");
        BigDecimal T2vuh = new BigDecimal("60");

        // Переменные
        BigDecimal Dvn = new BigDecimal("0.051");
        BigDecimal dnar = new BigDecimal("0.008");
        BigDecimal Ltrub = TWO;
        BigDecimal lyamdaStali = new BigDecimal("16.2");
        BigDecimal tolshinaStenki = new BigDecimal("0.001");
        BigDecimal teploprovodimistStali = new BigDecimal("16.2");
        BigDecimal teploprovodimostNakipi = new BigDecimal("0.22");
        BigDecimal po = new BigDecimal("977.8");//Table
        BigDecimal cp = new BigDecimal("4.178");//Table
        BigDecimal KoefRiflen = new BigDecimal("1");
        BigDecimal bNaYjim = new BigDecimal("0.0001");
        BigDecimal bZagr = new BigDecimal("0.000051");
        BigDecimal PrinimayemayaTemperaturaStenki = new BigDecimal("89.5");

        // Переменные расчетов
        BigDecimal dvn;
        BigDecimal dRaschetTeploobmenaTrubki;
        BigDecimal fvn;
        BigDecimal fnar;
        BigDecimal fnarTrubok;
        BigDecimal Fvn;
        BigDecimal fvnNtubok;
        BigDecimal Nyu;
        BigDecimal Pr = new BigDecimal("4.259798328");// Table
        BigDecimal Lyamda = new BigDecimal("0.63502003");// Table
        BigDecimal v1trubka;
        BigDecimal vNtrubok;


        // Расчеты
        dvn = dnar.subtract(tolshinaStenki.multiply(TWO)).subtract(bZagr.multiply(TWO))
                .subtract(bNaYjim.multiply(TWO));
        dRaschetTeploobmenaTrubki = (dvn.add(dnar)).divide(TWO, MODE);
        fvn = PI.multiply(dvn).multiply(dvn).divide(FOUR, MODE);
        fnar = PI.multiply(dnar).multiply(dnar).divide(FOUR, MODE);
        fnarTrubok = fnar.multiply(n_трубок);
        Fvn = PI.multiply(Dvn).multiply(Dvn).divide(FOUR, MODE);
        fvnNtubok = fvn.multiply(n_трубок);

        // Расчеты-вода
        Nyu = new BigDecimal("0.000000648");// Table
        v1trubka = G.divide(fvn, MODE).divide(po, MODE);

        vNtrubok = v1trubka.divide(n_трубок, MODE);

        BigDecimal Re = vNtrubok.multiply(dvn).divide(Nyu, MODE);

        BigDecimal ReRuflen = Re.multiply(KoefRiflen);

        BigDecimal Nu = new BigDecimal("0.021")
                .multiply(new BigDecimal(Math.pow(Re.doubleValue(), new BigDecimal("0.8").doubleValue())))
                .multiply(new BigDecimal(Math.pow(Pr.doubleValue(), new BigDecimal("0.43").doubleValue())));

        BigDecimal NuRuflen = new BigDecimal("0.021")
                .multiply(new BigDecimal(Math.pow(ReRuflen.doubleValue(), new BigDecimal("0.8").doubleValue())))
                .multiply(new BigDecimal(Math.pow(Pr.doubleValue(), new BigDecimal("0.43").doubleValue())));

        BigDecimal Alfa = Nu.multiply(Lyamda).divide(dvn, MODE);

        BigDecimal AlfaRuflen = NuRuflen.multiply(Lyamda).divide(dvn, MODE);

        BigDecimal KpoRovnoy = new BigDecimal("1")
                .divide(new BigDecimal("1").divide(Alfa.add(tolshinaStenki.divide(lyamdaStali, MODE)), MODE), MODE);

        BigDecimal Alpfha1 = (new BigDecimal("4950").add(new BigDecimal("58.5").multiply(new BigDecimal("97.66")))
                .subtract(new BigDecimal("0.18").multiply(new BigDecimal("97.66").pow(2))))
                .divide(new BigDecimal(
                                Math.pow((T1par.subtract(PrinimayemayaTemperaturaStenki)).multiply(new BigDecimal("3"))
                                        .multiply(dnar).doubleValue(), new BigDecimal("0.25").doubleValue())),
                        MODE);
        BigDecimal t2sred = (T2vuh.add(t2sht)).divide(TWO, MODE);

        BigDecimal gTb = T1par.subtract(t2sht);

        BigDecimal gTm = T1par.subtract(T2vuh);

        BigDecimal gTser = (gTb.subtract(gTm)).divide(new BigDecimal(Math.log(gTb.divide(gTm, MODE).doubleValue())), MODE);

        BigDecimal T2ser = T1par.subtract(gTser);



        // output
        System.out.println("dvn= " + dvn);
        System.out.println("dRaschetTeploobmenaTrubki= " + dRaschetTeploobmenaTrubki);
        System.out.println("fvn= " + fvn);
        System.out.println("fnar= " + fnar);
        System.out.println("fnarTrubok= " + fnarTrubok);
        System.out.println("Fvn= " + Fvn);
        System.out.println("fvnNtubok= " + fvnNtubok);
        System.out.println("v1trubka= " + v1trubka);
        System.out.println(Alpfha1);
        System.out.println(gTser);
//        System.out.println(Q);
        System.out.println(G);
    }

    public BigDecimal calculateQ(){

//        BigDecimal Q = G.multiply(cp).multiply(T2vuh.subtract(t2sht)).multiply(THOUSAND);
        return null;
    }

}
