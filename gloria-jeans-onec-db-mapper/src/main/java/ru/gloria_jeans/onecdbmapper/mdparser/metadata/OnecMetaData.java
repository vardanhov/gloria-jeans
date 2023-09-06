package ru.gloria_jeans.onecdbmapper.mdparser.metadata;

import ru.gloria_jeans.onecdbmapper.mdparser.utils.OnecConverter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

public class OnecMetaData {
    private final String CLOSE = "}";
    private final String OPEN = "{";
    public int[] MainDataContDef;
    public TaskItem TaskProp;
    public Map<String,JrnlFldDefNode> JournCommonRefs;
    public Map<String,DocSelRefObjNode> DocSelRefObj;
    public Map<String,DocNumNode> DocNums;
    public Map<String,ConstantNode> Constants;
    public Map<String,SbNode> Sbs;
    public Map<String,RegisterNode> Registers;
    public Map<String,DocumentNode> Documents;
    public Map<String,JournalNode> Journals;
    public Map<String,EnumNode> Enums;
    public Map<String,DocStreamNode> DocStreams;

    public void read(String input) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(Normalize(input)));
        Node root = new Node();
        ReadSub(reader, root);

        for (Node item : root.Childs) {
            String[] ww = OnecConverter.toStringArray(item.Text);

            switch (OnecConverter.trim(ww[0])) {
                case "MainDataContDef":
                    MainDataContDef = new int[] { Integer.parseInt(ww[1]), Integer.parseInt(ww[2]), Integer.parseInt(ww[3]) };
                    break;
                case "TaskItem":
                    this.TaskProp = new TaskItem(item.Childs.get(0).Text);
                    break;
                case "GenJrnlFldDef":
                    ProcessJrnlFldList(item);
                    break;
                case "DocSelRefObj":
                    ProcessDocSelRefObj(item);
                    break;
                case "DocNumDef":
                    ProcessDocNumDef(item);
                    break;
                case "Consts":
                    ProcessConsts(item);
                    break;
                case "SbCnts":
                    ProcessSbCnts(item);
                    break;
                case "Registers":
                    ProcessRegisterList(item);
                    break;
                case "Documents":
                    ProcessDocuments(item);
                    break;
                case "Journalisters":
                    ProcessJournals(item);
                    break;
                case "EnumList":
                    ProcessEnums(item);
                    break;
                case "Document Streams":
                    ProcessDocStreams(item);
                    break;
                default:
                    break;
            }
        }


        reader.close();
    }

    void ProcessJrnlFldList(Node item) {
        JournCommonRefs = new HashMap<>();
        JrnlFldDefNode d = new JrnlFldDefNode(String.format("\"ROW_ID\",\"Row ID\",\"\",\"\",\"%s\",\"%s\",\"0\",\"0\"", "I", "0"));
        JournCommonRefs.put(d.getIdentity(), d);
        d = new JrnlFldDefNode(String.format("\"IDJOURNAL\",\"IDJOURNAL\",\"\",\"\",\"%s\",\"%s\",\"0\",\"0\"", "I", "0"));
        JournCommonRefs.put(d.getIdentity(), d);
        d = new JrnlFldDefNode(String.format("\"IDDOCDEF\",\"IDDOCDEF\",\"\",\"\",\"%s\",\"%s\",\"0\",\"0\"", "I", "0"));
        JournCommonRefs.put(d.getIdentity(), d);
        d = new JrnlFldDefNode(String.format("\"IDDOC\",\"IDDOC\",\"\",\"\",\"%s\",\"%s\",\"0\",\"0\"", "S", "9"));
        JournCommonRefs.put(d.getIdentity(), d);
        d = new JrnlFldDefNode(String.format("\"APPCODE\",\"APPCODE\",\"\",\"\",\"%s\",\"%s\",\"0\",\"0\"", "I", "0"));
        JournCommonRefs.put(d.getIdentity(), d);
        d = new JrnlFldDefNode(String.format("\"DATE_TIME_IDDOC\",\"DATE_TIME_IDDOC\",\"\",\"\",\"%s\",\"%s\",\"0\",\"0\"", "S", "23"));
        JournCommonRefs.put(d.getIdentity(), d);
        d = new JrnlFldDefNode(String.format("\"DNPREFIX\",\"DNPREFIX\",\"\",\"\",\"%s\",\"%s\",\"0\",\"0\"", "I", "0"));
        JournCommonRefs.put(d.getIdentity(), d);
        d = new JrnlFldDefNode(String.format("\"DOCNO\",\"DOCNO\",\"\",\"\",\"%s\",\"%s\",\"0\",\"0\"", "S", "15"));
        JournCommonRefs.put(d.getIdentity(), d);
        d = new JrnlFldDefNode(String.format("\"ISMARK\",\"ISMARK\",\"\",\"\",\"%s\",\"%s\",\"0\",\"0\"", "B", "1"));
        JournCommonRefs.put(d.getIdentity(), d);
        d = new JrnlFldDefNode(String.format("\"CLOSED\",\"CLOSED\",\"\",\"\",\"%s\",\"%s\",\"0\",\"0\"", "B", "1"));
        JournCommonRefs.put(d.getIdentity(), d);
        d = new JrnlFldDefNode(String.format("\"ACTCNT\",\"ACTCNT\",\"\",\"\",\"%s\",\"%s\",\"0\",\"0\"", "B", "1"));
        JournCommonRefs.put(d.getIdentity(), d);
        d = new JrnlFldDefNode(String.format("\"VERSTAMP\",\"VERSTAMP\",\"\",\"\",\"%s\",\"%s\",\"0\",\"0\"", "B", "1"));
        JournCommonRefs.put(d.getIdentity(), d);

        for (Node node : item.Childs) {
            d = new JrnlFldDefNode(node.Text, "sp");
            JournCommonRefs.put(d.getIdentity(), d);
        }
    }

    //Графы отбора
    void ProcessDocSelRefObj(Node item) {
        DocSelRefObj = new HashMap<>();

        for (Node node : item.Childs) {
            DocSelRefObjNode d = new DocSelRefObjNode(node);
            DocSelRefObj.put(d.getIdentity(), d);
        }
    }

    //Номера документов
    void ProcessDocNumDef(Node item) {
        DocNums = new HashMap<>();

        for (Node node : item.Childs) {
            DocNumNode d = new DocNumNode(node.Text);
            DocNums.put(d.getIdentity(), d);
        }
    }

    //Константы
    void ProcessConsts(Node item) {
        Constants = new HashMap<>();

        for (Node node : item.Childs) {
            ConstantNode d = new ConstantNode(node.Text);
            Constants.put(d.getIdentity(), d);
        }
    }

    //Справочники
    void ProcessSbCnts(Node item) {
        Sbs = new HashMap<>();

        for (Node node : item.Childs) {
            SbNode d = new SbNode(node);
            Sbs.put(d.getIdentity(), d);
        }
    }

    //Регистры
    void ProcessRegisterList(Node item) throws Exception {
        Registers = new HashMap<>();

        for (Node node: item.Childs) {
            RegisterNode r = new RegisterNode(node);
            Registers.put(r.getIdentity(), r);
            r.All.add(new SbNodeField(String.format("\"LINENO_\",\"LINENO_\",\"\",\"\",\"%s\",\"%s\",\"0\",\"0\"", "I", "0")));
            r.All.add(new SbNodeField(String.format("\"ACTNO\",\"ACTNO\",\"\",\"\",\"%s\",\"%s\",\"0\",\"0\"", "I", "0")));
            r.All.add(new SbNodeField(String.format("\"IDDOCDEF\",\"IDDOCDEF\",\"\",\"\",\"%s\",\"%s\",\"0\",\"0\"", "I", "0")));
            r.All.add(new SbNodeField(String.format("\"IDDOC\",\"IDDOC\",\"\",\"\",\"%s\",\"%s\",\"0\",\"0\"", "S", "9")));
            r.All.add(new SbNodeField(String.format("\"DEBKRED\",\"DEBKRED\",\"\",\"\",\"%s\",\"%s\",\"0\",\"0\"", "L", "0")));
            r.All.add(new SbNodeField(String.format("\"DATE_TIME_IDDOC\",\"DATE_TIME_IDDOC\",\"\",\"\",\"%s\",\"%s\",\"0\",\"0\"", "S", "23")));
            r.All.add(new SbNodeField(String.format("\"PERIOD\",\"PERIOD\",\"\",\"\",\"%s\",\"%s\",\"0\",\"0\"", "D", "0")));
            JrnlFldDefNode d = new JrnlFldDefNode(String.format("\"RF%s\",\"%s\",\"\",\"\",\"L\",\"0\",\"0\",\"0\"", r.getID(), r.getIdentity()));
            JournCommonRefs.put(d.getIdentity(), d);
        }
    }

    //Документы
    void ProcessDocuments(Node item) throws Exception {
        Documents = new HashMap<>();

        for (Node node : item.Childs) {
            DocumentNode d = new DocumentNode(node);
            Documents.put(d.getIdentity(), d);
        }
    }

    //Журналы
    void ProcessJournals(Node item) {
        Journals = new HashMap<>();

        for (Node node : item.Childs) {
            JournalNode d = new JournalNode(node);
            Journals.put(d.getIdentity(), d);
        }
    }

    //ПЕречисления
    void ProcessEnums(Node item)
    {
        Enums = new HashMap<>();
        for (Node node : item.Childs)
        {
            EnumNode d = new EnumNode(node);
            Enums.put(d.getIdentity(), d);
        }
    }

    //Последовательности
    void ProcessDocStreams(Node item) {
        DocStreams = new HashMap<>();

        for (Node node : item.Childs) {
            DocStreamNode d = new DocStreamNode(node, Documents, Registers);
            DocStreams.put("Последовательность." + d.getIdentity(), d);
            JrnlFldDefNode df = new JrnlFldDefNode(String.format("\"DS%s\",\"%s\",\"\",\"\",\"L\",\"0\",\"0\",\"0\"", d.getID(), d.getIdentity()));
            JournCommonRefs.put("Последовательность." + df.getIdentity(), df);
        }
    }

    void ReadSub(BufferedReader reader, Node b) throws IOException {
        int rr = 0;
        StringBuilder stringBuilder = new StringBuilder();

        while (rr > -1) {
            rr = reader.read();

            if (OPEN.equals(String.valueOf((char) rr))) {
                Node s = new Node();
                b.Childs.add(s);
                ReadSub(reader, s);
                continue;
            }

            if (CLOSE.equals(String.valueOf((char) rr))) {
                break;
            }

            stringBuilder.append((char) rr);
        }

        b.Text = stringBuilder.toString();
    }

    String Normalize(String content) {
        content = content.replace("\r" + "\n", "");
        content = content.substring(1, content.length() - 2);
        return content;
    }
}
