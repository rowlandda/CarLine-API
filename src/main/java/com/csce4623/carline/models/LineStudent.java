package com.csce4623.carline.models;

  import org.springframework.data.annotation.Id;
  import org.springframework.data.annotation.PersistenceConstructor;
  import org.springframework.data.mongodb.core.mapping.Document;

/*
This is the same as a student model with an added field for position which
will allow the client to order the list based on the student's position in
the car line.  It also allows the data to be added to a separate collection
from the collection containing data on all students
*/

@Document(collection = "Students-line")
public class LineStudent extends StudentAbstract{
    private int position;
    public LineStudent setPosition(int position) {
        this.position = position;
        return this;
    }
    public int getPosition() {
        return this.position;
    }

    @PersistenceConstructor
    public LineStudent(int position, String name, int grade, int room, String[] cars) {
        super(name, grade, room, cars);
        this.position = position;
    }

    public LineStudent(Student student) {
        this._id = student.get_id();
        this.position = 0;
        this.grade = student.getGrade();
        this.name = student.getName();
        this.room = student.getRoom();
        this.cars = student.getCars();
    }
}
