/**
 * 
 * @author Iliya 
 * @version 1.0
 */
public class Topf
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private int einsatz;
    
    /**
    * Der Topf wird erstellt und der Einsatz wird auf 0 gesetzt.
    * 
    */
    public Topf()  
    {
        einsatz = 0;
    }

    /**Der angegebene Einsatz wird aufgenommen
       */
    public void einsatzAufnehmen(int pEinsatz) 
    {
        einsatz += pEinsatz;
    }
    
    /**
     * Einsatz wird zurückgegeben und der Einsatz auf Null gesetzt.
    */
    public int einsatzAbgeben()
    
    {
        int tempEinsatz;
        tempEinsatz = einsatz;
        einsatz = 0;
        return tempEinsatz;
    }
}
