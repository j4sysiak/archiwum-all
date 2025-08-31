package com.company;

import java.util.Hashtable;
import java.util.Map;

/*
Logika Proxy:   zadanie dodanie dodatkowej logiki, aby aplikacja była bardziej
wydajniejsza i zużywała mniej zewnętrznych zasobów
*/

public class ProxyYouTubeService implements IYouTubeService {

    // zapisane już videoId - ściągnięte wcześniej
    static Map<Integer, byte[]> _cache = new Hashtable() {
    };
    static {
        _cache.put(100, new byte[2143432]);
        _cache.put(101, new byte[54355654]);
    }

    //referencja do bazowego YouTubeService poprzez abstrakcję
    private IYouTubeService iyouTubeService;

    public ProxyYouTubeService(YouTubeService youTubeService) {
        this.iyouTubeService = youTubeService;
    }

    @Override
    public byte[] getVideo(int viedeoId) {
        System.out.println("ProxyYouTubeService getting video: " + viedeoId);

        //sprawdzamy, czy to video już nie było pobierane
        for (Map.Entry<Integer, byte[]> entry : _cache.entrySet()) {
            if (entry.getKey().equals(viedeoId)) {
                System.out.println("ProxyYouTubeService: Getting Video from _cache: " + entry.getKey());
                return entry.getValue();
            }
        }

        //będziemy musieli odnieść się do tego prawdziwego serwisu jakim jest YouTubeService
        byte[] video = iyouTubeService.getVideo(viedeoId);
        _cache.put(viedeoId, video);
        return video;
    }
}
































