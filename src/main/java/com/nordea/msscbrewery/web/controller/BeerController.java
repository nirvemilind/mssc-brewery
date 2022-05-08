package com.nordea.msscbrewery.web.controller;

import com.nordea.msscbrewery.services.BeerService;
import com.nordea.msscbrewery.web.model.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId ){
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<BeerDto> handlePost(@RequestBody BeerDto beerDto){

        System.out.println("Beer Details : \n " + " Beer Name : " + beerDto.getBeerName() + "\n" + " Beer Style:"
                + beerDto.getBeetStyle() );
        BeerDto beerDto1 = beerService.saveBeer(beerDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("location" , "/api/v1/beer/"+beerDto1.getId().toString());

        return new ResponseEntity<>(httpHeaders,HttpStatus.CREATED);


    }
}
