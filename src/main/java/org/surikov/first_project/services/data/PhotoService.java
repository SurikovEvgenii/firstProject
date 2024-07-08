package org.surikov.first_project.services.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.surikov.first_project.entities.data.Photo;
import org.surikov.first_project.entities.projects.Project;
import org.surikov.first_project.repository.data.PhotoRepository;
import org.surikov.first_project.repository.projects.ProjectRepository;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Service
public class PhotoService {

    private PhotoRepository photoRepository;

    @Autowired
    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public void save(MultipartFile[] files, Project project) throws IOException {

        List<Photo> photoList = new ArrayList<>();
        BufferedImage bufferedImage = null;


        for(MultipartFile file: files){
            Path root = FileSystems.getDefault().getPath("").toAbsolutePath();
            Path filepath = Paths.get(root.toString(), "src", "main", "resources","static", "images", "upload", project.getDesigner().getId().toString(), project.getId().toString(), file.getOriginalFilename());

            File directory = new File(filepath.getParent().toUri());

            if (!directory.exists()) {
                directory.mkdirs();
            }

            bufferedImage = ImageIO.read(file.getInputStream());
            File outputFile = new File(filepath.toUri());

            String type = file.getContentType().substring("image/".length());

            ImageIO.write(bufferedImage, Objects.requireNonNull(type), outputFile);


            Photo photo = new Photo();
            String filename = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
            photo.setName(filename);
            photo.setUrl("/images/upload/" + project.getDesigner().getId() + "/" + project.getId() + "/" + file.getOriginalFilename());
            photo.setProject(project);
            photoList.add(photo);
        }
        photoRepository.saveAll(photoList);

    }

    public Photo getPhoto(Long id) {
        return photoRepository.findById(id).get();
    }

    public List<Photo> getProjectPhotos(Long projectId) {
        List<Photo> photos = photoRepository.findAll().stream().toList();
        return photos.stream().filter(photo -> photo.getProject().getId().equals(projectId)).toList();
    }

    public Stream<Photo> getPhotos() {
        return photoRepository.findAll().stream();
    }


}
