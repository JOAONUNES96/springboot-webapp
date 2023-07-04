package guru.springframework.spring5webapp.domain.composite;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity
@IdClass(NameId.class)
public class AuthorComposite {

    //to map the composite key we need to create a class that will hold the composite key - NameId class in this case
    //and then use it in the entity class
    @Id
    private String firstName;
    @Id
    private String lastName;
    private String country;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
