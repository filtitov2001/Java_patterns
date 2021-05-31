package Lab8.command;

// An interface for command


// Light class and its corresponding command
// classes


// Driver class
class Main {
    public static void main(String[] args) {
        SimpleRemoteControl remote =
                new SimpleRemoteControl();
        Light light = new Light();
        Stereo stereo = new Stereo();

        // we can change command dynamically
        remote.setCommand(new LightOnCommand(light));
        remote.buttonWasPressed();
        remote.setCommand(new StereoOnWithCDCommand(stereo));
        remote.buttonWasPressed();
        remote.setCommand(new StereoOffCommand(stereo));
        remote.buttonWasPressed();
        remote.setCommand(new LightOffCommand(light));
        remote.buttonWasPressed();
    }
}
