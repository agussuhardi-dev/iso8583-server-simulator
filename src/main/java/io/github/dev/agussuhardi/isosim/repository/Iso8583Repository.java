package io.github.dev.agussuhardi.isosim.repository;

import io.github.dev.agussuhardi.isosim.entity.Iso8583;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface Iso8583Repository extends JpaRepository<Iso8583, String>, JpaSpecificationExecutor<Iso8583> {


    @Query(value = "select i.* from Iso8583 i where i.is_enabled = true limit 1", nativeQuery = true)
    Optional<Iso8583> findByEnabledIsTrue();


    @Modifying(clearAutomatically = true)
    @Query(value = "update Iso8583 set enabled=false where enabled is true ")
    void disableAll();
}
