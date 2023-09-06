package ru.gloria_jeans.ui.server.jetpackcompose.control;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.ElementType;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.IntrinsicSize;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Composable {
    private UUID id = UUID.randomUUID();
    private ElementType elementType;
    private Action action;
    private List<Modifier> modifiers = new ArrayList<>();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ElementType getElementType() {
        return elementType;
    }

    public void setElementType(ElementType elementType) {
        this.elementType = elementType;
    }

    public Action getClickAction() {
        return action;
    }

    public void setClickAction(Action action) {
        this.action = action;
    }

    public List<Modifier> getModifiers() {
        return modifiers;
    }

    public void setModifiers(List<Modifier> modifiers) {
        this.modifiers = modifiers;
    }

    public Composable weight(float value) {
        Modifier modifier = new Modifier();
        modifier.setWeight(value);
        modifiers.add(modifier);
        return this;
    }

    public Composable width(int dp) {
        Modifier modifier = new Modifier();
        modifier.setWidth(dp);
        modifiers.add(modifier);
        return this;
    }

    public Composable heigth(int dp) {
        Modifier modifier = new Modifier();
        modifier.setHeight(dp);
        modifiers.add(modifier);
        return this;
    }

    public Composable fillMaxSize() {
        Modifier modifier = new Modifier();
        modifier.setFillMaxSize(true);
        modifiers.add(modifier);
        return this;
    }

    public Composable fillMaxWidth() {
        Modifier modifier = new Modifier();
        modifier.setFillMaxWidth(true);
        modifiers.add(modifier);
        return this;
    }

    public Composable fillMaxHeigth() {
        Modifier modifier = new Modifier();
        modifier.setFillMaxHeight(true);
        modifiers.add(modifier);
        return this;
    }

    public Composable padding(int dp) {
        Modifier modifier = new Modifier();
        modifier.setPadding(dp);
        modifiers.add(modifier);
        return this;
    }

    public Composable paddingVertical(int dp) {
        Modifier modifier = new Modifier();
        modifier.setPaddingVertical(dp);
        modifiers.add(modifier);
        return this;
    }

    public Composable paddingHorizontal(int dp) {
        Modifier modifier = new Modifier();
        modifier.setPaddingHorizontal(dp);
        modifiers.add(modifier);
        return this;
    }

    public Composable intrinsicSizeHeight(IntrinsicSize intrinsicSize) {
        Modifier modifier = new Modifier();
        modifier.setIntrinsicSizeHeight(intrinsicSize);
        modifiers.add(modifier);
        return this;
    }

    public Composable intrinsicSizeWidth(IntrinsicSize intrinsicSize) {
        Modifier modifier = new Modifier();
        modifier.setIntrinsicSizeHeight(intrinsicSize);
        modifiers.add(modifier);
        return this;
    }

    public Composable background(Color color) {
        background(new Background(color));
        return this;
    }

    public Composable background(Color color, Shape shape) {
        background(new Background(color, shape));
        return this;
    }

    public Composable background(int red, int green, int blue, int alpha) {
        background(new Background(red, green, blue, alpha));
        return this;
    }

    public Composable background(Background background) {
        Modifier modifier = new Modifier();
        modifier.setBackground(background);
        modifiers.add(modifier);
        return this;
    }

    public Composable border(int width, Color color) {
        border(new Border(width, color));
        return this;
    }
    public Composable border(Border border) {
        Modifier modifier = new Modifier();
        modifier.setBorder(border);
        modifiers.add(modifier);
        return this;
    }

    public Composable hide() {
        modifiers.removeIf(x -> Objects.nonNull(x.getAlpha()));
        Modifier modifier = new Modifier();
        modifier.setAlpha(0f);
        modifiers.add(modifier);
        return this;
    }

    public Composable show() {
        modifiers.removeIf(x -> Objects.nonNull(x.getAlpha()));
        Modifier modifier = new Modifier();
        modifier.setAlpha(1f);
        modifiers.add(modifier);
        return this;
    }

    public Composable clip(Shape shape) {
        Modifier modifier = new Modifier();
        modifier.setClip(shape);
        modifiers.add(modifier);
        return this;
    }

    public Composable size(Integer size) {
        Modifier modifier = new Modifier();
        modifier.setSize(size);
        modifiers.add(modifier);
        return this;
    }

    public Composable offset(Offset offset) {
        Modifier modifier = new Modifier();
        modifier.setOffset(offset);
        modifiers.add(modifier);
        return this;
    }

    public Composable shadow(Shadow shadow) {
        Modifier modifier = new Modifier();
        modifier.setShadow(shadow);
        modifiers.add(modifier);
        return this;
    }
}
