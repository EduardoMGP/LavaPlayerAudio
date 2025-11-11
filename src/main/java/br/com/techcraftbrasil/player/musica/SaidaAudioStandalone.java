package br.com.techcraftbrasil.player.musica;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.track.playback.AudioFrame;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SaidaAudioStandalone {

    private final AudioPlayer player;
    private SourceDataLine linhaDeAudio;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public SaidaAudioStandalone(AudioPlayer player) {
        this.player = player;

        try {
            AudioFormat format = new AudioFormat(44100.0f, 16, 2, true, true);
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
            this.linhaDeAudio = (SourceDataLine) AudioSystem.getLine(info);
            this.linhaDeAudio.open(format);
            this.linhaDeAudio.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void iniciarReproducao() {
        executor.submit(() -> {
            System.out.println("Iniciando reprodução de áudio...");
            while (!Thread.currentThread().isInterrupted()) {
                AudioFrame frame = player.provide();
                if (frame == null) {
                    try { Thread.sleep(5); } catch (InterruptedException ignored) {}
                    continue;
                }
                byte[] pcm = frame.getData();
                this.linhaDeAudio.write(pcm, 0, pcm.length);
            }
        });
    }

    public void parar() {
        executor.shutdownNow();
        this.linhaDeAudio.drain(); // Esvazia buffer
        this.linhaDeAudio.close();
    }

}
