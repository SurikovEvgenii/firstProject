package org.surikov.first_project.repository.accounts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.surikov.first_project.entities.accounts.DesignerAccount;

@Repository
public interface DesignerRepository extends JpaRepository<DesignerAccount, Long> {
    DesignerAccount findDesignerAccountByLogin (String login);
}
