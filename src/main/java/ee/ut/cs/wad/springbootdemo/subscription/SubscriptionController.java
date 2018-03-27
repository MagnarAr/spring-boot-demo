package ee.ut.cs.wad.springbootdemo.subscription;

import ee.ut.cs.wad.springbootdemo.subscription.dto.SubscriptionDTO;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class SubscriptionController {

    private final static String SUBSCRIPTION_PAGE = "subscription/subscription";
    private final SubscriptionService subscriptionService;

    @Autowired
    SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @GetMapping("/subscription")
    public String getSubscriptons(Model model) {
        model.addAttribute("subscriptions", subscriptionService.getAllSubscriptions());
        return SUBSCRIPTION_PAGE;
    }

    @PostMapping("/subscription")
    public String addNewSubscription(@ModelAttribute SubscriptionDTO subscriptionDTO, Model model) {
        // map DTO to entity that can be persisted using service
        Subscription subscription = new Subscription();
        subscription.setFirstName(subscriptionDTO.getFirstName());
        subscription.setLastName(subscriptionDTO.getLastName());
        subscription.setEmail(subscriptionDTO.getEmail());
        subscription.setType(SubscriptionType.EMAIL);

        try {
            // get image from DTO
            subscription.setImageSource(getImageBase64Format(subscriptionDTO.getAvatarImage()));
            // persist entity object to DB
            subscriptionService.addSubscription(subscription);
            // if no exeption was thrown, everything went successfully
            model.addAttribute("successMessage", "Subscription added successfully!");
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
        } finally {
            model.addAttribute("subscriptions", subscriptionService.getAllSubscriptions());
        }

        return SUBSCRIPTION_PAGE;
    }

    // here we take uploaded image bytes and map it to the string
    // that can later be used to show the image in HTML <img src="">
    private String getImageBase64Format(MultipartFile file) throws Exception {
        return "data:" + file.getContentType() + ";base64," + Base64.encodeBase64String(file.getBytes());
    }
}
