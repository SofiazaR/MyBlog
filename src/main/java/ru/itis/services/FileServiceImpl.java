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
    public Long saveFileToStorage(InputStream file, String originalName, String contentType, Long size) {
        FileInfo fileInfo = FileInfo.builder()
                .originalName(originalName)
                .storageName(UUID.randomUUID())
                .size(size)
                .type(contentType)
                .build();

        try {
            Files.copy(file, Paths.get("/home/sofiana/Desktop/MyBlog/Images/" + fileInfo.getStorageName() + "." + fileInfo.getType().split("/")[1]));
            fileRepository.save(fileInfo);
            return fileInfo.getId();

        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }

    }

    @Override
    public void writeFileFromStorage(Long fileId, OutputStream outputStream) {
        Optional<FileInfo> fileInfo = fileRepository.findById(fileId);
        try {
            File file = new File("/home/sofiana/Desktop/MyBlog/Images/" + fileInfo.get().getStorageName() + "." + fileInfo.get().getType().split("/")[1]);
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