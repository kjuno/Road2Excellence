import java.util.Scanner;

public class Ratespiel {
	
	// Über die Klasse Ratespiel werden automatisch 3 Spieler erzeugt.
	// Der gesamte Spielablauf wird über die Objektmethode starteSpiel abgewickelt.
	
	//Instanzvariablen für die 3 Spieler.
	Spieler s1;
	Spieler s2;
	Spieler s3;
	
	public void starteSpiel() {
		s1 = new Spieler(1);
		s2 = new Spieler(2);
		s3 = new Spieler(3);
		char weiterspielen;
		// Ein Array für die Spieler dient einem übersichtlicheren Code. Anstelle von 3 if-Abfragen für jede erratene Zahl haben wir eine
		// for-Schleife, die das übernimmt mitsamt diverser Syso-Ausgaben.
		Spieler[] spieler = {s1, s2, s3};
		int tipp1 = 0;
		int tipp2 = 0;
		int tipp3 = 0;
		
		boolean hatGewinner = false;
		
		 while (true) {
			int zielZahl = (int) (Math.random() *10);
			System.out.println("Errate die Zahl zwischen 0 und 9");
			
			//Damit das Programm die Verbindung zu den eingegebenen Zahlen erstellt, setzen wir unsere tippX Variablen mittels Punktoperator '.'
			// mit der zahl-Variable gleich, die jeweils in jeder Spielerinstanz über die raten-Methode aufgerufen und verwendet wird.
			tipp1 = s1.zahl;
			tipp2 = s2.zahl;
			tipp3 = s3.zahl;
				
			// Für jeden Spieler wird die Ratemethode mit ihren eigenen Bedingungen jeweils aufgerufen.
			for (int i = 0; i < spieler.length; i++) {
				System.out.println("Spieler " + spieler[i].nummer + "");
				spieler[i].raten();		
			}
	
			//
			for (int i = 0; i < spieler.length; i++) {
				if (spieler[i].zahl == zielZahl) {
					spieler[i].hatRecht = true;
					hatGewinner = true;
				}
				System.out.println("Spieler " + spieler[i].nummer + " lag richtig: " + spieler[i].hatRecht);
			}
			
			System.out.println("\n" + "DIE ZIELZAHL LAUTETE : " + zielZahl + "\n");
			
			
			if (!hatGewinner) {
				System.out.println("\n" + "Ratet erneut, oh Spieler!" + "\n"); 
			}
			else {
				System.out.println("\n" + "Das Spiel ist vorbei!");
				System.out.println("Möchtest du erneut spielen: y | n ?");
				Scanner sc = new Scanner(System.in);
				while (true) {
					weiterspielen = sc.next().charAt(0);
					if (weiterspielen != 'y' && weiterspielen != 'n') {
						System.out.println("Bitte folgen Sie den Anweisungen auf dem Bildschirm.");
					}
					else {
						break;
					}
				}
				
				if (weiterspielen == 'y') {
					continue;
				}
				else {
					break;
				}
				
			}
		
				
			
			
		}
	}
}
