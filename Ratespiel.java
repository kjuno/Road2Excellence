import java.util.Scanner;

public class Ratespiel {

    // Über die Klasse Ratespiel werden automatisch 3 Spieler erzeugt.
    // Der gesamte Spielablauf wird über die Objektmethode starteSpiel abgewickelt.

    Spieler[] spieler;
    Scanner sc = new Scanner(System.in);

    public void starteSpiel() {
        int anzahlSpieler = 3;

        // Ein Array für die Spieler dient einem übersichtlicheren Code. Anstelle von 3 if-Abfragen für jede erratene Zahl haben wir eine
        // for-Schleife, die das übernimmt mitsamt diverser Syso-Ausgaben.
        spieler = new Spieler[anzahlSpieler];

        for (int i = 0; i < anzahlSpieler; i++)
            spieler[i] = new Spieler();

        boolean beendet;

        do {
            beendet = loop();
        } while (!beendet);

        sc.close();
    }

    private void eingabeSpieler(){
        System.out.println("Errate die Zahl zwischen 0 und 9");

        for (int i = 0; i < spieler.length; i++) {
            System.out.println("Spieler " + i + ":");
            spieler[i].raten();
        }
    }

    private boolean loop(){
        int zielZahl = (int) (Math.random() * 10);

        eingabeSpieler();

        boolean hatGewinner = false;

        for (int i = 0; i < spieler.length; i++) {
            if (spieler[i].getZahl() == zielZahl) {
                hatGewinner = true;
                System.out.println("Der Spieler " + i + " hat richtig erraten!");
            }
        }

        System.out.println("\n" + "DIE ZIELZAHL LAUTETE : " + zielZahl + "\n");


        if (!hatGewinner) {
            System.out.println("\n Ratet erneut, oh Spieler! \n");
            return false;
        }

        System.out.println("\n" + "Das Spiel ist vorbei!");
        System.out.println("Möchtest du erneut spielen: y | n ?");

        char weiterspielen;

        do{
            weiterspielen = sc.next().charAt(0);
            if (weiterspielen != 'y' && weiterspielen != 'n') {
                System.out.println("Bitte folgen Sie den Anweisungen auf dem Bildschirm.");
            }
        }
        while (weiterspielen != 'y' && weiterspielen != 'n');

        return weiterspielen == 'n';
    }
}