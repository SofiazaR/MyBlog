package ru.itis.services;

import ru.itis.models.FileInfo;
import ru.itis.repositories.FileRepository;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

public class FileServiceImpl implements FileService {

    private FileRepository fileRepository;

    public FileServiceImpl(FileRepository filesRepository) {
        this.fileRepository = filesRepository;
    }

    @Override
    public Long saveFileToStorage(InputStream file, String originalFileName, String contentType, Long size) {
        FileInfo fileInfo = FileInfo.builder()
                .originalFileName(originalFileName)
                .storageFileName(UUID.randomUUID())
                .size(size)
                .type(contentType)
                .build();

        try {
            Files.copy(file, Paths.get("/home/sofiana/Desktop/MyBlog/src/main/webapp/WebContent/Images/" + fileInfo.getStorageFileName() + "." + fileInfo.getType().split("/")[1]));
            fileRepository.save(fileInfo);
            return fileInfo.getId();

        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }

    }

    @Override
    public void writeFileFromStorage(Long fileId, OutputStream outputStream) {
        Optional<FileInfo> fileInfo = fileRepository.findById(fileId);
        // нашли файл на диске
        try {
            File file = new File("/home/sofiana/Desktop/MyBlog/src/main/webapp/WebContent/Images/" + fileInfo.get().getStorageFileName() + "." + fileInfo.get().getType().split("/")[1]);
            // записали его в ответ
            Files.copy(file.toPath(), outputStream);
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }

    }

    @Override
    public Optional<FileInfo> getFileInfo(Long fileId) {
        return fileRepository.findById(fileId);
    }
}