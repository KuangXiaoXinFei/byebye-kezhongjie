package com.cloudyoung.baic.common.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * Description:
 *
 * @author 李美根（limg@cloud-young.com）创建
 * @date 1.0  2018/7/10 15:05
 */
public class ImageUtil {

    private static final LogUtils logger = LogUtils.build(ImageUtil.class);

    /**
     * 图片剪切工具类
     *
     * @param input     图片输入流
     * @param x         截取时的x坐标
     * @param y         截取时的y坐标
     * @param desWidth  截取的宽度
     * @param desHeight 截取的高度
     * @return
     */
    public static InputStream cutImge(InputStream input, int x, int y, int desWidth, int desHeight) {
        InputStream newImageInputStream = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            //图片类
            Image imge;
            ImageFilter cropFilter;
            //读取图片
            BufferedImage bi = ImageIO.read(input);
            int srcWidth = bi.getWidth();
            int srcHeight = bi.getHeight();
            if (desWidth > srcWidth) {
                desWidth = srcWidth;
            }
            if (desHeight > srcHeight) {
                desHeight = srcHeight;
            }
            //当剪裁大小小于原始图片大小才执行
            if (srcWidth >= desWidth && srcHeight >= desHeight) {
                //获取原始图
                Image image = bi.getScaledInstance(srcWidth, srcHeight, Image.SCALE_DEFAULT);
                //获取新图
                cropFilter = new CropImageFilter(x, y, desWidth, desHeight);
                imge = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(image.getSource(), cropFilter));
                BufferedImage tag = new BufferedImage(desWidth, desHeight, BufferedImage.TYPE_INT_RGB);
                Graphics g = tag.getGraphics();
                g.drawImage(imge, 0, 0, null);
                g.dispose();
                // 输出文件
                ImageIO.write(tag, "png", bos);
                newImageInputStream = new ByteArrayInputStream(bos.toByteArray());
            } else {
                newImageInputStream = input;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("cutImge","剪切失败",e);
        }
        return newImageInputStream;

    }


}
