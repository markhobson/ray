/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
	// ----------------------------------------------------------------------------------------------------------------
	// constants
	// ----------------------------------------------------------------------------------------------------------------
	
	private static final int NANO = 1000 * 1000 * 1000;
	
	private static final long serialVersionUID = 1L;
	
	// ----------------------------------------------------------------------------------------------------------------
	// fields
	// ----------------------------------------------------------------------------------------------------------------
	
	private final Scene scene;
	
	private final Tracer tracer;
	
	private Dimension size;
	
	private int[] pixels;
	
	private MemoryImageSource imageSource;
	
	private Image image;
	
	private long time;
	
	private long frames;
	
	private boolean statisticsVisible;
	
	// ----------------------------------------------------------------------------------------------------------------
	// constructors
	// ----------------------------------------------------------------------------------------------------------------
	
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
	
	// ----------------------------------------------------------------------------------------------------------------
	// public methods
	// ----------------------------------------------------------------------------------------------------------------
	
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
	
	// ----------------------------------------------------------------------------------------------------------------
	// JComponent methods
	// ----------------------------------------------------------------------------------------------------------------
	
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
			String text = String.format("%d x %d @ %.1f fps", size.width, size.height, (double) NANO * frames / time);

			graphics.setColor(Color.WHITE);
			graphics.drawString(text, 0, 12);
		}
	}
	
	// ----------------------------------------------------------------------------------------------------------------
	// Container methods
	// ----------------------------------------------------------------------------------------------------------------
	
	@Override
	public void invalidate()
	{
		super.invalidate();
		
		image = null;
	}
	
	// ----------------------------------------------------------------------------------------------------------------
	// private methods
	// ----------------------------------------------------------------------------------------------------------------
	
	private void createImage()
	{
		if (size == null)
		{
			size = new Dimension(getSize());
			pixels = new int[size.width * size.height];
			imageSource = new MemoryImageSource(size.width, size.height, pixels, 0, size.width);
		}

		long start = System.nanoTime();
		tracer.trace(pixels, size.width, size.height);
		time += System.nanoTime() - start;
		frames++;
		
		image = createImage(imageSource);
	}
}
