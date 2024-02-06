package MyDataBase;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@EqualsAndHashCode
@Entity
@Table(name = "courses")
public class Course{

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Setter
    @Column(length = 500)
    private String name;

    @Getter
    @Setter
    private Integer duration;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CourseType type;

    @Getter
    @Setter
    @Column(nullable = true)
    private String description;

    @Getter
    @Setter
    @ManyToOne (cascade = CascadeType.ALL, targetEntity = Teacher.class)
    private Teacher teacher;

    @Getter
    @Setter
    @Column(name = "students_count", nullable = false)
    private Integer studentsCount;

    @Getter
    @Setter
    @Column(nullable = true)
    private int price;

    @Getter
    @Setter
    @Column(name = "price_per_hour")
    private float pricePerHour;

    public Course() {
    }


}
