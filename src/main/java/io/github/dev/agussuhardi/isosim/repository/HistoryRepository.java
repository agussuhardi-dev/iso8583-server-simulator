package io.github.dev.agussuhardi.isosim.repository;

import io.github.dev.agussuhardi.isosim.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface HistoryRepository extends JpaRepository<History, String>, JpaSpecificationExecutor<History> {

}
