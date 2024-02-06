package MyDataBase;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode
@Entity
@Table (name = "subscriptions")
public class Subscriptions {

    @Getter
    @Setter
    @EmbeddedId
    private SubscriptionKey id;

    @Getter
    @Setter
    @Column(name = "student_id", insertable = false, updatable = false)
    private int studentId;

    @Getter
    @Setter
    @Column(name = "course_id", insertable = false, updatable = false)
    private int courseId;

    @Getter
    @Setter
    @Column(name = "subscription_date", nullable = false)
    private Date subscriptionDate;

    public Subscriptions() {
    }

}
