package io.github.neferupito.hederahotel.model.room;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Room {

    @Id
    private int number;

    private Integer floor;

    @ManyToOne
    private Category category;

    @Enumerated(EnumType.STRING)
    private RoomState roomState = RoomState.CLOSED;

}
