package io.github.dev.agussuhardi.isosim.repository;

import io.github.dev.agussuhardi.isosim.entity.Iso8583ResponseTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface Iso8583ResponseTemplateRepository extends JpaRepository<Iso8583ResponseTemplate, String>, JpaSpecificationExecutor<Iso8583ResponseTemplate> {

}
