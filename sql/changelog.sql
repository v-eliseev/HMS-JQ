--  *********************************************************************
--  SQL to add all changesets to database history table
--  *********************************************************************
--  Change Log: changelog.groovy
--  Ran at: 3/10/14 10:19 PM
--  Against: hms@192.168.0.34@jdbc:mysql://srv:3306/hms
--  Liquibase version: 2.0.5
--  *********************************************************************

--  Create Database Lock Table
CREATE TABLE `DATABASECHANGELOGLOCK` (`ID` INT NOT NULL, `LOCKED` TINYINT(1) NOT NULL, `LOCKGRANTED` DATETIME NULL, `LOCKEDBY` VARCHAR(255) NULL, CONSTRAINT `PK_DATABASECHANGELOGLOCK` PRIMARY KEY (`ID`));

INSERT INTO `DATABASECHANGELOGLOCK` (`ID`, `LOCKED`) VALUES (1, 0);

--  Lock Database
--  Create Database Change Log Table
CREATE TABLE `DATABASECHANGELOG` (`ID` VARCHAR(63) NOT NULL, `AUTHOR` VARCHAR(63) NOT NULL, `FILENAME` VARCHAR(200) NOT NULL, `DATEEXECUTED` DATETIME NOT NULL, `ORDEREXECUTED` INT NOT NULL, `EXECTYPE` VARCHAR(10) NOT NULL, `MD5SUM` VARCHAR(35) NULL, `DESCRIPTION` VARCHAR(255) NULL, `COMMENTS` VARCHAR(255) NULL, `TAG` VARCHAR(255) NULL, `LIQUIBASE` VARCHAR(20) NULL, CONSTRAINT `PK_DATABASECHANGELOG` PRIMARY KEY (`ID`, `AUTHOR`, `FILENAME`));

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1394475472405-1', '2.0.5', '3:02be88ac2430c2eb45200cc58eeda1cc', 1);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1394475472405-2', '2.0.5', '3:892f245a1d53875e83a782bfe5f4b591', 2);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1394475472405-3', '2.0.5', '3:c93c755d82a4735002ccedb4965e5cbe', 3);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1394475472405-4', '2.0.5', '3:1098558ef528645475d8e6e3f6adc1f1', 4);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1394475472405-5', '2.0.5', '3:2cfaa762c35046c16333ae23543f327b', 5);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1394475472405-6', '2.0.5', '3:c8efb74e6143913ad94aeea83cdf37db', 6);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1394475472405-7', '2.0.5', '3:745bf5606accb8eb1cdcf081fd00f6a2', 7);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1394475472405-8', '2.0.5', '3:4636731830901498a66e80ec6b76ba40', 8);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1394475472405-9', '2.0.5', '3:dba04ff6be40ff74732fab32ff075b4c', 9);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1394475472405-10', '2.0.5', '3:7c6479f9c6c295133ec585ce7ac84271', 10);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1394475472405-11', '2.0.5', '3:ed2f1066d8a3ece31a99d145477f263e', 11);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1394475472405-12', '2.0.5', '3:92fd0220ea332a31ff830baebabd7af2', 12);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1394475472405-13', '2.0.5', '3:1da6430e890dd91edb2434c4332955bd', 13);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1394475472405-14', '2.0.5', '3:0f30adc115aca41a9eee4506b8ae4f5f', 14);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1394475472405-15', '2.0.5', '3:1bb8bd9ad1a6c7a090bb0d5831c58aad', 15);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1394475472405-16', '2.0.5', '3:893cd3a1358381123f38eaa425a07a49', 16);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1394475472405-17', '2.0.5', '3:855d54f599f3a11f0d1164c7c75af3fa', 17);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1394475472405-18', '2.0.5', '3:846f8a2f0b39cdaaf1f92b73ee447459', 18);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1394475472405-19', '2.0.5', '3:d01c0ed2a878ab4fec0cf99bbe24fab4', 19);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1394475472405-20', '2.0.5', '3:c9362bf2578e1233676ed97b5288d69b', 20);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1394475472405-21', '2.0.5', '3:fb599f2046feb3f218b698e917f8a773', 21);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1394475472405-22', '2.0.5', '3:df12feb39a343fc9d48cccc56e99c7cc', 22);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1394475472405-23', '2.0.5', '3:93847637563c4b67e327a255e7fc44b5', 23);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1394475472405-24', '2.0.5', '3:ce13897eded2c58e2a26b246c712fc9b', 24);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1394475472405-25', '2.0.5', '3:78c450b4fde01d64fedb731204a700a4', 25);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1394475472405-26', '2.0.5', '3:cafc06f44f9228ea4f2f20969d9c2b9a', 26);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1394475472405-27', '2.0.5', '3:6b128822e35f1bfdf62764eebd67795d', 27);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1394475472405-28', '2.0.5', '3:02ebb8194449f54c478ae4041aea75de', 28);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1394475472405-29', '2.0.5', '3:08455bd7b2ae280103b42a694ae05440', 29);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1394475472405-30', '2.0.5', '3:29340e66d8eccad29425993ca6ddfd66', 30);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Create Table', 'EXECUTED', 'changelog.groovy', '1394475472405-31', '2.0.5', '3:7dfb81face9d48b057aab552ccd99a3a', 31);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Add Primary Key', 'EXECUTED', 'changelog.groovy', '1394475472405-32', '2.0.5', '3:db84f74203c5c088301dab67078b42f1', 32);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Add Primary Key', 'EXECUTED', 'changelog.groovy', '1394475472405-33', '2.0.5', '3:417cd3c88e8d4aa2f8515c468dce3766', 33);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1394475472405-57', '2.0.5', '3:808d35bb1962807617cbad02c09193be', 34);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1394475472405-58', '2.0.5', '3:62c1caf9be52b3accc2cfad28bcf2edb', 35);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1394475472405-59', '2.0.5', '3:892598362f413f3aa0b36b9f1476e67c', 36);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1394475472405-60', '2.0.5', '3:909a924feb27444bb1463f7ad8c180b1', 37);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1394475472405-61', '2.0.5', '3:3ee09382d44bb1f5db5b11df76ea52e5', 38);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Create Index', 'EXECUTED', 'changelog.groovy', '1394475472405-62', '2.0.5', '3:75be88e2445cf685c6f181e76d5b1982', 39);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1394475472405-34', '2.0.5', '3:0341a28959ac38e46ac1ae4cbc87ec56', 40);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1394475472405-35', '2.0.5', '3:c67752423a63912049b612d5370819fe', 41);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1394475472405-36', '2.0.5', '3:66d0e1577d5affdd06490fde58a28e27', 42);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1394475472405-37', '2.0.5', '3:55143727def438707123318a8acca350', 43);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1394475472405-38', '2.0.5', '3:ff04413efcdf64301e58374f32480e64', 44);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1394475472405-39', '2.0.5', '3:66885f84494e39fd9d1033d98b2c6552', 45);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1394475472405-40', '2.0.5', '3:a21a03abf1a0e7e82a69484ff266e63c', 46);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1394475472405-41', '2.0.5', '3:83e1afe8b8a9c5d3d86da58f6e71e4c6', 47);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1394475472405-42', '2.0.5', '3:598187d9f53301ee73bb71c23735094c', 48);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1394475472405-43', '2.0.5', '3:5e899d52b132e0c6c69ad2cb1d28cb4b', 49);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1394475472405-44', '2.0.5', '3:5667259c5d2d1e0582bd95fc6fabed72', 50);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1394475472405-45', '2.0.5', '3:41ca1eec7f7883b62ea2f423c2897eb2', 51);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1394475472405-46', '2.0.5', '3:7dcb374b571782d71827ffd7c5f94a4b', 52);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1394475472405-47', '2.0.5', '3:c566a3ca1547ef61081d6ed860bb5717', 53);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1394475472405-48', '2.0.5', '3:3899ef1f7663496ac2dff7a993c4ef6b', 54);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1394475472405-49', '2.0.5', '3:1d2301e7f1531fa4a56f55ca3b377a28', 55);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1394475472405-50', '2.0.5', '3:10516332e4dea4cc160d6bb92b3574a9', 56);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1394475472405-51', '2.0.5', '3:5f1428ad31589b81a2c26290ba40eff6', 57);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1394475472405-52', '2.0.5', '3:f9ae363ddcf122aaf7010f872bbfce05', 58);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1394475472405-53', '2.0.5', '3:dc1a4defa199ced2a823691148875eb6', 59);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1394475472405-54', '2.0.5', '3:32bef9f434f669b7be517b0a7b815942', 60);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1394475472405-55', '2.0.5', '3:56a09960243e05da77ce89feb4676ceb', 61);

INSERT INTO `DATABASECHANGELOG` (`AUTHOR`, `COMMENTS`, `DATEEXECUTED`, `DESCRIPTION`, `EXECTYPE`, `FILENAME`, `ID`, `LIQUIBASE`, `MD5SUM`, `ORDEREXECUTED`) VALUES ('vlad (generated)', '', NOW(), 'Add Foreign Key Constraint', 'EXECUTED', 'changelog.groovy', '1394475472405-56', '2.0.5', '3:cb40db1c365b12a90aeec24029f9977a', 62);

