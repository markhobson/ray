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
import static org.hamcrest.CoreMatchers.sameInstance;
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
	
	@Test
	public void setWithVectorSetsComponents()
	{
		Vector vector = new Vector();

		vector.set(new Vector(1, 2, 3));

		assertThat(vector, is(new Vector(1, 2, 3)));
	}
	
	@Test
	public void setWithVectorReturnsSelf()
	{
		Vector vector = new Vector();
		
		Vector actual = vector.set(new Vector());
		
		assertThat(actual, sameInstance(vector));
	}
	
	@Test
	public void setWithComponentsSetsComponents()
	{
		Vector vector = new Vector();
		
		vector.set(1, 2, 3);
		
		assertThat(vector, is(new Vector(1, 2, 3)));
	}

	@Test
	public void setWithComponentsReturnsSelf()
	{
		Vector vector = new Vector();
		
		Vector actual = vector.set(0, 0, 0);
		
		assertThat(actual, sameInstance(vector));
	}
	
	@Test
	public void hashCodeWhenEqualReturnsEqual()
	{
		Vector vector1 = new Vector(1, 2, 3);
		Vector vector2 = new Vector(1, 2, 3);

		assertThat(vector1.hashCode(), is(vector2.hashCode()));
	}
	
	@Test
	public void equalsWithEqualReturnsTrue()
	{
		Vector vector1 = new Vector(1, 2, 3);
		Vector vector2 = new Vector(1, 2, 3);
		
		assertThat(vector1.equals(vector2), is(true));
	}
	
	@Test
	public void equalsWithUnequalXReturnsFalse()
	{
		Vector vector1 = new Vector(1, 2, 3);
		Vector vector2 = new Vector(0, 2, 3);
		
		assertThat(vector1.equals(vector2), is(false));
	}
	
	@Test
	public void equalsWithUnequalYReturnsFalse()
	{
		Vector vector1 = new Vector(1, 2, 3);
		Vector vector2 = new Vector(1, 0, 3);
		
		assertThat(vector1.equals(vector2), is(false));
	}
	
	@Test
	public void equalsWithUnequalZReturnsFalse()
	{
		Vector vector1 = new Vector(1, 2, 3);
		Vector vector2 = new Vector(1, 2, 0);
		
		assertThat(vector1.equals(vector2), is(false));
	}
	
	@Test
	public void equalsWithOtherClassReturnsFalse()
	{
		Vector vector = new Vector();
		Object object = new Object();
		
		assertThat(vector.equals(object), is(false));
	}
	
	@Test
	public void equalsWithNullReturnsFalse()
	{
		Vector vector = new Vector();
		Object object = null;
		
		assertThat(vector.equals(object), is(false));
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
