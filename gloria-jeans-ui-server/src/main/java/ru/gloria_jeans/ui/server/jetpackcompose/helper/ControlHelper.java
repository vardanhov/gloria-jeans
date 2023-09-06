package ru.gloria_jeans.ui.server.jetpackcompose.helper;

import com.google.common.base.Strings;
import ru.gloria_jeans.ui.server.jetpackcompose.control.*;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.*;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.*;
import ru.gloria_jeans.ui.server.utils.UrlHelper;

import java.math.BigDecimal;
import java.util.List;

public class ControlHelper {
    public static Composable getCircleLabel(
            String textInCircle,
            String textOutCircle,
            Color backgroundColor
    ) {
        Color colorBefore = new Color(
                Math.max(backgroundColor.getRed() - 10, 0),
                Math.max(backgroundColor.getGreen() - 10, 0),
                Math.max(backgroundColor.getBlue() - 10, 0),
                255
        );
        Color colorAfter = new Color(
                Math.min(backgroundColor.getRed() + 10, 255),
                Math.min(backgroundColor.getGreen() + 10, 255),
                Math.min(backgroundColor.getBlue() + 10, 255),
                255
        );

        Container container = new Container();
        container.setHasScroll(false);
        Text inCircle = new Text();
        inCircle.setFontSize(14);
        inCircle.setFontWeight(FontWeight.W400);
        inCircle.setColor(new Color(255, 255, 255, 255));
        inCircle
                .size(42)
                .background(
                        new Background(
                                new Gradient(
                                        List.of(colorBefore, backgroundColor, colorAfter),
                                        0f,
                                        45f,
                                        GradientDirection.Vertical,
                                        TileMode.Clamp
                                ),
                                new Shape(ClipShape.CircleShape)
                        )
                ).paddingVertical(12);
        BindingProperty bindingProperty = new BindingProperty();
        bindingProperty.setValue(textInCircle);
        inCircle.setContent(bindingProperty);
        container.getItems().add(inCircle);

        Text outCircle = new Text();
        outCircle.setFontWeight(FontWeight.W400);
        outCircle.setFontSize(12);
        outCircle.setColor(new Color(0, 0, 0, 100));
        outCircle.paddingVertical(4)
                .paddingHorizontal(7);
        bindingProperty = new BindingProperty();
        bindingProperty.setValue(textOutCircle);
        outCircle.setContent(bindingProperty);
        container.getItems().add(outCircle);
        return container;
    }

    public static Composable getBlockItem(
            String title,
            int quantity,
            int quantityFact
    ) {
        return getBlockItem(title, quantity, quantityFact, null);
    }

    public static Composable getBlockItem(
            String title,
            int quantity,
            int quantityFact,
            String id

    ) {
        Container container = new Container();

        if (!Strings.isNullOrEmpty(id)) {
            Action action = new Action();
            action.setActionUri(String.format(
                    "%s/%s?args=%s",
                    UrlHelper.getUrlToCurrentResource(),
                    WarehouseScreen.SUPPLY_RECALCULATION_BOX.getWarehouseScreen(),
                    id
            ));
            container.setClickAction(action);
        }

        container.setHasScroll(false);
        container.setDirection(Direction.HORIZONTAL);
        container
                .fillMaxWidth()
                .padding(7)
                .background(
                        new Color(245, 244, 244, 255),
                        new Shape(ClipShape.RoundedCornerShape, 8)
                );

        Container titleContainer = new Container();
        titleContainer.setHasScroll(false);
        titleContainer.setDirection(Direction.VERTICAL);
        titleContainer
                .width(280);

        Text titleText = new Text();
        titleText.setFontWeight(FontWeight.Bold);
        titleText.setColor(new Color(0, 0, 0, 255));
        BindingProperty bindingProperty = new BindingProperty();
        bindingProperty.setValue(title);
        bindingProperty.setSelfContained(true);
        titleText.setContent(bindingProperty);
        titleContainer.getItems().add(titleText);

        Container quantityContainer = new Container();
        quantityContainer.setDirection(Direction.HORIZONTAL);

        Text quantityText = new Text();
        quantityText.setFontWeight(FontWeight.Bold);
        quantityText.setColor(new Color(0, 60, 255, 255));
        bindingProperty = new BindingProperty();
        bindingProperty.setValue(String.format("Plan: %s", quantity));
        bindingProperty.setSelfContained(true);
        quantityText.setContent(bindingProperty);
        quantityText
                .padding(2)
                .background(
                        new Color(204, 216, 253, 255),
                        new Shape(ClipShape.CircleShape)
                );
        quantityContainer.getItems().add(quantityText);

        Text quantityFactText = new Text();
        quantityFactText.setFontWeight(FontWeight.Bold);
        quantityFactText.setColor(new Color(0, 60, 255, 255));
        bindingProperty = new BindingProperty();
        bindingProperty.setValue(String.format("Fact: %s", quantityFact));
        bindingProperty.setSelfContained(true);
        quantityFactText.setContent(bindingProperty);
        quantityFactText
                .padding(2)
                .background(
                        new Color(204, 216, 253, 255),
                        new Shape(ClipShape.CircleShape)
                );
        quantityContainer.getItems().add(quantityFactText);
        titleContainer.getItems().add(quantityContainer);


        Container diffContainer = new Container();
        diffContainer.setHasScroll(false);
        diffContainer.setDirection(Direction.VERTICAL);
        diffContainer
                .width(70);

        String strDiff = null;
        Color colorDiff = null;
        Background backgroundDiff = null;
        int diff = quantity - quantityFact;

        if (diff == 0) {
            strDiff = "✓";
            colorDiff = new Color(24, 186, 146, 255);
            backgroundDiff = new Background(new Color(255, 255, 255, 255), new Shape(ClipShape.CircleShape));
        } else if (diff > 0) {
            strDiff = String.format("-%s", diff);
            colorDiff = new Color(250, 0, 130, 255);
            backgroundDiff = new Background(new Color(250, 180, 236, 255), new Shape(ClipShape.CircleShape));
        } else {
            strDiff = String.format("+%s", Math.negateExact(diff));
            colorDiff = new Color(250, 0, 130, 255);
            backgroundDiff = new Background(new Color(250, 180, 236, 255), new Shape(ClipShape.CircleShape));
        }

        Text diffText = new Text();
        diffText.setFontWeight(FontWeight.Bold);
        diffText.setFontSize(16);
        diffText.setColor(colorDiff);
        diffText
                .padding(2)
                .background(backgroundDiff)
                .fillMaxSize();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue(strDiff);
        bindingProperty.setSelfContained(true);
        diffText.setContent(bindingProperty);
        diffContainer.getItems().add(diffText);
        container.getItems().add(titleContainer);
        container.getItems().add(diffContainer);

        DropdownMenu dropdownMenu = new DropdownMenu();
        Modifier modifier = new Modifier();
        modifier.setWidth(235);
        dropdownMenu.getDropdownMenuItems().add(
                new DropdownMenuItem(
                        new BindingProperty("changeQuantityButtonText", false),
                        new Action(String.format(
                                "%s/%s?args=%s",
                                UrlHelper.getUrlToCurrentResource(),
                                WarehouseScreen.SUPPLY_CHANGE_QUANTITY.getWarehouseScreen(),
                                id
                        ))
                )
        );
        dropdownMenu.getModifiers().add(
                modifier
        );
        dropdownMenu.getDropdownMenuItems().add(
                new DropdownMenuItem(
                        new BindingProperty("clearPositionFactButtonText", false),
                        new Action(String.format(
                                "%s/%s?args=%s",
                                UrlHelper.getUrlToCurrentResource(),
                                WarehouseScreen.SUPPLY_CLEAR_FACT_POSITION.getWarehouseScreen(),
                                id
                        ))
                )
        );
        dropdownMenu.getDropdownMenuItems().add(
                new DropdownMenuItem(
                        new BindingProperty("deletePositionButtonText", false),
                        new Action(String.format(
                                "%s/%s?args=%s",
                                UrlHelper.getUrlToCurrentResource(),
                                WarehouseScreen.SUPPLY_DELETE_POSITION.getWarehouseScreen(),
                                id
                        ))
                )
        );
        dropdownMenu.getDropdownMenuItems().add(
                new DropdownMenuItem(
                        new BindingProperty("viewPositionImageButtonText", false),
                        new Action(String.format(
                                "%s/%s",
                                UrlHelper.getUrlToCurrentResource(),
                                WarehouseScreen.SUPPLY_GOOD_IMAGE.getWarehouseScreen()
                        ))


                )
        );
        IconButton iconButton = new IconButton();
        iconButton.setIcon(Icon.Burger);
        iconButton.setDropdownMenu(dropdownMenu);

        container.getItems().add(iconButton);
        return container;
    }

    public static Composable getBlockItem(
            String title,
            int quantity,
            int quantityFact,
            int quantityDiff,
            int quantityDiffProductsIntoLot,
            boolean isLot,
            boolean isMark,
            boolean isScannedMark,
            BigDecimal price,
            String id,
            String barcode,
            Integer lineNumber
    ) {
        Container container = new Container();

        container.setHasScroll(false);
        container.setDirection(Direction.VERTICAL);
        container
                .fillMaxWidth()
                .paddingHorizontal(16)
                .heigth(88);

        Spacer spacer = new Spacer();
        spacer.paddingVertical(7);
        container.getItems().add(spacer);

        Container productContainer = new Container();
        productContainer.setHasScroll(false);
        productContainer.setDirection(Direction.VERTICAL);

        Container titleContainer = new Container();
        titleContainer.setHasScroll(false);
        titleContainer.setDirection(Direction.HORIZONTAL);
        titleContainer
                .width(360);

        String strDiff = null;
        Color colorText = null;
        Color colorCount = null;

        int diff = quantity - quantityFact;

        if (quantity > 0 && diff == 0) {
            strDiff = BaseStringImages.BOX_SCREEN_GREEN_CHECK_MARK;
            colorText = new Color(158, 158, 158, 255);
            colorCount = new Color(0, 0, 0, 255);
        } else {
            strDiff = BaseStringImages.BOX_SCREEN_RED_CHECK_MARK;
            colorText = new Color(239, 62, 66, 255);
            colorCount = colorText;
        }

        Image imageIcon = new Image();
        imageIcon.setImage(strDiff);
        imageIcon.paddingHorizontal(2)
                .paddingVertical(2);
        imageIcon.size(14);

        BindingProperty bindingProperty = new BindingProperty();
        bindingProperty.setValue(strDiff);
        bindingProperty.setSelfContained(true);
        titleContainer.getItems().add(imageIcon);

        Text titleText = new Text();
        titleText.setFontWeight(FontWeight.W500);
        titleText.setColor(new Color(0, 0, 0, 255));
        bindingProperty = new BindingProperty();
        bindingProperty.setValue(title);
        bindingProperty.setSelfContained(true);
        titleText.setContent(bindingProperty);
        titleText.setTextAlign(TextAlign.Left);
        titleText.paddingHorizontal(8);
        titleText.width(260);
        titleContainer.getItems().add(titleText);

        spacer = new Spacer();
        spacer.paddingHorizontal(10);
        titleContainer.getItems().add(spacer);

        IconButton menuButton = new IconButton();
        menuButton.setIcon(Icon.Column);
        menuButton.size(15);

        DropdownMenu dropdownMenu = new DropdownMenu();
        Modifier modifier = new Modifier();
        modifier.setWidth(250);
        dropdownMenu.getModifiers()
                .add(modifier);
        dropdownMenu.getDropdownMenuItems()
                .add(
                        new DropdownMenuItem(
                                new BindingProperty(
                                        "changeQuantityButtonText",
                                        false
                                ),
                                new Action(
                                        String.format(
                                                "%s/%s?args=%s",
                                                UrlHelper.getUrlToCurrentResource(),
                                                WarehouseScreen.SUPPLY_CHANGE_QUANTITY.getWarehouseScreen(),
                                                id
                                        )
                                )
                        )
                );
        dropdownMenu.getDropdownMenuItems()
                .add(
                        new DropdownMenuItem(
                                new BindingProperty(
                                        "clearPositionFactButtonText",
                                        false
                                ),
                                new Action(
                                        String.format(
                                                "%s/%s?args=%s",
                                                UrlHelper.getUrlToCurrentResource(),
                                                WarehouseScreen.SUPPLY_CLEAR_FACT_POSITION.getWarehouseScreen(),
                                                id
                                        )
                                )
                        )
                );
        dropdownMenu.getDropdownMenuItems()
                .add(
                        new DropdownMenuItem(
                                new BindingProperty(
                                        "removePositionButtonText",
                                        false
                                ),
                                new Action(
                                        String.format(
                                                "%s/%s?args=%s",
                                                UrlHelper.getUrlToCurrentResource(),
                                                WarehouseScreen.SUPPLY_DELETE_POSITION.getWarehouseScreen(),
                                                id
                                        )
                                ),
                                quantity != 0  ? Boolean.FALSE : Boolean.TRUE
                        )
                );
        dropdownMenu.getDropdownMenuItems()
                .add(
                        new DropdownMenuItem(
                                new BindingProperty(
                                        "viewPositionImageButtonText",
                                        false
                                ),
                                new Action(
                                        String.format(
                                                "%s/%s?args=%s",
                                                UrlHelper.getUrlToCurrentResource(),
                                                WarehouseScreen.SUPPLY_GOOD_IMAGE.getWarehouseScreen(),
                                                id
                                        )
                                )
                        )
                );
        dropdownMenu.getDropdownMenuItems()
                .add(
                        new DropdownMenuItem(
                                new BindingProperty(
                                        "addMarkButton",
                                        false
                                ),
                                new Action(
                                        String.format(
                                                "%s/%s?args=%s",
                                                UrlHelper.getUrlToCurrentResource(),
                                                WarehouseScreen.SUPPLY_RECALCULATION_BOX.getWarehouseScreen(),
                                                id
                                        )
                                ),
                                Boolean.FALSE
                        )
                );
        menuButton.setDropdownMenu(dropdownMenu);

        titleContainer.getItems().add(menuButton);

        Container positionContainer = new Container();
        positionContainer.setDirection(Direction.HORIZONTAL);

        spacer = new Spacer();
        spacer.width(24);

        positionContainer.getItems().add(spacer);

        Container quantityContainer = new Container();
        quantityContainer.setDirection(Direction.HORIZONTAL);
        quantityContainer.paddingHorizontal(0)
                .paddingVertical(4)
                .background(
                        new Color(242, 242, 242, 255),
                        new Shape(ClipShape.RoundedCornerShape, 4)
                );
        quantityContainer.heigth(22);

        spacer = new Spacer();
        spacer.paddingHorizontal(4);

        quantityContainer.getItems().add(spacer);

        Text quantityText = new Text();
        quantityText.setFontWeight(FontWeight.W500);
        quantityText.setFontSize(10);
        quantityText.setColor(new Color(158, 158, 158, 255));
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("ПЛАН:");
        bindingProperty.setSelfContained(true);
        quantityText.setContent(bindingProperty);
        quantityText
                .paddingVertical(4)
                .background(
                        new Color(242, 242, 242, 255),
                        new Shape(ClipShape.RoundedCornerShape, 4)
                );
        quantityText.heigth(20);
        quantityContainer.getItems().add(quantityText);

        quantityText = new Text();
        quantityText.setFontWeight(FontWeight.W500);
        quantityText.setFontSize(10);
        quantityText.setColor(new Color(0, 0, 0, 255));
        bindingProperty = new BindingProperty();
        bindingProperty.setValue(" " + quantity);
        bindingProperty.setSelfContained(true);
        quantityText.setContent(bindingProperty);
        quantityText
                .paddingVertical(4)
                .background(
                        new Color(242, 242, 242, 255),
                        new Shape(ClipShape.RoundedCornerShape, 4)
                );
        quantityText.heigth(20);
        quantityContainer.getItems().add(quantityText);

        spacer = new Spacer();
        spacer.paddingHorizontal(4);

        quantityContainer.getItems().add(spacer);

        Text quantityFactText = new Text();
        quantityFactText.setFontWeight(FontWeight.W500);
        quantityFactText.setFontSize(10);
        quantityFactText.setColor(new Color(158, 158, 158, 255));
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("ФАКТ:");
        bindingProperty.setSelfContained(true);
        quantityFactText.setContent(bindingProperty);
        quantityFactText
                .paddingVertical(4)
                .background(
                        new Color(242, 242, 242, 255),
                        new Shape(ClipShape.RoundedCornerShape, 4)
                );
        quantityFactText.heigth(20);

        quantityContainer.getItems().add(quantityFactText);

        quantityFactText = new Text();
        quantityFactText.setFontWeight(FontWeight.W500);
        quantityFactText.setFontSize(10);
        quantityFactText.setColor(new Color(0, 0, 0, 255));
        bindingProperty = new BindingProperty();
        bindingProperty.setValue(" " + quantityFact);
        bindingProperty.setSelfContained(true);
        quantityFactText.setContent(bindingProperty);
        quantityFactText
                .paddingVertical(4)
                .background(
                        new Color(242, 242, 242, 255),
                        new Shape(ClipShape.RoundedCornerShape, 4)
                );
        quantityFactText.heigth(20);

        quantityContainer.getItems().add(quantityFactText);

        quantityContainer.getItems().add(spacer);

        Text quantityDiffText = new Text();
        quantityDiffText.setFontWeight(FontWeight.W500);
        quantityDiffText.setFontSize(10);
        quantityDiffText.setColor(colorText);
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("РАСХ:");
        bindingProperty.setSelfContained(true);
        quantityDiffText.setContent(bindingProperty);
        quantityDiffText
                .paddingVertical(4)
                .background(
                        new Color(242, 242, 242, 255),
                        new Shape(ClipShape.RoundedCornerShape, 4)
                );
        quantityDiffText.heigth(20);
        quantityContainer.getItems().add(quantityDiffText);

        quantityDiffText = new Text();
        quantityDiffText.setFontWeight(FontWeight.W500);
        quantityDiffText.setFontSize(10);
        quantityDiffText.setColor(colorCount);
        bindingProperty = new BindingProperty();
        bindingProperty.setValue(" " + plusMinusSetter(quantityDiff));
        bindingProperty.setSelfContained(true);
        quantityDiffText.setContent(bindingProperty);
        quantityDiffText
                .paddingVertical(4)
                .background(
                        new Color(242, 242, 242, 255),
                        new Shape(ClipShape.RoundedCornerShape, 4)
                );
        quantityDiffText.heigth(20);
        quantityContainer.getItems().add(quantityDiffText);

        spacer = new Spacer();
        spacer.paddingHorizontal(4);

        quantityContainer.getItems().add(spacer);

        Container extraLotMark;

        extraLotMark = new Container();
        extraLotMark.setDirection(Direction.HORIZONTAL);
        extraLotMark.paddingHorizontal(4)
                .paddingVertical(4)
                .background(
                        new Color(242, 242, 242, 255),
                        new Shape(ClipShape.RoundedCornerShape, 4)
                );
        extraLotMark.heigth(22);

        spacer = new Spacer();
        spacer.width(5);
        extraLotMark.getItems().add(spacer);


        if (isLot) {
            Image imageIsLot = new Image();
            imageIsLot.setImage(quantityDiffProductsIntoLot == 0 ? BaseStringImages.BOX_SCREEN_GREEN_LOT : BaseStringImages.BOX_SCREEN_RED_LOT);
            imageIsLot.background(
                    new Color(242, 242, 242, 255),
                    new Shape(ClipShape.RoundedCornerShape, 4)
            );
            imageIsLot.heigth(28).width(23);
            imageIsLot.paddingVertical(4);

            extraLotMark.getItems().add(imageIsLot);
        }

        if (isMark) {
            Image imageIsMark = new Image();
            imageIsMark.setImage(isScannedMark ? BaseStringImages.BOX_SCREEN_GREEN_MARK : BaseStringImages.BOX_SCREEN_RED_MARK);
            imageIsMark.background(
                    new Color(242, 242, 242, 255),
                    new Shape(ClipShape.RoundedCornerShape, 4)
            );
            imageIsMark.heigth(28).width(23);
            imageIsMark.paddingVertical(4);

            extraLotMark.getItems().add(imageIsMark);
        }

        if (price != null && price.compareTo(BigDecimal.ZERO) == 0) {
            Image priceNotPresent = new Image();
            priceNotPresent.setImage(BaseStringImages.PRICE_NOT_PRESENT);
            priceNotPresent.background(
                    new Color(242, 242, 242, 255),
                    new Shape(ClipShape.RoundedCornerShape, 4)
            );
            priceNotPresent.heigth(28).width(23);
            priceNotPresent.paddingVertical(4);

            extraLotMark.getItems().add(priceNotPresent);
        }

        extraLotMark.getItems().add(spacer);

        if (!isLot && !isMark) {
            extraLotMark = new Container();
        }

        positionContainer.getItems().add(quantityContainer);
        positionContainer.getItems().add(extraLotMark);

        productContainer.getItems().add(titleContainer);
        productContainer.getItems().add(positionContainer);


        container.getItems().add(productContainer);

        spacer = new Spacer();
        spacer.paddingVertical(6);
        container.getItems().add(spacer);

        Container lineContainer = new Container();
        lineContainer.paddingHorizontal(0)
                .width(500)
                .heigth(1)
                .background(238, 238, 238, 255);
        container.getItems().add(lineContainer);

        if (isLot) {
            container.setClickAction(
                    new Action(
                            String.format(
                                    "%s/%s?args=%s&lineNumber=%s&linkToOpenLot=true",
                                    UrlHelper.getUrlToCurrentResource(),
                                    WarehouseScreen.SUPPLY_RECALCULATION_BOX_UPDATE.getWarehouseScreen(),
                                    barcode,
                                    lineNumber
                            )
                    )
            );
        }

        return container;
    }
    public static Composable getBlockItemForInternetOrder(
            String title,
            int quantity,
            int quantityFact,
            int quantityDiff,
            int quantityDiffProductsIntoLot,
            boolean isLot,
            boolean isMark,
            boolean isScannedMark,
            BigDecimal price,
            String id,
            String barcode,
            Integer lineNumber
    ) {
        Container container = new Container();

        container.setHasScroll(false);
        container.setDirection(Direction.VERTICAL);
        container
                .fillMaxWidth()
                .paddingHorizontal(16)
                .heigth(88);

        Spacer spacer = new Spacer();
        spacer.paddingVertical(7);
        container.getItems().add(spacer);

        Container productContainer = new Container();
        productContainer.setHasScroll(false);
        productContainer.setDirection(Direction.VERTICAL);

        Container titleContainer = new Container();
        titleContainer.setHasScroll(false);
        titleContainer.setDirection(Direction.HORIZONTAL);
        titleContainer
                .width(360);

        String strDiff = null;
        Color colorText = null;
        Color colorCount = null;

        int diff = quantity - quantityFact;

        if (quantity > 0 && diff == 0) {
            strDiff = BaseStringImages.BOX_SCREEN_GREEN_CHECK_MARK;
            colorText = new Color(158, 158, 158, 255);
            colorCount = new Color(0, 0, 0, 255);
        } else {
            strDiff = BaseStringImages.BOX_SCREEN_RED_CHECK_MARK;
            colorText = new Color(239, 62, 66, 255);
            colorCount = colorText;
        }

        Image imageIcon = new Image();
        imageIcon.setImage(strDiff);
        imageIcon.paddingHorizontal(2)
                .paddingVertical(2);
        imageIcon.size(14);

        BindingProperty bindingProperty = new BindingProperty();
        bindingProperty.setValue(strDiff);
        bindingProperty.setSelfContained(true);
        titleContainer.getItems().add(imageIcon);

        Text titleText = new Text();
        titleText.setFontWeight(FontWeight.W500);
        titleText.setColor(new Color(0, 0, 0, 255));
        bindingProperty = new BindingProperty();
        bindingProperty.setValue(title);
        bindingProperty.setSelfContained(true);
        titleText.setContent(bindingProperty);
        titleText.setTextAlign(TextAlign.Left);
        titleText.paddingHorizontal(8);
        titleText.width(260);
        titleContainer.getItems().add(titleText);

        spacer = new Spacer();
        spacer.paddingHorizontal(10);
        titleContainer.getItems().add(spacer);

        Container positionContainer = new Container();
        positionContainer.setDirection(Direction.HORIZONTAL);

        spacer = new Spacer();
        spacer.width(24);

        positionContainer.getItems().add(spacer);

        Container quantityContainer = new Container();
        quantityContainer.setDirection(Direction.HORIZONTAL);
        quantityContainer.paddingHorizontal(0)
                .paddingVertical(4)
                .background(
                        new Color(242, 242, 242, 255),
                        new Shape(ClipShape.RoundedCornerShape, 4)
                );
        quantityContainer.heigth(22);

        spacer = new Spacer();
        spacer.paddingHorizontal(4);

        quantityContainer.getItems().add(spacer);

        Text quantityText = new Text();
        quantityText.setFontWeight(FontWeight.W500);
        quantityText.setFontSize(10);
        quantityText.setColor(new Color(158, 158, 158, 255));
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("ПЛАН:");
        bindingProperty.setSelfContained(true);
        quantityText.setContent(bindingProperty);
        quantityText
                .paddingVertical(4)
                .background(
                        new Color(242, 242, 242, 255),
                        new Shape(ClipShape.RoundedCornerShape, 4)
                );
        quantityText.heigth(20);
        quantityContainer.getItems().add(quantityText);

        quantityText = new Text();
        quantityText.setFontWeight(FontWeight.W500);
        quantityText.setFontSize(10);
        quantityText.setColor(new Color(0, 0, 0, 255));
        bindingProperty = new BindingProperty();
        bindingProperty.setValue(" " + quantity);
        bindingProperty.setSelfContained(true);
        quantityText.setContent(bindingProperty);
        quantityText
                .paddingVertical(4)
                .background(
                        new Color(242, 242, 242, 255),
                        new Shape(ClipShape.RoundedCornerShape, 4)
                );
        quantityText.heigth(20);
        quantityContainer.getItems().add(quantityText);

        spacer = new Spacer();
        spacer.paddingHorizontal(4);

        quantityContainer.getItems().add(spacer);

        Text quantityFactText = new Text();
        quantityFactText.setFontWeight(FontWeight.W500);
        quantityFactText.setFontSize(10);
        quantityFactText.setColor(new Color(158, 158, 158, 255));
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("ФАКТ:");
        bindingProperty.setSelfContained(true);
        quantityFactText.setContent(bindingProperty);
        quantityFactText
                .paddingVertical(4)
                .background(
                        new Color(242, 242, 242, 255),
                        new Shape(ClipShape.RoundedCornerShape, 4)
                );
        quantityFactText.heigth(20);

        quantityContainer.getItems().add(quantityFactText);

        quantityFactText = new Text();
        quantityFactText.setFontWeight(FontWeight.W500);
        quantityFactText.setFontSize(10);
        quantityFactText.setColor(new Color(0, 0, 0, 255));
        bindingProperty = new BindingProperty();
        bindingProperty.setValue(" " + quantityFact);
        bindingProperty.setSelfContained(true);
        quantityFactText.setContent(bindingProperty);
        quantityFactText
                .paddingVertical(4)
                .background(
                        new Color(242, 242, 242, 255),
                        new Shape(ClipShape.RoundedCornerShape, 4)
                );
        quantityFactText.heigth(20);

        quantityContainer.getItems().add(quantityFactText);

        quantityContainer.getItems().add(spacer);

        Text quantityDiffText = new Text();
        quantityDiffText.setFontWeight(FontWeight.W500);
        quantityDiffText.setFontSize(10);
        quantityDiffText.setColor(colorText);
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("РАСХ:");
        bindingProperty.setSelfContained(true);
        quantityDiffText.setContent(bindingProperty);
        quantityDiffText
                .paddingVertical(4)
                .background(
                        new Color(242, 242, 242, 255),
                        new Shape(ClipShape.RoundedCornerShape, 4)
                );
        quantityDiffText.heigth(20);
        quantityContainer.getItems().add(quantityDiffText);

        quantityDiffText = new Text();
        quantityDiffText.setFontWeight(FontWeight.W500);
        quantityDiffText.setFontSize(10);
        quantityDiffText.setColor(colorCount);
        bindingProperty = new BindingProperty();
        bindingProperty.setValue(" " + plusMinusSetter(quantityDiff));
        bindingProperty.setSelfContained(true);
        quantityDiffText.setContent(bindingProperty);
        quantityDiffText
                .paddingVertical(4)
                .background(
                        new Color(242, 242, 242, 255),
                        new Shape(ClipShape.RoundedCornerShape, 4)
                );
        quantityDiffText.heigth(20);
        quantityContainer.getItems().add(quantityDiffText);

        spacer = new Spacer();
        spacer.paddingHorizontal(4);
        quantityContainer.getItems().add(spacer);

        Container extraLotMark;

        extraLotMark = new Container();
        extraLotMark.setDirection(Direction.HORIZONTAL);
        extraLotMark.paddingHorizontal(4)
                .paddingVertical(4)
                .background(
                        new Color(242, 242, 242, 255),
                        new Shape(ClipShape.RoundedCornerShape, 4)
                );
        extraLotMark.heigth(22);

        spacer = new Spacer();
        spacer.width(5);
        extraLotMark.getItems().add(spacer);


        if (isLot) {
            Image imageIsLot = new Image();
            imageIsLot.setImage(quantityDiffProductsIntoLot == 0 ? BaseStringImages.BOX_SCREEN_GREEN_LOT : BaseStringImages.BOX_SCREEN_RED_LOT);
            imageIsLot.background(
                    new Color(242, 242, 242, 255),
                    new Shape(ClipShape.RoundedCornerShape, 4)
            );
            imageIsLot.heigth(28).width(23);
            imageIsLot.paddingVertical(4);

            extraLotMark.getItems().add(imageIsLot);
        }

        if (isMark) {
            Image imageIsMark = new Image();
            imageIsMark.setImage(isScannedMark ? BaseStringImages.BOX_SCREEN_GREEN_MARK : BaseStringImages.BOX_SCREEN_RED_MARK);
            imageIsMark.background(
                    new Color(242, 242, 242, 255),
                    new Shape(ClipShape.RoundedCornerShape, 4)
            );
            imageIsMark.heigth(28).width(23);
            imageIsMark.paddingVertical(4);

            extraLotMark.getItems().add(imageIsMark);
        }

        if (price != null && price.compareTo(BigDecimal.ZERO) == 0) {
            Image priceNotPresent = new Image();
            priceNotPresent.setImage(BaseStringImages.PRICE_NOT_PRESENT);
            priceNotPresent.background(
                    new Color(242, 242, 242, 255),
                    new Shape(ClipShape.RoundedCornerShape, 4)
            );
            priceNotPresent.heigth(28).width(23);
            priceNotPresent.paddingVertical(4);

            extraLotMark.getItems().add(priceNotPresent);
        }

        extraLotMark.getItems().add(spacer);

        if (!isLot && !isMark) {
            extraLotMark = new Container();
        }

        positionContainer.getItems().add(quantityContainer);
        positionContainer.getItems().add(extraLotMark);

        productContainer.getItems().add(titleContainer);
        productContainer.getItems().add(positionContainer);


        container.getItems().add(productContainer);

        spacer = new Spacer();
        spacer.paddingVertical(6);
        container.getItems().add(spacer);

        Container lineContainer = new Container();
        lineContainer.paddingHorizontal(0)
                .width(500)
                .heigth(1)
                .background(238, 238, 238, 255);
        container.getItems().add(lineContainer);

        if (isLot) {
            container.setClickAction(
                    new Action(
                            String.format(
                                    "%s/%s?args=%s&lineNumber=%s&linkToOpenLot=true",
                                    UrlHelper.getUrlToCurrentResource(),
                                    WarehouseScreen.SUPPLY_RECALCULATION_BOX_UPDATE.getWarehouseScreen(),
                                    barcode,
                                    lineNumber
                            )
                    )
            );
        }

        return container;
    }

    public static Composable getBlockItemLot(
            String title,
            int quantity,
            int quantityFact,
            int quantityDiff,
            boolean isLot,
            boolean isMark,
            boolean isScannedMark,
            BigDecimal price,
            String id
    ) {


        Container container = new Container();

        container.setHasScroll(false);
        container.setDirection(Direction.VERTICAL);
        container
                .fillMaxWidth()
                .paddingHorizontal(16);
        container.heigth(88);

        Spacer spacer = new Spacer();
        spacer.paddingVertical(7);
        container.getItems().add(spacer);

        Container productContainer = new Container();
        productContainer.setHasScroll(false);
        productContainer.setDirection(Direction.VERTICAL);

        Container titleContainer = new Container();
        titleContainer.setHasScroll(false);
        titleContainer.setDirection(Direction.HORIZONTAL);
        titleContainer
                .width(360);

        String strDiff = null;
        Color colorText = null;
        Color colorCount = null;

        int diff = quantity - quantityFact;

        if (diff == 0) {
            strDiff = BaseStringImages.BOX_SCREEN_GREEN_CHECK_MARK;
            colorText = new Color(158, 158, 158, 255);
            colorCount = new Color(0, 0, 0, 255);
        } else {
            strDiff = BaseStringImages.BOX_SCREEN_RED_CHECK_MARK;
            colorText = new Color(239, 62, 66, 255);
            colorCount = colorText;
        }

        Image imageIcon = new Image();
        imageIcon.setImage(strDiff);
        imageIcon.paddingHorizontal(2)
                .paddingVertical(2);
        imageIcon.size(14);

        BindingProperty bindingProperty = new BindingProperty();
        bindingProperty.setValue(strDiff);
        bindingProperty.setSelfContained(true);
        titleContainer.getItems().add(imageIcon);

        Text titleText = new Text();
        titleText.setFontWeight(FontWeight.W500);
        titleText.setColor(new Color(0, 0, 0, 255));
        bindingProperty = new BindingProperty();
        bindingProperty.setValue(title);
        bindingProperty.setSelfContained(true);
        titleText.setContent(bindingProperty);
        titleText.setTextAlign(TextAlign.Left);
        titleText.paddingHorizontal(8);
        titleText.width(260);
        titleContainer.getItems().add(titleText);

        spacer = new Spacer();
        spacer.paddingHorizontal(10);
        titleContainer.getItems().add(spacer);

        IconButton menuButton = new IconButton();
        menuButton.setIcon(Icon.Column);
        menuButton.size(15);

        DropdownMenu dropdownMenu = new DropdownMenu();
        Modifier modifier = new Modifier();
        modifier.setWidth(250);
        dropdownMenu.getModifiers()
                .add(modifier);
        dropdownMenu.getDropdownMenuItems()
                .add(
                        new DropdownMenuItem(
                                new BindingProperty(
                                        "changeQuantityButtonText",
                                        false
                                ),
                                new Action(
                                        String.format(
                                                "%s/%s?args=%s",
                                                UrlHelper.getUrlToCurrentResource(),
                                                WarehouseScreen.SUPPLY_CHANGE_QUANTITY.getWarehouseScreen(),
                                                id
                                        )
                                )
                        )
                );
        dropdownMenu.getDropdownMenuItems()
                .add(
                        new DropdownMenuItem(
                                new BindingProperty(
                                        "clearPositionFactButtonText",
                                        false
                                ),
                                new Action(
                                        String.format(
                                                "%s/%s?args=%s",
                                                UrlHelper.getUrlToCurrentResource(),
                                                WarehouseScreen.SUPPLY_CLEAR_FACT_POSITION.getWarehouseScreen(),
                                                id
                                        )
                                )
                        )
                );
        dropdownMenu.getDropdownMenuItems()
                .add(
                        new DropdownMenuItem(
                                new BindingProperty(
                                        "removePositionButtonText",
                                        false
                                ),
                                new Action(
                                        String.format(
                                                "%s/%s?args=%s",
                                                UrlHelper.getUrlToCurrentResource(),
                                                WarehouseScreen.SUPPLY_DELETE_POSITION.getWarehouseScreen(),
                                                id
                                        )
                                ),
                                quantity != 0  ? Boolean.FALSE : Boolean.TRUE
                        )
                );
        dropdownMenu.getDropdownMenuItems()
                .add(
                        new DropdownMenuItem(
                                new BindingProperty(
                                        "viewPositionImageButtonText",
                                        false
                                ),
                                new Action(
                                        String.format(
                                                "%s/%s?args=%s",
                                                UrlHelper.getUrlToCurrentResource(),
                                                WarehouseScreen.SUPPLY_GOOD_IMAGE.getWarehouseScreen(),
                                                id
                                        )
                                )
                        )
                );
        dropdownMenu.getDropdownMenuItems()
                .add(
                        new DropdownMenuItem(
                                new BindingProperty(
                                        "addMarkButton",
                                        false
                                ),
                                new Action(
                                        String.format(
                                                "%s/%s?args=%s",
                                                UrlHelper.getUrlToCurrentResource(),
                                                WarehouseScreen.SUPPLY_RECALCULATION_BOX.getWarehouseScreen(),
                                                id
                                        )
                                ),
                                Boolean.FALSE
                        )
                );
        menuButton.setDropdownMenu(dropdownMenu);

        titleContainer.getItems().add(menuButton);

        Container positionContainer = new Container();
        positionContainer.setDirection(Direction.HORIZONTAL);

        spacer = new Spacer();
        spacer.width(24);

        positionContainer.getItems().add(spacer);

        Container quantityContainer = new Container();
        quantityContainer.setDirection(Direction.HORIZONTAL);
        quantityContainer.paddingHorizontal(0)
                .paddingVertical(4)
                .background(
                        new Color(242, 242, 242, 255),
                        new Shape(ClipShape.RoundedCornerShape, 4)
                );
        quantityContainer.heigth(22);

        spacer = new Spacer();
        spacer.paddingHorizontal(4);

        quantityContainer.getItems().add(spacer);

        Text quantityText = new Text();
        quantityText.setFontWeight(FontWeight.W500);
        quantityText.setFontSize(10);
        quantityText.setColor(new Color(158, 158, 158, 255));
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("ПЛАН:");
        bindingProperty.setSelfContained(true);
        quantityText.setContent(bindingProperty);
        quantityText
                .paddingVertical(4)
                .background(
                        new Color(242, 242, 242, 255),
                        new Shape(ClipShape.RoundedCornerShape, 4)
                );
        quantityText.heigth(20);
        quantityContainer.getItems().add(quantityText);

        quantityText = new Text();
        quantityText.setFontWeight(FontWeight.W500);
        quantityText.setFontSize(10);
        quantityText.setColor(new Color(0, 0, 0, 255));
        bindingProperty = new BindingProperty();
        bindingProperty.setValue(" " + quantity);
        bindingProperty.setSelfContained(true);
        quantityText.setContent(bindingProperty);
        quantityText
                .paddingVertical(4)
                .background(
                        new Color(242, 242, 242, 255),
                        new Shape(ClipShape.RoundedCornerShape, 4)
                );
        quantityText.heigth(20);
        quantityContainer.getItems().add(quantityText);

        spacer = new Spacer();
        spacer.paddingHorizontal(4);

        quantityContainer.getItems().add(spacer);

        Text quantityFactText = new Text();
        quantityFactText.setFontWeight(FontWeight.W500);
        quantityFactText.setFontSize(10);
        quantityFactText.setColor(new Color(158, 158, 158, 255));
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("ФАКТ:");
        bindingProperty.setSelfContained(true);
        quantityFactText.setContent(bindingProperty);
        quantityFactText
                .paddingVertical(4)
                .background(
                        new Color(242, 242, 242, 255),
                        new Shape(ClipShape.RoundedCornerShape, 4)
                );
        quantityFactText.heigth(20);

        quantityContainer.getItems().add(quantityFactText);

        quantityFactText = new Text();
        quantityFactText.setFontWeight(FontWeight.W500);
        quantityFactText.setFontSize(10);
        quantityFactText.setColor(new Color(0, 0, 0, 255));
        bindingProperty = new BindingProperty();
        bindingProperty.setValue(" " + quantityFact);
        bindingProperty.setSelfContained(true);
        quantityFactText.setContent(bindingProperty);
        quantityFactText
                .paddingVertical(4)
                .background(
                        new Color(242, 242, 242, 255),
                        new Shape(ClipShape.RoundedCornerShape, 4)
                );
        quantityFactText.heigth(20);

        quantityContainer.getItems().add(quantityFactText);

        quantityContainer.getItems().add(spacer);

        Text quantityDiffText = new Text();
        quantityDiffText.setFontWeight(FontWeight.W500);
        quantityDiffText.setFontSize(10);
        quantityDiffText.setColor(colorText);
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("РАСХ:");
        bindingProperty.setSelfContained(true);
        quantityDiffText.setContent(bindingProperty);
        quantityDiffText
                .paddingVertical(4)
                .background(
                        new Color(242, 242, 242, 255),
                        new Shape(ClipShape.RoundedCornerShape, 4)
                );
        quantityDiffText.heigth(20);
        quantityContainer.getItems().add(quantityDiffText);

        quantityDiffText = new Text();
        quantityDiffText.setFontWeight(FontWeight.W500);
        quantityDiffText.setFontSize(10);
        quantityDiffText.setColor(colorCount);
        bindingProperty = new BindingProperty();
        bindingProperty.setValue(" " + plusMinusSetter(quantityDiff));
        bindingProperty.setSelfContained(true);
        quantityDiffText.setContent(bindingProperty);
        quantityDiffText
                .paddingVertical(4)
                .background(
                        new Color(242, 242, 242, 255),
                        new Shape(ClipShape.RoundedCornerShape, 4)
                );
        quantityDiffText.heigth(20);
        quantityContainer.getItems().add(quantityDiffText);

        spacer = new Spacer();
        spacer.paddingHorizontal(4);
        quantityContainer.getItems().add(spacer);

        Container extraLotMark;

        extraLotMark = new Container();
        extraLotMark.setDirection(Direction.HORIZONTAL);
        extraLotMark.paddingHorizontal(4)
                .paddingVertical(4)
                .background(
                        new Color(242, 242, 242, 255),
                        new Shape(ClipShape.RoundedCornerShape, 4)
                );
        extraLotMark.heigth(22);

        spacer = new Spacer();
        spacer.width(5);
        extraLotMark.getItems().add(spacer);


        if (isLot) {
            Image imageIsLot = new Image();
            imageIsLot.setImage(diff == 0 ? BaseStringImages.BOX_SCREEN_GREEN_LOT : BaseStringImages.BOX_SCREEN_RED_LOT);
            imageIsLot.background(
                    new Color(242, 242, 242, 255),
                    new Shape(ClipShape.RoundedCornerShape, 4)
            );
            imageIsLot.heigth(28).width(23);
            imageIsLot.paddingVertical(4);

            extraLotMark.getItems().add(imageIsLot);
        }
        if (isMark) {
            Image imageIsMark = new Image();
            imageIsMark.setImage(isScannedMark ? BaseStringImages.BOX_SCREEN_GREEN_MARK : BaseStringImages.BOX_SCREEN_RED_MARK);
            imageIsMark.background(
                    new Color(242, 242, 242, 255),
                    new Shape(ClipShape.RoundedCornerShape, 4)
            );
            imageIsMark.heigth(28).width(23);
            imageIsMark.paddingVertical(4);

            extraLotMark.getItems().add(imageIsMark);
        }
        if (price != null && price.compareTo(BigDecimal.ZERO) == 0) {
            Image priceNotPresent = new Image();
            priceNotPresent.setImage(BaseStringImages.PRICE_NOT_PRESENT);
            priceNotPresent.background(
                    new Color(242, 242, 242, 255),
                    new Shape(ClipShape.RoundedCornerShape, 4)
            );
            priceNotPresent.heigth(28).width(23);
            priceNotPresent.paddingVertical(4);

            extraLotMark.getItems().add(priceNotPresent);
        }
        extraLotMark.getItems().add(spacer);
        if (!isLot && !isMark) {
            extraLotMark = new Container();
        }

        positionContainer.getItems().add(quantityContainer);
        positionContainer.getItems().add(extraLotMark);

        productContainer.getItems().add(titleContainer);
        productContainer.getItems().add(positionContainer);


        container.getItems().add(productContainer);

        spacer = new Spacer();
        spacer.paddingVertical(6);
        container.getItems().add(spacer);

        Container lineContainer = new Container();
        lineContainer.paddingHorizontal(0)
                .width(500)
                .heigth(1)
                .background(238, 238, 238, 255);

        container.getItems().add(lineContainer);

        return container;
    }

    public static Composable getBlockItem(
            String title,
            int quantity,
            int quantityFact,
            int quantityDiff,
            int quantityDiffProductsIntoLot,
            boolean isMark,
            boolean isScannedMark,
            BigDecimal price,
            String id,
            String barcode,
            Integer lineNumber,
            String idd,
            String marks
    ) {
        Container container = new Container();
        container.setClickAction(new Action(
                String.format("%s/%s?args=%s",
                UrlHelper.getUrlToCurrentResource(),
                WarehouseScreen.INTERNET_ORDERS_COLLECT_ORDERS_VIEW_POSITION.getWarehouseScreen(),
                id
        )));

        container.setHasScroll(false);
        container.setDirection(Direction.VERTICAL);
        container
                .fillMaxWidth()
                .paddingHorizontal(16)
                .heigth(88);

        Spacer spacer = new Spacer();
        spacer.paddingVertical(7);
        container.getItems().add(spacer);

        Container productContainer = new Container();
        productContainer.setHasScroll(false);
        productContainer.setDirection(Direction.VERTICAL);

        Container titleContainer = new Container();
        titleContainer.setHasScroll(false);
        titleContainer.setDirection(Direction.HORIZONTAL);
        titleContainer
                .width(360);

        String strDiff;
        Color colorText;
        Color colorCount;

        int diff = quantityFact- quantity;

        if (quantity > 0 && diff == 0 || quantity > 0 && quantityFact == 0 && !Strings.isNullOrEmpty(marks)) {
            strDiff = BaseStringImages.BOX_SCREEN_GREEN_CHECK_MARK;
            colorText = new Color(158, 158, 158, 255);
            colorCount = new Color(0, 0, 0, 255);
        } else {
            strDiff = BaseStringImages.BOX_SCREEN_RED_CHECK_MARK;
            colorText = new Color(239, 62, 66, 255);
            colorCount = colorText;
        }

        Image imageIcon = new Image();
        imageIcon.setImage(strDiff);
        imageIcon.paddingHorizontal(2)
                .paddingVertical(2);
        imageIcon.size(14);

        BindingProperty bindingProperty = new BindingProperty();
        bindingProperty.setValue(strDiff);
        bindingProperty.setSelfContained(true);
        titleContainer.getItems().add(imageIcon);

        Text titleText = new Text();
        titleText.setFontWeight(FontWeight.W500);
        titleText.setColor(new Color(0, 0, 0, 255));
        bindingProperty = new BindingProperty();
        bindingProperty.setValue(title);
        bindingProperty.setSelfContained(true);
        titleText.setContent(bindingProperty);
        titleText.setTextAlign(TextAlign.Left);
        titleText.paddingHorizontal(8);
        titleText.width(260);
        titleContainer.getItems().add(titleText);

        spacer = new Spacer();
        spacer.paddingHorizontal(10);
        titleContainer.getItems().add(spacer);

        IconButton menuButton = new IconButton();
        menuButton.setIcon(Icon.Column);
        menuButton.size(15);

        DropdownMenu dropdownMenu = new DropdownMenu();
        Modifier modifier = new Modifier();
        modifier.setWidth(250);
        dropdownMenu.getModifiers()
                .add(modifier);
        dropdownMenu.getDropdownMenuItems()
                .add(
                        new DropdownMenuItem(
                                new BindingProperty(
                                        "changeQuantityButtonText",
                                        false
                                ),
                                new Action(
                                        String.format(
                                                "%s/%s?args=%s",
                                                UrlHelper.getUrlToCurrentResource(),
                                                WarehouseScreen.INTERNET_ORDERS_CHANGE_QUANTITY.getWarehouseScreen(),
                                                id
                                        )
                                )
                        )
                );
        dropdownMenu.getDropdownMenuItems()
                .add(
                        new DropdownMenuItem(
                                new BindingProperty(
                                        "clearPositionFactButtonText",
                                        false
                                ),
                                new Action(
                                        String.format(
                                                "%s/%s?args=%s",
                                                UrlHelper.getUrlToCurrentResource(),
                                                WarehouseScreen.INTERNET_ORDERS_CLEAR_FACT_POSITION.getWarehouseScreen(),
                                                id
                                        )
                                )
                        )
                );
        dropdownMenu.getDropdownMenuItems()
                .add(
                        new DropdownMenuItem(
                                new BindingProperty(
                                        "reasonForAbsence",
                                        false
                                ),
                                new Action(
                                        String.format(
                                                "%s/%s?args=%s",
                                                UrlHelper.getUrlToCurrentResource(),
                                                WarehouseScreen.INTERNET_ORDERS_CAUSES_OF_NOT_ASSEMBLY.getWarehouseScreen(),
                                                id
                                        )
                                )
                        )
                );
        dropdownMenu.getDropdownMenuItems()
                .add(
                        new DropdownMenuItem(
                                new BindingProperty(
                                        "removePositionButtonText",
                                        false
                                ),
                                new Action(
                                        String.format(
                                                "%s/%s?args=%s",
                                                UrlHelper.getUrlToCurrentResource(),
                                                WarehouseScreen.INTERNET_ORDERS_DELETE_POSITION.getWarehouseScreen(),
                                                id
                                        )
                                ),
                                quantity != 0  ? Boolean.FALSE : Boolean.TRUE
                        )
                );
        dropdownMenu.getDropdownMenuItems()
                .add(
                        new DropdownMenuItem(
                                new BindingProperty(
                                        "addMarkButton",
                                        false
                                ),
                                new Action(
                                        String.format(
                                                "%s/%s?args=%s",
                                                UrlHelper.getUrlToCurrentResource(),
                                                WarehouseScreen.SUPPLY_RECALCULATION_BOX.getWarehouseScreen(),
                                                id
                                        )
                                ),
                                Boolean.FALSE
                        )
                );
        menuButton.setDropdownMenu(dropdownMenu);

        titleContainer.getItems().add(menuButton);

        Container positionContainer = new Container();
        positionContainer.setDirection(Direction.HORIZONTAL);

        spacer = new Spacer();
        spacer.width(24);

        positionContainer.getItems().add(spacer);

        Container quantityContainer = new Container();
        quantityContainer.setDirection(Direction.HORIZONTAL);
        quantityContainer.paddingHorizontal(0)
                .paddingVertical(4)
                .background(
                        new Color(242, 242, 242, 255),
                        new Shape(ClipShape.RoundedCornerShape, 4)
                );
        quantityContainer.heigth(22);

        spacer = new Spacer();
        spacer.paddingHorizontal(4);

        quantityContainer.getItems().add(spacer);

        Text quantityText = new Text();
        quantityText.setFontWeight(FontWeight.W500);
        quantityText.setFontSize(10);
        quantityText.setColor(new Color(158, 158, 158, 255));
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("ПЛАН:");
        bindingProperty.setSelfContained(true);
        quantityText.setContent(bindingProperty);
        quantityText
                .paddingVertical(4)
                .background(
                        new Color(242, 242, 242, 255),
                        new Shape(ClipShape.RoundedCornerShape, 4)
                );
        quantityText.heigth(20);
        quantityContainer.getItems().add(quantityText);

        quantityText = new Text();
        quantityText.setFontWeight(FontWeight.W500);
        quantityText.setFontSize(10);
        quantityText.setColor(new Color(0, 0, 0, 255));
        bindingProperty = new BindingProperty();
        bindingProperty.setValue(" " + quantity);
        bindingProperty.setSelfContained(true);
        quantityText.setContent(bindingProperty);
        quantityText
                .paddingVertical(4)
                .background(
                        new Color(242, 242, 242, 255),
                        new Shape(ClipShape.RoundedCornerShape, 4)
                );
        quantityText.heigth(20);
        quantityContainer.getItems().add(quantityText);

        spacer = new Spacer();
        spacer.paddingHorizontal(4);

        quantityContainer.getItems().add(spacer);

        Text quantityFactText = new Text();
        quantityFactText.setFontWeight(FontWeight.W500);
        quantityFactText.setFontSize(10);
        quantityFactText.setColor(new Color(158, 158, 158, 255));
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("ФАКТ:");
        bindingProperty.setSelfContained(true);
        quantityFactText.setContent(bindingProperty);
        quantityFactText
                .paddingVertical(4)
                .background(
                        new Color(242, 242, 242, 255),
                        new Shape(ClipShape.RoundedCornerShape, 4)
                );
        quantityFactText.heigth(20);

        quantityContainer.getItems().add(quantityFactText);

        quantityFactText = new Text();
        quantityFactText.setFontWeight(FontWeight.W500);
        quantityFactText.setFontSize(10);
        quantityFactText.setColor(new Color(0, 0, 0, 255));
        bindingProperty = new BindingProperty();
        bindingProperty.setValue(" " + quantityFact);
        bindingProperty.setSelfContained(true);
        quantityFactText.setContent(bindingProperty);
        quantityFactText
                .paddingVertical(4)
                .background(
                        new Color(242, 242, 242, 255),
                        new Shape(ClipShape.RoundedCornerShape, 4)
                );
        quantityFactText.heigth(20);

        quantityContainer.getItems().add(quantityFactText);

        quantityContainer.getItems().add(spacer);

        Text quantityDiffText = new Text();
        quantityDiffText.setFontWeight(FontWeight.W500);
        quantityDiffText.setFontSize(10);
        quantityDiffText.setColor(colorText);
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("РАСХ:");
        bindingProperty.setSelfContained(true);
        quantityDiffText.setContent(bindingProperty);
        quantityDiffText
                .paddingVertical(4)
                .background(
                        new Color(242, 242, 242, 255),
                        new Shape(ClipShape.RoundedCornerShape, 4)
                );
        quantityDiffText.heigth(20);
        quantityContainer.getItems().add(quantityDiffText);

        quantityDiffText = new Text();
        quantityDiffText.setFontWeight(FontWeight.W500);
        quantityDiffText.setFontSize(10);
        quantityDiffText.setColor(colorCount);
        bindingProperty = new BindingProperty();
        bindingProperty.setValue(" " + plusMinusSetter(quantityDiff));
        bindingProperty.setSelfContained(true);
        quantityDiffText.setContent(bindingProperty);
        quantityDiffText
                .paddingVertical(4)
                .background(
                        new Color(242, 242, 242, 255),
                        new Shape(ClipShape.RoundedCornerShape, 4)
                );
        quantityDiffText.heigth(20);
        quantityContainer.getItems().add(quantityDiffText);

        spacer = new Spacer();
        spacer.paddingHorizontal(4);
        quantityContainer.getItems().add(spacer);

        Container extraLotMark = new Container();

        if (isMark) {

            extraLotMark.setDirection(Direction.HORIZONTAL);
            extraLotMark.paddingHorizontal(4)
                    .paddingVertical(4)
                    .background(
                            new Color(242, 242, 242, 255),
                            new Shape(ClipShape.RoundedCornerShape, 4)
                    );
            extraLotMark.heigth(22);

            spacer = new Spacer();
            spacer.width(5);
            extraLotMark.getItems().add(spacer);
            Image imageIsMark = new Image();
            imageIsMark.setImage(isScannedMark ? BaseStringImages.BOX_SCREEN_GREEN_MARK : BaseStringImages.BOX_SCREEN_RED_MARK);
            imageIsMark.background(
                    new Color(242, 242, 242, 255),
                    new Shape(ClipShape.RoundedCornerShape, 4)
            );
            imageIsMark.heigth(28).width(23);
            imageIsMark.paddingVertical(4);

            extraLotMark.getItems().add(imageIsMark);
        }

        if (price != null && price.compareTo(BigDecimal.ZERO) == 0) {
            Image priceNotPresent = new Image();
            priceNotPresent.setImage(BaseStringImages.PRICE_NOT_PRESENT);
            priceNotPresent.background(
                    new Color(242, 242, 242, 255),
                    new Shape(ClipShape.RoundedCornerShape, 4)
            );
            priceNotPresent.heigth(28).width(23);
            priceNotPresent.paddingVertical(4);

            extraLotMark.getItems().add(priceNotPresent);
        }

        extraLotMark.getItems().add(spacer);

        positionContainer.getItems().add(quantityContainer);
        positionContainer.getItems().add(extraLotMark);

        productContainer.getItems().add(titleContainer);
        productContainer.getItems().add(positionContainer);


        container.getItems().add(productContainer);

        spacer = new Spacer();
        spacer.paddingVertical(6);
        container.getItems().add(spacer);

        Container lineContainer = new Container();
        lineContainer.paddingHorizontal(0)
                .width(500)
                .heigth(1)
                .background(238, 238, 238, 255);
        container.getItems().add(lineContainer);

        return container;
    }

    public static String plusMinusSetter(String diff) {
        Integer intDiff = Integer.parseInt(diff);
        return plusMinusSetter(intDiff);
    }
    public static String plusMinusSetter(Integer diff) {
        return diff > 0 ? String.format(
                "+%s",
                diff
        )
                : String.valueOf(diff);
    }
}
