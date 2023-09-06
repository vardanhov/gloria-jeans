SET
IDENTITY_INSERT _1SJOURN ON;
INSERT INTO Main.dbo._1SJOURN (ROW_ID, IDJOURNAL, IDDOC, IDDOCDEF, APPCODE, DATE_TIME_IDDOC, DNPREFIX, DOCNO, CLOSED,
                               ISMARK, ACTCNT, VERSTAMP, RF639, RF464, RF4667, RF4674, RF635, RF3549, RF4343, RF405,
                               RF328, RF351, RF2964, RF4335, RF4314, RF2351, RF438, RF4480, RF9048, SP74, SP798, SP4056,
                               SP5365, SP8033, SP8526, SP8608, DS1946, DS4757, DS5722)
VALUES (75016, 1913, N'  YBLX   ', 8244, 1, N'20210503CTZQA8  YBLX   ', N'      86552022    ', N'PM06040169     ', 1, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, N'     0   ', N'     0   ', N'     T   ', N'     0   ',
        N'00006040002042293', N'2021-05-04 00:00:00.000', 1, 1, 0, 0);
SET
IDENTITY_INSERT _1SJOURN OFF;

INSERT INTO Main.dbo.DH8655 (IDDOC, SP8642, SP8643, SP8644, SP8645, SP8646, SP8647, SP8708, SP8709, SP8650, SP8653,
                             SP8606, SP8607, SP8609, SP660)
VALUES (N'  YCR4   ', N'  YBLX   ', N'    3J   ', N'     T   ', N'    VQ   ', N'  2ABF   ', N'  2ABF   ', N'     1   ',
        0, 66, 14860.00, N'17:50:35', N'1753-01-01 00:00:00.000', N'        ', N'');

SET
IDENTITY_INSERT SC84 ON;
INSERT INTO Main.dbo.SC84 (ROW_ID, ID, CODE, DESCR, ISMARK, VERSTAMP, SP8014, SP8368, SP85, SP86, SP208, SP2417, SP8668,
                           SP8230, SP8669, SP97, SP5066, SP5013, SP94, SP4427, SP103, SP104, SP5012, SP8148, SP8850,
                           SP95, SP101, SP9068)
VALUES (1079206, N'  D0LK   ', N'999999',
        N'Фуфайка GKT009094 трикотаж белый/разноцветный XXS/165                                               ', 0, 0,
        N'00055550004171535', N'00055550004171535', N'GKT009094F0001           ', N'  RKHK   ', 0, N'   2Q2   ',
        N'   6QN   ', N'GKT009094', N'GKT009094F0001', 0.000, 0, N'     0   ', N'  RKHK   ', N'     0   ', N'    I8   ',
        N'     0   ', N'     0   ', N'4680063559958', N'   4GH   ', N'трикотаж, белый/разноцветный',
        N'Фуфайка GKT009094 трикотаж белый/разноцветный XXS/164', N'');
SET
IDENTITY_INSERT SC84 OFF;

-- Цена
INSERT INTO Main.dbo.SC319 (ID, PARENTEXT, ISMARK, VERSTAMP, SP6681, SP6682, SP327)
VALUES (N'  NI64   ', N'  D0LK   ', 0, 0, N'     1   ', 0.00, N'     1   ');

SET
IDENTITY_INSERT _1SCONST ON;
INSERT INTO Main.dbo._1SCONST (ROW_ID, OBJID, ID, DATE, VALUE, DOCID, TIME, ACTNO, LINENO_, TVALUE)
VALUES (96, N'  NI64   ', 324, '2004-12-09 00:00:00.000', N'124', N'  11Q2   ', 432100000, 1, 0, N'   '),
      (97, N'     0   ', 8024, '1753-01-01 00:00:00.000', N'     1   ', N'     0   ', 0, 0, 0, N'   ');
SET
IDENTITY_INSERT _1SCONST OFF;
