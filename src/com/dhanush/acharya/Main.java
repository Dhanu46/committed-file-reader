package com.dhanush.acharya;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        final String fileName = "src/resources/Committed_files.txt";
        final Path path = Paths.get(fileName);
        System.out.println(path);
        final Set<String> strings = new Main().readFileInList(fileName);
        strings.forEach(System.out::println);

    }
    public  Set<String> readFileInList(String fileName)
    {

        List<String> lines;
        Set<String> collect = Collections.emptySet();
        try
        {
            lines =
                    Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
            collect = lines.parallelStream().map(String::trim).filter(x -> x.length() > 0).collect(Collectors.toSet());
        }

        catch (IOException e)
        {// do something
            e.printStackTrace();
        }
        return collect;
    }
}
