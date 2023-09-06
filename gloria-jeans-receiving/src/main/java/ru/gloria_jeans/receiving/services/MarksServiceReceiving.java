package ru.gloria_jeans.receiving.services;

import com.google.common.base.Strings;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.gloria_jeans.core.v1.marks.services.MarksService;
import ru.gloria_jeans.onecdbmapper.dao.model.Tnved;
import ru.gloria_jeans.receiving.configuration.MarkConstantsReceiving;
import ru.gloria_jeans.receiving.dao.model.Product;
import ru.gloria_jeans.receiving.dao.model.ScannedMark;
import ru.gloria_jeans.receiving.model.marks.AddingEdoPa;
import ru.gloria_jeans.receiving.model.marks.Mark;
import ru.gloria_jeans.receiving.model.marks.MarkTransaction;
import ru.gloria_jeans.receiving.model.marks.ResponseMark;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.Charset;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MarksServiceReceiving {
    public Logger logger = LoggerFactory.getLogger("MarksService");
    private final String serverMarksUrl;
    private final String serverMarksAuthorizationUrl;
    private final String username;
    private final String password;
    private final MarksService marksService;
    private final MarkConstantsReceiving markConstants;


    @Autowired
    public MarksServiceReceiving(
            @Value("${marks.server.url}") String serverMarksUrl,
            @Value("${marks.server.authorization.url}") String serverMarksAuthorizationUrl,
            @Value("${marks.server.authorization.username}") String username,
            @Value("${marks.server.authorization.password}") String password,
            MarksService marksService,
            MarkConstantsReceiving markConstants
    ) {
        this.serverMarksUrl = serverMarksUrl;
        this.serverMarksAuthorizationUrl = serverMarksAuthorizationUrl;
        this.username = username;
        this.password = password;
        this.marksService = marksService;
        this.markConstants = markConstants;
    }

    public String validate(List<String> marks, String currentStoreIdd, String firmIdd) {
        return marksService.validate(
                marks
                        .parallelStream()
                        .collect(Collectors.joining(",")),
                currentStoreIdd,
                firmIdd,
                serverMarksUrl,
                serverMarksAuthorizationUrl,
                username,
                password
        );
    }

    public String validate(String mark, String currentStoreIdd, String firmIdd) {
        return marksService.validate(
                mark,
                currentStoreIdd,
                firmIdd,
                serverMarksUrl,
                serverMarksAuthorizationUrl,
                username,
                password);
    }

    public String addEdoPa(
            String edoType,
            String srcInn,
            String srcKpp,
            String dstInn,
            String dstKpp,
            String docIdd,
            String docNum,
            String storeIdd,
            String receivingEdm,
            String firmEdm,
            String denominationDocument, //НаимДокОпр
            String denominationFirm, //НаименованиеФирма
            String function, //Функ
            Instant documentBasisDate,
            String documentNumber, //НомерСчф
            String firmTin, //ИННФирма
            String warehouseFirmRrc, //КППФирма
            String legalAddress, //АдресФирма
            String warehouseAddress, //АдресСклад
            String warehouseFirmTin, //ИННФирмаПолучатель
            String denominationReceivingFirm, //НаименованиеФирмаПолучатель
            String warehouseReceivingAddress, //АдресСкладПолучатель
            String firmReceivingRcc, //КППФирмаПолучатель
            String firmReceivingAddress,  //АдресФирмаПолучатель
            String contract, //Договор
            String commissionUtd, //КомиссионныйУПД
            List<Product> products,
            List<Tnved> tnveds
    ) throws Exception {
        String token = marksService.auth(serverMarksAuthorizationUrl, username, password);

        if (!Strings.isNullOrEmpty(token)) {
            LocalDateTime date = LocalDateTime.now();
            String uuid = UUID.randomUUID().toString();
            String fileName = String.format(
                    "ON_NSCHFDOPPRMARK_%s_%s_%s_%s.xml",
                    receivingEdm,
                    firmEdm,
                    date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                    uuid
            );
            String xml = generateXmlUpd(
                    fileName,
                    date,
                    receivingEdm,
                    firmEdm,
                    denominationDocument, //НаимДокОпр
                    denominationFirm, //НаименованиеФирма
                    function, //Функ
                    documentBasisDate,
                    documentNumber, //НомерСчф
                    firmTin, //ИННФирма
                    warehouseFirmRrc, //КППФирма
                    legalAddress, //АдресФирма
                    warehouseAddress, //АдресСклад
                    warehouseFirmTin, //ИННФирмаПолучатель
                    denominationReceivingFirm, //НаименованиеФирмаПолучатель
                    warehouseReceivingAddress, //АдресСкладПолучатель
                    firmReceivingRcc, //КППФирмаПолучатель
                    firmReceivingAddress,  //АдресФирмаПолучатель
                    contract, //Договор
                    commissionUtd, //КомиссионныйУПД
                    products,
                    tnveds
            );
            Charset charset = Charset.forName("CP1251");
            String xmlCP1251 = new String(xml.getBytes(charset), charset);
            logger.info("Generated XML (UTF-8):\r\n'{}'\r\n", xml);
            logger.info("Generated XML (CP-1251):\r\n'{}'\r\n", xmlCP1251);
            AddingEdoPa addingEdoPa = new AddingEdoPa(
                    edoType,
                    srcInn,
                    srcKpp,
                    dstInn,
                    dstKpp,
                    docIdd,
                    docNum,
                    "MOVE_STORES",
                    storeIdd,
                    products
                            .parallelStream()
                            .flatMap(x ->
                                    x.getScannedMarks()
                                            .parallelStream()
                                            .filter(ScannedMark::getValidMark)
                            )
                            .map(ScannedMark::getDataMatrix)
                            .collect(Collectors.joining(",")),
                    "false",
                    Base64.getEncoder().encodeToString(xmlCP1251.getBytes(charset)),
                    fileName
            );
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", String.format("Bearer %s", token));
            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<AddingEdoPa> request = new HttpEntity<>(addingEdoPa, headers);
            ResponseEntity<String> response = restTemplate.exchange(
                    String.format("%s/api/SBIS/AddDoc", serverMarksUrl),
                    HttpMethod.POST,
                    request,
                    String.class
            );
            String responseBody = response.getBody();
            logger.info("Mark adding EDM get OK status. Body: {}", responseBody);
            Gson gson = new Gson();
            return gson.fromJson(responseBody, ResponseMark.class).getSbis_idd();
        } else {
            throw new Exception("Authorization token return empty.");
        }
    }

    public boolean addMarkTransaction(
            String subType,
            Instant date,
            String number,
            String idd,
            String src,
            String dst,
            String storeIdd,
            List<Mark> mark
    ) throws Exception {
        String token = marksService.auth(serverMarksAuthorizationUrl, username, password);

        if (!Strings.isNullOrEmpty(token)) {
            MarkTransaction markTransaction = new MarkTransaction(
                    "MOVE",
                    subType,
                    DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.ofInstant(date, ZoneOffset.UTC)),
                    number,
                    idd,
                    src,
                    dst,
                    storeIdd,
                    mark
            );
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", String.format("Bearer %s", token));
            headers.setContentType(MediaType.APPLICATION_XML);
            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<MarkTransaction> request = new HttpEntity<>(markTransaction, headers);
            ResponseEntity<String> response = restTemplate.exchange(
                    String.format("%s/api/AddMarkTransaction", serverMarksUrl),
                    HttpMethod.POST,
                    request,
                    String.class
            );
            String responseBody = response.getBody();
            logger.info("Mark adding EDM get OK status. Body: {}", responseBody);
            Gson gson = new Gson();
            return Strings.isNullOrEmpty(gson.fromJson(responseBody, ResponseMark.class).getError());

        } else {
            throw new Exception("Authorization token return empty.");
        }
    }

    public boolean isFromWarehouse(String fromFirmIdd) {
        if (fromFirmIdd.equals(markConstants.getRetailIdd())) {
            return false;
        } else if (fromFirmIdd.equals(markConstants.getEcommerceIdd())) {
            return false;
        } else if (fromFirmIdd.equals(markConstants.getContinentIdd())) {
            return false;
        } else if (fromFirmIdd.equals(markConstants.getKazakhstanIdd())) {
            return false;
        } else {
            return true;
        }
    }

    public String generateXmlUpd(
            String fileName,
            LocalDateTime date,
            String receivingEdm,
            String firmEdm,
            String denominationDocument, //НаимДокОпр
            String denominationFirm, //НаименованиеФирма
            String function, //Функ
            Instant documentBasisDate,
            String documentNumber, //НомерСчф
            String firmTin, //ИННФирма
            String warehouseFirmRrc, //КППФирма
            String legalAddress, //АдресФирма
            String warehouseAddress, //АдресСклад
            String warehouseFirmTin, //ИННФирмаПолучатель
            String denominationReceivingFirm, //НаименованиеФирмаПолучатель
            String warehouseReceivingAddress, //АдресСкладПолучатель
            String firmReceivingRcc, //КППФирмаПолучатель
            String firmReceivingAddress,  //АдресФирмаПолучатель
            String contract, //Договор
            String commissionUtd, //КомиссионныйУПД
            List<Product> products,
            List<Tnved> tnveds
    ) {
        StringBuilder xml = new StringBuilder();
        xml
                .append("<?xml version=\"1.0\" encoding=\"windows-1251\"?>\n")
                .append("<Файл ВерсПрог=\"СБИС\" ВерсФорм=\"5.01\" ИдФайл=\"").append(fileName).append("\">\n")
                .append("  <СвУчДокОбор ИдОтпр=\"").append(firmEdm).append("\" ИдПол=\"").append(receivingEdm).append("\">\n")
                .append("    <СвОЭДОтпр ИННЮЛ=\"7605016030\" ИдЭДО=\"2BE\" НаимОрг=\"ООО «Компания «Тензор»\" />\n")
                .append("  </СвУчДокОбор>\n")
                .append("  <Документ ВремИнфПр=\"").append(date.format(DateTimeFormatter.ofPattern("HH.mm.ss"))).append("\" ДатаИнфПр=\"").append(date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))).append("\" КНД=\"1115131\" НаимДокОпр=\"").append(denominationDocument).append("\" НаимЭконСубСост=\"").append(denominationFirm).append("\" ПоФактХЖ=\"Документ об отгрузке товаров (выполнении работ), передаче имущественных прав (документ об оказании услуг)\" Функция=\"").append(function).append("\">\n")
                .append("    <СвСчФакт ДатаСчФ=\"").append(DateTimeFormatter.ofPattern("dd.MM.yyyy").withLocale(Locale.getDefault()).withZone(ZoneId.systemDefault()).format(documentBasisDate)).append("\" КодОКВ=\"643\" НомерСчФ=\"").append(documentNumber).append("\">\n")
                .append("      <СвПрод>\n")
                .append("        <ИдСв>\n")
                .append("          <СвЮЛУч ИННЮЛ=\"").append(warehouseFirmTin).append("\" КПП=\"").append(warehouseFirmRrc).append("\" НаимОрг=\"").append(denominationFirm).append("\" />\n")
                .append("        </ИдСв>\n")
                .append("        <Адрес>\n")
                .append("          <АдрИнф АдрТекст=\"").append(legalAddress).append("\" КодСтр=\"643\" />\n")
                .append("        </Адрес>\n")
                .append("      </СвПрод>\n")
                .append("      <ГрузОт>\n")
                .append("        <ГрузОтпр>\n")
                .append("          <ИдСв>\n")
                .append("            <СвЮЛУч ИННЮЛ=\"").append(firmTin).append("\" НаимОрг=\"").append(denominationFirm).append("\" />\n")
                .append("          </ИдСв>\n")
                .append("          <Адрес>\n")
                .append("            <АдрИнф АдрТекст=\"").append(warehouseAddress).append("\" КодСтр=\"643\" />\n")
                .append("          </Адрес>\n")
                .append("       </ГрузОтпр>\n")
                .append("      </ГрузОт>\n")
                .append("      <ГрузПолуч>\n")
                .append("       <ИдСв>\n")
                .append("          <СвЮЛУч ИННЮЛ=\"").append(firmTin).append("\" НаимОрг=\"").append(denominationReceivingFirm).append("\" />\n")
                .append("       </ИдСв>\n")
                .append("       <Адрес>\n")
                .append("          <АдрИнф АдрТекст=\"").append(warehouseReceivingAddress).append("\" КодСтр=\"643\" />\n")
                .append("       </Адрес>\n")
                .append("     </ГрузПолуч>\n")
                .append("     <СвПокуп>\n")
                .append("       <ИдСв>\n")
                .append("          <СвЮЛУч ИННЮЛ=\"").append(firmTin).append("\" КПП=\"").append(firmReceivingRcc).append("\" НаимОрг=\"").append(denominationReceivingFirm).append("\" />\n")
                .append("       </ИдСв>\n")
                .append("       <Адрес>\n")
                .append("          <АдрИнф АдрТекст=\"").append(firmReceivingAddress).append("\" КодСтр=\"643\" />\n")
                .append("       </Адрес>\n")
                .append("     </СвПокуп>\n")
                .append(commissionUtd)
                .append("     </СвСчФакт>\n")
                .append("     <ТаблСчФакт>\n");

        BigDecimal sumVat = BigDecimal.ZERO;
        BigDecimal sumTotal = BigDecimal.ZERO;
        BigDecimal sumWithoutVat = BigDecimal.ZERO;
        BigDecimal sumVatTotal = BigDecimal.ZERO;

        for (Product product : products) {
            //Clear price = Price with tax / (1 + Tax percentage)
            BigDecimal clearSum = product
                    .getSum()
                    .divide(
                            product
                                    .getVat()
                                    .divide(
                                            new BigDecimal(100), RoundingMode.HALF_UP
                                    )
                                    .add(BigDecimal.ONE),
                            RoundingMode.HALF_UP
                    );
            BigDecimal amountTax = product.getSum().min(clearSum);
            BigDecimal priceVat = product
                    .getPrice()
                    .multiply(product.getVat())
                    .divide(BigDecimal.valueOf(100 + product.getVat().intValue()), 2, RoundingMode.HALF_UP);

            sumVatTotal = sumVatTotal.add(priceVat);
            sumVat = sumVat.add(amountTax);
            sumTotal = sumTotal.add(product.getSum());
            sumWithoutVat = sumWithoutVat.add(clearSum);
            xml
                    .append("<СведТов КолТов=\"")
                    .append(String.format("%s.%s", product.getQuantityFact(), "000"))
                    .append("\" НаимТов=\"")
                    .append(product.getFullName())
                    .append("\" НалСт=\"")
                    .append(product.getVat().intValue())
                    .append("%\" НомСтр=\"")
                    .append(product.getLineNumber())
                    .append("\" ОКЕИ_Тов=\"796\" СтТовБезНДС=\"")
                    .append(product.getPrice().subtract(priceVat))
                    .append("\" СтТовУчНал=\"")
                    .append(product.getSum())
                    .append("\" ЦенаТов=\"")
                    .append(product.getPrice())
                    .append("\">")
                    .append("<Акциз><БезАкциз>без акциза</БезАкциз></Акциз>")
                    .append("<СумНал><СумНал>")
                    .append(priceVat)
                    .append("</СумНал></СумНал>")
                    .append("<ДопСведТов КодВидТов=\"")
                    .append(
                            tnveds.parallelStream()
                                    .filter(x -> x.getCode().equals(product.getIdd()))
                                    .findFirst()
                                    .map(Tnved::getDescr).get()
                    )
                    .append("\" КодТов=\"")
                    .append(product.getBarcode())
                    .append("\" НаимЕдИзм=\"шт\" ПрТовРаб=\"1\">")
                    .append("<НомСредИдентТов>");

            for (String dataMatrix : product
                    .getScannedMarks()
                    .parallelStream()
                    .filter(ScannedMark::getValidMark)
                    .map(ScannedMark::getDataMatrix)
                    .collect(Collectors.toList())
            ) {
                xml.append("<КИЗ>").append(dataMatrix).append("</КИЗ>");
            }

            xml.append("</НомСредИдентТов>")
                    .append("</ДопСведТов >")
                    .append("</СведТов > ");
        }

        xml
                .append("<ВсегоОпл СтТовБезНДСВсего=\"").append(sumWithoutVat).append("\" СтТовУчНалВсего=\"").append(sumTotal).append("\">")
                .append("<СумНалВсего>")
                .append("<СумНал>")
                .append(sumVatTotal)
                .append("</СумНал>")
                .append("</СумНалВсего>")
                .append("</ВсегоОпл>")
                .append("     </ТаблСчФакт>\n")
                .append("     <СвПродПер>\n")
                .append("      <СвПер СодОпер=\"Товары Переданы\">\n")
                .append(contract)
                .append("      </СвПер>\n")
                .append("   </СвПродПер>\n")
                .append("   <Подписант ОблПолн=\"3\" ОснПолн=\"Должностные обязанности\" Статус=\"1\">\n")
                .append("      <ЮЛ Должн=\"Вице-президент по казначейским операциям\" ИННЮЛ=\"").append(warehouseFirmTin).append("\" НаимОрг=\"").append("АО &quot;КОРПОРАЦИЯ &quot;ГЛОРИЯ ДЖИНС&quot;").append("\">\n")
                .append("        <ФИО Имя=\"Галина\" Отчество=\"Петровна\" Фамилия=\"Ткачева\" />\n")
                .append("      </ЮЛ>\n")
                .append("   </Подписант>\n")
                .append("  </Документ>\n")
                .append("</Файл>");
        return xml.toString();
    }
}
