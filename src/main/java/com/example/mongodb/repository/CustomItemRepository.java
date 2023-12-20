package com.example.mongodb.entity.repository;

public interface CustomItemRepository {

    void updateItemQuantity(String name, float newQuantity);

}
