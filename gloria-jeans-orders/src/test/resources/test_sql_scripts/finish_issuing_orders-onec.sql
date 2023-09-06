INSERT INTO Main.dbo.[_1SJOURN] (IDJOURNAL, IDDOC, IDDOCDEF, APPCODE, DATE_TIME_IDDOC, DNPREFIX, DOCNO, CLOSED,
                                 ISMARK, ACTCNT, VERSTAMP, RF639, RF464, RF4667, RF4674, RF635, RF3549, RF4343, RF405,
                                 RF328, RF351, RF2964, RF4335, RF4314, RF2351, RF438, RF4480, RF9048, SP74, SP798,
                                 SP4056, SP5365, SP8033, SP8526, SP8608, DS1946, DS4757, DS5722)
VALUES
    (1913, N'  ZTIT   ', 9179, 1, N'20211029BTVD0G  ZTIT   ', N'      91792021    ', N'1025503207     ', 1, 0, 0, 2009681864, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, N'     0   ', N'     0   ', N'     T   ', N'     0   ', N'H0013611025503207', '2021-11-03 00:00:00.000', 1, 0, 0, 0);

INSERT INTO Main.dbo.DH9170 (IDDOC, SP9155, SP9156, SP9157, SP9158, SP9159, SP9160, SP9161, SP9162, SP9193, SP9194,
                             SP9195, SP9196, SP9197, SP9198, SP9215, SP9216, SP9217, SP9218, SP9219, SP9220, SP9164,
                             SP9165, SP9167, SP8606, SP8607, SP8609, SP660)
VALUES (N'  ZTIT   ', N'             ', N'1025503207                                        ',
        N'Ульяна Мусина;+79888900307                                                                          ',
        N'    VQ   ', N'  218F   ', N'     0   ', N'     1   ', N'     0   ', N'     0   ', N'     0   ',
        N'                                                                                                                                                                                                        ',
        N'   73P   ',
        N'                                                                                                                                                                                                        ',
        N'                                                                                                                                                                                                        ',
        N'                                                                                                                                           ',
        N'cdek', N'                                                  ', 0.00, 0.00, 0.00, 1, 1, 999.00, N'21:46:46',
        '2021-10-29 00:00:00.000', N'20:14:17', N'');

INSERT INTO Main.dbo.DT9170 (IDDOC, LINENO_, SP9163, SP9164, SP9165, SP9166, SP9167, SP9168, SP9221, SP9222)
VALUES (N'  ZTIT   ', 1, N'  R0ZY   ', 1, 1, 999.00, 999.00,
        N'                                                                                                                                  ',
        N'  ', 0);

SET IDENTITY_INSERT SC14 ON;
INSERT INTO Main.dbo.SC14 (ROW_ID, ID, CODE, DESCR, ISMARK, VERSTAMP, SP18, SP15) VALUES (1, N'     1   ', N'1  ', N'руб       ', 0, 0, N'Рубли                                             ', N'                                                  ');
INSERT INTO Main.dbo.SC14 (ROW_ID, ID, CODE, DESCR, ISMARK, VERSTAMP, SP18, SP15) VALUES (2, N'     2   ', N'2  ', N'$         ', 0, 0, N'Бакс                                              ', N'                                                  ');
SET IDENTITY_INSERT SC14 OFF;

SET IDENTITY_INSERT _1SCONST ON;
INSERT INTO Main.dbo._1SCONST (ROW_ID, OBJID, ID, DATE, VALUE, DOCID, TIME, ACTNO, LINENO_, TVALUE) VALUES(89, N'     0   ', 448, '1753-01-01 00:00:00.000', N'     1   ', N'     0   ', 0, 0, 0, N'   ');
INSERT INTO Main.dbo._1SCONST (ROW_ID, OBJID, ID, DATE, VALUE, DOCID, TIME, ACTNO, LINENO_, TVALUE) VALUES (90, N'     1   ', 17, N'2003-08-06 00:00:00.000', N'32', N'     0   ', 0, 0, 0, N'   ');
INSERT INTO Main.dbo._1SCONST (ROW_ID, OBJID, ID, DATE, VALUE, DOCID, TIME, ACTNO, LINENO_, TVALUE) VALUES (92, N'     2   ', 17, N'2003-08-06 00:00:00.000', N'1', N'     0   ', 0, 0, 0, N'   ');
INSERT INTO Main.dbo._1SCONST (ROW_ID, OBJID, ID, DATE, VALUE, DOCID, TIME, ACTNO, LINENO_, TVALUE) VALUES (91, N'     1   ', 16, N'2003-07-31 00:00:00.000', N'1', N'     0   ', 0, 0, 0, N'   ');
INSERT INTO Main.dbo._1SCONST (ROW_ID, OBJID, ID, DATE, VALUE, DOCID, TIME, ACTNO, LINENO_, TVALUE) VALUES (93, N'     2   ', 16, N'2003-08-06 00:00:00.000', N'1', N'     0   ', 0, 0, 0, N'   ');
INSERT INTO Main.dbo._1SCONST (ROW_ID, OBJID, ID, DATE, VALUE, DOCID, TIME, ACTNO, LINENO_, TVALUE) VALUES (94, N'     0   ', 8034, '1753-01-01 00:00:00.000', N'1031237', N'     0   ', 0, 0, 0, N'   ');
INSERT INTO Main.dbo._1SCONST (ROW_ID, OBJID, ID, DATE, VALUE, DOCID, TIME, ACTNO, LINENO_, TVALUE) VALUES (95, N'     0   ', 8013, '1753-01-01 00:00:00.000', N'0001361', N'     0   ', 0, 0, 0, N'   ');
INSERT INTO Main.dbo._1SCONST (ROW_ID, OBJID, ID, DATE, VALUE, DOCID, TIME, ACTNO, LINENO_, TVALUE) VALUES (96, N'  NI64   ', 324, '2004-12-09 00:00:00.000' , N'124', N'  11Q2   ', 432100000, 1, 0, N'   ');
INSERT INTO Main.dbo._1SCONST (ROW_ID, OBJID, ID, DATE, VALUE, DOCID, TIME, ACTNO, LINENO_, TVALUE) VALUES (99, N'  NI65   ', 324, '2004-12-09 00:00:00.000' , N'200', N'  11Q2   ', 432100000, 1, 0, N'   ');

INSERT INTO Main.dbo._1SCONST (ROW_ID, OBJID, ID, DATE, VALUE, DOCID, TIME, ACTNO, LINENO_, TVALUE) VALUES (97, N'     0   ', 8024, '1753-01-01 00:00:00.000', N'     1   ',N'     0   ',0,0,0,N'   ');
INSERT INTO Main.dbo._1SCONST (ROW_ID, OBJID, ID, DATE, VALUE, DOCID, TIME, ACTNO, LINENO_, TVALUE) VALUES (98, N'     0   ', 8156, '1753-01-01 00:00:00.000', N'0', N'     0   ', 0, 0, 0, N'   ');
SET IDENTITY_INSERT _1SCONST OFF;

INSERT INTO Main.dbo.SC55 (ID, CODE, DESCR, ISMARK, VERSTAMP, SP8441, SP8447, SP8442, SP8451, SP425, SP8443, SP3019,
                           SP4254, SP56, SP8444, SP8445, SP8448, SP8674, SP8995, SP8996, SP8997)
VALUES (N'    VQ   ', N'595  ', N'м-н Ростов-на-Дону ТЦ РИО                                       ', 0, 0,
        N'00005550003814628', N'0001361',
        N'г. Ростов-на-Дону, пр. Михаила Нагибина 17                                                          ',
        N'     I   ', N'     0   ', N'   6KM   ', 0, 0, 0, N'   6KO   ', N'8-800-500-82-82,1674', N'     T   ',
        N'    1D   ', N'     0   ', N'   8H4   ', N'     0   ');

INSERT INTO Main.dbo._1SSYSTEM (CURDATE, CURTIME, EVENTIDTA, DBSIGN, DBSETUUID, SNAPSHPER, ACCDATE, FLAGS)
VALUES('2023-07-27 00:00:00.000', 588450100, N'  FGWM   ', N'   ', N'00000000-0000-0000-0000-000000000000', N'M', '2003-07-01 00:00:00.000', 0);

INSERT INTO Main.dbo._1SUSERS (USRSCNT, NETCHGCN)
VALUES(1, 17);


Create procedure _1sp__1SJOURN_MaxID(@id CHAR(9) OUTPUT) AS
set nocount on select @id=MAX(IDDOC) from _1SJOURN(NOLOCK) if @id is null select @id='         ';
