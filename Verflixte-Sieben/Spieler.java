/**
 * Beschreiben Sie hier die Klasse Spieler.
 * 
 * @author (Christian Rößler) 
 * @version (0.4)
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
    private int punkteStand;
    private int einsatz;
    private int x; //Hilfe für Vermoegen am Start
    /**
     * Konstruktor für Objekte der Klasse Spieler
     */
    public Spieler()
    {
        wuerfel1 = new Wuerfel();
        wuerfel2 = new Wuerfel();
        topf = new Topf();
        vermoegen = 100;
    }
    
    public void einsatzSetzen(int pEinsatz)
    {
        //Einsatz wird richtig in der Konsole nach Ausführen ausgegeben, aber die Methoden beim Topf geben danach alle 0 aus.
        einsatz = pEinsatz;
        
        if(einsatz > vermoegen)
        {
            System.out.println("Der Einsatz übertrifft dein Vermoegen!");
        }else if(einsatz < vermoegen/** || einsatz = vermoegen**/)
        {
            vermoegen = vermoegen - einsatz;
            topf.einsatzAufnehmen(einsatz);
            System.out.println("Du hast " + einsatz + " Münze(n) gesetzt. Dein neues Vermögen beträgt " + vermoegen + " Münze(n).");
        }
    }
    
    public void topfLeeren()
    {
        //Funktioniert dem entsprechend auch nicht;
        int tempEinsatz = topf.einsatzAbgeben();
        vermoegen += tempEinsatz;
        tempEinsatz = 0;
        System.out.println("Sie haben jetzt " + vermoegen + " Credits!");
    }
    
    public void wuerfeln()
    {
        wuerfel1.rollen();
        wuerfel2.rollen();
        punkte = wuerfel1.punkteAngeben() + wuerfel2.punkteAngeben();
        System.out.println("Du hast eine " + punkte + " gewürfelt");
        wurfAnzahl += 1;
    }
    
    public int getWurfAnzahl()
    {
        return wurfAnzahl;
    }
    
    public void setStartGeld(int pEinsatz2)
    {
        vermoegen = pEinsatz2;
    }
    
    public int getVermoegen()
    {
        return vermoegen;
    }
    
    public int getPunkte()
    {
        return punkte;
    }
    
    public int getPunkteStand()
    {
        return punkteStand;
    }
    
    public void setName(String pName)
    {
        name = pName;
    }
}