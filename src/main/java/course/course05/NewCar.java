package course.course05;

abstract public class NewCar implements Engine{
    public void start() {
        System.out.println("Car start engine");
    }
    abstract public void stop(String time);
}
