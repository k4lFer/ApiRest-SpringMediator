package kalfer.apis_pring.Domain.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="users")
@Getter
public class TUser
{
    @Id
    private UUID id;

    private String name;

    private String email;

    public static TUser create(String name, String email) {
        TUser user = new TUser();
        user.id = UUID.randomUUID();
        user.name = name;
        user.email = email;
        return user;
    }
}