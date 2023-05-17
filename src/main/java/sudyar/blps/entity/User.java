package sudyar.blps.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@XmlRootElement
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String login;

    @JsonIgnore
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

}
