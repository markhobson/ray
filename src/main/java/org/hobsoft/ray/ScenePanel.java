/*
 * $HeadURL$
 *
 * (c) 2005 Mark Hobson.  All rights reserved.
 */
package org.hobsoft.ray;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.MemoryImageSource;

import javax.swing.JComponent;

/**
 * 
 */
public class ScenePanel extends JComponent
{
	// constants --------------------------------------------------------------
	
	private static final int NANO = 1000 * 1000 * 1000;
	
	private static final long serialVersionUID = 1L;
	
	// fields -----------------------------------------------------------------
	
	private final Scene scene;
	
	private final Tracer tracer;
	
	private Dimension size;
	
	private int[] pixels;
	
	private MemoryImageSource imageSource;
	
	private Image image;
	
	private long time;
	
	private boolean statisticsVisible;
	
	// constructors -----------------------------------------------------------
	
	public ScenePanel(Scene scene)
	{
		this.scene = scene;
		
		tracer = new Tracer(scene);
		
		addComponentListener(new ComponentAdapter()
		{
			@Override
			public void componentResized(ComponentEvent event)
			{
				size = null;
				invalidate();
			}
		});
	}
	
	// public methods ---------------------------------------------------------
	
	public Scene getScene()
	{
		return scene;
	}
	
	public boolean isStatisticsVisible()
	{
		return statisticsVisible;
	}
	
	public void setStatisticsVisible(boolean statisticsVisible)
	{
		this.statisticsVisible = statisticsVisible;
		
		repaint();
	}
	
	// JComponent methods -----------------------------------------------------
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void paintComponent(Graphics graphics)
	{
		if (image == null)
		{
			createImage();
		}

		graphics.drawImage(image, 0, 0, this);

		if (statisticsVisible)
		{
			String text = String.format("%d x %d @ %.1f fps", size.width, size.height, (double) NANO / time);

			graphics.setColor(Color.WHITE);
			graphics.drawString(text, 0, 12);
		}
	}
	
	// Container methods ------------------------------------------------------
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void invalidate()
	{
		super.invalidate();
		
		image = null;
	}
	
	// private methods --------------------------------------------------------
	
	private void createImage()
	{
		if (size == null)
		{
			size = new Dimension(getSize());
			pixels = new int[size.width * size.height];
			imageSource = new MemoryImageSource(size.width, size.height, pixels, 0, size.width);
		}

		time = System.nanoTime();
		tracer.trace(pixels, size.width, size.height);
		time = System.nanoTime() - time;
		
		image = createImage(imageSource);
	}
}
