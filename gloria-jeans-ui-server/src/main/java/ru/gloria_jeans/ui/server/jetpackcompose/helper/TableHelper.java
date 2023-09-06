package ru.gloria_jeans.ui.server.jetpackcompose.helper;

import com.google.common.base.Strings;
import ru.gloria_jeans.ui.server.jetpackcompose.control.*;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.Direction;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Color;
import ru.gloria_jeans.ui.server.model.table.Cell;
import ru.gloria_jeans.ui.server.model.table.Row;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TableHelper {
    private Container headerContainer;
    private List<Composable> bodyContainers;

    public TableHelper() {
        headerContainer = new Container();
        headerContainer.setHasScroll(false);
        headerContainer.setDirection(Direction.HORIZONTAL);
        bodyContainers = new ArrayList<>();
    }

    public void setHeader(Row row) {
        for (Cell cell : row.getCells()) {
            Text textControl = new Text();
            BindingProperty bindingProperty = new BindingProperty();
            bindingProperty.setSelfContained(true);
            bindingProperty.setValue(cell.getText());
            textControl.setContent(bindingProperty);
            textControl
                    .border(1, cell.getBorder())
                    .background(cell.getBackgroundColor())
                    .width(cell.getWidth())
                    .heigth(cell.getHeight());
            headerContainer.getItems().add(textControl);
        }
    }

    public void setBody(List<Row> rows) {
        setBody(null, null, rows);
    }

    public void setBody(String baseActionUrl, Integer index, List<Row> rows) {
        for (int i = 0; i < rows.size(); i++) {
            Container bodyContainer = new Container();
            bodyContainer.setHasScroll(false);
            bodyContainer.setDirection(Direction.HORIZONTAL);

            for (int j = 0; j < rows.get(i).getCells().size(); j++) {
                    Text textControl = new Text();
                    BindingProperty bindingProperty = new BindingProperty();
                    bindingProperty.setSelfContained(true);
                    bindingProperty.setValue(rows.get(i).getCells().get(j).getText());
                    textControl.setContent(bindingProperty);

                    if (Objects.nonNull(rows.get(i).getCells().get(j).getBorder())) {
                        textControl.border(1, rows.get(i).getCells().get(j).getBorder());
                    }

                    if (Objects.nonNull(rows.get(i).getCells().get(j).getBackgroundColor())) {
                        textControl.background(rows.get(i).getCells().get(j).getBackgroundColor());
                    }

                    if (Objects.nonNull(rows.get(i).getCells().get(j).getWidth())) {
                        textControl.width(rows.get(i).getCells().get(j).getWidth());
                    }

                    if (Objects.nonNull(rows.get(i).getCells().get(j).getHeight())) {
                        textControl.heigth(rows.get(i).getCells().get(j).getHeight());
                    }

                    bodyContainer.getItems().add(textControl);
                }

            if (Objects.isNull(rows.get(i).getRowBackgroundColor())) {
                if (i % 2 == 0) {
                    bodyContainer.background(new Color(255, 255, 255, 255));
                } else {
                    bodyContainer.background(new Color(240, 240, 240, 255));
                }
            }

            if (!Strings.isNullOrEmpty(baseActionUrl) && Objects.nonNull(index)) {
                Action action = new Action();
                action.setActionUri(
                        String.format(
                                "%s?args=%s",
                                baseActionUrl,
                                rows.get(i).getCells().get(index).getText()
                        )
                );
                bodyContainer.setClickAction(action);
            }

            bodyContainers.add(bodyContainer);
        }
    }

    public Composable getTable() {
        Container container = new Container();
        container.getItems().add(headerContainer);
        container.getItems().addAll(bodyContainers);
        container.setHasScroll(false);
        return container;
    }
}
