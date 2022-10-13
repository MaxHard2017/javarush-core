package level6.task1631;

import level6.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes imageType) throws IllegalArgumentException {
        if ( (imageType == null) ) {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        } else {
            switch (imageType) {
                case BMP : 
                    return new BmpReader();
                case JPG : 
                    return new JpgReader();
                case PNG :
                    return new PngReader();
                default :
                    throw new IllegalArgumentException("Неизвестный тип картинки");
            }
        }
    }
}