package com.training.docghifile.code;


import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {
        String fileInput = "src/com/training/docghifile/resource/m4s_user_profile_public_representative.sql";
        String fileOutput = "src/com/training/docghifile/resource/out.txt";

        List<String> stringList = Reader.read(fileInput);
        Writer.write(stringList,fileOutput);
    }
}
