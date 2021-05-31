package lab12.fileoperations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lab12.filesettings.FileOperation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.security.NoSuchAlgorithmException;
import java.io.*;

/**
 * Service for managing file's content (encoding)
 */
@Service
public class FileService extends FileWorker {
    @Autowired
    private FileOperation fileOperation;
    private File file;
    private final Logger logger = LoggerFactory.getLogger(FileService.class);

    @PostConstruct
    private void init() {
        logger.info("Initializing...");
        InputStream inputStream = null;
        String inputFilename = fileOperation.getInputName();
        String outputFilename = fileOperation.getOutputName();

        try {
            file = new File(inputFilename);
            if (!file.exists()) {
                writeToFile(outputFilename, "null");
                return;
            }
            inputStream = new FileInputStream(file);
            String data = readFromInputStream(inputStream);

            writeToFile(outputFilename, hashedData(data));
            destroy();
        } catch (IOException | NoSuchAlgorithmException e) {
            destroy();
            logger.error(e.getMessage());

        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                    destroy();
                } catch (IOException e) {
                    logger.error(e.getMessage());
                    destroy();
                }
            }
        }
    }

    @PreDestroy
    private void destroy() {
        logger.info("Destroying...");
        if (file.exists()) {
            logger.info("File {} deleted: {}", file.getName(), file.delete());
        } else {
            logger.info("File {} does not exist", file.getName());
        }

    }
}
