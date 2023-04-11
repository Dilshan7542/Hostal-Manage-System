package lk.ijse.hotel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Custom implements SuperEntity{
    String resID;
    Date date;
    Student student;
    Room room;
}
