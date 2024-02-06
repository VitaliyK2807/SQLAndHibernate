package MyDataBase;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "students")
public class Student {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Setter
    @Column(length = 45, nullable = false)
    private String name;

    @Getter
    @Setter
    @Column(nullable = true)
    private int age;

    @Getter
    @Setter
    @Column(name = "registration_date", nullable = false)
    private Date registrationDate;

    public Student() {}


}
