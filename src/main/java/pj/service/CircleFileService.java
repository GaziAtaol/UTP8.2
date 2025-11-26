package pj.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.StandardOpenOption;

@Service
public class CircleFileService {

    private String filePath = "circles.bin";

    public int[] loadCircles() throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            return new int[0];
        }

        try (FileChannel channel = FileChannel.open(file.toPath(), StandardOpenOption.READ)) {
            long fileSize = channel.size();
            if (fileSize == 0) {
                return new int[0];
            }

            ByteBuffer buffer = ByteBuffer.allocate((int) fileSize);
            channel.read(buffer);
            buffer.flip();

            int numberOfCircles = buffer.getInt();
            int[] circles = new int[numberOfCircles];
            for (int i = 0; i < numberOfCircles; i++) {
                circles[i] = buffer.getInt();
            }

            return circles;
        }
    }

    public boolean fileExists() {
        File file = new File(filePath);
        return file.exists();
    }

    public int getCirclesCount() throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            return 0;
        }

        try (FileChannel channel = FileChannel.open(file.toPath(), StandardOpenOption.READ)) {
            if (channel.size() < Integer.BYTES) {
                return 0;
            }

            ByteBuffer buffer = ByteBuffer.allocate(Integer.BYTES);
            channel.read(buffer);
            buffer.flip();

            return buffer.getInt();
        }
    }
}
