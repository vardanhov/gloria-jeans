package ru.gloria_jeans.onecdbmapper;

import org.apache.logging.log4j.util.Strings;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;

@Component
public class NamingStrategy implements PhysicalNamingStrategy {
    private Logger logger = LoggerFactory.getLogger(NamingStrategy.class);
    private String currentEntityTableName;
    private String currentPhysicalTableName;
    private String currentEntityColumnName;
    private String currentPhysicalColumnName;
    private final NamingAssociations namingAssociations;
    private final String[] IGNORE_COLUMN_NAMES = {
            "DTYPE",
            "element",
            "items_KEY",
            "items",
            "journal",
            "productInfo",
            "movingDocument",
            "acceptanceDocument",
            "uidd",
            "iddoc",
            "iddocLinenumberIdentity",
            "idDoc",
            "lineNo_",
            "ROW_ID",
            "mismatchDocument",
            "packageErrorContentsDocument",
            "lotInfo",
            "priceOrder",
            "prices",
            "prices_KEY",
            "actno",
            "stockBalanceTMCEmbeddedId",
            "position",
            "parentProduct",
            "orderDocument",
            "status",
            "orderClosureDocument",
            "receipt",
            "writeOffDocument",
            "routeList"
    };

    public NamingStrategy() throws Exception {
        namingAssociations = new NamingAssociations();
    }

    @Override
    public Identifier toPhysicalCatalogName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        return Objects.nonNull(identifier) ? identifier : jdbcEnvironment.getCurrentCatalog();
    }

    @Override
    public Identifier toPhysicalSchemaName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        return Objects.nonNull(identifier) ? identifier : jdbcEnvironment.getCurrentSchema();
    }

    @Override
    public Identifier toPhysicalTableName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        currentPhysicalTableName = Strings.EMPTY;
        currentEntityTableName = identifier.getText();
        currentPhysicalTableName = namingAssociations.getTableName(identifier.getText());
        logger.debug("Renaming table name from '{}' to '{}'", currentEntityTableName, currentPhysicalTableName);
        return Identifier.toIdentifier(currentPhysicalTableName);
    }

    @Override
    public Identifier toPhysicalSequenceName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        return identifier;
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        currentPhysicalColumnName = Strings.EMPTY;
        currentEntityColumnName = identifier.getText();

        if (Arrays.stream(IGNORE_COLUMN_NAMES).anyMatch(x -> x.equals(currentEntityColumnName))) {
            return identifier;
        }

        try {
            currentPhysicalColumnName = namingAssociations.getColumnName(identifier.getText(), currentEntityTableName);
            logger.debug(
                    "Renaming column name from '{}'.'{}' to '{}'.'{}'",
                    currentEntityTableName,
                    currentEntityColumnName,
                    currentPhysicalTableName,
                    currentPhysicalColumnName
            );
            return Identifier.toIdentifier(currentPhysicalColumnName);
        } catch (Exception e) {
            logger.error(
                    "Error in toPhysicalColumnName with table name '{}' physical '{}' and column name '{}' physical '{}'.",
                    currentEntityTableName,
                    currentPhysicalTableName,
                    currentEntityColumnName,
                    currentPhysicalColumnName
            );
            return identifier;
        }
    }
}
