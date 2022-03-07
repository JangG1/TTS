package com.tts.MusicPlayer;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // 메뉴 출력(), 재생정보 출력()
        ArrayList<MusicVO> playlist = new ArrayList<MusicVO>();
        playlist.add(new MusicVO("slow", "joji", 100, "C:\\study_boot\\trans\\src\\main\\java\\music\\joji.mp3"));
        playlist.add(new MusicVO("test", "test", 120, "C:\\study_boot\\trans\\src\\main\\java\\music\\1644805215282.mp3"));
//        playlist.add(new MusicVO("cheerup", "트와이스", 143, ".\\src\\music\\cheerup.mp3"));
//        playlist.add(new MusicVO("daddy", "싸이", 190, ".\\src\\music\\daddy.mp3"));
//        playlist.add(new MusicVO("dumbdumb", "레드벨벳", 110, ".\\src\\music\\dumbdumb.mp3"));
//        playlist.add(new MusicVO("유리구슬", "여자친구", 170, ".\\src\\music\\glass.mp3"));
//        playlist.add(new MusicVO("IcecreamCake", "레드벨벳", 110, ".\\src\\music\\icecreamcake.mp3"));
//        playlist.add(new MusicVO("이럴거면그러지말지", "백아연", 90, ".\\src\\music\\no.mp3"));
//        playlist.add(new MusicVO("위아래", "EXID", 110, ".\\src\\music\\updown.mp3"));
//        playlist.add(new MusicVO("uptownpuck", "브루노마스", 90, ".\\src\\music\\uptownpunk.mp3"));

        MusicPlayer mp = new MusicPlayer(playlist);
        boolean onOff = true;

        while (onOff) {
            System.out.println("[1]재생  [2]정지  [3]이전곡  [4]다음곡  [5]종료");
            switch (new Scanner(System.in).nextInt()) {
                case 1:
                    MusicVO currentMusic = mp.play();
                    System.out.println(currentMusic.getTitle());
                    break;
                case 2:
                    mp.stop();
                    System.out.println("정지");
                    break;
                case 3:
                    MusicVO previouMusic = mp.previous();
                    System.out.println(previouMusic.getTitle());
                    break;
                case 4:
                    MusicVO nextMusic = mp.next();
                    System.out.println(nextMusic.getTitle());
                    break;
                case 5:
                    System.out.println("종료");
                    onOff = false;
                    break;
            }

        }
    }

}