/**
 * Die Klasse Spieler ist grundsätzlich für die Interaktion mit den jeweiligen
 * Spielern zuständig. Sie stellt verschiedene Aktionen zur Verfügung 
 * greift dabei heufig auf die Klassen Topf und 
 * Würfel zurück.
 * 
 * @author (Christian Rößler) 
 * @version (0.9)
 */
public class Spieler
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private Wuerfel wuerfel1;
    private Wuerfel wuerfel2;
    private Topf topf;
    private String name;
    private int wurfAnzahl;
    private int vermoegen;
    private int punkte;
    /**
     * Im der Konstruktor werden Objekte der Klasse Spieler erstellt.
     */
    public Spieler(Wuerfel pWuerfel1, Wuerfel pWuerfel2, Topf pTopf)
    {
        wuerfel1 = pWuerfel1;
        wuerfel2 = pWuerfel2;
        topf = pTopf;
        vermoegen = 100;
    }
    /**
     * Spieler kann einen beliebig hohen Einsatz (solange im Buget) mit dieser 
     * Methode setzen.
     */
    public void einsatzSetzen(int pEinsatz)
    {
        vermoegen = vermoegen - pEinsatz;
        topf.einsatzAufnehmen(pEinsatz);
        System.out.println("Du hast " + pEinsatz + " Credit(s) gesetzt. Dein neues Vermögen beträgt " + vermoegen + " Credit(s).");
    }
    /**
     * Wenn ein Spieler gewinnt nimmt er sich den Einsatz aus dem Topf.
     */
    public void topfLeeren()
    {
        int tempEinsatz = topf.einsatzAbgeben();
        vermoegen += tempEinsatz;
        System.out.println("Sie haben jetzt " + vermoegen + " Credit(s)!");
    }
    /**
     * Zwei Zahlen zwischen 1 und 6 werden addiert und ausgegeben. Dies ist 
     * dann die Augenzahl eines Spielers.
     */
    public void wuerfeln()
    {
        wuerfel1.rollen();
        wuerfel2.rollen();
        punkte = wuerfel1.punkteAngeben() + wuerfel2.punkteAngeben();
        System.out.println("Du hast eine " + punkte + " gewürfelt");
        wurfAnzahl += 1;
    }
    
    /**
     * Wurf-Anzahl eines Spielers wird zurückgegeben.
     */
    public int getWurfAnzahl()
    {
        return wurfAnzahl;
    }
    
    /**
     * Vermögen eines Spielers wird zurückgegeben.
     */
    public int getVermoegen()
    {
        return vermoegen;
    }
    
    /**
     * Augensumme der Würfel eines Spielers wird zurückgegeben.
     */
    public int getPunkte()
    {
        return punkte;
    }
    
    /**
     * Festlegung der Spielernamen.
     */
    public void setName(String pName)
    {
        name = pName;
    }
    
    /**
     * Das Spiel wird neu gestartet.
     */
    public void neuesSpiel()
    {
        vermoegen = 100;
        wurfAnzahl = 0;
    }
    /**
     * Die wurfAnzahl wird auf null gesetzt.
     */
     public void neueRunde()
    {
        wurfAnzahl = 0;
    }
}
