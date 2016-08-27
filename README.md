# todahora

Projeto JEE desenvolvido para fins educativos.

Ambiente:
- Eclipse
- postgresql
- driver postgresql
- wildfly
- maven

Configuração do datasource no wildfly-9.0.1.Final/standalone/configuration/standalone.xml:
```
                <datasource jta="true" jndi-name="java:jboss/datasources/apis2DS" pool-name="apis2DS" enabled="true" use-java-context="true">
                    <connection-url>jdbc:postgresql://192.168.99.100:5432/dbcico</connection-url>
                    <driver>postgresql</driver>
                    <transaction-isolation>TRANSACTION_READ_COMMITTED</transaction-isolation>
                    <pool>
                        <min-pool-size>5</min-pool-size>
                        <max-pool-size>10</max-pool-size>
                    </pool>
                    <security>
                        <user-name>cico</user-name>
                        <password>cic0db</password>
                    </security>
                    <validation>
                        <check-valid-connection-sql>SELECT 1</check-valid-connection-sql>
                        <validate-on-match>false</validate-on-match>
                        <background-validation>false</background-validation>
                    </validation>
                    <statement>
                        <track-statements>true</track-statements>
                        <share-prepared-statements>false</share-prepared-statements>
                    </statement>
                </datasource>
```
                
Configuração do driver em wildfly-9.0.1.Final/standalone/configuration/standalone.xml:
```                <drivers>
                    <driver name="h2" module="com.h2database.h2">
                        <xa-datasource-class>org.h2.jdbcx.JdbcDataSource</xa-datasource-class>
                    </driver>
                    <driver name="postgresql" module="org.postgresql">
                        <xa-datasource-class>org.postgresql.xa.PGXADataSource</xa-datasource-class>
                    </driver>
                </drivers>
```

Configuração do módulo do driver em wildfly-9.0.1.Final/modules/system/layers/base/org/postgresql/main/module.xml:

```
<?xml version="1.0" encoding="UTF-8"?>
<module xmlns="urn:jboss:module:1.3" name="org.postgresql">

    <resources>
        <resource-root path="postgresql-9.4-1202.jdbc4.jar"/>
    </resources>
    <dependencies>
        <module name="javax.api"/>
        <module name="javax.transaction.api"/>
        <module name="javax.servlet.api" optional="true"/>
    </dependencies>
</module>
```
