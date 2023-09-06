CREATE DATABASE Main;
USE Main;

-- POS.dbo.DH1582 definition

-- Drop table

-- DROP TABLE POS.dbo.DH1582;

CREATE TABLE DH1582 (
                        IDDOC char(9)  NOT NULL,
                        SP3333 char(9)  NOT NULL,
                        SP1559 char(13)  NOT NULL,
                        SP1565 char(9)  NOT NULL,
                        SP1555 char(9)  NOT NULL,
                        SP1556 char(9)  NOT NULL,
                        SP1557 char(9)  NOT NULL,
                        SP1558 numeric(9,4) NOT NULL,
                        SP1561 numeric(1,0) NOT NULL,
                        SP1562 numeric(1,0) NOT NULL,
                        SP1563 numeric(1,0) NOT NULL,
                        SP1564 numeric(1,0) NOT NULL,
                        SP1567 char(9)  NOT NULL,
                        SP1566 numeric(14,2) NOT NULL,
                        SP1995 char(15)  NOT NULL,
                        SP2266 datetime NOT NULL,
                        SP1560 datetime NOT NULL,
                        SP7825 numeric(1,0) NOT NULL,
                        SP1574 numeric(14,2) NOT NULL,
                        SP1575 numeric(14,2) NOT NULL,
                        SP1576 numeric(14,2) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH1582 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH1611 definition

-- Drop table

-- DROP TABLE POS.dbo.DH1611;

CREATE TABLE DH1611 (
                        IDDOC char(9)  NOT NULL,
                        SP3338 char(9)  NOT NULL,
                        SP1587 char(13)  NOT NULL,
                        SP1593 char(9)  NOT NULL,
                        SP1583 char(9)  NOT NULL,
                        SP1584 char(9)  NOT NULL,
                        SP1585 char(9)  NOT NULL,
                        SP1586 numeric(9,4) NOT NULL,
                        SP1589 numeric(1,0) NOT NULL,
                        SP1590 numeric(1,0) NOT NULL,
                        SP1591 numeric(1,0) NOT NULL,
                        SP1592 numeric(1,0) NOT NULL,
                        SP1595 char(9)  NOT NULL,
                        SP1596 char(9)  NOT NULL,
                        SP1594 numeric(14,2) NOT NULL,
                        SP1588 datetime NOT NULL,
                        SP7550 numeric(1,0) NOT NULL,
                        SP1604 numeric(14,2) NOT NULL,
                        SP1605 numeric(14,2) NOT NULL,
                        SP1606 numeric(14,2) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH1611 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH1628 definition

-- Drop table

-- DROP TABLE POS.dbo.DH1628;

CREATE TABLE DH1628 (
                        IDDOC char(9)  NOT NULL,
                        SP1619 char(13)  NOT NULL,
                        SP3078 char(9)  NOT NULL,
                        SP4855 char(9)  NOT NULL,
                        SP1615 char(9)  NOT NULL,
                        SP1612 char(9)  NOT NULL,
                        SP1613 numeric(9,4) NOT NULL,
                        SP1616 char(9)  NOT NULL,
                        SP3910 numeric(1,0) NOT NULL,
                        SP3911 numeric(1,0) NOT NULL,
                        SP3912 numeric(1,0) NOT NULL,
                        SP3913 numeric(1,0) NOT NULL,
                        SP1625 numeric(14,2) NOT NULL,
                        SP3915 numeric(14,2) NOT NULL,
                        SP3917 numeric(14,2) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH1628 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH1656 definition

-- Drop table

-- DROP TABLE POS.dbo.DH1656;

CREATE TABLE DH1656 (
                        IDDOC char(9)  NOT NULL,
                        SP3340 char(9)  NOT NULL,
                        SP1633 char(13)  NOT NULL,
                        SP1639 char(9)  NOT NULL,
                        SP1629 char(9)  NOT NULL,
                        SP1630 char(9)  NOT NULL,
                        SP1631 char(9)  NOT NULL,
                        SP1632 numeric(9,4) NOT NULL,
                        SP1635 numeric(1,0) NOT NULL,
                        SP1636 numeric(1,0) NOT NULL,
                        SP1637 numeric(1,0) NOT NULL,
                        SP1638 numeric(1,0) NOT NULL,
                        SP6089 numeric(1,0) NOT NULL,
                        SP1641 char(9)  NOT NULL,
                        SP7320 char(9)  NOT NULL,
                        SP1640 numeric(14,2) NOT NULL,
                        SP1634 datetime NOT NULL,
                        SP6397 char(50)  NOT NULL,
                        SP1649 numeric(14,2) NOT NULL,
                        SP1650 numeric(14,2) NOT NULL,
                        SP1651 numeric(14,2) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH1656 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH1684 definition

-- Drop table

-- DROP TABLE POS.dbo.DH1684;

CREATE TABLE DH1684 (
                        IDDOC char(9)  NOT NULL,
                        SP3336 char(9)  NOT NULL,
                        SP1661 char(13)  NOT NULL,
                        SP1667 char(9)  NOT NULL,
                        SP1657 char(9)  NOT NULL,
                        SP1658 char(9)  NOT NULL,
                        SP1659 char(9)  NOT NULL,
                        SP1660 numeric(9,4) NOT NULL,
                        SP1663 numeric(1,0) NOT NULL,
                        SP1664 numeric(1,0) NOT NULL,
                        SP1665 numeric(1,0) NOT NULL,
                        SP1666 numeric(1,0) NOT NULL,
                        SP1668 numeric(14,2) NOT NULL,
                        SP1669 char(9)  NOT NULL,
                        SP1662 datetime NOT NULL,
                        SP6486 char(50)  NOT NULL,
                        SP1677 numeric(14,2) NOT NULL,
                        SP1678 numeric(14,2) NOT NULL,
                        SP1679 numeric(14,2) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH1684 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH1731 definition

-- Drop table

-- DROP TABLE POS.dbo.DH1731;

CREATE TABLE DH1731 (
                        IDDOC char(9)  NOT NULL,
                        SP2563 char(9)  NOT NULL,
                        SP1742 char(10)  NOT NULL,
                        SP1735 char(9)  NOT NULL,
                        SP1732 char(13)  NOT NULL,
                        SP7927 char(7)  NOT NULL,
                        SP7928 char(11)  NOT NULL,
                        SP1734 char(9)  NOT NULL,
                        SP1741 numeric(1,0) NOT NULL,
                        SP7929 numeric(1,0) NOT NULL,
                        SP7930 datetime NOT NULL,
                        SP7931 char(18)  NOT NULL,
                        SP7932 char(2)  NOT NULL,
                        SP7933 char(10)  NOT NULL,
                        SP7934 char(2)  NOT NULL,
                        SP7989 char(12)  NOT NULL,
                        SP7990 char(10)  NOT NULL,
                        SP7991 char(12)  NOT NULL,
                        SP7992 char(10)  NOT NULL,
                        SP1738 char(9)  NOT NULL,
                        SP7935 char(2)  NOT NULL,
                        SP1737 numeric(14,2) NOT NULL,
                        SP3224 char(9)  NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP1740 text  NULL,
                        SP3223 text  NULL,
                        SP3225 text  NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH1731 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH1774 definition

-- Drop table

-- DROP TABLE POS.dbo.DH1774;

CREATE TABLE DH1774 (
                        IDDOC char(9)  NOT NULL,
                        SP1755 char(13)  NOT NULL,
                        SP1751 char(9)  NOT NULL,
                        SP1752 char(9)  NOT NULL,
                        SP1753 char(9)  NOT NULL,
                        SP1754 numeric(9,4) NOT NULL,
                        SP1757 numeric(1,0) NOT NULL,
                        SP1758 numeric(1,0) NOT NULL,
                        SP1761 char(9)  NOT NULL,
                        SP1760 numeric(14,2) NOT NULL,
                        SP3678 char(15)  NOT NULL,
                        SP3679 datetime NOT NULL,
                        SP1756 datetime NOT NULL,
                        SP7815 numeric(1,0) NOT NULL,
                        SP1769 numeric(14,2) NOT NULL,
                        SP1770 numeric(14,2) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH1774 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH1790 definition

-- Drop table

-- DROP TABLE POS.dbo.DH1790;

CREATE TABLE DH1790 (
                        IDDOC char(9)  NOT NULL,
                        SP1780 char(13)  NOT NULL,
                        SP1777 char(9)  NOT NULL,
                        SP1775 char(9)  NOT NULL,
                        SP1776 numeric(9,4) NOT NULL,
                        SP3859 char(23)  NOT NULL,
                        TSP3859 char(3)  NOT NULL,
                        SP3860 char(23)  NOT NULL,
                        TSP3860 char(3)  NOT NULL,
                        SP3861 char(23)  NOT NULL,
                        TSP3861 char(3)  NOT NULL,
                        SP3862 char(23)  NOT NULL,
                        TSP3862 char(3)  NOT NULL,
                        SP7770 char(23)  NOT NULL,
                        TSP7770 char(3)  NOT NULL,
                        SP7771 char(23)  NOT NULL,
                        TSP7771 char(3)  NOT NULL,
                        SP7772 char(23)  NOT NULL,
                        TSP7772 char(3)  NOT NULL,
                        SP7773 char(23)  NOT NULL,
                        TSP7773 char(3)  NOT NULL,
                        SP1787 numeric(14,2) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH1790 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH2051 definition

-- Drop table

-- DROP TABLE POS.dbo.DH2051;

CREATE TABLE DH2051 (
                        IDDOC char(9)  NOT NULL,
                        SP2034 char(9)  NOT NULL,
                        SP2035 char(9)  NOT NULL,
                        SP2038 char(13)  NOT NULL,
                        SP4394 numeric(1,0) NOT NULL,
                        SP4395 numeric(1,0) NOT NULL,
                        SP4396 numeric(1,0) NOT NULL,
                        SP4397 numeric(1,0) NOT NULL,
                        SP4398 numeric(1,0) NOT NULL,
                        SP4399 numeric(1,0) NOT NULL,
                        SP4400 char(10)  NOT NULL,
                        SP4401 datetime NOT NULL,
                        SP2036 char(9)  NOT NULL,
                        SP2037 numeric(9,4) NOT NULL,
                        SP7847 numeric(1,0) NOT NULL,
                        SP2043 numeric(14,2) NOT NULL,
                        SP2044 numeric(14,2) NOT NULL,
                        SP2045 numeric(14,2) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH2051 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH2075 definition

-- Drop table

-- DROP TABLE POS.dbo.DH2075;

CREATE TABLE DH2075 (
                        IDDOC char(9)  NOT NULL,
                        SP7763 char(9)  NOT NULL,
                        SP2056 char(13)  NOT NULL,
                        SP2052 char(9)  NOT NULL,
                        SP2053 char(9)  NOT NULL,
                        SP2054 char(9)  NOT NULL,
                        SP2055 numeric(9,4) NOT NULL,
                        SP2058 numeric(1,0) NOT NULL,
                        SP2059 numeric(1,0) NOT NULL,
                        SP2060 numeric(1,0) NOT NULL,
                        SP2061 numeric(1,0) NOT NULL,
                        SP2062 numeric(14,2) NOT NULL,
                        SP2063 char(15)  NOT NULL,
                        SP2761 datetime NOT NULL,
                        SP2057 datetime NOT NULL,
                        SP7821 numeric(1,0) NOT NULL,
                        SP2067 numeric(14,2) NOT NULL,
                        SP2068 numeric(14,2) NOT NULL,
                        SP2069 numeric(14,2) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH2075 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH2106 definition

-- Drop table

-- DROP TABLE POS.dbo.DH2106;

CREATE TABLE DH2106 (
                        IDDOC char(9)  NOT NULL,
                        SP2093 char(13)  NOT NULL,
                        SP2094 char(9)  NOT NULL,
                        SP2091 char(9)  NOT NULL,
                        SP2092 numeric(9,4) NOT NULL,
                        SP2095 char(9)  NOT NULL,
                        SP3854 char(23)  NOT NULL,
                        TSP3854 char(3)  NOT NULL,
                        SP3855 char(23)  NOT NULL,
                        TSP3855 char(3)  NOT NULL,
                        SP3856 char(23)  NOT NULL,
                        TSP3856 char(3)  NOT NULL,
                        SP3857 char(23)  NOT NULL,
                        TSP3857 char(3)  NOT NULL,
                        SP2103 numeric(14,2) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH2106 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH2196 definition

-- Drop table

-- DROP TABLE POS.dbo.DH2196;

CREATE TABLE DH2196 (
                        IDDOC char(9)  NOT NULL,
                        SP2197 char(13)  NOT NULL,
                        SP2201 char(9)  NOT NULL,
                        SP3319 char(9)  NOT NULL,
                        SP3320 char(9)  NOT NULL,
                        SP3321 char(9)  NOT NULL,
                        SP3322 char(9)  NOT NULL,
                        SP2198 char(9)  NOT NULL,
                        SP2199 numeric(9,4) NOT NULL,
                        SP2203 numeric(14,2) NOT NULL,
                        SP2205 char(9)  NOT NULL,
                        SP2200 numeric(1,0) NOT NULL,
                        SP2206 char(9)  NOT NULL,
                        SP2204 numeric(14,2) NOT NULL,
                        SP2208 char(80)  NOT NULL,
                        SP2207 char(64)  NOT NULL,
                        SP2209 char(150)  NOT NULL,
                        SP3876 char(23)  NOT NULL,
                        TSP3876 char(3)  NOT NULL,
                        SP3877 char(23)  NOT NULL,
                        TSP3877 char(3)  NOT NULL,
                        SP3878 char(23)  NOT NULL,
                        TSP3878 char(3)  NOT NULL,
                        SP3879 char(23)  NOT NULL,
                        TSP3879 char(3)  NOT NULL,
                        SP4265 char(9)  NOT NULL,
                        SP7819 numeric(1,0) NOT NULL,
                        SP8880 numeric(4,0) NOT NULL,
                        SP8881 char(30)  NOT NULL,
                        SP8882 char(9)  NOT NULL,
                        SP8883 char(9)  NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH2196 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH2225 definition

-- Drop table

-- DROP TABLE POS.dbo.DH2225;

CREATE TABLE DH2225 (
                        IDDOC char(9)  NOT NULL,
                        SP2226 char(13)  NOT NULL,
                        SP2230 char(9)  NOT NULL,
                        SP3325 char(9)  NOT NULL,
                        SP3326 char(9)  NOT NULL,
                        SP3327 char(9)  NOT NULL,
                        SP3328 char(9)  NOT NULL,
                        SP2227 char(9)  NOT NULL,
                        SP2228 numeric(9,4) NOT NULL,
                        SP2232 numeric(14,2) NOT NULL,
                        SP2229 numeric(1,0) NOT NULL,
                        SP2233 numeric(14,2) NOT NULL,
                        SP2237 char(80)  NOT NULL,
                        SP2236 char(64)  NOT NULL,
                        SP2238 char(150)  NOT NULL,
                        SP3881 char(23)  NOT NULL,
                        TSP3881 char(3)  NOT NULL,
                        SP3882 char(23)  NOT NULL,
                        TSP3882 char(3)  NOT NULL,
                        SP3883 char(23)  NOT NULL,
                        TSP3883 char(3)  NOT NULL,
                        SP3884 char(23)  NOT NULL,
                        TSP3884 char(3)  NOT NULL,
                        SP4267 char(9)  NOT NULL,
                        SP8885 numeric(4,0) NOT NULL,
                        SP8886 char(30)  NOT NULL,
                        SP8887 char(9)  NOT NULL,
                        SP8888 char(9)  NOT NULL,
                        SP8889 char(30)  NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP7749 text  NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH2225 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH2320 definition

-- Drop table

-- DROP TABLE POS.dbo.DH2320;

CREATE TABLE DH2320 (
                        IDDOC char(9)  NOT NULL,
                        SP3416 char(9)  NOT NULL,
                        SP3080 char(9)  NOT NULL,
                        SP2385 char(9)  NOT NULL,
                        SP3015 char(9)  NOT NULL,
                        SP2306 char(9)  NOT NULL,
                        SP2307 numeric(13,3) NOT NULL,
                        SP2308 char(9)  NOT NULL,
                        SP2309 numeric(9,3) NOT NULL,
                        SP2310 char(9)  NOT NULL,
                        SP3768 numeric(14,2) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH2320 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH2457 definition

-- Drop table

-- DROP TABLE POS.dbo.DH2457;

CREATE TABLE DH2457 (
                        IDDOC char(9)  NOT NULL,
                        SP4433 char(13)  NOT NULL,
                        SP2621 char(9)  NOT NULL,
                        SP2434 char(9)  NOT NULL,
                        SP2435 char(9)  NOT NULL,
                        SP2436 char(9)  NOT NULL,
                        SP2437 numeric(9,4) NOT NULL,
                        SP2439 numeric(1,0) NOT NULL,
                        SP2440 numeric(1,0) NOT NULL,
                        SP2441 numeric(1,0) NOT NULL,
                        SP2442 numeric(1,0) NOT NULL,
                        SP2443 numeric(14,2) NOT NULL,
                        SP2444 char(9)  NOT NULL,
                        SP2445 char(9)  NOT NULL,
                        SP2438 datetime NOT NULL,
                        SP4434 datetime NOT NULL,
                        SP4437 char(9)  NOT NULL,
                        SP4760 char(9)  NOT NULL,
                        SP7943 char(9)  NOT NULL,
                        SP2451 numeric(14,2) NOT NULL,
                        SP2452 numeric(14,2) NOT NULL,
                        SP2453 numeric(14,2) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH2457 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH2695 definition

-- Drop table

-- DROP TABLE POS.dbo.DH2695;

CREATE TABLE DH2695 (
                        IDDOC char(9)  NOT NULL,
                        SP3481 char(15)  NOT NULL,
                        SP3482 datetime NOT NULL,
                        SP2691 char(9)  NOT NULL,
                        SP2692 char(9)  NOT NULL,
                        SP2693 char(13)  NOT NULL,
                        SP3483 numeric(1,0) NOT NULL,
                        SP5395 char(9)  NOT NULL,
                        SP5396 numeric(9,4) NOT NULL,
                        SP7849 numeric(1,0) NOT NULL,
                        SP4145 numeric(14,2) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH2695 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH2742 definition

-- Drop table

-- DROP TABLE POS.dbo.DH2742;

CREATE TABLE DH2742 (
                        IDDOC char(9)  NOT NULL,
                        SP2730 char(13)  NOT NULL,
                        SP2719 char(9)  NOT NULL,
                        SP2720 char(9)  NOT NULL,
                        SP2721 char(9)  NOT NULL,
                        SP2722 numeric(9,4) NOT NULL,
                        SP2724 numeric(1,0) NOT NULL,
                        SP2725 numeric(1,0) NOT NULL,
                        SP2726 numeric(1,0) NOT NULL,
                        SP2727 numeric(1,0) NOT NULL,
                        SP2729 char(9)  NOT NULL,
                        SP2728 numeric(14,2) NOT NULL,
                        SP2723 datetime NOT NULL,
                        SP4439 datetime NOT NULL,
                        SP2736 numeric(14,2) NOT NULL,
                        SP2737 numeric(14,2) NOT NULL,
                        SP2738 numeric(14,2) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH2742 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH2827 definition

-- Drop table

-- DROP TABLE POS.dbo.DH2827;

CREATE TABLE DH2827 (
                        IDDOC char(9)  NOT NULL,
                        SP2811 char(9)  NOT NULL,
                        SP2812 char(9)  NOT NULL,
                        SP2813 char(9)  NOT NULL,
                        SP2814 numeric(9,4) NOT NULL,
                        SP2817 numeric(14,2) NOT NULL,
                        SP2816 datetime NOT NULL,
                        SP5032 char(9)  NOT NULL,
                        SP5033 numeric(5,2) NOT NULL,
                        SP5034 numeric(1,0) NOT NULL,
                        SP6462 char(9)  NOT NULL,
                        SP7817 numeric(1,0) NOT NULL,
                        SP2824 numeric(14,2) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH2827 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH2988 definition

-- Drop table

-- DROP TABLE POS.dbo.DH2988;

CREATE TABLE DH2988 (
                        IDDOC char(9)  NOT NULL,
                        SP3427 char(9)  NOT NULL,
                        SP2972 char(9)  NOT NULL,
                        SP2969 char(9)  NOT NULL,
                        SP2970 numeric(9,4) NOT NULL,
                        SP2973 char(9)  NOT NULL,
                        SP2975 numeric(1,0) NOT NULL,
                        SP2976 numeric(1,0) NOT NULL,
                        SP3682 numeric(1,0) NOT NULL,
                        SP3683 numeric(1,0) NOT NULL,
                        SP3684 char(50)  NOT NULL,
                        SP3685 char(15)  NOT NULL,
                        SP3686 datetime NOT NULL,
                        SP7835 numeric(1,0) NOT NULL,
                        SP2983 numeric(14,2) NOT NULL,
                        SP2985 numeric(14,2) NOT NULL,
                        SP3688 numeric(14,2) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH2988 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH2998 definition

-- Drop table

-- DROP TABLE POS.dbo.DH2998;

CREATE TABLE DH2998 (
                        IDDOC char(9)  NOT NULL,
                        SP3422 char(9)  NOT NULL,
                        SP2989 char(9)  NOT NULL,
                        SP2990 numeric(9,4) NOT NULL,
                        SP3690 char(50)  NOT NULL,
                        SP3691 char(15)  NOT NULL,
                        SP3692 datetime NOT NULL,
                        SP2993 numeric(14,2) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH2998 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH3046 definition

-- Drop table

-- DROP TABLE POS.dbo.DH3046;

CREATE TABLE DH3046 (
                        IDDOC char(9)  NOT NULL,
                        SP3027 char(9)  NOT NULL,
                        SP4368 char(9)  NOT NULL,
                        SP8592 datetime NOT NULL,
                        SP8116 char(13)  NOT NULL,
                        SP4369 char(13)  NOT NULL,
                        SP3361 char(9)  NOT NULL,
                        SP8178 numeric(14,2) NOT NULL,
                        SP8179 numeric(14,2) NOT NULL,
                        SP3028 numeric(9,4) NOT NULL,
                        SP8593 numeric(1,0) NOT NULL,
                        SP8177 numeric(14,2) NOT NULL,
                        SP3036 numeric(10,0) NOT NULL,
                        SP8245 char(139)  NOT NULL,
                        SP3034 numeric(16,2) NOT NULL,
                        SP8115 char(9)  NOT NULL,
                        SP8180 numeric(1,0) NOT NULL,
                        SP4261 char(9)  NOT NULL,
                        SP3029 char(9)  NOT NULL,
                        SP8132 char(9)  NOT NULL,
                        SP3037 numeric(1,0) NOT NULL,
                        SP8594 numeric(1,0) NOT NULL,
                        SP8722 numeric(1,0) NOT NULL,
                        SP9031 char(20)  NOT NULL,
                        SP9032 char(20)  NOT NULL,
                        SP9033 numeric(10,0) NOT NULL,
                        SP9034 numeric(10,0) NOT NULL,
                        SP9052 char(17)  NOT NULL,
                        SP9053 char(100)  NOT NULL,
                        SP9073 numeric(11,2) NOT NULL,
                        SP9074 char(40)  NOT NULL,
                        SP9085 char(20)  NOT NULL,
                        SP9086 char(20)  NOT NULL,
                        SP9087 char(20)  NOT NULL,
                        SP9088 char(20)  NOT NULL,
                        SP9089 char(20)  NOT NULL,
                        SP9090 char(20)  NOT NULL,
                        SP9091 char(20)  NOT NULL,
                        SP9130 char(50)  NOT NULL,
                        SP9185 char(9)  NOT NULL,
                        SP9186 char(50)  NOT NULL,
                        SP9187 char(9)  NOT NULL,
                        SP9188 char(9)  NOT NULL,
                        SP9209 char(9)  NOT NULL,
                        SP3040 numeric(13,3) NOT NULL,
                        SP3044 numeric(14,2) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH3046 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH3089 definition

-- Drop table

-- DROP TABLE POS.dbo.DH3089;

CREATE TABLE DH3089 (
                        IDDOC char(9)  NOT NULL,
                        SP3424 char(9)  NOT NULL,
                        SP3082 char(9)  NOT NULL,
                        SP3083 numeric(9,4) NOT NULL,
                        SP3695 char(50)  NOT NULL,
                        SP3696 char(15)  NOT NULL,
                        SP3697 datetime NOT NULL,
                        SP4198 numeric(1,0) NOT NULL,
                        SP4199 numeric(1,0) NOT NULL,
                        SP4200 numeric(1,0) NOT NULL,
                        SP4201 numeric(1,0) NOT NULL,
                        SP7845 numeric(1,0) NOT NULL,
                        SP3086 numeric(14,2) NOT NULL,
                        SP4183 numeric(14,2) NOT NULL,
                        SP4185 numeric(14,2) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH3089 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH3114 definition

-- Drop table

-- DROP TABLE POS.dbo.DH3114;

CREATE TABLE DH3114 (
                        IDDOC char(9)  NOT NULL,
                        SP3093 char(9)  NOT NULL,
                        SP3363 char(9)  NOT NULL,
                        SP3091 char(9)  NOT NULL,
                        SP3092 numeric(9,4) NOT NULL,
                        SP4256 numeric(1,0) NOT NULL,
                        SP3097 numeric(1,0) NOT NULL,
                        SP3099 numeric(1,0) NOT NULL,
                        SP3098 numeric(1,0) NOT NULL,
                        SP3100 numeric(1,0) NOT NULL,
                        SP6994 char(9)  NOT NULL,
                        SP3658 char(13)  NOT NULL,
                        SP3659 char(9)  NOT NULL,
                        SP4298 char(9)  NOT NULL,
                        SP4690 char(9)  NOT NULL,
                        SP5150 char(9)  NOT NULL,
                        SP5384 char(10)  NOT NULL,
                        SP7548 numeric(1,0) NOT NULL,
                        SP3107 numeric(14,2) NOT NULL,
                        SP3109 numeric(14,2) NOT NULL,
                        SP3111 numeric(14,2) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH3114 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH3259 definition

-- Drop table

-- DROP TABLE POS.dbo.DH3259;

CREATE TABLE DH3259 (
                        IDDOC char(9)  NOT NULL,
                        SP3245 char(13)  NOT NULL,
                        SP3246 char(9)  NOT NULL,
                        SP3247 char(9)  NOT NULL,
                        SP3248 char(9)  NOT NULL,
                        SP3249 char(9)  NOT NULL,
                        SP3250 char(9)  NOT NULL,
                        SP3251 numeric(9,4) NOT NULL,
                        SP3252 numeric(14,2) NOT NULL,
                        SP3254 numeric(1,0) NOT NULL,
                        SP3256 numeric(14,2) NOT NULL,
                        SP3866 char(23)  NOT NULL,
                        TSP3866 char(3)  NOT NULL,
                        SP3867 char(23)  NOT NULL,
                        TSP3867 char(3)  NOT NULL,
                        SP3868 char(23)  NOT NULL,
                        TSP3868 char(3)  NOT NULL,
                        SP3869 char(23)  NOT NULL,
                        TSP3869 char(3)  NOT NULL,
                        SP4269 char(9)  NOT NULL,
                        SP7837 numeric(1,0) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP6656 text  NULL,
                        SP6659 text  NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH3259 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH3274 definition

-- Drop table

-- DROP TABLE POS.dbo.DH3274;

CREATE TABLE DH3274 (
                        IDDOC char(9)  NOT NULL,
                        SP3260 char(13)  NOT NULL,
                        SP3261 char(9)  NOT NULL,
                        SP3262 char(9)  NOT NULL,
                        SP3263 char(9)  NOT NULL,
                        SP3264 char(9)  NOT NULL,
                        SP3265 char(9)  NOT NULL,
                        SP3266 numeric(9,4) NOT NULL,
                        SP3267 numeric(14,2) NOT NULL,
                        SP3269 numeric(1,0) NOT NULL,
                        SP3271 numeric(14,2) NOT NULL,
                        SP3871 char(23)  NOT NULL,
                        TSP3871 char(3)  NOT NULL,
                        SP3872 char(23)  NOT NULL,
                        TSP3872 char(3)  NOT NULL,
                        SP3873 char(23)  NOT NULL,
                        TSP3873 char(3)  NOT NULL,
                        SP3874 char(23)  NOT NULL,
                        TSP3874 char(3)  NOT NULL,
                        SP4271 char(9)  NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP6657 text  NULL,
                        SP6658 text  NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH3274 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH3311 definition

-- Drop table

-- DROP TABLE POS.dbo.DH3311;

CREATE TABLE DH3311 (
                        IDDOC char(9)  NOT NULL,
                        SP3280 char(13)  NOT NULL,
                        SP3281 char(9)  NOT NULL,
                        SP3282 char(9)  NOT NULL,
                        SP3283 char(9)  NOT NULL,
                        SP3284 char(9)  NOT NULL,
                        SP3285 numeric(9,4) NOT NULL,
                        SP3286 char(9)  NOT NULL,
                        SP3287 numeric(14,2) NOT NULL,
                        SP3289 datetime NOT NULL,
                        SP3290 char(15)  NOT NULL,
                        SP3291 datetime NOT NULL,
                        SP3292 char(9)  NOT NULL,
                        SP3293 char(9)  NOT NULL,
                        SP3294 numeric(14,2) NOT NULL,
                        SP3295 char(9)  NOT NULL,
                        SP3296 numeric(14,2) NOT NULL,
                        SP3349 numeric(14,2) NOT NULL,
                        SP7355 numeric(1,0) NOT NULL,
                        SP7356 numeric(1,0) NOT NULL,
                        SP7827 numeric(1,0) NOT NULL,
                        SP3303 numeric(14,2) NOT NULL,
                        SP3305 numeric(14,2) NOT NULL,
                        SP3307 numeric(14,2) NOT NULL,
                        SP3309 numeric(14,2) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH3311 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH3504 definition

-- Drop table

-- DROP TABLE POS.dbo.DH3504;

CREATE TABLE DH3504 (
                        IDDOC char(9)  NOT NULL,
                        SP3494 char(13)  NOT NULL,
                        SP3501 char(50)  NOT NULL,
                        SP3502 char(25)  NOT NULL,
                        SP4359 char(9)  NOT NULL,
                        SP4360 char(9)  NOT NULL,
                        SP4150 numeric(14,2) NOT NULL,
                        SP4152 numeric(14,2) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH3504 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH3521 definition

-- Drop table

-- DROP TABLE POS.dbo.DH3521;

CREATE TABLE DH3521 (
                        IDDOC char(9)  NOT NULL,
                        SP3505 datetime NOT NULL,
                        SP3506 char(9)  NOT NULL,
                        SP3507 char(9)  NOT NULL,
                        SP3508 char(9)  NOT NULL,
                        SP3509 char(13)  NOT NULL,
                        SP3510 char(9)  NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP6425 text  NULL,
                        SP6639 text  NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH3521 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH3592 definition

-- Drop table

-- DROP TABLE POS.dbo.DH3592;

CREATE TABLE DH3592 (
                        IDDOC char(9)  NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH3592 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH3614 definition

-- Drop table

-- DROP TABLE POS.dbo.DH3614;

CREATE TABLE DH3614 (
                        IDDOC char(9)  NOT NULL,
                        SP3593 char(13)  NOT NULL,
                        SP7154 char(9)  NOT NULL,
                        SP3594 char(9)  NOT NULL,
                        SP3595 char(9)  NOT NULL,
                        SP3596 char(9)  NOT NULL,
                        SP3597 numeric(9,4) NOT NULL,
                        SP3598 numeric(1,0) NOT NULL,
                        SP3599 numeric(1,0) NOT NULL,
                        SP3600 numeric(1,0) NOT NULL,
                        SP3601 numeric(1,0) NOT NULL,
                        SP3602 numeric(14,2) NOT NULL,
                        SP3603 datetime NOT NULL,
                        SP7831 numeric(1,0) NOT NULL,
                        SP3606 numeric(14,2) NOT NULL,
                        SP3608 numeric(14,2) NOT NULL,
                        SP3610 numeric(14,2) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH3614 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH3638 definition

-- Drop table

-- DROP TABLE POS.dbo.DH3638;

CREATE TABLE DH3638 (
                        IDDOC char(9)  NOT NULL,
                        SP3615 char(9)  NOT NULL,
                        SP3616 char(9)  NOT NULL,
                        SP3617 char(9)  NOT NULL,
                        SP3618 numeric(9,4) NOT NULL,
                        SP3621 numeric(1,0) NOT NULL,
                        SP3622 numeric(1,0) NOT NULL,
                        SP3623 numeric(1,0) NOT NULL,
                        SP3624 numeric(1,0) NOT NULL,
                        SP3625 numeric(14,2) NOT NULL,
                        SP3626 char(15)  NOT NULL,
                        SP3627 datetime NOT NULL,
                        SP3620 datetime NOT NULL,
                        SP7843 numeric(1,0) NOT NULL,
                        SP3630 numeric(14,2) NOT NULL,
                        SP3631 numeric(14,2) NOT NULL,
                        SP3632 numeric(14,2) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH3638 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH3725 definition

-- Drop table

-- DROP TABLE POS.dbo.DH3725;

CREATE TABLE DH3725 (
                        IDDOC char(9)  NOT NULL,
                        SP3715 char(9)  NOT NULL,
                        SP3710 char(9)  NOT NULL,
                        SP3711 char(9)  NOT NULL,
                        SP3712 numeric(9,4) NOT NULL,
                        SP3722 numeric(14,2) NOT NULL,
                        SP3723 numeric(14,2) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH3725 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH3790 definition

-- Drop table

-- DROP TABLE POS.dbo.DH3790;

CREATE TABLE DH3790 (
                        IDDOC char(9)  NOT NULL,
                        SP3775 char(9)  NOT NULL,
                        SP3776 char(9)  NOT NULL,
                        SP3777 char(9)  NOT NULL,
                        SP3778 char(15)  NOT NULL,
                        SP3779 datetime NOT NULL,
                        SP3780 datetime NOT NULL,
                        SP6341 numeric(1,0) NOT NULL,
                        SP3782 numeric(14,2) NOT NULL,
                        SP3783 numeric(14,2) NOT NULL,
                        SP3784 numeric(14,2) NOT NULL,
                        SP3786 numeric(14,2) NOT NULL,
                        SP3788 numeric(14,2) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH3790 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH3805 definition

-- Drop table

-- DROP TABLE POS.dbo.DH3805;

CREATE TABLE DH3805 (
                        IDDOC char(9)  NOT NULL,
                        SP3791 char(9)  NOT NULL,
                        SP3792 char(9)  NOT NULL,
                        SP3793 char(9)  NOT NULL,
                        SP3794 datetime NOT NULL,
                        SP6338 numeric(1,0) NOT NULL,
                        SP3796 numeric(14,2) NOT NULL,
                        SP3797 numeric(14,2) NOT NULL,
                        SP3798 numeric(14,2) NOT NULL,
                        SP3800 numeric(14,2) NOT NULL,
                        SP3802 numeric(14,2) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH3805 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH3813 definition

-- Drop table

-- DROP TABLE POS.dbo.DH3813;

CREATE TABLE DH3813 (
                        IDDOC char(9)  NOT NULL,
                        SP3806 char(9)  NOT NULL,
                        SP6335 numeric(1,0) NOT NULL,
                        SP3809 numeric(14,2) NOT NULL,
                        SP3810 numeric(14,2) NOT NULL,
                        SP3811 numeric(14,2) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH3813 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH3957 definition

-- Drop table

-- DROP TABLE POS.dbo.DH3957;

CREATE TABLE DH3957 (
                        IDDOC char(9)  NOT NULL,
                        SP3935 char(9)  NOT NULL,
                        SP3941 char(9)  NOT NULL,
                        SP3939 char(9)  NOT NULL,
                        SP3940 char(9)  NOT NULL,
                        SP3937 char(9)  NOT NULL,
                        SP3938 char(9)  NOT NULL,
                        SP4074 char(23)  NOT NULL,
                        TSP4074 char(3)  NOT NULL,
                        SP6344 numeric(1,0) NOT NULL,
                        SP3948 numeric(14,2) NOT NULL,
                        SP3951 numeric(14,2) NOT NULL,
                        SP3952 numeric(14,2) NOT NULL,
                        SP3953 numeric(14,2) NOT NULL,
                        SP3954 numeric(14,2) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH3957 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH3995 definition

-- Drop table

-- DROP TABLE POS.dbo.DH3995;

CREATE TABLE DH3995 (
                        IDDOC char(9)  NOT NULL,
                        SP3982 char(9)  NOT NULL,
                        SP3993 char(9)  NOT NULL,
                        SP3981 char(9)  NOT NULL,
                        SP3980 char(9)  NOT NULL,
                        SP3983 numeric(9,4) NOT NULL,
                        SP3986 numeric(1,0) NOT NULL,
                        SP3990 char(23)  NOT NULL,
                        TSP3990 char(3)  NOT NULL,
                        SP3991 char(23)  NOT NULL,
                        TSP3991 char(3)  NOT NULL,
                        SP3992 char(23)  NOT NULL,
                        TSP3992 char(3)  NOT NULL,
                        SP3984 numeric(14,2) NOT NULL,
                        SP3988 numeric(14,2) NOT NULL,
                        SP3989 char(23)  NOT NULL,
                        TSP3989 char(3)  NOT NULL,
                        SP7860 numeric(1,0) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH3995 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH4132 definition

-- Drop table

-- DROP TABLE POS.dbo.DH4132;

CREATE TABLE DH4132 (
                        IDDOC char(9)  NOT NULL,
                        SP4117 char(9)  NOT NULL,
                        SP4123 char(9)  NOT NULL,
                        SP4124 numeric(9,4) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH4132 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH4389 definition

-- Drop table

-- DROP TABLE POS.dbo.DH4389;

CREATE TABLE DH4389 (
                        IDDOC char(9)  NOT NULL,
                        SP4379 char(9)  NOT NULL,
                        SP4380 char(50)  NOT NULL,
                        SP4381 char(25)  NOT NULL,
                        SP4382 char(9)  NOT NULL,
                        SP4383 char(9)  NOT NULL,
                        SP4384 numeric(14,2) NOT NULL,
                        SP4386 numeric(14,2) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH4389 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH4541 definition

-- Drop table

-- DROP TABLE POS.dbo.DH4541;

CREATE TABLE DH4541 (
                        IDDOC char(9)  NOT NULL,
                        SP4528 char(9)  NOT NULL,
                        SP4529 char(9)  NOT NULL,
                        SP4530 char(9)  NOT NULL,
                        SP4531 numeric(9,4) NOT NULL,
                        SP4538 numeric(14,2) NOT NULL,
                        SP4539 numeric(14,2) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH4541 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH4694 definition

-- Drop table

-- DROP TABLE POS.dbo.DH4694;

CREATE TABLE DH4694 (
                        IDDOC char(9)  NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH4694 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH4824 definition

-- Drop table

-- DROP TABLE POS.dbo.DH4824;

CREATE TABLE DH4824 (
                        IDDOC char(9)  NOT NULL,
                        SP4800 char(9)  NOT NULL,
                        SP4801 char(9)  NOT NULL,
                        SP4802 char(9)  NOT NULL,
                        SP4803 numeric(9,4) NOT NULL,
                        SP4804 numeric(1,0) NOT NULL,
                        SP4805 numeric(1,0) NOT NULL,
                        SP4806 numeric(1,0) NOT NULL,
                        SP4807 numeric(1,0) NOT NULL,
                        SP4808 numeric(14,2) NOT NULL,
                        SP4809 char(9)  NOT NULL,
                        SP4810 char(9)  NOT NULL,
                        SP4811 char(9)  NOT NULL,
                        SP6305 char(9)  NOT NULL,
                        SP6306 char(9)  NOT NULL,
                        SP6307 char(30)  NOT NULL,
                        SP6308 char(9)  NOT NULL,
                        SP6309 char(9)  NOT NULL,
                        SP4817 numeric(14,2) NOT NULL,
                        SP4819 numeric(14,2) NOT NULL,
                        SP4821 numeric(14,2) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH4824 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH4847 definition

-- Drop table

-- DROP TABLE POS.dbo.DH4847;

CREATE TABLE DH4847 (
                        IDDOC char(9)  NOT NULL,
                        SP8702 char(9)  NOT NULL,
                        SP8703 char(9)  NOT NULL,
                        SP8704 numeric(18,2) NOT NULL,
                        SP8705 numeric(18,2) NOT NULL,
                        SP8706 numeric(18,2) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH4847 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH4854 definition

-- Drop table

-- DROP TABLE POS.dbo.DH4854;

CREATE TABLE DH4854 (
                        IDDOC char(9)  NOT NULL,
                        SP4848 char(9)  NOT NULL,
                        SP4849 char(9)  NOT NULL,
                        SP4850 numeric(14,2) NOT NULL,
                        SP4851 char(9)  NOT NULL,
                        SP4852 char(9)  NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH4854 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH4913 definition

-- Drop table

-- DROP TABLE POS.dbo.DH4913;

CREATE TABLE DH4913 (
                        IDDOC char(9)  NOT NULL,
                        SP4901 numeric(1,0) NOT NULL,
                        SP4902 numeric(1,0) NOT NULL,
                        SP4903 numeric(1,0) NOT NULL,
                        SP4904 numeric(1,0) NOT NULL,
                        SP4905 numeric(1,0) NOT NULL,
                        SP4906 numeric(1,0) NOT NULL,
                        SP4907 numeric(1,0) NOT NULL,
                        SP4908 numeric(1,0) NOT NULL,
                        SP4909 numeric(1,0) NOT NULL,
                        SP4910 numeric(1,0) NOT NULL,
                        SP5374 numeric(1,0) NOT NULL,
                        SP5375 numeric(1,0) NOT NULL,
                        SP4911 char(9)  NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH4913 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH5155 definition

-- Drop table

-- DROP TABLE POS.dbo.DH5155;

CREATE TABLE DH5155 (
                        IDDOC char(9)  NOT NULL,
                        SP5153 numeric(1,0) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH5155 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH5211 definition

-- Drop table

-- DROP TABLE POS.dbo.DH5211;

CREATE TABLE DH5211 (
                        IDDOC char(9)  NOT NULL,
                        SP5199 char(9)  NOT NULL,
                        SP5200 char(9)  NOT NULL,
                        SP5201 char(9)  NOT NULL,
                        SP5202 numeric(9,4) NOT NULL,
                        SP5203 numeric(14,2) NOT NULL,
                        SP5209 numeric(14,2) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH5211 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH5292 definition

-- Drop table

-- DROP TABLE POS.dbo.DH5292;

CREATE TABLE DH5292 (
                        IDDOC char(9)  NOT NULL,
                        SP5341 char(9)  NOT NULL,
                        SP5266 char(13)  NOT NULL,
                        SP5267 char(9)  NOT NULL,
                        SP5268 char(9)  NOT NULL,
                        SP5269 char(9)  NOT NULL,
                        SP5270 char(9)  NOT NULL,
                        SP5271 numeric(9,4) NOT NULL,
                        SP5276 numeric(1,0) NOT NULL,
                        SP5272 numeric(1,0) NOT NULL,
                        SP5273 numeric(1,0) NOT NULL,
                        SP5274 numeric(1,0) NOT NULL,
                        SP5275 numeric(1,0) NOT NULL,
                        SP6999 char(9)  NOT NULL,
                        SP5277 char(9)  NOT NULL,
                        SP5278 numeric(14,2) NOT NULL,
                        SP5279 datetime NOT NULL,
                        SP7101 char(9)  NOT NULL,
                        SP7552 numeric(1,0) NOT NULL,
                        SP5285 numeric(14,2) NOT NULL,
                        SP5287 numeric(14,2) NOT NULL,
                        SP5289 numeric(14,2) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH5292 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH6313 definition

-- Drop table

-- DROP TABLE POS.dbo.DH6313;

CREATE TABLE DH6313 (
                        IDDOC char(9)  NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH6313 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH6322 definition

-- Drop table

-- DROP TABLE POS.dbo.DH6322;

CREATE TABLE DH6322 (
                        IDDOC char(9)  NOT NULL,
                        SP6314 char(9)  NOT NULL,
                        SP6315 char(25)  NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH6322 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH6334 definition

-- Drop table

-- DROP TABLE POS.dbo.DH6334;

CREATE TABLE DH6334 (
                        IDDOC char(9)  NOT NULL,
                        SP6324 char(9)  NOT NULL,
                        SP6325 numeric(1,0) NOT NULL,
                        SP6328 numeric(14,2) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH6334 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH6532 definition

-- Drop table

-- DROP TABLE POS.dbo.DH6532;

CREATE TABLE DH6532 (
                        IDDOC char(9)  NOT NULL,
                        SP6502 char(9)  NOT NULL,
                        SP6503 char(13)  NOT NULL,
                        SP6504 char(9)  NOT NULL,
                        SP6505 char(9)  NOT NULL,
                        SP6506 char(9)  NOT NULL,
                        SP6507 char(9)  NOT NULL,
                        SP6508 numeric(9,4) NOT NULL,
                        SP6509 numeric(1,0) NOT NULL,
                        SP6510 numeric(1,0) NOT NULL,
                        SP6511 numeric(1,0) NOT NULL,
                        SP6512 numeric(1,0) NOT NULL,
                        SP6513 char(9)  NOT NULL,
                        SP6514 numeric(14,2) NOT NULL,
                        SP6515 char(15)  NOT NULL,
                        SP6516 datetime NOT NULL,
                        SP6517 datetime NOT NULL,
                        SP7829 numeric(1,0) NOT NULL,
                        SP6525 numeric(14,2) NOT NULL,
                        SP6527 numeric(14,2) NOT NULL,
                        SP6529 numeric(14,2) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH6532 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH6661 definition

-- Drop table

-- DROP TABLE POS.dbo.DH6661;

CREATE TABLE DH6661 (
                        IDDOC char(9)  NOT NULL,
                        SP6662 char(13)  NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH6661 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH6675 definition

-- Drop table

-- DROP TABLE POS.dbo.DH6675;

CREATE TABLE DH6675 (
                        IDDOC char(9)  NOT NULL,
                        SP6664 char(9)  NOT NULL,
                        SP6826 char(9)  NOT NULL,
                        SP6666 numeric(9,4) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH6675 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH6918 definition

-- Drop table

-- DROP TABLE POS.dbo.DH6918;

CREATE TABLE DH6918 (
                        IDDOC char(9)  NOT NULL,
                        SP6905 char(9)  NOT NULL,
                        SP6907 char(9)  NOT NULL,
                        SP6908 char(9)  NOT NULL,
                        SP6990 numeric(14,2) NOT NULL,
                        SP6916 numeric(14,2) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH6918 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH8015 definition

-- Drop table

-- DROP TABLE POS.dbo.DH8015;

CREATE TABLE DH8015 (
                        IDDOC char(9)  NOT NULL,
                        SP8017 numeric(10,0) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH8015 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH8025 definition

-- Drop table

-- DROP TABLE POS.dbo.DH8025;

CREATE TABLE DH8025 (
                        IDDOC char(9)  NOT NULL,
                        SP8384 numeric(1,0) NOT NULL,
                        SP8385 numeric(1,0) NOT NULL,
                        SP8922 numeric(1,0) NOT NULL,
                        SP9212 char(2)  NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH8025 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH8036 definition

-- Drop table

-- DROP TABLE POS.dbo.DH8036;

CREATE TABLE DH8036 (
                        IDDOC char(9)  NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH8036 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH8137 definition

-- Drop table

-- DROP TABLE POS.dbo.DH8137;

CREATE TABLE DH8137 (
                        IDDOC char(9)  NOT NULL,
                        SP8134 char(20)  NOT NULL,
                        SP8135 char(20)  NOT NULL,
                        SP8248 char(60)  NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH8137 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH8244 definition

-- Drop table

-- DROP TABLE POS.dbo.DH8244;

CREATE TABLE DH8244 (
                        IDDOC char(9)  NOT NULL,
                        SP8238 char(9)  NOT NULL,
                        SP8239 char(9)  NOT NULL,
                        SP8240 char(9)  NOT NULL,
                        SP8282 char(50)  NOT NULL,
                        SP8283 char(9)  NOT NULL,
                        SP8284 char(9)  NOT NULL,
                        SP8285 char(9)  NOT NULL,
                        SP8470 char(9)  NOT NULL,
                        SP8471 char(9)  NOT NULL,
                        SP8472 numeric(9,4) NOT NULL,
                        SP8473 numeric(5,0) NOT NULL,
                        SP8474 char(9)  NOT NULL,
                        SP8475 numeric(2,0) NOT NULL,
                        SP8638 datetime NOT NULL,
                        SP8699 numeric(12,0) NOT NULL,
                        SP8700 char(17)  NOT NULL,
                        SP8892 char(9)  NOT NULL,
                        SP9093 char(20)  NOT NULL,
                        SP9132 numeric(9,2) NOT NULL,
                        SP9133 char(9)  NOT NULL,
                        SP9151 char(36)  NOT NULL,
                        SP9190 char(36)  NOT NULL,
                        SP9191 char(20)  NOT NULL,
                        SP8242 numeric(13,3) NOT NULL,
                        SP8479 numeric(14,2) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH8244 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH8257 definition

-- Drop table

-- DROP TABLE POS.dbo.DH8257;

CREATE TABLE DH8257 (
                        IDDOC char(9)  NOT NULL,
                        SP8251 char(9)  NOT NULL,
                        SP8252 numeric(1,0) NOT NULL,
                        SP8711 char(9)  NOT NULL,
                        SP8712 char(9)  NOT NULL,
                        SP8713 char(9)  NOT NULL,
                        SP8714 numeric(12,0) NOT NULL,
                        SP8715 datetime NOT NULL,
                        SP8716 numeric(1,0) NOT NULL,
                        SP9015 numeric(10,0) NOT NULL,
                        SP9016 datetime NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH8257 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH8297 definition

-- Drop table

-- DROP TABLE POS.dbo.DH8297;

CREATE TABLE DH8297 (
                        IDDOC char(9)  NOT NULL,
                        SP8680 char(13)  NOT NULL,
                        SP8543 char(9)  NOT NULL,
                        SP8681 char(9)  NOT NULL,
                        SP8682 char(9)  NOT NULL,
                        SP8686 numeric(14,2) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH8297 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH8323 definition

-- Drop table

-- DROP TABLE POS.dbo.DH8323;

CREATE TABLE DH8323 (
                        IDDOC char(9)  NOT NULL,
                        SP8317 char(9)  NOT NULL,
                        SP8318 char(9)  NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH8323 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH8496 definition

-- Drop table

-- DROP TABLE POS.dbo.DH8496;

CREATE TABLE DH8496 (
                        IDDOC char(9)  NOT NULL,
                        SP8488 char(9)  NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH8496 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH8502 definition

-- Drop table

-- DROP TABLE POS.dbo.DH8502;

CREATE TABLE DH8502 (
                        IDDOC char(9)  NOT NULL,
                        SP8497 char(9)  NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH8502 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH8580 definition

-- Drop table

-- DROP TABLE POS.dbo.DH8580;

CREATE TABLE DH8580 (
                        IDDOC char(9)  NOT NULL,
                        SP8550 char(9)  NOT NULL,
                        SP8551 char(9)  NOT NULL,
                        SP8552 char(9)  NOT NULL,
                        SP8553 numeric(9,4) NOT NULL,
                        SP8554 numeric(14,2) NOT NULL,
                        SP8555 char(9)  NOT NULL,
                        SP8556 numeric(4,0) NOT NULL,
                        SP8557 numeric(1,0) NOT NULL,
                        SP8558 char(9)  NOT NULL,
                        SP8559 char(13)  NOT NULL,
                        SP8560 char(9)  NOT NULL,
                        SP8561 char(9)  NOT NULL,
                        SP8562 char(9)  NOT NULL,
                        SP8563 numeric(11,2) NOT NULL,
                        SP8564 numeric(11,2) NOT NULL,
                        SP8565 numeric(11,2) NOT NULL,
                        SP8566 numeric(1,0) NOT NULL,
                        SP8567 char(9)  NOT NULL,
                        SP8568 numeric(1,0) NOT NULL,
                        SP8569 char(9)  NOT NULL,
                        SP8570 datetime NOT NULL,
                        SP8573 numeric(13,3) NOT NULL,
                        SP8577 numeric(14,2) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH8580 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH8587 definition

-- Drop table

-- DROP TABLE POS.dbo.DH8587;

CREATE TABLE DH8587 (
                        IDDOC char(9)  NOT NULL,
                        SP8581 char(64)  NOT NULL,
                        SP8582 char(25)  NOT NULL,
                        SP8583 char(9)  NOT NULL,
                        SP8584 datetime NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH8587 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH8603 definition

-- Drop table

-- DROP TABLE POS.dbo.DH8603;

CREATE TABLE DH8603 (
                        IDDOC char(9)  NOT NULL,
                        SP8797 numeric(1,0) NOT NULL,
                        SP8798 char(9)  NOT NULL,
                        SP8799 char(9)  NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH8603 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH8655 definition

-- Drop table

-- DROP TABLE POS.dbo.DH8655;

CREATE TABLE DH8655 (
                        IDDOC char(9)  NOT NULL,
                        SP8642 char(9)  NOT NULL,
                        SP8643 char(9)  NOT NULL,
                        SP8644 char(9)  NOT NULL,
                        SP8645 char(9)  NOT NULL,
                        SP8646 char(9)  NOT NULL,
                        SP8647 char(9)  NOT NULL,
                        SP8708 char(9)  NOT NULL,
                        SP8709 numeric(12,0) NOT NULL,
                        SP8650 numeric(10,0) NOT NULL,
                        SP8653 numeric(14,2) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH8655 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH8696 definition

-- Drop table

-- DROP TABLE POS.dbo.DH8696;

CREATE TABLE DH8696 (
                        IDDOC char(9)  NOT NULL,
                        SP9037 numeric(1,0) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH8696 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH8777 definition

-- Drop table

-- DROP TABLE POS.dbo.DH8777;

CREATE TABLE DH8777 (
                        IDDOC char(9)  NOT NULL,
                        SP8770 char(9)  NOT NULL,
                        SP8771 char(9)  NOT NULL,
                        SP8772 char(9)  NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH8777 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH8789 definition

-- Drop table

-- DROP TABLE POS.dbo.DH8789;

CREATE TABLE DH8789 (
                        IDDOC char(9)  NOT NULL,
                        SP8782 char(9)  NOT NULL,
                        SP8783 numeric(14,2) NOT NULL,
                        SP8784 char(9)  NOT NULL,
                        SP8785 char(9)  NOT NULL,
                        SP8786 char(9)  NOT NULL,
                        SP8787 char(9)  NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH8789 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH8875 definition

-- Drop table

-- DROP TABLE POS.dbo.DH8875;

CREATE TABLE DH8875 (
                        IDDOC char(9)  NOT NULL,
                        SP8867 char(9)  NOT NULL,
                        SP8868 datetime NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH8875 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH8956 definition

-- Drop table

-- DROP TABLE POS.dbo.DH8956;

CREATE TABLE DH8956 (
                        IDDOC char(9)  NOT NULL,
                        SP8939 char(10)  NOT NULL,
                        SP8940 char(9)  NOT NULL,
                        SP8941 char(9)  NOT NULL,
                        SP8942 numeric(5,0) NOT NULL,
                        SP8943 numeric(13,3) NOT NULL,
                        SP8944 datetime NOT NULL,
                        SP8945 char(17)  NOT NULL,
                        SP8947 numeric(9,2) NOT NULL,
                        SP8948 char(9)  NOT NULL,
                        SP8949 char(9)  NOT NULL,
                        SP9003 numeric(9,2) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP8946 text  NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH8956 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH8984 definition

-- Drop table

-- DROP TABLE POS.dbo.DH8984;

CREATE TABLE DH8984 (
                        IDDOC char(9)  NOT NULL,
                        SP8978 char(9)  NOT NULL,
                        SP8979 char(9)  NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH8984 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH9025 definition

-- Drop table

-- DROP TABLE POS.dbo.DH9025;

CREATE TABLE DH9025 (
                        IDDOC char(9)  NOT NULL,
                        SP9020 datetime NOT NULL,
                        SP9021 numeric(1,0) NOT NULL,
                        SP9022 char(9)  NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH9025 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH9111 definition

-- Drop table

-- DROP TABLE POS.dbo.DH9111;

CREATE TABLE DH9111 (
                        IDDOC char(9)  NOT NULL,
                        SP9098 char(9)  NOT NULL,
                        SP9100 char(9)  NOT NULL,
                        SP9281 datetime NOT NULL,
                        SP9282 char(8)  NOT NULL,
                        SP9283 char(9)  NOT NULL,
                        SP9284 datetime NOT NULL,
                        SP9285 numeric(9,4) NOT NULL,
                        SP9286 char(50)  NOT NULL,
                        SP9287 char(17)  NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH9111 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH9148 definition

-- Drop table

-- DROP TABLE POS.dbo.DH9148;

CREATE TABLE DH9148 (
                        IDDOC char(9)  NOT NULL,
                        SP9136 char(13)  NOT NULL,
                        SP9137 char(9)  NOT NULL,
                        SP9138 char(9)  NOT NULL,
                        SP9139 numeric(9,4) NOT NULL,
                        SP9140 char(9)  NOT NULL,
                        SP9142 numeric(13,3) NOT NULL,
                        SP9146 numeric(14,2) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH9148 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH9170 definition

-- Drop table

-- DROP TABLE POS.dbo.DH9170;

CREATE TABLE DH9170 (
                        IDDOC char(9)  NOT NULL,
                        SP9155 char(13)  NOT NULL,
                        SP9156 char(50)  NOT NULL,
                        SP9157 char(100)  NOT NULL,
                        SP9158 char(9)  NOT NULL,
                        SP9159 char(9)  NOT NULL,
                        SP9160 char(9)  NOT NULL,
                        SP9161 char(9)  NOT NULL,
                        SP9162 char(9)  NOT NULL,
                        SP9193 char(9)  NOT NULL,
                        SP9194 char(9)  NOT NULL,
                        SP9195 char(200)  NOT NULL,
                        SP9196 char(9)  NOT NULL,
                        SP9197 char(200)  NOT NULL,
                        SP9198 char(200)  NOT NULL,
                        SP9215 char(139)  NOT NULL,
                        SP9216 char(50)  NOT NULL,
                        SP9217 char(50)  NOT NULL,
                        SP9218 numeric(14,2) NOT NULL,
                        SP9219 numeric(14,2) NOT NULL,
                        SP9220 numeric(14,2) NOT NULL,
                        SP9164 numeric(10,0) NOT NULL,
                        SP9165 numeric(10,0) NOT NULL,
                        SP9167 numeric(14,2) NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH9170 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH9264 definition

-- Drop table

-- DROP TABLE POS.dbo.DH9264;

CREATE TABLE DH9264 (
                        IDDOC char(9)  NOT NULL,
                        SP9224 char(9)  NOT NULL,
                        SP9225 datetime NOT NULL,
                        SP9226 char(8)  NOT NULL,
                        SP9227 char(9)  NOT NULL,
                        SP9228 numeric(9,4) NOT NULL,
                        SP9229 numeric(14,2) NOT NULL,
                        SP9230 numeric(14,2) NOT NULL,
                        SP9231 numeric(14,2) NOT NULL,
                        SP9232 char(139)  NOT NULL,
                        SP9233 char(9)  NOT NULL,
                        SP9234 char(13)  NOT NULL,
                        SP9235 char(50)  NOT NULL,
                        SP9236 char(9)  NOT NULL,
                        SP9237 char(17)  NOT NULL,
                        SP9238 char(9)  NOT NULL,
                        SP9239 numeric(14,2) NOT NULL,
                        SP9240 char(13)  NOT NULL,
                        SP9241 char(20)  NOT NULL,
                        SP9242 char(9)  NOT NULL,
                        SP9243 char(50)  NOT NULL,
                        SP9244 char(9)  NOT NULL,
                        SP9245 char(2)  NOT NULL,
                        SP9246 char(1)  NOT NULL,
                        SP9247 char(20)  NOT NULL,
                        SP9248 char(40)  NOT NULL,
                        SP9249 char(20)  NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH9264 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DH9275 definition

-- Drop table

-- DROP TABLE POS.dbo.DH9275;

CREATE TABLE DH9275 (
                        IDDOC char(9)  NOT NULL,
                        SP9276 char(10)  NOT NULL,
                        SP8606 char(8)  NOT NULL,
                        SP8607 datetime NOT NULL,
                        SP8609 char(8)  NOT NULL,
                        SP660 text  NULL,
                        CONSTRAINT PK_DH9275 PRIMARY KEY (IDDOC)
);


-- POS.dbo.DKLog definition

-- Drop table

-- DROP TABLE POS.dbo.DKLog;

CREATE TABLE DKLog (
    [DATE] date NULL,
     CARDCODE char(13)  NULL,
     EMPLOYEE char(17)  NULL,
     SAVEONLINE numeric(1,0) NULL
);


-- POS.dbo.DT1582 definition

-- Drop table

-- DROP TABLE POS.dbo.DT1582;

CREATE TABLE DT1582 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP1578 char(9)  NOT NULL,
                        SP1569 char(9)  NOT NULL,
                        SP1570 numeric(13,3) NOT NULL,
                        SP1571 char(9)  NOT NULL,
                        SP1572 numeric(9,3) NOT NULL,
                        SP1573 numeric(14,2) NOT NULL,
                        SP1574 numeric(14,2) NOT NULL,
                        SP1579 char(9)  NOT NULL,
                        SP1575 numeric(14,2) NOT NULL,
                        SP1580 char(9)  NOT NULL,
                        SP1576 numeric(14,2) NOT NULL,
                        SP1577 char(9)  NOT NULL,
                        CONSTRAINT PK_DT1582 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT1611 definition

-- Drop table

-- DROP TABLE POS.dbo.DT1611;

CREATE TABLE DT1611 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP1599 char(9)  NOT NULL,
                        SP1600 numeric(13,3) NOT NULL,
                        SP1601 char(9)  NOT NULL,
                        SP1602 numeric(9,3) NOT NULL,
                        SP1603 numeric(14,2) NOT NULL,
                        SP1604 numeric(14,2) NOT NULL,
                        SP1608 char(9)  NOT NULL,
                        SP1605 numeric(14,2) NOT NULL,
                        SP1609 char(9)  NOT NULL,
                        SP1606 numeric(14,2) NOT NULL,
                        SP1607 char(9)  NOT NULL,
                        CONSTRAINT PK_DT1611 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT1628 definition

-- Drop table

-- DROP TABLE POS.dbo.DT1628;

CREATE TABLE DT1628 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP1620 char(9)  NOT NULL,
                        SP1621 numeric(13,3) NOT NULL,
                        SP1622 char(9)  NOT NULL,
                        SP1623 numeric(9,3) NOT NULL,
                        SP1624 numeric(14,2) NOT NULL,
                        SP1625 numeric(14,2) NOT NULL,
                        SP3914 char(9)  NOT NULL,
                        SP3915 numeric(14,2) NOT NULL,
                        SP3916 char(9)  NOT NULL,
                        SP3917 numeric(14,2) NOT NULL,
                        SP1626 char(9)  NOT NULL,
                        CONSTRAINT PK_DT1628 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT1656 definition

-- Drop table

-- DROP TABLE POS.dbo.DT1656;

CREATE TABLE DT1656 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP1644 char(9)  NOT NULL,
                        SP1645 numeric(13,3) NOT NULL,
                        SP1646 char(9)  NOT NULL,
                        SP1647 numeric(9,3) NOT NULL,
                        SP1648 numeric(14,2) NOT NULL,
                        SP1649 numeric(14,2) NOT NULL,
                        SP1653 char(9)  NOT NULL,
                        SP1650 numeric(14,2) NOT NULL,
                        SP1654 char(9)  NOT NULL,
                        SP1651 numeric(14,2) NOT NULL,
                        SP4244 char(23)  NOT NULL,
                        TSP4244 char(3)  NOT NULL,
                        SP4245 numeric(14,2) NOT NULL,
                        SP4246 numeric(14,2) NOT NULL,
                        SP6362 numeric(14,2) NOT NULL,
                        SP1652 char(9)  NOT NULL,
                        CONSTRAINT PK_DT1656 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT1684 definition

-- Drop table

-- DROP TABLE POS.dbo.DT1684;

CREATE TABLE DT1684 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP1674 char(9)  NOT NULL,
                        SP1673 numeric(13,3) NOT NULL,
                        SP1675 numeric(9,3) NOT NULL,
                        SP1672 char(9)  NOT NULL,
                        SP1680 char(9)  NOT NULL,
                        SP7125 numeric(14,2) NOT NULL,
                        SP1681 char(9)  NOT NULL,
                        SP1682 char(9)  NOT NULL,
                        SP1677 numeric(14,2) NOT NULL,
                        SP1678 numeric(14,2) NOT NULL,
                        SP1679 numeric(14,2) NOT NULL,
                        SP1676 numeric(14,2) NOT NULL,
                        CONSTRAINT PK_DT1684 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT1774 definition

-- Drop table

-- DROP TABLE POS.dbo.DT1774;

CREATE TABLE DT1774 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP1764 char(9)  NOT NULL,
                        SP1765 numeric(13,3) NOT NULL,
                        SP1766 char(9)  NOT NULL,
                        SP1767 numeric(9,3) NOT NULL,
                        SP1768 numeric(14,2) NOT NULL,
                        SP1769 numeric(14,2) NOT NULL,
                        SP1772 char(9)  NOT NULL,
                        SP1770 numeric(14,2) NOT NULL,
                        SP1771 char(9)  NOT NULL,
                        CONSTRAINT PK_DT1774 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT1790 definition

-- Drop table

-- DROP TABLE POS.dbo.DT1790;

CREATE TABLE DT1790 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP1782 char(9)  NOT NULL,
                        SP1783 numeric(13,3) NOT NULL,
                        SP1784 char(9)  NOT NULL,
                        SP1785 numeric(9,3) NOT NULL,
                        SP1786 numeric(14,2) NOT NULL,
                        SP1787 numeric(14,2) NOT NULL,
                        SP1788 char(9)  NOT NULL,
                        CONSTRAINT PK_DT1790 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT2051 definition

-- Drop table

-- DROP TABLE POS.dbo.DT2051;

CREATE TABLE DT2051 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP4421 char(30)  NOT NULL,
                        SP2040 numeric(13,3) NOT NULL,
                        SP2658 char(9)  NOT NULL,
                        SP2042 numeric(14,2) NOT NULL,
                        SP2043 numeric(14,2) NOT NULL,
                        SP2044 numeric(14,2) NOT NULL,
                        SP2045 numeric(14,2) NOT NULL,
                        SP2046 char(9)  NOT NULL,
                        SP2047 char(9)  NOT NULL,
                        SP2048 char(9)  NOT NULL,
                        SP2049 char(9)  NOT NULL,
                        CONSTRAINT PK_DT2051 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT2075 definition

-- Drop table

-- DROP TABLE POS.dbo.DT2075;

CREATE TABLE DT2075 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP2064 char(13)  NOT NULL,
                        SP2065 numeric(13,3) NOT NULL,
                        SP2073 char(9)  NOT NULL,
                        SP2066 numeric(14,2) NOT NULL,
                        SP2067 numeric(14,2) NOT NULL,
                        SP2070 char(9)  NOT NULL,
                        SP2068 numeric(14,2) NOT NULL,
                        SP2071 char(9)  NOT NULL,
                        SP2069 numeric(14,2) NOT NULL,
                        SP2072 char(80)  NOT NULL,
                        CONSTRAINT PK_DT2075 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT2106 definition

-- Drop table

-- DROP TABLE POS.dbo.DT2106;

CREATE TABLE DT2106 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP2097 char(9)  NOT NULL,
                        SP2098 char(9)  NOT NULL,
                        SP2099 numeric(13,3) NOT NULL,
                        SP2100 char(9)  NOT NULL,
                        SP2101 numeric(9,3) NOT NULL,
                        SP2102 numeric(14,2) NOT NULL,
                        SP2103 numeric(14,2) NOT NULL,
                        SP2104 char(9)  NOT NULL,
                        SP6569 numeric(15,2) NOT NULL,
                        SP6570 numeric(15,2) NOT NULL,
                        CONSTRAINT PK_DT2106 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT2320 definition

-- Drop table

-- DROP TABLE POS.dbo.DT2320;

CREATE TABLE DT2320 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP3016 char(9)  NOT NULL,
                        SP2312 char(9)  NOT NULL,
                        SP2313 numeric(13,3) NOT NULL,
                        SP2314 char(9)  NOT NULL,
                        SP2315 numeric(9,3) NOT NULL,
                        SP2318 char(9)  NOT NULL,
                        SP3768 numeric(14,2) NOT NULL,
                        SP3769 numeric(14,2) NOT NULL,
                        CONSTRAINT PK_DT2320 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT2457 definition

-- Drop table

-- DROP TABLE POS.dbo.DT2457;

CREATE TABLE DT2457 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP2446 char(9)  NOT NULL,
                        SP2447 numeric(13,3) NOT NULL,
                        SP2448 char(9)  NOT NULL,
                        SP2449 numeric(9,3) NOT NULL,
                        SP2450 numeric(14,2) NOT NULL,
                        SP2451 numeric(14,2) NOT NULL,
                        SP2454 char(9)  NOT NULL,
                        SP2452 numeric(14,2) NOT NULL,
                        SP2455 char(9)  NOT NULL,
                        SP2453 numeric(14,2) NOT NULL,
                        CONSTRAINT PK_DT2457 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT2695 definition

-- Drop table

-- DROP TABLE POS.dbo.DT2695;

CREATE TABLE DT2695 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP4145 numeric(14,2) NOT NULL,
                        SP4146 char(9)  NOT NULL,
                        SP4147 numeric(14,2) NOT NULL,
                        SP4148 numeric(14,2) NOT NULL,
                        SP4355 char(9)  NOT NULL,
                        SP4356 char(9)  NOT NULL,
                        SP4357 char(9)  NOT NULL,
                        CONSTRAINT PK_DT2695 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT2742 definition

-- Drop table

-- DROP TABLE POS.dbo.DT2742;

CREATE TABLE DT2742 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP2731 char(9)  NOT NULL,
                        SP2732 numeric(13,3) NOT NULL,
                        SP2733 char(9)  NOT NULL,
                        SP2734 numeric(9,3) NOT NULL,
                        SP2735 numeric(14,2) NOT NULL,
                        SP2736 numeric(14,2) NOT NULL,
                        SP2739 char(9)  NOT NULL,
                        SP2737 numeric(14,2) NOT NULL,
                        SP2740 char(9)  NOT NULL,
                        SP2738 numeric(14,2) NOT NULL,
                        SP4684 char(9)  NOT NULL,
                        CONSTRAINT PK_DT2742 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT2827 definition

-- Drop table

-- DROP TABLE POS.dbo.DT2827;

CREATE TABLE DT2827 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP2819 char(9)  NOT NULL,
                        SP2820 numeric(13,3) NOT NULL,
                        SP2821 char(9)  NOT NULL,
                        SP2822 numeric(9,3) NOT NULL,
                        SP2823 numeric(14,2) NOT NULL,
                        SP2824 numeric(14,2) NOT NULL,
                        SP2825 char(9)  NOT NULL,
                        CONSTRAINT PK_DT2827 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT2988 definition

-- Drop table

-- DROP TABLE POS.dbo.DT2988;

CREATE TABLE DT2988 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP2977 char(9)  NOT NULL,
                        SP2978 char(9)  NOT NULL,
                        SP2979 numeric(13,3) NOT NULL,
                        SP2980 char(9)  NOT NULL,
                        SP2981 numeric(9,3) NOT NULL,
                        SP2982 numeric(14,2) NOT NULL,
                        SP2983 numeric(14,2) NOT NULL,
                        SP2984 char(9)  NOT NULL,
                        SP2985 numeric(14,2) NOT NULL,
                        SP3687 char(9)  NOT NULL,
                        SP3688 numeric(14,2) NOT NULL,
                        SP2986 char(9)  NOT NULL,
                        CONSTRAINT PK_DT2988 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT2998 definition

-- Drop table

-- DROP TABLE POS.dbo.DT2998;

CREATE TABLE DT2998 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP2995 char(9)  NOT NULL,
                        SP2996 char(9)  NOT NULL,
                        SP2993 numeric(14,2) NOT NULL,
                        SP2994 numeric(14,2) NOT NULL,
                        SP3693 char(100)  NOT NULL,
                        CONSTRAINT PK_DT2998 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT3046 definition

-- Drop table

-- DROP TABLE POS.dbo.DT3046;

CREATE TABLE DT3046 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP3038 char(13)  NOT NULL,
                        SP3039 char(9)  NOT NULL,
                        SP3040 numeric(13,3) NOT NULL,
                        SP3041 char(9)  NOT NULL,
                        SP3042 numeric(9,3) NOT NULL,
                        SP3043 numeric(14,2) NOT NULL,
                        SP3044 numeric(14,2) NOT NULL,
                        SP8389 numeric(5,2) NOT NULL,
                        SP8835 numeric(9,2) NOT NULL,
                        SP8836 numeric(5,0) NOT NULL,
                        SP9005 numeric(4,2) NOT NULL,
                        SP9006 numeric(14,2) NOT NULL,
                        SP9075 char(130)  NOT NULL,
                        SP9210 char(2)  NOT NULL,
                        CONSTRAINT PK_DT3046 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT3089 definition

-- Drop table

-- DROP TABLE POS.dbo.DT3089;

CREATE TABLE DT3089 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP3086 numeric(14,2) NOT NULL,
                        SP3698 char(100)  NOT NULL,
                        SP3887 char(23)  NOT NULL,
                        TSP3887 char(3)  NOT NULL,
                        SP3888 char(23)  NOT NULL,
                        TSP3888 char(3)  NOT NULL,
                        SP3889 char(23)  NOT NULL,
                        TSP3889 char(3)  NOT NULL,
                        SP3890 char(23)  NOT NULL,
                        TSP3890 char(3)  NOT NULL,
                        SP4182 char(9)  NOT NULL,
                        SP4183 numeric(14,2) NOT NULL,
                        SP4184 char(9)  NOT NULL,
                        SP4185 numeric(14,2) NOT NULL,
                        SP4202 numeric(13,3) NOT NULL,
                        SP4203 numeric(14,2) NOT NULL,
                        SP7775 char(23)  NOT NULL,
                        TSP7775 char(3)  NOT NULL,
                        SP7776 char(23)  NOT NULL,
                        TSP7776 char(3)  NOT NULL,
                        SP7777 char(23)  NOT NULL,
                        TSP7777 char(3)  NOT NULL,
                        SP7778 char(23)  NOT NULL,
                        TSP7778 char(3)  NOT NULL,
                        CONSTRAINT PK_DT3089 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT3114 definition

-- Drop table

-- DROP TABLE POS.dbo.DT3114;

CREATE TABLE DT3114 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP3102 char(9)  NOT NULL,
                        SP3103 numeric(13,3) NOT NULL,
                        SP3104 char(9)  NOT NULL,
                        SP3105 numeric(9,3) NOT NULL,
                        SP3106 numeric(14,2) NOT NULL,
                        SP3107 numeric(14,2) NOT NULL,
                        SP3108 char(9)  NOT NULL,
                        SP3109 numeric(14,2) NOT NULL,
                        SP3110 char(9)  NOT NULL,
                        SP3111 numeric(14,2) NOT NULL,
                        SP3112 char(9)  NOT NULL,
                        CONSTRAINT PK_DT3114 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT3311 definition

-- Drop table

-- DROP TABLE POS.dbo.DT3311;

CREATE TABLE DT3311 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP3297 char(9)  NOT NULL,
                        SP3298 char(9)  NOT NULL,
                        SP3299 numeric(13,3) NOT NULL,
                        SP3300 char(9)  NOT NULL,
                        SP3301 numeric(9,3) NOT NULL,
                        SP3302 numeric(14,2) NOT NULL,
                        SP3303 numeric(14,2) NOT NULL,
                        SP3304 numeric(5,2) NOT NULL,
                        SP3305 numeric(14,2) NOT NULL,
                        SP3306 char(9)  NOT NULL,
                        SP3307 numeric(14,2) NOT NULL,
                        SP3308 char(9)  NOT NULL,
                        SP3309 numeric(14,2) NOT NULL,
                        SP7357 numeric(15,2) NOT NULL,
                        SP7358 numeric(16,2) NOT NULL,
                        CONSTRAINT PK_DT3311 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT3504 definition

-- Drop table

-- DROP TABLE POS.dbo.DT3504;

CREATE TABLE DT3504 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP4150 numeric(14,2) NOT NULL,
                        SP4151 char(9)  NOT NULL,
                        SP4152 numeric(14,2) NOT NULL,
                        SP4361 numeric(14,2) NOT NULL,
                        CONSTRAINT PK_DT3504 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT3521 definition

-- Drop table

-- DROP TABLE POS.dbo.DT3521;

CREATE TABLE DT3521 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP6426 char(80)  NOT NULL,
                        SP3516 char(9)  NOT NULL,
                        SP3517 numeric(13,3) NOT NULL,
                        SP6427 char(9)  NOT NULL,
                        CONSTRAINT PK_DT3521 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT3614 definition

-- Drop table

-- DROP TABLE POS.dbo.DT3614;

CREATE TABLE DT3614 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP3604 numeric(13,3) NOT NULL,
                        SP3605 numeric(14,2) NOT NULL,
                        SP3606 numeric(14,2) NOT NULL,
                        SP3607 char(9)  NOT NULL,
                        SP3608 numeric(14,2) NOT NULL,
                        SP3609 char(9)  NOT NULL,
                        SP3610 numeric(14,2) NOT NULL,
                        SP3611 char(80)  NOT NULL,
                        CONSTRAINT PK_DT3614 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT3638 definition

-- Drop table

-- DROP TABLE POS.dbo.DT3638;

CREATE TABLE DT3638 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP3628 numeric(13,3) NOT NULL,
                        SP3629 numeric(14,2) NOT NULL,
                        SP3630 numeric(14,2) NOT NULL,
                        SP3631 numeric(14,2) NOT NULL,
                        SP3632 numeric(14,2) NOT NULL,
                        SP3633 char(9)  NOT NULL,
                        SP3634 char(9)  NOT NULL,
                        SP3635 char(80)  NOT NULL,
                        SP3835 char(23)  NOT NULL,
                        TSP3835 char(3)  NOT NULL,
                        SP3836 char(23)  NOT NULL,
                        TSP3836 char(3)  NOT NULL,
                        SP3837 char(23)  NOT NULL,
                        TSP3837 char(3)  NOT NULL,
                        SP3838 char(23)  NOT NULL,
                        TSP3838 char(3)  NOT NULL,
                        SP7765 char(23)  NOT NULL,
                        TSP7765 char(3)  NOT NULL,
                        SP7766 char(23)  NOT NULL,
                        TSP7766 char(3)  NOT NULL,
                        SP7767 char(23)  NOT NULL,
                        TSP7767 char(3)  NOT NULL,
                        SP7768 char(23)  NOT NULL,
                        TSP7768 char(3)  NOT NULL,
                        CONSTRAINT PK_DT3638 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT3725 definition

-- Drop table

-- DROP TABLE POS.dbo.DT3725;

CREATE TABLE DT3725 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP3716 char(9)  NOT NULL,
                        SP3717 numeric(13,3) NOT NULL,
                        SP3718 numeric(13,3) NOT NULL,
                        SP3719 char(9)  NOT NULL,
                        SP3720 numeric(9,3) NOT NULL,
                        SP3721 numeric(14,2) NOT NULL,
                        SP3722 numeric(14,2) NOT NULL,
                        SP3723 numeric(14,2) NOT NULL,
                        CONSTRAINT PK_DT3725 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT3790 definition

-- Drop table

-- DROP TABLE POS.dbo.DT3790;

CREATE TABLE DT3790 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP3781 char(9)  NOT NULL,
                        SP3782 numeric(14,2) NOT NULL,
                        SP3783 numeric(14,2) NOT NULL,
                        SP3784 numeric(14,2) NOT NULL,
                        SP3785 char(9)  NOT NULL,
                        SP3786 numeric(14,2) NOT NULL,
                        SP3787 char(9)  NOT NULL,
                        SP3788 numeric(14,2) NOT NULL,
                        SP6342 char(13)  NOT NULL,
                        CONSTRAINT PK_DT3790 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT3805 definition

-- Drop table

-- DROP TABLE POS.dbo.DT3805;

CREATE TABLE DT3805 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP3795 char(9)  NOT NULL,
                        SP3796 numeric(14,2) NOT NULL,
                        SP3797 numeric(14,2) NOT NULL,
                        SP3798 numeric(14,2) NOT NULL,
                        SP3799 char(9)  NOT NULL,
                        SP3800 numeric(14,2) NOT NULL,
                        SP3801 char(9)  NOT NULL,
                        SP3802 numeric(14,2) NOT NULL,
                        SP3803 numeric(14,2) NOT NULL,
                        SP6339 char(13)  NOT NULL,
                        CONSTRAINT PK_DT3805 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT3813 definition

-- Drop table

-- DROP TABLE POS.dbo.DT3813;

CREATE TABLE DT3813 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP3807 char(13)  NOT NULL,
                        SP3808 char(9)  NOT NULL,
                        SP3809 numeric(14,2) NOT NULL,
                        SP3810 numeric(14,2) NOT NULL,
                        SP3811 numeric(14,2) NOT NULL,
                        SP6336 char(13)  NOT NULL,
                        CONSTRAINT PK_DT3813 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT3957 definition

-- Drop table

-- DROP TABLE POS.dbo.DT3957;

CREATE TABLE DT3957 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP3944 char(9)  NOT NULL,
                        SP3945 numeric(13,3) NOT NULL,
                        SP3946 char(9)  NOT NULL,
                        SP3947 numeric(9,3) NOT NULL,
                        SP3948 numeric(14,2) NOT NULL,
                        SP3949 char(9)  NOT NULL,
                        SP3950 char(9)  NOT NULL,
                        SP3951 numeric(14,2) NOT NULL,
                        SP3952 numeric(14,2) NOT NULL,
                        SP3953 numeric(14,2) NOT NULL,
                        SP3954 numeric(14,2) NOT NULL,
                        SP3955 char(9)  NOT NULL,
                        SP6345 char(13)  NOT NULL,
                        SP6346 char(9)  NOT NULL,
                        SP6347 datetime NOT NULL,
                        SP6348 char(9)  NOT NULL,
                        SP6349 char(9)  NOT NULL,
                        CONSTRAINT PK_DT3957 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT4132 definition

-- Drop table

-- DROP TABLE POS.dbo.DT4132;

CREATE TABLE DT4132 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP4125 char(9)  NOT NULL,
                        SP4126 numeric(13,3) NOT NULL,
                        SP4127 char(9)  NOT NULL,
                        SP4128 numeric(9,3) NOT NULL,
                        SP4129 numeric(14,2) NOT NULL,
                        SP4130 numeric(14,2) NOT NULL,
                        CONSTRAINT PK_DT4132 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT4389 definition

-- Drop table

-- DROP TABLE POS.dbo.DT4389;

CREATE TABLE DT4389 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP4384 numeric(14,2) NOT NULL,
                        SP4385 char(9)  NOT NULL,
                        SP4386 numeric(14,2) NOT NULL,
                        SP4387 numeric(14,2) NOT NULL,
                        CONSTRAINT PK_DT4389 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT4541 definition

-- Drop table

-- DROP TABLE POS.dbo.DT4541;

CREATE TABLE DT4541 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP4532 char(9)  NOT NULL,
                        SP4533 numeric(13,3) NOT NULL,
                        SP4534 numeric(13,3) NOT NULL,
                        SP4535 char(9)  NOT NULL,
                        SP4536 numeric(9,3) NOT NULL,
                        SP4537 numeric(14,2) NOT NULL,
                        SP4538 numeric(14,2) NOT NULL,
                        SP4539 numeric(14,2) NOT NULL,
                        CONSTRAINT PK_DT4541 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT4824 definition

-- Drop table

-- DROP TABLE POS.dbo.DT4824;

CREATE TABLE DT4824 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP4812 char(9)  NOT NULL,
                        SP4813 numeric(13,3) NOT NULL,
                        SP4814 char(9)  NOT NULL,
                        SP4815 numeric(9,3) NOT NULL,
                        SP4816 numeric(14,2) NOT NULL,
                        SP4817 numeric(14,2) NOT NULL,
                        SP4818 char(9)  NOT NULL,
                        SP4819 numeric(14,2) NOT NULL,
                        SP4820 char(9)  NOT NULL,
                        SP4821 numeric(14,2) NOT NULL,
                        SP4822 char(9)  NOT NULL,
                        CONSTRAINT PK_DT4824 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT4847 definition

-- Drop table

-- DROP TABLE POS.dbo.DT4847;

CREATE TABLE DT4847 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP8916 char(9)  NOT NULL,
                        SP8917 numeric(10,0) NOT NULL,
                        SP8918 numeric(1,0) NOT NULL,
                        CONSTRAINT PK_DT4847 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT5211 definition

-- Drop table

-- DROP TABLE POS.dbo.DT5211;

CREATE TABLE DT5211 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP5204 char(9)  NOT NULL,
                        SP5205 numeric(13,3) NOT NULL,
                        SP5206 char(9)  NOT NULL,
                        SP5207 numeric(9,3) NOT NULL,
                        SP5208 numeric(14,2) NOT NULL,
                        SP5209 numeric(14,2) NOT NULL,
                        CONSTRAINT PK_DT5211 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT5292 definition

-- Drop table

-- DROP TABLE POS.dbo.DT5292;

CREATE TABLE DT5292 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP5280 char(9)  NOT NULL,
                        SP5281 numeric(13,3) NOT NULL,
                        SP5282 char(9)  NOT NULL,
                        SP5283 numeric(9,3) NOT NULL,
                        SP5284 numeric(14,2) NOT NULL,
                        SP5285 numeric(14,2) NOT NULL,
                        SP5286 char(9)  NOT NULL,
                        SP5287 numeric(14,2) NOT NULL,
                        SP5288 char(9)  NOT NULL,
                        SP5289 numeric(14,2) NOT NULL,
                        SP5290 char(9)  NOT NULL,
                        CONSTRAINT PK_DT5292 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT6313 definition

-- Drop table

-- DROP TABLE POS.dbo.DT6313;

CREATE TABLE DT6313 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP6311 char(9)  NOT NULL,
                        CONSTRAINT PK_DT6313 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT6322 definition

-- Drop table

-- DROP TABLE POS.dbo.DT6322;

CREATE TABLE DT6322 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP6316 char(9)  NOT NULL,
                        SP6317 char(9)  NOT NULL,
                        SP6318 char(9)  NOT NULL,
                        SP6319 numeric(9,3) NOT NULL,
                        SP6320 numeric(13,3) NOT NULL,
                        SP6359 char(9)  NOT NULL,
                        CONSTRAINT PK_DT6322 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT6334 definition

-- Drop table

-- DROP TABLE POS.dbo.DT6334;

CREATE TABLE DT6334 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP6326 char(9)  NOT NULL,
                        SP6327 numeric(13,3) NOT NULL,
                        SP6328 numeric(14,2) NOT NULL,
                        SP6329 char(9)  NOT NULL,
                        SP6330 char(9)  NOT NULL,
                        SP6331 char(9)  NOT NULL,
                        SP6332 char(9)  NOT NULL,
                        CONSTRAINT PK_DT6334 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT6532 definition

-- Drop table

-- DROP TABLE POS.dbo.DT6532;

CREATE TABLE DT6532 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP6518 char(9)  NOT NULL,
                        SP6519 char(9)  NOT NULL,
                        SP6520 numeric(13,3) NOT NULL,
                        SP6521 char(9)  NOT NULL,
                        SP6522 numeric(9,3) NOT NULL,
                        SP6523 numeric(14,2) NOT NULL,
                        SP6524 numeric(14,2) NOT NULL,
                        SP6525 numeric(14,2) NOT NULL,
                        SP6526 char(9)  NOT NULL,
                        SP6527 numeric(14,2) NOT NULL,
                        SP6528 char(9)  NOT NULL,
                        SP6529 numeric(14,2) NOT NULL,
                        SP6530 char(9)  NOT NULL,
                        SP6573 numeric(5,2) NOT NULL,
                        CONSTRAINT PK_DT6532 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT6918 definition

-- Drop table

-- DROP TABLE POS.dbo.DT6918;

CREATE TABLE DT6918 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP6989 char(13)  NOT NULL,
                        SP6990 numeric(14,2) NOT NULL,
                        SP6915 char(9)  NOT NULL,
                        SP6916 numeric(14,2) NOT NULL,
                        SP7106 char(9)  NOT NULL,
                        CONSTRAINT PK_DT6918 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT8015 definition

-- Drop table

-- DROP TABLE POS.dbo.DT8015;

CREATE TABLE DT8015 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP8016 char(9)  NOT NULL,
                        SP8017 numeric(10,0) NOT NULL,
                        CONSTRAINT PK_DT8015 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT8025 definition

-- Drop table

-- DROP TABLE POS.dbo.DT8025;

CREATE TABLE DT8025 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP8029 char(9)  NOT NULL,
                        SP8030 numeric(9,2) NOT NULL,
                        SP8031 numeric(9,2) NOT NULL,
                        SP8386 numeric(5,2) NOT NULL,
                        CONSTRAINT PK_DT8025 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT8036 definition

-- Drop table

-- DROP TABLE POS.dbo.DT8036;

CREATE TABLE DT8036 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP8039 char(9)  NOT NULL,
                        SP8040 numeric(10,0) NOT NULL,
                        SP8041 char(2)  NOT NULL,
                        CONSTRAINT PK_DT8036 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT8244 definition

-- Drop table

-- DROP TABLE POS.dbo.DT8244;

CREATE TABLE DT8244 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP8241 char(9)  NOT NULL,
                        SP8242 numeric(13,3) NOT NULL,
                        SP8286 numeric(3,0) NOT NULL,
                        SP8381 char(9)  NOT NULL,
                        SP8476 char(9)  NOT NULL,
                        SP8477 numeric(9,3) NOT NULL,
                        SP8478 numeric(14,2) NOT NULL,
                        SP8479 numeric(14,2) NOT NULL,
                        SP8639 char(20)  NOT NULL,
                        SP9077 char(130)  NOT NULL,
                        SP9094 numeric(1,0) NOT NULL,
                        CONSTRAINT PK_DT8244 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT8257 definition

-- Drop table

-- DROP TABLE POS.dbo.DT8257;

CREATE TABLE DT8257 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP8254 char(9)  NOT NULL,
                        SP8255 numeric(10,0) NOT NULL,
                        CONSTRAINT PK_DT8257 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT8297 definition

-- Drop table

-- DROP TABLE POS.dbo.DT8297;

CREATE TABLE DT8297 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP8683 char(9)  NOT NULL,
                        SP8684 numeric(5,0) NOT NULL,
                        SP8685 numeric(9,2) NOT NULL,
                        SP8686 numeric(14,2) NOT NULL,
                        SP8687 char(9)  NOT NULL,
                        SP8688 char(20)  NOT NULL,
                        SP8689 numeric(14,2) NOT NULL,
                        SP8690 char(9)  NOT NULL,
                        SP8691 char(9)  NOT NULL,
                        SP9079 char(130)  NOT NULL,
                        CONSTRAINT PK_DT8297 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT8323 definition

-- Drop table

-- DROP TABLE POS.dbo.DT8323;

CREATE TABLE DT8323 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP8319 char(9)  NOT NULL,
                        SP8320 numeric(5,0) NOT NULL,
                        SP8321 numeric(5,0) NOT NULL,
                        CONSTRAINT PK_DT8323 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT8496 definition

-- Drop table

-- DROP TABLE POS.dbo.DT8496;

CREATE TABLE DT8496 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP8489 char(9)  NOT NULL,
                        SP8490 char(5)  NOT NULL,
                        SP8491 char(5)  NOT NULL,
                        SP8492 char(5)  NOT NULL,
                        SP8493 char(5)  NOT NULL,
                        SP8494 char(9)  NOT NULL,
                        SP8862 char(100)  NOT NULL,
                        SP8930 char(9)  NOT NULL,
                        CONSTRAINT PK_DT8496 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT8502 definition

-- Drop table

-- DROP TABLE POS.dbo.DT8502;

CREATE TABLE DT8502 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP8498 char(9)  NOT NULL,
                        SP8499 numeric(16,2) NOT NULL,
                        SP8500 char(9)  NOT NULL,
                        CONSTRAINT PK_DT8502 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT8580 definition

-- Drop table

-- DROP TABLE POS.dbo.DT8580;

CREATE TABLE DT8580 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP8571 char(13)  NOT NULL,
                        SP8572 char(9)  NOT NULL,
                        SP8573 numeric(13,3) NOT NULL,
                        SP8574 char(9)  NOT NULL,
                        SP8575 numeric(9,3) NOT NULL,
                        SP8576 numeric(14,2) NOT NULL,
                        SP8577 numeric(14,2) NOT NULL,
                        SP8578 numeric(5,2) NOT NULL,
                        CONSTRAINT PK_DT8580 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT8587 definition

-- Drop table

-- DROP TABLE POS.dbo.DT8587;

CREATE TABLE DT8587 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP8585 char(9)  NOT NULL,
                        CONSTRAINT PK_DT8587 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT8603 definition

-- Drop table

-- DROP TABLE POS.dbo.DT8603;

CREATE TABLE DT8603 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP8596 char(9)  NOT NULL,
                        SP8597 char(9)  NOT NULL,
                        SP8598 char(9)  NOT NULL,
                        SP8599 numeric(5,0) NOT NULL,
                        SP8600 numeric(14,2) NOT NULL,
                        SP8601 numeric(6,0) NOT NULL,
                        CONSTRAINT PK_DT8603 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT8655 definition

-- Drop table

-- DROP TABLE POS.dbo.DT8655;

CREATE TABLE DT8655 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP8648 char(9)  NOT NULL,
                        SP8649 numeric(10,0) NOT NULL,
                        SP8650 numeric(10,0) NOT NULL,
                        SP8651 numeric(14,2) NOT NULL,
                        SP8652 char(20)  NOT NULL,
                        SP8653 numeric(14,2) NOT NULL,
                        SP9081 char(130)  NOT NULL,
                        CONSTRAINT PK_DT8655 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT8696 definition

-- Drop table

-- DROP TABLE POS.dbo.DT8696;

CREATE TABLE DT8696 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP8693 char(9)  NOT NULL,
                        SP8694 numeric(14,2) NOT NULL,
                        CONSTRAINT PK_DT8696 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT8777 definition

-- Drop table

-- DROP TABLE POS.dbo.DT8777;

CREATE TABLE DT8777 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP8773 char(9)  NOT NULL,
                        SP8774 numeric(4,0) NOT NULL,
                        SP8775 numeric(7,0) NOT NULL,
                        CONSTRAINT PK_DT8777 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT8875 definition

-- Drop table

-- DROP TABLE POS.dbo.DT8875;

CREATE TABLE DT8875 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP8869 char(9)  NOT NULL,
                        SP8870 datetime NOT NULL,
                        SP8871 char(5)  NOT NULL,
                        SP8872 char(5)  NOT NULL,
                        SP8873 char(2)  NOT NULL,
                        CONSTRAINT PK_DT8875 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT8956 definition

-- Drop table

-- DROP TABLE POS.dbo.DT8956;

CREATE TABLE DT8956 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP8950 char(9)  NOT NULL,
                        SP8951 datetime NOT NULL,
                        SP8952 datetime NOT NULL,
                        SP8953 char(20)  NOT NULL,
                        SP8954 char(20)  NOT NULL,
                        CONSTRAINT PK_DT8956 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT8984 definition

-- Drop table

-- DROP TABLE POS.dbo.DT8984;

CREATE TABLE DT8984 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP8980 char(9)  NOT NULL,
                        SP8981 numeric(5,0) NOT NULL,
                        SP8982 numeric(5,0) NOT NULL,
                        CONSTRAINT PK_DT8984 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT9025 definition

-- Drop table

-- DROP TABLE POS.dbo.DT9025;

CREATE TABLE DT9025 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP9023 char(9)  NOT NULL,
                        CONSTRAINT PK_DT9025 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT9111 definition

-- Drop table

-- DROP TABLE POS.dbo.DT9111;

CREATE TABLE DT9111 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP9105 char(9)  NOT NULL,
                        SP9288 numeric(13,3) NOT NULL,
                        SP9289 char(9)  NOT NULL,
                        SP9290 numeric(14,2) NOT NULL,
                        SP9291 numeric(9,3) NOT NULL,
                        SP9292 numeric(16,2) NOT NULL,
                        SP9293 char(9)  NOT NULL,
                        SP9294 numeric(14,2) NOT NULL,
                        SP9295 numeric(14,2) NOT NULL,
                        SP9296 numeric(10,0) NOT NULL,
                        SP9297 char(130)  NOT NULL,
                        SP9298 char(14)  NOT NULL,
                        SP9299 char(14)  NOT NULL,
                        CONSTRAINT PK_DT9111 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT9148 definition

-- Drop table

-- DROP TABLE POS.dbo.DT9148;

CREATE TABLE DT9148 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP9141 char(9)  NOT NULL,
                        SP9142 numeric(13,3) NOT NULL,
                        SP9143 char(9)  NOT NULL,
                        SP9144 numeric(9,3) NOT NULL,
                        SP9145 numeric(14,2) NOT NULL,
                        SP9146 numeric(14,2) NOT NULL,
                        CONSTRAINT PK_DT9148 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT9170 definition

-- Drop table

-- DROP TABLE POS.dbo.DT9170;

CREATE TABLE DT9170 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP9163 char(9)  NOT NULL,
                        SP9164 numeric(10,0) NOT NULL,
                        SP9165 numeric(10,0) NOT NULL,
                        SP9166 numeric(14,2) NOT NULL,
                        SP9167 numeric(14,2) NOT NULL,
                        SP9168 char(130)  NOT NULL,
                        SP9221 char(2)  NOT NULL,
                        SP9222 numeric(5,0) NOT NULL,
                        CONSTRAINT PK_DT9170 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.DT9264 definition

-- Drop table

-- DROP TABLE POS.dbo.DT9264;

CREATE TABLE DT9264 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        SP9250 char(9)  NOT NULL,
                        SP9251 numeric(13,3) NOT NULL,
                        SP9252 char(9)  NOT NULL,
                        SP9253 numeric(9,3) NOT NULL,
                        SP9254 numeric(14,2) NOT NULL,
                        SP9255 numeric(16,2) NOT NULL,
                        SP9256 char(130)  NOT NULL,
                        SP9257 char(2)  NOT NULL,
                        SP9258 char(9)  NOT NULL,
                        SP9259 numeric(14,2) NOT NULL,
                        SP9260 numeric(16,2) NOT NULL,
                        SP9261 numeric(5,0) NOT NULL,
                        SP9262 numeric(14,2) NOT NULL,
                        CONSTRAINT PK_DT9264 PRIMARY KEY (IDDOC,LINENO_)
);


-- POS.dbo.OS270223 definition

-- Drop table

-- DROP TABLE POS.dbo.OS270223;

CREATE TABLE OS270223 (
                          ITEM char(17)  NULL,
                          S277 numeric(9,0) NULL,
                          S925 numeric(9,0) NULL,
                          S899 numeric(9,0) NULL,
                          S590 numeric(9,0) NULL,
                          S5021 numeric(9,0) NULL,
                          S5124 numeric(9,0) NULL,
                          S5057 numeric(9,0) NULL,
                          S5020 numeric(9,0) NULL,
                          S289 numeric(9,0) NULL,
                          S5043 numeric(9,0) NULL,
                          S30 numeric(9,0) NULL,
                          S921 numeric(9,0) NULL,
                          S5015 numeric(9,0) NULL,
                          S908 numeric(9,0) NULL,
                          S5389 numeric(9,0) NULL,
                          S5010 numeric(9,0) NULL,
                          S5275 numeric(9,0) NULL,
                          S365 numeric(9,0) NULL,
                          S5255 numeric(9,0) NULL,
                          S5254 numeric(9,0) NULL,
                          S5023 numeric(9,0) NULL,
                          S5066 numeric(9,0) NULL,
                          S330 numeric(9,0) NULL,
                          S137 numeric(9,0) NULL,
                          S5187 numeric(9,0) NULL,
                          S941 numeric(9,0) NULL,
                          S5385 numeric(9,0) NULL,
                          S5263 numeric(9,0) NULL,
                          S622 numeric(9,0) NULL,
                          S5006 numeric(9,0) NULL,
                          S5265 numeric(9,0) NULL,
                          S5274 numeric(9,0) NULL,
                          S227 numeric(9,0) NULL,
                          S5314 numeric(9,0) NULL,
                          S5324 numeric(9,0) NULL,
                          S5067 numeric(9,0) NULL,
                          S5321 numeric(9,0) NULL,
                          S5375 numeric(9,0) NULL,
                          S5396 numeric(9,0) NULL,
                          S547 numeric(9,0) NULL,
                          S5386 numeric(9,0) NULL,
                          S5264 numeric(9,0) NULL,
                          S5134 numeric(9,0) NULL,
                          S5014 numeric(9,0) NULL,
                          S469 numeric(9,0) NULL
);
CREATE CLUSTERED INDEX ITEM ON dbo.OS270223 (  ITEM ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.RA2351 definition

-- Drop table

-- DROP TABLE POS.dbo.RA2351;

CREATE TABLE RA2351 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        ACTNO int NOT NULL,
                        DEBKRED bit NOT NULL,
                        SP2343 char(9)  NOT NULL,
                        SP2344 char(9)  NOT NULL,
                        SP2345 char(9)  NOT NULL,
                        SP4067 char(9)  NOT NULL,
                        SP2349 numeric(14,2) NOT NULL,
                        SP2350 numeric(14,2) NOT NULL,
                        SP2375 numeric(14,5) NOT NULL,
                        SP5191 numeric(14,2) NOT NULL,
                        SP5192 numeric(14,2) NOT NULL,
                        SP5193 numeric(14,5) NOT NULL,
                        CONSTRAINT PK_RA2351 PRIMARY KEY (IDDOC,LINENO_,ACTNO)
);


-- POS.dbo.RA2964 definition

-- Drop table

-- DROP TABLE POS.dbo.RA2964;

CREATE TABLE RA2964 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        ACTNO int NOT NULL,
                        DEBKRED bit NOT NULL,
                        SP4068 char(9)  NOT NULL,
                        SP3000 char(9)  NOT NULL,
                        SP3001 char(9)  NOT NULL,
                        SP2959 char(13)  NOT NULL,
                        SP2960 numeric(14,2) NOT NULL,
                        SP2961 numeric(14,2) NOT NULL,
                        SP2962 numeric(14,2) NOT NULL,
                        SP2963 char(9)  NOT NULL,
                        CONSTRAINT PK_RA2964 PRIMARY KEY (IDDOC,LINENO_,ACTNO)
);


-- POS.dbo.RA328 definition

-- Drop table

-- DROP TABLE POS.dbo.RA328;

CREATE TABLE RA328 (
                       IDDOC char(9)  NOT NULL,
                       LINENO_ smallint NOT NULL,
                       ACTNO int NOT NULL,
                       DEBKRED bit NOT NULL,
                       SP4061 char(9)  NOT NULL,
                       SP330 char(9)  NOT NULL,
                       SP331 char(9)  NOT NULL,
                       SP340 char(9)  NOT NULL,
                       SP341 char(9)  NOT NULL,
                       SP1554 datetime NOT NULL,
                       SP7404 numeric(14,2) NOT NULL,
                       SP342 numeric(14,5) NOT NULL,
                       SP421 numeric(14,2) NOT NULL,
                       SP343 numeric(14,2) NOT NULL,
                       SP344 numeric(14,2) NOT NULL,
                       SP347 char(9)  NOT NULL,
                       SP6818 numeric(17,2) NOT NULL,
                       SP7685 numeric(14,2) NOT NULL,
                       CONSTRAINT PK_RA328 PRIMARY KEY (IDDOC,LINENO_,ACTNO)
);


-- POS.dbo.RA351 definition

-- Drop table

-- DROP TABLE POS.dbo.RA351;

CREATE TABLE RA351 (
                       IDDOC char(9)  NOT NULL,
                       LINENO_ smallint NOT NULL,
                       ACTNO int NOT NULL,
                       DEBKRED bit NOT NULL,
                       SP4063 char(9)  NOT NULL,
                       SP365 char(9)  NOT NULL,
                       SP354 char(9)  NOT NULL,
                       SP355 char(9)  NOT NULL,
                       SP356 char(9)  NOT NULL,
                       SP364 char(13)  NOT NULL,
                       SP357 numeric(14,5) NOT NULL,
                       SP422 numeric(14,2) NOT NULL,
                       SP423 numeric(14,2) NOT NULL,
                       SP746 numeric(14,2) NOT NULL,
                       SP3539 numeric(14,2) NOT NULL,
                       SP360 char(9)  NOT NULL,
                       SP7746 numeric(14,2) NOT NULL,
                       CONSTRAINT PK_RA351 PRIMARY KEY (IDDOC,LINENO_,ACTNO)
);


-- POS.dbo.RA3549 definition

-- Drop table

-- DROP TABLE POS.dbo.RA3549;

CREATE TABLE RA3549 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        ACTNO int NOT NULL,
                        DEBKRED bit NOT NULL,
                        SP4315 char(13)  NOT NULL,
                        SP4316 char(9)  NOT NULL,
                        SP4317 char(9)  NOT NULL,
                        SP4318 numeric(14,2) NOT NULL,
                        SP3546 numeric(14,2) NOT NULL,
                        SP4319 numeric(14,2) NOT NULL,
                        SP4320 char(9)  NOT NULL,
                        SP4321 char(13)  NOT NULL,
                        CONSTRAINT PK_RA3549 PRIMARY KEY (IDDOC,LINENO_,ACTNO)
);


-- POS.dbo.RA405 definition

-- Drop table

-- DROP TABLE POS.dbo.RA405;

CREATE TABLE RA405 (
                       IDDOC char(9)  NOT NULL,
                       LINENO_ smallint NOT NULL,
                       ACTNO int NOT NULL,
                       DEBKRED bit NOT NULL,
                       SP8010 char(9)  NOT NULL,
                       SP408 char(9)  NOT NULL,
                       SP418 char(9)  NOT NULL,
                       SP411 numeric(14,5) NOT NULL,
                       SP8009 char(2)  NOT NULL,
                       SP8042 numeric(16,2) NOT NULL,
                       CONSTRAINT PK_RA405 PRIMARY KEY (IDDOC,LINENO_,ACTNO)
);


-- POS.dbo.RA4314 definition

-- Drop table

-- DROP TABLE POS.dbo.RA4314;

CREATE TABLE RA4314 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        ACTNO int NOT NULL,
                        DEBKRED bit NOT NULL,
                        SP4305 char(9)  NOT NULL,
                        SP4306 char(9)  NOT NULL,
                        SP4307 char(9)  NOT NULL,
                        SP4308 char(13)  NOT NULL,
                        SP4309 numeric(14,2) NOT NULL,
                        SP4310 numeric(14,2) NOT NULL,
                        SP4311 numeric(14,2) NOT NULL,
                        SP4312 char(9)  NOT NULL,
                        SP4313 char(13)  NOT NULL,
                        CONSTRAINT PK_RA4314 PRIMARY KEY (IDDOC,LINENO_,ACTNO)
);


-- POS.dbo.RA4335 definition

-- Drop table

-- DROP TABLE POS.dbo.RA4335;

CREATE TABLE RA4335 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        ACTNO int NOT NULL,
                        DEBKRED bit NOT NULL,
                        SP4322 char(9)  NOT NULL,
                        SP4323 char(9)  NOT NULL,
                        SP4324 char(9)  NOT NULL,
                        SP4325 char(9)  NOT NULL,
                        SP4326 char(13)  NOT NULL,
                        SP4327 numeric(14,2) NOT NULL,
                        SP4328 numeric(14,2) NOT NULL,
                        SP4329 numeric(14,2) NOT NULL,
                        SP4330 numeric(14,2) NOT NULL,
                        SP4331 numeric(14,2) NOT NULL,
                        SP4332 char(9)  NOT NULL,
                        SP4333 char(9)  NOT NULL,
                        SP4334 char(13)  NOT NULL,
                        CONSTRAINT PK_RA4335 PRIMARY KEY (IDDOC,LINENO_,ACTNO)
);


-- POS.dbo.RA4343 definition

-- Drop table

-- DROP TABLE POS.dbo.RA4343;

CREATE TABLE RA4343 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        ACTNO int NOT NULL,
                        DEBKRED bit NOT NULL,
                        SP4336 char(13)  NOT NULL,
                        SP4337 char(9)  NOT NULL,
                        SP4365 char(9)  NOT NULL,
                        SP4338 numeric(14,2) NOT NULL,
                        SP4339 numeric(14,2) NOT NULL,
                        SP4340 numeric(14,2) NOT NULL,
                        SP4341 char(9)  NOT NULL,
                        SP4342 char(13)  NOT NULL,
                        SP5345 char(9)  NOT NULL,
                        CONSTRAINT PK_RA4343 PRIMARY KEY (IDDOC,LINENO_,ACTNO)
);


-- POS.dbo.RA438 definition

-- Drop table

-- DROP TABLE POS.dbo.RA438;

CREATE TABLE RA438 (
                       IDDOC char(9)  NOT NULL,
                       LINENO_ smallint NOT NULL,
                       ACTNO int NOT NULL,
                       DEBKRED bit NOT NULL,
                       SP4064 char(9)  NOT NULL,
                       SP439 char(9)  NOT NULL,
                       SP441 char(9)  NOT NULL,
                       SP445 char(9)  NOT NULL,
                       SP2833 char(13)  NOT NULL,
                       SP442 numeric(14,5) NOT NULL,
                       SP443 numeric(14,2) NOT NULL,
                       SP5063 numeric(14,2) NOT NULL,
                       CONSTRAINT PK_RA438 PRIMARY KEY (IDDOC,LINENO_,ACTNO)
);


-- POS.dbo.RA4480 definition

-- Drop table

-- DROP TABLE POS.dbo.RA4480;

CREATE TABLE RA4480 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        ACTNO int NOT NULL,
                        DEBKRED bit NOT NULL,
                        SP4475 char(9)  NOT NULL,
                        SP4477 char(9)  NOT NULL,
                        SP4476 char(9)  NOT NULL,
                        SP4519 char(9)  NOT NULL,
                        SP4762 char(9)  NOT NULL,
                        SP4479 numeric(14,5) NOT NULL,
                        CONSTRAINT PK_RA4480 PRIMARY KEY (IDDOC,LINENO_,ACTNO)
);


-- POS.dbo.RA464 definition

-- Drop table

-- DROP TABLE POS.dbo.RA464;

CREATE TABLE RA464 (
                       IDDOC char(9)  NOT NULL,
                       LINENO_ smallint NOT NULL,
                       ACTNO int NOT NULL,
                       DEBKRED bit NOT NULL,
                       SP4467 char(9)  NOT NULL,
                       SP466 char(9)  NOT NULL,
                       SP470 char(9)  NOT NULL,
                       SP4470 char(9)  NOT NULL,
                       SP4471 numeric(14,5) NOT NULL,
                       SP4472 numeric(14,2) NOT NULL,
                       CONSTRAINT PK_RA464 PRIMARY KEY (IDDOC,LINENO_,ACTNO)
);


-- POS.dbo.RA4667 definition

-- Drop table

-- DROP TABLE POS.dbo.RA4667;

CREATE TABLE RA4667 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        ACTNO int NOT NULL,
                        DEBKRED bit NOT NULL,
                        SP4663 char(9)  NOT NULL,
                        SP4664 char(9)  NOT NULL,
                        SP4665 char(9)  NOT NULL,
                        SP4666 numeric(14,5) NOT NULL,
                        CONSTRAINT PK_RA4667 PRIMARY KEY (IDDOC,LINENO_,ACTNO)
);


-- POS.dbo.RA4674 definition

-- Drop table

-- DROP TABLE POS.dbo.RA4674;

CREATE TABLE RA4674 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        ACTNO int NOT NULL,
                        DEBKRED bit NOT NULL,
                        SP4668 char(9)  NOT NULL,
                        SP4669 char(9)  NOT NULL,
                        SP4670 char(9)  NOT NULL,
                        SP4671 char(9)  NOT NULL,
                        SP4672 numeric(14,5) NOT NULL,
                        SP4673 numeric(14,2) NOT NULL,
                        CONSTRAINT PK_RA4674 PRIMARY KEY (IDDOC,LINENO_,ACTNO)
);


-- POS.dbo.RA635 definition

-- Drop table

-- DROP TABLE POS.dbo.RA635;

CREATE TABLE RA635 (
                       IDDOC char(9)  NOT NULL,
                       LINENO_ smallint NOT NULL,
                       ACTNO int NOT NULL,
                       DEBKRED bit NOT NULL,
                       SP4065 char(9)  NOT NULL,
                       SP1919 char(9)  NOT NULL,
                       SP1944 char(9)  NOT NULL,
                       SP646 numeric(14,2) NOT NULL,
                       SP685 numeric(14,2) NOT NULL,
                       SP647 numeric(14,2) NOT NULL,
                       SP687 char(9)  NOT NULL,
                       SP4273 char(9)  NOT NULL,
                       CONSTRAINT PK_RA635 PRIMARY KEY (IDDOC,LINENO_,ACTNO)
);


-- POS.dbo.RA639 definition

-- Drop table

-- DROP TABLE POS.dbo.RA639;

CREATE TABLE RA639 (
                       IDDOC char(9)  NOT NULL,
                       LINENO_ smallint NOT NULL,
                       ACTNO int NOT NULL,
                       DEBKRED bit NOT NULL,
                       SP4066 char(9)  NOT NULL,
                       SP641 char(9)  NOT NULL,
                       SP644 numeric(14,2) NOT NULL,
                       SP642 numeric(14,2) NOT NULL,
                       SP643 numeric(14,2) NOT NULL,
                       SP686 char(9)  NOT NULL,
                       SP4274 char(9)  NOT NULL,
                       CONSTRAINT PK_RA639 PRIMARY KEY (IDDOC,LINENO_,ACTNO)
);


-- POS.dbo.RA9048 definition

-- Drop table

-- DROP TABLE POS.dbo.RA9048;

CREATE TABLE RA9048 (
                        IDDOC char(9)  NOT NULL,
                        LINENO_ smallint NOT NULL,
                        ACTNO int NOT NULL,
                        DEBKRED bit NOT NULL,
                        SP9046 char(9)  NOT NULL,
                        SP9047 numeric(14,2) NOT NULL,
                        CONSTRAINT PK_RA9048 PRIMARY KEY (IDDOC,LINENO_,ACTNO)
);


-- POS.dbo.RG2351 definition

-- Drop table

-- DROP TABLE POS.dbo.RG2351;

CREATE TABLE RG2351 (
                        PERIOD datetime NOT NULL,
                        SP2343 char(9)  NOT NULL,
                        SP2344 char(9)  NOT NULL,
                        SP2345 char(9)  NOT NULL,
                        SP4067 char(9)  NOT NULL,
                        SP2349 numeric(14,2) NOT NULL,
                        SP2350 numeric(14,2) NOT NULL,
                        SP2375 numeric(14,5) NOT NULL,
                        SP5191 numeric(14,2) NOT NULL,
                        SP5192 numeric(14,2) NOT NULL,
                        SP5193 numeric(14,5) NOT NULL,
                        CONSTRAINT PK_RG2351 PRIMARY KEY (PERIOD,SP2343,SP2344,SP2345,SP4067)
);


-- POS.dbo.RG2964 definition

-- Drop table

-- DROP TABLE POS.dbo.RG2964;

CREATE TABLE RG2964 (
                        PERIOD datetime NOT NULL,
                        SP4068 char(9)  NOT NULL,
                        SP3000 char(9)  NOT NULL,
                        SP3001 char(9)  NOT NULL,
                        SP2959 char(13)  NOT NULL,
                        SP2960 numeric(14,2) NOT NULL,
                        SP2961 numeric(14,2) NOT NULL,
                        SP2962 numeric(14,2) NOT NULL,
                        CONSTRAINT PK_RG2964 PRIMARY KEY (PERIOD,SP4068,SP3000,SP3001,SP2959)
);


-- POS.dbo.RG328 definition

-- Drop table

-- DROP TABLE POS.dbo.RG328;

CREATE TABLE RG328 (
                       PERIOD datetime NOT NULL,
                       SP4061 char(9)  NOT NULL,
                       SP330 char(9)  NOT NULL,
                       SP331 char(9)  NOT NULL,
                       SP340 char(9)  NOT NULL,
                       SP341 char(9)  NOT NULL,
                       SP1554 datetime NOT NULL,
                       SP7404 numeric(14,2) NOT NULL,
                       SP342 numeric(14,5) NOT NULL,
                       SP421 numeric(14,2) NOT NULL,
                       SP343 numeric(14,2) NOT NULL,
                       SP344 numeric(14,2) NOT NULL,
                       CONSTRAINT PK_RG328 PRIMARY KEY (PERIOD,SP4061,SP330,SP331,SP340,SP341,SP1554,SP7404)
);
CREATE NONCLUSTERED INDEX VIA331 ON dbo.RG328 (  PERIOD ASC  , SP331 ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.RG351 definition

-- Drop table

-- DROP TABLE POS.dbo.RG351;

CREATE TABLE RG351 (
                       PERIOD datetime NOT NULL,
                       SP4063 char(9)  NOT NULL,
                       SP365 char(9)  NOT NULL,
                       SP354 char(9)  NOT NULL,
                       SP355 char(9)  NOT NULL,
                       SP356 char(9)  NOT NULL,
                       SP364 char(13)  NOT NULL,
                       SP357 numeric(14,5) NOT NULL,
                       SP422 numeric(14,2) NOT NULL,
                       SP423 numeric(14,2) NOT NULL,
                       SP746 numeric(14,2) NOT NULL,
                       SP3539 numeric(14,2) NOT NULL,
                       CONSTRAINT PK_RG351 PRIMARY KEY (PERIOD,SP4063,SP365,SP354,SP355,SP356,SP364)
);
CREATE NONCLUSTERED INDEX VIA354 ON dbo.RG351 (  PERIOD ASC  , SP354 ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.RG3549 definition

-- Drop table

-- DROP TABLE POS.dbo.RG3549;

CREATE TABLE RG3549 (
                        PERIOD datetime NOT NULL,
                        SP4315 char(13)  NOT NULL,
                        SP4316 char(9)  NOT NULL,
                        SP4317 char(9)  NOT NULL,
                        SP4318 numeric(14,2) NOT NULL,
                        SP3546 numeric(14,2) NOT NULL,
                        SP4319 numeric(14,2) NOT NULL,
                        CONSTRAINT PK_RG3549 PRIMARY KEY (PERIOD,SP4315,SP4316,SP4317)
);


-- POS.dbo.RG405 definition

-- Drop table

-- DROP TABLE POS.dbo.RG405;

CREATE TABLE RG405 (
                       PERIOD datetime NOT NULL,
                       SP8010 char(9)  NOT NULL,
                       SP408 char(9)  NOT NULL,
                       SP418 char(9)  NOT NULL,
                       SP411 numeric(14,5) NOT NULL,
                       CONSTRAINT PK_RG405 PRIMARY KEY (PERIOD,SP8010,SP408,SP418)
);
CREATE NONCLUSTERED INDEX VIA408 ON dbo.RG405 (  PERIOD ASC  , SP408 ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.RG4314 definition

-- Drop table

-- DROP TABLE POS.dbo.RG4314;

CREATE TABLE RG4314 (
                        PERIOD datetime NOT NULL,
                        SP4305 char(9)  NOT NULL,
                        SP4306 char(9)  NOT NULL,
                        SP4307 char(9)  NOT NULL,
                        SP4308 char(13)  NOT NULL,
                        SP4309 numeric(14,2) NOT NULL,
                        SP4310 numeric(14,2) NOT NULL,
                        SP4311 numeric(14,2) NOT NULL,
                        CONSTRAINT PK_RG4314 PRIMARY KEY (PERIOD,SP4305,SP4306,SP4307,SP4308)
);


-- POS.dbo.RG4335 definition

-- Drop table

-- DROP TABLE POS.dbo.RG4335;

CREATE TABLE RG4335 (
                        PERIOD datetime NOT NULL,
                        SP4322 char(9)  NOT NULL,
                        SP4323 char(9)  NOT NULL,
                        SP4324 char(9)  NOT NULL,
                        SP4325 char(9)  NOT NULL,
                        SP4326 char(13)  NOT NULL,
                        SP4327 numeric(14,2) NOT NULL,
                        SP4328 numeric(14,2) NOT NULL,
                        SP4329 numeric(14,2) NOT NULL,
                        SP4330 numeric(14,2) NOT NULL,
                        SP4331 numeric(14,2) NOT NULL,
                        CONSTRAINT PK_RG4335 PRIMARY KEY (PERIOD,SP4322,SP4323,SP4324,SP4325,SP4326)
);


-- POS.dbo.RG4343 definition

-- Drop table

-- DROP TABLE POS.dbo.RG4343;

CREATE TABLE RG4343 (
                        PERIOD datetime NOT NULL,
                        SP4336 char(13)  NOT NULL,
                        SP4337 char(9)  NOT NULL,
                        SP4365 char(9)  NOT NULL,
                        SP4338 numeric(14,2) NOT NULL,
                        SP4339 numeric(14,2) NOT NULL,
                        SP4340 numeric(14,2) NOT NULL,
                        CONSTRAINT PK_RG4343 PRIMARY KEY (PERIOD,SP4336,SP4337,SP4365)
);


-- POS.dbo.RG438 definition

-- Drop table

-- DROP TABLE POS.dbo.RG438;

CREATE TABLE RG438 (
                       PERIOD datetime NOT NULL,
                       SP4064 char(9)  NOT NULL,
                       SP439 char(9)  NOT NULL,
                       SP441 char(9)  NOT NULL,
                       SP445 char(9)  NOT NULL,
                       SP2833 char(13)  NOT NULL,
                       SP442 numeric(14,5) NOT NULL,
                       SP443 numeric(14,2) NOT NULL,
                       CONSTRAINT PK_RG438 PRIMARY KEY (PERIOD,SP4064,SP439,SP441,SP445,SP2833)
);
CREATE NONCLUSTERED INDEX VIA441 ON dbo.RG438 (  PERIOD ASC  , SP441 ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.RG4480 definition

-- Drop table

-- DROP TABLE POS.dbo.RG4480;

CREATE TABLE RG4480 (
                        PERIOD datetime NOT NULL,
                        SP4475 char(9)  NOT NULL,
                        SP4477 char(9)  NOT NULL,
                        SP4476 char(9)  NOT NULL,
                        SP4519 char(9)  NOT NULL,
                        SP4762 char(9)  NOT NULL,
                        SP4479 numeric(14,5) NOT NULL,
                        CONSTRAINT PK_RG4480 PRIMARY KEY (PERIOD,SP4475,SP4477,SP4476,SP4519,SP4762)
);
CREATE NONCLUSTERED INDEX VIA4477 ON dbo.RG4480 (  PERIOD ASC  , SP4477 ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE NONCLUSTERED INDEX VIA4762 ON dbo.RG4480 (  PERIOD ASC  , SP4762 ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.RG464 definition

-- Drop table

-- DROP TABLE POS.dbo.RG464;

CREATE TABLE RG464 (
                       PERIOD datetime NOT NULL,
                       SP4467 char(9)  NOT NULL,
                       SP466 char(9)  NOT NULL,
                       SP470 char(9)  NOT NULL,
                       SP4470 char(9)  NOT NULL,
                       SP4471 numeric(14,5) NOT NULL,
                       SP4472 numeric(14,2) NOT NULL,
                       CONSTRAINT PK_RG464 PRIMARY KEY (PERIOD,SP4467,SP466,SP470,SP4470)
);
CREATE NONCLUSTERED INDEX VIA466 ON dbo.RG464 (  PERIOD ASC  , SP466 ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.RG4667 definition

-- Drop table

-- DROP TABLE POS.dbo.RG4667;

CREATE TABLE RG4667 (
                        PERIOD datetime NOT NULL,
                        SP4663 char(9)  NOT NULL,
                        SP4664 char(9)  NOT NULL,
                        SP4665 char(9)  NOT NULL,
                        SP4666 numeric(14,5) NOT NULL,
                        CONSTRAINT PK_RG4667 PRIMARY KEY (PERIOD,SP4663,SP4664,SP4665)
);


-- POS.dbo.RG4674 definition

-- Drop table

-- DROP TABLE POS.dbo.RG4674;

CREATE TABLE RG4674 (
                        PERIOD datetime NOT NULL,
                        SP4668 char(9)  NOT NULL,
                        SP4669 char(9)  NOT NULL,
                        SP4670 char(9)  NOT NULL,
                        SP4671 char(9)  NOT NULL,
                        SP4672 numeric(14,5) NOT NULL,
                        SP4673 numeric(14,2) NOT NULL,
                        CONSTRAINT PK_RG4674 PRIMARY KEY (PERIOD,SP4668,SP4669,SP4670,SP4671)
);
CREATE NONCLUSTERED INDEX VIA4671 ON dbo.RG4674 (  PERIOD ASC  , SP4671 ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.RG635 definition

-- Drop table

-- DROP TABLE POS.dbo.RG635;

CREATE TABLE RG635 (
                       PERIOD datetime NOT NULL,
                       SP4065 char(9)  NOT NULL,
                       SP1919 char(9)  NOT NULL,
                       SP1944 char(9)  NOT NULL,
                       SP646 numeric(14,2) NOT NULL,
                       SP685 numeric(14,2) NOT NULL,
                       SP647 numeric(14,2) NOT NULL,
                       CONSTRAINT PK_RG635 PRIMARY KEY (PERIOD,SP4065,SP1919,SP1944)
);


-- POS.dbo.RG639 definition

-- Drop table

-- DROP TABLE POS.dbo.RG639;

CREATE TABLE RG639 (
                       PERIOD datetime NOT NULL,
                       SP4066 char(9)  NOT NULL,
                       SP641 char(9)  NOT NULL,
                       SP644 numeric(14,2) NOT NULL,
                       SP642 numeric(14,2) NOT NULL,
                       SP643 numeric(14,2) NOT NULL,
                       CONSTRAINT PK_RG639 PRIMARY KEY (PERIOD,SP4066,SP641)
);


-- POS.dbo.RG9048 definition

-- Drop table

-- DROP TABLE POS.dbo.RG9048;

CREATE TABLE RG9048 (
                        PERIOD datetime NOT NULL,
                        SP9046 char(9)  NOT NULL,
                        SP9047 numeric(14,2) NOT NULL,
                        CONSTRAINT PK_RG9048 PRIMARY KEY (PERIOD,SP9046)
);


-- POS.dbo.SC131 definition

-- Drop table

-- DROP TABLE POS.dbo.SC131;

CREATE TABLE SC131 (
                       ROW_ID int IDENTITY(1,1) NOT NULL,
                       ID char(9)  NOT NULL,
                       CODE char(5)  NOT NULL,
                       DESCR char(50)  NOT NULL,
                       ISMARK bit NOT NULL,
                       VERSTAMP int NOT NULL,
                       SP145 char(2)  NOT NULL,
                       SP135 char(20)  NOT NULL,
                       SP134 datetime NOT NULL,
                       SP141 char(10)  NOT NULL,
                       SP665 char(4)  NOT NULL,
                       SP140 char(5)  NOT NULL,
                       SP4101 char(2)  NOT NULL,
                       SP4102 char(2)  NOT NULL,
                       SP5350 char(4)  NOT NULL,
                       SP4828 numeric(1,0) NOT NULL,
                       SP4829 numeric(1,0) NOT NULL,
                       SP6568 char(9)  NOT NULL,
                       SP148 text  NULL,
                       SP149 text  NULL,
                       SP144 text  NULL,
                       SP5346 text  NULL,
                       SP593 text  NULL,
                       SP143 text  NULL,
                       SP664 text  NULL,
                       SP5347 text  NULL,
                       SP5348 text  NULL,
                       SP2905 text  NULL,
                       SP5349 text  NULL,
                       SP137 text  NULL,
                       CONSTRAINT PK_SC131 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC131 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC131 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC131 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI135 ON dbo.SC131 (  SP135 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC14 definition

-- Drop table

-- DROP TABLE POS.dbo.SC14;

CREATE TABLE SC14 (
                      ROW_ID int IDENTITY(1,1) NOT NULL,
                      ID char(9)  NOT NULL,
                      CODE char(3)  NOT NULL,
                      DESCR char(10)  NOT NULL,
                      ISMARK bit NOT NULL,
                      VERSTAMP int NOT NULL,
                      SP18 char(50)  NOT NULL,
                      SP15 char(50)  NOT NULL,
                      CONSTRAINT PK_SC14 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC14 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC14 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC14 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC163 definition

-- Drop table

-- DROP TABLE POS.dbo.SC163;

CREATE TABLE SC163 (
                       ROW_ID int IDENTITY(1,1) NOT NULL,
                       ID char(9)  NOT NULL,
                       PARENTID char(9)  NOT NULL,
                       CODE char(9)  NOT NULL,
                       DESCR char(100)  NOT NULL,
                       ISFOLDER tinyint NOT NULL,
                       ISMARK bit NOT NULL,
                       VERSTAMP int NOT NULL,
                       SP164 char(50)  NOT NULL,
                       SP165 char(20)  NOT NULL,
                       SP167 char(30)  NOT NULL,
                       SP166 text  NULL,
                       CONSTRAINT PK_SC163 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC163 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC163 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC163 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX PCODE ON dbo.SC163 (  PARENTID ASC  , ISFOLDER ASC  , CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX PDESCR ON dbo.SC163 (  PARENTID ASC  , ISFOLDER ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC1710 definition

-- Drop table

-- DROP TABLE POS.dbo.SC1710;

CREATE TABLE SC1710 (
                        ROW_ID int IDENTITY(1,1) NOT NULL,
                        ID char(9)  NOT NULL,
                        CODE char(8)  NOT NULL,
                        DESCR char(25)  NOT NULL,
                        ISMARK bit NOT NULL,
                        VERSTAMP int NOT NULL,
                        SP1712 char(9)  NOT NULL,
                        SP2410 char(9)  NOT NULL,
                        SP1713 char(9)  NOT NULL,
                        SP1714 char(20)  NOT NULL,
                        SP1717 datetime NOT NULL,
                        SP1716 datetime NOT NULL,
                        SP2412 numeric(1,0) NOT NULL,
                        SP1715 char(35)  NOT NULL,
                        SP4219 char(20)  NOT NULL,
                        SP2411 numeric(1,0) NOT NULL,
                        SP2409 char(13)  NOT NULL,
                        SP2413 text  NULL,
                        SP6129 text  NULL,
                        CONSTRAINT PK_SC1710 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC1710 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC1710 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC1710 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI2409 ON dbo.SC1710 (  SP2409 ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI4219 ON dbo.SC1710 (  SP4219 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC172 definition

-- Drop table

-- DROP TABLE POS.dbo.SC172;

CREATE TABLE SC172 (
                       ROW_ID int IDENTITY(1,1) NOT NULL,
                       ID char(9)  NOT NULL,
                       PARENTID char(9)  NOT NULL,
                       CODE char(8)  NOT NULL,
                       DESCR char(50)  NOT NULL,
                       ISFOLDER tinyint NOT NULL,
                       ISMARK bit NOT NULL,
                       VERSTAMP int NOT NULL,
                       SP521 char(13)  NOT NULL,
                       SP667 char(9)  NOT NULL,
                       SP4137 char(9)  NOT NULL,
                       SP573 char(40)  NOT NULL,
                       SP4426 char(9)  NOT NULL,
                       SP572 char(40)  NOT NULL,
                       SP583 char(9)  NOT NULL,
                       SP9067 char(17)  NOT NULL,
                       SP186 text  NULL,
                       CONSTRAINT PK_SC172 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC172 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC172 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC172 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX PCODE ON dbo.SC172 (  PARENTID ASC  , ISFOLDER ASC  , CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX PDESCR ON dbo.SC172 (  PARENTID ASC  , ISFOLDER ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI521 ON dbo.SC172 (  SP521 ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI573 ON dbo.SC172 (  SP573 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI9067 ON dbo.SC172 (  SP9067 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VIP521 ON dbo.SC172 (  PARENTID ASC  , ISFOLDER ASC  , SP521 ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VIP573 ON dbo.SC172 (  PARENTID ASC  , ISFOLDER ASC  , SP573 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VIP9067 ON dbo.SC172 (  PARENTID ASC  , ISFOLDER ASC  , SP9067 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC1809 definition

-- Drop table

-- DROP TABLE POS.dbo.SC1809;

CREATE TABLE SC1809 (
                        ROW_ID int IDENTITY(1,1) NOT NULL,
                        ID char(9)  NOT NULL,
                        CODE char(5)  NOT NULL,
                        DESCR char(50)  NOT NULL,
                        ISMARK bit NOT NULL,
                        VERSTAMP int NOT NULL,
                        SP3356 char(9)  NOT NULL,
                        SP3355 char(10)  NOT NULL,
                        SP8440 numeric(2,0) NOT NULL,
                        SP8632 numeric(1,0) NOT NULL,
                        SP8766 numeric(1,0) NOT NULL,
                        CONSTRAINT PK_SC1809 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC1809 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC1809 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC1809 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI3355 ON dbo.SC1809 (  SP3355 ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC204 definition

-- Drop table

-- DROP TABLE POS.dbo.SC204;

CREATE TABLE SC204 (
                       ROW_ID int IDENTITY(1,1) NOT NULL,
                       ID char(9)  NOT NULL,
                       PARENTID char(9)  NOT NULL,
                       CODE char(8)  NOT NULL,
                       DESCR char(50)  NOT NULL,
                       PARENTEXT char(9)  NOT NULL,
                       ISFOLDER tinyint NOT NULL,
                       ISMARK bit NOT NULL,
                       VERSTAMP int NOT NULL,
                       SP668 char(9)  NOT NULL,
                       SP1948 char(9)  NOT NULL,
                       SP1920 char(9)  NOT NULL,
                       SP870 numeric(4,0) NOT NULL,
                       SP2285 numeric(14,2) NOT NULL,
                       SP4764 numeric(1,0) NOT NULL,
                       CONSTRAINT PK_SC204 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC204 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC204 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC204 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX PCODE ON dbo.SC204 (  PARENTEXT ASC  , PARENTID ASC  , ISFOLDER ASC  , CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX PDESCR ON dbo.SC204 (  PARENTEXT ASC  , PARENTID ASC  , ISFOLDER ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC214 definition

-- Drop table

-- DROP TABLE POS.dbo.SC214;

CREATE TABLE SC214 (
                       ROW_ID int IDENTITY(1,1) NOT NULL,
                       ID char(9)  NOT NULL,
                       CODE char(8)  NOT NULL,
                       PARENTEXT char(9)  NOT NULL,
                       ISMARK bit NOT NULL,
                       VERSTAMP int NOT NULL,
                       SP216 char(13)  NOT NULL,
                       SP586 char(9)  NOT NULL,
                       SP585 char(9)  NOT NULL,
                       SP436 char(9)  NOT NULL,
                       SP217 char(9)  NOT NULL,
                       SP876 char(9)  NOT NULL,
                       SP2796 numeric(14,2) NOT NULL,
                       CONSTRAINT PK_SC214 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC214 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC214 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX PCODE ON dbo.SC214 (  PARENTEXT ASC  , CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC219 definition

-- Drop table

-- DROP TABLE POS.dbo.SC219;

CREATE TABLE SC219 (
                       ROW_ID int IDENTITY(1,1) NOT NULL,
                       ID char(9)  NOT NULL,
                       CODE char(5)  NOT NULL,
                       DESCR char(25)  NOT NULL,
                       ISMARK bit NOT NULL,
                       VERSTAMP int NOT NULL,
                       SP224 numeric(1,0) NOT NULL,
                       SP225 char(9)  NOT NULL,
                       SP221 numeric(5,2) NOT NULL,
                       SP4877 char(9)  NOT NULL,
                       SP226 numeric(1,0) NOT NULL,
                       SP222 numeric(1,0) NOT NULL,
                       SP237 char(9)  NOT NULL,
                       SP8453 char(17)  NOT NULL,
                       SP220 text  NULL,
                       CONSTRAINT PK_SC219 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC219 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC219 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC219 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI8453 ON dbo.SC219 (  SP8453 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC2221 definition

-- Drop table

-- DROP TABLE POS.dbo.SC2221;

CREATE TABLE SC2221 (
                        ROW_ID int IDENTITY(1,1) NOT NULL,
                        ID char(9)  NOT NULL,
                        PARENTID char(9)  NOT NULL,
                        CODE char(24)  NOT NULL,
                        DESCR char(100)  NOT NULL,
                        ISFOLDER tinyint NOT NULL,
                        ISMARK bit NOT NULL,
                        VERSTAMP int NOT NULL,
                        SP2519 char(9)  NOT NULL,
                        SP2520 char(9)  NOT NULL,
                        SP2521 char(9)  NOT NULL,
                        SP2522 numeric(1,0) NOT NULL,
                        SP2523 numeric(1,0) NOT NULL,
                        SP2524 numeric(1,0) NOT NULL,
                        SP2527 char(25)  NOT NULL,
                        CONSTRAINT PK_SC2221 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC2221 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC2221 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC2221 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX PCODE ON dbo.SC2221 (  PARENTID ASC  , CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX PDESCR ON dbo.SC2221 (  PARENTID ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI2527 ON dbo.SC2221 (  SP2527 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VIP2527 ON dbo.SC2221 (  PARENTID ASC  , SP2527 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC2335 definition

-- Drop table

-- DROP TABLE POS.dbo.SC2335;

CREATE TABLE SC2335 (
                        ROW_ID int IDENTITY(1,1) NOT NULL,
                        ID char(9)  NOT NULL,
                        CODE char(5)  NOT NULL,
                        DESCR char(25)  NOT NULL,
                        ISMARK bit NOT NULL,
                        VERSTAMP int NOT NULL,
                        SP2328 numeric(1,0) NOT NULL,
                        SP2329 numeric(1,0) NOT NULL,
                        SP2330 numeric(1,0) NOT NULL,
                        SP2331 numeric(1,0) NOT NULL,
                        SP2333 numeric(1,0) NOT NULL,
                        CONSTRAINT PK_SC2335 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC2335 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC2335 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC2335 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC2532 definition

-- Drop table

-- DROP TABLE POS.dbo.SC2532;

CREATE TABLE SC2532 (
                        ROW_ID int IDENTITY(1,1) NOT NULL,
                        ID char(9)  NOT NULL,
                        CODE char(5)  NOT NULL,
                        DESCR char(100)  NOT NULL,
                        ISMARK bit NOT NULL,
                        VERSTAMP int NOT NULL,
                        SP2530 char(141)  NOT NULL,
                        SP5356 char(141)  NOT NULL,
                        SP5357 char(128)  NOT NULL,
                        SP5358 char(128)  NOT NULL,
                        CONSTRAINT PK_SC2532 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC2532 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC2532 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC2532 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI5357 ON dbo.SC2532 (  SP5357 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC2534 definition

-- Drop table

-- DROP TABLE POS.dbo.SC2534;

CREATE TABLE SC2534 (
                        ROW_ID int IDENTITY(1,1) NOT NULL,
                        ID char(9)  NOT NULL,
                        PARENTID char(9)  NOT NULL,
                        DESCR char(100)  NOT NULL,
                        PARENTEXT char(9)  NOT NULL,
                        ISFOLDER tinyint NOT NULL,
                        ISMARK bit NOT NULL,
                        VERSTAMP int NOT NULL,
                        SP5355 char(100)  NOT NULL,
                        CONSTRAINT PK_SC2534 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC2534 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC2534 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX PDESCR ON dbo.SC2534 (  PARENTEXT ASC  , PARENTID ASC  , ISFOLDER ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI5355 ON dbo.SC2534 (  SP5355 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VIP5355 ON dbo.SC2534 (  PARENTEXT ASC  , PARENTID ASC  , ISFOLDER ASC  , SP5355 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC2537 definition

-- Drop table

-- DROP TABLE POS.dbo.SC2537;

CREATE TABLE SC2537 (
                        ROW_ID int IDENTITY(1,1) NOT NULL,
                        ID char(9)  NOT NULL,
                        CODE char(5)  NOT NULL,
                        DESCR char(50)  NOT NULL,
                        ISMARK bit NOT NULL,
                        VERSTAMP int NOT NULL,
                        SP2535 char(50)  NOT NULL,
                        SP3211 char(9)  NOT NULL,
                        CONSTRAINT PK_SC2537 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC2537 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC2537 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC2537 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI2535 ON dbo.SC2537 (  SP2535 ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC2543 definition

-- Drop table

-- DROP TABLE POS.dbo.SC2543;

CREATE TABLE SC2543 (
                        ROW_ID int IDENTITY(1,1) NOT NULL,
                        ID char(9)  NOT NULL,
                        PARENTID char(9)  NOT NULL,
                        CODE char(5)  NOT NULL,
                        DESCR char(100)  NOT NULL,
                        PARENTEXT char(9)  NOT NULL,
                        ISFOLDER tinyint NOT NULL,
                        ISMARK bit NOT NULL,
                        VERSTAMP int NOT NULL,
                        SP2538 char(50)  NOT NULL,
                        SP2539 char(1)  NOT NULL,
                        SP2857 char(23)  NOT NULL,
                        TSP2857 char(3)  NOT NULL,
                        SP2541 char(9)  NOT NULL,
                        CONSTRAINT PK_SC2543 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC2543 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC2543 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC2543 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX PCODE ON dbo.SC2543 (  PARENTEXT ASC  , PARENTID ASC  , ISFOLDER ASC  , CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX PDESCR ON dbo.SC2543 (  PARENTEXT ASC  , PARENTID ASC  , ISFOLDER ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI2538 ON dbo.SC2543 (  SP2538 ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI2541 ON dbo.SC2543 (  SP2541 ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VIP2538 ON dbo.SC2543 (  PARENTEXT ASC  , PARENTID ASC  , ISFOLDER ASC  , SP2538 ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VIP2541 ON dbo.SC2543 (  PARENTEXT ASC  , PARENTID ASC  , ISFOLDER ASC  , SP2541 ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC2875 definition

-- Drop table

-- DROP TABLE POS.dbo.SC2875;

CREATE TABLE SC2875 (
                        ROW_ID int IDENTITY(1,1) NOT NULL,
                        ID char(9)  NOT NULL,
                        PARENTID char(9)  NOT NULL,
                        CODE char(5)  NOT NULL,
                        DESCR char(50)  NOT NULL,
                        PARENTEXT char(9)  NOT NULL,
                        ISFOLDER tinyint NOT NULL,
                        ISMARK bit NOT NULL,
                        VERSTAMP int NOT NULL,
                        SP2858 char(9)  NOT NULL,
                        SP4003 numeric(1,0) NOT NULL,
                        SP2860 char(23)  NOT NULL,
                        TSP2860 char(3)  NOT NULL,
                        SP2861 char(23)  NOT NULL,
                        TSP2861 char(3)  NOT NULL,
                        SP2862 char(23)  NOT NULL,
                        TSP2862 char(3)  NOT NULL,
                        SP2863 char(23)  NOT NULL,
                        TSP2863 char(3)  NOT NULL,
                        SP4004 numeric(1,0) NOT NULL,
                        SP2865 char(23)  NOT NULL,
                        TSP2865 char(3)  NOT NULL,
                        SP2866 char(23)  NOT NULL,
                        TSP2866 char(3)  NOT NULL,
                        SP2867 char(23)  NOT NULL,
                        TSP2867 char(3)  NOT NULL,
                        SP2868 char(23)  NOT NULL,
                        TSP2868 char(3)  NOT NULL,
                        SP2869 char(9)  NOT NULL,
                        SP2870 char(9)  NOT NULL,
                        SP2871 char(9)  NOT NULL,
                        SP2872 char(9)  NOT NULL,
                        SP4428 numeric(1,0) NOT NULL,
                        SP7793 char(2)  NOT NULL,
                        SP3439 char(9)  NOT NULL,
                        SP6567 char(9)  NOT NULL,
                        SP7919 char(9)  NOT NULL,
                        SP2873 text  NULL,
                        CONSTRAINT PK_SC2875 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC2875 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC2875 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC2875 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX PCODE ON dbo.SC2875 (  PARENTEXT ASC  , PARENTID ASC  , ISFOLDER ASC  , CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX PDESCR ON dbo.SC2875 (  PARENTEXT ASC  , PARENTID ASC  , ISFOLDER ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI2858 ON dbo.SC2875 (  SP2858 ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI2860 ON dbo.SC2875 (  SP2860 ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI2865 ON dbo.SC2875 (  SP2865 ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI7793 ON dbo.SC2875 (  SP7793 ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VIP2858 ON dbo.SC2875 (  PARENTEXT ASC  , PARENTID ASC  , ISFOLDER ASC  , SP2858 ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VIP2860 ON dbo.SC2875 (  PARENTEXT ASC  , PARENTID ASC  , ISFOLDER ASC  , SP2860 ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VIP2865 ON dbo.SC2875 (  PARENTEXT ASC  , PARENTID ASC  , ISFOLDER ASC  , SP2865 ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VIP7793 ON dbo.SC2875 (  PARENTEXT ASC  , PARENTID ASC  , ISFOLDER ASC  , SP7793 ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC30 definition

-- Drop table

-- DROP TABLE POS.dbo.SC30;

CREATE TABLE SC30 (
                      ROW_ID int IDENTITY(1,1) NOT NULL,
                      ID char(9)  NOT NULL,
                      CODE char(24)  NOT NULL,
                      DESCR char(50)  NOT NULL,
                      ISMARK bit NOT NULL,
                      VERSTAMP int NOT NULL,
                      SP5843 numeric(1,0) NOT NULL,
                      SP1949 char(9)  NOT NULL,
                      SP5578 datetime NOT NULL,
                      SP2643 char(9)  NOT NULL,
                      SP2272 char(9)  NOT NULL,
                      SP1950 char(9)  NOT NULL,
                      SP1951 char(9)  NOT NULL,
                      SP4010 char(9)  NOT NULL,
                      SP2274 char(9)  NOT NULL,
                      SP2275 char(9)  NOT NULL,
                      SP5727 char(9)  NOT NULL,
                      SP873 char(9)  NOT NULL,
                      SP1953 char(9)  NOT NULL,
                      SP1954 char(9)  NOT NULL,
                      SP5354 char(10)  NOT NULL,
                      SP2336 char(9)  NOT NULL,
                      SP1952 char(9)  NOT NULL,
                      SP6811 numeric(1,0) NOT NULL,
                      CONSTRAINT PK_SC30 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC30 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC30 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC30 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI1952 ON dbo.SC30 (  SP1952 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC319 definition

-- Drop table

-- DROP TABLE POS.dbo.SC319;

CREATE TABLE SC319 (
                       ROW_ID int IDENTITY(1,1) NOT NULL,
                       ID char(9)  NOT NULL,
                       PARENTEXT char(9)  NOT NULL,
                       ISMARK bit NOT NULL,
                       VERSTAMP int NOT NULL,
                       SP6681 char(9)  NOT NULL,
                       SP6682 numeric(5,2) NOT NULL,
                       SP327 char(9)  NOT NULL,
                       CONSTRAINT PK_SC319 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC319 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX PCODE ON dbo.SC319 (  PARENTEXT ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI327 ON dbo.SC319 (  SP327 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VIP327 ON dbo.SC319 (  PARENTEXT ASC  , SP327 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC35 definition

-- Drop table

-- DROP TABLE POS.dbo.SC35;

CREATE TABLE SC35 (
                      ROW_ID int IDENTITY(1,1) NOT NULL,
                      ID char(9)  NOT NULL,
                      DESCR char(10)  NOT NULL,
                      ISMARK bit NOT NULL,
                      VERSTAMP int NOT NULL,
                      SP36 numeric(4,2) NOT NULL,
                      CONSTRAINT PK_SC35 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC35 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC35 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI36 ON dbo.SC35 (  SP36 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- Main.dbo.SC4014 definition

-- Drop table

-- DROP TABLE Main.dbo.SC4014;

CREATE TABLE SC4014 (
                        ROW_ID int IDENTITY(1,1) NOT NULL,
                        ID char(9)  NOT NULL,
                        CODE char(5)  NOT NULL,
                        DESCR char(50)  NOT NULL,
                        ISMARK bit NOT NULL,
                        VERSTAMP int NOT NULL,
                        SP4011 char(9)  NOT NULL,
                        SP4012 char(9)  NOT NULL,
                        SP4133 char(9)  NOT NULL,
                        SP5011 char(40)  NOT NULL,
                        SP5010 char(40)  NOT NULL,
                        SP8454 char(17)  NOT NULL,
                        SP8455 char(100)  NOT NULL,
                        SP8456 char(35)  NOT NULL,
                        SP8457 char(50)  NOT NULL,
                        SP8458 char(85)  NOT NULL,
                        SP9175 numeric(7,0) NOT NULL,
                        SP9176 char(20)  NOT NULL,
                        SP9177 char(20)  NOT NULL,
                        SP9178 char(255)  NOT NULL,
                        SP4073 text  NULL,
                        CONSTRAINT PK_SC4014 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC4014 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC4014 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC4014 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI5011 ON dbo.SC4014 (  SP5011 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI8454 ON dbo.SC4014 (  SP8454 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI9176 ON dbo.SC4014 (  SP9176 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI9177 ON dbo.SC4014 (  SP9177 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC41 definition

-- Drop table

-- DROP TABLE POS.dbo.SC41;

CREATE TABLE SC41 (
                      ROW_ID int IDENTITY(1,1) NOT NULL,
                      ID char(9)  NOT NULL,
                      CODE char(3)  NOT NULL,
                      DESCR char(25)  NOT NULL,
                      ISMARK bit NOT NULL,
                      VERSTAMP int NOT NULL,
                      SP42 char(100)  NOT NULL,
                      CONSTRAINT PK_SC41 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC41 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC41 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC41 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC426 definition

-- Drop table

-- DROP TABLE POS.dbo.SC426;

CREATE TABLE SC426 (
                       ROW_ID int IDENTITY(1,1) NOT NULL,
                       ID char(9)  NOT NULL,
                       CODE char(5)  NOT NULL,
                       DESCR char(25)  NOT NULL,
                       ISMARK bit NOT NULL,
                       VERSTAMP int NOT NULL,
                       SP429 numeric(6,3) NOT NULL,
                       SP8127 numeric(6,3) NOT NULL,
                       SP8370 numeric(1,0) NOT NULL,
                       CONSTRAINT PK_SC426 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC426 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC426 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC426 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI429 ON dbo.SC426 (  SP429 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI8127 ON dbo.SC426 (  SP8127 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC4264 definition

-- Drop table

-- DROP TABLE POS.dbo.SC4264;

CREATE TABLE SC4264 (
                        ROW_ID int IDENTITY(1,1) NOT NULL,
                        ID char(9)  NOT NULL,
                        CODE char(5)  NOT NULL,
                        DESCR char(50)  NOT NULL,
                        ISMARK bit NOT NULL,
                        VERSTAMP int NOT NULL,
                        CONSTRAINT PK_SC4264 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC4264 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC4264 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC4264 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC493 definition

-- Drop table

-- DROP TABLE POS.dbo.SC493;

CREATE TABLE SC493 (
                       ROW_ID int IDENTITY(1,1) NOT NULL,
                       ID char(9)  NOT NULL,
                       PARENTID char(9)  NOT NULL,
                       CODE char(8)  NOT NULL,
                       DESCR char(50)  NOT NULL,
                       ISFOLDER tinyint NOT NULL,
                       ISMARK bit NOT NULL,
                       VERSTAMP int NOT NULL,
                       SP494 char(20)  NOT NULL,
                       SP497 char(10)  NOT NULL,
                       SP498 text  NULL,
                       SP671 text  NULL,
                       SP666 text  NULL,
                       SP499 text  NULL,
                       SP495 text  NULL,
                       CONSTRAINT PK_SC493 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC493 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC493 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC493 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX PCODE ON dbo.SC493 (  PARENTID ASC  , ISFOLDER ASC  , CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX PDESCR ON dbo.SC493 (  PARENTID ASC  , ISFOLDER ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI494 ON dbo.SC493 (  SP494 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VIP494 ON dbo.SC493 (  PARENTID ASC  , ISFOLDER ASC  , SP494 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC503 definition

-- Drop table

-- DROP TABLE POS.dbo.SC503;

CREATE TABLE SC503 (
                       ROW_ID int IDENTITY(1,1) NOT NULL,
                       ID char(9)  NOT NULL,
                       PARENTID char(9)  NOT NULL,
                       CODE char(8)  NOT NULL,
                       DESCR char(50)  NOT NULL,
                       ISFOLDER tinyint NOT NULL,
                       ISMARK bit NOT NULL,
                       VERSTAMP int NOT NULL,
                       SP508 char(100)  NOT NULL,
                       SP504 char(12)  NOT NULL,
                       SP672 text  NULL,
                       SP4769 text  NULL,
                       SP673 text  NULL,
                       SP674 text  NULL,
                       SP505 text  NULL,
                       CONSTRAINT PK_SC503 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC503 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC503 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC503 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX PCODE ON dbo.SC503 (  PARENTID ASC  , ISFOLDER ASC  , CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX PDESCR ON dbo.SC503 (  PARENTID ASC  , ISFOLDER ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI504 ON dbo.SC503 (  SP504 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VIP504 ON dbo.SC503 (  PARENTID ASC  , ISFOLDER ASC  , SP504 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC538 definition

-- Drop table

-- DROP TABLE POS.dbo.SC538;

CREATE TABLE SC538 (
                       ROW_ID int IDENTITY(1,1) NOT NULL,
                       ID char(9)  NOT NULL,
                       PARENTID char(9)  NOT NULL,
                       CODE char(5)  NOT NULL,
                       DESCR char(50)  NOT NULL,
                       ISFOLDER tinyint NOT NULL,
                       ISMARK bit NOT NULL,
                       VERSTAMP int NOT NULL,
                       SP539 char(13)  NOT NULL,
                       SP540 char(9)  NOT NULL,
                       SP541 char(40)  NOT NULL,
                       SP544 char(9)  NOT NULL,
                       SP543 text  NULL,
                       SP542 text  NULL,
                       CONSTRAINT PK_SC538 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC538 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC538 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC538 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX PCODE ON dbo.SC538 (  PARENTID ASC  , ISFOLDER ASC  , CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX PDESCR ON dbo.SC538 (  PARENTID ASC  , ISFOLDER ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI541 ON dbo.SC538 (  SP541 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VIP541 ON dbo.SC538 (  PARENTID ASC  , ISFOLDER ASC  , SP541 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC546 definition

-- Drop table

-- DROP TABLE POS.dbo.SC546;

CREATE TABLE SC546 (
                       ROW_ID int IDENTITY(1,1) NOT NULL,
                       ID char(9)  NOT NULL,
                       PARENTID char(9)  NOT NULL,
                       CODE char(5)  NOT NULL,
                       DESCR char(100)  NOT NULL,
                       ISFOLDER tinyint NOT NULL,
                       ISMARK bit NOT NULL,
                       VERSTAMP int NOT NULL,
                       SP547 char(9)  NOT NULL,
                       SP549 char(40)  NOT NULL,
                       SP548 numeric(1,0) NOT NULL,
                       CONSTRAINT PK_SC546 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC546 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC546 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC546 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX PCODE ON dbo.SC546 (  PARENTID ASC  , ISFOLDER ASC  , CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX PDESCR ON dbo.SC546 (  PARENTID ASC  , ISFOLDER ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI547 ON dbo.SC546 (  SP547 ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI549 ON dbo.SC546 (  SP549 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VIP547 ON dbo.SC546 (  PARENTID ASC  , ISFOLDER ASC  , SP547 ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VIP549 ON dbo.SC546 (  PARENTID ASC  , ISFOLDER ASC  , SP549 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC55 definition

-- Drop table

-- DROP TABLE POS.dbo.SC55;

CREATE TABLE SC55 (
                      ROW_ID int IDENTITY(1,1) NOT NULL,
                      ID char(9)  NOT NULL,
                      CODE char(5)  NOT NULL,
                      DESCR char(64)  NOT NULL,
                      ISMARK bit NOT NULL,
                      VERSTAMP int NOT NULL,
                      SP8441 char(17)  NOT NULL,
                      SP8447 char(7)  NOT NULL,
                      SP8442 char(100)  NOT NULL,
                      SP8451 char(9)  NOT NULL,
                      SP425 char(9)  NOT NULL,
                      SP8443 char(9)  NOT NULL,
                      SP3019 numeric(1,0) NOT NULL,
                      SP4254 numeric(1,0) NOT NULL,
                      SP56 numeric(1,0) NOT NULL,
                      SP8444 char(9)  NOT NULL,
                      SP8445 char(20)  NOT NULL,
                      SP8448 char(9)  NOT NULL,
                      SP8674 char(9)  NOT NULL,
                      SP8995 char(9)  NOT NULL,
                      SP8996 char(9)  NOT NULL,
                      SP8997 char(9)  NOT NULL,
                      CONSTRAINT PK_SC55 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC55 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC55 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC55 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI8441 ON dbo.SC55 (  SP8441 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI8447 ON dbo.SC55 (  SP8447 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI8448 ON dbo.SC55 (  SP8448 ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC552 definition

-- Drop table

-- DROP TABLE POS.dbo.SC552;

CREATE TABLE SC552 (
                       ROW_ID int IDENTITY(1,1) NOT NULL,
                       ID char(9)  NOT NULL,
                       CODE char(8)  NOT NULL,
                       DESCR char(100)  NOT NULL,
                       PARENTEXT char(9)  NOT NULL,
                       ISMARK bit NOT NULL,
                       VERSTAMP int NOT NULL,
                       SP553 char(9)  NOT NULL,
                       SP554 char(40)  NOT NULL,
                       CONSTRAINT PK_SC552 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC552 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC552 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC552 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX PCODE ON dbo.SC552 (  PARENTEXT ASC  , CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX PDESCR ON dbo.SC552 (  PARENTEXT ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI553 ON dbo.SC552 (  SP553 ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI554 ON dbo.SC552 (  SP554 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VIP553 ON dbo.SC552 (  PARENTEXT ASC  , SP553 ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VIP554 ON dbo.SC552 (  PARENTEXT ASC  , SP554 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC556 definition

-- Drop table

-- DROP TABLE POS.dbo.SC556;

CREATE TABLE SC556 (
                       ROW_ID int IDENTITY(1,1) NOT NULL,
                       ID char(9)  NOT NULL,
                       DESCR char(100)  NOT NULL,
                       PARENTEXT char(9)  NOT NULL,
                       ISMARK bit NOT NULL,
                       VERSTAMP int NOT NULL,
                       CONSTRAINT PK_SC556 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC556 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC556 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX PDESCR ON dbo.SC556 (  PARENTEXT ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC558 definition

-- Drop table

-- DROP TABLE POS.dbo.SC558;

CREATE TABLE SC558 (
                       ROW_ID int IDENTITY(1,1) NOT NULL,
                       ID char(9)  NOT NULL,
                       PARENTEXT char(9)  NOT NULL,
                       ISMARK bit NOT NULL,
                       VERSTAMP int NOT NULL,
                       SP559 char(9)  NOT NULL,
                       SP560 char(9)  NOT NULL,
                       CONSTRAINT PK_SC558 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC558 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX PCODE ON dbo.SC558 (  PARENTEXT ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI559 ON dbo.SC558 (  SP559 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI560 ON dbo.SC558 (  SP560 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VIP559 ON dbo.SC558 (  PARENTEXT ASC  , SP559 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VIP560 ON dbo.SC558 (  PARENTEXT ASC  , SP560 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC562 definition

-- Drop table

-- DROP TABLE POS.dbo.SC562;

CREATE TABLE SC562 (
                       ROW_ID int IDENTITY(1,1) NOT NULL,
                       ID char(9)  NOT NULL,
                       PARENTEXT char(9)  NOT NULL,
                       ISMARK bit NOT NULL,
                       VERSTAMP int NOT NULL,
                       SP563 char(9)  NOT NULL,
                       SP564 char(9)  NOT NULL,
                       CONSTRAINT PK_SC562 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC562 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX PCODE ON dbo.SC562 (  PARENTEXT ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI563 ON dbo.SC562 (  SP563 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI564 ON dbo.SC562 (  SP564 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VIP563 ON dbo.SC562 (  PARENTEXT ASC  , SP563 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VIP564 ON dbo.SC562 (  PARENTEXT ASC  , SP564 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC566 definition

-- Drop table

-- DROP TABLE POS.dbo.SC566;

CREATE TABLE SC566 (
                       ROW_ID int IDENTITY(1,1) NOT NULL,
                       ID char(9)  NOT NULL,
                       CODE char(3)  NOT NULL,
                       DESCR char(50)  NOT NULL,
                       ISMARK bit NOT NULL,
                       VERSTAMP int NOT NULL,
                       CONSTRAINT PK_SC566 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC566 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC566 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC566 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC568 definition

-- Drop table

-- DROP TABLE POS.dbo.SC568;

CREATE TABLE SC568 (
                       ROW_ID int IDENTITY(1,1) NOT NULL,
                       ID char(9)  NOT NULL,
                       DESCR char(26)  NOT NULL,
                       ISMARK bit NOT NULL,
                       VERSTAMP int NOT NULL,
                       SP569 text  NULL,
                       CONSTRAINT PK_SC568 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC568 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC568 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC577 definition

-- Drop table

-- DROP TABLE POS.dbo.SC577;

CREATE TABLE SC577 (
                       ROW_ID int IDENTITY(1,1) NOT NULL,
                       ID char(9)  NOT NULL,
                       CODE char(5)  NOT NULL,
                       DESCR char(50)  NOT NULL,
                       ISMARK bit NOT NULL,
                       VERSTAMP int NOT NULL,
                       SP578 text  NULL,
                       SP580 text  NULL,
                       SP579 text  NULL,
                       CONSTRAINT PK_SC577 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC577 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC577 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC577 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC72 definition

-- Drop table

-- DROP TABLE POS.dbo.SC72;

CREATE TABLE SC72 (
                      ROW_ID int IDENTITY(1,1) NOT NULL,
                      ID char(9)  NOT NULL,
                      CODE char(5)  NOT NULL,
                      DESCR char(50)  NOT NULL,
                      ISMARK bit NOT NULL,
                      VERSTAMP int NOT NULL,
                      SP4136 text  NULL,
                      CONSTRAINT PK_SC72 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC72 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC72 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC72 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC75 definition

-- Drop table

-- DROP TABLE POS.dbo.SC75;

CREATE TABLE SC75 (
                      ROW_ID int IDENTITY(1,1) NOT NULL,
                      ID char(9)  NOT NULL,
                      PARENTEXT char(9)  NOT NULL,
                      ISMARK bit NOT NULL,
                      VERSTAMP int NOT NULL,
                      SP79 char(9)  NOT NULL,
                      SP76 numeric(13,3) NOT NULL,
                      SP78 numeric(9,3) NOT NULL,
                      SP80 char(13)  NOT NULL,
                      CONSTRAINT PK_SC75 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC75 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX PCODE ON dbo.SC75 (  PARENTEXT ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI79 ON dbo.SC75 (  SP79 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI80 ON dbo.SC75 (  SP80 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VIP79 ON dbo.SC75 (  PARENTEXT ASC  , SP79 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VIP80 ON dbo.SC75 (  PARENTEXT ASC  , SP80 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC7657 definition

-- Drop table

-- DROP TABLE POS.dbo.SC7657;

CREATE TABLE SC7657 (
                        ROW_ID int IDENTITY(1,1) NOT NULL,
                        ID char(9)  NOT NULL,
                        PARENTID char(9)  NOT NULL,
                        CODE char(4)  NOT NULL,
                        DESCR char(100)  NOT NULL,
                        ISFOLDER tinyint NOT NULL,
                        ISMARK bit NOT NULL,
                        VERSTAMP int NOT NULL,
                        SP7644 char(9)  NOT NULL,
                        SP7645 char(9)  NOT NULL,
                        SP7646 char(9)  NOT NULL,
                        SP7647 char(9)  NOT NULL,
                        SP7648 char(9)  NOT NULL,
                        SP7649 char(9)  NOT NULL,
                        SP7651 char(9)  NOT NULL,
                        SP7655 numeric(6,5) NOT NULL,
                        SP7650 text  NULL,
                        SP7652 text  NULL,
                        SP7653 text  NULL,
                        SP7654 text  NULL,
                        CONSTRAINT PK_SC7657 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC7657 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC7657 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC7657 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX PCODE ON dbo.SC7657 (  PARENTID ASC  , CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX PDESCR ON dbo.SC7657 (  PARENTID ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC7664 definition

-- Drop table

-- DROP TABLE POS.dbo.SC7664;

CREATE TABLE SC7664 (
                        ROW_ID int IDENTITY(1,1) NOT NULL,
                        ID char(9)  NOT NULL,
                        CODE char(2)  NOT NULL,
                        PARENTEXT char(9)  NOT NULL,
                        ISMARK bit NOT NULL,
                        VERSTAMP int NOT NULL,
                        SP7658 char(100)  NOT NULL,
                        SP7659 char(23)  NOT NULL,
                        TSP7659 char(3)  NOT NULL,
                        SP7660 char(100)  NOT NULL,
                        SP7662 char(8)  NOT NULL,
                        SP7661 text  NULL,
                        CONSTRAINT PK_SC7664 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC7664 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC7664 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX PCODE ON dbo.SC7664 (  PARENTEXT ASC  , CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI7658 ON dbo.SC7664 (  SP7658 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI7659 ON dbo.SC7664 (  SP7659 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VIP7658 ON dbo.SC7664 (  PARENTEXT ASC  , SP7658 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VIP7659 ON dbo.SC7664 (  PARENTEXT ASC  , SP7659 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC7677 definition

-- Drop table

-- DROP TABLE POS.dbo.SC7677;

CREATE TABLE SC7677 (
                        ROW_ID int IDENTITY(1,1) NOT NULL,
                        ID char(9)  NOT NULL,
                        PARENTID char(9)  NOT NULL,
                        CODE char(5)  NOT NULL,
                        DESCR char(100)  NOT NULL,
                        ISFOLDER tinyint NOT NULL,
                        ISMARK bit NOT NULL,
                        VERSTAMP int NOT NULL,
                        SP7667 char(13)  NOT NULL,
                        SP7668 char(9)  NOT NULL,
                        SP7669 char(9)  NOT NULL,
                        SP7665 text  NULL,
                        SP7666 text  NULL,
                        CONSTRAINT PK_SC7677 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC7677 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC7677 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC7677 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX PCODE ON dbo.SC7677 (  PARENTID ASC  , ISFOLDER ASC  , CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX PDESCR ON dbo.SC7677 (  PARENTID ASC  , ISFOLDER ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC796 definition

-- Drop table

-- DROP TABLE POS.dbo.SC796;

CREATE TABLE SC796 (
                       ROW_ID int IDENTITY(1,1) NOT NULL,
                       ID char(9)  NOT NULL,
                       PARENTID char(9)  NOT NULL,
                       CODE char(5)  NOT NULL,
                       DESCR char(50)  NOT NULL,
                       ISFOLDER tinyint NOT NULL,
                       ISMARK bit NOT NULL,
                       VERSTAMP int NOT NULL,
                       CONSTRAINT PK_SC796 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC796 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC796 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC796 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX PCODE ON dbo.SC796 (  PARENTID ASC  , ISFOLDER ASC  , CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX PDESCR ON dbo.SC796 (  PARENTID ASC  , ISFOLDER ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC8054 definition

-- Drop table

-- DROP TABLE POS.dbo.SC8054;

CREATE TABLE SC8054 (
                        ROW_ID int IDENTITY(1,1) NOT NULL,
                        ID char(9)  NOT NULL,
                        CODE char(8)  NOT NULL,
                        DESCR char(5)  NOT NULL,
                        ISMARK bit NOT NULL,
                        VERSTAMP int NOT NULL,
                        SP8061 char(9)  NOT NULL,
                        SP8048 char(200)  NOT NULL,
                        SP8049 numeric(1,0) NOT NULL,
                        SP8051 numeric(2,0) NOT NULL,
                        SP8052 datetime NOT NULL,
                        SP8077 char(255)  NOT NULL,
                        SP8369 numeric(1,0) NOT NULL,
                        SP8813 char(8)  NOT NULL,
                        SP8050 text  NULL,
                        SP8149 text  NULL,
                        CONSTRAINT PK_SC8054 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC8054 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC8054 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC8054 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI8049 ON dbo.SC8054 (  SP8049 ASC  , CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI8051 ON dbo.SC8054 (  SP8051 ASC  , CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI8052 ON dbo.SC8054 (  SP8052 ASC  , CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI8061 ON dbo.SC8054 (  SP8061 ASC  , CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI8369 ON dbo.SC8054 (  SP8369 ASC  , CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC8064 definition

-- Drop table

-- DROP TABLE POS.dbo.SC8064;

CREATE TABLE SC8064 (
                        ROW_ID int IDENTITY(1,1) NOT NULL,
                        ID char(9)  NOT NULL,
                        CODE char(5)  NOT NULL,
                        DESCR char(50)  NOT NULL,
                        ISMARK bit NOT NULL,
                        VERSTAMP int NOT NULL,
                        SP8062 char(255)  NOT NULL,
                        CONSTRAINT PK_SC8064 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC8064 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC8064 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC8064 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI8062 ON dbo.SC8064 (  SP8062 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC8084 definition

-- Drop table

-- DROP TABLE POS.dbo.SC8084;

CREATE TABLE SC8084 (
                        ROW_ID int IDENTITY(1,1) NOT NULL,
                        ID char(9)  NOT NULL,
                        CODE char(5)  NOT NULL,
                        DESCR char(25)  NOT NULL,
                        ISMARK bit NOT NULL,
                        VERSTAMP int NOT NULL,
                        SP8090 char(9)  NOT NULL,
                        SP8080 char(120)  NOT NULL,
                        SP8081 char(50)  NOT NULL,
                        SP8082 char(50)  NOT NULL,
                        SP8352 numeric(10,0) NOT NULL,
                        SP8796 numeric(1,0) NOT NULL,
                        CONSTRAINT PK_SC8084 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC8084 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC8084 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC8084 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI8080 ON dbo.SC8084 (  SP8080 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI8090 ON dbo.SC8084 (  SP8090 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC8093 definition

-- Drop table

-- DROP TABLE POS.dbo.SC8093;

CREATE TABLE SC8093 (
                        ROW_ID int IDENTITY(1,1) NOT NULL,
                        ID char(9)  NOT NULL,
                        CODE char(5)  NOT NULL,
                        DESCR char(50)  NOT NULL,
                        ISMARK bit NOT NULL,
                        VERSTAMP int NOT NULL,
                        SP8091 char(17)  NOT NULL,
                        CONSTRAINT PK_SC8093 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC8093 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC8093 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC8093 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI8091 ON dbo.SC8093 (  SP8091 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC8114 definition

-- Drop table

-- DROP TABLE POS.dbo.SC8114;

CREATE TABLE SC8114 (
                        ROW_ID int IDENTITY(1,1) NOT NULL,
                        ID char(9)  NOT NULL,
                        CODE char(13)  NOT NULL,
                        ISMARK bit NOT NULL,
                        VERSTAMP int NOT NULL,
                        SP8353 char(50)  NOT NULL,
                        SP8111 char(17)  NOT NULL,
                        SP8231 numeric(6,0) NOT NULL,
                        SP8112 numeric(1,0) NOT NULL,
                        SP8354 char(8)  NOT NULL,
                        SP8539 char(9)  NOT NULL,
                        SP8355 char(9)  NOT NULL,
                        SP8356 datetime NOT NULL,
                        SP8097 datetime NOT NULL,
                        SP8101 datetime NOT NULL,
                        SP8104 datetime NOT NULL,
                        SP8107 datetime NOT NULL,
                        SP8110 datetime NOT NULL,
                        SP8762 datetime NOT NULL,
                        SP8357 char(10)  NOT NULL,
                        SP8358 char(10)  NOT NULL,
                        SP8763 numeric(1,0) NOT NULL,
                        SP8359 char(10)  NOT NULL,
                        SP8098 numeric(2,0) NOT NULL,
                        SP8360 char(17)  NOT NULL,
                        SP8363 char(50)  NOT NULL,
                        SP8096 char(9)  NOT NULL,
                        SP8100 char(9)  NOT NULL,
                        SP8103 char(9)  NOT NULL,
                        SP8106 char(9)  NOT NULL,
                        SP8109 char(9)  NOT NULL,
                        SP8365 numeric(1,0) NOT NULL,
                        SP8765 numeric(1,0) NOT NULL,
                        SP8099 char(50)  NOT NULL,
                        SP8102 char(50)  NOT NULL,
                        SP8105 char(50)  NOT NULL,
                        SP8108 char(50)  NOT NULL,
                        SP8094 char(9)  NOT NULL,
                        SP8202 numeric(10,0) NOT NULL,
                        SP8361 char(20)  NOT NULL,
                        SP8364 numeric(1,0) NOT NULL,
                        SP8362 char(50)  NOT NULL,
                        SP8095 char(100)  NOT NULL,
                        SP8764 text  NULL,
                        CONSTRAINT PK_SC8114 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC8114 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC8114 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI8111 ON dbo.SC8114 (  SP8111 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI8363 ON dbo.SC8114 (  SP8363 ASC  , CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC8131 definition

-- Drop table

-- DROP TABLE POS.dbo.SC8131;

CREATE TABLE SC8131 (
                        ROW_ID int IDENTITY(1,1) NOT NULL,
                        ID char(9)  NOT NULL,
                        CODE char(5)  NOT NULL,
                        DESCR char(50)  NOT NULL,
                        ISMARK bit NOT NULL,
                        VERSTAMP int NOT NULL,
                        SP8128 char(17)  NOT NULL,
                        SP8129 char(7)  NOT NULL,
                        SP8201 numeric(1,0) NOT NULL,
                        SP8452 char(9)  NOT NULL,
                        SP9027 char(12)  NOT NULL,
                        SP9049 char(100)  NOT NULL,
                        CONSTRAINT PK_SC8131 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC8131 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC8131 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC8131 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI8128 ON dbo.SC8131 (  SP8128 ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI8129 ON dbo.SC8131 (  SP8129 ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI8452 ON dbo.SC8131 (  SP8452 ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC8164 definition

-- Drop table

-- DROP TABLE POS.dbo.SC8164;

CREATE TABLE SC8164 (
                        ROW_ID int IDENTITY(1,1) NOT NULL,
                        ID char(9)  NOT NULL,
                        CODE char(5)  NOT NULL,
                        DESCR char(25)  NOT NULL,
                        ISMARK bit NOT NULL,
                        VERSTAMP int NOT NULL,
                        SP8161 char(9)  NOT NULL,
                        SP8162 char(30)  NOT NULL,
                        CONSTRAINT PK_SC8164 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC8164 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC8164 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC8164 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC8236 definition

-- Drop table

-- DROP TABLE POS.dbo.SC8236;

CREATE TABLE SC8236 (
                        ROW_ID int IDENTITY(1,1) NOT NULL,
                        ID char(9)  NOT NULL,
                        CODE char(13)  NOT NULL,
                        ISMARK bit NOT NULL,
                        VERSTAMP int NOT NULL,
                        SP8232 char(17)  NOT NULL,
                        SP8233 numeric(4,0) NOT NULL,
                        SP8234 char(17)  NOT NULL,
                        CONSTRAINT PK_SC8236 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC8236 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC8236 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI8232 ON dbo.SC8236 (  SP8232 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC8351 definition

-- Drop table

-- DROP TABLE POS.dbo.SC8351;

CREATE TABLE SC8351 (
                        ROW_ID int IDENTITY(1,1) NOT NULL,
                        ID char(9)  NOT NULL,
                        CODE char(11)  NOT NULL,
                        DESCR char(48)  NOT NULL,
                        ISMARK bit NOT NULL,
                        VERSTAMP int NOT NULL,
                        SP8341 numeric(6,0) NOT NULL,
                        SP8342 numeric(1,0) NOT NULL,
                        SP8343 char(5)  NOT NULL,
                        SP8344 char(8)  NOT NULL,
                        SP8345 char(3)  NOT NULL,
                        SP8346 char(17)  NOT NULL,
                        SP8347 char(9)  NOT NULL,
                        CONSTRAINT PK_SC8351 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC8351 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC8351 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC8351 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI8342 ON dbo.SC8351 (  SP8342 ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI8343 ON dbo.SC8351 (  SP8343 ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI8344 ON dbo.SC8351 (  SP8344 ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI8345 ON dbo.SC8351 (  SP8345 ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI8346 ON dbo.SC8351 (  SP8346 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC8377 definition

-- Drop table

-- DROP TABLE POS.dbo.SC8377;

CREATE TABLE SC8377 (
                        ROW_ID int IDENTITY(1,1) NOT NULL,
                        ID char(9)  NOT NULL,
                        CODE char(3)  NOT NULL,
                        DESCR char(25)  NOT NULL,
                        ISMARK bit NOT NULL,
                        VERSTAMP int NOT NULL,
                        SP8371 char(9)  NOT NULL,
                        SP8372 char(17)  NOT NULL,
                        SP8373 datetime NOT NULL,
                        SP8374 char(8)  NOT NULL,
                        SP8375 numeric(1,0) NOT NULL,
                        CONSTRAINT PK_SC8377 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC8377 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC8377 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC8377 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI8372 ON dbo.SC8377 (  SP8372 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC84 definition

-- Drop table

-- DROP TABLE POS.dbo.SC84;

CREATE TABLE SC84 (
                      ROW_ID int IDENTITY(1,1) NOT NULL,
                      ID char(9)  NOT NULL,
                      CODE char(6)  NOT NULL,
                      DESCR char(100)  NOT NULL,
                      ISMARK bit NOT NULL,
                      VERSTAMP int NOT NULL,
                      SP8014 char(17)  NOT NULL,
                      SP8368 char(17)  NOT NULL,
                      SP85 char(25)  NOT NULL,
                      SP86 char(9)  NOT NULL,
                      SP208 numeric(1,0) NOT NULL,
                      SP2417 char(9)  NOT NULL,
                      SP8668 char(9)  NOT NULL,
                      SP8230 char(9)  NOT NULL,
                      SP8669 char(14)  NOT NULL,
                      SP97 numeric(13,3) NOT NULL,
                      SP5066 numeric(1,0) NOT NULL,
                      SP5013 char(9)  NOT NULL,
                      SP94 char(9)  NOT NULL,
                      SP4427 char(9)  NOT NULL,
                      SP103 char(9)  NOT NULL,
                      SP104 char(9)  NOT NULL,
                      SP5012 char(9)  NOT NULL,
                      SP8148 char(13)  NOT NULL,
                      SP8850 char(9)  NOT NULL,
                      SP95 text  NULL,
                      SP101 text  NULL,
                      SP9068 text  NULL,
                      CONSTRAINT PK_SC84 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC84 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC84 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC84 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI5066 ON dbo.SC84 (  SP5066 ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI8014 ON dbo.SC84 (  SP8014 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI8148 ON dbo.SC84 (  SP8148 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI8230 ON dbo.SC84 (  SP8230 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI8368 ON dbo.SC84 (  SP8368 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI85 ON dbo.SC84 (  SP85 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC8461 definition

-- Drop table

-- DROP TABLE POS.dbo.SC8461;

CREATE TABLE SC8461 (
                        ROW_ID int IDENTITY(1,1) NOT NULL,
                        ID char(9)  NOT NULL,
                        CODE char(5)  NOT NULL,
                        DESCR char(50)  NOT NULL,
                        ISMARK bit NOT NULL,
                        VERSTAMP int NOT NULL,
                        SP8459 char(17)  NOT NULL,
                        CONSTRAINT PK_SC8461 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC8461 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC8461 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC8461 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI8459 ON dbo.SC8461 (  SP8459 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC8467 definition

-- Drop table

-- DROP TABLE POS.dbo.SC8467;

CREATE TABLE SC8467 (
                        ROW_ID int IDENTITY(1,1) NOT NULL,
                        ID char(9)  NOT NULL,
                        CODE char(5)  NOT NULL,
                        DESCR char(25)  NOT NULL,
                        ISMARK bit NOT NULL,
                        VERSTAMP int NOT NULL,
                        SP8462 numeric(1,0) NOT NULL,
                        SP8463 char(15)  NOT NULL,
                        SP8464 char(5)  NOT NULL,
                        SP8465 numeric(2,0) NOT NULL,
                        CONSTRAINT PK_SC8467 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC8467 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC8467 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC8467 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI8465 ON dbo.SC8467 (  SP8465 ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC8672 definition

-- Drop table

-- DROP TABLE POS.dbo.SC8672;

CREATE TABLE SC8672 (
                        ROW_ID int IDENTITY(1,1) NOT NULL,
                        ID char(9)  NOT NULL,
                        CODE char(2)  NOT NULL,
                        DESCR char(60)  NOT NULL,
                        ISMARK bit NOT NULL,
                        VERSTAMP int NOT NULL,
                        SP8670 char(17)  NOT NULL,
                        CONSTRAINT PK_SC8672 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC8672 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC8672 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC8672 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI8670 ON dbo.SC8672 (  SP8670 ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC8679 definition

-- Drop table

-- DROP TABLE POS.dbo.SC8679;

CREATE TABLE SC8679 (
                        ROW_ID int IDENTITY(1,1) NOT NULL,
                        ID char(9)  NOT NULL,
                        CODE char(10)  NOT NULL,
                        PARENTEXT char(9)  NOT NULL,
                        ISMARK bit NOT NULL,
                        VERSTAMP int NOT NULL,
                        SP8675 char(9)  NOT NULL,
                        SP8676 numeric(10,0) NOT NULL,
                        SP8677 char(17)  NOT NULL,
                        CONSTRAINT PK_SC8679 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC8679 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC8679 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX PCODE ON dbo.SC8679 (  PARENTEXT ASC  , CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI8677 ON dbo.SC8679 (  SP8677 ASC  , CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VIP8677 ON dbo.SC8679 (  PARENTEXT ASC  , SP8677 ASC  , CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC8831 definition

-- Drop table

-- DROP TABLE POS.dbo.SC8831;

CREATE TABLE SC8831 (
                        ROW_ID int IDENTITY(1,1) NOT NULL,
                        ID char(9)  NOT NULL,
                        CODE char(13)  NOT NULL,
                        DESCR char(100)  NOT NULL,
                        ISMARK bit NOT NULL,
                        VERSTAMP int NOT NULL,
                        SP8826 char(100)  NOT NULL,
                        SP8827 datetime NOT NULL,
                        SP8828 char(9)  NOT NULL,
                        SP8829 datetime NOT NULL,
                        CONSTRAINT PK_SC8831 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC8831 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC8831 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC8831 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC8854 definition

-- Drop table

-- DROP TABLE POS.dbo.SC8854;

CREATE TABLE SC8854 (
                        ROW_ID int IDENTITY(1,1) NOT NULL,
                        ID char(9)  NOT NULL,
                        CODE char(5)  NOT NULL,
                        DESCR char(25)  NOT NULL,
                        ISMARK bit NOT NULL,
                        VERSTAMP int NOT NULL,
                        SP8851 datetime NOT NULL,
                        SP8852 numeric(3,0) NOT NULL,
                        SP8902 numeric(3,0) NOT NULL,
                        CONSTRAINT PK_SC8854 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC8854 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC8854 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC8854 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI8851 ON dbo.SC8854 (  SP8851 ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC8858 definition

-- Drop table

-- DROP TABLE POS.dbo.SC8858;

CREATE TABLE SC8858 (
                        ROW_ID int IDENTITY(1,1) NOT NULL,
                        ID char(9)  NOT NULL,
                        PARENTID char(9)  NOT NULL,
                        CODE char(15)  NOT NULL,
                        DESCR char(50)  NOT NULL,
                        ISFOLDER tinyint NOT NULL,
                        ISMARK bit NOT NULL,
                        VERSTAMP int NOT NULL,
                        SP8855 char(17)  NOT NULL,
                        SP8856 datetime NOT NULL,
                        CONSTRAINT PK_SC8858 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC8858 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC8858 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC8858 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX PCODE ON dbo.SC8858 (  PARENTID ASC  , ISFOLDER ASC  , CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX PDESCR ON dbo.SC8858 (  PARENTID ASC  , ISFOLDER ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI8855 ON dbo.SC8858 (  SP8855 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VIP8855 ON dbo.SC8858 (  PARENTID ASC  , ISFOLDER ASC  , SP8855 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC890 definition

-- Drop table

-- DROP TABLE POS.dbo.SC890;

CREATE TABLE SC890 (
                       ROW_ID int IDENTITY(1,1) NOT NULL,
                       ID char(9)  NOT NULL,
                       PARENTEXT char(9)  NOT NULL,
                       ISMARK bit NOT NULL,
                       VERSTAMP int NOT NULL,
                       SP3470 char(9)  NOT NULL,
                       SP891 numeric(13,3) NOT NULL,
                       SP3760 numeric(14,2) NOT NULL,
                       CONSTRAINT PK_SC890 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC890 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX PCODE ON dbo.SC890 (  PARENTEXT ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI3470 ON dbo.SC890 (  SP3470 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VIP3470 ON dbo.SC890 (  PARENTEXT ASC  , SP3470 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC8906 definition

-- Drop table

-- DROP TABLE POS.dbo.SC8906;

CREATE TABLE SC8906 (
                        ROW_ID int IDENTITY(1,1) NOT NULL,
                        ID char(9)  NOT NULL,
                        PARENTID char(9)  NOT NULL,
                        CODE char(15)  NOT NULL,
                        DESCR char(50)  NOT NULL,
                        ISFOLDER tinyint NOT NULL,
                        ISMARK bit NOT NULL,
                        VERSTAMP int NOT NULL,
                        SP8903 char(17)  NOT NULL,
                        SP8904 datetime NOT NULL,
                        CONSTRAINT PK_SC8906 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC8906 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC8906 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC8906 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX PCODE ON dbo.SC8906 (  PARENTID ASC  , ISFOLDER ASC  , CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX PDESCR ON dbo.SC8906 (  PARENTID ASC  , ISFOLDER ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI8903 ON dbo.SC8906 (  SP8903 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VIP8903 ON dbo.SC8906 (  PARENTID ASC  , ISFOLDER ASC  , SP8903 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC8909 definition

-- Drop table

-- DROP TABLE POS.dbo.SC8909;

CREATE TABLE SC8909 (
                        ROW_ID int IDENTITY(1,1) NOT NULL,
                        ID char(9)  NOT NULL,
                        CODE char(5)  NOT NULL,
                        DESCR char(25)  NOT NULL,
                        ISMARK bit NOT NULL,
                        VERSTAMP int NOT NULL,
                        SP8907 char(17)  NOT NULL,
                        CONSTRAINT PK_SC8909 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC8909 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC8909 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC8909 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI8907 ON dbo.SC8909 (  SP8907 ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC8914 definition

-- Drop table

-- DROP TABLE POS.dbo.SC8914;

CREATE TABLE SC8914 (
                        ROW_ID int IDENTITY(1,1) NOT NULL,
                        ID char(9)  NOT NULL,
                        CODE char(5)  NOT NULL,
                        DESCR char(25)  NOT NULL,
                        ISMARK bit NOT NULL,
                        VERSTAMP int NOT NULL,
                        SP8910 numeric(9,2) NOT NULL,
                        SP8911 char(17)  NOT NULL,
                        SP8912 char(9)  NOT NULL,
                        CONSTRAINT PK_SC8914 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC8914 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC8914 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC8914 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI8911 ON dbo.SC8914 (  SP8911 ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC8972 definition

-- Drop table

-- DROP TABLE POS.dbo.SC8972;

CREATE TABLE SC8972 (
                        ROW_ID int IDENTITY(1,1) NOT NULL,
                        ID char(9)  NOT NULL,
                        CODE char(7)  NOT NULL,
                        DESCR char(31)  NOT NULL,
                        ISMARK bit NOT NULL,
                        VERSTAMP int NOT NULL,
                        SP8962 char(17)  NOT NULL,
                        SP8963 char(8)  NOT NULL,
                        SP8964 char(100)  NOT NULL,
                        SP8965 datetime NOT NULL,
                        SP8966 datetime NOT NULL,
                        SP8967 datetime NOT NULL,
                        SP8968 numeric(1,0) NOT NULL,
                        SP8969 char(9)  NOT NULL,
                        SP8970 char(9)  NOT NULL,
                        CONSTRAINT PK_SC8972 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC8972 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC8972 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC8972 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI8962 ON dbo.SC8972 (  SP8962 ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI8968 ON dbo.SC8972 (  SP8968 ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI8969 ON dbo.SC8972 (  SP8969 ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC9001 definition

-- Drop table

-- DROP TABLE POS.dbo.SC9001;

CREATE TABLE SC9001 (
                        ROW_ID int IDENTITY(1,1) NOT NULL,
                        ID char(9)  NOT NULL,
                        CODE char(5)  NOT NULL,
                        DESCR char(65)  NOT NULL,
                        ISMARK bit NOT NULL,
                        VERSTAMP int NOT NULL,
                        SP8998 char(17)  NOT NULL,
                        SP8999 char(9)  NOT NULL,
                        CONSTRAINT PK_SC9001 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC9001 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC9001 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC9001 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI8998 ON dbo.SC9001 (  SP8998 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI8999 ON dbo.SC9001 (  SP8999 ASC  , DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC9060 definition

-- Drop table

-- DROP TABLE POS.dbo.SC9060;

CREATE TABLE SC9060 (
                        ROW_ID int IDENTITY(1,1) NOT NULL,
                        ID char(9)  NOT NULL,
                        CODE char(17)  NOT NULL,
                        DESCR char(10)  NOT NULL,
                        ISMARK bit NOT NULL,
                        VERSTAMP int NOT NULL,
                        CONSTRAINT PK_SC9060 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC9060 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC9060 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC9060 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC9063 definition

-- Drop table

-- DROP TABLE POS.dbo.SC9063;

CREATE TABLE SC9063 (
                        ROW_ID int IDENTITY(1,1) NOT NULL,
                        ID char(9)  NOT NULL,
                        CODE char(17)  NOT NULL,
                        ISMARK bit NOT NULL,
                        VERSTAMP int NOT NULL,
                        SP9061 char(10)  NOT NULL,
                        CONSTRAINT PK_SC9063 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC9063 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC9063 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI9061 ON dbo.SC9063 (  SP9061 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC9129 definition

-- Drop table

-- DROP TABLE POS.dbo.SC9129;

CREATE TABLE SC9129 (
                        ROW_ID int IDENTITY(1,1) NOT NULL,
                        ID char(9)  NOT NULL,
                        CODE char(5)  NOT NULL,
                        DESCR char(50)  NOT NULL,
                        ISMARK bit NOT NULL,
                        VERSTAMP int NOT NULL,
                        SP9127 char(17)  NOT NULL,
                        CONSTRAINT PK_SC9129 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC9129 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC9129 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC9129 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI9127 ON dbo.SC9129 (  SP9127 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC9181 definition

-- Drop table

-- DROP TABLE POS.dbo.SC9181;

CREATE TABLE SC9181 (
                        ROW_ID int IDENTITY(1,1) NOT NULL,
                        ID char(9)  NOT NULL,
                        CODE char(5)  NOT NULL,
                        DESCR char(25)  NOT NULL,
                        ISMARK bit NOT NULL,
                        VERSTAMP int NOT NULL,
                        SP9179 char(17)  NOT NULL,
                        CONSTRAINT PK_SC9181 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC9181 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC9181 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC9181 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI9179 ON dbo.SC9181 (  SP9179 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.SC9184 definition

-- Drop table

-- DROP TABLE POS.dbo.SC9184;

CREATE TABLE SC9184 (
                        ROW_ID int IDENTITY(1,1) NOT NULL,
                        ID char(9)  NOT NULL,
                        CODE char(5)  NOT NULL,
                        DESCR char(50)  NOT NULL,
                        ISMARK bit NOT NULL,
                        VERSTAMP int NOT NULL,
                        SP9182 char(17)  NOT NULL,
                        CONSTRAINT PK_SC9184 PRIMARY KEY (ROW_ID)
);
CREATE  UNIQUE NONCLUSTERED INDEX CODE ON dbo.SC9184 (  CODE ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DESCR ON dbo.SC9184 (  DESCR ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo.SC9184 (  ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VI9182 ON dbo.SC9184 (  SP9182 ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.[_1SCONNECT] definition

-- Drop table

-- DROP TABLE POS.dbo.[_1SCONNECT];

CREATE TABLE [_1SCONNECT] (
    CONNECTUUID char(36)  NOT NULL
    );


-- POS.dbo.[_1SCONST] definition

-- Drop table

-- DROP TABLE POS.dbo.[_1SCONST];

CREATE TABLE [_1SCONST] (
                            ROW_ID int IDENTITY(1,1) NOT NULL,
    OBJID char(9)  NOT NULL,
    ID int NOT NULL,
    [DATE] datetime NOT NULL,
    VALUE varchar(255)  NOT NULL,
    DOCID char(9)  NOT NULL,
    [TIME] int NOT NULL,
    ACTNO int NOT NULL,
    LINENO_ smallint NOT NULL,
    TVALUE char(3)  NOT NULL,
    CONSTRAINT PK__1SCONST PRIMARY KEY (ROW_ID)
    );
CREATE  UNIQUE NONCLUSTERED INDEX DOC ON dbo._1SCONST (  DOCID ASC  , ACTNO ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDD ON dbo._1SCONST (  ID ASC  , OBJID ASC  , DATE ASC  , TIME ASC  , DOCID ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.[_1SCRDOC] definition

-- Drop table

-- DROP TABLE POS.dbo.[_1SCRDOC];

CREATE TABLE [_1SCRDOC] (
                            ROW_ID int IDENTITY(1,1) NOT NULL,
    MDID int NOT NULL,
    PARENTVAL char(23)  NOT NULL,
    CHILD_DATE_TIME_IDDOC char(23)  NOT NULL,
    CHILDID char(9)  NOT NULL,
    FLAGS tinyint NOT NULL,
    CONSTRAINT PK__1SCRDOC PRIMARY KEY (ROW_ID)
    );
CREATE  UNIQUE NONCLUSTERED INDEX CHILD ON dbo._1SCRDOC (  CHILDID ASC  , MDID ASC  , PARENTVAL ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX PARENT ON dbo._1SCRDOC (  MDID ASC  , PARENTVAL ASC  , CHILD_DATE_TIME_IDDOC ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.[_1SDNLOCK] definition

-- Drop table

-- DROP TABLE POS.dbo.[_1SDNLOCK];

CREATE TABLE [_1SDNLOCK] (
    DNPREFIX char(28)  NOT NULL,
    DOCNO char(24)  NOT NULL,
    CONSTRAINT PK__1SDNLOCK PRIMARY KEY (DNPREFIX,DOCNO)
    );


-- POS.dbo.[_1SJOURN] definition

-- Drop table

-- DROP TABLE POS.dbo.[_1SJOURN];

CREATE TABLE [_1SJOURN] (
                            ROW_ID int IDENTITY(1,1) NOT NULL,
    IDJOURNAL int NOT NULL,
    IDDOC char(9)  NOT NULL,
    IDDOCDEF int NOT NULL,
    APPCODE smallint NOT NULL,
    DATE_TIME_IDDOC char(23)  NOT NULL,
    DNPREFIX char(18)  NOT NULL,
    DOCNO char(15)  NOT NULL,
    CLOSED tinyint NOT NULL,
    ISMARK bit NOT NULL,
    ACTCNT int NOT NULL,
    VERSTAMP int NOT NULL,
    RF639 bit NOT NULL,
    RF464 bit NOT NULL,
    RF4667 bit NOT NULL,
    RF4674 bit NOT NULL,
    RF635 bit NOT NULL,
    RF3549 bit NOT NULL,
    RF4343 bit NOT NULL,
    RF405 bit NOT NULL,
    RF328 bit NOT NULL,
    RF351 bit NOT NULL,
    RF2964 bit NOT NULL,
    RF4335 bit NOT NULL,
    RF4314 bit NOT NULL,
    RF2351 bit NOT NULL,
    RF438 bit NOT NULL,
    RF4480 bit NOT NULL,
    RF9048 bit NOT NULL,
    SP74 char(9)  NOT NULL,
    SP798 char(9)  NOT NULL,
    SP4056 char(9)  NOT NULL,
    SP5365 char(9)  NOT NULL,
    SP8033 char(17)  NOT NULL,
    SP8526 datetime NOT NULL,
    SP8608 numeric(1,0) NOT NULL,
    DS1946 tinyint NOT NULL,
    DS4757 tinyint NOT NULL,
    DS5722 tinyint NOT NULL,
    CONSTRAINT PK__1SJOURN PRIMARY KEY (ROW_ID)
    );
CREATE  UNIQUE NONCLUSTERED INDEX ACDATETIME ON dbo._1SJOURN (  DATE_TIME_IDDOC ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DOCNO ON dbo._1SJOURN (  DNPREFIX ASC  , DOCNO ASC  , ROW_ID ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX DOCTYPE ON dbo._1SJOURN (  IDDOCDEF ASC  , DATE_TIME_IDDOC ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX IDDOC ON dbo._1SJOURN (  IDDOC ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX JOURNAL ON dbo._1SJOURN (  IDJOURNAL ASC  , DATE_TIME_IDDOC ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE NONCLUSTERED INDEX VIA1946 ON dbo._1SJOURN (  DS1946 ASC  , DATE_TIME_IDDOC ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VIA4056 ON dbo._1SJOURN (  SP4056 ASC  , DATE_TIME_IDDOC ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE NONCLUSTERED INDEX VIA4757 ON dbo._1SJOURN (  DS4757 ASC  , DATE_TIME_IDDOC ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VIA5365 ON dbo._1SJOURN (  SP5365 ASC  , DATE_TIME_IDDOC ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE NONCLUSTERED INDEX VIA5722 ON dbo._1SJOURN (  DS5722 ASC  , DATE_TIME_IDDOC ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VIA74 ON dbo._1SJOURN (  SP74 ASC  , DATE_TIME_IDDOC ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VIA798 ON dbo._1SJOURN (  SP798 ASC  , DATE_TIME_IDDOC ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VIA8033 ON dbo._1SJOURN (  SP8033 ASC  , DATE_TIME_IDDOC ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VIA8526 ON dbo._1SJOURN (  SP8526 ASC  , DATE_TIME_IDDOC ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
 CREATE  UNIQUE NONCLUSTERED INDEX VIA8608 ON dbo._1SJOURN (  SP8608 ASC  , DATE_TIME_IDDOC ASC  )
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- POS.dbo.[_1SSTREAM] definition

-- Drop table

-- DROP TABLE POS.dbo.[_1SSTREAM];

CREATE TABLE [_1SSTREAM] (
                             ID int NOT NULL,
                             DATE_TIME_DOCID char(23)  NOT NULL,
    CONSTRAINT PK__1SSTREAM PRIMARY KEY (ID)
    );


-- POS.dbo.[_1SSYSTEM] definition

-- Drop table

-- DROP TABLE POS.dbo.[_1SSYSTEM];

CREATE TABLE [_1SSYSTEM] (
                             CURDATE datetime NOT NULL,
                             CURTIME int NOT NULL,
                             EVENTIDTA char(9)  NOT NULL,
    DBSIGN char(3)  NOT NULL,
    DBSETUUID char(36)  NOT NULL,
    SNAPSHPER char(1)  NOT NULL,
    ACCDATE datetime NOT NULL,
    FLAGS int NOT NULL
    );


-- POS.dbo.[_1SUIDCTL] definition

-- Drop table

-- DROP TABLE POS.dbo.[_1SUIDCTL];

CREATE TABLE [_1SUIDCTL] (
                             TYPEID int NOT NULL,
                             MAXID char(9)  NOT NULL,
    CONSTRAINT PK__1SUIDCTL PRIMARY KEY (TYPEID)
    );


-- POS.dbo.[_1SUSERS] definition

-- Drop table

-- DROP TABLE POS.dbo.[_1SUSERS];

CREATE TABLE [_1SUSERS] (
                            USRSCNT smallint NOT NULL,
                            NETCHGCN int NOT NULL
);


-- POS.dbo.t1 definition

-- Drop table

-- DROP TABLE POS.dbo.t1;

CREATE TABLE t1 (
                    ITEM char(17)  NULL,
                    p1 numeric(18,0) NULL,
                    p2 numeric(18,0) NULL
);


--------------------------------------------------------------------------------------------INSERT BEFORE THIS





-- CREATE TYPE RG405_TParam as TABLE ([PERIOD] DateTime NOT NULL, [SP8010] char(9) NOT NULL, [SP408] char(9) NOT NULL, [SP418] char(9) NOT NULL, [SP411] numeric(14,5) NOT NULL);
--
-- CREATE PROCEDURE _1sp_RG405_TUpdate (@ItemTVP RG405_TParam READONLY) AS
-- BEGIN
-- MERGE RG405 AS target
--     USING (select PERIOD,SP8010,SP408,SP418,SP411 from @ItemTVP) AS source (PERIOD,SP8010,SP408,SP418,SP411)
--     ON (target.PERIOD = source.PERIOD AND target.SP8010 = source.SP8010 AND target.SP408 = source.SP408 AND target.SP418 = source.SP418)
--     WHEN MATCHED THEN
-- UPDATE SET target.SP411=target.SP411+source.SP411
--     WHEN NOT MATCHED THEN
-- INSERT (PERIOD, SP8010,SP408,SP418,SP411)
-- values (source.PERIOD, source.SP8010,source.SP408,source.SP418,source.SP411);
-- END;

Create procedure _1sp_RA405_WriteDocAct(@IdDoc CHAR(9), @LineNo SMALLINT, @ActNo INTEGER, @DebetCredit BIT, @p0 CHAR(9), @p1 CHAR(9), @p2 CHAR(9), @f0 NUMERIC(14, 5), @g0 CHAR(2), @g1 NUMERIC(16, 2), @DocDate DATETIME, @CurPeriod DATETIME, @RepeatToTM INTEGER, @SaveTurnsWithMonth INTEGER) AS

SET NOCOUNT ON
DECLARE @PeriodTA datetime, @Period datetime, @SnapShotPeriod char
SELECT @PeriodTA=CURDATE, @SnapShotPeriod=SNAPSHPER FROM _1SSYSTEM
    EXECUTE _1sp_GetBeginOfPeriod @PeriodTA, @SnapShotPeriod, @PeriodTA OUTPUT
INSERT INTO RA405 VALUES(@IdDoc, @LineNo, @ActNo, @DebetCredit, @p0, @p1, @p2, @f0, @g0, @g1)
    IF @DebetCredit=1
SELECT @f0=-@f0
           IF @RepeatToTM=1 BEGIN
SELECT @Period=@CurPeriod
           WHILE @Period<=@PeriodTA BEGIN
        EXECUTE _1sp_RG405_Change @Period, @p0, @p1, @p2, @f0
        EXECUTE _1sp_GetNextPeriod @Period, @SnapShotPeriod, @Period OUTPUT
END
END
ELSE
    EXECUTE _1sp_RG405_Change @CurPeriod, @p0, @p1, @p2, @f0
IF @SaveTurnsWithMonth=1 BEGIN
    EXECUTE _1sp_GetBeginOfPeriod @DocDate, 'M', @Period OUTPUT
    EXECUTE _1sp_RG405_Change @Period, @p0, @p1, @p2, @f0
END;

Create procedure _1sp_GetBeginOfPeriod(@BaseDate DATETIME, @Period CHAR(1), @NewDate DATETIME OUTPUT) AS

SET NOCOUNT ON
SET DATEFIRST 1
DECLARE @Day int
IF @Period='D'
SELECT @NewDate=@BaseDate
    ELSE IF @Period='W'
SELECT @NewDate=DATEADD(dd, -DATEPART(dw, @BaseDate)+1, @BaseDate)
    ELSE IF @Period='M'
SELECT @NewDate=DATEADD(mm, DATEDIFF(mm, '1753-01-01', @BaseDate), '1753-01-01')
    ELSE IF @Period='Q'
SELECT @NewDate=DATEADD(qq, DATEDIFF(qq, '1753-01-01', @BaseDate), '1753-01-01')
    ELSE IF @Period='Y'
SELECT @NewDate=DATEADD(yy, DATEDIFF(yy, '1753-01-01', @BaseDate), '1753-01-01')
    ELSE IF @Period='T'
BEGIN
SELECT @Day=DATEPART(dd, @BaseDate )
           IF @Day>15 SELECT @Day=15
	    ELSE       SELECT @Day=0
SELECT @NewDate=DATEADD(dd, @Day, DATEADD(mm, DATEDIFF(mm, '1753-01-01', @BaseDate), '1753-01-01'))
END
ELSE IF @Period='C'
BEGIN
SELECT @Day=DATEPART(dd, @BaseDate )
           IF      @Day>20  SELECT @Day=20
	    ELSE IF @Day>10  SELECT @Day=10
                                                         ELSE             SELECT @Day=0
SELECT @NewDate=DATEADD(dd, @Day, DATEADD(mm, DATEDIFF(mm, '1753-01-01', @BaseDate), '1753-01-01'))
END
ELSE IF @Period='F'
BEGIN
SELECT @Day=DATEPART(dd, @BaseDate )
           IF      @Day>25 SELECT @Day=25
        ELSE IF @Day>20 SELECT @Day=20
                                                       ELSE IF @Day>15 SELECT @Day=15
                                                                           ELSE IF @Day>10 SELECT @Day=10
                                                                                               ELSE IF @Day>5  SELECT @Day=5
                                                                                                                   ELSE            SELECT @Day=0
SELECT @NewDate=DATEADD(dd, @Day, DATEADD(mm, DATEDIFF(mm, '1753-01-01', @BaseDate), '1753-01-01'))
END
ELSE SELECT @NewDate=CONVERT(datetime, '1753-01-01');

Create procedure _1sp_GetEndOfPeriod(@BaseDate DATETIME, @Period CHAR(1), @NewDate DATETIME OUTPUT) AS

SET NOCOUNT ON
DECLARE @NextPeriod  datetime
EXECUTE _1sp_GetNextPeriod @BaseDate, @Period, @NextPeriod OUTPUT
SELECT @NewDate=DATEADD(dd, -1,  @NextPeriod);


Create procedure _1sp_GetNextPeriod(@BaseDate DATETIME, @Period CHAR(1), @NewDate DATETIME OUTPUT) AS

SET NOCOUNT ON
SET DATEFIRST 1
DECLARE @BeginOfPeriod datetime
DECLARE @day integer
EXECUTE _1sp_GetBeginOfPeriod @BaseDate, @Period, @BeginOfPeriod OUTPUT
IF @Period='D'
SELECT @NewDate=DATEADD(dd, 1,  @BeginOfPeriod)
    ELSE IF @Period='W'
SELECT @NewDate=DATEADD(wk, 1,  @BeginOfPeriod)
    ELSE IF @Period='M'
SELECT @NewDate=DATEADD(mm, 1,  @BeginOfPeriod)
    ELSE IF @Period='Q'
SELECT @NewDate=DATEADD(qq, 1,  @BeginOfPeriod)
    ELSE IF @Period='Y'
SELECT @NewDate=DATEADD(yy, 1,  @BeginOfPeriod)
    ELSE IF @Period='T' BEGIN
SELECT @day=DATEPART(dd, @BeginOfPeriod)
           IF @day>15 SELECT @NewDate=DATEADD(mm, DATEDIFF(mm, '1753-01-01', @BeginOfPeriod), '1753-02-01')
    ELSE       SELECT @NewDate=DATEADD(dd, 15, @BeginOfPeriod)
END
ELSE IF @Period='C' BEGIN
SELECT @day=DATEPART(dd, @BeginOfPeriod)
           IF @day>20 SELECT @NewDate=DATEADD(mm, DATEDIFF(mm, '1753-01-01', @BeginOfPeriod), '1753-02-01')
    ELSE       SELECT @NewDate=DATEADD(dd, 10, @BeginOfPeriod)
END
ELSE IF @Period='F' BEGIN
SELECT @day=DATEPART(dd, @BeginOfPeriod)
           IF @day>25 SELECT @NewDate=DATEADD(mm, DATEDIFF(mm, '1753-01-01', @BeginOfPeriod), '1753-02-01')
    ELSE       SELECT @NewDate=DATEADD(dd, 5,  @BeginOfPeriod)
END
ELSE SELECT @NewDate=CONVERT(datetime, '1753-01-01');

Create procedure _1sp_RG405_Change(@per DATETIME, @p1 CHAR(9), @p2 CHAR(9), @p3 CHAR(9), @p4 NUMERIC(14, 5)) AS

Set Nocount On
Update RG405
set SP411=Case When ABS(SP411+@p4)>999999999.99999 Then 999999999.99999 Else SP411+@p4 End
where PERIOD=@per AND SP8010=@p1 AND SP408=@p2 AND SP418=@p3
    if @@ROWCOUNT=0
insert into RG405 values(@per,@p1,@p2,@p3,@p4);
