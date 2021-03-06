import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
 
/**
 * Beschreiben Sie hier die Klasse GUI.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class GUI extends JFrame implements ActionListener
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private JButton wuerfeln, allIn, einsatzSetzen, zugAbgeben, neuStart;
    private JTextArea textfeld; 
    private JTextField eingabeFeld;
    private Spielverwaltung spielv;
          
    public void main(String[] args) {
     GUI neueGUI = new GUI();
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == this.wuerfeln) {
           addText(spielv.wuerfeln());
        } else if (e.getSource() == this.allIn){
            addText(spielv.allIn());
        } else if (e.getSource() == this.einsatzSetzen){
            addText(spielv.setzen(Integer.parseInt(eingabeFeld.getText())));
        }else if (e.getSource() == this.zugAbgeben) {
            addText(spielv.zugAbgeben());
        }else if (e.getSource() == this.neuStart) {
            neuStart();
            addText(spielv.neuStart());
        }
    }
    
    public void neuStart()
    {
        textfeld.selectAll();
        textfeld.cut();
        textfeld.setText("Wilkommen beim Spiel Verflixte Sieben! \n \n");
        eingabeFeld.setText("Einsatz");
    }
    
    public void createGUI()
    {
        JFrame meinJFrame = new JFrame();
      meinJFrame.setTitle("Verflixte Sieben");
      meinJFrame.setSize(800, 500);
      JPanel panel = new JPanel();
      panel.setLayout(new BorderLayout());
      JPanel buttonPanel = new JPanel();
      buttonPanel.setLayout(new FlowLayout());
      JPanel picturePanel = new JPanel();
      JPanel bottomPanel = new JPanel();
      
      
      textfeld = new JTextArea(20, 70);
      
      textfeld.setText("");
      
      textfeld.setLineWrap(true);
      
      textfeld.setWrapStyleWord(true);
      textfeld.setBackground(new Color(110,122,126));
      textfeld.setForeground(new Color(152,250,11));
      Font font = new Font("Casino", Font.PLAIN, 15);
      textfeld.setFont(font);
      
      JScrollPane scrollpane = new JScrollPane(textfeld);
      
      panel.add(scrollpane);
      
       meinJFrame.add(panel);
      meinJFrame.setVisible(true);
      
      wuerfeln = new JButton ("W??rfeln");
      wuerfeln.addActionListener(this);
      einsatzSetzen = new JButton("Einsatz setzen");
      einsatzSetzen.addActionListener(this);
      zugAbgeben = new JButton("Spielzug beenden.");
      zugAbgeben.addActionListener(this);
      allIn = new JButton("All-In");
      allIn.addActionListener(this);
      neuStart = new JButton("Spiel neu starten.");
      neuStart.addActionListener(this);
      eingabeFeld = new JTextField();
      eingabeFeld.setColumns(10);
      
      buttonPanel.add(eingabeFeld);
      buttonPanel.add(einsatzSetzen);
      buttonPanel.add(allIn);
      buttonPanel.add(wuerfeln);
      buttonPanel.add(zugAbgeben);
      
      
      buttonPanel.setBackground(new Color(85,95,98));
      buttonPanel.setForeground(Color.white);
      
      Font buttonFont = new Font("Reem Kufi", Font.PLAIN, 10);
      wuerfeln.setFont(buttonFont);
      einsatzSetzen.setFont(buttonFont);
      zugAbgeben.setFont(buttonFont);
      allIn.setFont(buttonFont);
      neuStart.setFont(buttonFont);
      
      wuerfeln.setBackground(new Color( 71, 78, 80 ));
      wuerfeln.setForeground(new Color(152,250,11));
      einsatzSetzen.setBackground(new Color( 71, 78, 80 ));
      einsatzSetzen.setForeground(new Color(152,250,11));
      zugAbgeben.setBackground(new Color( 71, 78, 80 ));
      zugAbgeben.setForeground(new Color(152,250,11));
      allIn.setBackground(new Color( 71, 78, 80 ));
      allIn.setForeground(new Color(152,250,11));
      neuStart.setBackground(new Color( 71, 78, 80 ));
      neuStart.setForeground(new Color(152,250,11));
      
      panel.add(buttonPanel, BorderLayout.PAGE_START);
      panel.add(picturePanel, BorderLayout.LINE_END);
      panel.add(bottomPanel, BorderLayout.PAGE_END);
      try {
         BufferedImage myPicture = ImageIO.read(new File("logo.png"));
         JLabel picLabel = new JLabel(new ImageIcon(myPicture));
         picturePanel.add(picLabel);
     } catch(Exception e) {
         addText("Bilddatei fehlt.");
     }
    }
    public GUI()
    {
        spielv = new Spielverwaltung();
        createGUI();
    }
    public void addText(String newText) {
      textfeld.append(newText);
    }
}

