import java.util.Random;
/**
 * Beschreiben Sie hier die Klasse Wuerfel.
 * 
 * @author Iliya 
 * @version 1.0
 */
public class Wuerfel
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private int punkte;
    private int randomZahl;
    /**
     * Konstruktor für Objekte der Klasse Wuerfel
     */
    public Wuerfel()
    {
        
    }

    public int punkteAngeben()
    {
        return punkte;
    }
    private int zufallsZahlAusgeben(){
         
      
       Random wuerfel = new Random();
  
       
       randomZahl = 1 + wuerfel.nextInt(6);
       
      
       return randomZahl;
    }
    public void rollen()
    {
        punkte = zufallsZahlAusgeben();
        System.out.println("Sie haben " + punkte + " gewürfelt.");
    }
}