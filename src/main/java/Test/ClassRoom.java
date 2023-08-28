package Test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
//@Builder
//@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ClassRoom {
    List<Student> students;
    Integer roomNumber;
}
