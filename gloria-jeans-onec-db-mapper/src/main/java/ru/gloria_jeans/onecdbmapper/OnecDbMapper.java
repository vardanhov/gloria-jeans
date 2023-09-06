package ru.gloria_jeans.onecdbmapper;


import com.google.common.base.Strings;
import org.yaml.snakeyaml.Yaml;
import ru.gloria_jeans.onecdbmapper.mdparser.metadata.OnecMetaData;
import ru.gloria_jeans.onecdbmapper.mdparser.stream.CompoundParser;

import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public class OnecDbMapper {
    private static OnecMetaData onecMetaData;
    private static final String property = "onec.md.path";
    private static final String moduleName = "Root Entry/Metadata/Main MetaData Stream";

    public static OnecMetaData getOnecMetadata(String pathToMdFile) throws Exception {
        File file = new File(pathToMdFile);
        CompoundParser compoundParser = new CompoundParser(Files.readAllBytes(file.toPath()));
        byte[] bytes = compoundParser.read(moduleName);
        byte[] copiedBytes = Arrays.copyOfRange(bytes, 7, bytes.length - 7);
        String ppp = new String(copiedBytes, Charset.forName("windows-1251"));
        onecMetaData = new OnecMetaData();
        onecMetaData.read(ppp);
        return onecMetaData;
    }

    public static OnecMetaData getOnecMetadata() {
        if (Objects.isNull(onecMetaData)) {
            try {
                getOnecMetadata(getPathToMdFile());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return onecMetaData;
    }

    private static String getPathToMdFile() throws Exception {
        String pathToMdFile = "";
        pathToMdFile = System.getenv(property);

        if (!Strings.isNullOrEmpty(pathToMdFile)) {
            return pathToMdFile;
        }

        pathToMdFile = System.getProperty(property);

        if (!Strings.isNullOrEmpty(pathToMdFile)) {
            return pathToMdFile;
        }

        InputStream inputStream = OnecDbMapper.class.getClassLoader().getResourceAsStream(String.format("application%s.yml", getPrefixToFile()));

        if(Objects.nonNull(inputStream)) {
            Yaml yaml = new Yaml();
            Map<String, Object> data = yaml.load(inputStream);
            pathToMdFile = ((Map<String, Object>)((Map<String, Object>) data.get("onec")).get("md")).get("path").toString();
        } else {
            Properties properties = new Properties();
            inputStream = OnecDbMapper.class.getClassLoader().getResourceAsStream(String.format("application%s.properties", getPrefixToFile()));
            properties.load(inputStream);
            pathToMdFile = properties.getProperty(property);
        }

        return pathToMdFile;
    }

    private static String getPrefixToFile() {
        String springProfile = System.getenv("spring.profiles.active");

        if (!Strings.isNullOrEmpty(springProfile)) {
            return String.format("-%s", springProfile);
        }

        springProfile = System.getProperty("spring.profiles.active");

        if (Strings.isNullOrEmpty(springProfile)) {
            return "";
        } else {
            return String.format("-%s", springProfile);
        }
    }
}
