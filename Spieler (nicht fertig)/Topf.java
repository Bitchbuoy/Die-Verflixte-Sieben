/**
 * Beschreiben Sie hier die Klasse Topf.
 * 
 * @author Iliya 
 * @version 1.0
 */
public class Topf
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private int einsatz;
    private int test;
    public Topf()
    {
        
    }

    public void einsatzAufnehmen(int pEinsatz)
    {
        einsatz += pEinsatz;
        System.out.println("Sie haben insgesamt " + einsatz +" Credits gesetzt.");
    }
    public int einsatzAbgeben()
    {
        int tempEinsatz;
        tempEinsatz = einsatz;
        einsatz = 0;
        return tempEinsatz;
    }
    
    public int getEinsatz()
    {
        return einsatz;
    }
}
