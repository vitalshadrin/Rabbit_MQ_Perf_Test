package report;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportTemplate {
    private final static String REPORT_TEMPLATE = "src/main/java/report/template";

    public static String getResultDirectory(String nameResults) {
        Path path = Paths.get("results");
        try {
            Path resultsDir = !Files.exists(path) ? Files.createDirectory(path) : path;
            Path resultDir;
            Path file;
            if (nameResults.contains(".js")) {
                resultDir = Paths.get(resultsDir + "/perfTestMulti_result_" + getCurrentDate());
                FileUtils.copyDirectory(new File(REPORT_TEMPLATE), new File(resultDir.toString()));
                file = Paths.get(resultDir + "/html/" + nameResults);
            } else {
                resultDir = Files.createDirectory(Paths.get(resultsDir + "/perfTest_result_" + getCurrentDate()));
                file = Paths.get(resultDir + "/" + nameResults);
            }
            return Files.createFile(file).toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String getCurrentDate() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
        return formatter.format(date);
    }
}
