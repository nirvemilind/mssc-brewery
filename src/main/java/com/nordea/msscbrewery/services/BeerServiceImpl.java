package com.nordea.msscbrewery.services;

import com.nordea.msscbrewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID())
                                .beerName("CarlsBerg")
                                .beetStyle("Mild").build();
    }

    @Override
    public BeerDto saveBeer(BeerDto beerDto) {
        System.out.println("Beer Details : \n " + " Beer Name : " + beerDto.getBeerName() + "\n" + " Beer Style:"
                + beerDto.getBeetStyle() );

        return BeerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }
}
