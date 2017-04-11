package com.gesua;


/**
 * Created by Chirp on 12.03.2017.
 */
public class CalculatorDouble {

    public static final double TWO = 2;
    public static final double PI = Math.PI;
    public static final double FOUR = 4;
    public static final double THOUSAND = 1000;
    public static final double ZERO = 0;
    public static final double G = 0.277777778;


    public static void main(String[] args) {

        double nTrubok = 9;
        double t2sht = 10;// Т2вх
        double T1par = 102.66;
        double T2vuh = 60;

        double Dvn = 0.051;
        double dnar = 0.008;
        double Ltrub = 2;
        double lyamdaStali = 16.2;
        double tolshinaStenki = 0.001;
        double teploprovodimistStali = 16.2;
        double teploprovodimostNakipi = 0.22;
        double po = 977.8;//Table
        double cp = 4.178;//Table
        double KoefRiflen = 1;
        double bNaYjim = 0.0001;
        double bZagr = 0.000051;
//        double PrinimayemayaTemperaturaStenki = 89.5;

        //        Par
        double Pnar = 0.1;
        double popar = 0.658646;
        double r = 2250.2;
        double NuPar = 0.0000187033;
        double Prpar = 1.08266;
        double lamdaKond = 0.683532;
        double poKondensata = 956.4316;
        double MuPar = 0.0001210034;
        double MuKond = 0.00276249;


        double dvn = dvn(dnar, tolshinaStenki, bZagr, bNaYjim);
        double dRaschetTeploobTrubki = dRaschetTeploobTrubki(dvn, dnar);
        double fvn = fvn(dvn);
        double fnar = fnar(dnar);
        double fnarTrubok = fnarTrubok(fnar, nTrubok);
        double Fvn = Fvn(Dvn);
        double fvnNTrubok = fvnNTrubok(fvn, nTrubok);
        double v1trubka = v1trubka(G, fvn, po);
        double vNtrubok = vNtrubok(v1trubka, nTrubok);


        double dTb = dTb(T1par, t2sht);
        double dTm = dTm(T1par, T2vuh);
        double dTser = dTser(dTb, dTm);
        double T2ser = T2ser(T1par, dTser);

        double nyuT2ser = nyuT2ser(T2ser);
        double pr = pr(T2ser);
        double lamda = lamda(T2ser);

        double Re = Re(vNtrubok, dvn, nyuT2ser);
        double reRuflen = reRuflen(Re, KoefRiflen);

        double nu = nu(Re, pr);
        double nuRuflen = nuRuflen(reRuflen, pr);
        double alpha = alpha(nu, lamda, dvn);
        double alphaRuflen = alphaRuflen(nuRuflen, lamda, dvn);

        double alphaGorizontSkorostnaya = alphaGorizontSkorostnaya(T1par, dnar);
        double kPoRovnoy = kPoRovnoy(alpha, tolshinaStenki, lyamdaStali, bZagr, alphaGorizontSkorostnaya);
        double t2sred = t2sred(T2vuh, t2sht);
        double q = q(G, cp, T2vuh, t2sht);
        double qPo45min = qPo45min(cp, T2vuh, t2sht);
        double k = k(alphaRuflen, tolshinaStenki, bZagr, alphaGorizontSkorostnaya);
        double F = F(q, dTser, k);
        double Fpo45min = fPo45min(qPo45min, dTser, k);


//        Fvodu
        double Fvodu = Fvodu(fnar,nTrubok);
        double Fvn_Fvodu  =Fvn_Fvodu(Fvn,fnar,nTrubok);
        double Dekv = Dekv(Fvn_Fvodu);
        double dekv = dekv(Fvodu);
        double fvnVodu = fvnVodu(dvn,nTrubok);
        double dekvVnTrubok = dekvVnTrubok(fvnVodu);


//        Par
        double dPar = dPar(q, r);
        double v = v(dPar,popar,Fvn_Fvodu);


        System.out.println("dvn: " + dvn);
        System.out.println("dRaschetTeploobTrubki: " + dRaschetTeploobTrubki);
        System.out.println("fvn: " + fvn);
        System.out.println("fnar: " + fnar);
        System.out.println("fnarTrubok: " + fnarTrubok);
        System.out.println("Fvn: " + Fvn);
        System.out.println("fvnNTrubok: " + fvnNTrubok);
        System.out.println("v1trubka: " + v1trubka);
        System.out.println("vNtrubok: " + vNtrubok);
        System.out.println("dTb: " + dTb);
        System.out.println("dTm: " + dTm);
        System.out.println("dTser: " + dTser);
        System.out.println("T2ser: " + T2ser);
        System.out.println("nyuT2ser: " + nyuT2ser);
        System.out.println("pr: " + pr);
        System.out.println("lamda: " + lamda);
        System.out.println("Re: " + Re);
        System.out.println("reRuflen: " + reRuflen);
        System.out.println("nu: " + nu);
        System.out.println("nuRuflen: " + nuRuflen);
        System.out.println("alpha: " + alpha);
        System.out.println("alphaRuflen: " + alphaRuflen);
        System.out.println("kPoRovnoy: " + kPoRovnoy);
        System.out.println("alphaGorizontSkorostnaya: " + alphaGorizontSkorostnaya);
        System.out.println("t2sred: " + t2sred);
        System.out.println("Q: " + q);
        System.out.println("qPo45min: " + qPo45min);
        System.out.println("K: " + k);
        System.out.println("F: " + F);
        System.out.println("Fpo45min: " + Fpo45min);

        System.out.println("***********************");
        System.out.println("Fvodu"+Fvodu);
        System.out.println("Fvn_Fvodu"+Fvn_Fvodu);
        System.out.println("Dekv"+Dekv);
        System.out.println("dekv"+dekv);
        System.out.println("fvnVodu"+fvnVodu);
        System.out.println("dekvVnTrubok"+dekvVnTrubok);

        System.out.println("***********************");
        System.out.println("dPar"+dPar);
        System.out.println("v"+v);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

    }

    //Расчеты нормализации
    //Для nTrubok
    private static double normNtrub(double F, double Ltrub, double dRaschetTeploobTrubki) {
        double normNtrub = F / PI / dRaschetTeploobTrubki / Ltrub;
        return normNtrub;
    }

    private static double ploshadEkvivalentnoyPoverhnosti(double dRaschetTeploobTrubki, double Ltrub, double nTrubok) {
        double ploshadEkvivalentnoyPoverhnosti = PI * dRaschetTeploobTrubki * Ltrub * nTrubok * 0.96;
        return ploshadEkvivalentnoyPoverhnosti;
    }

    private static double tStenki(double T1par, double q, double alphaGorizontSkorostnaya) {
        double tStenki = (T1par - 5) - q / alphaGorizontSkorostnaya;
        return tStenki;
    }

    private static double qNorm(double k, double dTser) {
        double qNorm = k * dTser;
        return qNorm;
    }

    //Общие+вода
    private static double dvn(double dnar, double tolshinaStenki, double bZagr, double bNaYjim) {
        double dvn = dnar - (tolshinaStenki * TWO) - (bZagr * TWO) - (bNaYjim * TWO);
        return dvn;
    }

    private static double dRaschetTeploobTrubki(double dvn, double dnar) {
        double dRaschetTeploobTrubki = (dvn + dnar) / 2;
        return dRaschetTeploobTrubki;
    }

    private static double fvn(double dvn) {
        double fvn = PI * dvn * dvn / FOUR;
        return fvn;
    }

    private static double fnar(double dnar) {
        double fnar = PI * dnar * dnar / FOUR;
        return fnar;
    }

    private static double fnarTrubok(double fnar, double nTrubok) {
        double fnarTrubok = fnar * nTrubok;
        return fnarTrubok;
    }

    private static double Fvn(double Dvn) {
        double Fvn = Dvn * Dvn * PI / FOUR;
        return Fvn;
    }

    private static double fvnNTrubok(double fvn, double nTrubok) {
        double fvnNTrubok = fvn * nTrubok;
        return fvnNTrubok;
    }


    private static double nyuT2ser(double T2ser) {
        double nyuT2ser = 0.000000556 + (0.000000478 - 0.000000556) / (60 - 50) * (T2ser - 50);
        return nyuT2ser;
    }

    private static double pr(double T2ser) {
        double pr = 3.54 + (2.93 - 3.54) / (60 - 50) * (T2ser - 50);
        return pr;
    }

    private static double lamda(double T2ser) {
        double lamda = Math.pow(10, -2) * (64.8 + (65.9 - 64.8) / (60 - 50) * (T2ser - 50));
        return lamda;
    }

    private static double v1trubka(double G, double fvn, double po) {
        double v1trubka = G / fvn / po;
        return v1trubka;
    }

    private static double vNtrubok(double v1trubka, double nTrubok) {
        double vNtrubok = v1trubka / nTrubok;
        return vNtrubok;
    }

    private static double Re(double vNtrubok, double dvn, double Nyu) {
        double Re = vNtrubok * dvn / Nyu;
        return Re;
    }

    private static double reRuflen(double Re, double koefRuglen) {
        double reRuflen = Re * koefRuglen;
        return reRuflen;
    }

    private static double nu(double Re, double pr) {
        double nu = 0.021 * Math.pow(Re, 0.8) * Math.pow(pr, 0.43);
        return nu;
    }

    private static double nuRuflen(double reRuflen, double pr) {
        double nuRuflen = 0.021 * Math.pow(reRuflen, 0.8) * Math.pow(pr, 0.43);
        return nuRuflen;
    }

    private static double alpha(double nu, double lamda, double dvn) {
        double alpha = nu * lamda / dvn;
        return alpha;
    }

    private static double alphaRuflen(double nuRuflen, double lamda, double dvn) {
        double alphaRuflen = nuRuflen * lamda / dvn;
        return alphaRuflen;
    }

    private static double kPoRovnoy(double alpha, double tolshinaStenki, double lyamdaStali, double bZagr, double alphaGorizontSkorostnaya) {
        double kPoRovnoy = 1 / (1 / alpha + tolshinaStenki / lyamdaStali + bZagr / 1.16 + 1 / alphaGorizontSkorostnaya);
        return kPoRovnoy;
    }

    private static double alphaGorizontSkorostnaya(double T1par, double dnar) {
        double alphaGorizontSkorostnaya = (4950 + 58.5 * 97.66 - (0.18 * Math.pow(97.66, 2))) / Math.pow(((T1par - 89.5) * 3 * dnar), 0.25);
        return alphaGorizontSkorostnaya;
    }

    private static double t2sred(double T2vuh, double t2sht) {
        double t2sred = (T2vuh + t2sht) / 2;
        return t2sred;
    }

    private static double dTb(double T1par, double t2sht) {
        double dTb = T1par - t2sht;
        return dTb;
    }

    private static double dTm(double T1par, double T2vuh) {
        double dTm = T1par - T2vuh;
        return dTm;
    }

    private static double dTser(double dTb, double dTm) {
        double dTser = (dTb - dTm) / Math.log(dTb / dTm);
        return dTser;
    }

    private static double T2ser(double T1par, double dTser) {

        double T2ser = T1par - dTser;
        return T2ser;
    }

    private static double q(double G, double cp, double T2vuh, double t2sht) {
        double q = G * cp * (T2vuh - t2sht) * THOUSAND;
        return q;
    }

    private static double qPo45min(double cp, double T2vuh, double t2sht) {
        double gPo45min = 1000 * 60 / 45 * cp * (T2vuh - t2sht) / 3600 * THOUSAND;
        return gPo45min;
    }

    private static double k(double alphaRuflen, double tolshinaStenki, double bzagr, double alphaGorizontSkorostnaya) {
        double k = 1 / (1 / alphaRuflen + tolshinaStenki / 16.2 + bzagr / 1.16 + 1 / alphaGorizontSkorostnaya);
        return k;
    }

    private static double F(double q, double dTser, double k) {
        double F = q / dTser / k;
        return F;
    }

    private static double fPo45min(double qPo45min, double dTser, double k) {
        double fPo45min = qPo45min / dTser / k;
        return fPo45min;
    }

    //need
    private static double Fvodu(double fnar, double nTrubok) {

        double Fvodu = fnar * nTrubok;
        return Fvodu;
    }

    private static double Fvn_Fvodu(double Fvn, double fnar, double nTrubok) {
        double Fvn_Fvodu = Fvn - fnar * nTrubok;
        return Fvn_Fvodu;
    }

    private static double Dekv(double Fvn_Fvodu) {
        double Dekv = Math.pow((4 * Fvn_Fvodu / PI), 0.5);
        return Dekv;
    }

    private static double dekv(double Fvodu) {
        double dekv = Math.pow((4 * Fvodu / PI), 0.5);
        return dekv;
    }

    private static double fvnVodu(double dvn, double nTrubok) {
        double fvnVodu = Math.pow(dvn, 2) * PI / 4 * nTrubok;
        return fvnVodu;
    }

    private static double dekvVnTrubok(double fvn) {
        double dekvVnTrubok = Math.pow((fvn * 4 / PI), 0.5);
        return dekvVnTrubok;
    }

//    Пар

    private static double dPar(double Q, double r) {
        double dPar = Q / r / 1000;
        return dPar;
    }

    private static double v(double Dpar, double poPar, double Fvn_Fvodu) {
        double v = Dpar / poPar / Fvn_Fvodu;
        return v;
    }

    private static double RePar(double v, double Dekv, double NuPar) {
        double RePar = v * Dekv / NuPar;
        return RePar;
    }

    private static double nuPar(double Re, double PrPar) {
        double nuPar = 0.021 * Math.pow(Re, 0.8) * Math.pow(PrPar, 0.43);
        return nuPar;
    }

    private static double AlphaPar(double nuPar, double lamdaKond, double Dekv) {
        double AlphaPar = nuPar * lamdaKond / Dekv;
        return AlphaPar;
    }

    private static double A(double lamdaKond, double r, double poKond, double poPar, double NuPar) {
        double A = Math.pow((Math.pow(lamdaKond, 3) * 9.81 * r * 1000 * (poKond - poPar) / NuPar), 0.25);
        return A;
    }

    private static double AlphaGorKondNepodPar(double A, double dnar, double T1par, double Tstenki1) {
        double AlphaGorKondNepodPar = 0.728 * A / Math.pow(dnar * (T1par - Tstenki1), 0.25);
        return AlphaGorKondNepodPar;
    }

    //    Сопротивление по воде
    private static double reEkv(double vNtrubok, double dekvVnTrubok, double nu) {
        double reEkv = vNtrubok * dekvVnTrubok / nu;
        return reEkv;
    }

    private static double soprLamda(double dEkv, double reEkv) {
        double soprLamda = 0.11 * Math.pow((1 / dEkv + 68 / reEkv), 0.25);
        return soprLamda;
    }

    private static double dPot(double soprLamda, double Ltrub, double dekvVnTrubok, double vNtrubok, double po) {
        double dPot = (soprLamda * Ltrub / dekvVnTrubok * Math.pow(vNtrubok, 2) / 2 * po) / 1000;
        return dPot;
    }

    private static double ksiSujeniya(double fvnVodu, double sorpF) {
        double ksiSujeniya = 0.5 * (1 - fvnVodu / sorpF);
        return ksiSujeniya;
    }

    private static double dpSujeniya(double ksiSujeniya, double vNtrubok, double po) {
        double dpSujeniya = (ksiSujeniya * Math.pow(vNtrubok, 2) * po / 2) / 1000;
        return dpSujeniya;
    }

    private static double dpTotal(double dPot, double dpSujeniya) {
        double dpTotal = dPot + dpSujeniya;
        return dpTotal;
    }
}