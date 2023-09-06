package ru.gloria_jeans.orders.utils;

import ru.gloria_jeans.orders.dao.enums.Month;

import java.io.File;
import java.nio.file.FileSystems;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class FileNameHelper {
    public static File setFileName(List<String> folders, String orderNumber, String fileType) {
        String currentDate = new SimpleDateFormat("yyyy.MM.dd").format(new Date());
        folders.add(Objects.requireNonNull(Month.getCurrentMonth()).getName());
        String fileDirectory = FileNameHelper.createFileDirectory(folders);
        return new File(
                FileSystems.getDefault().getPath(
                        fileDirectory,
                        String.format(
                                "%s_%s_%s.pdf",
                                currentDate,
                                orderNumber.trim(),
                                fileType
                        )
                ).toString());
    }

    public static String createFileDirectory(List<String> folders) {
        String fileDirectory = null;
        File file;

        for (String folder : folders) {

            if (fileDirectory == null) {
                fileDirectory = folder;
            } else {
                fileDirectory = FileSystems.getDefault().getPath(
                        fileDirectory,
                        folder
                ).toString();
            }

            file = new File(fileDirectory);

            if (!file.isDirectory()) {
                file.mkdir();
            }
        }
        return fileDirectory;
    }
}
