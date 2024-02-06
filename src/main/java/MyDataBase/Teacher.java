package MyDataBase;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "teachers")
public class Teacher{

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
    private int salary;

    @Getter
    @Setter
    @Column(nullable = true)
    private int age;

    public Teacher() {}



}
