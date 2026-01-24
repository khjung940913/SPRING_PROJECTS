package guru.springframework.spring7restmvc.services;

import guru.springframework.spring7restmvc.model.Beer;
import guru.springframework.spring7restmvc.model.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

    private Map<UUID, Beer> beerMap;

    public BeerServiceImpl() {
        Beer beer1 = Beer.builder()
                .id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyle.PILSNER)
                .upc("123456789012")
                .price(new java.math.BigDecimal("12.99"))
                .quantityOnHand(394)
                .build();

        Beer beer2 = Beer.builder()
                .id(UUID.randomUUID())
                .beerName("Crank")
                .beerStyle(BeerStyle.ALE)
                .upc("123456789013")
                .price(new java.math.BigDecimal("11.99"))
                .quantityOnHand(392)
                .build();

        Beer beer3 = Beer.builder()
                .id(UUID.randomUUID())
                .beerName("Sunshine City")
                .beerStyle(BeerStyle.IPA)
                .upc("123456789014")
                .price(new java.math.BigDecimal("13.99"))
                .quantityOnHand(144)
                .build();

        beerMap = Map.of(
                beer1.getId(), beer1,
                beer2.getId(), beer2,
                beer3.getId(), beer3
        );
    }

    @Override
    public List<Beer> listBeers() {
        return List.copyOf(beerMap.values());
    }


    @Override
    public Beer getBeerById(UUID id) {

        log.debug("Get Beer by Id - in service. Id: {}", id.toString());

        return this.beerMap.get(id);
    }

    @Override
    public Beer saveNewBeer(Beer beer) {
        Beer savedBeer = Beer.builder()
                .id(UUID.randomUUID())
                .beerName(beer.getBeerName())
                .beerStyle(beer.getBeerStyle())
                .upc(beer.getUpc())
                .price(beer.getPrice())
                .quantityOnHand(beer.getQuantityOnHand())
                .build();

        log.debug("Saved new Beer - in service. Id: {}", savedBeer.getId().toString());
        this.beerMap.put(savedBeer.getId(), savedBeer);

        return savedBeer;
    }
}
