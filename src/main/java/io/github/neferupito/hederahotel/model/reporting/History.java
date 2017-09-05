package io.github.neferupito.hederahotel.model.reporting;

import io.github.neferupito.hederahotel.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<HistoryLine> lines = new ArrayList<>();

    public static History createHistoryWithFirstLine(HistoryMessages message, User user) {
        History history = new History();
        history.getLines().add(
                HistoryLine.builder()
                        .who(user)
                        .when(new Date())
                        .what(message)
                        .build());
        return history;
    }

}
