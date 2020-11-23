package ru.innopolis.models;

import lombok.*;
import ru.innopolis.forms.UserForm;
import javax.persistence.*;
import java.util.List;


@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "fix_user", uniqueConstraints = @UniqueConstraint(columnNames = {"login"}))
@EqualsAndHashCode
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String login;
    private String hashPassword;
    @Enumerated(value = EnumType.STRING)
    private Role role;
    @Enumerated(value = EnumType.STRING)
    private State state;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    List<Player> players;

    public static User from(UserForm form) {
        return User.builder()
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .build();
    }

}
