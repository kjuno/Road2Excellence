import java.util.Scanner;

public class Spieler {

    // Instanzvariablen:
    private int zahl = 0;         // Die Zahl, die dieser Spieler getippt hat

    public void raten() {
        boolean eingegeben = false;

        do {
            Scanner sc = new Scanner(System.in);
            if(!sc.hasNextInt())
                System.out.println("Bitte geben sie eine ganze Zahl zwischen 0 und 9 ein.");

            zahl = sc.nextInt();

            if (zahl > 9 || zahl < 0)
                System.out.println("Ungültige Zahl! versuche es erneut.");

            eingegeben = true;
        } while(!eingegeben);
    }

    public int getZahl(){
        return zahl;
    }
}