package Client.ClientController;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Music implements Runnable{
    private Clip clip;
    AudioInputStream ais;

    public Music(File file){

        try {
            clip = AudioSystem.getClip();
            ais = AudioSystem.getAudioInputStream(file);

        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e1) {
            e1.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }

    }




    public void run(){
        try {
            clip.open(ais);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void turnOffVolume(){
        FloatControl gainControl =
                (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(-50.0f); //
    }
    public void turnOnVolume(){
        FloatControl gainControl =
                (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(6.0f); //
    }
    public void stopMusic() {
        clip.stop();
    }

}
