package ee.ut.cs.wad.springbootdemo.subscription;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "subscription")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subscriptionId;

    @Enumerated(EnumType.STRING)
    private SubscriptionType type;

    private String firstName;
    private String lastName;
    private String email;
    private String imageSource; // type + base64 encoded image bytes

    public String getInfo() {
        return firstName + " " + lastName + " - " + email;
    }
}
