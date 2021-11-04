package br.usp.each.pand.model;

import io.quarkus.mongodb.panache.common.MongoEntity;

@MongoEntity(collection = "user")
public class User {
    public String username;

    public String password;

    public String email;
}
