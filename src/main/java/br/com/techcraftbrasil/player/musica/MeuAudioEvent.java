package br.com.techcraftbrasil.player.musica;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.event.AudioEventAdapter;
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import com.sedmelluq.discord.lavaplayer.track.AudioTrackEndReason;

public class MeuAudioEvent extends AudioEventAdapter {

    public void onPlayerPause(AudioPlayer player) {
        System.out.println("Player pausado.");
    }

    /**
     * @param player Audio player
     */
    public void onPlayerResume(AudioPlayer player) {
        System.out.println("Player resumido.");
    }

    /**
     * @param player Audio player
     * @param track  Audio track that started
     */
    public void onTrackStart(AudioPlayer player, AudioTrack track) {
        System.out.println("Música iniciada: " + track.getInfo().title);
        player.setVolume(50); // Define o volume para 50%
    }

    /**
     * @param player    Audio player
     * @param track     Audio track that ended
     * @param endReason The reason why the track stopped playing
     */
    public void onTrackEnd(AudioPlayer player, AudioTrack track, AudioTrackEndReason endReason) {
        System.out.println("Música terminou: " + track.getInfo().title + " | Motivo: " + endReason);
    }

    /**
     * @param player    Audio player
     * @param track     Audio track where the exception occurred
     * @param exception The exception that occurred
     */
    public void onTrackException(AudioPlayer player, AudioTrack track, FriendlyException exception) {
        System.out.println("Erro na música: " + track.getInfo().title + " | Erro: " + exception.getMessage());
    }

    /**
     * @param player      Audio player
     * @param track       Audio track where the exception occurred
     * @param thresholdMs The wait threshold that was exceeded for this event to trigger
     */
    public void onTrackStuck(AudioPlayer player, AudioTrack track, long thresholdMs) {
        System.out.println("Música travada: " + track.getInfo().title + " | Limite: " + thresholdMs + "ms");
    }

    public void onTrackStuck(AudioPlayer player, AudioTrack track, long thresholdMs, StackTraceElement[] stackTrace) {
        onTrackStuck(player, track, thresholdMs);
    }
}
