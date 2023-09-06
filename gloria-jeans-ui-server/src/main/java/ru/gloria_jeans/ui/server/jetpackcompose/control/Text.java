package ru.gloria_jeans.ui.server.jetpackcompose.control;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.ElementType;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.FontStyle;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.FontWeight;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.TextAlign;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Color;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Text extends Composable{
    private ElementType elementType = ElementType.Text;
    private TextAlign textAlign = TextAlign.Center;
    private int fontSize = 12;
    private FontStyle fontStyle = FontStyle.Normal;
    private FontWeight fontWeight = FontWeight.Normal;
    private BindingProperty content;
    private Color color;

    @Override
    public ElementType getElementType() {
        return elementType;
    }

    @Override
    public void setElementType(ElementType elementType) {
        this.elementType = elementType;
    }

    public TextAlign getTextAlign() {
        return textAlign;
    }

    public void setTextAlign(TextAlign textAlign) {
        this.textAlign = textAlign;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public FontStyle getFontStyle() {
        return fontStyle;
    }

    public void setFontStyle(FontStyle fontStyle) {
        this.fontStyle = fontStyle;
    }

    public FontWeight getFontWeight() {
        return fontWeight;
    }

    public void setFontWeight(FontWeight fontWeight) {
        this.fontWeight = fontWeight;
    }

    public BindingProperty getContent() {
        return content;
    }

    public void setContent(BindingProperty content) {
        this.content = content;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
