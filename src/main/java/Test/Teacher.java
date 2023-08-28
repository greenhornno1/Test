package Test;

import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Builder
@Setter
public class Teacher {
    String name;
    String id;
    Integer age;
    String gender;
    String educationalBackground;
}
