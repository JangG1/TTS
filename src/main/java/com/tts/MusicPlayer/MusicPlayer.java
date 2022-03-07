package com.tts.MusicPlayer;

import java.util.ArrayList;

import javazoom.jl.player.MP3Player;

public class MusicPlayer {
    //노래리스트,  재생(), 정지(), 이전곡(), 다음곡()
    private ArrayList<MusicVO> playlist = new ArrayList<MusicVO>();
    private MP3Player mp3Player;
    private int index;

    public MusicPlayer(ArrayList<MusicVO> playlist) {
        this.playlist = playlist;
        this.mp3Player = new MP3Player();
    }

    public ArrayList<MusicVO> getPlaylist() {
        return playlist;
    }

    public void indexNum(int index) {
        if(index < 0) {
            index = playlist.size() - 1;
        } else if(index >= playlist.size()) {
            index = 0;
        }
        this.index = index;
    }

    public MusicVO play() {
        MusicVO m = playlist.get(index);
        if(mp3Player.isPlaying()) {
            mp3Player.stop();
        }
        mp3Player.play(m.getPath());

        return m;
    }

    public void stop() {
        if(mp3Player.isPlaying()) {
            mp3Player.stop();
        }
    }

    public MusicVO previous() {
        indexNum(index-1);

        return play();
    }

    public MusicVO next() {
        indexNum(index+1);

        return play();
    }

}