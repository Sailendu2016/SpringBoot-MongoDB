package com.example.mongodb.entity.repository;

import com.example.mongodb.entity.GroceryItem;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
public class CustomItemRepositoryImpl implements CustomItemRepository{
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void updateItemQuantity(String name, float newQuantity) {

        Query query = new Query(Criteria.where("name").is(name));
        Update update = new Update();
        update.set("quantity",newQuantity);

        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, GroceryItem.class);

        if(updateResult == null)
            System.out.println("No documents updated");
        else
            System.out.println(updateResult.getModifiedCount() + " document(s) updated..");

    }

}
