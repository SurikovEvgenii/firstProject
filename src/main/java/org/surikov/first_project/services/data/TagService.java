package org.surikov.first_project.services.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.surikov.first_project.entities.data.StyleTag;
import org.surikov.first_project.repository.data.TagRepository;

import java.util.List;

@Service
public class TagService {

    private TagRepository tagRepository;

    @Autowired
    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<StyleTag> findAll(){
        return tagRepository.findAll();
    }

}
