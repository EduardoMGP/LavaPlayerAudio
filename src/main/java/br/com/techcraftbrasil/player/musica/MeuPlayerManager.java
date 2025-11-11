package br.com.techcraftbrasil.player.musica;

import com.sedmelluq.discord.lavaplayer.format.StandardAudioDataFormats;
import com.sedmelluq.discord.lavaplayer.player.AudioConfiguration;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;

public class MeuPlayerManager {

    private final AudioPlayerManager manager;
    private final MeuAudioPlayer meuPlayer;

    public MeuPlayerManager() {
        this.manager = new DefaultAudioPlayerManager();
        this.meuPlayer = new MeuAudioPlayer(this);
        AudioSourceManagers.registerLocalSource(this.manager);
        AudioSourceManagers.registerRemoteSources(this.manager);

        this.manager.getConfiguration().setOpusEncodingQuality(20);
        this.manager.getConfiguration().setResamplingQuality(AudioConfiguration.ResamplingQuality.HIGH);

        // Essa configuração é muitooooooo importante, sem ela não funciona o áudio!
        this.manager.getConfiguration().setOutputFormat(StandardAudioDataFormats.COMMON_PCM_S16_BE);
    }

    public AudioPlayerManager getPlayerManager() {
        return manager;
    }

    public void playFromUrl(String url) {
        this.manager.loadItem(url, new MeuAudioLoadResultHandler(this));
    }

    public MeuAudioPlayer getMeuPlayer() {
        return meuPlayer;
    }
}
