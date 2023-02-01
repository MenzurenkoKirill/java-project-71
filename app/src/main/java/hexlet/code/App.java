package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

@Command(
        name = "gendiff",
        mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.",
        version = "gendiff 1.0"
)
public class App implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return null;
    }

    @Option(names = {"V", "--version"}, description = "Print version information and exit.")
    private String version;
    @Option(names = {"-h", "--help"}, description = "Show this help message and exit.", help = true)
    private String help;
    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
