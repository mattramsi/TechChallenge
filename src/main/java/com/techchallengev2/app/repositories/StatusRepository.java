package com.techchallengev2.app.repositories;

import com.techchallengev2.app.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatusRepository extends JpaRepository<Status, Long> {
    Optional<Status> findByNome(String nome);
}
