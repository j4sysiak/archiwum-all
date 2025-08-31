package com.company;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MapCreator {

    private IRouteStrategy iRouteStrategy;

    public MapCreator(IRouteStrategy routeStrategy) {
        this.iRouteStrategy = routeStrategy;
    }

    // to jest taki przekaznik (switch), w zaleznoci na jakim elemencie zdefiniujemz interfej
    // to taka będie strategia  /- droga do celu (piechota, rower, samochód)
    public void creatingRoute(Coordinate start, Coordinate stop) {
        this.iRouteStrategy.createRoute(start, stop);
    }
}
