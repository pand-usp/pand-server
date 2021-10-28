package br.usp.each.pand.model;

import io.quarkus.mongodb.panache.common.MongoEntity;
import org.bson.types.ObjectId;

import java.util.List;

@MongoEntity(collection = "community")
public class Community {

    public String name;

    public String description;

    public String imgPath;

    public List<ObjectId> places;
}
