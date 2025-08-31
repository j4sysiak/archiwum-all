package com.company;

public class YouTubeService implements IYouTubeService  {

    @Override
    public byte[] getVideo(int viedeoId) {
        System.out.println("YouTubeService downloading video: " + viedeoId);
        return new byte[viedeoId];
    }
}
