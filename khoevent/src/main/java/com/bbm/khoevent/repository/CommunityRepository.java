package com.bbm.khoevent.repository;

import com.bbm.khoevent.model.Community;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityRepository extends JpaRepository<Community, Long> {

//    metodo pra verificar se o nome e o email sao unicos

    boolean existsByNameOrEmail(String name, String email);
}
