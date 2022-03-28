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
     neueGUI.createGUI();
     spielv = new Spielverwaltung();
    }
    
    public void actionPerformed(ActionEvent e)
    {
         
    }
    
    public void createGUI()
    {
        JFrame meinJFrame = new JFrame();
      meinJFrame.setTitle("Scooterdatenbank 0.4");
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
      
      wuerfeln = new JButton(new ImageIcon(this.getClass().getResource("/images/buttonWuerfeln.png")));
      wuerfeln.addActionListener(this);
      einsatzSetzen = new JButton (new ImageIcon(this.getClass().getResource("/images/buttonEinsatzSetzen.png")));
      einsatzSetzen.addActionListener(this);
      zugAbgeben = new JButton(new ImageIcon(this.getClass().getResource("/images/buttonSpielzugBeenden.png")));
      zugAbgeben.addActionListener(this);
      allIn = new JButton(new ImageIcon(this.getClass().getResource("/images/buttonAllIn.png")));
      allIn.addActionListener(this);
      neuStart = new JButton(new ImageIcon(this.getClass().getResource("/images/buttonNeuStart.png")));
      neuStart.addActionListener(this);
      eingabeFeld = new JTextField();
      eingabeFeld.setColumns(10);
      
      buttonPanel.add(wuerfeln);
      buttonPanel.add(einsatzSetzen);
      buttonPanel.add(zugAbgeben);
      buttonPanel.add(allIn);
      buttonPanel.add(eingabeFeld);
      
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
        
    }
    public void addText(String newText) {
      textfeld.append(newText);
    }
}
