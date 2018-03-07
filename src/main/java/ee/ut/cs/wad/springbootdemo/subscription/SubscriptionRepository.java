package ee.ut.cs.wad.springbootdemo.subscription;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    //@Query(value = "SELECT * FROM subscription WHERE email = :email", nativeQuery = true)
    Subscription findSubscriptionByEmail(@Param("email") String email);

}
