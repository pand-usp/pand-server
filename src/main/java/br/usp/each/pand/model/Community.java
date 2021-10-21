package main.java.br.usp.each.pand.model;

import io.quarkus.mongodb.panache.common.MongoEntity;
import org.bson.types.ObjectId;

@MongoEntity(collection = "community")
public class Community {
    
    public ObjectId id;

    public String name;

    public String description;

    public String imgPath;
}
