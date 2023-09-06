package ru.gloria_jeans.onecdbmapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gloria_jeans.onecdbmapper.mdparser.metadata.OnecMetaData;
import ru.gloria_jeans.onecdbmapper.mdparser.metadata.SbNodeField;

import java.util.Objects;

@Component
public class NamingAssociations {
    private OnecMetaData onecMetaData;

    @Autowired
    public NamingAssociations() throws Exception {
        this.onecMetaData = OnecDbMapper.getOnecMetadata();
    }

    public String getTableName(String tableName) {
        String[] onecObjectNames = tableName.split("\\.");

        switch (onecObjectNames[0]) {
            case "Журналы":
                return "_1sjourn";
            case "Справочник":
                return onecMetaData.Sbs.get(onecObjectNames[1]).getDbName();
            case "Документ":
                return onecMetaData.Documents.get(onecObjectNames[1]).getDbName();
            case "ДокументСтроки":
                return "DT" + onecMetaData.Documents.get(onecObjectNames[1]).getDbName().substring(2);
            case "Регистр":
                return onecMetaData.Registers.get(onecObjectNames[1]).getDbName();
            case "РегистрИтоги":
                return "RG" + onecMetaData.Registers.get(onecObjectNames[1]).getDbName().substring(2);
            default:
                return tableName;
        }
    }

    public String getColumnName(String columnName, String tableName) throws Exception {
        if (tableName.toLowerCase().contains("журналы")) {
            if (!onecMetaData.JournCommonRefs.containsKey(columnName)) {
                throw new Exception();
            }

            return onecMetaData.JournCommonRefs.get(columnName).getDbName();
        } else {
            boolean IsDoc = false;
            SbNodeField field = null;
            String[] onecObjectNames = tableName.split("\\.");

            switch (onecObjectNames[0]) {
                case "Справочник":
                    field = onecMetaData.Sbs.get(onecObjectNames[1]).getFields()
                            .parallelStream()
                            .filter(x -> x.getIdentity().equals(columnName))
                            .findFirst()
                            .orElse(null);
                    break;
                case "Документ":
                    field = onecMetaData.Documents.get(onecObjectNames[1]).Head
                            .parallelStream()
                            .filter(x -> x.getIdentity().equals(columnName))
                            .findFirst()
                            .orElse(null);
                    IsDoc = true;
                    break;
                case "ДокументСтроки":
                    field = onecMetaData.Documents.get(onecObjectNames[1]).Table
                            .parallelStream()
                            .filter(x -> x.getIdentity().equals(columnName))
                            .findFirst()
                            .orElse(null);
                    break;
                case "Регистр":
                case "РегистрИтоги":
                    field = onecMetaData.Registers.get(onecObjectNames[1]).All
                            .parallelStream()
                            .filter(x -> x.getIdentity().equals(columnName))
                            .findFirst()
                            .orElse(null);
                    break;
                default:
                    return columnName;
            }

            if (Objects.isNull(field)) {
                if (IsDoc) {
                    if (onecMetaData.JournCommonRefs.containsKey(columnName)) {
                        return onecMetaData.JournCommonRefs.get(columnName).getDbName();
                    }

                    field = onecMetaData.Documents.get(onecObjectNames[1]).Table.parallelStream()
                            .filter(x -> x.getIdentity().equals(columnName))
                            .findFirst()
                            .orElse(null);

                    if (Objects.nonNull(field)) {
                        return field.getDbName();
                    }
                }

                throw new Exception();
            }

            return field.getDbName();
        }
    }

    public Integer getTableId(String tableName) {
        String[] onecObjectNames = tableName.split("\\.");

        switch (onecObjectNames[0]) {
            case "Справочник":
                return Integer.parseInt(onecMetaData.Sbs.get(onecObjectNames[1]).getID());
            case "Документ":
                return Integer.parseInt(onecMetaData.Documents.get(onecObjectNames[1]).getID());
//            case "ДокументСтроки":
//                return "DT" + onecMetaData.Documents.get(onecObjectNames[1]).getDbName().substring(2);
//            case "Регистр":
//                return onecMetaData.Registers.get(onecObjectNames[1]).getDbName();
//            case "РегистрИтоги":
//                return "RG" + onecMetaData.Registers.get(onecObjectNames[1]).getDbName().substring(2);
            default:
                return null;
        }
    }
}
