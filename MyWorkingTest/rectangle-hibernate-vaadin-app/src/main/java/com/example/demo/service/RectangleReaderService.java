package com.example.demo.service;

import com.example.demo.model.Rectangle;
import com.example.demo.repository.RectangleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class RectangleReaderService {

    // Żeby zapisać Rectangle w bazie to musimy wstrzyknąć beana RectangleRepo
    private RectangleRepo rectangleRepo;

    @Autowired
    public RectangleReaderService(RectangleRepo rectangleRepo) {
        this.rectangleRepo = rectangleRepo;
    }

    //wstrzyknięcie wartości z konfiguracji
    @Value("${siteA1}")
    private int siteA1;
    @Value("${siteB1}")
    private int siteB1;

    @Value("${siteA2}")
    private int siteA2;
    @Value("${siteB2}")
    private int siteB2;

    @Value("${siteA3}")
    private int siteA3;
    @Value("${siteB3}")
    private int siteB3;

    @Value("${siteA4}")
    private int siteA4;
    @Value("${siteB4}")
    private int siteB4;

    // znaczenie tej adnotacji: zdarzenie ma być przechwycone przez aspect (Beffore...    ...after)
    // np. w momenncie startu aplikacji włazimy tutaj i budujemy cztery prostokąty
    @EventListener(ApplicationReadyEvent.class)
    public void addRectangles() {
        Rectangle r1 = Rectangle.builder()
                .height(siteA1)
                .weight(siteB1)
                .build();

        Rectangle r2 = Rectangle.builder()
                .height(siteA2)
                .weight(siteB3)
                .build();

        Rectangle r3 = Rectangle.builder()
                .height(siteA3)
                .weight(siteB3)
                .build();

        Rectangle r4 = Rectangle.builder()
                .height(siteA4)
                .weight(siteB4)
                .build();

        System.out.println("Zapis tych elementó do bazy");  // localhost:8080/figureDB
        rectangleRepo.save(r1);
        rectangleRepo.save(r2);
        rectangleRepo.save(r3);
        rectangleRepo.save(r4);
    }
}
