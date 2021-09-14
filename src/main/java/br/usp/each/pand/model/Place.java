package br.usp.each.pand.model;

import io.quarkus.mongodb.panache.common.MongoEntity;

@MongoEntity(collection = "place")
public class Place {
    public String name;

    public String description;
}
