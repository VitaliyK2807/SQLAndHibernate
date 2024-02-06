package MyDataBase;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode
@Entity
@Table(name = "purchaselist")
public class PurchaseList {

    @Getter
    @Setter
    @EmbeddedId
    private PurchaseKey id;

    @Getter
    @Setter
    @Column(name = "student_name", insertable = false, updatable = false, nullable = false)
    public String studentName;

    @Getter
    @Setter
    @Column (name = "course_name", insertable = false, updatable = false, nullable = false)
    public String courseName;

    @Getter
    @Setter
    private Integer price;

    @Getter
    @Setter
    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public PurchaseList() {}

}
