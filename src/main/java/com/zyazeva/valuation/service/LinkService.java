package com.zyazeva.valuation.service;

import com.zyazeva.valuation.model.Link;
import java.util.List;

public interface LinkService {
    
    void createLink(Link link);

    Link readLink(int linkId);

    void updateLink(Link link);

    void deleteLink(Link link);

    List getAllLinks();
    
    List getAllLinksByProjectId(Integer projectId); 
    
}