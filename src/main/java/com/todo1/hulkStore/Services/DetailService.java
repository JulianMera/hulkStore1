package com.todo1.hulkStore.Services;

import com.todo1.hulkStore.Entities.Detail;
import com.todo1.hulkStore.Repositories.DetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DetailService {

    private final DetailRepository detailRepository;

    @Autowired
    public DetailService(DetailRepository detailRepository) {
        this.detailRepository = detailRepository;
    }

    public void createDetail(Detail detail) {
        this.detailRepository.save(detail);
    }
    public List<Detail> getDetailBySaleId(String saleId){
        return this.detailRepository.findBySaleId(saleId);
    }

}
