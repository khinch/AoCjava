package aocjava.jcommander;

import com.beust.jcommander.IStringConverter;

import java.io.File;

public class StringToFileConverter implements IStringConverter<File> {
    @Override
    public File convert(String pathString) {
        return new File(pathString);
    }
}
