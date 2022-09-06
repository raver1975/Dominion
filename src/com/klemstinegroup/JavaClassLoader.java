package com.klemstinegroup;

public class JavaClassLoader extends ClassLoader {

    private final byte[] data;

    public JavaClassLoader(byte[] data) {
        this.data = data;
    }

    @Override
    protected Class<?> findClass(final String name) throws ClassNotFoundException {
        return defineClass(name, data, 0, data.length);
//        return super.findClass(name);
    }
}