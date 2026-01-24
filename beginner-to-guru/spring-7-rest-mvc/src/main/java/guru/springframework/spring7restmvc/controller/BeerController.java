package guru.springframework.spring7restmvc.controller;

import guru.springframework.spring7restmvc.model.Beer;
import guru.springframework.spring7restmvc.services.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@Slf4j
public class BeerController {
    private final BeerService beerService;

    @PostMapping
    public ResponseEntity<Beer> handlePost(Beer beer) {
        log.debug("Handle Post - in controller");

        Beer savedBeer = beerService.saveNewBeer(beer);

       return new ResponseEntity<>(savedBeer, HttpStatusCode.valueOf(201));
    }

    @RequestMapping("/api/v1/beer")
    public List<Beer> listBeers() {

        log.debug("List Beers - in controller");

        return beerService.listBeers();
    }

    @RequestMapping("/api/v1/beer/{beerId}")
    public Beer getBeerById(@PathVariable UUID beerId) {

        log.debug("Get Beer by Id - in controller. Id: {}", beerId.toString());

        return beerService.getBeerById(beerId);
    }
}
