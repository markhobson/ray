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

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Tests {@code Vector}.
 */
public class VectorTest
{
	// ----------------------------------------------------------------------------------------------------------------
	// tests
	// ----------------------------------------------------------------------------------------------------------------

	@Test
	public void defaultConstructorSetsZeroComponents()
	{
		Vector actual = new Vector();
		
		assertVector(0d, 0d, 0d, actual);
	}

	@Test
	public void constructorWithComponentSetsComponents()
	{
		Vector actual = new Vector(1);
		
		assertVector(1d, 1d, 1d, actual);
	}
	
	@Test
	public void constructorWithComponentsSetsComponents()
	{
		Vector actual = new Vector(1, 2, 3);
		
		assertVector(1d, 2d, 3d, actual);
	}
	
	// ----------------------------------------------------------------------------------------------------------------
	// private methods
	// ----------------------------------------------------------------------------------------------------------------

	private static void assertVector(double expectedX, double expectedY, double expectedZ, Vector actual)
	{
		assertThat("x", actual.getX(), is(expectedX));
		assertThat("y", actual.getY(), is(expectedY));
		assertThat("z", actual.getZ(), is(expectedZ));
	}
}
