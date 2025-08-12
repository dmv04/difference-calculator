package io.github.dmv04;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

@Command(name = "genDiff", mixinStandardHelpOptions = true, description
        = "Compares two configuration files and shows a difference.")

public class App implements Callable<Integer> {
    @Option(names = {"-f", "--format"}, defaultValue = "stylish",
            paramLabel = "format", description = "output format [default: stylish]")
    private String format;
    @Parameters(index = "0", paramLabel = "filepath1", description = "path to first file")
    private String filepath1;
    @Parameters(index = "1", paramLabel = "filepath2", description = "path to second file")
    private String filepath2;
    /**
     * @return returns a string of differences between 2 files
     * @throws Exception  if files not exist
     */
    @Override
    public Integer call() throws Exception {
        String formattedDifference =  Differ.generate(filepath1, filepath2, format);
        System.out.println(formattedDifference);
        return 0;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
