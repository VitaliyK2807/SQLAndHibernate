package MyDataBase;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@EqualsAndHashCode
public class  SubscriptionKey implements Serializable {
    @Getter
    @Setter
    @JoinTable(name = "courses")
    @Column(name = "course_id")
    private int courseId;

    @Getter
    @Setter
    @JoinTable(name = "students")
    @Column(name = "student_id")
    private int studentId;

    public SubscriptionKey() {}

    public SubscriptionKey(int courseId, int studentId) {
        this.courseId = courseId;
        this.studentId = studentId;
    }


//setters, getters, equals(), hashcode()
}
