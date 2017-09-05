package io.github.neferupito.hederahotel.repository.reporting;

import io.github.neferupito.hederahotel.model.reporting.HistoryLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryLineRepository extends JpaRepository<HistoryLine, Long> {
}
