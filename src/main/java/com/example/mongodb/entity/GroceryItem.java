package com.example.mongodb.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("groceryitems")
@Getter
@Setter
@AllArgsConstructor
public class GroceryItem {

    @Id
    private String id; //If we don't do this, MongoDB will automatically generate an _id when creating the document.
    private String name;
    private int quantity;
    private String category;
}
