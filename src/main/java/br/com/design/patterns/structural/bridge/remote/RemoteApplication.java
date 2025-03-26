package br.com.design.patterns.structural.bridge.remote;

public class RemoteApplication {
    public static void main(String[] args) {
        Device tv = new Television();
        RemoteControl remote = new BasicRemote(tv);
        remote.togglePower();
        remote.volumeUp();
        remote.changeChannel(5);

        System.out.println("\nSwitching device...\n");

        Device radio = new Radio();
        remote = new BasicRemote(radio);
        remote.togglePower();
        remote.volumeDown();
        remote.changeChannel(3);
    }
}

interface Device {
    boolean isEnabled();
    void enable();
    void disable();
    int getVolume();
    void setVolume(int percent);
    void setChannel(int channel);
    int getChannel();
}

class Television implements Device {
    private boolean on = false;
    private int volume = 30;
    private int channel = 1;
    @Override
    public boolean isEnabled() {
        return on;
    }

    @Override
    public void enable() {
        on = true;
        System.out.println("Television is turned ON.");
    }

    @Override
    public void disable() {
        on = false;
        System.out.println("Television is turned OFF.");
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int percent) {
        volume = percent;
        System.out.println("Television volume set to " + percent + "%.");
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
        System.out.println("Television channel set to " + channel + ".");
    }

    @Override
    public int getChannel() {
        return channel;
    }
}

class Radio implements Device {
    private boolean on = false;
    private int volume = 20;
    private int channel = 1;

    @Override
    public boolean isEnabled() {
        return on;
    }

    @Override
    public void enable() {
        on = true;
        System.out.println("Radio is turned ON.");
    }

    @Override
    public void disable() {
        on = false;
        System.out.println("Radio is turned OFF.");
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int percent) {
        volume = percent;
        System.out.println("Radio volume set to " + percent + "%.");
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
        System.out.println("Radio channel set to " + channel + ".");
    }

    @Override
    public int getChannel() {
        return channel;
    }
}

abstract class RemoteControl {
    protected Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    public void togglePower() {
        if(device.isEnabled()) {
            device.disable();
        } else {
            device.enable();
        }
    }

    public void volumeUp() {
        device.setVolume(device.getVolume() + 10);
    }

    public void volumeDown() {
        device.setVolume(device.getVolume() - 10);
    }

    public abstract void changeChannel(int channel);
}

class BasicRemote extends RemoteControl {

    public BasicRemote(Device device) {
        super(device);
    }

    @Override
    public void changeChannel(int channel) {
        device.setChannel(channel);
    }
}
