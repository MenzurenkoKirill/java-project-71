package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

import static hexlet.code.Parser.generate;

@Command(
        name = "gendiff",
        mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.",
        version = "gendiff 1.0"
        //sortOptions = false
)
public class App implements Callable<String> {
    @Option(names = {"-f", "--format"},paramLabel = "format",
            description = "output format [default: stylish]")
    String format;
    @Parameters(paramLabel = "filepath1", description = "path to first file")
    String filepath1;
    @Parameters(paramLabel = "filepath2", description = "path to second file")
    String filepath2;
    @Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this @|fg(30) help|@ message and exit.")
    boolean versionHelpRequested;
    @Option(names = {"-V", "--version"}, versionHelp=true, description = "Print version information and exit.")
    boolean versionInfoRequested;
    @Override
    public String call() throws Exception {
        System.out.println(generate(filepath1, filepath2));
        return "method call() is working";
    }
    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
