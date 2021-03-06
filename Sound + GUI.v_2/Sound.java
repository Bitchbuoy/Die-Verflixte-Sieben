import javax.sound.sampled.*;
import java.io.*;
import java.awt.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.lang.Exception;
import javax.swing.Timer;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Sound {

   
    public Sound()
    {
       //leerer Konstruktor
    }
    
    public void spieleSoundGewonnen (String pgameWin) throws Exception {
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File (pgameWin));

        int BUFFER_SIZE = 128000;
        AudioFormat audioFormat = null;
        SourceDataLine sourceLine = null;

        audioFormat = audioStream.getFormat();

        sourceLine = AudioSystem.getSourceDataLine(audioFormat);
        sourceLine.open(audioFormat);
        sourceLine.start();

        int nBytesRead = 0;
        byte[] abData = new byte[BUFFER_SIZE];
        while (nBytesRead != -1) {
            try {
                nBytesRead = 
                audioStream.read(abData, 0, abData.length);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (nBytesRead >= 0) {
                int nBytesWritten = sourceLine.write(abData, 0, nBytesRead);
            }
        }

        sourceLine.drain();
        sourceLine.close();
    }

    public void spieleSoundVerloren (String pDateiName) throws Exception {
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File (pDateiName));

        int BUFFER_SIZE = 128000;
        AudioFormat audioFormat = null;
        SourceDataLine sourceLine = null;

        audioFormat = audioStream.getFormat();

        sourceLine = AudioSystem.getSourceDataLine(audioFormat);
        sourceLine.open(audioFormat);
        sourceLine.start();

        int nBytesRead = 0;
        byte[] abData = new byte[BUFFER_SIZE];
        while (nBytesRead != -1) {
            try {
                nBytesRead = 
                audioStream.read(abData, 0, abData.length);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (nBytesRead >= 0) {
                int nBytesWritten = sourceLine.write(abData, 0, nBytesRead);
            }
        }

        sourceLine.drain();
        sourceLine.close();
    }
    
    public void spieleSoundHintergrund (String pDateiName) throws Exception {
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File (pDateiName));

        int BUFFER_SIZE = 128000;
        AudioFormat audioFormat = null;
        SourceDataLine sourceLine = null;

        audioFormat = audioStream.getFormat();

        sourceLine = AudioSystem.getSourceDataLine(audioFormat);
        sourceLine.open(audioFormat);
        sourceLine.start();

        int nBytesRead = 0;
        byte[] abData = new byte[BUFFER_SIZE];
        while (nBytesRead != -1) {
            try {
                nBytesRead = 
                audioStream.read(abData, 0, abData.length);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (nBytesRead >= 0) {
                int nBytesWritten = sourceLine.write(abData, 0, nBytesRead);
            }
        }

        sourceLine.drain();
        sourceLine.close();
    }
    
    public void spieleSoundWuerfeln (String pDateiName) throws Exception {
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File (pDateiName));

        int BUFFER_SIZE = 128000;
        AudioFormat audioFormat = null;
        SourceDataLine sourceLine = null;

        audioFormat = audioStream.getFormat();

        sourceLine = AudioSystem.getSourceDataLine(audioFormat);
        sourceLine.open(audioFormat);
        sourceLine.start();

        int nBytesRead = 0;
        byte[] abData = new byte[BUFFER_SIZE];
        while (nBytesRead != -1) {
            try {
                nBytesRead = 
                audioStream.read(abData, 0, abData.length);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (nBytesRead >= 0) {
                int nBytesWritten = sourceLine.write(abData, 0, nBytesRead);
            }
        }

        sourceLine.drain();
        sourceLine.close();
    }

    public void spieleSoundAbgeben (String pDateiName) throws Exception {
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File (pDateiName));

        int BUFFER_SIZE = 128000;
        AudioFormat audioFormat = null;
        SourceDataLine sourceLine = null;

        audioFormat = audioStream.getFormat();

        sourceLine = AudioSystem.getSourceDataLine(audioFormat);
        sourceLine.open(audioFormat);
        sourceLine.start();

        int nBytesRead = 0;
        byte[] abData = new byte[BUFFER_SIZE];
        while (nBytesRead != -1) {
            try {
                nBytesRead = 
                audioStream.read(abData, 0, abData.length);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (nBytesRead >= 0) {
                int nBytesWritten = sourceLine.write(abData, 0, nBytesRead);
            }
        }

        sourceLine.drain();
        sourceLine.close();
    }

    }


    

