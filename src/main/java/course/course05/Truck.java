package course.course05;

public class Truck implements Car,Engine{
    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void engineOn() {
        System.out.println("Start engine with maxcapacity"+ Engine.MAX_CAPACITY);
    }

    @Override
    public void engineOff() {

    }
}
