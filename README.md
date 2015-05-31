# Ray

Real-time ray tracing in Java.

## Running the demo

To build and run the demo using Maven:

	mvn install
	mvn -pl demo exec:java
	
Alternatively build and run the jar:

	mvn install
	java -jar demo/target/ray-demo-0.1.0-SNAPSHOT.jar

When running press `F12` to toggle the rendering statistics. The window can also be resized to change the resolution.

## Further reading

* [Practical Ray Tracing](http://www.itu.dk/courses/IM/Projects/Raytracer/RayNotes.pdf)
* [Reflections and Refractions in Ray Tracing](http://www.flipcode.com/archives/reflection_transmission.pdf)
