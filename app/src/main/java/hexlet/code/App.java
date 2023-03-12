package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

import static hexlet.code.Differ.generate;

@Command(
        name = "gendiff",
        mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.",
        version = "gendiff 1.0"
)
public class App implements Callable<Integer> {
    private static final int SUCCESS = 0;
    private static final int ERROR = 2;
    @Option(names = {"-f", "--format"}, paramLabel = "format",
            description = "output format [default: stylish]")
    private String format = "stylish";
    @Parameters(index = "0", paramLabel = "filepath1", description = "path to first file")
    private String filepath1;
    @Parameters(index = "1", paramLabel = "filepath2", description = "path to second file")
    private String filepath2;
    @Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this @|fg(30) help|@ message and exit.")
    boolean versionHelpRequested;
    @Option(names = {"-V", "--version"}, versionHelp = true, description = "Print version information and exit.")
    boolean versionInfoRequested;
    @Override
    public Integer call() throws Exception {
        try {
            System.out.println(generate(filepath1, filepath2, format));
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }
    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
