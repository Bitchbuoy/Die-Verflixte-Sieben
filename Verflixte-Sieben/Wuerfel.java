import java.util.Random;
/**
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

    /**
     * Die punkte werden ausgegeben.
     */
    public int punkteAngeben()
    {
        return punkte;
    }
    
    /**
     * Es wird eine Zahl zwischen 1 bis 6 generiert.
     */
    private int zufallsZahlAusgeben(){
         
      
       Random wuerfel = new Random();
  
       
       randomZahl = 1 + wuerfel.nextInt(6);
       
      
       return randomZahl;
    }
    
    /**
     * Es wird eine Zahl zwischen 1 bis 6 ausgerollt.
     */
    public void rollen()
    {
        punkte = zufallsZahlAusgeben();
    }
}
