package com.company;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Homework {

    /**
     * Класс документ - описывает структуру документа.
     * <p>
     * Нужно спроектировать систему отчетов, которая будет формировать отчеты для документа.
     * <p>
     * 1. Формирование PDF-файла (потенциально может быть несколько типом разметки PDF-файла).
     * 2. Формирование JSON-файла с полями документа.
     * 3. Формирование XML-файла с полями документа.
     * 4. ... потенциально могут добавляться разные типы отчетов.
     * <p>
     * После реализации задать себе 2 вопроса и прикрепить их к сданной ДЗ:
     * 1. Насколько сложно добавить поддержку нового типа отчета?
     * 2. Как будет выглядеть проект, если в нем будет 1000+ типов отчетов?
     */

    interface ReportGenerator {
        byte[] generateReport(Document document);
    }

    static class ReportService {
        private Map<String, ReportGenerator> reportGenerators = new HashMap<>();

        public ReportService() {
            reportGenerators.put("pdf-1", new PdfReportGenerator());
            reportGenerators.put("json", new JsonReportGenerator());
            reportGenerators.put("xml", new XmlReportGenerator());
        }

        public byte[] createReport(Document document, String reportType) {
            // reportType = {"pdf-1", "json", "xml", ...}
            ReportGenerator reportGenerator = reportGenerators.get(getNormalizeExtension(reportType));
            if (reportGenerator == null) {
                throw new UnsupportedOperationException("Неподдерживаемй тип отчёта: " + reportType);
            }
            return reportGenerator.generateReport(document);
        }

        private String getNormalizeExtension(String s) {
            return s.trim().toLowerCase();
        }

    }

    static class PdfReportGenerator implements ReportGenerator {
        @Override
        public byte[] generateReport(Document document) {
            // Реализация генерации PDF-отчета
            System.out.println("Генерация PDF отчёта...");
            return new byte[0];
        }
    }

    static class JsonReportGenerator implements ReportGenerator {
        @Override
        public byte[] generateReport(Document document) {
            // Реализация генерации JSON-отчета
            System.out.println("Генерация JSON отчёта...");
            return new byte[0];
        }
    }

    static class XmlReportGenerator implements ReportGenerator {
        @Override
        public byte[] generateReport(Document document) {
            // Реализация генерации XML-отчета
            System.out.println("Генерация XML отчёта...");
            return new byte[0];
        }
    }

    static class Document {
        private long id;
        private String number;
        // ...
    }

    public static void main(String arg[]){

    }

}

/**
 * 1. Добавление отчёта не становится сложным.
 * Необхлдимо создать класс, реализующий ReportGenerator
 * и добавить его экземпляр в конструкторе ReportService
 * 2. Проект будет выглядеть осень большим, так как
 * для каждого типа отчётов нужно создавать класс, реализующий ReportGenerator
 * и добавлять его экземпляр в конструкторе ReportService
 */