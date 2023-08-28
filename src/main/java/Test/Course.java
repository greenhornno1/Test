package Test;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
//@Builder
//@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    String name;
    String id;
    ClassRoom classRooms;
    List<Teacher> teachers;
    List<Teacher> teachingAssistant;
}
