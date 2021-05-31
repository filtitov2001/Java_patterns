package Lab6.Builder;

// Client Side Code
class StudentReceiver {

    // volatile student instance to ensure visibility
    // of shared reference to immutable objects
    private volatile Student student;

    public StudentReceiver() {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                student = Student.Builder.newInstance()
                        .setId(1)
                        .setName("Ram")
                        .setAddress("Noida").build();
            }
        });



        t1.start();
       // t2.start();
    }

    public Student getStudent() {
        return student;
    }
}
