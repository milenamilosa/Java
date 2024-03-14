public class Main {
    public static void main(String[] args) {
        double[] atzimesParProgrammam = {1,1,1,1,1, 1,1,1,1,1, 1,1,1,1,0};
        double[] atzimesParKontroldarbiem = {10,4.4,7.5,10,4.5, 10,10,10,9.5,10, 10,7,9.2,8,8.5};
        double bonussPunktiParMenti = 1;
        double bonussPunktiParPapilduzdevumiem = 2;
        double bonussPunktiParAlgPraksi = 0;
        double atzimeParEksamenu = 4;
        atzimeParEksamenu = atzimeParEksamenu >= 4 ? atzimeParEksamenu : 0;
        double videjaAtzimeParLD = 0;
        for (int i=0; i<15; i++) {
            videjaAtzimeParLD = videjaAtzimeParLD +
                    atzimesParProgrammam[i] *
                            atzimesParKontroldarbiem[i];
        }
        videjaAtzimeParLD = videjaAtzimeParLD / 15;
        double bonussPunkti =
                (bonussPunktiParMenti + bonussPunktiParAlgPraksi +
                        bonussPunktiParPapilduzdevumiem)* 0.1;
        long atzimeParKursu = Math.round(
                videjaAtzimeParLD * 0.6 + atzimeParEksamenu * 0.4
                        + bonussPunkti);
        atzimeParKursu = atzimeParKursu > 10 ? 10 : atzimeParKursu;
        System.out.println(atzimeParKursu);
    }
}