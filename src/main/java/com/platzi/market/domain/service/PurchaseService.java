package com.platzi.market.domain.service;

import com.platzi.market.domain.Purchase;
import com.platzi.market.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Purchase> getAll(){return purchaseRepository.getAll();}

    public Optional<Purchase> getPurchase(int purchaseId){return purchaseRepository.getPurchase(purchaseId);}

    public Optional<List<Purchase>> getbyClient(String clientId){return purchaseRepository.getByClient(clientId);}

    public Purchase save(Purchase purchase){return purchaseRepository.save(purchase);}

    public boolean delete(int purchaseId) {
        return getPurchase(purchaseId).map(purchase -> {
            purchaseRepository.delete(purchaseId);
            return true;
        }).orElse(false);
    }

}
