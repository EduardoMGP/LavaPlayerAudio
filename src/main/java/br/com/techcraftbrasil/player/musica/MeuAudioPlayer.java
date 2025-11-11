package br.com.techcraftbrasil.player.musica;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;

public class MeuAudioPlayer {

    private final AudioPlayer player;
    private final MeuPlayerManager manager;

    public MeuAudioPlayer(MeuPlayerManager manager) {
        this.manager = manager;
        this.player = this.manager.getPlayerManager().createPlayer();
        this.player.addListener(new MeuAudioEvent());
    }

    public AudioPlayer getPlayer() {
        return player;
    }
}
