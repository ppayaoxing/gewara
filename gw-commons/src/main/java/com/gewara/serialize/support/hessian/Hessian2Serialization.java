
package com.gewara.serialize.support.hessian;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.gewara.serialize.ObjectInput;
import com.gewara.serialize.ObjectOutput;
import com.gewara.serialize.Serialization;

/**
 * @author ding.lid
 */
public class Hessian2Serialization implements Serialization {
    /**
     */
    public static final byte ID = 2;

    @Override
    public byte getContentTypeId() {
        return ID;
    }

    @Override
    public String getContentType() {
        return "x-application/hessian2";
    }

    /**
     */
    @Override
    public ObjectOutput serialize(OutputStream out) throws IOException {
        return new Hessian2ObjectOutput(out);
    }

    /**
     */
    @Override
    public ObjectInput deserialize(InputStream is) throws IOException {
        return new Hessian2ObjectInput(is);
    }

}