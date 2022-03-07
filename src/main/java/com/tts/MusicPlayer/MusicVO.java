package com.tts.MusicPlayer;

public class MusicVO {
    //제목, 가수, 재생시간, 파일경로
    private String title;
    private String singer;
    private int playTime;
    private String path;

    public MusicVO(String title, String singer, int playTime, String path) {
        super();
        this.title = title;
        this.singer = singer;
        this.playTime = playTime;
        this.path = path;
    }

    public String getTitle() {
        return title;
    }

    public String getSinger() {
        return singer;
    }

    public int getPlayTime() {
        return playTime;
    }

    public String getPath() {
        return path;
    }

}