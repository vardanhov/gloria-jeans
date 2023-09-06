package ru.gloria_jeans.onecdbmapper;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.util.Strings;
import ru.gloria_jeans.onecdbmapper.mdparser.metadata.DocumentNode;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class Utils {
    private static final String poz = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String convertToBase10(String input) {
        input = input.trim();
        double vv = 0, pow = 0;

        for (int i = input.length(); i > 0; i--) {
            int idx = poz.indexOf(input.charAt(i - 1));
            vv = vv + idx * Math.pow(36, pow);
            pow++;
        }

        return String.valueOf((int) vv);
    }

    public static String convertToBase36(String input) {
        int deci = Integer.parseInt(input);
        StringBuilder rez = new StringBuilder();

        while (true) {
            int prom = deci / 36;
            rez.insert(0, poz.charAt(deci - (prom * 36)));
            if (prom == 0) break;
            deci = prom;
        }

        return StringUtils.rightPad(StringUtils.leftPad(rez.toString(), 6, ' '), 9, ' ');
    }

    public static String getOnecTime(LocalDateTime b) {
        String v = String.valueOf(((b.getHour() * 60 + b.getMinute()) * 60 + b.getSecond()) * 10000);
        v = StringUtils.leftPad(Utils.convertToBase36(v).trim(), 6, ' ');
        return v;
    }

    public static Integer getDef(String documentKey) {
        return Integer.parseInt(
                OnecDbMapper.getOnecMetadata().Documents.get(documentKey).getID()
        );
    }

    public static Integer getJournalId(Integer id) {
        return Integer.parseInt(
                OnecDbMapper.getOnecMetadata().Documents.values()
                        .parallelStream()
                        .filter(x -> x.getID().equals(id.toString()))
                        .findFirst()
                        .get()
                        .getIDJOURNAL()
        );
    }

    public static String getPrefix(Integer id) {
        String dnprefix = Strings.EMPTY;
        DocumentNode node = OnecDbMapper.getOnecMetadata().Documents.values()
                .parallelStream()
                .filter(x -> x.getID().equals(id.toString()))
                .findFirst()
                .get();

        if (node.getIDNumerator().trim().equals("0")) {
            String period = node.ww[5];
            String add = Strings.EMPTY;

            if (period.equals("1")) {
                add = String.valueOf(LocalDateTime.now().getYear());
            }

            dnprefix = String.format(
                    "%s%s",
                    StringUtils.leftPad(node.getID(), 10, ' '),
                    StringUtils.rightPad(add, 8, ' ')
            );
        } else {
            dnprefix = String.format(
                    "%s        ",
                    StringUtils.leftPad(node.getIDNumerator(), 10, ' ')
            );
        }

        return dnprefix;
    }

    public static String build23Ref(String type, Integer Def, String val) {
        //return (Type + Utils.ToBase36(Def.ToString()).Trim().PadLeft(4, ' ') + val).PadRight(23, ' ');
        return StringUtils.rightPad(type + StringUtils.leftPad(Utils.convertToBase36(Def.toString()).trim(), 4, ' ') + val, 23, ' ');
    }

    public static String build13Ref(Integer Def, String val) {
        //return (Utils.ToBase36(Def.ToString()).Trim().PadLeft(4, ' ') + val).PadRight(13, ' ');
        return StringUtils.rightPad(StringUtils.leftPad(Utils.convertToBase36(Def.toString()).trim(), 4, ' ') + val, 13, ' ');
    }

    public static Date convertDateTimeIdDocToDate(String dateTimeIdDoc) throws Exception {
        long totalMilliseconds = Long.parseLong(Utils.convertToBase10(dateTimeIdDoc.substring(8, 14)));
        int totalSeconds = (int) (totalMilliseconds / 10000);
        int second = totalSeconds % 60;
        int totalMinutes = totalSeconds / 60;
        int minute = totalMinutes % 60;
        int hour = totalMinutes / 60;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = dateFormat.parse(
                String.format(
                        "%s%02d%02d%02d",
                        dateTimeIdDoc.substring(0, 8),
                        hour,
                        minute,
                        second
                )
        );
        return date;
    }

    public static Date getBeginOfPeriod(Date date, String snapShotPeriod) {
        LocalDate basePeriod = new Date(date.getTime())
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        switch (snapShotPeriod) {
//            case "D": {
//                basePeriod = basePeriod;
//                break;
//            }

            case "W": {
                basePeriod = basePeriod.plusDays(-(basePeriod.getDayOfWeek() == DayOfWeek.SUNDAY ? 7 : basePeriod.getDayOfWeek().getValue()) + 1);//  basePeriod.DayOfWeek) + 1);
                break;
            }

            case "M": {
                basePeriod = LocalDate.of(basePeriod.getYear(), basePeriod.getMonth(), 1); // basePeriod.AddDays(-basePeriod.Day+1);
                break;
            }

            case "Q": {
                basePeriod = LocalDate.of(basePeriod.getYear(), (basePeriod.getMonth().getValue() - 1) / 3 + 1, 1);
                break;
            }

            case "Y": {
                basePeriod = LocalDate.of(basePeriod.getYear(), 1, 1);
                break;
            }

            case "T": {
                int tDay = basePeriod.getDayOfMonth();

                if (tDay > 15) {
                    tDay = 16;
                } else {
                    tDay = 1;
                }

                basePeriod = LocalDate.of(basePeriod.getYear(), basePeriod.getMonth(), tDay);
                break;
            }

            case "C": {
                int cDay = basePeriod.getDayOfMonth();

                if (cDay > 20) {
                    cDay = 21;
                } else if (cDay > 10) {
                    cDay = 11;
                } else {
                    cDay = 1;
                }

                basePeriod = LocalDate.of(basePeriod.getYear(), basePeriod.getMonth(), cDay);
                break;
            }

            case "F": {
                int fDay = basePeriod.getDayOfMonth();

                if (fDay > 25) {
                    fDay = 26;
                } else if (fDay > 20) {
                    fDay = 21;
                } else if (fDay > 15) {
                    fDay = 16;
                } else if (fDay > 10) {
                    fDay = 11;
                } else if (fDay > 5) {
                    fDay = 6;
                } else {
                    fDay = 1;
                }

                basePeriod = LocalDate.of(basePeriod.getYear(), basePeriod.getMonth(), fDay);
                break;
            }

            default: {
                basePeriod = LocalDate.of(1753, 1, 1);
                break;
            }
        }

        return Date.from(
                basePeriod
                        .atStartOfDay()
                        .atZone(ZoneId.systemDefault())
                        .toInstant()
        );
    }

    public static Date getNextPeriod(Date date, String snapShotPeriod) {
        LocalDate basePeriod = null;
        LocalDate beginOfPeriod = new Date(Utils.getBeginOfPeriod(date, snapShotPeriod).getTime())
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        switch (snapShotPeriod) {
            case "D": {
                basePeriod = beginOfPeriod.plusDays(1);
                break;
            }

            case "W": {
                basePeriod = beginOfPeriod.plusDays(7);
                break;
            }

            case "M": {
                basePeriod = beginOfPeriod.plusMonths(1);
                break;
            }

            case "Q": {
                basePeriod = beginOfPeriod.plusMonths(3);
                break;
            }

            case "Y": {
                basePeriod = beginOfPeriod.plusYears(1);
                break;
            }

            case "T": {
                int tDay = beginOfPeriod.getDayOfMonth();

                if (tDay == 1) {
                    basePeriod = LocalDate.of(beginOfPeriod.getYear(), beginOfPeriod.getMonth(), 16);
                } else {
                    basePeriod = LocalDate.of(beginOfPeriod.getYear(), beginOfPeriod.getMonth(), 1).plusMonths(1);
                }

                break;
            }

            case "C": {
                int cDay = beginOfPeriod.getDayOfMonth();

                if (cDay > 20) {
                    basePeriod = LocalDate.of(beginOfPeriod.getYear(), beginOfPeriod.getMonth(), 1).plusMonths(1);
                } else {
                    basePeriod = beginOfPeriod.plusDays(10);
                }

                break;
            }

            case "F": {
                int fDay = beginOfPeriod.getDayOfMonth();

                if (fDay > 25) {
                    basePeriod = LocalDate.of(beginOfPeriod.getYear(), beginOfPeriod.getMonth(), 1).plusMonths(1);
                } else {
                    basePeriod = beginOfPeriod.plusDays(5);
                }

                break;
            }

            default: {
                basePeriod = LocalDate.of(1753, 1, 1);
                break;
            }
        }

        return Date.from(
                basePeriod
                        .atStartOfDay()
                        .atZone(ZoneId.systemDefault())
                        .toInstant()
        );
    }
}
