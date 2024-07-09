package org.surikov.first_project.services.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.surikov.first_project.entities.accounts.DesignerAccount;
import org.surikov.first_project.entities.data.ProfilePicture;
import org.surikov.first_project.repository.accounts.DesignerRepository;
import org.surikov.first_project.repository.data.ProfilePictureRepository;
import org.surikov.first_project.services.accounts.DesignerService;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@Service
public class ProfilePictureService {

    private final DesignerRepository designerRepository;
    private ProfilePictureRepository pictureRepository;
    private DesignerService designerService;

    @Autowired
    public ProfilePictureService(ProfilePictureRepository pictureRepository, DesignerService designerService, DesignerRepository designerRepository) {
        this.pictureRepository = pictureRepository;
        this.designerService = designerService;
        this.designerRepository = designerRepository;
    }

    public ProfilePicture findById(Long id) {
        return pictureRepository.findById(id).get();
    }

    public void save(MultipartFile[] files, Long designerId) {

        BufferedImage bufferedImage = null;

        for(MultipartFile file : files) {
            Path root = FileSystems.getDefault().getPath("").toAbsolutePath();
            Path filepath = Paths.get(root.toString(), "src", "main", "resources","static", "images", "upload", "profile_image", String.valueOf(designerId), file.getOriginalFilename());

            try {

                File directory = new File(filepath.getParent().toUri());

                if (!directory.exists()) {
                    directory.mkdirs();
                }

                bufferedImage = ImageIO.read(file.getInputStream());
                File outputFile = new File(filepath.toUri());
                String type = file.getContentType().substring("image/".length());
                ImageIO.write(bufferedImage, Objects.requireNonNull(type), outputFile);
                ProfilePicture photo = new ProfilePicture();

                String filename = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
                String url = "/images/upload/profile_image/" + String.valueOf(designerId) + "/" + filename;

                if(pictureRepository.existsByDesignerAccount(designerService.findById(designerId))) {
                    pictureRepository.updateProfilePictureByDesignerAccountAndUrl(designerService.findById(designerId), url);
                } else {
                    photo.setUrl(url);
                    photo.setDesignerAccount(designerService.findById(designerId));
                    pictureRepository.save(photo);
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
