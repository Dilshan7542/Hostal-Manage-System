package lk.ijse.hotel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Reservation implements SuperEntity {
    @Id
    String resID;
    Date date;
    String status;
    @ManyToOne
    @JoinColumn(name = "studentID")
    Student student;
    @ManyToOne
    @JoinColumn(name = "roomID")
    Room room;
}
