package org.surikov.first_project.repository.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.surikov.first_project.entities.accounts.DesignerAccount;
import org.surikov.first_project.entities.data.ProfilePicture;

@Repository
public interface ProfilePictureRepository extends JpaRepository<ProfilePicture, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE ProfilePicture p SET p.url = :url WHERE p.designerAccount = :designerAccount")
    void updateProfilePictureByDesignerAccountAndUrl(@Param("designerAccount") DesignerAccount designerAccount, @Param("url") String url);

    ProfilePicture findByDesignerAccount(DesignerAccount designerAccount);

    boolean existsByDesignerAccount(DesignerAccount designerAccount);
}
