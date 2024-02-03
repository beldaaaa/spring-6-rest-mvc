package springframework.spring6restmvc.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import springframework.spring6restmvc.model.Beer;
import springframework.spring6restmvc.model.BeerStyle;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    private Map<UUID, Beer> beerMap;// just for example as substitute for DB
    //so its initialized in ctor and generates data

    public BeerServiceImpl(Map<UUID, Beer> beerMap) {
        this.beerMap = beerMap;
        Beer beer1 = Beer.builder()//builder pattern saves quite of code (no creating new object, no setters and returning value then,...)
                .id(UUID.randomUUID())
                .version(1)
                .beerName("12")
                .beerStyle(BeerStyle.PILSNER)
                .upc("456")
                .price(new BigDecimal("25.90"))
                .quantityOnHand(40)
                .createdData(LocalDateTime.now())
                .updateData(LocalDateTime.now())
                .build();
        Beer beer2 = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("10")
                .beerStyle(BeerStyle.STOUT)
                .upc("444")
                .price(new BigDecimal("12.90"))
                .quantityOnHand(120)
                .createdData(LocalDateTime.now())
                .updateData(LocalDateTime.now())
                .build();
        Beer beer3 = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("1000")
                .beerStyle(BeerStyle.IPA)
                .upc("99")
                .price(new BigDecimal("50.90"))
                .quantityOnHand(12)
                .createdData(LocalDateTime.now())
                .updateData(LocalDateTime.now())
                .build();
        beerMap.put(beer1.getId(), beer1);
        beerMap.put(beer2.getId(), beer2);
        beerMap.put(beer3.getId(), beer3);
    }

    @Override
    public List<Beer> beerList() {
        return new ArrayList<>(beerMap.values());
    }

    @Override
    public Beer getBeerById(UUID id) {

        log.debug("Get Beer Id in service was called");

        return beerMap.get(id);
    }
}
