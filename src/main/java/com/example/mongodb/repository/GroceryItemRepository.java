package com.example.mongodb.repository;

import com.example.mongodb.entity.GroceryItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroceryItemRepository extends MongoRepository<GroceryItem, String> {

    //findItemByName, requires a parameter for the query
    //the field by which to filter the query
    @Query(value = "{name:'?0'}")
    GroceryItem findGroceryItemByName(String name);

    //uses the category field to get all the items of a particular category
    //only project the fields (name and quantity) in the query response,
    @Query(value = "{category: '?0'}", fields = "{'name': 1, 'quantity': 1}")
    List<GroceryItem> findAll(String category);
}
