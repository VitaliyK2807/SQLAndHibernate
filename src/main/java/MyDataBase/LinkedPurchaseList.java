package MyDataBase;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode
@Entity(name = "linked_purchase_list")
public class LinkedPurchaseList {

    @Getter
    @Setter
    @EmbeddedId
    private LinkedPurchaseListKey id;

    @Getter
    @Setter
    @Column(name = "subscription_date")
    private Date subscriptionDate;


    public LinkedPurchaseList() {
    }


}
