package ru.gloria_jeans.ui.server.jetpackcompose.datacontext.export;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.gloria_jeans.ui.server.jetpackcompose.control.DataContext;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExportDataContext extends DataContext {
    private String movementDecree;
    private String movement;
    private String movementRequests;

    public String getMovementDecree() {
        return movementDecree;
    }

    public void setMovementDecree(String movementDecree) {
        this.movementDecree = movementDecree;
    }

    public String getMovement() {
        return movement;
    }

    public void setMovement(String movement) {
        this.movement = movement;
    }

    public String getMovementRequests() {
        return movementRequests;
    }

    public void setMovementRequests(String movementRequests) {
        this.movementRequests = movementRequests;
    }
}
