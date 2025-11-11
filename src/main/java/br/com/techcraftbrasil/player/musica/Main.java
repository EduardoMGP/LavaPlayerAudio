package br.com.techcraftbrasil.player.musica;

public class Main {
    public static void main(String[] args) {
        MeuPlayerManager manager = new MeuPlayerManager();
        SaidaAudioStandalone saida = new SaidaAudioStandalone(manager.getMeuPlayer().getPlayer());
        saida.iniciarReproducao();

        manager.playFromUrl("https://e-spo-102.fabricahost.com.br/metropolitana985sp?f=1762866777N01K9SGRKKZ5FXHS6YQHC1ZAJVW&tid=01K9SGRKKZDXP44WZBFQ5Q9YQ7");

    }
}