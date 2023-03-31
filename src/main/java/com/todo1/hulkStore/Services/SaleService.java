package com.todo1.hulkStore.Services;

import com.todo1.hulkStore.Entities.Detail;
import com.todo1.hulkStore.Entities.Sale;
import com.todo1.hulkStore.Entities.ShoppingCart;
import com.todo1.hulkStore.Entities.User;
import com.todo1.hulkStore.Repositories.SaleRepository;
import com.todo1.hulkStore.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
@Transactional
public class SaleService {

    @Autowired
    private final SaleRepository saleRepository;
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final DetailService detailService;

    @Autowired
    public SaleService(SaleRepository saleRepository, UserService userRepository, ShoppingCartService shoppingCartService, DetailService detailService) {
        this.saleRepository = saleRepository;
        this.userService = userRepository;
        this.shoppingCartService = shoppingCartService;

        this.detailService = detailService;
    }
    public List<Sale> getSaleByClient(String clientName) {
        return this.saleRepository.findByClient(clientName);
    }
    public void createSale(String clientName) {
        User client = this.userService.getClientByUserName(clientName).get(0);
        List<ShoppingCart> shoppingCartList = shoppingCartService.findByClientName(client.getUserName());
        DecimalFormat decimalFormat = new DecimalFormat("0.00", new DecimalFormatSymbols(Locale.US));
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        double total = shoppingCartList.stream().mapToDouble(shoppingCartItem ->
        shoppingCartItem.getProduct().getPrice() * shoppingCartItem.getAmount()).sum();
        Sale sale = new Sale(Double.parseDouble(decimalFormat.format(total)), new Date(), client);
        Sale saveSale = this.saleRepository.save(sale);
        for (ShoppingCart shoppingCart : shoppingCartList) {
            Detail detail = new Detail();
            detail.setProduct(shoppingCart.getProduct());
            detail.setAmount(shoppingCart.getAmount());
            detail.setSale(saveSale);
            this.detailService.createDetail(detail);
        }
        this.shoppingCartService.cleanShoppingCart(client.getId());
    }
}