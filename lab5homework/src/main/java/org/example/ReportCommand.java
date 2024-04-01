package org.example;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * Concrete command class for creating and opening an HTML report.
 */
class ReportCommand implements Command {
    private final Repository repository;

    /**
     * Constructs a ReportCommand object with the given repository.
     *
     * @param repository The repository to generate the report from.
     */
    public ReportCommand(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(String[] args) throws IOException, InvalidCommandException {
        if (args.length != 0) {
            throw new InvalidCommandException("Report command does not take any arguments");
        }

        generateHtmlReport();

        System.out.println("Report command executed. HTML report generated.");
    }

    /**
     * Generates an HTML report based on the repository data.
     *
     * @throws IOException If an I/O error occurs while generating the report.
     */
    private void generateHtmlReport() throws IOException {

        // Configure FreeMarker
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
        cfg.setClassForTemplateLoading(ReportCommand.class, "/templates");
        cfg.setDefaultEncoding("UTF-8");

        // Load template
        Template template = cfg.getTemplate("report_template.ftl");

        // Prepare data model
        Map<String, Object> data = new HashMap<>();
        data.put("repository", repository.getDocuments().entrySet());

        // Render template to HTML file
        try (Writer out = new FileWriter("report.html")) {
            template.process(data, out);
        } catch (TemplateException e) {
            e.printStackTrace();
            throw new IOException("Error generating HTML report", e);
        }
    }
}
