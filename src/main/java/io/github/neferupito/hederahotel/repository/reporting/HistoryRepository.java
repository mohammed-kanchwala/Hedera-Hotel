package io.github.neferupito.hederahotel.repository.reporting;

import io.github.neferupito.hederahotel.model.reporting.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {
}
