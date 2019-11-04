package com.csce4623.carline.models;

  import org.springframework.data.annotation.Id;
  import org.springframework.data.mongodb.core.mapping.Document;

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

    public LineStudent() {}
    public LineStudent(String name, int grade, int room, String[] cars) {
        this.name = name;
        this.grade = grade;
        this.room = room;
        this.cars = cars;
    }

    public LineStudent(Student student) {
        this._id = student.get_id();
        this.name = student.getName();
        this.room = student.getRoom();
        this.cars = student.getCars();
    }
}
