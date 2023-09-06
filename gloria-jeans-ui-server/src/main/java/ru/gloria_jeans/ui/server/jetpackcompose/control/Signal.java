package ru.gloria_jeans.ui.server.jetpackcompose.control;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.SignalType;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Signal {
    public SignalType signalType;
    public int duration;
    public int repeatCount;

    public Signal() {}

    public Signal(SignalType type, int duration) {
        this.signalType = type;
        this.duration = duration;
    }

    public Signal(SignalType type, int duration, int repeatCount) {
        this.signalType = type;
        this.duration = duration;
        this.repeatCount = repeatCount;
    }

    public SignalType getSignalType() {
        return signalType;
    }

    public void setSignalType(SignalType signalType) {
        this.signalType = signalType;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getRepeatCount() {
        return repeatCount;
    }

    public void setRepeatCount(int repeatCount) {
        this.repeatCount = repeatCount;
    }

    public static Signal success() {
        return new Signal(SignalType.Success, 200);
    }

    public static Signal error() {
        return new Signal(SignalType.Error, 400);
    }

    public static Signal warning() {
        return new Signal(SignalType.Warning, 400);
    }
}
