import java.awt.Color;

/**
 * An image filter to mirror (flip) the image horizontally.
 * 
 * @author Michael Kölling and David J. Barnes.
 * @version 1.0
 */
public class FlipFilter extends Filter
{
	/**
	 * Constructor for objects of class FlipFilter.
     * @param name The name of the filter.
	 */
	public FlipFilter(String name)
    {
        super(name);
	}

    /**
     * Apply this filter to an image.
     * 
     * @param  image  The image to be changed by this filter.
     */
    public void apply(OFImage image)
    {
        int width = image.getWidth();
        int height = image.getHeight();
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height / 2; y++) {
                Color left = image.getPixel(x, y);
                image.setPixel(x, y, image.getPixel(height - 1 - x, y));
                image.setPixel(height - 1 - x, y, left);
            }
        }
    }
}