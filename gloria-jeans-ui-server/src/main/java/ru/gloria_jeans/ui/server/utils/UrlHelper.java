package ru.gloria_jeans.ui.server.utils;

import ru.gloria_jeans.ui.server.jetpackcompose.control.DataContext;

import java.util.ArrayList;
import java.util.Objects;

public class UrlHelper {
    public final static String MAIN_SCREEN = "main";
    public final static String CLOSE_MODAL_DIALOG = "modalDialogAction=CLOSE";
    private static String baseServerUrl;
    private static String currentResource;
    private static String currentScreen;

    public static String getBaseServerUrl() {
        return baseServerUrl;
    }

    public static void setBaseServerUrl(String baseServerUrl) {
        UrlHelper.baseServerUrl = baseServerUrl;
    }

    public static String getCurrentResource() {
        return currentResource;
    }

    public static void setCurrentResource(String currentResource) {
        UrlHelper.currentResource = currentResource;
    }

    public static String getCurrentScreen() {
        return currentScreen;
    }

    public static void setCurrentScreen(String currentScreen) {
        UrlHelper.currentScreen = currentScreen;
    }
    public static void setCurrentScreen(String currentScreen, DataContext dataContext) {
        UrlHelper.currentScreen = currentScreen;
        ArrayList<String> urls = dataContext.getLastURLs();

        if (urls.size() > 2){
            var urlFirst = urls.get(1);
            var urlSecond = urls.get(2);
            urls.clear();
            urls.add(urlFirst);
            urls.add(urlSecond);
        }

        if (0 == urls.size()){
            urls.add(currentScreen);
        } else{
            if (!Objects.equals(urls.get(urls.size() - 1), currentScreen)){
                urls.add(currentScreen);
            }
        }

        dataContext.setLastURLs(urls);

    }

    public static String getUrlToCurrentResource() {
        return String.format(
                "%s/screen/%s",
                baseServerUrl,
                currentResource
        );
    }

    public static String getUrlToCurrentScreen() {
        return getUrlToCurrentScreen(false);
    }
    public static String getUrlToCurrentScreen(boolean closeModalDialog) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(baseServerUrl)
                .append("/screen/")
                .append(currentResource);

        if (!MAIN_SCREEN.equals(currentScreen)) {
            stringBuilder
                    .append("/")
                    .append(currentScreen.replace('_', '/'));
        }

        if (closeModalDialog) {
            stringBuilder
                    .append("?")
                    .append(CLOSE_MODAL_DIALOG);
        }

        return stringBuilder.toString();
    }

    public static String getUrlToBack() {
        return getUrlToBack(false);
    }

    public static String getUrlToBack(boolean closeModalDialog) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(baseServerUrl)
                .append("/screen/")
                .append(currentResource);
        String[] urlParts = currentScreen.replace('_', '/').split("/");

        for (int i = 0; i < urlParts.length; i++) {
            if (i < urlParts.length - 1) {
                stringBuilder.append("/").append(urlParts[i]);
            }
        }

        if (closeModalDialog) {
            stringBuilder.append("?").append(CLOSE_MODAL_DIALOG);
        }

        return stringBuilder.toString();
    }
}
