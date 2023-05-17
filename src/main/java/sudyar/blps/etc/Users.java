package sudyar.blps.etc;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import sudyar.blps.entity.User;

import java.util.ArrayList;
import java.util.List;

@Data
@XmlRootElement
public class Users {
    private List<User> user;

    public Users(){
        user = new ArrayList<>();
    }
}
