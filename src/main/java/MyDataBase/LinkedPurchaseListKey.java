package MyDataBase;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import java.io.Serializable;

@EqualsAndHashCode
public class LinkedPurchaseListKey implements Serializable {
    @Getter
    @Setter
    @Column(name = "course_id")
    private int courseId;

    @Getter
    @Setter
    @Column(name = "student_id")
    private int studentId;

    public LinkedPurchaseListKey() {
    }

    public LinkedPurchaseListKey(int courseId, int studentId) {
        this.courseId = courseId;
        this.studentId = studentId;
    }
}
