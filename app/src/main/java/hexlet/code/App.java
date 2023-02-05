package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.util.concurrent.Callable;

@Command(
        name = "gendiff",
        mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.",
        version = "gendiff 1.0",
        sortOptions = false
)
public class App implements Callable<Integer> {
    @Option(names = {"-f", "--format"},paramLabel = "format",
            description = "output format [default: stylish]")
    String format;
    @Parameters(paramLabel = "filepath1", description = "path to first file")
    File filepath1;
    @Parameters(paramLabel = "filepath2", description = "path to second file")
    File filepath2;
    @Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this @|fg(30) help|@ message and exit.")
    boolean versionHelpRequested;
    @Option(names = {"-V", "--version"}, versionHelp=true, description = "Print version information and exit.")
    boolean versionInfoRequested;
    @Override
    public Integer call() throws Exception {
        return null;
    }
    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
