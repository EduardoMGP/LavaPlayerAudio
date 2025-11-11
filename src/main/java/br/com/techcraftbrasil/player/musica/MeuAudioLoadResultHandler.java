package br.com.techcraftbrasil.player.musica;

import com.sedmelluq.discord.lavaplayer.player.AudioLoadResultHandler;
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException;
import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;

public class MeuAudioLoadResultHandler implements AudioLoadResultHandler {

    private final MeuPlayerManager manager;

    public MeuAudioLoadResultHandler(MeuPlayerManager manager) {
        this.manager = manager;
    }

    @Override
    public void trackLoaded(AudioTrack track) {
        System.out.println("Música carregada: " + track.getInfo().title);
        this.manager.getMeuPlayer().getPlayer().playTrack(track);
    }

    @Override
    public void playlistLoaded(AudioPlaylist playlist) {
        System.out.println("Playlist carregada: " + playlist.getName() + " com " + playlist.getTracks().size() + " faixas.");
    }

    @Override
    public void noMatches() {
        System.out.println("Nenhuma música ou playlist encontrada.");
    }

    @Override
    public void loadFailed(FriendlyException exception) {
        System.out.println("Falha ao carregar: " + exception.getMessage());
    }
}
