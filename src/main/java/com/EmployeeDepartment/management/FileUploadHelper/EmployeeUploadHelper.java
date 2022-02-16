package com.EmployeeDepartment.management.FileUploadHelper;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
@Component
public class EmployeeUploadHelper {
    private String filePath="/Users/jatajaylalaram/Downloads/management/src/main/resources/static/";
    public boolean StoreFiles(MultipartFile multipartFile) throws IOException {
        boolean f=false;
        Files.copy(multipartFile.getInputStream(), Paths.get(filePath+ File.pathSeparator+multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
        f=true;
        return f;
    }
}
