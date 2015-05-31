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

/**
 * Defines a scene object that can be ray traced.
 */
public interface Traceable
{
	// ----------------------------------------------------------------------------------------------------------------
	// public methods
	// ----------------------------------------------------------------------------------------------------------------

	/**
	 * Calculates the intersection of the specified ray with this object.
	 * <p>
	 * The ray is specified by the line <b>p</b> = <b>u</b> + <b>v</b><i>t</i>.
	 * 
	 * @param u
	 *            the vector <b>u</b> of the ray
	 * @param v
	 *            the vector <b>v</b> of the ray
	 * @return the value of scalar <i>t</i> where 0 <= <i>t</i> <= 1 if the specified ray intersects with this object,
	 *         or {@code Double.NaN} if the specified ray does not intersect with this object
	 */
	double getIntersection(Vector u, Vector v);
	
	Vector getNormal(Vector p, Vector n);
	
	Material getMaterial();
}
