package org.arquillian.smart.testing.strategies.affected;

import java.io.File;
import org.arquillian.smart.testing.strategies.affected.ast.JavaClass;

public class JavaElement {

    private final String className;
    private final File classFile;


    public JavaElement(String className) {
        this.className = className;
        this.classFile = null;
    }

    /**
     * Constructor for creating a Java element.
     * @param className of the java element.
     * @param classFile location of the java element. Can be null.
     */
    public JavaElement(String className, File classFile) {
        this.className = className;
        this.classFile = classFile;
    }

    public JavaElement(JavaClass javaClass) {
        this.className = javaClass.getName();
        this.classFile = javaClass.getClassFile();
    }

    public File getClassFile() {
        return classFile;
    }

    public String getClassName() {
        return className;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final JavaElement that = (JavaElement) o;

        return className != null ? className.equals(that.className) : that.className == null;
    }

    @Override
    public int hashCode() {
        return className != null ? className.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "JavaElement{" + "className='" + className + '\'' + ", classFile=" + classFile + '}';
    }
}
