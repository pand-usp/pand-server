package br.usp.each.pand.service;


import br.usp.each.pand.model.Community;
import br.usp.each.pand.repository.CommunitiesRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class CommunitiesService {

    @Inject
    CommunitiesRepository communitiesRepository;

    public Community findCommunityById(String id) {
        // TODO implement
        return null;
    }

    public List<Community> listCommunities() {
        return communitiesRepository.findByName("");
    }

    public void insertCommunity(Community community) {
        communitiesRepository.insertCommunity(community);
    }

    public void addPlace(String id) {
    }
}
