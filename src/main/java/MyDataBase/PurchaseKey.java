package MyDataBase;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import java.io.Serializable;

@EqualsAndHashCode
public class PurchaseKey implements Serializable{

    @Getter
    @Setter
    @Column(name = "student_name", columnDefinition="varchar(160)", nullable = false)
    public String studentName;

    @Getter
    @Setter
    @Column (name = "course_name", columnDefinition="varchar(160)", nullable = false)
    public String courseName;


}
