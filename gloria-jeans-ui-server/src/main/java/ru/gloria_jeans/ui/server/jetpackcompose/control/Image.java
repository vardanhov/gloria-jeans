package ru.gloria_jeans.ui.server.jetpackcompose.control;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.ElementType;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Image extends Composable {
    private String image;
    private BindingProperty url;
    private ElementType elementType = ElementType.Image;

    public BindingProperty getUrl() {
        return url;
    }

    public void setUrl(BindingProperty url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public ElementType getElementType() {
        return elementType;
    }

    @Override
    public void setElementType(ElementType elementType) {
        this.elementType = elementType;
    }
}
