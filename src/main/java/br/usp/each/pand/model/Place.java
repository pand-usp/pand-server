package br.usp.each.pand.model;

import io.quarkus.mongodb.panache.common.MongoEntity;
import org.bson.types.ObjectId;

@MongoEntity(collection = "place")
public class Place {

    public ObjectId id;

    public String name;

    public String address;

    public String imageURL;

    public Accessibility accessibility;

    public Rating rating;
}
