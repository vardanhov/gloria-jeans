INSERT INTO Main.dbo._1SJOURN (IDJOURNAL, IDDOC, IDDOCDEF, APPCODE, DATE_TIME_IDDOC, DNPREFIX, DOCNO, CLOSED, ISMARK,
                               ACTCNT, VERSTAMP, RF639, RF464, RF4667, RF4674, RF635, RF3549, RF4343, RF405, RF328,
                               RF351, RF2964, RF4335, RF4314, RF2351, RF438, RF4480, RF9048, SP74, SP798, SP4056,
                               SP5365, SP8033, SP8526, SP8608, DS1946, DS4757, DS5722)
VALUES (1913, N'  FDY3   ', 8244, 1, N'20230612CKYDBK  FDY3   ', N'      82442023    ', N'Л323ПР000079210', 1, 0, 0, 12,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, N'     0   ', N'     0   ', N'    1J   ', N'     0   ',
        N'00002780081106691', '2023-06-17 00:00:00.000', 0, 1, 0, 0);

INSERT INTO Main.dbo.DH8244 (IDDOC, SP8238, SP8239, SP8240, SP8282, SP8283, SP8284, SP8285, SP8470, SP8471, SP8472,
                             SP8473, SP8474, SP8475, SP8638, SP8699, SP8700, SP8892, SP9093, SP9132, SP9133, SP9151,
                             SP9190, SP9191, SP8242, SP8479, SP8606, SP8607, SP8609, SP660)
VALUES (N'  FDY3   ', N'     0   ', N'   16L   ', N'     1   ', N'                                                  ',
        N'   1I0   ', N'     0   ', N'     0   ', N'     T   ', N'   1I0   ', 1.0000, 11, N'     6   ', 1,
        '1753-01-01 00:00:00.000', 0, N'                 ', N'   16P   ', N'                    ', 0.00, N'     0   ',
        N'                                    ', N'                                    ', N'                    ',
        373.000, 312394.00, N'09:13:40', '2023-06-12 00:00:00.000', N'        ', N'');

INSERT INTO Main.dbo.SC8672 (ID, CODE, DESCR, ISMARK, VERSTAMP, SP8670)
VALUES ('     6   ', '10', 'Первоначальное распределение                                ', 0, 1, '00005550003212109');

INSERT INTO Main.dbo.SC55 (ID, CODE, DESCR, ISMARK, VERSTAMP, SP8441, SP8447, SP8442, SP8451, SP425, SP8443, SP3019,
                           SP4254, SP56, SP8444, SP8445, SP8448, SP8674, SP8995, SP8996, SP8997)
VALUES (N'   16L   ', N'7160 ', N'Новошахтинск №1                                                 ', 0, 1,
        N'00005550006191527', N'0000178',
        N'г. Новошахтинск, ул. Городская, 1а                                                                  ',
        N'     I   ', N'     0   ', N'   6QL   ', 0, 0, 0, N'   6KO   ', N'8(863)2-618-901     ', N'    1J   ',
        N'     1   ', N'     0   ', N'   6XP   ', N'     0   ');

INSERT INTO Main.dbo.DT8244 (IDDOC, LINENO_, SP8241, SP8242, SP8286, SP8381, SP8476, SP8477, SP8478, SP8479, SP8639,
                             SP9077, SP9094)
VALUES (N'  FDY3   ', 242, N'  V0VX   ', 2.000, 3, N'     0   ', N'  Z6XH   ', 1.000, 165.00, 330.00,
        N'0010803041844       ',
        N'                                                                                                                                  ',
        0);

SET
IDENTITY_INSERT SC84 ON;
INSERT INTO Main.dbo.SC84 (ROW_ID, ID, CODE, DESCR, ISMARK, VERSTAMP, SP8014, SP8368, SP85, SP86, SP208, SP2417, SP8668,
                           SP8230, SP8669, SP97, SP5066, SP5013, SP94, SP4427, SP103, SP104, SP5012, SP8148, SP8850,
                           SP95, SP101, SP9068)
VALUES (1430135, N'  V0VX   ', N'999999',
        N'Лот 1 Ободок GJW010325 пластик синий                                                                ', 0, 1,
        N'00044040000202987', N'00044040000202987', N'GJW01032502L01           ', N'  Z6XH   ', 0, N'   2Q2   ',
        N'   6QO   ', N'GJW010325', N'AAL0000202987 ', 0.000, 0, N'     0   ', N'  Z6XH   ', '     0   ', '    I8   ',
        '     0   ', '     0   ', '4680199065330', '   72R   ', N'пластик, синий',
        N'Лот 1 Ободок GJW010325 пластик синий', ''),
       (1429728, '  V0KM   ', '999999',
        'Ободок GJW010325 пластик синий                                                                      ', 0, 1,
        '00055550005725579', '00055550005725579', 'GJW010325F0002           ', '  Z6M6   ', 0, '   2Q2   ', '   6QN   ',
        'GJW010325', 'GJW010325F0002', 0.000, 0, '     0   ', '  Z6M6   ', '     0   ', '    I8   ', '     0   ',
        '     0   ', '4680199060151', '   72R   ', 'пластик, синий', 'Ободок GJW010325 пластик синий', '');

SET
IDENTITY_INSERT SC84 OFF;

INSERT INTO Main.dbo.SC319 (ID, PARENTEXT, ISMARK, VERSTAMP, SP6681, SP6682, SP327)
VALUES (N'  NI64   ', N'  D0LK   ', 0, 0, N'     1   ', 0.00, N'     1   '),
       (N'  NI65   ', N'  P5Pf   ', 0, 0, N'     1   ', 0.00, N'     1   '),
       (N' 1FV2U   ', '  V0KM   ', 0, 1, '     1   ', 0.00, '     1   '),
       (N' 1GNVG   ', '  V0KM   ', 0, 0, '     1   ', 0.00, '     2   ');

INSERT INTO Main.dbo.SC8679 (ID, CODE, PARENTEXT, ISMARK, VERSTAMP, SP8675, SP8676, SP8677)
VALUES (N'     7   ', N'         7', N'  38K1   ', 0, 0, N'  268H   ', 2, N'00055550000052543'),
       ('  Z1C5   ', '   1634693', '  V0VX   ', 0, 1, '  V0KM   ', 3, '00055550005727798');

SET
IDENTITY_INSERT _1SCONST ON;
INSERT INTO Main.dbo._1SCONST (ROW_ID, OBJID, ID, DATE, VALUE, DOCID, TIME, ACTNO, LINENO_, TVALUE)
VALUES (99, N'  NI65   ', 324, '2004-12-09 00:00:00.000', N'200', N'  11Q2   ', 432100000, 1, 0, N'   '),
       (2704609, '  V0KM   ', 324, '2017-03-06 00:00:00.000', '0.00', '  6VNZ   ', 441500000, 65, 0, '   '),
       (5258386, ' 1FV2U   ', 324, '2023-03-13 00:00:00.000', '55.00', '  EP1F   ', 811990000, 64, 0, '   '),
       (96, N'  NI64   ', 324, '2004-12-09 00:00:00.000', N'124', N'  11Q2   ', 432100000, 1, 0, N'   '),
       (97, N'     0   ', 8024, '1753-01-01 00:00:00.000', N'     1   ', N'     0   ', 0, 0, 0, N'   ');
SET
IDENTITY_INSERT _1SCONST OFF;

