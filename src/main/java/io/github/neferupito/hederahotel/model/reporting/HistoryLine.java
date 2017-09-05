package io.github.neferupito.hederahotel.model.reporting;

import io.github.neferupito.hederahotel.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class HistoryLine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Date when;

    @ManyToOne
    private User who;

    @Enumerated(EnumType.STRING)
    private HistoryMessages what;

}
