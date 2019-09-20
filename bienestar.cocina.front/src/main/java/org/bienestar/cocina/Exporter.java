package org.bienestar.cocina;


//import exporter.types.IExportable;


//import CSV.IExportable;
import exporter.Container;
import exporter.types.IExportable;
//import exporter.types.IExportable;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class Exporter {


    //private static Map<String, IExportable> container;

    //TODO: find class que recorra  paquetes y te creemap de type(csv,xls) con sus type names.
    public void findAll(Container container) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {

        List<Class> clases = getClasses("plugins");

        for (Class clazz : clases) {
            if (IExportable.class.isAssignableFrom(clazz)) {
                container.add(IExportable.class, clazz, clazz.getSimpleName());//descomentar luego
            }
        }
    }

    private List<Class> getClasses(String pack) throws IOException, ClassNotFoundException {

        ArrayList<Class> classes = new ArrayList<>();
        JarFile jf;

        String s = this.getClass().getResource("").getPath().replaceAll("file:", "");
        s = s.substring(0, s.length() - 36);

        for (File file: new File(s + pack).listFiles()
             ) {
            getClassesFromJar(pack, classes, s, file);
        }

        return classes;
    }

    private void getClassesFromJar(String pack, ArrayList<Class> classes, String s, File file) throws IOException, ClassNotFoundException {
        JarFile jf;
        jf = new JarFile(file.getPath());

        URL[] urls = {new URL("jar:file:" + s + "!/")};
        URLClassLoader cl = URLClassLoader.newInstance(urls);

        Enumeration<JarEntry> entries = jf.entries();
        while (entries.hasMoreElements()) {
            JarEntry je = entries.nextElement();
            if (je.getName().endsWith(".class")) {
                String className = je.getName().substring(0, je.getName().length() - 6);
                className = className.replace('/', '.');
                Class c = cl.loadClass(className);//da Java.lang.ClassNot FoundException: CSV.CSVExportable.
                classes.add(c);
            }
        }
        if (jf != null)
            jf.close();
    }


}




