package org.surikov.first_project.repository.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.surikov.first_project.entities.data.StyleTag;

@Repository
public interface TagRepository extends JpaRepository<StyleTag, Long> {
}
