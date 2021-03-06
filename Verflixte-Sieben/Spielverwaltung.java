import javax.swing.JOptionPane;
/**
 * Beschreiben Sie hier die Klasse Spielverwaltung.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Spielverwaltung
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private Spieler spieler1, spieler2;
    private Topf topf;
    private Wuerfel wuerfel1, wuerfel2;
    private String name1, name2;
    private boolean zugSpieler1, startSpieler1, gesetzt;
    private int score1, score2;
    
    /**
     * Konstruktor für Objekte der Klasse Spielverwaltung
     */
    public Spielverwaltung()
    {
        // Instanzvariable initialisieren
        topf = new Topf();
        wuerfel1 = new Wuerfel();
        wuerfel2 = new Wuerfel();
        spieler1 = new Spieler(/**wuerfel1, wuerfel2, topf**/);
        spieler2 = new Spieler(/**wuerfel1, wuerfel2, topf**/);
        name1 = JOptionPane.showInputDialog("Name des ersten Spielers:");
        spieler1.setName(name1);
        name2 = JOptionPane.showInputDialog("Name des zweiten Spielers:");
        spieler2.setName(name1);
        startSpieler1 = true;
        zugSpieler1 = true;
    }
    
    public void main (String[] args){
        new Spielverwaltung();
    }

    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    public String wuerfeln()
    {
        String ausgabe = "";
        int tempPunkte;
        if (gesetzt == true){
            if (zugSpieler1 == true){
                spieler1.wuerfeln();
                tempPunkte = spieler1.getPunkteStand();
                ausgabe = name1+ " hat eine "+ tempPunkte +" gewürfelt \n";
                if (tempPunkte == 7){
                    score1 -= 7;
                    ausgabe += name1+ " hat jetzt "+ score1 +" Punkte \n \n";
                    ausgabe += tauschen();
                } else if(spieler1.getWurfAnzahl() == spieler2.getWurfAnzahl()){
                    score1 += tempPunkte;
                    ausgabe += name1+ " hat jetzt "+ score1 +" Punkte \n \n";
                    ausgabe += tauschen();
                } else{
                    score1 += tempPunkte;
                    ausgabe += name1+ " hat jetzt "+ score1 +" Punkte \n \n";
                }
            } else{
                spieler2.wuerfeln();
                tempPunkte = spieler2.getPunkteStand();
                ausgabe = name2+ " hat eine "+ tempPunkte +" gewürfelt \n";
                if (tempPunkte == 7){
                    score2 -= 7;
                    ausgabe += name2+ " hat jetzt "+ score2 +" Punkte \n \n";
                    ausgabe += tauschen();
                } else if(spieler2.getWurfAnzahl() == spieler1.getWurfAnzahl()){
                    score2 += tempPunkte;
                    ausgabe += name2+ " hat jetzt "+ score2 +" Punkte \n \n";
                    ausgabe += tauschen();
                } else{
                    score2 += tempPunkte;
                    ausgabe += name2+ " hat jetzt "+ score2 +" Punkte \n \n";
                }
            }
        } else{
            ausgabe = "Bitte erst setzen! \n \n";
        }
        return ausgabe;
    }
    
    public String tauschen()
    {
        String string = "";
        if (startSpieler1 == true){
            if (zugSpieler1 == true){
                zugSpieler1 = false;
                string = name2 + " ist jetzt dran! \n \n";
            } else{
                startSpieler1 = false;
                string = auswerten() + "\n";
            }
        } else{
            if (zugSpieler1 == false){
                zugSpieler1 = true;
                string = name1 + " ist jetzt dran! \n \n";
            } else{
                startSpieler1 = true;
                string = auswerten() + "\n";
            }
        }
        return string;
    }
    
    public String setzen(int pEinsatz)
    {
        String string = "";
        //boolean spieler.kannSetzen(pEinsatz) muss noch erstellt werden. soll nur prüfen ob der Einsatz kleiner als das vermoegen ist.
        if (pEinsatz <= spieler1.getVermoegen() && pEinsatz <= spieler2.getVermoegen()){
            spieler1.einsatzSetzen(pEinsatz);
            spieler2.einsatzSetzen(pEinsatz);
            gesetzt = true;
            string = "Der Einsatz beträgt " + pEinsatz + "\n";
            string += name1 + " hat jetzt noch " + spieler1.getVermoegen() + "\n";
            string += name2 + " hat jetzt noch " + spieler2.getVermoegen() + "\n" + "\n";
        } else{
            string = "Der Einsatz ist zu groß! \n \n";
        }
        return string;
    }
    
    public String auswerten()
    {
        String string = "";
        if (score1 > score2){
            string = name1 + " hat gewonnen!(" + score1 +"/" + score2 + ") \n";
            spieler1.topfLeeren();
        } else if(score1 == score2){
            string = "Unentschieden! \n";
        } else if(score1 < score2){
            string = name2 + " hat gewonnen!(" + score1 +"/" + score2 + ") \n";
            spieler2.topfLeeren();
        }
        string += name1+ " hat jetzt "+ spieler1.getVermoegen() + "\n";
        string += name2+ " hat jetzt "+ spieler2.getVermoegen() + "\n";
        score1 = 0;
        score2 = 0;
        gesetzt = false;
        return string;
    }
    
    public String zugAbgeben()
    {
        String string = "";
        if (zugSpieler1 == true && spieler1.getWurfAnzahl() > 0){
            string = tauschen();
        } else if(zugSpieler1 == false && spieler2.getWurfAnzahl() > 0){
            string = tauschen();
        } else{
            string = "Du musst mindestens einmal Würfeln! \n \n";
        }
        return string;
    }
    
    public String allIn()
    {
        String string = "";
        int pEinsatz;
        if (spieler1.getVermoegen() <= spieler2.getVermoegen()){
            pEinsatz = spieler1.getVermoegen();
        } else{
            pEinsatz = spieler2.getVermoegen();
        }
        spieler1.einsatzSetzen(pEinsatz);
        spieler2.einsatzSetzen(pEinsatz);
        gesetzt = true;
        if (zugSpieler1 == true){
            string = name1 + " geht All In! Der Einsatz beträgt " + pEinsatz + "\n";
        } else{
            string = name2 + " geht All In! Der Einsatz beträgt " + pEinsatz + "\n";
        }
        string += score1 + " hat jetzt noch " + spieler1.getVermoegen() + "\n";
        string += score2 + " hat jetzt noch " + spieler2.getVermoegen() + "\n" + "\n";
        return string;
    }
    
    public String neuStart()
    {
        score1 = 0;
        score2 = 0;
        startSpieler1 = true;
        zugSpieler1 = true;
        gesetzt = false;
        // void neuesSpiel() soll das vermoegen auf 100 setzen und die wurfAnzahl auf null.
        // spieler1.neuesSpiel();
        // spieler2.neuesSpiel();
        int temp = topf.einsatzAbgeben();
        return "Das Spiel wurde neu gestartet!";
    }
}
