package ru.gloria_jeans.ui.server.jetpackcompose.control;


import com.fasterxml.jackson.annotation.JsonInclude;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.ElementType;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Spinner extends Composable{

    private Composable content;

    public Spinner() {
        super();
        setElementType(ElementType.Spinner);
    }

    public Composable getContent() {
        return content;
    }

    public void setContent(Composable content) {
        this.content = content;
    }
}
