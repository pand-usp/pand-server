package br.usp.each.pand.repository;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import br.usp.each.pand.model.Community;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class CommunitiesRepository implements PanacheMongoRepository<Community>{
    
    public void insertCommunity(Community community) {
        this.persist(community);
    }

    public List<Community> findByName(String name) {
        return this.find("name like ?1", caseInsensitive(name)).list();
    }

    private String caseInsensitive(String field) {
        return "/" + field + "/i";
    }
}
