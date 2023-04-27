import java.util.Scanner;

public class Spieler {
	
	// Instanzvariablen: 
	int zahl = 0; 		// Die Zahl, die dieser Spieler getippt hat
	int nummer = 0;
	boolean hatRecht = false;
	
	//Konstruktor
	
	public Spieler(int nummer) {
		this.zahl = zahl;
		this.nummer = nummer;
	}
	
	public void raten() {		
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			if (sc.hasNextInt()) {				// sc.hasNextInt überprüft, ob der eingegebene Wert auch wirklich dem gewollten Typ (int) entspricht. Auf die Weise
												// vermeiden wir diverse Programmabstürze und Exceptions.
				zahl = sc.nextInt();
			}
			else {
				System.out.println("Bitte geben sie eine ganze Zahl zwischen 0 und 9 ein.");
				continue;
			}
			if (zahl > 9 || zahl < 0) {
				System.out.println("Ungültige Zahl! versuche es erneut.");
			}
			else {
				break;
			}
		}
	
	
	}
}
