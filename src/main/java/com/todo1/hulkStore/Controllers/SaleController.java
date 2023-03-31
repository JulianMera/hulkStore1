package com.todo1.hulkStore.Controllers;

import com.todo1.hulkStore.Entities.Sale;
import com.todo1.hulkStore.Services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sale")
public class SaleController {

    @Autowired
    private final SaleService saleService;

    @Autowired
    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping("/client/{clientName}")
    public ResponseEntity<List<Sale>> getByClient(@PathVariable("clientName") String clientName) {
        return new ResponseEntity<>(this.saleService.getSaleByClient(clientName), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createSale(@PathVariable("clientName") String clientName) {
        this.saleService.createSale(clientName);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
