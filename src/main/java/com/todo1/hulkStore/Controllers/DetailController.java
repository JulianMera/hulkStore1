package com.todo1.hulkStore.Controllers;

import com.todo1.hulkStore.Entities.Detail;
import com.todo1.hulkStore.Services.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/detail")
public class DetailController {

    @Autowired
    private final DetailService detailService;

    @Autowired
    public DetailController(DetailService detailService) {
        this.detailService = detailService;
    }

    @GetMapping("/{saleId}")
    public ResponseEntity<List<Detail>> getDetailById(@PathVariable("saleId") String saleId) {
        return new ResponseEntity<>(this.detailService.getDetailBySaleId(saleId), HttpStatus.OK);
    }
}
