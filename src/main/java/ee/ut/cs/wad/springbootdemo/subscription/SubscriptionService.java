package ee.ut.cs.wad.springbootdemo.subscription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    @Autowired
    SubscriptionService(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    public void addSubscription(Subscription subscription) {
        Subscription existing = subscriptionRepository.findSubscriptionByEmail(subscription.getEmail());
        if (existing != null) {
            // if subscription with same email already exists, throw exception
            throw new UnsupportedOperationException("Cannot subscribe user with same e-mail twice");
        }
        subscriptionRepository.save(subscription);
    }

    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }

}
