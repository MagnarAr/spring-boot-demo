package ee.ut.cs.wad.springbootdemo.subscription.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class SubscriptionDTO {

    private String firstName;
    private String lastName;
    private String email;
    // expects multipart image upload file
    // <input type="file" name="avatarImage" ...> is important in HTML form
    private MultipartFile avatarImage;

}
