package Test;

import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import java.util.List;

@Data
@Builder
@Setter
public class Student {
    String name;
    Integer age;
    String gender;
    Integer id;
    List<Teacher> contacts;
}
