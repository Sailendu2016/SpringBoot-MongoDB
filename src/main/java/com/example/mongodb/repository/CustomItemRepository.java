package com.example.mongodb.repository;

import org.springframework.stereotype.Component;

@Component
public interface CustomItemRepository {

    void updateItemQuantity(String name, float newQuantity);

}
