package com.csce4623.carline.models;

  import org.springframework.data.annotation.Id;
  import org.springframework.data.mongodb.core.mapping.Document;

/*
This is the same as a student model with an added field for position which
will allow the client to order the list based on the student's position in
the car line.  It also allows the data to be added to a separate collection
from the collection containing data on all students
*/

@Document(collection = "Students-line")
public class LineStudent {
    @Id
    private String _id;
    public LineStudent set_id(String _id) {
        this._id = _id;
        return this;
    }
    public String get_id() {
        return this._id;
    }

    private String name;
    public LineStudent setName(String name) {
        this.name = name;
        return this;
    }
    public String getName() {
        return this.name;
    }

    private int grade;
    public LineStudent setGrade(int grade) {
        this.grade = grade;
        return this;
    }
    public int getGrade() {
        return this.grade;
    }

    private int room;
    public LineStudent setRoom(int room) {
        this.room = room;
        return this;
    }
    public int getRoom() {
        return this.room;
    }

    private String[] cars;
    public LineStudent setCars(String[] cars) {
        this.cars = cars;
        return this;
    }
    public String[] getCars() {
        return this.cars;
    }

    private int position;
    public LineStudent setPosition(int pos) {
        this.position = pos;
        return this;
    }


    public LineStudent() {}
    public LineStudent(int pos, String name, int grade, int room, String[] cars) {
        this.position = pos;
        this.name = name;
        this.grade = grade;
        this.room = room;
        this.cars = cars;
    }

    public LineStudent(Student student) {
        this._id = student.get_id();
        this.position = 0;
        this.name = student.getName();
        this.room = student.getRoom();
        this.cars = student.getCars();
    }
}
